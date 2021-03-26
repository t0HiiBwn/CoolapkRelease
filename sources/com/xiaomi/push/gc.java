package com.xiaomi.push;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.fy;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.q;
import java.util.Hashtable;

public class gc {
    private static final int a = eb.PING_RTT.a();

    static class a {
        static Hashtable<Integer, Long> a = new Hashtable<>();
    }

    public static void a() {
        a(0, a);
    }

    public static void a(int i) {
        ec f = ga.a().f();
        f.a(eb.CHANNEL_STATS_COUNTER.a());
        f.c(i);
        ga.a().a(f);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (gc.class) {
            if (i2 < 16777215) {
                a.a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                c.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        ec f = ga.a().f();
        f.a((byte) i);
        f.a(i2);
        f.b(i3);
        f.b(str);
        f.c(i4);
        ga.a().a(f);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (gc.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                ec f = ga.a().f();
                f.a(i2);
                f.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                f.b(str);
                if (i3 > -1) {
                    f.c(i3);
                }
                ga.a().a(f);
                a.a.remove(Integer.valueOf(i2));
            } else {
                c.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, q.b bVar) {
        new fu(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        ec f = ga.a().f();
        if (i > 0) {
            f.a(eb.GSLB_REQUEST_SUCCESS.a());
            f.b(str);
            f.b(i);
            ga.a().a(f);
            return;
        }
        try {
            fy.a a2 = fy.a(exc);
            f.a(a2.a.a());
            f.c(a2.b);
            f.b(str);
            ga.a().a(f);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            fy.a b = fy.b(exc);
            ec f = ga.a().f();
            f.a(b.a.a());
            f.c(b.b);
            f.b(str);
            ga.a().a(f);
        } catch (NullPointerException unused) {
        }
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            fy.a d = fy.d(exc);
            ec f = ga.a().f();
            f.a(d.a.a());
            f.c(d.b);
            f.b(str);
            ga.a().a(f);
        } catch (NullPointerException unused) {
        }
    }

    public static byte[] c() {
        ed e = ga.a().e();
        if (e != null) {
            return ht.a(e);
        }
        return null;
    }
}
