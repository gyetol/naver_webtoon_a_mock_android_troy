package com.softsquared.naverwebtoon.src.watch;

import com.softsquared.naverwebtoon.src.watch.interfaces.WatchActivityView;
import com.softsquared.naverwebtoon.src.watch.interfaces.WatchRetrofitInterface;
import com.softsquared.naverwebtoon.src.watch.models.WatchResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.naverwebtoon.src.ApplicationClass.getRetrofit;

public class WatchService {
    private final WatchActivityView mWatchActivityView;
    private final int idx;

    public WatchService(WatchActivityView mWatchActivityView, int idx) {
        this.mWatchActivityView = mWatchActivityView;
        this.idx = idx;
    }

    public void getWatch(){
        final WatchRetrofitInterface watchRetrofitInterface = getRetrofit().create(WatchRetrofitInterface.class);
        watchRetrofitInterface.getWatch(idx, 1, 14).enqueue(new Callback<WatchResponse>() {
            @Override
            public void onResponse(Call<WatchResponse> call, Response<WatchResponse> response) {
                final WatchResponse watchResponse = response.body();
                if(watchResponse==null){
                    mWatchActivityView.validateFailure(null);
                    return;
                }
                mWatchActivityView.validateSuccess(response.body().getResult());
            }

            @Override
            public void onFailure(Call<WatchResponse> call, Throwable t) {
                mWatchActivityView.validateFailure(null);
            }
        });
    }
}
