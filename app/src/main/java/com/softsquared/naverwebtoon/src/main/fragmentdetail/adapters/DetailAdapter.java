package com.softsquared.naverwebtoon.src.main.fragmentdetail.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.main.fragmentdetail.models.DetailEpisodeList;

import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {

    ArrayList<DetailEpisodeList> list;
    Context mContext;
    RequestManager mGlideRequestManager;

    public DetailAdapter(ArrayList<DetailEpisodeList> list, Context mContext, RequestManager mGlideRequestManager) {
        this.list = list;
        this.mContext = mContext;
        this.mGlideRequestManager = mGlideRequestManager;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView episode;
        public TextView starAndDate;

        ViewHolder(View itemView){
            super(itemView);

            imageView=itemView.findViewById(R.id.detail_recycler_image);
            episode=itemView.findViewById(R.id.detail_recycler_episode);
            starAndDate=itemView.findViewById(R.id.detail_recycler_star_date);
        }
    }

    @NonNull
    @Override
    public DetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.detail_recycler_item,parent,false);
        DetailAdapter.ViewHolder vh = new DetailAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailAdapter.ViewHolder holder, int position) {
        String url = list.get(position).getThumbnail();
        mGlideRequestManager.load(url)
                .centerCrop()
                .crossFade()
                .into(holder.imageView);


        holder.episode.setText(list.get(position).getTitle());

        double star = list.get(position).getStarscore();
        int intStar = (int)(star *100);
        star = (double)intStar/100;
        String strStar = Double.toString(star);

        String date = list.get(position).getDate();

        holder.starAndDate.setText(strStar+"  "+date);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
