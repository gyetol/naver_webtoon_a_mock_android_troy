package com.softsquared.naverwebtoon.src.main.fragmentmore.interfaces;

import com.softsquared.naverwebtoon.src.main.fragmentdetail.models.DetailResponse;
import com.softsquared.naverwebtoon.src.main.fragmentmore.models.MoreResponse;
import com.softsquared.naverwebtoon.src.main.models.TopBannerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoreFragmentRetrofitInterface {
    @GET("/more")
    Call<MoreResponse> getMore();
}
