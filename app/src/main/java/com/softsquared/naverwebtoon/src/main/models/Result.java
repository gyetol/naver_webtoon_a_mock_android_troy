package com.softsquared.naverwebtoon.src.main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("idx")
    @Expose
    private Integer idx;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("starscore")
    @Expose
    private Double starscore;
    @SerializedName("UP")
    @Expose
    private String uP;
    @SerializedName("form")
    @Expose
    private String form;
    @SerializedName("rest")
    @Expose
    private String rest;

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Double getStarscore() {
        return starscore;
    }

    public void setStarscore(Double starscore) {
        this.starscore = starscore;
    }

    public String getUP() {
        return uP;
    }

    public void setUP(String uP) {
        this.uP = uP;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getRest() {
        return rest;
    }

    public void setRest(String rest) {
        this.rest = rest;
    }

}