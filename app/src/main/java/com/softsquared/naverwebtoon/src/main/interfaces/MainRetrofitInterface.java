package com.softsquared.naverwebtoon.src.main.interfaces;

import com.softsquared.naverwebtoon.src.main.models.LoginResponse;
import com.softsquared.naverwebtoon.src.main.models.TopBannerResponse;
import com.softsquared.naverwebtoon.src.main.models.WebtoonResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MainRetrofitInterface {
    @GET("/mainpage")
    Call<WebtoonResponse>getWebtoonList(
            @Query("keyword") String keyword,
            @Query("order") String order
    );

    @GET("/banner")
    Call<TopBannerResponse>getTopBannerList(@Query("size") int size);

    @POST("/login")
    Call<LoginResponse> getLoginResponse(@Body String params);
}
