package com.softsquared.naverwebtoon.src.comment.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.softsquared.naverwebtoon.src.comment.FragmentAllComment;
import com.softsquared.naverwebtoon.src.comment.FragmentBestComment;

public class CommentPagerAdapter extends FragmentPagerAdapter {
    int mPageCount; //탭의 개수

    public CommentPagerAdapter(@NonNull FragmentManager fm, int mPageCount) {
        super(fm);
        this.mPageCount = mPageCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new FragmentBestComment();
            case 1:
                return new FragmentAllComment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
