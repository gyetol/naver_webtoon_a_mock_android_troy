package com.softsquared.naverwebtoon.src.main.fragmentwebtoon.fragmentthursday;

import com.softsquared.naverwebtoon.src.main.interfaces.MainActivityView;
import com.softsquared.naverwebtoon.src.main.interfaces.MainRetrofitInterface;
import com.softsquared.naverwebtoon.src.main.models.WebtoonResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.naverwebtoon.src.ApplicationClass.getRetrofit;

public class ThursdayService {
    private final MainActivityView mMainActivityView;

    public ThursdayService(final MainActivityView mainActivityView){
        this.mMainActivityView = mainActivityView;
    }

    public void getWebtoonList(){
        final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
        mainRetrofitInterface.getWebtoonList("목","인기순").enqueue(new Callback<WebtoonResponse>() {
            @Override
            public void onResponse(Call<WebtoonResponse> call, Response<WebtoonResponse> response) {
                final WebtoonResponse webtoonResponse = response.body();
                if(webtoonResponse == null){
                    mMainActivityView.validateFailure(null);
                    return;
                }
                mMainActivityView.validateSuccess(response.body().getResult());
                return;
            }

            @Override
            public void onFailure(Call<WebtoonResponse> call, Throwable t) {
                mMainActivityView.validateFailure(null);
            }
        });
    }
}
