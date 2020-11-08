package com.softsquared.naverwebtoon.src.main.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopBannerResponse {

    @SerializedName("result")
    @Expose
    private List<TopBannerResult> topBannerResults = null;
    @SerializedName("is_success")
    @Expose
    private Boolean isSuccess;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;

    public List<TopBannerResult> getTopBannerResults() {
        return topBannerResults;
    }

    public void setTopBannerResults(List<TopBannerResult> topBannerResults) {
        this.topBannerResults = topBannerResults;
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