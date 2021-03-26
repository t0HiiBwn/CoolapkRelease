package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gs;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.as;
import java.util.Hashtable;

public class gw {
    private static final int a = ex.PING_RTT.a();

    static class a {
        static Hashtable<Integer, Long> a = new Hashtable<>();
    }

    public static void a() {
        a(0, a);
    }

    public static void a(int i) {
        ey a2 = gu.m378a().m380a();
        a2.a(ex.CHANNEL_STATS_COUNTER.a());
        a2.c(i);
        gu.m378a().a(a2);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (gw.class) {
            if (i2 < 16777215) {
                a.a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        ey a2 = gu.m378a().m380a();
        a2.a((byte) i);
        a2.a(i2);
        a2.b(i3);
        a2.b(str);
        a2.c(i4);
        gu.m378a().a(a2);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (gw.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                ey a2 = gu.m378a().m380a();
                a2.a(i2);
                a2.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                a2.b(str);
                if (i3 > -1) {
                    a2.c(i3);
                }
                gu.m378a().a(a2);
                a.a.remove(Integer.valueOf(i2));
            } else {
                b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, as.b bVar) {
        new gp(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        ey a2 = gu.m378a().m380a();
        if (i > 0) {
            a2.a(ex.GSLB_REQUEST_SUCCESS.a());
            a2.b(str);
            a2.b(i);
            gu.m378a().a(a2);
            return;
        }
        try {
            gs.a a3 = gs.a(exc);
            a2.a(a3.a.a());
            a2.c(a3.f522a);
            a2.b(str);
            gu.m378a().a(a2);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            gs.a b = gs.b(exc);
            ey a2 = gu.m378a().m380a();
            a2.a(b.a.a());
            a2.c(b.f522a);
            a2.b(str);
            gu.m378a().a(a2);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m384a() {
        ez a2 = gu.m378a().m381a();
        if (a2 != null) {
            return im.a(a2);
        }
        return null;
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            gs.a d = gs.d(exc);
            ey a2 = gu.m378a().m380a();
            a2.a(d.a.a());
            a2.c(d.f522a);
            a2.b(str);
            gu.m378a().a(a2);
        } catch (NullPointerException unused) {
        }
    }
}
