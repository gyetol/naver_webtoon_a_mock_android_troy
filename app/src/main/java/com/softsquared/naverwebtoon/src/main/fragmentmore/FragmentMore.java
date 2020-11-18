package com.softsquared.naverwebtoon.src.main.fragmentmore;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.gson.JsonObject;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.data.OAuthLoginPreferenceManager;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;
import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.ApplicationClass;
import com.softsquared.naverwebtoon.src.main.JWTUtils;
import com.softsquared.naverwebtoon.src.main.LoginService;
import com.softsquared.naverwebtoon.src.main.MainActivity;
import com.softsquared.naverwebtoon.src.main.fragmentmore.interfaces.MoreFragmentView;
import com.softsquared.naverwebtoon.src.main.fragmentmore.models.MoreResult;
import com.softsquared.naverwebtoon.src.main.fragmentwebtoon.fragmentmonday.MondayService;
import com.softsquared.naverwebtoon.src.main.interfaces.LoginView;
import com.softsquared.naverwebtoon.src.main.models.LoginResult;
import com.softsquared.naverwebtoon.src.user.ApiUserProfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import android.content.SharedPreferences;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;


public class FragmentMore extends Fragment implements LoginView, MoreFragmentView {
    Toolbar tb = null;
    FrameLayout mFrameLayout = null;
    boolean mLoginFlag = false;
    View view = null;
    //Context mContext = null;
    String accessToken;
    String mNickname;
    TextView mCookieText;
    String isLogin;
    TextView nickname;



    //네이버로그인
    private static String OAUTH_CLIENT_ID ="TsRlPAeR8cojfwcDKvbG";
    private static String OAUTH_CLIENT_SECRET="JArPgUUAvz";
    private static String OAUTH_CLIENT_NAME="네이버웹툰";
    private static OAuthLogin mOAuthLoginInstance;
    private static Context mContext;

    private OAuthLoginButton mOAuthLoginButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_more,container,false);
        mContext = view.getContext();
        nickname= view.findViewById(R.id.more_nickname);
        tb = (Toolbar)view.findViewById(R.id.app_toolbar);
        tb.setTitle("더보기");
        ((AppCompatActivity)getActivity()).setSupportActionBar(tb);

        Bundle bundle = getArguments();
        if(bundle!=null) {
            isLogin = bundle.getString("로그인여부");

            if (isLogin.equals("로그인성공")) {
                mLoginFlag = true;
            } else if(isLogin.equals("로그인실패")) {
                //mLoginFlag = false;
            }
        }


        mCookieText = view.findViewById(R.id.more_cookie_count);

        initData(view);

        if(mLoginFlag) {
            //TextView nickname = view.findViewById(R.id.more_nickname);
            nickname.setText(mNickname);
            mFrameLayout = view.findViewById(R.id.more_frame_login);
            mFrameLayout.setVisibility(View.GONE);
            LinearLayout linearLayout = view.findViewById(R.id.more_info_layout);
            linearLayout.setVisibility(View.VISIBLE);
            tryGetMore();
        }



        return view;
    }


    private void initData(View view){
        mOAuthLoginInstance = OAuthLogin.getInstance();
        mOAuthLoginInstance.init(mContext,OAUTH_CLIENT_ID,OAUTH_CLIENT_SECRET,OAUTH_CLIENT_NAME);

        mOAuthLoginButton = (OAuthLoginButton)(view.findViewById(R.id.more_naver_login));
        mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);


    }

    private  OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if(success) {
                accessToken = mOAuthLoginInstance.getAccessToken(mContext);
                String refreshToken = mOAuthLoginInstance.getRefreshToken(mContext);
                long expiresAt = mOAuthLoginInstance.getExpiresAt(mContext);
                String tokenType = mOAuthLoginInstance.getTokenType(mContext);
                tryGetLoginResponse(accessToken);
                Log.d("accesstoken",accessToken);
                //redirectSignupActivity();
            }
            else{
                String errorCode = mOAuthLoginInstance.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginInstance.getLastErrorDesc(mContext);
            }
        }
    };

    protected void redirectSignupActivity(){
        final Intent intent = new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }



    public void tryGetLoginResponse(String accessToken){
        final LoginService loginService = new LoginService(this,accessToken);
        loginService.getLoginResponse();
    }


    @Override
    public void validateSuccess(LoginResult loginResult) {
        SharedPreferences test = mContext.getSharedPreferences(ApplicationClass.TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = test.edit();
        editor.putString("X-ACCESS-TOKEN",loginResult.getJwt());
        editor.commit();
        try {
            JWTUtils.decoded(loginResult.getJwt());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //nickname = view.findViewById(R.id.more_nickname);

        //jwt 디코드 후 제이슨파싱
        String[] split = loginResult.getJwt().split("\\.");
        byte[] decodeBytes = Base64.decode(split[1], Base64.URL_SAFE);

        try {
             String nick = new String(decodeBytes,"UTF-8");
            JSONObject jsonObject = new JSONObject(nick);
            mNickname = jsonObject.getString("nick");
            nickname.setText(mNickname+"님");

        } catch (UnsupportedEncodingException | JSONException e) {
            e.printStackTrace();
        }
        tryGetMore();

        mLoginFlag=true;
            mFrameLayout = view.findViewById(R.id.more_frame_login);
            mFrameLayout.setVisibility(View.GONE);
            LinearLayout linearLayout = view.findViewById(R.id.more_info_layout);
            linearLayout.setVisibility(View.VISIBLE);

    }

    @Override
    public void validateFailure(String message) {

    }

    public void logout(){

    }


    public void tryGetMore(){
        final FragmentMoreService fragmentMoreService = new FragmentMoreService(this);
        fragmentMoreService.getMore();
    }


    @Override
    public void validateSuccessMore(MoreResult moreResult) {
        mCookieText.setText(Integer.toString(moreResult.getCookieCount())+"개");
        nickname.setText(moreResult.getNick()+"님");
    }

    @Override
    public void validateFailureMore(String message) {

    }
}
