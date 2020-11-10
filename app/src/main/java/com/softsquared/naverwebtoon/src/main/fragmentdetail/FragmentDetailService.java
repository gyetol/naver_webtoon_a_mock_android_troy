package com.softsquared.naverwebtoon.src.main.fragmentdetail;

import com.softsquared.naverwebtoon.src.main.fragmentdetail.interfaces.DetailFragmentRetrofitInterface;
import com.softsquared.naverwebtoon.src.main.fragmentdetail.interfaces.DetailFragmentView;
import com.softsquared.naverwebtoon.src.main.fragmentdetail.models.DetailResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.naverwebtoon.src.ApplicationClass.getRetrofit;

public class FragmentDetailService {
    private final DetailFragmentView mDetailFragmentView;
    private final int idx;

    public FragmentDetailService(DetailFragmentView mDetailFragmentView, int idx) {
        this.mDetailFragmentView = mDetailFragmentView;
        this.idx = idx;
    }

    public void getDetail(){
        final DetailFragmentRetrofitInterface detailFragmentRetrofitInterface = getRetrofit().create(DetailFragmentRetrofitInterface.class);
        detailFragmentRetrofitInterface.getDetail(idx).enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                final DetailResponse detailResponse = response.body();
                if(detailResponse==null){
                    mDetailFragmentView.validateFailure(null);
                    return;
                }
                mDetailFragmentView.validateSuccess(response.body().getResult());
            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                mDetailFragmentView.validateFailure(null);
            }
        });
    }
}
