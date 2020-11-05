package com.softsquared.naverwebtoon.src.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.naverwebtoon.R;

public class FragmentWebtoonFragmentThursday extends Fragment {

    public FragmentWebtoonFragmentThursday(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("haha","목욜");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webtoon_fragment_thursday,container,false);
        Log.d("haha","목욜뷰생성");
        return view;
    }
}
