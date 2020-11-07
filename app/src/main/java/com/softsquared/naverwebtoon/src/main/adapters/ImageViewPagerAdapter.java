package com.softsquared.naverwebtoon.src.main.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.softsquared.naverwebtoon.R;

public class ImageViewPagerAdapter extends PagerAdapter {
    private Context mContext = null;


    public ImageViewPagerAdapter(){}

    public ImageViewPagerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = null;

        if(mContext != null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.page, container, false);
            ImageView imageView = (ImageView)view.findViewById(R.id.viewpager_image);

            //아래의 코드는 나중에 서버에서 받아와 처리할 수 있도록 uri로 바꿔야 합니다
            imageView.setImageResource(R.drawable.webtoon_viewpager_1+position);
        }

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (View)object);
    }

}
