package com.qq.e.ads.rewardvideo2;

import com.qq.e.comm.util.AdError;
import java.util.Map;

public interface ExpressRewardVideoAdListener {
    void onAdLoaded();

    void onClick();

    void onClose();

    void onError(AdError adError);

    void onExpose();

    void onReward(Map<String, Object> map);

    void onShow();

    void onVideoCached();

    void onVideoComplete();
}
