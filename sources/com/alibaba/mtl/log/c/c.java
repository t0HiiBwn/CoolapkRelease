package com.alibaba.mtl.log.c;

import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.r;
import com.alibaba.mtl.log.upload.UploadEngine;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: LogStoreMgr */
public class c {
    private static int A;
    private static c a;
    private static final Object d = new Object();

    /* renamed from: a  reason: collision with other field name */
    private a f59a = new b(com.alibaba.mtl.log.a.getContext());
    private Runnable b = new Runnable() {
        /* class com.alibaba.mtl.log.c.c.AnonymousClass1 */

        @Override // java.lang.Runnable
        public void run() {
            c.this.F();
        }
    };
    private List<com.alibaba.mtl.log.model.a> l = new CopyOnWriteArrayList();

    private c() {
        UploadEngine.getInstance().start();
        r.a().b(new a());
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            cVar = a;
        }
        return cVar;
    }

    public void a(com.alibaba.mtl.log.model.a aVar) {
        i.a("LogStoreMgr", "[add] :", aVar.X);
        com.alibaba.mtl.log.b.a.m(aVar.T);
        this.l.add(aVar);
        if (this.l.size() >= 100) {
            r.a().f(1);
            r.a().a(1, this.b, 0);
        } else if (!r.a().b(1)) {
            r.a().a(1, this.b, 5000);
        }
        synchronized (d) {
            int i = A + 1;
            A = i;
            if (i > 5000) {
                A = 0;
                r.a().b(new b());
            }
        }
    }

    public int a(List<com.alibaba.mtl.log.model.a> list) {
        i.a("LogStoreMgr", list);
        return this.f59a.mo15a(list);
    }

    public List<com.alibaba.mtl.log.model.a> a(String str, int i) {
        List<com.alibaba.mtl.log.model.a> a2 = this.f59a.a(str, i);
        i.a("LogStoreMgr", "[get]", a2);
        return a2;
    }

    public synchronized void F() {
        i.a("LogStoreMgr", "[store]");
        ArrayList arrayList = null;
        try {
            synchronized (this.l) {
                if (this.l.size() > 0) {
                    arrayList = new ArrayList(this.l);
                    this.l.clear();
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                this.f59a.m14a((List<com.alibaba.mtl.log.model.a>) arrayList);
            }
        } catch (Throwable unused) {
        }
    }

    public void clear() {
        i.a("LogStoreMgr", "[clear]");
        this.f59a.clear();
        this.l.clear();
    }

    /* access modifiers changed from: private */
    public void G() {
        Calendar instance = Calendar.getInstance();
        instance.add(5, -3);
        this.f59a.c("time", String.valueOf(instance.getTimeInMillis()));
    }

    /* access modifiers changed from: private */
    public void e(int i) {
        if (i > 9000) {
            this.f59a.e((i - 9000) + 1000);
        }
    }

    /* compiled from: LogStoreMgr */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.a("LogStoreMgr", "CleanLogTask");
            int g = c.this.f59a.g();
            if (g > 9000) {
                c.this.e(g);
            }
        }
    }

    /* compiled from: LogStoreMgr */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.G();
            int g = c.this.f59a.g();
            if (g > 9000) {
                c.this.e(g);
            }
        }
    }
}
