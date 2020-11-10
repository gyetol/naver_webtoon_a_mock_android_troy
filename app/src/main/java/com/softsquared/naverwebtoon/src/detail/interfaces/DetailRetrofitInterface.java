/*
package com.softsquared.naverwebtoon.src.detail.interfaces;

import com.softsquared.naverwebtoon.src.detail.models.DetailEpisodeListResponse;
import com.softsquared.naverwebtoon.src.detail.models.DetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DetailRetrofitInterface {
    @GET("/webtoons/{webtoonIdx}")
    Call<DetailResponse> getDetail(
      @Path("webtoonIdx")  int webtoonIdx
    );

    @GET("webtoons/{webtoonIdx}/episodes")
    Call<DetailEpisodeListResponse> getDetailEpisodeList(
            @Path("webtoonIdx")  int webtoonIdx
    );
}
*/
