package com.softsquared.naverwebtoon.src.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.main.models.Result;
import com.softsquared.naverwebtoon.src.main.models.WebtoonResponse;

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

        holder.summary.setText(list.get(position).getAuthor());

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView imageView;
        public TextView summary;
        ImageView search;

        public MyViewHolder(View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.tv_name);
            imageView = itemView.findViewById(R.id.imageView);
            summary = itemView.findViewById(R.id.tv_summary);
            search = itemView.findViewById(R.id.bt_search);

            search.setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
        }
    }
}
