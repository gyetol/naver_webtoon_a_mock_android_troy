package com.softsquared.naverwebtoon.src.comment;

import com.softsquared.naverwebtoon.src.comment.interfaces.CommentActivityView;
import com.softsquared.naverwebtoon.src.comment.interfaces.CommentRetrofitInterface;
import com.softsquared.naverwebtoon.src.comment.models.CommentLikeResponse;
import com.softsquared.naverwebtoon.src.comment.models.RequestCommentState;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.naverwebtoon.src.ApplicationClass.getRetrofit;

public class CommentLikeService {
    private final CommentActivityView mCommentActivityView;
    private final int idx;
    private final RequestCommentState requestCommentState;

    public CommentLikeService(CommentActivityView mCommentActivityView, int idx, RequestCommentState requestCommentState) {
        this.mCommentActivityView = mCommentActivityView;
        this.idx = idx;
        this.requestCommentState = requestCommentState;
    }

    public void pushLikeOrDislike(){
        final CommentRetrofitInterface commentRetrofitInterface = getRetrofit().create(CommentRetrofitInterface.class);
        commentRetrofitInterface.getCommentLike(idx,requestCommentState).enqueue(new Callback<CommentLikeResponse>() {
            @Override
            public void onResponse(Call<CommentLikeResponse> call, Response<CommentLikeResponse> response) {
                final CommentLikeResponse commentLikeResponse = response.body();
                if(commentLikeResponse == null){
                    mCommentActivityView.validateFailure(null);
                    return;
                }
                mCommentActivityView.validateSuccessLike(response.body());
                return;
            }

            @Override
            public void onFailure(Call<CommentLikeResponse> call, Throwable t) {
                mCommentActivityView.validateFailure(null);
            }
        });
    }
}
