package com.coolapk.market.view.splash;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: SplashTimer.kt */
final class SplashTimer$startTimeout$1 implements Runnable {
    final /* synthetic */ SplashTimer this$0;

    SplashTimer$startTimeout$1(SplashTimer splashTimer) {
        this.this$0 = splashTimer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.this$0.isTimeout = true;
        this.this$0.listener.onTimeout();
    }
}
