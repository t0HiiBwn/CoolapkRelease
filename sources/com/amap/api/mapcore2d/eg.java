package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: LoaderFactory */
public class eg {
    private static final eg a = new eg();
    private static final ThreadFactory d = new b();
    private final Map<String, ei> b = new HashMap();
    private final Map<String, a> c = new HashMap();
    private ExecutorService e = null;

    /* compiled from: LoaderFactory */
    class a {
        volatile boolean a = false;
        volatile boolean b = false;

        a() {
        }
    }

    /* compiled from: LoaderFactory */
    static class b implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "amapD#" + this.a.getAndIncrement());
        }
    }

    private eg() {
    }

    public ExecutorService a() {
        try {
            ExecutorService executorService = this.e;
            if (executorService == null || executorService.isShutdown()) {
                this.e = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(128), d);
            }
        } catch (Throwable unused) {
        }
        return this.e;
    }

    public static eg b() {
        return a;
    }

    a a(da daVar) {
        synchronized (this.c) {
            if (!b(daVar)) {
                return null;
            }
            String a2 = daVar.a();
            a aVar = this.c.get(a2);
            if (aVar == null) {
                try {
                    a aVar2 = new a();
                    try {
                        this.c.put(a2, aVar2);
                    } catch (Throwable unused) {
                    }
                    aVar = aVar2;
                } catch (Throwable unused2) {
                }
            }
            return aVar;
        }
    }

    ei a(Context context, da daVar) throws Exception {
        ei eiVar;
        if (!b(daVar) || context == null) {
            return null;
        }
        String a2 = daVar.a();
        synchronized (this.b) {
            eiVar = this.b.get(a2);
            if (eiVar == null) {
                try {
                    ek ekVar = new ek(context.getApplicationContext(), daVar, true);
                    try {
                        this.b.put(a2, ekVar);
                        ec.a(context, daVar);
                    } catch (Throwable unused) {
                    }
                    eiVar = ekVar;
                } catch (Throwable unused2) {
                }
            }
        }
        return eiVar;
    }

    private boolean b(da daVar) {
        return daVar != null && !TextUtils.isEmpty(daVar.b()) && !TextUtils.isEmpty(daVar.a());
    }
}
