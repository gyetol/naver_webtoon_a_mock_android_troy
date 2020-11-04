package com.softsquared.naverwebtoon.src.main.models;

public class WebtoonResponse {

     String name;
     String photo;
     String summary;

    public WebtoonResponse(String name, String photo, String summary) {
        this.name = name;
        this.photo = photo;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public String getSummary() {
        return summary;
    }
}
