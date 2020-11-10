package com.softsquared.naverwebtoon.src.main.fragmentdetail.interfaces;



import com.softsquared.naverwebtoon.src.main.fragmentdetail.models.DetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DetailFragmentRetrofitInterface {
    @GET("/webtoons/{webtoonIdx}/episodes")
    Call<DetailResponse> getDetail(
            @Path("webtoonIdx")  int webtoonIdx
    );


}
