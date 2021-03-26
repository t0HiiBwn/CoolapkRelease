package com.bytedance.sdk.openadsdk.i;

import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.i.b.c;
import com.bytedance.sdk.openadsdk.i.e.b;
import com.bytedance.sdk.openadsdk.i.e.f;
import com.bytedance.sdk.openadsdk.i.g.d;
import com.bytedance.sdk.openadsdk.i.i;
import com.bytedance.sdk.openadsdk.i.l;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: AbsTask */
abstract class a implements k {
    private static final AtomicLong m = new AtomicLong();
    protected volatile com.bytedance.sdk.openadsdk.i.a.a a;
    protected final c b;
    protected final AtomicInteger c = new AtomicInteger();
    protected final AtomicLong d = new AtomicLong();
    protected com.bytedance.sdk.openadsdk.i.d.a e;
    protected volatile List<i.b> f;
    protected volatile String g;
    protected volatile String h;
    protected volatile i i;
    protected volatile l j;
    protected volatile boolean k = false;

    /* renamed from: l  reason: collision with root package name */
    public final long f1332l = m.incrementAndGet();
    private final AtomicInteger n = new AtomicInteger(0);
    private int o = -1;

    protected void a(Boolean bool, String str, Throwable th) {
    }

    public a(com.bytedance.sdk.openadsdk.i.a.a aVar, c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    public void a() {
        this.n.compareAndSet(0, 1);
    }

    public boolean b() {
        return this.n.get() == 1;
    }

    protected void c() {
        this.n.compareAndSet(0, 2);
    }

    public boolean d() {
        return this.n.get() == 2;
    }

    protected void e() throws com.bytedance.sdk.openadsdk.i.c.a {
        if (b()) {
            throw new com.bytedance.sdk.openadsdk.i.c.a();
        }
    }

    protected com.bytedance.sdk.openadsdk.i.e.a a(l.a aVar, int i2, int i3, String str) throws IOException, VAdError {
        b b2 = com.bytedance.sdk.openadsdk.i.e.c.a().b();
        f fVar = new f();
        HashMap hashMap = new HashMap();
        fVar.b = aVar.a;
        fVar.a = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            fVar.a = 4;
        }
        List<i.b> list = this.f;
        if (list != null && !list.isEmpty()) {
            for (i.b bVar : list) {
                if (!"Range".equalsIgnoreCase(bVar.a) && !"Connection".equalsIgnoreCase(bVar.a) && !"Proxy-Connection".equalsIgnoreCase(bVar.a) && !"Host".equalsIgnoreCase(bVar.a)) {
                    hashMap.put(bVar.a, bVar.b);
                }
            }
        }
        String a2 = d.a(i2, i3);
        if (a2 != null) {
            hashMap.put("Range", a2);
        }
        if (e.f) {
            hashMap.put("Cache-Control", "no-cache");
        }
        d c2 = d.c();
        f a3 = f.a();
        boolean z = this.i == null;
        c a4 = z ? c2.a() : a3.b();
        c b3 = z ? c2.b() : a3.c();
        if (!(a4 == null && b3 == null)) {
            if (a4 != null) {
                fVar.c = a4.a(aVar.b);
            }
            if (b3 != null) {
                fVar.d = b3.a(aVar.b);
            }
        }
        fVar.e = hashMap;
        if (!this.k) {
            return b2.a(fVar);
        }
        this.k = false;
        return null;
    }

    protected int f() {
        if (this.i != null) {
            return this.i.c.a;
        }
        return this.a instanceof com.bytedance.sdk.openadsdk.i.a.b ? 1 : 0;
    }

    protected boolean g() {
        return f() == 1;
    }

    protected void a(int i2, int i3) {
        if (i2 > 0 && i3 >= 0) {
            int i4 = e.g;
            int f2 = f();
            if (i4 == 1 || (i4 == 2 && f2 == 1)) {
                int i5 = (int) ((((float) i3) / ((float) i2)) * 100.0f);
                if (i5 > 100) {
                    i5 = 100;
                }
                synchronized (this) {
                    if (i5 > this.o) {
                        this.o = i5;
                        d.b(new Runnable() {
                            /* class com.bytedance.sdk.openadsdk.i.a.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.e != null) {
                                    a.this.e.a(a.this.j, a.this.o);
                                }
                            }
                        });
                    }
                }
            }
        }
    }
}
