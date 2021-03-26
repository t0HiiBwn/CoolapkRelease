package com.tencent.tpns.baseapi.base.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import java.lang.Thread;

/* compiled from: ProGuard */
public class CommonWorkingThread {
    private static HandlerThread a;
    private static Handler b;

    /* compiled from: ProGuard */
    public static class CommonWorkingThreadHolder {
        public static CommonWorkingThread instance = new CommonWorkingThread();
    }

    private CommonWorkingThread() {
    }

    public static CommonWorkingThread getInstance() {
        a();
        return CommonWorkingThreadHolder.instance;
    }

    public boolean execute(Runnable runnable) {
        Handler handler = b;
        if (handler != null) {
            return handler.post(runnable);
        }
        return false;
    }

    public boolean execute(Runnable runnable, long j) {
        Handler handler = b;
        if (handler != null) {
            return handler.postDelayed(runnable, j);
        }
        return false;
    }

    public boolean executeAtTime(Runnable runnable, int i, long j) {
        Handler handler = b;
        if (handler != null) {
            return handler.postAtTime(runnable, Integer.valueOf(i), SystemClock.uptimeMillis() + j);
        }
        return false;
    }

    public void remove(int i) {
        Handler handler = b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(Integer.valueOf(i));
        }
    }

    public void remove(Runnable runnable) {
        Handler handler = b;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public Handler getHandler() {
        return b;
    }

    private static void a() {
        try {
            HandlerThread handlerThread = a;
            if (handlerThread == null || !handlerThread.isAlive() || a.isInterrupted() || a.getState() == Thread.State.TERMINATED) {
                HandlerThread handlerThread2 = new HandlerThread("tpns.baseapi.thread");
                a = handlerThread2;
                handlerThread2.start();
                Looper looper = a.getLooper();
                if (looper != null) {
                    b = new Handler(looper);
                } else {
                    Logger.e("CommonWorkingThread", ">>> Create new working thread false, cause thread.getLooper()==null");
                }
            }
        } catch (Throwable th) {
            Logger.e("CommonWorkingThread", "unexpected for initHandler", th);
        }
    }
}
