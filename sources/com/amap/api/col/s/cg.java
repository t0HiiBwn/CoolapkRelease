package com.amap.api.col.s;

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
public final class cg extends cd implements Thread.UncaughtExceptionHandler {
    private static ExecutorService e;
    private static Set<Integer> f = Collections.synchronizedSet(new HashSet());
    private static WeakReference<Context> g;
    private static final ThreadFactory h = new ThreadFactory() {
        /* class com.amap.api.col.s.cg.AnonymousClass2 */
        private final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.a.getAndIncrement()) {
                /* class com.amap.api.col.s.cg.AnonymousClass2.AnonymousClass1 */

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

    public static synchronized cg a(Context context, br brVar) throws bh {
        synchronized (cg.class) {
            if (brVar == null) {
                throw new bh("sdk info is null");
            } else if (brVar.b() == null || "".equals(brVar.b())) {
                throw new bh("sdk name is invalid");
            } else {
                try {
                    if (!f.add(Integer.valueOf(brVar.hashCode()))) {
                        return (cg) cd.a;
                    }
                    if (cd.a == null) {
                        cd.a = new cg(context);
                    } else {
                        cd.a.c = false;
                    }
                    cd.a.a(brVar, cd.a.c);
                    return (cg) cd.a;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    @Override // com.amap.api.col.s.cd
    protected final void a(br brVar, String str, String str2) {
        ch.a(brVar, this.d, str2, str);
    }

    @Override // com.amap.api.col.s.cd
    protected final void a(Throwable th, int i, String str, String str2) {
        ch.a(this.d, th, i, str, str2);
    }

    @Override // com.amap.api.col.s.cd
    protected final void a() {
        ce.a(this.d);
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

    @Override // com.amap.api.col.s.cd
    protected final void a(final br brVar, final boolean z) {
        try {
            ExecutorService c = c();
            if (c == null) {
                return;
            }
            if (!c.isShutdown()) {
                c.submit(new Runnable() {
                    /* class com.amap.api.col.s.cg.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            synchronized (Looper.getMainLooper()) {
                                ce.a(brVar);
                            }
                            if (z) {
                                ch.a(cg.this.d);
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

    public final void b(Throwable th, String str, String str2) {
        if (th != null) {
            try {
                a(th, 1, str, str2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private cg(Context context) {
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

    public static void b() {
        WeakReference<Context> weakReference = g;
        if (weakReference != null && weakReference.get() != null) {
            ce.a(g.get());
        } else if (cd.a != null) {
            cd.a.a();
        }
    }

    public static void c(Throwable th, String str, String str2) {
        try {
            if (cd.a != null) {
                cd.a.a(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(br brVar, String str, String str2, String str3, String str4) {
        a(brVar, str, str2, str3, "", str4);
    }

    public static void a(br brVar, String str, String str2, String str3, String str4, String str5) {
        try {
            if (cd.a != null) {
                cd.a.a(brVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(br brVar, String str, String str2) {
        try {
            if (cd.a != null) {
                cd.a.a(brVar, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(br brVar, String str, bh bhVar) {
        a(brVar, str, bhVar.c(), bhVar.d(), bhVar.e(), bhVar.b());
    }

    public static synchronized ExecutorService c() {
        ExecutorService executorService;
        synchronized (cg.class) {
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

    public static synchronized cg d() {
        cg cgVar;
        synchronized (cg.class) {
            cgVar = (cg) cd.a;
        }
        return cgVar;
    }
}
