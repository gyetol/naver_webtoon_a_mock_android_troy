package com.softsquared.naverwebtoon.src.watch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.watch.adapters.WatchAdapter;
import com.softsquared.naverwebtoon.src.watch.interfaces.WatchActivityView;
import com.softsquared.naverwebtoon.src.watch.models.WatchEpisode;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        mNextEpisode = findViewById(R.id.watch_next_episode);
        mScrollview = findViewById(R.id.watch_scrollview);

        mGlideRequestManager = Glide.with(getApplicationContext());
        mWatchEpisodes = new ArrayList<>();

        Intent intent = getIntent();
        final int idx = intent.getExtras().getInt("고른에피소드");
        mNextEpisode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int nextidx=idx+1;
                tryGetWatchEpisodes(nextidx);
                mScrollview.post(new Runnable() {
                    @Override
                    public void run() {
                        mScrollview.scrollTo(0,0);
                    }
                });
            }
        });

        recyclerView = findViewById(R.id.watch_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        WatchAdapter adapter = new WatchAdapter(mWatchEpisodes,this,mGlideRequestManager);
        recyclerView.setAdapter(adapter);

        tryGetWatchEpisodes(idx);
    }

    public void tryGetWatchEpisodes(int idx){
        final WatchService watchService = new WatchService(this,idx);
        watchService.getWatch();
    }

    @Override
    public void validateSuccess(WatchResult watchResult) {
        mWatchResult=watchResult;
        Log.d("watch",mWatchResult.getEpisode().get(0).getContents());
         mWatchEpisodes=(ArrayList<WatchEpisode>)mWatchResult.getEpisode();
         WatchAdapter adapter = new WatchAdapter(mWatchEpisodes,mContext,mGlideRequestManager);
         recyclerView.setAdapter(adapter);
         adapter.notifyDataSetChanged();
    }

    @Override
    public void validateFailure(String message) {

    }
}