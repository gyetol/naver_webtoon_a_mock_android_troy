package com.softsquared.naverwebtoon.src.main.fragmentwebtoon.fragmenttuesday;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.main.MainService;
import com.softsquared.naverwebtoon.src.main.adapters.WebtoonRecyclerViewAdapter;
import com.softsquared.naverwebtoon.src.main.fragmentwebtoon.fragmentmonday.MondayService;
import com.softsquared.naverwebtoon.src.main.interfaces.MainActivityView;
import com.softsquared.naverwebtoon.src.main.models.Result;

import java.util.ArrayList;
import java.util.List;

public class FragmentWebtoonFragmentTuesday extends Fragment implements MainActivityView {
    private ArrayList<Result> items = new ArrayList<>();
    RecyclerView recyclerView = null;
    Context context= null;
    WebtoonRecyclerViewAdapter adapter = null;

    public FragmentWebtoonFragmentTuesday(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_webtoon_fragment_monday,container,false);
        context = view.getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(context,3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new WebtoonRecyclerViewAdapter(items,context);
        recyclerView.setAdapter(adapter);
        tryGetWebtoonList();
        return view;
    }

    public void tryGetWebtoonList(){
        final TuesdayService tuesdayService = new TuesdayService(this);
        tuesdayService.getWebtoonList();
    }


    @Override
    public void validateSuccess(List<Result> results) {

        items= (ArrayList<Result>)results;

        WebtoonRecyclerViewAdapter adapter = new WebtoonRecyclerViewAdapter(items,context);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void validateFailure(String message) {

    }
}
