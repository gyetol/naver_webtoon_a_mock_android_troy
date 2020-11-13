package com.softsquared.naverwebtoon.src.watch.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WatchEpisode {

    @SerializedName("idx")
    @Expose
    private Integer idx;
    @SerializedName("contents")
    @Expose
    private String contents;

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

}