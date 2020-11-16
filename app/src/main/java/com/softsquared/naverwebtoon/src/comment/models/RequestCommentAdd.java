package com.softsquared.naverwebtoon.src.comment.models;

public class RequestCommentAdd {
    private String contents;

    public RequestCommentAdd(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
