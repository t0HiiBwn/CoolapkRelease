package com.huawei.hms.stats;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class aw {
    private static aw b = new aw();
    private static aw c = new aw();
    private static aw d = new aw();
    private static aw e = new aw();
    private ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000));

    private static class a implements Runnable {
        private Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    af.c("TaskThread", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    private aw() {
    }

    public static aw a() {
        return b;
    }

    public static aw b() {
        return c;
    }

    public void a(av avVar) {
        try {
            this.a.execute(new a(avVar));
        } catch (RejectedExecutionException unused) {
            af.c("TaskThread", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
