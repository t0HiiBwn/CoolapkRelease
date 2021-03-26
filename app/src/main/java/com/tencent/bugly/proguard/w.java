package com.tencent.bugly.proguard;

import com.tencent.bugly.b;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
public final class w {
    private static final AtomicInteger a = new AtomicInteger(1);
    private static w b;
    private ScheduledExecutorService c = null;

    protected w() {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3, new ThreadFactory(this) {
            /* class com.tencent.bugly.proguard.w.AnonymousClass1 */

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + w.a.getAndIncrement());
                return thread;
            }
        });
        this.c = newScheduledThreadPool;
        if (newScheduledThreadPool == null || newScheduledThreadPool.isShutdown()) {
            x.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            if (b == null) {
                b = new w();
            }
            wVar = b;
        }
        return wVar;
    }

    public final synchronized boolean a(Runnable runnable, long j) {
        if (!c()) {
            x.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            x.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            if (j <= 0) {
                j = 0;
            }
            x.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j), runnable.getClass().getName());
            try {
                this.c.schedule(runnable, j, TimeUnit.MILLISECONDS);
                return true;
            } catch (Throwable th) {
                if (b.c) {
                    th.printStackTrace();
                }
                return false;
            }
        }
    }

    public final synchronized boolean a(Runnable runnable) {
        if (!c()) {
            x.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            x.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            x.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
            try {
                this.c.execute(runnable);
                return true;
            } catch (Throwable th) {
                if (b.c) {
                    th.printStackTrace();
                }
                return false;
            }
        }
    }

    public final synchronized void b() {
        ScheduledExecutorService scheduledExecutorService = this.c;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            x.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.c.shutdownNow();
        }
    }

    public final synchronized boolean c() {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.c;
        return scheduledExecutorService != null && !scheduledExecutorService.isShutdown();
    }
}
