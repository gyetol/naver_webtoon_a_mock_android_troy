package com.softsquared.naverwebtoon.src.comment.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommentResult {

    @SerializedName("nick")
    @Expose
    private String nick;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("contents")
    @Expose
    private String contents;
    @SerializedName("like_count")
    @Expose
    private Integer likeCount;
    @SerializedName("dislike_count")
    @Expose
    private Integer dislikeCount;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(Integer dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

}