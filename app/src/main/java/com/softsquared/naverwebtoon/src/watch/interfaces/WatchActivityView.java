package com.softsquared.naverwebtoon.src.watch.interfaces;

import com.softsquared.naverwebtoon.src.watch.models.WatchHeartResponse;
import com.softsquared.naverwebtoon.src.watch.models.WatchResult;

public interface WatchActivityView {
    void validateSuccess(WatchResult watchResult);

    void validateFailure(String message);

    void validateSuccessHeart(WatchHeartResponse watchHeartResponse);

}
