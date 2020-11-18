package com.softsquared.naverwebtoon.src.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.main.fragmentbestchallenge.FragmentBestchallenge;
import com.softsquared.naverwebtoon.src.main.fragmentdetail.FragmentDetail;
import com.softsquared.naverwebtoon.src.main.fragmentmore.FragmentMore;
import com.softsquared.naverwebtoon.src.main.fragmentmypage.FragmentMypage;
import com.softsquared.naverwebtoon.src.main.fragmentrecommendation.FragmentRecommendation;
import com.softsquared.naverwebtoon.src.main.fragmentwebtoon.FragmentWebtoon;

public class MainActivity extends AppCompatActivity  {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentWebtoon fragmentWebtoon = new FragmentWebtoon();
    private FragmentRecommendation fragmentRecommendation = new FragmentRecommendation();
    private FragmentBestchallenge fragmentBestchallenge = new FragmentBestchallenge();
    private FragmentMypage fragmentMypage = new FragmentMypage();
    private FragmentMore fragmentMore = new FragmentMore();
    private FragmentDetail fragmentDetail = new FragmentDetail();
    private Menu mNavMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,LoadingActivity.class);
        startActivityForResult(intent,0);


        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentWebtoon).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());

        mNavMenu = bottomNavigationView.getMenu();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0){
            if(resultCode==RESULT_OK){
                Log.d("autologin","로그인넘어옴");
                Bundle bundle = new Bundle();
                bundle.putString("로그인여부","로그인성공");
                fragmentMore.setArguments(bundle);
            }
            else{
                Log.d("autologin","로그인안넘어옴");
                Bundle bundle = new Bundle();
                bundle.putString("로그인여부","로그인실패");
                fragmentMore.setArguments(bundle);
            }
        }
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragmentDetail).commit();
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction =fragmentManager.beginTransaction();
            MenuItem item1 = mNavMenu.getItem(0);
            MenuItem item2 = mNavMenu.getItem(1);
            MenuItem item3 = mNavMenu.getItem(2);
            MenuItem item4 = mNavMenu.getItem(3);
            MenuItem item5 = mNavMenu.getItem(4);

            switch(menuItem.getItemId()){
                case R.id.bottom_navigation_view_webtoon_1:
                    transaction.replace(R.id.frameLayout,fragmentWebtoon).commitAllowingStateLoss();
                    menuItem.setIcon(getDrawable(R.drawable.item_1_b));
                    item2.setIcon(getDrawable(R.drawable.item_2));
                    item3.setIcon(getDrawable(R.drawable.item_3));
                    item4.setIcon(getDrawable(R.drawable.item_4));
                    item5.setIcon(getDrawable(R.drawable.item_5));
                    break;
                case R.id.bottom_navigation_view_recommendation_2:
                    transaction.replace(R.id.frameLayout,fragmentRecommendation).commitAllowingStateLoss();
                    menuItem.setIcon(getDrawable(R.drawable.item_2_b));
                    item1.setIcon(getDrawable(R.drawable.item_1));
                    item3.setIcon(getDrawable(R.drawable.item_3));
                    item4.setIcon(getDrawable(R.drawable.item_4));
                    item5.setIcon(getDrawable(R.drawable.item_5));
                    break;
                case R.id.bottom_navigation_view_bestchallenge_3:
                    transaction.replace(R.id.frameLayout,fragmentBestchallenge).commitAllowingStateLoss();
                    menuItem.setIcon(getDrawable(R.drawable.item_3_b));
                    item1.setIcon(getDrawable(R.drawable.item_1));
                    item2.setIcon(getDrawable(R.drawable.item_2));
                    item4.setIcon(getDrawable(R.drawable.item_4));
                    item5.setIcon(getDrawable(R.drawable.item_5));
                    break;
                case R.id.bottom_navigation_view_my_4:
                    transaction.replace(R.id.frameLayout,fragmentMypage).commitAllowingStateLoss();
                    menuItem.setIcon(getDrawable(R.drawable.item_4_b));
                    item1.setIcon(getDrawable(R.drawable.item_1));
                    item2.setIcon(getDrawable(R.drawable.item_2));
                    item3.setIcon(getDrawable(R.drawable.item_3));
                    item5.setIcon(getDrawable(R.drawable.item_5));
                    break;
                case R.id.bottom_navigation_view_more_5:
                    transaction.replace(R.id.frameLayout,fragmentMore).commitAllowingStateLoss();
                    menuItem.setIcon(getDrawable(R.drawable.item_5_b));
                    item1.setIcon(getDrawable(R.drawable.item_1));
                    item2.setIcon(getDrawable(R.drawable.item_2));
                    item3.setIcon(getDrawable(R.drawable.item_3));
                    item4.setIcon(getDrawable(R.drawable.item_4));
                    break;
            }
            return true;
        }
    }
}