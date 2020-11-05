package com.softsquared.naverwebtoon.src.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.main.interfaces.MainActivityView;
import com.softsquared.naverwebtoon.src.main.models.Result;
import com.softsquared.naverwebtoon.src.main.models.WebtoonResponse;

import java.util.ArrayList;
import java.util.List;

public class FragmentWebtoonFragmentMonday extends Fragment implements MainActivityView {
    private ArrayList<Result> items = new ArrayList<>();
    RecyclerView recyclerView = null;
    Context context= null;

    public FragmentWebtoonFragmentMonday(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("haha","월욜");
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_webtoon_fragment_monday,container,false);
        Log.d("haha","월욜뷰생성");
        //Context context = view.getContext();
         context = view.getContext();
       // RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
         recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(context,1);
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        Log.d("haha","어뎁터이전");
        WebtoonRecyclerViewAdapter adapter = new WebtoonRecyclerViewAdapter(items,context);
        Log.d("haha","어뎁터이후");
        recyclerView.setAdapter(adapter);
        Log.d("haha","셋어뎁터까지");
        tryGetWebtoonList();
        return view;
    }

    private void tryGetWebtoonList(){
        final MainService mainService = new MainService(this);
        mainService.getWebtoonList();
        Log.d("haha","서비스");
    }

    private void initDataset(){
        items.clear();
        //items.add(new WebtoonResponse("아이유", "http://www.viva100.com/mnt/images/file/2019y/06m/17d/20190617001056491_1.jpg", "아이유는 대한민국의 가수이다."));
       // items.add(new WebtoonResponse("수지", "http://www.viva100.com/mnt/images/file/2019y/06m/17d/20190617001056491_1.jpg", "수지 는 대한민국의 가수 겸 배우이다."));
       // items.add(new WebtoonResponse("박보영", "http://www.viva100.com/mnt/images/file/2019y/06m/17d/20190617001056491_1.jpg", "박보영은 대한민국의 배우이다"));
    }


    @Override
    public void validateSuccess(List<Result> results) {

        items= (ArrayList<Result>)results;
        Log.d("haha","콜백메서드");
        WebtoonRecyclerViewAdapter adapter = new WebtoonRecyclerViewAdapter(items,context);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void validateFailure(String message) {
        Log.d("haha","실패콜백메서드");
    }
}
