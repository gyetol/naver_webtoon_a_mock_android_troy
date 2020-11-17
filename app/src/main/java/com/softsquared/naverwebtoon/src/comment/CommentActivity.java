package com.softsquared.naverwebtoon.src.comment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.comment.adapters.CommentPagerAdapter;
import com.softsquared.naverwebtoon.src.comment.adapters.CommentRecyclerViewAdapter;
import com.softsquared.naverwebtoon.src.comment.interfaces.CommentActivityView;
import com.softsquared.naverwebtoon.src.comment.models.CommentAddResponse;
import com.softsquared.naverwebtoon.src.comment.models.CommentLikeResponse;
import com.softsquared.naverwebtoon.src.comment.models.CommentResult;
import com.softsquared.naverwebtoon.src.comment.models.RequestCommentAdd;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private CommentPagerAdapter mCommentPagerAdapter;
    EditText mEditText;
    TextView mTextviewBtn;
    String comments;
    int idx;
    TextView mAddBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        mAddBtn = findViewById(R.id.comment_add_comment_btn);

        Intent intent = getIntent();
        idx = intent.getExtras().getInt("고른 에피소드");
        Log.d("recycler",idx+"");

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

        mEditText = findViewById(R.id.comment_add_comment);
        mTextviewBtn = findViewById(R.id.comment_add_comment_btn);


    }




}