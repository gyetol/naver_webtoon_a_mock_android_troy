package com.softsquared.naverwebtoon.src.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
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
import com.softsquared.naverwebtoon.src.main.models.WebtoonResponse;

import java.util.ArrayList;

public class WebtoonRecyclerViewAdapter extends RecyclerView.Adapter<WebtoonRecyclerViewAdapter.MyViewHolder> {

    ArrayList<WebtoonResponse> list;
    Context mContext;
    LayoutInflater mInflater;

    public WebtoonRecyclerViewAdapter(Context context, ArrayList<WebtoonResponse> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position){
        String url = list.get(position).getPhoto();
        holder.name.setText(list.get(position).getName());

        Glide.with(mContext)
                .load(url)
                .centerCrop()
                .crossFade()
                .into(holder.imageView);

        holder.summary.setText(list.get(position).getSummary());

        holder.search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String term = list.get(position).getName();
               // Intent intent = new Intent()
            }
        });
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

            name = imageView.findViewById(R.id.tv_name);
            imageView = itemView.findViewById(R.id.imageView);
            summary = itemView.findViewById(R.id.tv_summary);
            search = itemView.findViewById(R.id.bt_search);
            search.setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
        }
    }
}
