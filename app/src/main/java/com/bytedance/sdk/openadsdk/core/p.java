package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.c.b;
import com.bytedance.sdk.openadsdk.c.e;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.l;
import com.bytedance.sdk.openadsdk.c.m;
import com.bytedance.sdk.openadsdk.c.n;
import com.bytedance.sdk.openadsdk.c.o;
import com.bytedance.sdk.openadsdk.core.h.g;
import com.bytedance.sdk.openadsdk.core.h.h;
import com.bytedance.sdk.openadsdk.g.c.c;
import com.bytedance.sdk.openadsdk.g.c.d;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: InternalContainer */
public class p {
    private static volatile b<com.bytedance.sdk.openadsdk.c.a> a;
    private static volatile b<c.a> b;
    private static volatile b<c.a> c;
    private static volatile q<com.bytedance.sdk.openadsdk.c.a> d;
    private static volatile com.bytedance.sdk.openadsdk.k.a e;
    private static volatile com.bytedance.sdk.openadsdk.g.c.a f;
    private static volatile Context g;
    private static volatile h h;
    private static final AtomicBoolean i = new AtomicBoolean(false);

    public static Context a() {
        if (g == null) {
            a(null);
        }
        return g;
    }

    public static synchronized void a(Context context) {
        synchronized (p.class) {
            if (g == null) {
                if (context != null) {
                    g = context.getApplicationContext();
                } else if (a.a() != null) {
                    try {
                        g = a.a();
                        if (g != null) {
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static void b() {
        a = null;
        e = null;
        f = null;
    }

    public static b<com.bytedance.sdk.openadsdk.c.a> c() {
        if (!g.a()) {
            return b.c();
        }
        if (a == null) {
            synchronized (p.class) {
                if (a == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        a = new com.bytedance.sdk.openadsdk.c.c();
                    } else {
                        a = new b<>(new f(g), f(), l(), b(g));
                    }
                }
            }
        }
        return a;
    }

    public static b<c.a> d() {
        if (!g.a()) {
            return b.d();
        }
        if (c == null) {
            synchronized (p.class) {
                if (c == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        c = new m(false);
                    } else {
                        c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
        }
        return c;
    }

    public static b<c.a> e() {
        if (!g.a()) {
            return b.d();
        }
        if (b == null) {
            synchronized (p.class) {
                if (b == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        b = new m(true);
                    } else {
                        b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
        }
        return b;
    }

    public static q<com.bytedance.sdk.openadsdk.c.a> f() {
        if (d == null) {
            synchronized (p.class) {
                if (d == null) {
                    d = new r(g);
                }
            }
        }
        return d;
    }

    public static com.bytedance.sdk.openadsdk.k.a g() {
        if (!g.a()) {
            return com.bytedance.sdk.openadsdk.k.b.c();
        }
        if (e == null) {
            synchronized (com.bytedance.sdk.openadsdk.k.a.class) {
                if (e == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        e = new com.bytedance.sdk.openadsdk.k.c();
                    } else {
                        e = new com.bytedance.sdk.openadsdk.k.b(g, new com.bytedance.sdk.openadsdk.k.g(g));
                    }
                }
            }
        }
        return e;
    }

    private static g.b l() {
        return g.b.a();
    }

    public static b<c.a> a(String str, String str2, boolean z) {
        e eVar;
        g.b bVar;
        if (z) {
            eVar = new n(g);
            bVar = g.b.a();
        } else {
            bVar = g.b.b();
            eVar = new l(g);
        }
        g.a b2 = b(g);
        return new b<>(eVar, null, bVar, b2, new o(str, str2, eVar, null, bVar, b2));
    }

    private static g.a b(final Context context) {
        return new g.a() {
            /* class com.bytedance.sdk.openadsdk.core.p.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.c.g.a
            public boolean a() {
                Context context = context;
                if (context == null) {
                    context = p.a();
                }
                return x.a(context);
            }
        };
    }

    public static h h() {
        if (h == null) {
            synchronized (h.class) {
                if (h == null) {
                    h = new h();
                }
            }
        }
        return h;
    }

    public static com.bytedance.sdk.openadsdk.g.c.a i() {
        if (!com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return c.c();
        }
        if (f == null) {
            synchronized (c.class) {
                if (f == null) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        f = new d();
                    } else {
                        f = new c();
                    }
                }
            }
        }
        return f;
    }

    public static void j() {
        AtomicBoolean atomicBoolean = i;
        if (atomicBoolean != null) {
            atomicBoolean.set(true);
        }
    }

    public static boolean k() {
        AtomicBoolean atomicBoolean = i;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        return false;
    }

    /* compiled from: InternalContainer */
    private static class a {
        private static volatile Application a;

        public static Application a() {
            return a;
        }

        static {
            try {
                Object b = b();
                a = (Application) b.getClass().getMethod("getApplication", new Class[0]).invoke(b, new Object[0]);
                u.f("MyApplication", "application get success");
            } catch (Throwable th) {
                u.c("MyApplication", "application get failed", th);
            }
        }

        private static Object b() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                u.c("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }
}
