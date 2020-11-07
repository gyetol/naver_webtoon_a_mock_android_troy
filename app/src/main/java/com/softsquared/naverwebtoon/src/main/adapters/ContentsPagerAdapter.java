package com.softsquared.naverwebtoon.src.main.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.softsquared.naverwebtoon.src.main.fragmentwebtoon.fragmentend.FragmentWebtoonFragmentEnd;
import com.softsquared.naverwebtoon.src.main.fragmentwebtoon.fragmentfriday.FragmentWebtoonFragmentFriday;
import com.softsquared.naverwebtoon.src.main.fragmentwebtoon.fragmentmonday.FragmentWebtoonFragmentMonday;
import com.softsquared.naverwebtoon.src.main.fragmentwebtoon.fragmentnew.FragmentWebtoonFragmentNew;
import com.softsquared.naverwebtoon.src.main.fragmentwebtoon.fragmentsaturday.FragmentWebtoonFragmentSaturday;
import com.softsquared.naverwebtoon.src.main.fragmentwebtoon.fragmentsunday.FragmentWebtoonFragmentSunday;
import com.softsquared.naverwebtoon.src.main.fragmentwebtoon.fragmentthursday.FragmentWebtoonFragmentThursday;
import com.softsquared.naverwebtoon.src.main.fragmentwebtoon.fragmenttuesday.FragmentWebtoonFragmentTuesday;
import com.softsquared.naverwebtoon.src.main.fragmentwebtoon.fragmentwednesday.FragmentWebtoonFragmentWednesday;

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
                return new FragmentWebtoonFragmentNew();

            case 1:
                return new FragmentWebtoonFragmentMonday();

            case 2:
                return new FragmentWebtoonFragmentTuesday();

            case 3:
                return new FragmentWebtoonFragmentWednesday();

            case 4:
                return new FragmentWebtoonFragmentThursday();

            case 5:
                return new FragmentWebtoonFragmentFriday();

            case 6:
                return new FragmentWebtoonFragmentSaturday();

            case 7:
                return new FragmentWebtoonFragmentSunday();

            case 8:
                return new FragmentWebtoonFragmentEnd();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
