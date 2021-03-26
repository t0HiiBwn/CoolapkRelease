package com.qq.e.ads.interstitial2;

import com.qq.e.comm.util.AdError;

public interface UnifiedInterstitialADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpened();

    void onADReceive();

    void onNoAD(AdError adError);

    void onVideoCached();
}
