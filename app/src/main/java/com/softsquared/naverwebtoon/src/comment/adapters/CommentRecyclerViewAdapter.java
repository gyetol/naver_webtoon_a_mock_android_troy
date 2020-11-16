package com.softsquared.naverwebtoon.src.comment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.comment.models.CommentResult;

import java.util.ArrayList;

public class CommentRecyclerViewAdapter extends RecyclerView.Adapter<CommentRecyclerViewAdapter.MyViewHolder> {
    ArrayList<CommentResult> list;
    Context mContext;
    LayoutInflater mInflater;
    boolean isBest;
    FragmentTransaction transaction;
    FragmentManager fragmentManager;

    public CommentRecyclerViewAdapter(ArrayList<CommentResult> list, Context mContext,boolean isBest) {
        this.list = list;
        this.mContext = mContext;
        this.isBest = isBest;
        mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(isBest) {
            view = mInflater.inflate(R.layout.comment_recycler_item, parent, false);
        }
        else{
            view = mInflater.inflate(R.layout.comment_recycler_item_without_best,parent,false);
        }

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nick.setText(list.get(position).getNick());
        holder.date.setText(list.get(position).getDate());
        holder.reply.setText(list.get(position).getContents());
        holder.up.setText(Integer.toString(list.get(position).getLikeCount()));
        holder.down.setText(Integer.toString(list.get(position).getDislikeCount()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        public TextView nick;
        public TextView date;
        public TextView reply;
        public TextView up;
        public TextView down;

        public MyViewHolder(View itemView){
            super(itemView);

            nick = itemView.findViewById(R.id.comment_nick);
            date = itemView.findViewById(R.id.comment_date);
            reply = itemView.findViewById(R.id.comment_text);
            up = itemView.findViewById(R.id.comment_up_count);
            down = itemView.findViewById(R.id.comment_down_count);


        }

    }


}
