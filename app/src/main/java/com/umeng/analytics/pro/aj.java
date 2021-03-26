package com.umeng.analytics.pro;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPoolUtils */
public class aj {
    private static int a = 8;
    private static int b = 64;
    private static int c = 5;
    private static BlockingQueue<Runnable> d = new ArrayBlockingQueue(64);
    private static ThreadPoolExecutor e = new ThreadPoolExecutor(a, b, (long) c, TimeUnit.SECONDS, d);

    private aj() {
    }

    public static void a(Runnable runnable) {
        e.execute(runnable);
    }
}
