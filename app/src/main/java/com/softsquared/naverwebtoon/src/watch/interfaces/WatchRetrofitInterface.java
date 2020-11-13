package com.softsquared.naverwebtoon.src.watch.interfaces;

import com.softsquared.naverwebtoon.src.watch.models.WatchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WatchRetrofitInterface {
    @GET("/episodes/{episodeIdx}")
    Call<WatchResponse> getWatch(
            @Path("episodeIdx") int episodeIdx,
            @Query("page") final int page,
            @Query("size") final int size
    );
}
