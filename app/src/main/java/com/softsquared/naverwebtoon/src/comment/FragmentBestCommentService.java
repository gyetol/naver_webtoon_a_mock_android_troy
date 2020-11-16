package com.softsquared.naverwebtoon.src.comment;


import com.softsquared.naverwebtoon.src.comment.interfaces.CommentActivityView;
import com.softsquared.naverwebtoon.src.comment.interfaces.CommentRetrofitInterface;
import com.softsquared.naverwebtoon.src.comment.models.CommentResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.naverwebtoon.src.ApplicationClass.getRetrofit;


public class FragmentBestCommentService {
    private final CommentActivityView mCommentActivityView;
    private final int idx;

    public FragmentBestCommentService(CommentActivityView mCommentActivityView, int idx) {
        this.mCommentActivityView = mCommentActivityView;
        this.idx = idx;
    }

    public void getCommentList(){
        final CommentRetrofitInterface commentRetrofitInterface = getRetrofit().create(CommentRetrofitInterface.class);
        commentRetrofitInterface.getComment(idx,"베스트").enqueue(new Callback<CommentResponse>() {
            @Override
            public void onResponse(Call<CommentResponse> call, Response<CommentResponse> response) {
                final CommentResponse commentResponse = response.body();
                if(commentResponse == null){
                    mCommentActivityView.validateFailure(null);
                    return;
                }
                mCommentActivityView.validateSuccess(response.body().getResult());
                return;
            }

            @Override
            public void onFailure(Call<CommentResponse> call, Throwable t) {
                mCommentActivityView.validateFailure(null);
            }
        });
    }
}