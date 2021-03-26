package com.loc;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SDKLogHandler */
public final class ab extends y implements Thread.UncaughtExceptionHandler {
    private static ExecutorService e;
    private static Set<Integer> f = Collections.synchronizedSet(new HashSet());
    private static WeakReference<Context> g;
    private static final ThreadFactory h = new ThreadFactory() {
        /* class com.loc.ab.AnonymousClass2 */
        private final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.a.getAndIncrement()) {
                /* class com.loc.ab.AnonymousClass2.AnonymousClass1 */

                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    try {
                        super.run();
                    } catch (Throwable unused) {
                    }
                }
            };
        }
    };
    private Context d;

    private ab(Context context) {
        this.d = context;
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

    public static synchronized ab a(Context context, t tVar) throws j {
        synchronized (ab.class) {
            if (tVar == null) {
                throw new j("sdk info is null");
            } else if (tVar.a() == null || "".equals(tVar.a())) {
                throw new j("sdk name is invalid");
            } else {
                try {
                    if (!f.add(Integer.valueOf(tVar.hashCode()))) {
                        return (ab) y.a;
                    }
                    if (y.a == null) {
                        y.a = new ab(context);
                    } else {
                        y.a.c = false;
                    }
                    y.a.a(tVar, y.a.c);
                    return (ab) y.a;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(t tVar, String str, j jVar) {
        if (jVar != null) {
            a(tVar, str, jVar.c(), jVar.d(), jVar.e(), jVar.b());
        }
    }

    public static void a(t tVar, String str, String str2, String str3, String str4) {
        a(tVar, str, str2, str3, "", str4);
    }

    public static void a(t tVar, String str, String str2, String str3, String str4, String str5) {
        try {
            if (y.a != null) {
                y.a.a(tVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void b() {
        synchronized (ab.class) {
            try {
                ExecutorService executorService = e;
                if (executorService != null) {
                    executorService.shutdown();
                }
                ao.a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (!(y.a == null || Thread.getDefaultUncaughtExceptionHandler() != y.a || y.a.b == null)) {
                    Thread.setDefaultUncaughtExceptionHandler(y.a.b);
                }
                y.a = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        return;
    }

    public static void b(t tVar, String str, String str2) {
        try {
            if (y.a != null) {
                y.a.a(tVar, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(Throwable th, String str, String str2) {
        try {
            if (y.a != null) {
                y.a.a(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        WeakReference<Context> weakReference = g;
        if (weakReference != null && weakReference.get() != null) {
            z.a(g.get());
        } else if (y.a != null) {
            y.a.a();
        }
    }

    public static synchronized ExecutorService d() {
        ExecutorService executorService;
        synchronized (ab.class) {
            try {
                ExecutorService executorService2 = e;
                if (executorService2 == null || executorService2.isShutdown()) {
                    e = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), h);
                }
            } catch (Throwable unused) {
            }
            executorService = e;
        }
        return executorService;
    }

    @Override // com.loc.y
    protected final void a() {
        z.a(this.d);
    }

    @Override // com.loc.y
    protected final void a(t tVar, String str, String str2) {
        ac.a(tVar, this.d, str2, str);
    }

    @Override // com.loc.y
    protected final void a(final t tVar, final boolean z) {
        try {
            ExecutorService d2 = d();
            if (d2 == null) {
                return;
            }
            if (!d2.isShutdown()) {
                d2.submit(new Runnable() {
                    /* class com.loc.ab.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            synchronized (Looper.getMainLooper()) {
                                z.a(tVar);
                            }
                            if (z) {
                                ac.a(ab.this.d);
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

    @Override // com.loc.y
    protected final void a(Throwable th, int i, String str, String str2) {
        ac.a(this.d, th, i, str, str2);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
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
}
