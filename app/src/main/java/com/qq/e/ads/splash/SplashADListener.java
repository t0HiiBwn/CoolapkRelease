package com.qq.e.ads.splash;

import com.qq.e.comm.util.AdError;

public interface SplashADListener {
    void onADClicked();

    void onADDismissed();

    void onADExposure();

    void onADLoaded(long j);

    void onADPresent();

    void onADTick(long j);

    void onNoAD(AdError adError);
}
