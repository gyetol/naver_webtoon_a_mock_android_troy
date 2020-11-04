package com.softsquared.naverwebtoon.src.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.main.models.WebtoonResponse;

import java.util.ArrayList;

public class FragmentWebtoonFragmentMonday extends Fragment {

    private ArrayList<WebtoonResponse> webtoonResponses = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webtoon_fragment_monday,null);

        initDataset();

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.grid_recyclerview);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        WebtoonRecyclerViewAdapter adapter = new WebtoonRecyclerViewAdapter(context,webtoonResponses);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void initDataset(){
        webtoonResponses.clear();
        webtoonResponses.add(new WebtoonResponse("아이유","http://image_url.jpg","아이유다"));
        webtoonResponses.add(new WebtoonResponse("수지","http://image_url.jpg","수지다"));
        webtoonResponses.add(new WebtoonResponse("박보영","http://image_url.jpg","박보영이다"));
    }
}
