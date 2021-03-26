package com.qq.e.ads.splash;

public interface SplashADZoomOutListener extends SplashADListener {
    boolean isSupportZoomOut();

    void onZoomOut();

    void onZoomOutPlayFinish();
}
