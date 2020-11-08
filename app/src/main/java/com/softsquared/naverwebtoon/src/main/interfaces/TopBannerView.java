package com.softsquared.naverwebtoon.src.main.interfaces;

import com.softsquared.naverwebtoon.src.main.models.TopBannerResult;

import java.util.List;

public interface TopBannerView {
    void validateSuccess(List<TopBannerResult> results);

    void validateFailure(String message);
}

