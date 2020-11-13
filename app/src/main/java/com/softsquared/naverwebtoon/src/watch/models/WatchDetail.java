package com.softsquared.naverwebtoon.src.watch.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WatchDetail {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("comment_count")
    @Expose
    private Integer commentCount;
    @SerializedName("heart_count")
    @Expose
    private Integer heartCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getHeartCount() {
        return heartCount;
    }

    public void setHeartCount(Integer heartCount) {
        this.heartCount = heartCount;
    }

}