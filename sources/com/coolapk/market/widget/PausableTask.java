package com.coolapk.market.widget;

/* compiled from: MainSpareHandler.kt */
public abstract class PausableTask implements Runnable {
    private CheckPauseCallback callback;

    public final CheckPauseCallback getCallback$presentation_coolapkAppRelease() {
        return this.callback;
    }

    public final void setCallback$presentation_coolapkAppRelease(CheckPauseCallback checkPauseCallback) {
        this.callback = checkPauseCallback;
    }

    public static /* synthetic */ boolean checkNeedPause$default(PausableTask pausableTask, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            return pausableTask.checkNeedPause(z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkNeedPause");
    }

    public final boolean checkNeedPause(boolean z) {
        CheckPauseCallback checkPauseCallback = this.callback;
        if (checkPauseCallback == null) {
            return false;
        }
        boolean checkNeedPause = checkPauseCallback.checkNeedPause();
        if (checkNeedPause && z) {
            MainSpareHandler.Companion.getSInstance().post(this);
        }
        return checkNeedPause;
    }
}
