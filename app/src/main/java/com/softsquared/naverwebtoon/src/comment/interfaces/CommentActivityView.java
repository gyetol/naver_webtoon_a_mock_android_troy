package com.softsquared.naverwebtoon.src.comment.interfaces;

import com.softsquared.naverwebtoon.src.comment.models.CommentAddResponse;
import com.softsquared.naverwebtoon.src.comment.models.CommentLikeResponse;
import com.softsquared.naverwebtoon.src.comment.models.CommentResult;

import java.util.List;

public interface CommentActivityView {
    void validateSuccess(List<CommentResult> commentResults);

    void validateSuccessLike(CommentLikeResponse commentLikeResponse);

    void validateSuccessAdd(CommentAddResponse commentAddResponse);

    void validateFailure(String message);
}
