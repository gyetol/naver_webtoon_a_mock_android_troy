package com.softsquared.naverwebtoon.src.main.interfaces;


import com.softsquared.naverwebtoon.src.main.models.LoginResult;

public interface LoginView {
    void validateSuccess(LoginResult loginResult);

    void validateFailure(String message);
}
