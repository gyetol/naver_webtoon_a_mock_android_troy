package com.softsquared.naverwebtoon.src.main.interfaces;

import com.softsquared.naverwebtoon.src.main.models.TopBannerResponse;
import com.softsquared.naverwebtoon.src.main.models.WebtoonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainRetrofitInterface {
    @GET("/mainpage")
    Call<WebtoonResponse>getWebtoonList(@Query("keyword") String keyword);

    @GET("/banner")
    Call<TopBannerResponse>getTopBannerList(@Query("size") int size);
}
