package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.c.j;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RealTimeProcess */
public final class i implements h {
    private static AtomicInteger e = new AtomicInteger(2000);
    private boolean a = false;
    private List<RDBean> b;
    private Context c;
    private e d;
    private int f;
    private Runnable g = new Runnable() {
        /* class com.tencent.beacon.core.event.i.AnonymousClass1 */

        @Override // java.lang.Runnable
        public final void run() {
            b.f(i.this.a("[realtime event] -> do sync upload task."), new Object[0]);
            try {
                i.this.b();
            } catch (Throwable th) {
                b.a(th);
            }
        }
    };
    private Runnable h = new Runnable() {
        /* class com.tencent.beacon.core.event.i.AnonymousClass2 */

        @Override // java.lang.Runnable
        public final void run() {
            i.this.a();
        }
    };

    public i(Context context, e eVar) {
        this.c = context;
        this.b = Collections.synchronizedList(new ArrayList(25));
        this.d = eVar;
        this.f = e.addAndGet(1);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0010: APUT  (r2v0 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v0 java.lang.String) */
    @Override // com.tencent.beacon.core.event.h
    public final synchronized boolean a(RDBean rDBean) {
        Object[] objArr = new Object[1];
        objArr[0] = rDBean == null ? "null" : rDBean.getEN();
        b.f("[event] eN:%s", objArr);
        if (this.c != null) {
            if (rDBean != null) {
                if (!e()) {
                    b.d(a("[realtime event] disable process."), new Object[0]);
                    return false;
                }
                this.b.add(rDBean);
                d a2 = d.a();
                int b2 = a2.b();
                long c2 = (long) (a2.c() * 1000);
                int size = this.b.size();
                b.b(a("[realtime event] realtime event buff num: " + this.b.size()), new Object[0]);
                if ("rqd_applaunched".equals(rDBean.getEN()) || size >= b2 || rDBean.isImmediatelyUpload()) {
                    b.f(a("[realtime event] upload by max num or immediate."), new Object[0]);
                    com.tencent.beacon.core.a.b.a().a(this.g);
                    com.tencent.beacon.core.a.b.a().a(this.f, this.g, c2, c2);
                }
                Iterator<j> it2 = com.tencent.beacon.core.c.i.a(this.c).c().iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
                b.a(a("[realtime event] processUA:true!"), new Object[0]);
                return true;
            }
        }
        b.d(a("[realtime event] context is null or bean is null !"), new Object[0]);
        return false;
    }

    private synchronized List<RDBean> d() {
        List<RDBean> list = this.b;
        if (list != null && list.size() > 0) {
            if (e()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.b);
                this.b.clear();
                b.b(a("[realtime event] buff event size: " + arrayList.size()), new Object[0]);
                return arrayList;
            }
        }
        return null;
    }

    private synchronized boolean e() {
        return this.a;
    }

    @Override // com.tencent.beacon.core.event.h
    public final synchronized void a(boolean z) {
        if (this.a != z) {
            if (z) {
                this.a = z;
                com.tencent.beacon.core.a.b.a().a(this.f, this.g, 5000, (long) (d.a().c() * 1000));
                return;
            }
            com.tencent.beacon.core.a.b.a().a(this.f, true);
            b(true);
            this.a = z;
        }
    }

    @Override // com.tencent.beacon.core.event.h
    public final synchronized void b(boolean z) {
        b.e(a("[realtime event] flush memory objects to db."), new Object[0]);
        if (z) {
            a();
        } else {
            com.tencent.beacon.core.a.b.a().a(this.h);
        }
    }

    protected final void a() {
        List<RDBean> d2 = d();
        if (d2 != null && d2.size() > 0) {
            b.f(a("[realtime event] sync real events 2 db"), new Object[0]);
            if (l.a(this.c, this.d.f(), d2) != null) {
                Iterator<j> it2 = com.tencent.beacon.core.c.i.a(this.c).c().iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
            }
        }
    }

    protected final void b() {
        if (!e()) {
            b.d(a("[realtime event] disable upload."), new Object[0]);
            return;
        }
        List<RDBean> d2 = d();
        if (d2 != null && d2.size() > 0) {
            com.tencent.beacon.core.c.i a2 = com.tencent.beacon.core.c.i.a(this.c);
            d a3 = d.a();
            if (!c.b(this.c) || a2 == null || !a3.g()) {
                b.f(a("[realtime event] sync real events 2 db"), new Object[0]);
                if (l.a(this.c, this.d.f(), d2) != null) {
                    Iterator<j> it2 = com.tencent.beacon.core.c.i.a(this.c).c().iterator();
                    while (it2.hasNext()) {
                        it2.next();
                    }
                    return;
                }
                return;
            }
            b.f(a("[realtime event] sync real events 2 upload"), new Object[0]);
            a2.a(new j(this.c, this.d.f(), d2));
        }
    }

    @Override // com.tencent.beacon.core.event.h
    public final synchronized void c() {
        com.tencent.beacon.core.a.b.a().a(this.f, this.g, 5000, (long) (d.a().c() * 1000));
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        return str + " Tunnel key: " + this.d.f();
    }
}
