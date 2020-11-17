package com.softsquared.naverwebtoon.src.comment.models;

public class RequestCommentState {
    private String state;

    public RequestCommentState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
