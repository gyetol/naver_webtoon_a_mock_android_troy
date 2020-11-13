/*
package com.softsquared.naverwebtoon.src.detail;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.bumptech.glide.Glide;
        import com.bumptech.glide.RequestManager;
        import com.softsquared.naverwebtoon.R;
        import com.softsquared.naverwebtoon.src.main.fragmentdetail.adapters.DetailAdapter;
        import com.softsquared.naverwebtoon.src.detail.interfaces.DetailActivityView;
        import com.softsquared.naverwebtoon.src.detail.models.DetailEpisodeListResult;
        import com.softsquared.naverwebtoon.src.detail.models.DetailResult;

        import java.util.ArrayList;
        import java.util.List;

public class DetailActivity extends AppCompatActivity implements DetailActivityView {
    private ArrayList<DetailEpisodeListResult> mDetailEpisodeListResults = new ArrayList<>();
    private DetailResult mDetailResult ;
    RecyclerView recyclerView;
    Context mContext;
    RequestManager mGlideRequestManager;
    ImageView iv ;
    TextView title;
    TextView author;
    TextView weekday;
    TextView story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mGlideRequestManager = Glide.with(getApplicationContext());
        ArrayList<DetailEpisodeListResult> detailEpisodeListResults = new ArrayList<>();

        Intent intent = getIntent();
        int idx = intent.getExtras().getInt("고른만화");

        recyclerView = findViewById(R.id.detail_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DetailAdapter adapter = new DetailAdapter(detailEpisodeListResults,this,mGlideRequestManager);
        recyclerView.setAdapter(adapter);
        tryGetDetail(idx);
        tryGetDetailEpisodeList(idx);

        iv = findViewById(R.id.detail_image);
        title = findViewById(R.id.detail_title);
        author = findViewById(R.id.detail_author);
        weekday = findViewById(R.id.detail_weekday);
        story = findViewById(R.id.detail_story);


    }

    public void tryGetDetailEpisodeList(int idx){
        final DetailEpisodeListService detailEpisodeListService = new DetailEpisodeListService(this,idx);
        detailEpisodeListService.getEpisodeList();
    }

    public void tryGetDetail(int idx){
        Log.d("gg","들들" );
        final DetailService detailService = new DetailService(this,idx);
        detailService.getDetail();
        Log.d("gg","빠빠" );
    }

    @Override
    public void validateSuccess(DetailResult detailResult) {
        mDetailResult = detailResult;
        Log.d("gg",mDetailResult.getTitle());

        String url = mDetailResult.getProfile();
        Glide.with(getApplicationContext())
                .load(url)
                .centerCrop()
                .crossFade()
                .into(iv);

        title.setText(mDetailResult.getTitle());
        author.setText(mDetailResult.getAuthor());
        weekday.setText(mDetailResult.getDays());
        story.setText(mDetailResult.getDetails());

    }

    @Override
    public void validateFailure(String message) {
        Log.d("gg","실패" );
    }

    @Override
    public void validateSuccessList(List<DetailEpisodeListResult> detailResults) {
        mDetailEpisodeListResults =(ArrayList<DetailEpisodeListResult>)detailResults;
        DetailAdapter adapter = new DetailAdapter(mDetailEpisodeListResults,mContext,mGlideRequestManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
*/
