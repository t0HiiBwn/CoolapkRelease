package com.qq.e.ads.nativ;

import com.qq.e.comm.util.AdError;

public interface NativeADEventListener {
    void onADClicked();

    void onADError(AdError adError);

    void onADExposed();

    void onADStatusChanged();
}
