package com.softsquared.naverwebtoon.src.main.adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.main.models.Result;

import java.util.ArrayList;

public class WebtoonRecyclerViewAdapter extends RecyclerView.Adapter<WebtoonRecyclerViewAdapter.MyViewHolder> {

    ArrayList<Result> list;
    Context mContext;
    LayoutInflater mInflater;

    public WebtoonRecyclerViewAdapter(ArrayList<Result> list, Context context) {
        this.list = list;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_row,parent,false);
        //View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_row,null);

        View view = mInflater.inflate(R.layout.recyclerview_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position){

        String url = list.get(position).getThumbnail();
        holder.name.setText(list.get(position).getTitle());

        Glide.with(mContext)
                .load(url)
                .centerCrop()
                .crossFade()
                .into(holder.imageView);



        holder.author.setText(list.get(position).getAuthor());
        double star = list.get(position).getStarscore();
        int intStar = (int)(star *100);
        star = (double)intStar/100;
        String strStar = Double.toString(star);
        holder.starScore.setText(strStar);

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView imageView;
        public TextView author;
        public TextView starScore;
       // ImageView search;

        public MyViewHolder(View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.main_webtoon_title);
            imageView = itemView.findViewById(R.id.main_webtoon_image);
            author = itemView.findViewById(R.id.main_webtoon_author);
            starScore = itemView.findViewById(R.id.main_webtoon_starscore);
            //search.setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
        }
    }
}
