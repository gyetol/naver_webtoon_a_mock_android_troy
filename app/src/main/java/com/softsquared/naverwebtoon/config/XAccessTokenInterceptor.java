package com.softsquared.naverwebtoon.config;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.softsquared.naverwebtoon.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.naverwebtoon.src.ApplicationClass.sSharedPreferences;

public class XAccessTokenInterceptor implements Interceptor {

    @Override
    @NonNull
    public Response intercept(@NonNull final Interceptor.Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
//        final String jwtToken = sSharedPreferences.getString(X_ACCESS_TOKEN, null);
//        String jwtToken ="dd";
//        if (jwtToken != null) {
//            builder.addHeader("X-ACCESS-TOKEN", jwtToken);
//        }

        return chain.proceed(builder.build());
    }
}
