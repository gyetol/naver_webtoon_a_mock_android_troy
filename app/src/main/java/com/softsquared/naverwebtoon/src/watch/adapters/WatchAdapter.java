package com.softsquared.naverwebtoon.src.watch.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.watch.WatchActivity;
import com.softsquared.naverwebtoon.src.watch.models.WatchEpisode;

import java.util.ArrayList;

public class WatchAdapter extends RecyclerView.Adapter<WatchAdapter.ViewHolder> {
    ArrayList<WatchEpisode> list;
    Context mContext;
    RequestManager mGlideRequestManager;

    public WatchAdapter(ArrayList<WatchEpisode> list, Context mContext, RequestManager mGlideRequestManager) {
        this.list = list;
        this.mContext = mContext;
        this.mGlideRequestManager = mGlideRequestManager;
    }

    @NonNull
    @Override
    public WatchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.watch_recycler_item,parent,false);
        WatchAdapter.ViewHolder vh = new WatchAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull WatchAdapter.ViewHolder holder, int position) {
        String url = list.get(position).getContents();
        mGlideRequestManager.load(url)
                .centerCrop()
                .crossFade()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;

        ViewHolder(View itemView){
            super(itemView);

            imageView=itemView.findViewById(R.id.watch_recycler_image);

        }

    }



}
