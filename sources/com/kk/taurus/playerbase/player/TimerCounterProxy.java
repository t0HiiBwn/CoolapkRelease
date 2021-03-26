package com.kk.taurus.playerbase.player;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kk.taurus.playerbase.log.PLog;

public class TimerCounterProxy {
    private final int MSG_CODE_COUNTER = 1;
    private int counterInterval;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        /* class com.kk.taurus.playerbase.player.TimerCounterProxy.AnonymousClass1 */

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1 && TimerCounterProxy.this.useProxy) {
                if (TimerCounterProxy.this.onCounterUpdateListener != null) {
                    TimerCounterProxy.this.onCounterUpdateListener.onCounter();
                }
                TimerCounterProxy.this.loopNext();
            }
        }
    };
    private OnCounterUpdateListener onCounterUpdateListener;
    private boolean useProxy = true;

    public interface OnCounterUpdateListener {
        void onCounter();
    }

    public TimerCounterProxy(int i) {
        this.counterInterval = i;
    }

    public void setUseProxy(boolean z) {
        this.useProxy = z;
        if (!z) {
            cancel();
            PLog.e("TimerCounterProxy", "Timer Stopped");
            return;
        }
        start();
        PLog.e("TimerCounterProxy", "Timer Started");
    }

    public void setOnCounterUpdateListener(OnCounterUpdateListener onCounterUpdateListener2) {
        this.onCounterUpdateListener = onCounterUpdateListener2;
    }

    public void proxyPlayEvent(int i, Bundle bundle) {
        switch (i) {
            case -99016:
            case -99009:
            case -99008:
            case -99007:
                cancel();
                return;
            case -99015:
            case -99014:
            case -99011:
            case -99010:
            case -99006:
            case -99005:
            case -99001:
                if (this.useProxy) {
                    start();
                    return;
                }
                return;
            case -99013:
            case -99012:
            case -99004:
            case -99003:
            case -99002:
            default:
                return;
        }
    }

    public void proxyErrorEvent(int i, Bundle bundle) {
        cancel();
    }

    public void start() {
        removeMessage();
        this.mHandler.sendEmptyMessage(1);
    }

    /* access modifiers changed from: private */
    public void loopNext() {
        removeMessage();
        this.mHandler.sendEmptyMessageDelayed(1, (long) this.counterInterval);
    }

    public void cancel() {
        removeMessage();
    }

    private void removeMessage() {
        this.mHandler.removeMessages(1);
    }
}
