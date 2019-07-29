package com.courtney.news;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NewsDao {
    @Query("SELECT * FROM news")
    List<News> getNews();

    @Insert
    void insert(News news);

    @Delete
    void delete(News news);
}
