package com.softsquared.naverwebtoon.src.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.main.fragmentmore.FragmentMore;
import com.softsquared.naverwebtoon.src.main.interfaces.AutoLoginView;
import com.softsquared.naverwebtoon.src.main.models.AutoLoginResponse;
import com.softsquared.naverwebtoon.src.main.models.AutoLoginResult;

public class LoadingActivity extends AppCompatActivity implements AutoLoginView {
    boolean isLogin;
    FragmentMore fragmentMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding);
        View view = getWindow().getDecorView();
        if(view != null){
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(Color.parseColor("#00D463"));
            getWindow().setNavigationBarColor(Color.parseColor("#00D463"));
        }
        tryGetAutoLogin();
        startLoading();
    }

    private void startLoading(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 4000);
    }

    public void tryGetAutoLogin(){
        final AutoLoginService autoLoginService = new AutoLoginService(this);
        autoLoginService.getAutoLoginResponse();
    }

    @Override
    public void validateSuccess(AutoLoginResponse autoLoginResponse) {

        if(autoLoginResponse.getIsSuccess()) {
            Log.d("autologin", autoLoginResponse.getResult().getJwt());
            Toast.makeText(getApplicationContext(),"자동로그인 성공",Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
        }
        else{
            Toast.makeText(getApplicationContext(),"자동로그인되지 않았습니다",Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED);
        }


    }

    @Override
    public void validateFailure(String message) {

    }
}