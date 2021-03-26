package com.bytedance.sdk.openadsdk.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: OpenAppSuccEvent */
public class k {
    private static volatile k a;
    private c b = c.a();
    private Map<String, Object> c;
    private b d;

    public static k a() {
        if (a == null) {
            synchronized (k.class) {
                if (a == null) {
                    a = new k();
                }
            }
        }
        return a;
    }

    private k() {
    }

    public void a(l lVar, String str, boolean z) {
        this.d = b.a(lVar, str, this.c, z);
        e.c().schedule(new a(100), 0, TimeUnit.MILLISECONDS);
    }

    private void a(b bVar) {
        if (bVar != null) {
            bVar.b();
            if (bVar.a() * this.b.a > this.b.b) {
                c(bVar.a(false));
            } else {
                e.c().schedule(new a(100), (long) this.b.a, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(b bVar) {
        if (bVar != null) {
            if (aj.a()) {
                a(bVar);
            } else {
                c(bVar.a(true));
            }
        }
    }

    /* compiled from: OpenAppSuccEvent */
    private class a implements Runnable {
        private int b;

        public a(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b == 100 && k.this.d != null) {
                k kVar = k.this;
                kVar.b(kVar.d);
            }
        }
    }

    private void c(b bVar) {
        if (bVar != null) {
            e.a(bVar, 5);
        }
    }

    /* compiled from: OpenAppSuccEvent */
    private static class b implements Serializable, Runnable {
        public final AtomicInteger a = new AtomicInteger(0);
        public final AtomicBoolean b = new AtomicBoolean(false);
        public l c;
        public String d;
        public Map<String, Object> e;
        public boolean f;

        public static b a(l lVar, String str, Map<String, Object> map, boolean z) {
            return new b(lVar, str, map, z);
        }

        public b() {
        }

        public b(l lVar, String str, Map<String, Object> map, boolean z) {
            this.c = lVar;
            this.d = str;
            this.e = map;
            this.f = z;
        }

        public b a(boolean z) {
            this.b.set(z);
            return this;
        }

        public int a() {
            return this.a.get();
        }

        public void b() {
            this.a.incrementAndGet();
        }

        @Override // java.lang.Runnable
        public void run() {
            AtomicBoolean atomicBoolean;
            l lVar;
            if (this.c == null || TextUtils.isEmpty(this.d) || (atomicBoolean = this.b) == null) {
                u.a("materialMeta or eventTag or sResult is null, pls check");
            } else if (this.f) {
                u.b("DMLibManager", "落地页调起应用是否成功 sResult.get() " + this.b.get());
                d.b(p.a(), this.c, this.d, this.b.get() ? "lp_dpl_success" : "lp_dpl_failed");
            } else {
                d.i(p.a(), this.c, this.d, atomicBoolean.get() ? "dpl_success" : "dpl_failed", this.e);
                AtomicBoolean atomicBoolean2 = this.b;
                if (atomicBoolean2 != null && atomicBoolean2.get() && (lVar = this.c) != null) {
                    k.b(lVar, this.d);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(l lVar, String str) {
        if (lVar != null && !TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.utils.k.a(System.currentTimeMillis());
            JSONObject aF = lVar.aF();
            if (aF != null) {
                com.bytedance.sdk.openadsdk.utils.k.d(aF.toString());
                com.bytedance.sdk.openadsdk.utils.k.c(str);
            }
        }
    }

    /* compiled from: OpenAppSuccEvent */
    private static class c {
        public int a = 500;
        public int b = 5000;
        public int c = 1000;
        public int d = 300;

        public static c a() {
            return new c();
        }
    }
}
