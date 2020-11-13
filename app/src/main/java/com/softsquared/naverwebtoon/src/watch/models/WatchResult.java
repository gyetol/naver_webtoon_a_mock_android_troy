package com.softsquared.naverwebtoon.src.watch.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WatchResult {

    @SerializedName("episode")
    @Expose
    private List<WatchEpisode> episode = null;
    @SerializedName("detail")
    @Expose
    private WatchDetail detail;

    public List<WatchEpisode> getEpisode() {
        return episode;
    }

    public void setEpisode(List<WatchEpisode> episode) {
        this.episode = episode;
    }

    public WatchDetail getDetail() {
        return detail;
    }

    public void setDetail(WatchDetail detail) {
        this.detail = detail;
    }

}