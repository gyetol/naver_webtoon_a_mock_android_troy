/*
package com.softsquared.naverwebtoon.src.detail;

import com.softsquared.naverwebtoon.src.detail.interfaces.DetailActivityView;
import com.softsquared.naverwebtoon.src.detail.interfaces.DetailRetrofitInterface;
import com.softsquared.naverwebtoon.src.detail.models.DetailEpisodeListResponse;
import com.softsquared.naverwebtoon.src.detail.models.DetailResponse;
import com.softsquared.naverwebtoon.src.detail.models.DetailResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.naverwebtoon.src.ApplicationClass.getRetrofit;

public class DetailService {
    private final DetailActivityView mDetailActivityView;
    private final int idx;

    public DetailService(DetailActivityView mDetailActivityView, int idx) {
        this.mDetailActivityView = mDetailActivityView;
        this.idx = idx;
    }

    public void getDetail(){
        final DetailRetrofitInterface detailRetrofitInterface = getRetrofit().create(DetailRetrofitInterface.class);
        detailRetrofitInterface.getDetail(idx).enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                final DetailResponse detailResponse = response.body();
                if(detailResponse == null){
                    mDetailActivityView.validateFailure(null);
                    return;
                }
                mDetailActivityView.validateSuccess(response.body().getResult());
            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                mDetailActivityView.validateFailure(null);
            }
        });
    }
}
*/
