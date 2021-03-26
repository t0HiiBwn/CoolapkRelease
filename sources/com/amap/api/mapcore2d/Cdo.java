package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.amap.api.mapcore2d.do  reason: invalid class name */
/* compiled from: SDKLogHandler */
public class Cdo extends dl implements Thread.UncaughtExceptionHandler {
    private static ExecutorService e;
    private static Set<Integer> f = Collections.synchronizedSet(new HashSet());
    private static WeakReference<Context> g;
    private static final ThreadFactory h = new ThreadFactory() {
        /* class com.amap.api.mapcore2d.Cdo.AnonymousClass2 */
        private final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.a.getAndIncrement());
        }
    };
    private Context d;
    private List<a> i;

    /* renamed from: com.amap.api.mapcore2d.do$a */
    /* compiled from: SDKLogHandler */
    public interface a {
        void a(Thread thread, Throwable th);
    }

    public static synchronized Cdo a(Context context, da daVar) throws cp {
        synchronized (Cdo.class) {
            if (daVar == null) {
                throw new cp("sdk info is null");
            } else if (daVar.a() == null || "".equals(daVar.a())) {
                throw new cp("sdk name is invalid");
            } else {
                try {
                    new dq().a(context);
                    if (!f.add(Integer.valueOf(daVar.hashCode()))) {
                        return (Cdo) dl.a;
                    }
                    if (dl.a == null) {
                        dl.a = new Cdo(context, daVar);
                    } else {
                        dl.a.c = false;
                    }
                    dl.a.a(context, daVar, dl.a.c);
                    return (Cdo) dl.a;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static synchronized void b() {
        synchronized (Cdo.class) {
            try {
                ExecutorService executorService = e;
                if (executorService != null) {
                    executorService.shutdown();
                }
                em.a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (!(dl.a == null || Thread.getDefaultUncaughtExceptionHandler() != dl.a || dl.a.b == null)) {
                    Thread.setDefaultUncaughtExceptionHandler(dl.a.b);
                }
                dl.a = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return;
    }

    @Override // com.amap.api.mapcore2d.dl
    protected void a(da daVar, String str, String str2) {
        dp.b(daVar, this.d, str2, str);
    }

    @Override // com.amap.api.mapcore2d.dl
    protected void a(Throwable th, int i2, String str, String str2) {
        dp.a(this.d, th, i2, str, str2);
    }

    @Override // com.amap.api.mapcore2d.dl
    protected void a() {
        dm.b(this.d);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th);
        if (th != null) {
            a(th, 0, null, null);
            if (this.b != null) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(this.b);
                } catch (Throwable unused) {
                }
                this.b.uncaughtException(thread, th);
            }
        }
    }

    @Override // com.amap.api.mapcore2d.dl
    protected void a(final Context context, final da daVar, final boolean z) {
        try {
            ExecutorService d2 = d();
            if (d2 == null) {
                return;
            }
            if (!d2.isShutdown()) {
                d2.submit(new Runnable() {
                    /* class com.amap.api.mapcore2d.Cdo.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            synchronized (Looper.getMainLooper()) {
                                new dy(context, true).a(daVar);
                            }
                            if (z) {
                                dp.a(Cdo.this.d);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b(Throwable th, String str, String str2) {
        if (th != null) {
            try {
                a(th, 1, str, str2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private Cdo(Context context, da daVar) {
        this.d = context;
        f();
    }

    private void f() {
        try {
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
                return;
            }
            String obj = this.b.toString();
            if (obj.startsWith("com.amap.apis.utils.core.dynamiccore") || (obj.indexOf("com.amap.api") == -1 && obj.indexOf("com.loc") == -1)) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
                return;
            }
            this.c = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c() {
        WeakReference<Context> weakReference = g;
        if (weakReference != null && weakReference.get() != null) {
            dm.b(g.get());
        } else if (dl.a != null) {
            dl.a.a();
        }
    }

    public static void c(Throwable th, String str, String str2) {
        try {
            if (dl.a != null) {
                dl.a.a(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(da daVar, String str, String str2, String str3, String str4) {
        try {
            if (dl.a != null) {
                dl.a.a(daVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",code:" + str4, "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(da daVar, String str, String str2) {
        try {
            if (dl.a != null) {
                dl.a.a(daVar, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(da daVar, String str, cp cpVar) {
        if (cpVar != null) {
            a(daVar, str, cpVar.c(), cpVar.d(), cpVar.b());
        }
    }

    public static synchronized ExecutorService d() {
        ExecutorService executorService;
        synchronized (Cdo.class) {
            try {
                ExecutorService executorService2 = e;
                if (executorService2 == null || executorService2.isShutdown()) {
                    e = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), h);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            executorService = e;
        }
        return executorService;
    }

    public static synchronized Cdo e() {
        Cdo doVar;
        synchronized (Cdo.class) {
            doVar = (Cdo) dl.a;
        }
        return doVar;
    }

    private void a(Thread thread, Throwable th) {
        int i2 = 0;
        while (i2 < this.i.size() && i2 < 10) {
            try {
                a aVar = this.i.get(i2);
                if (aVar != null) {
                    aVar.a(thread, th);
                }
                i2++;
            } catch (Throwable unused) {
                return;
            }
        }
    }
}
