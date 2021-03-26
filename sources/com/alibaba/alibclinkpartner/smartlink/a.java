package com.alibaba.alibclinkpartner.smartlink;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a {
    private static Handler a = new Handler(Looper.getMainLooper());
    private static ExecutorService b = Executors.newCachedThreadPool();

    public static void a(Runnable runnable) {
        if (runnable != null) {
            b.execute(runnable);
        }
    }
}
