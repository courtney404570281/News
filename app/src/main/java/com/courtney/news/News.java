package com.courtney.news;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class News {

    @Nullable
    String imgUrl;
    @PrimaryKey
    @NonNull
    String title;

    public News(@Nullable String imgUrl, @NonNull String title) {
        this.imgUrl = imgUrl;
        this.title = title;
    }

    @Nullable
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(@Nullable String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }
}
