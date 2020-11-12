package com.softsquared.naverwebtoon.src.main.fragmentdetail.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailEpisodeList {

    @SerializedName("idx")
    @Expose
    private Integer idx;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("form")
    @Expose
    private String form;
    @SerializedName("starscore")
    @Expose
    private Double starscore;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("look")
    @Expose
    private String look;

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Double getStarscore() {
        return starscore;
    }

    public void setStarscore(Double starscore) {
        this.starscore = starscore;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

}
