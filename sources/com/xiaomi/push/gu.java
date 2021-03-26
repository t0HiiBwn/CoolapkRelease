package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.be;
import com.xiaomi.push.je;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bh;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class gu {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f528a;

    /* renamed from: a  reason: collision with other field name */
    private be f529a = be.a();

    /* renamed from: a  reason: collision with other field name */
    private gt f530a;

    /* renamed from: a  reason: collision with other field name */
    private String f531a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f532a = false;

    static class a {
        static final gu a = new gu();
    }

    private ey a(be.a aVar) {
        if (aVar.f225a != 0) {
            ey a2 = m380a();
            a2.a(ex.CHANNEL_STATS_COUNTER.a());
            a2.c(aVar.f225a);
            a2.c(aVar.f227a);
            return a2;
        } else if (aVar.f226a instanceof ey) {
            return (ey) aVar.f226a;
        } else {
            return null;
        }
    }

    private ez a(int i) {
        ArrayList arrayList = new ArrayList();
        ez ezVar = new ez(this.f531a, arrayList);
        if (!bc.d(this.f530a.f525a)) {
            ezVar.a(i.m(this.f530a.f525a));
        }
        jg jgVar = new jg(i);
        iy a2 = new je.a().a(jgVar);
        try {
            ezVar.b(a2);
        } catch (is unused) {
        }
        LinkedList<be.a> a3 = this.f529a.m136a();
        while (true) {
            try {
                if (a3.size() <= 0) {
                    break;
                }
                ey a4 = a(a3.getLast());
                if (a4 != null) {
                    a4.b(a2);
                }
                if (jgVar.a_() > i) {
                    break;
                }
                if (a4 != null) {
                    arrayList.add(a4);
                }
                a3.removeLast();
            } catch (is | NoSuchElementException unused2) {
            }
        }
        return ezVar;
    }

    public static gt a() {
        gt gtVar;
        synchronized (a.a) {
            gtVar = a.a.f530a;
        }
        return gtVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gu m378a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m379a() {
        if (this.f532a && System.currentTimeMillis() - this.f528a > ((long) this.a)) {
            this.f532a = false;
            this.f528a = 0;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    synchronized ey m380a() {
        ey eyVar;
        eyVar = new ey();
        eyVar.a(bc.m129a((Context) this.f530a.f525a));
        eyVar.f423a = 0;
        eyVar.f427b = 1;
        eyVar.d((int) (System.currentTimeMillis() / 1000));
        return eyVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    synchronized ez m381a() {
        ez ezVar;
        ezVar = null;
        if (b()) {
            int i = 750;
            if (!bc.d(this.f530a.f525a)) {
                i = 375;
            }
            ezVar = a(i);
        }
        return ezVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m382a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            if (i2 > 604800000) {
                i2 = 604800000;
            }
            if (this.a != i2 || !this.f532a) {
                this.f532a = true;
                this.f528a = System.currentTimeMillis();
                this.a = i2;
                b.c("enable dot duration = " + i2 + " start = " + this.f528a);
            }
        }
    }

    synchronized void a(ey eyVar) {
        this.f529a.a(eyVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f530a = new gt(xMPushService);
        this.f531a = "";
        bh.a().a(new gv(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m383a() {
        return this.f532a;
    }

    boolean b() {
        m379a();
        return this.f532a && this.f529a.m135a() > 0;
    }
}
