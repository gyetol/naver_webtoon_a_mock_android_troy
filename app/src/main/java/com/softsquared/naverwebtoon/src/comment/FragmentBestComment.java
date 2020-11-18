package com.softsquared.naverwebtoon.src.comment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.comment.adapters.CommentRecyclerViewAdapter;
import com.softsquared.naverwebtoon.src.comment.interfaces.CommentActivityView;
import com.softsquared.naverwebtoon.src.comment.interfaces.OnItemClick;
import com.softsquared.naverwebtoon.src.comment.models.CommentAddResponse;
import com.softsquared.naverwebtoon.src.comment.models.CommentLikeResponse;
import com.softsquared.naverwebtoon.src.comment.models.CommentResult;
import com.softsquared.naverwebtoon.src.comment.models.RequestCommentAdd;
import com.softsquared.naverwebtoon.src.comment.models.RequestCommentState;

import java.util.ArrayList;
import java.util.List;

public class FragmentBestComment extends Fragment implements CommentActivityView, OnItemClick {

   ArrayList<CommentResult> items ;
    RecyclerView recyclerView = null;
    Context context = null;
    CommentRecyclerViewAdapter adapter;
    boolean isBest=true;
    String content1;
    int idx;

    public FragmentBestComment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        idx = ((CommentActivity)getActivity()).idx;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comment_all,container,false);
        context = view.getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.comment_recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
       // CommentRecyclerViewAdapter adapter = new CommentRecyclerViewAdapter(items,context,isBest);
       //recyclerView.setAdapter(adapter);
        tryGetCommentList();

        ((CommentActivity)getActivity()).mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               content1= ((CommentActivity)getActivity()).mEditText.getText().toString();
                ((CommentActivity)getActivity()).mEditText.setText("");
               tryGetCommentAdd();
            }
        });


        return view;
    }

    public void tryGetCommentList(){
        final FragmentBestCommentService fragmentBestCommentService = new FragmentBestCommentService(this,idx);
        fragmentBestCommentService.getCommentList();
    }

    public void tryGetCommentAdd(){
        final CommentAddService commentAddService = new CommentAddService(this,idx,new RequestCommentAdd(content1));
        commentAddService.AddComment();

    }

    public void tryGetCommentLike(int commentIdx, RequestCommentState requestCommentState){ //좋아요 버튼 클릭 통신메서드
        final CommentLikeService commentLikeService = new CommentLikeService(this,commentIdx,requestCommentState);
        commentLikeService.pushLikeOrDislike();
    }

    @Override
    public void validateSuccess(List<CommentResult> commentResults) {
        items = (ArrayList<CommentResult>)commentResults;
        Log.d("recycler","아이템넣어주기best");
        adapter = new CommentRecyclerViewAdapter(items,context,isBest,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void validateSuccessLike(CommentLikeResponse commentLikeResponse) {
        //Toast.makeText(getContext(),"좋아요 성공",Toast.LENGTH_SHORT).show();
        Toast.makeText(getContext(), commentLikeResponse.getMessage(), Toast.LENGTH_SHORT).show();
        tryGetCommentList();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void validateSuccessAdd(CommentAddResponse commentAddResponse) {
        adapter = new CommentRecyclerViewAdapter(items,context,isBest,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        tryGetCommentList();
        Toast.makeText(getContext(),"댓글 달기 성공",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void validateFailure(String message) {

    }


    @Override
    public void onClick(int pickedCommentIdx,boolean isGood) {
        if(isGood) {
            tryGetCommentLike(pickedCommentIdx, new RequestCommentState("L"));
        }
        else{
            tryGetCommentLike(pickedCommentIdx, new RequestCommentState("D"));
        }
    }
}
