package com.coolapk.market.view.splash;

import android.os.CountDownTimer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/coolapk/market/view/splash/SplashTimer$startCountdown$countdownTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SplashTimer.kt */
public final class SplashTimer$startCountdown$countdownTimer$1 extends CountDownTimer {
    final /* synthetic */ long $duration;
    final /* synthetic */ SplashTimer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SplashTimer$startCountdown$countdownTimer$1(SplashTimer splashTimer, long j, long j2, long j3) {
        super(j2, j3);
        this.this$0 = splashTimer;
        this.$duration = j;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        if (this.this$0.isStartCountdown()) {
            this.this$0.listener.onCountdownFinish();
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        if (this.this$0.isStartCountdown()) {
            this.this$0.currentTick = j;
            this.this$0.listener.onCountdown((int) Math.ceil((double) (((float) j) / 1000.0f)));
        }
    }
}
