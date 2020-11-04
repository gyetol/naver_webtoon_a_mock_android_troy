package com.softsquared.naverwebtoon.src.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.main.models.WebtoonResponse;

import java.util.ArrayList;

public class FragmentWebtoonFragmentNew extends Fragment {
    private ArrayList<WebtoonResponse> items = new ArrayList<>();

    public FragmentWebtoonFragmentNew(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webtoon_fragment_new,container,false);

        initDataset();

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        WebtoonRecyclerViewAdapter adapter = new WebtoonRecyclerViewAdapter(items,context);
        recyclerView.setAdapter(adapter);


        return view;

    }

    private void initDataset(){
        items.clear();
        items.add(new WebtoonResponse("아이유", "http://www.viva100.com/mnt/images/file/2019y/06m/17d/20190617001056491_1.jpg", "아이유는 대한민국의 가수이다."));
        items.add(new WebtoonResponse("수지", "http://www.viva100.com/mnt/images/file/2019y/06m/17d/20190617001056491_1.jpg", "수지 는 대한민국의 가수 겸 배우이다."));
        items.add(new WebtoonResponse("박보영", "http://www.viva100.com/mnt/images/file/2019y/06m/17d/20190617001056491_1.jpg", "박보영은 대한민국의 배우이다"));
    }
}
