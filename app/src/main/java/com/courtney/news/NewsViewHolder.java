package com.courtney.news;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    TextView titleText;
    ImageView ImgUrl;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        titleText = itemView.findViewById(R.id.txt_title);
        ImgUrl = itemView.findViewById(R.id.img_news);
    }

    public void bindTo(News news) {
        titleText.setText(news.title);
        Glide.with(itemView.getContext())
                .load(news.imgUrl)
                .override(200)
                .into(ImgUrl);
    }
}
