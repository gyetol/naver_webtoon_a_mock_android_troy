package com.softsquared.naverwebtoon.src.main.interfaces;

import com.softsquared.naverwebtoon.src.main.models.AutoLoginResponse;
import com.softsquared.naverwebtoon.src.main.models.AutoLoginResult;

public interface AutoLoginView {
    void validateSuccess(AutoLoginResponse autoLoginResponse);

    void validateFailure(String message);
}
