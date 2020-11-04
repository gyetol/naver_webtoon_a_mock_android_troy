package com.softsquared.naverwebtoon.src.main;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.softsquared.naverwebtoon.R;

public class ContentsPagerAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;
    private Context mContext=null;

    public ContentsPagerAdapter(@NonNull FragmentManager fm, int mPageCount) {
        super(fm);
        this.mPageCount = mPageCount;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentWebtoonFragmentNew fragmentWebtoonFragmentNew = new FragmentWebtoonFragmentNew();
                return fragmentWebtoonFragmentNew;

            case 1:
                FragmentWebtoonFragmentMonday fragmentWebtoonFragmentMonday = new FragmentWebtoonFragmentMonday();
                return fragmentWebtoonFragmentMonday;

            case 2:
                FragmentWebtoonFragmentTuesday fragmentWebtoonFragmentTuesday = new FragmentWebtoonFragmentTuesday();
                return fragmentWebtoonFragmentTuesday;

            case 3:
                FragmentWebtoonFragmentWednesday fragmentWebtoonFragmentWednesday = new FragmentWebtoonFragmentWednesday();
                return fragmentWebtoonFragmentWednesday;

            case 4:
                FragmentWebtoonFragmentThursday fragmentWebtoonFragmentThursday = new FragmentWebtoonFragmentThursday();
                return fragmentWebtoonFragmentThursday;

            case 5:
                FragmentWebtoonFragmentFriday fragmentWebtoonFragmentFriday = new FragmentWebtoonFragmentFriday();
                return fragmentWebtoonFragmentFriday;

            case 6:
                FragmentWebtoonFragmentSaturday fragmentWebtoonFragmentSaturday = new FragmentWebtoonFragmentSaturday();
                return fragmentWebtoonFragmentSaturday;

            case 7:
                FragmentWebtoonFragmentSunday fragmentWebtoonFragmentSunday = new FragmentWebtoonFragmentSunday();
                return fragmentWebtoonFragmentSunday;

            case 8:
                FragmentWebtoonFragmentEnd fragmentWebtoonFragmentEnd = new FragmentWebtoonFragmentEnd();
                return fragmentWebtoonFragmentEnd;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
