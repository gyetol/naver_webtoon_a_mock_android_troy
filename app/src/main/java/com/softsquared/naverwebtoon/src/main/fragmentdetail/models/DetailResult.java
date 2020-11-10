package com.softsquared.naverwebtoon.src.main.fragmentdetail.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailResult {

    @SerializedName("detail")
    @Expose
    private Details detail;
    @SerializedName("Episodelist")
    @Expose
    private List<DetailEpisodeList> episodelist = null;

    public Details getDetail() {
        return detail;
    }

    public void setDetail(Details detail) {
        this.detail = detail;
    }

    public List<DetailEpisodeList> getEpisodelist() {
        return episodelist;
    }

    public void setEpisodelist(List<DetailEpisodeList> episodelist) {
        this.episodelist = episodelist;
    }

}