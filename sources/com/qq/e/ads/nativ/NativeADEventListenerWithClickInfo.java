package com.qq.e.ads.nativ;

import android.view.View;

public abstract class NativeADEventListenerWithClickInfo implements NativeADEventListener {
    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public final void onADClicked() {
    }

    public abstract void onADClicked(View view);
}
