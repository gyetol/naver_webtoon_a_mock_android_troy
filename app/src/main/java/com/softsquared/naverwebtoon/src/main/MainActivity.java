package com.softsquared.naverwebtoon.src.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,LoadingActivity.class);
        startActivity(intent);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentWebtoon).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
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

            switch(menuItem.getItemId()){
                case R.id.bottom_navigation_view_webtoon_1:
                    transaction.replace(R.id.frameLayout,fragmentWebtoon).commitAllowingStateLoss();
                    break;
                case R.id.bottom_navigation_view_recommendation_2:
                    transaction.replace(R.id.frameLayout,fragmentRecommendation).commitAllowingStateLoss();
                    break;
                case R.id.bottom_navigation_view_bestchallenge_3:
                    transaction.replace(R.id.frameLayout,fragmentBestchallenge).commitAllowingStateLoss();
                    break;
                case R.id.bottom_navigation_view_my_4:
                    transaction.replace(R.id.frameLayout,fragmentMypage).commitAllowingStateLoss();
                    break;
                case R.id.bottom_navigation_view_more_5:
                    transaction.replace(R.id.frameLayout,fragmentMore).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }
}