package com.ali.auth.third.login.util;

import android.content.Context;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.trace.SDKLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class LoginStatus {
    public static final String TAG = "login.LoginStatus";
    private static AtomicBoolean a = new AtomicBoolean(false);
    private static AtomicLong b = new AtomicLong(0);

    public static synchronized boolean compareAndSetLogining(boolean z, boolean z2) {
        boolean compareAndSet;
        synchronized (LoginStatus.class) {
            compareAndSet = a.compareAndSet(z, z2);
            if (compareAndSet) {
                b.set(System.currentTimeMillis());
            }
        }
        return compareAndSet;
    }

    public static long getLastLoginTime() {
        return b.get();
    }

    public static void init(Context context) {
    }

    public static boolean isLogining() {
        if (System.currentTimeMillis() - getLastLoginTime() >= 60000) {
            return false;
        }
        return a.get();
    }

    public static void resetLoginFlag() {
        SDKLogger.w("login.LoginStatus", "reset login status");
        a.compareAndSet(true, false);
        KernelContext.sOneTimeAuthOption = null;
    }
}
