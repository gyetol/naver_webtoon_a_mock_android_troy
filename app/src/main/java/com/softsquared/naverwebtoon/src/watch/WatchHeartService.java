package com.softsquared.naverwebtoon.src.watch;

import com.softsquared.naverwebtoon.src.watch.interfaces.WatchActivityView;
import com.softsquared.naverwebtoon.src.watch.interfaces.WatchRetrofitInterface;
import com.softsquared.naverwebtoon.src.watch.models.WatchHeartResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.naverwebtoon.src.ApplicationClass.getRetrofit;

public class WatchHeartService {
    private final WatchActivityView mWatchActivityView;
    private final int idx;

    public WatchHeartService(WatchActivityView mWatchActivityView, int idx) {
        this.mWatchActivityView = mWatchActivityView;
        this.idx = idx;
    }

    public void pushHeart(){
        final WatchRetrofitInterface watchRetrofitInterface = getRetrofit().create(WatchRetrofitInterface.class);
        watchRetrofitInterface.pushHeart(idx).enqueue(new Callback<WatchHeartResponse>() {
            @Override
            public void onResponse(Call<WatchHeartResponse> call, Response<WatchHeartResponse> response) {
                final WatchHeartResponse watchHeartResponse = response.body();
                if(watchHeartResponse == null){
                    mWatchActivityView.validateFailure(null);
                    return;
                }
                mWatchActivityView.validateSuccessHeart(response.body());
            }

            @Override
            public void onFailure(Call<WatchHeartResponse> call, Throwable t) {
                mWatchActivityView.validateFailure(null);
            }
        });
    }
}
