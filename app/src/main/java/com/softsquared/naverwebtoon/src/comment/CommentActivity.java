package com.softsquared.naverwebtoon.src.comment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.material.tabs.TabLayout;
import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.comment.adapters.CommentPagerAdapter;

public class CommentActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private CommentPagerAdapter mCommentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        mTabLayout = findViewById(R.id.comment_tablayout);

        mTabLayout.addTab(mTabLayout.newTab().setText("BEST 댓글"));
        mTabLayout.addTab(mTabLayout.newTab().setText("전체 댓글"));

        mViewPager = findViewById(R.id.comment_viewpager);
        mCommentPagerAdapter = new CommentPagerAdapter(getSupportFragmentManager(),mTabLayout.getTabCount());
        mViewPager.setAdapter(mCommentPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                mCommentPagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }
        });

    }
}