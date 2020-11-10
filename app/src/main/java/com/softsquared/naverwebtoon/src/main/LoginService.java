package com.softsquared.naverwebtoon.src.main;

import com.softsquared.naverwebtoon.src.main.interfaces.LoginView;
import com.softsquared.naverwebtoon.src.main.interfaces.MainActivityView;
import com.softsquared.naverwebtoon.src.main.interfaces.MainRetrofitInterface;
import com.softsquared.naverwebtoon.src.main.models.LoginResponse;
import com.softsquared.naverwebtoon.src.main.models.WebtoonResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.naverwebtoon.src.ApplicationClass.getRetrofit;

public class LoginService {
    private final LoginView mLoginView;
    private final String mAccessToken;

    public LoginService(LoginView mLoginView, String mAccessToken) {
        this.mLoginView = mLoginView;
        this.mAccessToken = mAccessToken;
    }

    public void getLoginResponse(){
        final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
        mainRetrofitInterface.getLoginResponse(mAccessToken).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                final LoginResponse loginResponse = response.body();
                if(loginResponse == null){
                    mLoginView.validateFailure(null);
                    return;
                }
                mLoginView.validateSuccess(response.body().getResult());
                return;
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                mLoginView.validateFailure(null);
            }
        });
    }
}
