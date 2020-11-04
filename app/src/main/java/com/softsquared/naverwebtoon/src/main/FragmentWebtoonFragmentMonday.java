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

    public FragmentWebtoonFragmentMonday(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webtoon_fragment_monday,container,false);

        return view;
    }


}
