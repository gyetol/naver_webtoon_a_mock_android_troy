package com.softsquared.naverwebtoon.src.comment.interfaces;

import com.softsquared.naverwebtoon.src.comment.models.CommentResult;

import java.util.List;

public interface CommentActivityView {
    void validateSuccess(List<CommentResult> commentResults);

    void validateFailure(String message);
}
