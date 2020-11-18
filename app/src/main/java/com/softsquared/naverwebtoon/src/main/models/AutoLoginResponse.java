package com.softsquared.naverwebtoon.src.main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AutoLoginResponse {

    @SerializedName("result")
    @Expose
    private AutoLoginResult result;
    @SerializedName("is_success")
    @Expose
    private Boolean isSuccess;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;

    public AutoLoginResult getResult() {
        return result;
    }

    public void setResult(AutoLoginResult result) {
        this.result = result;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}