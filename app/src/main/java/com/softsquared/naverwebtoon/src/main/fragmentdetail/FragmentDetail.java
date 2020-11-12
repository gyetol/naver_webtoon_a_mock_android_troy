package com.softsquared.naverwebtoon.src.main.fragmentdetail;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.main.fragmentdetail.adapters.DetailAdapter;
import com.softsquared.naverwebtoon.src.main.fragmentdetail.interfaces.DetailFragmentView;
import com.softsquared.naverwebtoon.src.main.fragmentdetail.models.DetailEpisodeList;
import com.softsquared.naverwebtoon.src.main.fragmentdetail.models.DetailResult;
import com.softsquared.naverwebtoon.src.main.fragmentdetail.models.Details;

import java.util.ArrayList;

public class FragmentDetail extends Fragment implements DetailFragmentView {
    private ArrayList<DetailEpisodeList> mDetailEpisodeLists = new ArrayList<>();
    private DetailResult mDetailResult ;
    private Details mDetails;
    RecyclerView recyclerView;
    Context mContext;
    RequestManager mGlideRequestManager;
    ImageView iv ;
    TextView title;
    TextView author;
    TextView weekday;
    TextView story;
    ScrollView scrollView;
    ImageView storyExpandButton;

    Toolbar tb;
    LinearLayout colorBar;
    boolean connectionFlag=false;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail,container,false);

        colorBar = view.findViewById(R.id.detail_color_bar);
        tb = (Toolbar)view.findViewById(R.id.detail_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(tb);
        ActionBar actionBar =((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);


        scrollView = view.findViewById(R.id.detail_scroll);
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int x = scrollY - oldScrollY;

                if (scrollY == 0) {
                    if(connectionFlag) {
                        tb.setBackgroundColor(Color.parseColor(mDetails.getColor()));
                        colorBar.setBackgroundColor(Color.parseColor(mDetails.getColor()));
                    }

                } else {
                    tb.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    colorBar.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
            }
        });


        mGlideRequestManager = Glide.with(view.getContext());
        ArrayList<DetailEpisodeList> detailEpisodeListResults = new ArrayList<>();
        int idx=0;
        Bundle bundle = getArguments();
        if(bundle!=null){
            idx = bundle.getInt("고른만화");
        }


        recyclerView = view.findViewById(R.id.detail_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        DetailAdapter adapter = new DetailAdapter(mDetailEpisodeLists,view.getContext(),mGlideRequestManager);
        recyclerView.setAdapter(adapter);
        tryGetDetail(idx);

        iv = view.findViewById(R.id.detail_image);
        title = view.findViewById(R.id.detail_title);
        author = view.findViewById(R.id.detail_author);
        weekday = view.findViewById(R.id.detail_weekday);
        story = view.findViewById(R.id.detail_story);
        storyExpandButton = view.findViewById(R.id.detail_story_expand);

        storyExpandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(story.getMaxLines()==1){
                    story.setMaxLines(10);
                }
                else{
                    story.setMaxLines(1);
                }
            }
        });

        return view;
    }

    public void tryGetDetail(int idx){
        final FragmentDetailService fragmentDetailService = new FragmentDetailService(this,idx);
        fragmentDetailService.getDetail();
    }

    @Override
    public void validateSuccess(DetailResult detailResult) {
        connectionFlag=true;
        mDetailResult = detailResult;
        mDetailEpisodeLists = (ArrayList<DetailEpisodeList>)mDetailResult.getEpisodelist();
        mDetails = mDetailResult.getDetail();

        String url = mDetails.getProfile();
        mGlideRequestManager
                .load(url)
                .centerCrop()
                .crossFade()
                .into(iv);

        title.setText(mDetails.getTitle());
        author.setText(mDetails.getAuthor());
        weekday.setText(mDetails.getDays());
        story.setText(mDetails.getDetails());
        tb.setBackgroundColor(Color.parseColor(mDetails.getColor()));
        colorBar.setBackgroundColor(Color.parseColor(mDetails.getColor()));
        DetailAdapter adapter = new DetailAdapter(mDetailEpisodeLists,mContext,mGlideRequestManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void validateFailure(String message) {

    }
}
