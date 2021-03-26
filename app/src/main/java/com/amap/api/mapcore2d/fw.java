package com.amap.api.mapcore2d;

import com.amap.api.mapcore2d.fx;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ThreadPool */
public final class fw {
    private static fw a;
    private ExecutorService b;
    private ConcurrentHashMap<fx, Future<?>> c = new ConcurrentHashMap<>();
    private fx.a d = new fx.a() {
        /* class com.amap.api.mapcore2d.fw.AnonymousClass1 */

        @Override // com.amap.api.mapcore2d.fx.a
        public void a(fx fxVar) {
        }

        @Override // com.amap.api.mapcore2d.fx.a
        public void b(fx fxVar) {
            fw.this.a(fxVar, false);
        }
    };

    public static fw a(int i) {
        return new fw(i);
    }

    private fw(int i) {
        try {
            this.b = new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256));
        } catch (Throwable th) {
            Cdo.c(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(fx fxVar, boolean z) {
        try {
            Future<?> remove = this.c.remove(fxVar);
            if (z && remove != null) {
                remove.cancel(true);
            }
        } catch (Throwable th) {
            Cdo.c(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
        return;
    }
}
