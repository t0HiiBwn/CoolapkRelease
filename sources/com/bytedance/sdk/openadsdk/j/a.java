package com.bytedance.sdk.openadsdk.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ADThreadPoolExecutor */
class a extends ThreadPoolExecutor {
    private String a = null;

    public a(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.a = str;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        BlockingQueue<Runnable> queue;
        if (runnable instanceof g) {
            super.execute(new b((g) runnable, this));
        } else {
            super.execute(new b(new g() {
                /* class com.bytedance.sdk.openadsdk.j.a.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            }, this));
        }
        if (e.d() && !TextUtils.isEmpty(this.a) && (queue = getQueue()) != null) {
            String str = this.a;
            str.hashCode();
            if (!str.equals("io")) {
                if (str.equals("aidl") && queue.size() >= 4 && getCorePoolSize() != 4) {
                    try {
                        setMaximumPoolSize(e.a + 4);
                        setCorePoolSize(4);
                        u.c("ADThreadPoolExecutor", "execute: increase " + this.a);
                    } catch (Exception e) {
                        u.c("ADThreadPoolExecutor", e.getMessage());
                    }
                }
            } else if (queue.size() >= 8 && getCorePoolSize() != 8) {
                try {
                    setMaximumPoolSize(e.a + 8);
                    setCorePoolSize(8);
                    u.c("ADThreadPoolExecutor", "execute: increase " + this.a);
                } catch (Exception e2) {
                    u.c("ADThreadPoolExecutor", e2.getMessage());
                }
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        BlockingQueue<Runnable> queue;
        super.afterExecute(runnable, th);
        if (e.d() && !TextUtils.isEmpty(this.a) && (queue = getQueue()) != null) {
            String str = this.a;
            str.hashCode();
            if (!str.equals("io")) {
                if (str.equals("aidl") && queue.size() < 4 && getCorePoolSize() != 0) {
                    try {
                        setCorePoolSize(0);
                        setMaximumPoolSize(4);
                        u.c("ADThreadPoolExecutor", "execute: reduce " + this.a);
                    } catch (Exception e) {
                        u.c("ADThreadPoolExecutor", e.getMessage());
                    }
                }
            } else if (queue.size() < 8 && getCorePoolSize() != 2) {
                try {
                    setCorePoolSize(2);
                    setMaximumPoolSize(8);
                    u.c("ADThreadPoolExecutor", "execute: reduce " + this.a);
                } catch (Exception e2) {
                    u.c("ADThreadPoolExecutor", e2.getMessage());
                }
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if ("io".equals(this.a) || "aidl".equals(this.a)) {
            return Collections.emptyList();
        }
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if (!"io".equals(this.a) && !"aidl".equals(this.a)) {
            super.shutdown();
        }
    }

    public String a() {
        return this.a;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.j.a$a  reason: collision with other inner class name */
    /* compiled from: ADThreadPoolExecutor */
    public static class C0058a {
        private String a = "io";
        private int b = 1;
        private long c = 30;
        private TimeUnit d = TimeUnit.SECONDS;
        private int e = 1;
        private BlockingQueue<Runnable> f = null;
        private ThreadFactory g = null;
        private RejectedExecutionHandler h;
        private int i = 5;

        public C0058a a(String str) {
            this.a = str;
            return this;
        }

        public C0058a a(int i2) {
            this.b = i2;
            return this;
        }

        public C0058a a(long j) {
            this.c = j;
            return this;
        }

        public C0058a a(TimeUnit timeUnit) {
            this.d = timeUnit;
            return this;
        }

        public C0058a b(int i2) {
            this.e = i2;
            return this;
        }

        public C0058a a(BlockingQueue<Runnable> blockingQueue) {
            this.f = blockingQueue;
            return this;
        }

        public C0058a a(RejectedExecutionHandler rejectedExecutionHandler) {
            this.h = rejectedExecutionHandler;
            return this;
        }

        public a a() {
            if (this.g == null) {
                this.g = new h(this.i, this.a);
            }
            if (this.h == null) {
                this.h = e.e();
            }
            if (this.f == null) {
                this.f = new LinkedBlockingQueue();
            }
            return new a(this.a, this.b, this.e, this.c, this.d, this.f, this.g, this.h);
        }
    }
}
