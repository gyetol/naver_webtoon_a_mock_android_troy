package com.softsquared.naverwebtoon.src.main.fragmentmore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;
import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.main.MainActivity;

public class FragmentMore extends Fragment {
    Toolbar tb = null;
    FrameLayout mFrameLayout = null;
    boolean mLoginFlag = false;
    View view = null;
    //Context mContext = null;

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
        tb = (Toolbar)view.findViewById(R.id.app_toolbar);
        tb.setTitle("더보기");
        ((AppCompatActivity)getActivity()).setSupportActionBar(tb);
        initData(view);





        return view;
    }


    private void initData(View view){
        mOAuthLoginInstance = OAuthLogin.getInstance();
        mOAuthLoginInstance.init(mContext,OAUTH_CLIENT_ID,OAUTH_CLIENT_SECRET,OAUTH_CLIENT_NAME);

        mOAuthLoginButton = (OAuthLoginButton)(view.findViewById(R.id.more_naver_login));
        mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);


    }

    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if(success) {
                String accessToken = mOAuthLoginInstance.getAccessToken(mContext);
                String refreshToken = mOAuthLoginInstance.getRefreshToken(mContext);
                long expiresAt = mOAuthLoginInstance.getExpiresAt(mContext);
                String tokenType = mOAuthLoginInstance.getTokenType(mContext);
                Log.d("haha", "토큰: " + accessToken);
                mLoginFlag=true;
                if(mLoginFlag) {
                    mFrameLayout = view.findViewById(R.id.more_frame_login);
                    mFrameLayout.setVisibility(View.GONE);
                    LinearLayout linearLayout = view.findViewById(R.id.more_info_layout);
                    linearLayout.setVisibility(View.VISIBLE);
                }
                //redirectSignupActivity();
            }
            else{
                String errorCode = mOAuthLoginInstance.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginInstance.getLastErrorDesc(mContext);
                Log.d("haha","에러: "+errorCode+ " / 에러: "+errorDesc);
            }
        }
    };

    protected void redirectSignupActivity(){
        final Intent intent = new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
