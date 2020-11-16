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
import com.softsquared.naverwebtoon.src.comment.models.CommentAddResponse;
import com.softsquared.naverwebtoon.src.comment.models.CommentLikeResponse;
import com.softsquared.naverwebtoon.src.comment.models.CommentResult;
import com.softsquared.naverwebtoon.src.comment.models.RequestCommentAdd;

import java.util.ArrayList;
import java.util.List;

public class FragmentBestComment extends Fragment implements CommentActivityView {

    private ArrayList<CommentResult> items = new ArrayList<>();
    RecyclerView recyclerView = null;
    Context context = null;
    CommentRecyclerViewAdapter adapter = null;
    boolean isBest=true;
    String content1;

    public FragmentBestComment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        adapter = new CommentRecyclerViewAdapter(items,context,isBest);
        recyclerView.setAdapter(adapter);
        tryGetCommentList();

        ((CommentActivity)getActivity()).mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               content1= ((CommentActivity)getActivity()).mEditText.getText().toString();
               tryGetCommentAdd();
            }
        });


        return view;
    }

    public void tryGetCommentList(){
        final FragmentBestCommentService fragmentBestCommentService = new FragmentBestCommentService(this,7);
        fragmentBestCommentService.getCommentList();
    }

    public void tryGetCommentAdd(){
        final CommentAddService commentAddService = new CommentAddService(this,7,new RequestCommentAdd(content1));
        commentAddService.AddComment();

    }

    @Override
    public void validateSuccess(List<CommentResult> commentResults) {
        items = (ArrayList<CommentResult>)commentResults;

        CommentRecyclerViewAdapter adapter = new CommentRecyclerViewAdapter(items,context,isBest);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void validateSuccessLike(CommentLikeResponse commentLikeResponse) {

    }

    @Override
    public void validateSuccessAdd(CommentAddResponse commentAddResponse) {
        CommentRecyclerViewAdapter adapter = new CommentRecyclerViewAdapter(items,context,isBest);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Toast.makeText(getContext(),"댓글 달기 성공",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void validateFailure(String message) {

    }


}
