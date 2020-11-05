package com.softsquared.naverwebtoon.src.main.interfaces;

import com.softsquared.naverwebtoon.src.main.models.Result;

import java.util.List;

public interface MainActivityView {
    void validateSuccess(List<Result> results);

    void validateFailure(String message);
}
