package com.softsquared.naverwebtoon.src.main;

import android.util.Log;

import com.softsquared.naverwebtoon.src.main.interfaces.AutoLoginView;
import com.softsquared.naverwebtoon.src.main.interfaces.MainRetrofitInterface;
import com.softsquared.naverwebtoon.src.main.models.AutoLoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.naverwebtoon.src.ApplicationClass.getRetrofit;

public class AutoLoginService{
    private final AutoLoginView mAutoLoginView;

    public AutoLoginService(AutoLoginView mAutoLoginView) {
        this.mAutoLoginView = mAutoLoginView;
    }

    public void getAutoLoginResponse(){
        final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
        mainRetrofitInterface.getAutoLoginResponse().enqueue(new Callback<AutoLoginResponse>() {
            @Override
            public void onResponse(Call<AutoLoginResponse> call, Response<AutoLoginResponse> response) {
                final AutoLoginResponse autoLoginResponse = response.body();
                if(autoLoginResponse == null){
                    mAutoLoginView.validateFailure(null);
                    return;
                }
                Log.d("autologin",response.body().getIsSuccess()+"");
                mAutoLoginView.validateSuccess(response.body());
                return;
            }

            @Override
            public void onFailure(Call<AutoLoginResponse> call, Throwable t) {
                mAutoLoginView.validateFailure(null);
            }
        });
    }
}