package com.softsquared.naverwebtoon.src.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ContentsPagerAdapter extends FragmentPagerAdapter {
    int mPageCount; //탭의 개수

    public ContentsPagerAdapter(@NonNull FragmentManager fm, int mPageCount) {
        super(fm);
        this.mPageCount = mPageCount;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
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
