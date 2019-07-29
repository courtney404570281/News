package com.courtney.news;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Database(entities = News.class, version = 1)
public abstract class NewsDatabase extends RoomDatabase {
    public abstract NewsDao newsDao();
    public static NewsDatabase instance = null;

    public static NewsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, NewsDatabase.class, "news-database")
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                        }
                    })
                    .build();
            fillDataFromJson(instance.newsDao(), context);
        }
        return instance;
    }

    private static void fillDataFromJson(NewsDao newsDao, Context context) {
        InputStream is = context.getResources().openRawResource(R.raw.news);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            JSONObject json = new JSONObject(builder.toString());
            JSONArray news = json.getJSONArray("articles");
            for (int i = 0; i < news.length() ; i++) {
                JSONObject o = news.getJSONObject(i);
                News n = new News(o.getString("urlToImage"),
                        o.getString("title"));
                new Thread(() -> newsDao.insert(n)).start();

            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }


    }
}
