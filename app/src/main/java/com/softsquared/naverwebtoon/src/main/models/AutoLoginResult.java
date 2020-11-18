package com.softsquared.naverwebtoon.src.main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AutoLoginResult {

    @SerializedName("jwt")
    @Expose
    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

}