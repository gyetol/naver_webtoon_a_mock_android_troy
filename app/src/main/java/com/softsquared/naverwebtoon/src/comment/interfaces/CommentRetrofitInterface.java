package com.softsquared.naverwebtoon.src.comment.interfaces;

import com.softsquared.naverwebtoon.src.comment.models.CommentResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CommentRetrofitInterface {
    @GET("/episodes/{episodeIdx}/comments")
    Call<CommentResponse> getComment(
            @Path("episodeIdx") int episodeIdx,
            @Query("keyword") final String keyword
    );
}
