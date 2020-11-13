package com.softsquared.naverwebtoon.src.main.fragmentmore;

import com.softsquared.naverwebtoon.src.main.fragmentmore.interfaces.MoreFragmentRetrofitInterface;
import com.softsquared.naverwebtoon.src.main.fragmentmore.interfaces.MoreFragmentView;
import com.softsquared.naverwebtoon.src.main.fragmentmore.models.MoreResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.naverwebtoon.src.ApplicationClass.getRetrofit;

public class FragmentMoreService {
    private final MoreFragmentView mMoreFragmentView;

    public FragmentMoreService(MoreFragmentView mMoreFragmentView) {
        this.mMoreFragmentView = mMoreFragmentView;
    }

    public void getMore(){
        final MoreFragmentRetrofitInterface moreFragmentRetrofitInterface  = getRetrofit().create(MoreFragmentRetrofitInterface.class);
        moreFragmentRetrofitInterface.getMore().enqueue(new Callback<MoreResponse>() {
            @Override
            public void onResponse(Call<MoreResponse> call, Response<MoreResponse> response) {
                final MoreResponse moreResponse = response.body();
                if(moreResponse==null){
                    mMoreFragmentView.validateFailureMore(null);
                    return;
                }
                mMoreFragmentView.validateSuccessMore(response.body().getResult());
            }

            @Override
            public void onFailure(Call<MoreResponse> call, Throwable t) {
                mMoreFragmentView.validateFailureMore(null);
            }
        });
    }
}
