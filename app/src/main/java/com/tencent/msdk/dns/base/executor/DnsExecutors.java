package com.tencent.msdk.dns.base.executor;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public final class DnsExecutors {
    public static final a a = new a();
    public static final Executor b = new b();
    public static ExecutorSupplier c = null;
    private static final AtomicInteger d = new AtomicInteger(0);

    public interface ExecutorSupplier {
        Executor get();
    }

    /* access modifiers changed from: private */
    public static Runnable b(final Runnable runnable) {
        return new Runnable() {
            /* class com.tencent.msdk.dns.base.executor.DnsExecutors.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                String c = DnsExecutors.c("dns-work-" + DnsExecutors.d.getAndIncrement());
                int c2 = DnsExecutors.c();
                try {
                    Runnable runnable = runnable;
                    if (runnable != null) {
                        runnable.run();
                    }
                } catch (Exception e) {
                    com.tencent.msdk.dns.base.log.b.c(e, "Run task in executor failed", new Object[0]);
                }
                DnsExecutors.b(c2);
                DnsExecutors.d(c);
            }
        };
    }

    /* access modifiers changed from: private */
    public static int c() {
        int i = Integer.MIN_VALUE;
        try {
            i = Process.getThreadPriority(Process.myTid());
            if (10 != i) {
                Process.setThreadPriority(10);
            }
        } catch (Exception unused) {
        }
        return i;
    }

    /* access modifiers changed from: private */
    public static void b(int i) {
        if (Integer.MIN_VALUE != i) {
            try {
                if (i != Process.getThreadPriority(Process.myTid())) {
                    Process.setThreadPriority(i);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static String c(String str) {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(str);
        return name;
    }

    /* access modifiers changed from: private */
    public static void d(String str) {
        Thread.currentThread().setName(str);
    }

    private static class a implements a {
        private final HandlerThread a;
        private final Handler b;
        private final Map<Runnable, Runnable> c;

        private a() {
            this.c = new ConcurrentHashMap();
            HandlerThread handlerThread = new HandlerThread("dns-main");
            this.a = handlerThread;
            handlerThread.start();
            this.b = new Handler(handlerThread.getLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (runnable != null) {
                this.b.post(DnsExecutors.b(runnable));
            }
        }

        @Override // com.tencent.msdk.dns.base.executor.a
        public void a(Runnable runnable, long j) {
            if (runnable != null) {
                Runnable b2 = DnsExecutors.b(runnable);
                if (0 < j) {
                    this.c.put(runnable, b2);
                    this.b.postDelayed(b2, j);
                    return;
                }
                execute(b2);
            }
        }

        @Override // com.tencent.msdk.dns.base.executor.a
        public void a(Runnable runnable) {
            Runnable runnable2;
            if (runnable != null && (runnable2 = this.c.get(runnable)) != null) {
                this.b.removeCallbacks(runnable2);
            }
        }
    }

    private static class b implements Executor {
        private final Executor a;

        private b() {
            Executor executor = DnsExecutors.c != null ? DnsExecutors.c.get() : null;
            this.a = executor == null ? AsyncTask.THREAD_POOL_EXECUTOR : executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (runnable != null) {
                this.a.execute(DnsExecutors.b(runnable));
            }
        }
    }
}
