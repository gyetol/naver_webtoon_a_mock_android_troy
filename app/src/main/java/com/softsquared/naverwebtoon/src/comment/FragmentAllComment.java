package com.softsquared.naverwebtoon.src.comment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.naverwebtoon.R;
import com.softsquared.naverwebtoon.src.comment.adapters.CommentRecyclerViewAdapter;
import com.softsquared.naverwebtoon.src.comment.interfaces.CommentActivityView;
import com.softsquared.naverwebtoon.src.comment.models.CommentResult;

import java.util.ArrayList;
import java.util.List;

public class FragmentAllComment extends Fragment implements CommentActivityView {
    private ArrayList<CommentResult> items = new ArrayList<>();
    RecyclerView recyclerView = null;
    Context context = null;
    CommentRecyclerViewAdapter adapter = null;
    boolean isBest =false;

    public FragmentAllComment(){}

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
        return view;
    }

    public void tryGetCommentList(){
        final FragmentAllCommentService fragmentAllCommentService = new FragmentAllCommentService(this,7);
        fragmentAllCommentService.getCommentList();
    }

    @Override
    public void validateSuccess(List<CommentResult> commentResults) {
        items = (ArrayList<CommentResult>)commentResults;

        CommentRecyclerViewAdapter adapter = new CommentRecyclerViewAdapter(items,context,isBest);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void validateFailure(String message) {

    }
}
