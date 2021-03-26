package com.tencent.beacon.core.a;

import android.util.SparseArray;
import com.tencent.beacon.core.d.h;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AsyncTaskHandlerAbs */
public abstract class b {
    public static boolean a = true;
    private static b b;

    public abstract void a(int i, Runnable runnable, long j, long j2);

    public abstract void a(int i, boolean z);

    public abstract void a(Runnable runnable);

    public abstract void a(Runnable runnable, long j);

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new a();
            }
            bVar = b;
        }
        return bVar;
    }

    /* compiled from: AsyncTaskHandlerAbs */
    static class a extends b {
        private ScheduledExecutorService b;
        private SparseArray<ScheduledFuture<?>> c;

        public a() {
            this.b = null;
            this.c = null;
            this.b = Executors.newScheduledThreadPool(3, new ThreadFactoryC0120b());
            this.c = new SparseArray<>();
        }

        @Override // com.tencent.beacon.core.a.b
        public final synchronized void a(Runnable runnable) {
            if (runnable == null) {
                com.tencent.beacon.core.d.b.d("[task] runner should not be null", new Object[0]);
                return;
            }
            this.b.execute(b(runnable));
        }

        @Override // com.tencent.beacon.core.a.b
        public final synchronized void a(int i, Runnable runnable, long j, long j2) {
            if (runnable == null) {
                com.tencent.beacon.core.d.b.d("[task] runner should not be null", new Object[0]);
                return;
            }
            Runnable b2 = b(runnable);
            long j3 = 0;
            if (j > 0) {
                j3 = j;
            }
            if (a && j2 <= 10000) {
                j2 = 10000;
            }
            a(i, true);
            ScheduledFuture<?> scheduleAtFixedRate = this.b.scheduleAtFixedRate(b2, j3, j2, TimeUnit.MILLISECONDS);
            if (scheduleAtFixedRate != null) {
                com.tencent.beacon.core.d.b.b("[task] add a new future! taskId: %d , periodTime: %d", Integer.valueOf(i), Long.valueOf(j2));
                this.c.put(i, scheduleAtFixedRate);
            }
        }

        @Override // com.tencent.beacon.core.a.b
        public final synchronized void a(int i, boolean z) {
            ScheduledFuture<?> scheduledFuture = this.c.get(i);
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                com.tencent.beacon.core.d.b.b("[task] cancel a old future!", new Object[0]);
                scheduledFuture.cancel(z);
            }
            this.c.remove(i);
        }

        @Override // com.tencent.beacon.core.a.b
        public final synchronized void a(Runnable runnable, long j) {
            if (runnable == null) {
                com.tencent.beacon.core.d.b.d("[task] runner should not be null", new Object[0]);
                return;
            }
            Runnable b2 = b(runnable);
            if (j <= 0) {
                j = 0;
            }
            this.b.schedule(b2, j, TimeUnit.MILLISECONDS);
        }

        private static Runnable b(final Runnable runnable) {
            return new Runnable() {
                /* class com.tencent.beacon.core.a.b.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        h.a(th);
                        th.printStackTrace();
                    }
                }
            };
        }
    }

    /* renamed from: com.tencent.beacon.core.a.b$b  reason: collision with other inner class name */
    /* compiled from: AsyncTaskHandlerAbs */
    public class ThreadFactoryC0120b implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            try {
                return new Thread(runnable, "beacon-thread-" + this.a.getAndIncrement());
            } catch (Exception e) {
                com.tencent.beacon.core.d.b.a(e);
                return null;
            } catch (OutOfMemoryError unused) {
                com.tencent.beacon.core.d.b.d("[task] memory not enough, create thread failed.", new Object[0]);
                return null;
            }
        }
    }
}
