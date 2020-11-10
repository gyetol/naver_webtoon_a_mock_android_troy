package com.softsquared.naverwebtoon.src.user.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfileResponse {

    @SerializedName("resultcode")
    @Expose
    private String resultcode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("response")
    @Expose
    private UserProfileResult response;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserProfileResult getResponse() {
        return response;
    }

    public void setResponse(UserProfileResult response) {
        this.response = response;
    }

}