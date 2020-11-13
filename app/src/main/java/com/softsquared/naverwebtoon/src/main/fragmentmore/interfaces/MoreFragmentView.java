package com.softsquared.naverwebtoon.src.main.fragmentmore.interfaces;

import com.softsquared.naverwebtoon.src.main.fragmentmore.models.MoreResult;

public interface MoreFragmentView {
    void validateSuccessMore(MoreResult moreResult);

    void validateFailureMore(String message);
}
