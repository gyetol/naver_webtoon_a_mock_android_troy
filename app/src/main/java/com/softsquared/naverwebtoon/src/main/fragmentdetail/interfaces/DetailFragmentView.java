package com.softsquared.naverwebtoon.src.main.fragmentdetail.interfaces;


import com.softsquared.naverwebtoon.src.main.fragmentdetail.models.DetailResult;

public interface DetailFragmentView {
    void validateSuccess(DetailResult detailResult);

    void validateFailure(String message);
}
