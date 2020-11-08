package com.softsquared.naverwebtoon.src.main.fragmentwebtoon;


import com.softsquared.naverwebtoon.src.main.interfaces.MainActivityView;
import com.softsquared.naverwebtoon.src.main.interfaces.MainRetrofitInterface;
import com.softsquared.naverwebtoon.src.main.interfaces.TopBannerView;
import com.softsquared.naverwebtoon.src.main.models.TopBannerResponse;
import com.softsquared.naverwebtoon.src.main.models.WebtoonResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.naverwebtoon.src.ApplicationClass.getRetrofit;

public class TopBannerService {
    private final TopBannerView mTopBannerView;

    public TopBannerService(TopBannerView mTopBannerView) {
        this.mTopBannerView = mTopBannerView;
    }

    public void getTopBannerList(){
        final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
        mainRetrofitInterface.getTopBannerList(6).enqueue(new Callback<TopBannerResponse>() {
            @Override
            public void onResponse(Call<TopBannerResponse> call, Response<TopBannerResponse> response) {
                final TopBannerResponse topBannerResponse = response.body();
                if(topBannerResponse == null){
                    mTopBannerView.validateFailure(null);
                    return;
                }
                mTopBannerView.validateSuccess(response.body().getTopBannerResults());
                return;
            }

            @Override
            public void onFailure(Call<TopBannerResponse> call, Throwable t) {
                mTopBannerView.validateFailure(null);
            }
        });
    }
}
