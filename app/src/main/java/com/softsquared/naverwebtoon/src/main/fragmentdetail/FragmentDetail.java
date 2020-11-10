package com.softsquared.naverwebtoon.src.main.fragmentdetail;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail,container,false);

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


        return view;
    }

    public void tryGetDetail(int idx){
        final FragmentDetailService fragmentDetailService = new FragmentDetailService(this,idx);
        fragmentDetailService.getDetail();
    }

    @Override
    public void validateSuccess(DetailResult detailResult) {
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

        DetailAdapter adapter = new DetailAdapter(mDetailEpisodeLists,mContext,mGlideRequestManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void validateFailure(String message) {

    }
}
