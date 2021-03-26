package com.xiaomi.push;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ad;
import com.xiaomi.push.im;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ag;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ga {
    private String a;
    private boolean b = false;
    private int c;
    private long d;
    private fz e;
    private ad f = ad.a();

    static class a {
        static final ga a = new ga();
    }

    private ec a(ad.a aVar) {
        if (aVar.a != 0) {
            ec f2 = f();
            f2.a(eb.CHANNEL_STATS_COUNTER.a());
            f2.c(aVar.a);
            f2.c(aVar.b);
            return f2;
        } else if (aVar.c instanceof ec) {
            return (ec) aVar.c;
        } else {
            return null;
        }
    }

    public static ga a() {
        return a.a;
    }

    private ed b(int i) {
        ArrayList arrayList = new ArrayList();
        ed edVar = new ed(this.a, arrayList);
        if (!aa.e(this.e.a)) {
            edVar.a(gw.m(this.e.a));
        }
        io ioVar = new io(i);
        ig a2 = new im.a().a(ioVar);
        try {
            edVar.b(a2);
        } catch (ia unused) {
        }
        LinkedList<ad.a> c2 = this.f.c();
        while (true) {
            try {
                if (c2.size() <= 0) {
                    break;
                }
                ec a3 = a(c2.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (ioVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                c2.removeLast();
            } catch (ia | NoSuchElementException unused2) {
            }
        }
        return edVar;
    }

    public static fz b() {
        fz fzVar;
        synchronized (a.a) {
            fzVar = a.a.e;
        }
        return fzVar;
    }

    private void g() {
        if (this.b && System.currentTimeMillis() - this.d > ((long) this.c)) {
            this.b = false;
            this.d = 0;
        }
    }

    public void a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            if (i2 > 604800000) {
                i2 = 604800000;
            }
            if (this.c != i2 || !this.b) {
                this.b = true;
                this.d = System.currentTimeMillis();
                this.c = i2;
                c.c("enable dot duration = " + i2 + " start = " + this.d);
            }
        }
    }

    synchronized void a(ec ecVar) {
        this.f.a(ecVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.e = new fz(xMPushService);
        this.a = "";
        ag.a().a(new gb(this));
    }

    public boolean c() {
        return this.b;
    }

    boolean d() {
        g();
        return this.b && this.f.b() > 0;
    }

    synchronized ed e() {
        ed edVar;
        edVar = null;
        if (d()) {
            int i = 750;
            if (!aa.e(this.e.a)) {
                i = 375;
            }
            edVar = b(i);
        }
        return edVar;
    }

    synchronized ec f() {
        ec ecVar;
        ecVar = new ec();
        ecVar.a(aa.k(this.e.a));
        ecVar.a = 0;
        ecVar.c = 1;
        ecVar.d((int) (System.currentTimeMillis() / 1000));
        return ecVar;
    }
}
