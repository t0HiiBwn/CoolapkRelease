package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.c.j;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CommonProcess */
public final class a implements h {
    private static AtomicInteger i = new AtomicInteger(1000);
    private Context a;
    private boolean b = false;
    private Object c = new Object();
    private Object d = new Object();
    private Object e = new Object();
    private List<RDBean> f;
    private long g = 60000;
    private e h;
    private int j;
    private Runnable k = new Runnable() {
        /* class com.tencent.beacon.core.event.a.AnonymousClass1 */

        @Override // java.lang.Runnable
        public final void run() {
            b.f(a.this.a("[event] -> do sync db and upload task."), new Object[0]);
            a.this.a();
        }
    };
    private Runnable l = new Runnable() {
        /* class com.tencent.beacon.core.event.a.AnonymousClass2 */

        @Override // java.lang.Runnable
        public final void run() {
            a.this.b();
        }
    };
    private Runnable m = new Runnable() {
        /* class com.tencent.beacon.core.event.a.AnonymousClass3 */

        @Override // java.lang.Runnable
        public final void run() {
            b.f(a.this.a("[event] -> do max size upload task."), new Object[0]);
            try {
                a.this.h.b(false);
            } catch (Throwable th) {
                b.a(th);
            }
        }
    };

    public a(Context context, e eVar) {
        this.a = context;
        this.f = new ArrayList(25);
        this.h = eVar;
        this.j = i.addAndGet(1);
    }

    private synchronized List<RDBean> d() {
        if (this.f.size() > 0) {
            if (e()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f);
                this.f.clear();
                b.b(a("[event] buffer event size:" + arrayList.size()), new Object[0]);
                return arrayList;
            }
        }
        return null;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0016: APUT  (r3v0 java.lang.Object[]), (0 ??[int, short, byte, char]), (r4v0 java.lang.String) */
    @Override // com.tencent.beacon.core.event.h
    public final boolean a(RDBean rDBean) {
        synchronized (this.c) {
            String a2 = a("[event] eN:%s");
            Object[] objArr = new Object[1];
            objArr[0] = rDBean == null ? "null" : rDBean.getEN();
            b.f(a2, objArr);
            if (!(this.a == null || rDBean == null)) {
                if (this.b) {
                    if (!e()) {
                        b.d(a("[event] return false, isEnable is false !"), new Object[0]);
                        return false;
                    }
                    d a3 = d.a();
                    int d2 = a3.d();
                    this.g = (long) (a3.e() * 1000);
                    int size = this.f.size();
                    if (size >= d2) {
                        b.f(a("[event] max num."), new Object[0]);
                        com.tencent.beacon.core.a.b.a().a(this.k);
                        com.tencent.beacon.core.a.b a4 = com.tencent.beacon.core.a.b.a();
                        int i2 = this.j;
                        Runnable runnable = this.k;
                        long j2 = this.g;
                        a4.a(i2, runnable, j2, j2);
                    }
                    this.f.add(rDBean);
                    b.f(a("[event] event buff num：" + this.f.size()), new Object[0]);
                    if (this.f.size() >= d2) {
                        b.c(a("[event] err BF 3R! list size:" + size), new Object[0]);
                    }
                    Iterator<j> it2 = i.a(this.a).c().iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                    b.a(a("[event] process UA:true!"), new Object[0]);
                    return true;
                }
            }
            b.d(a("[event] err return."), new Object[0]);
            return false;
        }
    }

    protected final void a() {
        boolean z;
        synchronized (this.d) {
            if (!e()) {
                b.d(a("[event] err disable."), new Object[0]);
                return;
            }
            List<RDBean> d2 = d();
            if (d2 == null || d2.size() <= 0) {
                d a2 = d.a();
                if (a2 != null) {
                    z = a2.h();
                } else {
                    z = false;
                }
                if (z) {
                    this.m.run();
                    b.e(a("[event] polling then up"), new Object[0]);
                }
            } else {
                Long[] a3 = l.a(this.a, this.h.f(), d2);
                if (a3 != null) {
                    Iterator<j> it2 = i.a(this.a).c().iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                }
                i a4 = i.a(this.a);
                if (a3 != null) {
                    long f2 = (long) d.a().f();
                    if (c.a(this.a)) {
                        b.e(a("[event] on wifi, so half mSZ " + f2), new Object[0]);
                        f2 /= 2;
                    }
                    int a5 = l.a(this.a, this.h.f());
                    b.b(a("[event] recordNum: " + a5 + ", maxNum: " + f2), new Object[0]);
                    if ((((long) a5) >= f2) && a4.a() && a4.b()) {
                        if (!d.a().g()) {
                            b.e(a("[event] max but not up(zeroPeak)!"), new Object[0]);
                        } else {
                            this.m.run();
                            b.e(a("[event] max then up"), new Object[0]);
                        }
                    }
                }
            }
        }
    }

    protected final void b() {
        b.b(a("[event] sync db only"), new Object[0]);
        synchronized (this.e) {
            if (!e()) {
                b.d(a("[event] err disable."), new Object[0]);
                return;
            }
            List<RDBean> d2 = d();
            if (!(d2 == null || d2.size() <= 0 || l.a(this.a, this.h.f(), d2) == null)) {
                Iterator<j> it2 = i.a(this.a).c().iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
            }
        }
    }

    private synchronized boolean e() {
        return this.b;
    }

    @Override // com.tencent.beacon.core.event.h
    public final synchronized void a(boolean z) {
        if (this.b != z) {
            if (z) {
                this.b = z;
                this.g = (long) (d.a().e() * 1000);
                com.tencent.beacon.core.a.b a2 = com.tencent.beacon.core.a.b.a();
                int i2 = this.j;
                Runnable runnable = this.k;
                long j2 = this.g;
                a2.a(i2, runnable, j2, j2);
                return;
            }
            com.tencent.beacon.core.a.b.a().a(this.j, true);
            com.tencent.beacon.core.a.b.a().a(112, true);
            b(true);
            this.b = z;
        }
    }

    @Override // com.tencent.beacon.core.event.h
    public final synchronized void b(boolean z) {
        b.e(a("[event] process flush memory objects to db."), new Object[0]);
        if (z) {
            b();
        } else {
            com.tencent.beacon.core.a.b.a().a(this.l);
        }
    }

    @Override // com.tencent.beacon.core.event.h
    public final synchronized void c() {
        this.g = (long) (d.a().e() * 1000);
        com.tencent.beacon.core.a.b a2 = com.tencent.beacon.core.a.b.a();
        int i2 = this.j;
        Runnable runnable = this.k;
        long j2 = this.g;
        a2.a(i2, runnable, j2, j2);
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        return str + " Tunnel key: " + this.h.f();
    }
}
