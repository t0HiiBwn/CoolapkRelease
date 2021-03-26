package com.alibaba.baichuan.trade.common.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class ExecutorServiceUtils {
    public static final String TAG = "ExecutorServiceUtils";
    private static volatile ExecutorServiceUtils d;
    private Handler a = new Handler(Looper.getMainLooper());
    private HandlerThread b;
    private Handler c;

    private ExecutorServiceUtils() {
        HandlerThread handlerThread = new HandlerThread("SDK Looper Thread");
        this.b = handlerThread;
        handlerThread.start();
        while (this.b.getLooper() == null) {
            try {
                this.b.wait();
            } catch (InterruptedException e) {
                AlibcLogger.e("ExecutorServiceUtils", "创建handlerThread错误：" + e.getMessage());
            }
        }
        this.c = new Handler(this.b.getLooper()) {
            /* class com.alibaba.baichuan.trade.common.utils.ExecutorServiceUtils.AnonymousClass1 */

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    super.handleMessage(message);
                } catch (Throwable th) {
                    AlibcLogger.d("ExecutorServiceUtils", th.getMessage());
                }
            }
        };
    }

    public static ExecutorServiceUtils getInstance() {
        if (d == null) {
            synchronized (ExecutorServiceUtils.class) {
                if (d == null) {
                    d = new ExecutorServiceUtils();
                }
            }
        }
        return d;
    }

    public void destroy() {
        Handler handler = this.a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.a = null;
        }
        Handler handler2 = this.c;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.c = null;
        }
        HandlerThread handlerThread = this.b;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    public void postDelayTask(Runnable runnable, long j) {
        this.c.postDelayed(runnable, j);
    }

    public void postHandlerTask(Runnable runnable) {
        this.c.post(runnable);
    }

    public void postUITask(Runnable runnable) {
        this.a.post(runnable);
    }
}
