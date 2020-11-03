package com.softsquared.naverwebtoon.src.main;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.softsquared.naverwebtoon.R;

import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.Inflater;

public class FragmentWebtoon extends Fragment  {

    private ViewPager viewPager;
    private ImageViewPagerAdapter pagerAdapter;

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;
    final long PERIOD_MS = 3000;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webtoon, container, false);
        viewPager = (ViewPager)(view.findViewById(R.id.viewPager));
        pagerAdapter = new ImageViewPagerAdapter(getActivity());
        viewPager.setAdapter(pagerAdapter);
        final TextView textView = (TextView)view.findViewById(R.id.viewpager_page_count_text);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage=position;
                textView.setText(currentPage+1+" / 10");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        final Handler handler = new Handler();
        final Runnable pagerRunnable = new Runnable() {
            @Override
            public void run() {
                if(currentPage==10){
                    currentPage=0;
                }

                viewPager.setCurrentItem(currentPage++,true);
                //textView.setText(viewPager.getCurrentItem()+1+" / 10");

            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(pagerRunnable);
            }
        },DELAY_MS,PERIOD_MS);

        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
