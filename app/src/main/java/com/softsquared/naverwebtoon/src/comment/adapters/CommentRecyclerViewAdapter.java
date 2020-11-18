package com.softsquared.naverwebtoon.src.comment.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.comment.CommentActivity;
import com.softsquared.naverwebtoon.src.comment.FragmentAllComment;
import com.softsquared.naverwebtoon.src.comment.interfaces.OnItemClick;
import com.softsquared.naverwebtoon.src.comment.models.CommentResult;
import com.softsquared.naverwebtoon.src.comment.models.RequestCommentState;

import java.util.ArrayList;

public class CommentRecyclerViewAdapter extends RecyclerView.Adapter<CommentRecyclerViewAdapter.MyViewHolder> {
    ArrayList<CommentResult> list;
    Context mContext;
    LayoutInflater mInflater;
    boolean isBest;
    private Button btnTest;
    FragmentTransaction transaction;
    FragmentManager fragmentManager;
    //FragmentAllComment fragmentAllComment;
    private OnItemClick mCallback;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position, boolean isUser);
    }

    public CommentRecyclerViewAdapter(ArrayList<CommentResult> list, Context mContext, boolean isBest, OnItemClick listener) {
        this.list = list;
        this.mContext = mContext;
        this.isBest = isBest;
        mInflater = LayoutInflater.from(mContext);
        mCallback = listener;
        //fragmentManager =((AppCompatActivity)mContext).getSupportFragmentManager();
        //fragmentAllComment = new FragmentAllComment();
        Log.d("recycler", "생성자");
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (isBest) {
            view = mInflater.inflate(R.layout.comment_recycler_item, parent, false);
        } else {
            view = mInflater.inflate(R.layout.comment_recycler_item_without_best, parent, false);
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
        Log.d("recycler", "겟아이템");
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nick;
        public TextView date;
        public TextView reply;
        public TextView up;
        public TextView down;

        public MyViewHolder(final View itemView) {
            super(itemView);

            nick = itemView.findViewById(R.id.comment_nick);
            date = itemView.findViewById(R.id.comment_date);
            reply = itemView.findViewById(R.id.comment_text);
            up = itemView.findViewById(R.id.comment_up_count);
            down = itemView.findViewById(R.id.comment_down_count);

           up.setOnClickListener(new View.OnClickListener() {  //좋아요 버튼 클릭시
               @Override
               public void onClick(View v) {
                    int pos = getAdapterPosition();
                    int pickedCommentIdx=0;
                    if(pos != RecyclerView.NO_POSITION){
                        pickedCommentIdx = list.get(pos).getIdx();  // 어떤 댓글의 좋아요 버튼인지 idx에 저장
                        Log.d("picked",""+pickedCommentIdx);
                    }
                    mCallback.onClick(pickedCommentIdx,true);
                    //////////////////////////////////// 어뎁터에서 프래그먼트의 메소드(tryGetCommentLike)를 쓰기위해 아래처럼 new해줬습니다.
                   //FragmentAllComment fragmentAllComment = new FragmentAllComment();
                  // fragmentAllComment.tryGetCommentLike(pickedCommentIdx,new RequestCommentState("L")); // 레트로핏통신, post로 body에 "L"를 보냄
                   // notifyItemChanged(pos);

               }
           });

           down.setOnClickListener(new View.OnClickListener() { //싫어요 버튼 클릭시
               @Override
               public void onClick(View v) {
                   int pos = getAdapterPosition();
                   int pickedCommentIdx=0;
                   if(pos != RecyclerView.NO_POSITION){
                       pickedCommentIdx = list.get(pos).getIdx();
                   }
                   mCallback.onClick(pickedCommentIdx,false);
                   //FragmentAllComment fragmentAllComment = new FragmentAllComment();
                   //fragmentAllComment.tryGetCommentLike(pickedCommentIdx,new RequestCommentState("D"));
                   //notifyItemChanged(pos);

               }
           });


        }

    }


}
