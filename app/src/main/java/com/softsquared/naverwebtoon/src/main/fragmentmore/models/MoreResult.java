package com.softsquared.naverwebtoon.src.main.fragmentmore.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoreResult {

    @SerializedName("nick")
    @Expose
    private String nick;
    @SerializedName("cookie_count")
    @Expose
    private Integer cookieCount;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getCookieCount() {
        return cookieCount;
    }

    public void setCookieCount(Integer cookieCount) {
        this.cookieCount = cookieCount;
    }

}