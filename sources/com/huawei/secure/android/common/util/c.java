package com.huawei.secure.android.common.util;

import android.os.Handler;
import android.os.Looper;

public class c {
    private static Handler v = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (runnable != null) {
            v.post(runnable);
        }
    }
}
