package com.courtney.news;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    List<News> news;

    public NewsAdapter(List<News> news) {
        this.news = news;
    }

    public void setWords(List<News> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News n = news.get(position);
        if (n != null) {
            holder.bindTo(n);
        }
    }

    @Override
    public int getItemCount() {
        return (news == null) ? 0 : news.size();
    }
}
