/*
package com.softsquared.naverwebtoon.src.detail;

import com.softsquared.naverwebtoon.src.detail.interfaces.DetailActivityView;
import com.softsquared.naverwebtoon.src.detail.interfaces.DetailRetrofitInterface;
import com.softsquared.naverwebtoon.src.detail.models.DetailEpisodeListResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.naverwebtoon.src.ApplicationClass.getRetrofit;

public class DetailEpisodeListService {
    private final DetailActivityView mDetailActivityView;
    private final int idx;

    public DetailEpisodeListService(DetailActivityView mDetailActivityView, int idx) {
        this.mDetailActivityView = mDetailActivityView;
        this.idx = idx;
    }

    public void getEpisodeList(){
        final DetailRetrofitInterface detailRetrofitInterface = getRetrofit().create(DetailRetrofitInterface.class);
        detailRetrofitInterface.getDetailEpisodeList(1).enqueue(new Callback<DetailEpisodeListResponse>() {
            @Override
            public void onResponse(Call<DetailEpisodeListResponse> call, Response<DetailEpisodeListResponse> response) {
                final DetailEpisodeListResponse detailEpisodeListResponse = response.body();
                if(detailEpisodeListResponse == null){
                    mDetailActivityView.validateFailure(null);
                    return;
                }
                mDetailActivityView.validateSuccessList(response.body().getResult());
            }

            @Override
            public void onFailure(Call<DetailEpisodeListResponse> call, Throwable t) {
                mDetailActivityView.validateFailure(null);
            }
        });
    }
}
*/
