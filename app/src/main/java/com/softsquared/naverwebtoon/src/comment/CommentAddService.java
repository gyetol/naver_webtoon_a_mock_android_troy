package com.softsquared.naverwebtoon.src.comment;

import com.softsquared.naverwebtoon.src.comment.interfaces.CommentActivityView;
import com.softsquared.naverwebtoon.src.comment.interfaces.CommentRetrofitInterface;
import com.softsquared.naverwebtoon.src.comment.models.CommentAddResponse;
import com.softsquared.naverwebtoon.src.comment.models.RequestCommentAdd;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.naverwebtoon.src.ApplicationClass.getRetrofit;

public class CommentAddService {
    private final CommentActivityView mCommentActivityView;
    private final int idx;
    private final RequestCommentAdd requestCommentAdd;

    public CommentAddService(CommentActivityView mCommentActivityView, int idx, RequestCommentAdd requestCommentAdd) {
        this.mCommentActivityView = mCommentActivityView;
        this.idx = idx;
        this.requestCommentAdd = requestCommentAdd;
    }

    public void AddComment(){
        final CommentRetrofitInterface commentRetrofitInterface = getRetrofit().create(CommentRetrofitInterface.class);
        commentRetrofitInterface.getCommentAdd(idx, requestCommentAdd).enqueue(new Callback<CommentAddResponse>() {
            @Override
            public void onResponse(Call<CommentAddResponse> call, Response<CommentAddResponse> response) {
                final CommentAddResponse commentAddResponse = response.body();
                if(commentAddResponse == null){
                    mCommentActivityView.validateFailure(null);
                    return;
                }
                mCommentActivityView.validateSuccessAdd(response.body());
                return;
            }

            @Override
            public void onFailure(Call<CommentAddResponse> call, Throwable t) {
                mCommentActivityView.validateFailure(null);
            }
        });
    }
}
