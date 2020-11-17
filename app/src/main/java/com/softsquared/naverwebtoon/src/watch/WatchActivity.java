package com.softsquared.naverwebtoon.src.watch;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.comment.CommentActivity;
import com.softsquared.naverwebtoon.src.watch.adapters.WatchAdapter;
import com.softsquared.naverwebtoon.src.watch.interfaces.WatchActivityView;
import com.softsquared.naverwebtoon.src.watch.models.WatchEpisode;
import com.softsquared.naverwebtoon.src.watch.models.WatchHeartResponse;
import com.softsquared.naverwebtoon.src.watch.models.WatchResult;

import java.util.ArrayList;

public class WatchActivity extends AppCompatActivity implements WatchActivityView {
    private ArrayList<WatchEpisode> mWatchEpisodes;
    private WatchResult mWatchResult;
    RecyclerView recyclerView;
    Context mContext;
    RequestManager mGlideRequestManager;
    LinearLayout mNextEpisode;
    ScrollView mScrollview;
    NestedScrollView mNestedScrollview;
    ImageView mNextEpisodeImage;
    TextView mNextEpisodeText;
    TextView mStarScore;
    Toolbar mTopbar;
    Toolbar mBottombar;
    ImageView mTopbarBack;
    LinearLayout mHeart;
    LinearLayout mReply;
    ImageView mHeartImage;
    TextView mHeartText;
    ImageView mReplyImage;
    TextView mReplyText;
    String isHeart;
    boolean heartCheck;
    int idx;
    int nextidx;
    int heartCnt;
    ImageView ivFace;
    RecyclerView mWatchRecyclerView;
    LinearLayout mWatchFake;



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        mNextEpisode = findViewById(R.id.watch_next_episode);
        //mScrollview = findViewById(R.id.watch_scrollview);
        mNestedScrollview = findViewById(R.id.watch_scrollview);
        mNextEpisodeText= findViewById(R.id.watch_next_episode_count);
        mNextEpisodeImage = findViewById(R.id.watch_episode_nextimage);
        mStarScore= findViewById(R.id.watch_starscore);
        mWatchRecyclerView = findViewById(R.id.watch_recycler);
        //mWatchFake = findViewById(R.id.watch_fake);

        mGlideRequestManager = Glide.with(getApplicationContext());
        mWatchEpisodes = new ArrayList<>();

        mHeart = findViewById(R.id.watch_heart_layout);
        mReply = findViewById(R.id.watch_reply_layout);
        mHeartImage = findViewById(R.id.watch_heart_image);
        mHeartText = findViewById(R.id.watch_heart_count);
        mReplyImage = findViewById(R.id.watch_reply_image);
        mReplyText = findViewById(R.id.watch_reply_count);

        //툴바
        mTopbar = findViewById(R.id.watch_topbar);
        mBottombar = findViewById(R.id.watch_bottombar);
        mTopbarBack = findViewById(R.id.watch_bac1);
        //mTopbarThreedot = findViewById(R.id.watch_threedot_white);
        setSupportActionBar(mTopbar);
        ActionBar ab = getSupportActionBar();

        mTopbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ivFace = findViewById(R.id.iv_face);
        ivFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTopbar.getVisibility()==View.VISIBLE){
                    mTopbar.setVisibility(View.GONE);
                    mBottombar.setVisibility(View.GONE);
                }
                else if(mTopbar.getVisibility()==View.GONE){
                    mTopbar.setVisibility(View.VISIBLE);
                    mBottombar.setVisibility(View.VISIBLE);
                }
            }
        });

//        mWatchRecyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if(!v.canScrollVertically(-1)){
//                    mTopbar.setVisibility(View.VISIBLE);
//                }
//                else if(scrollY > oldScrollY || scrollY < oldScrollY){
//                    mTopbar.setVisibility(View.GONE);
//                }
//                if(!v.canScrollVertically(1)){
//                    mTopbar.setVisibility(View.VISIBLE);
//                }
//            }
//        });

//        mNestedScrollview.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if (scrollY == 0) {
//                   mTopbar.setVisibility(View.VISIBLE);
//                    mBottombar.setVisibility(View.VISIBLE);
//                   // mWatchFake.setVisibility(View.VISIBLE);
//                } else if (scrollY > oldScrollY || scrollY < oldScrollY) {
//                   mTopbar.setVisibility(View.GONE);
//                    mBottombar.setVisibility(View.GONE);
//                   // mWatchFake.setVisibility(View.GONE);
//                }
//                if(!v.canScrollVertically(1)){
//                    mTopbar.setVisibility(View.VISIBLE);
//                    mBottombar.setVisibility(View.VISIBLE);
//                   // mWatchFake.setVisibility(View.VISIBLE);
//                }
//            }
//        });

        mWatchRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTopbar.getVisibility()==View.VISIBLE){
                    mTopbar.setVisibility(View.GONE);
                    mBottombar.setVisibility(View.GONE);
                }
                else if(mTopbar.getVisibility()==View.GONE){
                    mTopbar.setVisibility(View.VISIBLE);
                    mBottombar.setVisibility(View.VISIBLE);
                }
            }
        });

//        mScrollview.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if(scrollY==0){
//                    mTopbar.setVisibility(View.VISIBLE);
//                    mBottombar.setVisibility(View.VISIBLE);
//                }
//                else{
//                    mTopbar.setVisibility(View.GONE);
//                    mBottombar.setVisibility(View.GONE);
//                }
//            }
//        });


        heartCheck=false;


        Intent intent = getIntent();
        idx = intent.getExtras().getInt("고른에피소드");
        mNextEpisode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextidx=idx+1;
                tryGetWatchEpisodes(nextidx);
                mNextEpisodeText.setText("3화");
                mNextEpisodeImage.setImageResource(R.drawable.epi3);
                mStarScore.setText("9.93");
                mNestedScrollview.post(new Runnable() {
                    @Override
                    public void run() {
                        mNestedScrollview.scrollTo(0,0);
                    }
                });
            }
        });

        recyclerView = findViewById(R.id.watch_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        WatchAdapter adapter = new WatchAdapter(mWatchEpisodes,this,mGlideRequestManager);
        recyclerView.setAdapter(adapter);

        mHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryPushHeart(idx);
            }
        });

        mReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), CommentActivity.class);
                it.putExtra("고른 에피소드", idx);
                startActivity(it);
            }
        });

        tryGetWatchEpisodes(idx);
    }

    public void tryGetWatchEpisodes(int idx){
        final WatchService watchService = new WatchService(this,idx);
        watchService.getWatch();
    }

    public void tryPushHeart(int idx){
        final WatchHeartService watchHeartService = new WatchHeartService(this,idx);
        watchHeartService.pushHeart();
    }

    @Override
    public void validateSuccess(WatchResult watchResult) {
        mWatchResult=watchResult;
        Log.d("watch",mWatchResult.getEpisode().get(0).getContents());
        mWatchEpisodes=(ArrayList<WatchEpisode>)mWatchResult.getEpisode();
        WatchAdapter adapter = new WatchAdapter(mWatchEpisodes,mContext,mGlideRequestManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        heartCnt = mWatchResult.getDetail().getHeartCount();
        mHeartText.setText(Integer.toString(mWatchResult.getDetail().getHeartCount()));
        mReplyText.setText(Integer.toString(mWatchResult.getDetail().getCommentCount()));
        if(mWatchResult.getDetail().getHeart().equals("Y")){
            mHeartImage.setImageResource(R.drawable.watch_heart_red);
        }
        else if(mWatchResult.getDetail().getHeart().equals("N")){
            mHeartImage.setImageResource(R.drawable.watch_heart);
        }
    }

    @Override
    public void validateFailure(String message) {

    }

    @Override
    public void validateSuccessHeart(WatchHeartResponse watchHeartResponse) {

        isHeart = watchHeartResponse.getMessage();
        if(isHeart.equals("유저 하트누르기 성공") || isHeart.equals("유저 하트다시 누르기 성공")){
            mHeartImage.setImageResource(R.drawable.watch_heart_red);
            heartCnt++;
            mHeartText.setText(Integer.toString(heartCnt));
            Log.d("heart","하트 누르기");

        }
        else if(isHeart.equals("유저 하트취소 성공")){
            mHeartImage.setImageResource(R.drawable.watch_heart);
            heartCnt--;
            mHeartText.setText(Integer.toString(heartCnt));
            Log.d("heart","하트 취소");

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_watch_topbar,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_temporarily:
                Toast.makeText(getApplicationContext(),"임시 저장되었습니다",Toast.LENGTH_SHORT).show();
                break;
            case R.id.share_episode:
                Toast.makeText(getApplicationContext(),"회차 공유하기",Toast.LENGTH_SHORT).show();
                break;
            case R.id.register_interest:
                Toast.makeText(getApplicationContext(),"관심웹툰 등록완료",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}