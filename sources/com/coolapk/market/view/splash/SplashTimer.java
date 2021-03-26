package com.coolapk.market.view.splash;

import android.os.CountDownTimer;
import android.os.Handler;
import com.coolapk.market.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0011R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/splash/SplashTimer;", "", "listener", "Lcom/coolapk/market/view/splash/SplashTimer$OnEventListener;", "(Lcom/coolapk/market/view/splash/SplashTimer$OnEventListener;)V", "countdownTimer", "Landroid/os/CountDownTimer;", "currentTick", "", "handler", "Landroid/os/Handler;", "<set-?>", "", "isStartCountdown", "()Z", "isTimeout", "destroy", "", "startCountdown", "startTimeout", "stopCountdown", "Companion", "OnEventListener", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SplashTimer.kt */
public final class SplashTimer {
    public static final Companion Companion = new Companion(null);
    public static final long DEFAULT_DURATION_AD = 5000;
    public static final long DURATION_TIMEOUT = 5000;
    private CountDownTimer countdownTimer;
    private long currentTick = -1;
    private Handler handler;
    private boolean isStartCountdown;
    private boolean isTimeout;
    private final OnEventListener listener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/splash/SplashTimer$OnEventListener;", "", "onCountdown", "", "number", "", "onCountdownFinish", "onTimeout", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SplashTimer.kt */
    public interface OnEventListener {
        void onCountdown(int i);

        void onCountdownFinish();

        void onTimeout();
    }

    public SplashTimer(OnEventListener onEventListener) {
        Intrinsics.checkNotNullParameter(onEventListener, "listener");
        this.listener = onEventListener;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/splash/SplashTimer$Companion;", "", "()V", "DEFAULT_DURATION_AD", "", "DURATION_TIMEOUT", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SplashTimer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean isStartCountdown() {
        return this.isStartCountdown;
    }

    public final boolean isTimeout() {
        return this.isTimeout;
    }

    public final void startCountdown() {
        CountDownTimer countDownTimer = this.countdownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        long j = this.currentTick;
        if (j == -1) {
            j = 5000;
        }
        SplashTimer$startCountdown$countdownTimer$1 splashTimer$startCountdown$countdownTimer$1 = new SplashTimer$startCountdown$countdownTimer$1(this, j, j, 100);
        this.countdownTimer = splashTimer$startCountdown$countdownTimer$1;
        this.isStartCountdown = true;
        splashTimer$startCountdown$countdownTimer$1.start();
        LogUtils.d("开始倒计时", new Object[0]);
    }

    public final void stopCountdown() {
        LogUtils.d("停止倒计时", new Object[0]);
        this.isStartCountdown = false;
        CountDownTimer countDownTimer = this.countdownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countdownTimer = null;
    }

    public final void startTimeout() {
        Handler handler2 = this.handler;
        if (handler2 == null) {
            handler2 = new Handler();
            this.handler = handler2;
        }
        this.isTimeout = false;
        handler2.removeCallbacksAndMessages(null);
        handler2.postDelayed(new SplashTimer$startTimeout$1(this), 5000);
    }

    public final void destroy() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }
}
