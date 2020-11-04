package com.softsquared.naverwebtoon.src.main;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.main.models.WebtoonResponse;

import java.util.ArrayList;
import java.util.List;
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

    //tablayout + viewpager
    private TabLayout mTabLayout;
    private Context mContext;
    private ViewPager mViewPager;
    private ContentsPagerAdapter mContentPagerAdapter;


    //recyclerview
    RecyclerView recyclerView;
    WebtoonRecyclerViewAdapter adapter;
    GridLayoutManager gridLayoutManager;
    ArrayList<WebtoonResponse> list = new ArrayList<WebtoonResponse>(){
        {

        }
    };



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


        //recyclerview
        List<Fragment> listFragments = new ArrayList<>();
        listFragments.add(new FragmentWebtoonFragmentMonday());
        listFragments.add(new FragmentWebtoonFragmentTuesday());

      /*  for(int i =0 ; i<10; i++) {
            list.add(new WebtoonResponse("웹툰이오",R.drawable.webtoon_viewpager_1+i));
        }*/

        recyclerView = (RecyclerView)view.findViewById(R.id.grid_recyclerview);
        adapter = new WebtoonRecyclerViewAdapter(getActivity(),list);
        gridLayoutManager = new GridLayoutManager(getActivity(),3);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);




        //tablayout
        mContext = getContext(); //getApplicationContext를 못받네

        mTabLayout = (TabLayout)view.findViewById(R.id.webtoon_tablayout);

        mTabLayout.addTab(mTabLayout.newTab().setText("신작"));
        mTabLayout.addTab(mTabLayout.newTab().setText("월"));
        mTabLayout.addTab(mTabLayout.newTab().setText("화"));
        mTabLayout.addTab(mTabLayout.newTab().setText("수"));
        mTabLayout.addTab(mTabLayout.newTab().setText("목"));
        mTabLayout.addTab(mTabLayout.newTab().setText("금"));
        mTabLayout.addTab(mTabLayout.newTab().setText("토"));
        mTabLayout.addTab(mTabLayout.newTab().setText("일"));
        mTabLayout.addTab(mTabLayout.newTab().setText("완결"));

        mViewPager = (ViewPager)view.findViewById(R.id.viewpager_weekday);
        mContentPagerAdapter = new ContentsPagerAdapter(
                getChildFragmentManager(),mTabLayout.getTabCount());
        mViewPager.setAdapter(mContentPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                mContentPagerAdapter.notifyDataSetChanged();
                Log.d("haha","아이템번호: "+tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }
        });



        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

   /* private View createTabView(String tabName){
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab,null);
        TextView txt_name = (TextView)tabView.findViewById(R.id.txt_name);
        txt_name.setText(tabName);

        return tabView;
    }*/

    /*@Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext=context;
    }*/
}
