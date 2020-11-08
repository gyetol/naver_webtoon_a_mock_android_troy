package com.softsquared.naverwebtoon.src.main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopBannerResult {

    @SerializedName("banner_photo")
    @Expose
    private String bannerPhoto;
    @SerializedName("webtoon_idx")
    @Expose
    private Integer webtoonIdx;
    @SerializedName("episode_idx")
    @Expose
    private Integer episodeIdx;

    public String getBannerPhoto() {
        return bannerPhoto;
    }

    public void setBannerPhoto(String bannerPhoto) {
        this.bannerPhoto = bannerPhoto;
    }

    public Integer getWebtoonIdx() {
        return webtoonIdx;
    }

    public void setWebtoonIdx(Integer webtoonIdx) {
        this.webtoonIdx = webtoonIdx;
    }

    public Integer getEpisodeIdx() {
        return episodeIdx;
    }

    public void setEpisodeIdx(Integer episodeIdx) {
        this.episodeIdx = episodeIdx;
    }

}