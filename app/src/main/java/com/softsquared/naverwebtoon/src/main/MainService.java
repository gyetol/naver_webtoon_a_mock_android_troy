package com.softsquared.naverwebtoon.src.main;

import android.util.Log;

import com.softsquared.naverwebtoon.src.main.interfaces.MainActivityView;
import com.softsquared.naverwebtoon.src.main.interfaces.MainRetrofitInterface;
import com.softsquared.naverwebtoon.src.main.models.WebtoonResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.naverwebtoon.src.ApplicationClass.getRetrofit;

public class MainService {
    private final MainActivityView mMainActivityView;

    MainService(final MainActivityView mainActivityView){
        this.mMainActivityView = mainActivityView;
    }

    void getWebtoonList(){
        Log.d("haha","서비스호출");
        final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
        Log.d("haha","서비스호출1");
        mainRetrofitInterface.getWebtoonList("월").enqueue(new Callback<WebtoonResponse>() {
            @Override
            public void onResponse(Call<WebtoonResponse> call, Response<WebtoonResponse> response) {
                Log.d("haha","서비스호출2");
                final WebtoonResponse webtoonResponse = response.body();
                if(webtoonResponse == null){
                    mMainActivityView.validateFailure(null);
                    return;
                }
                Log.d("haha","야호1");

                    mMainActivityView.validateSuccess(response.body().getResult());

                return;
            }

            @Override
            public void onFailure(Call<WebtoonResponse> call, Throwable t) {
                Log.d("haha","야호호");
                mMainActivityView.validateFailure(null);
            }
        });
    }
}
