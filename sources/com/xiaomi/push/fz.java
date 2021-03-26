package com.xiaomi.push;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.XMPushService;

public class fz implements ep {
    XMPushService a;
    em b;
    private int c;
    private Exception d;
    private String e;
    private long f = 0;
    private long g = 0;
    private long h = 0;
    private long i = 0;
    private long j = 0;
    private long k = 0;

    fz(XMPushService xMPushService) {
        this.a = xMPushService;
        this.e = "";
        c();
        int myUid = Process.myUid();
        try {
            this.k = TrafficStats.getUidRxBytes(myUid);
            this.j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            c.a("Failed to obtain traffic data during initialization: " + e2);
            this.k = -1;
            this.j = -1;
        }
    }

    private void c() {
        this.g = 0;
        this.i = 0;
        this.f = 0;
        this.h = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (aa.c(this.a)) {
            this.f = elapsedRealtime;
        }
        if (this.a.f()) {
            this.h = elapsedRealtime;
        }
    }

    private synchronized void d() {
        c.c("stat connpt = " + this.e + " netDuration = " + this.g + " ChannelDuration = " + this.i + " channelConnectedTime = " + this.h);
        ec ecVar = new ec();
        ecVar.a = 0;
        ecVar.a(eb.CHANNEL_ONLINE_RATE.a());
        ecVar.a(this.e);
        ecVar.d((int) (System.currentTimeMillis() / 1000));
        ecVar.b((int) (this.g / 1000));
        ecVar.c((int) (this.i / 1000));
        ga.a().a(ecVar);
        c();
    }

    Exception a() {
        return this.d;
    }

    @Override // com.xiaomi.push.ep
    public void a(em emVar) {
        b();
        this.h = SystemClock.elapsedRealtime();
        gc.a(0, eb.CONN_SUCCESS.a(), emVar.e(), emVar.k());
    }

    @Override // com.xiaomi.push.ep
    public void a(em emVar, int i2, Exception exc) {
        long j2;
        if (this.c == 0 && this.d == null) {
            this.c = i2;
            this.d = exc;
            gc.b(emVar.e(), exc);
        }
        if (i2 == 22 && this.h != 0) {
            long g2 = emVar.g() - this.h;
            if (g2 < 0) {
                g2 = 0;
            }
            this.i += g2 + ((long) (es.c() / 2));
            this.h = 0;
        }
        b();
        int myUid = Process.myUid();
        long j3 = -1;
        try {
            j3 = TrafficStats.getUidRxBytes(myUid);
            j2 = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            c.a("Failed to obtain traffic data: " + e2);
            j2 = -1;
        }
        c.c("Stats rx=" + (j3 - this.k) + ", tx=" + (j2 - this.j));
        this.k = j3;
        this.j = j2;
    }

    @Override // com.xiaomi.push.ep
    public void a(em emVar, Exception exc) {
        gc.a(0, eb.CHANNEL_CON_FAIL.a(), 1, emVar.e(), aa.c(this.a) ? 1 : 0);
        b();
    }

    public synchronized void b() {
        XMPushService xMPushService = this.a;
        if (xMPushService != null) {
            String k2 = aa.k(xMPushService);
            boolean c2 = aa.c(this.a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = this.f;
            if (j2 > 0) {
                this.g += elapsedRealtime - j2;
                this.f = 0;
            }
            long j3 = this.h;
            if (j3 != 0) {
                this.i += elapsedRealtime - j3;
                this.h = 0;
            }
            if (c2) {
                if ((!TextUtils.equals(this.e, k2) && this.g > 30000) || this.g > 5400000) {
                    d();
                }
                this.e = k2;
                if (this.f == 0) {
                    this.f = elapsedRealtime;
                }
                if (this.a.f()) {
                    this.h = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.push.ep
    public void b(em emVar) {
        this.c = 0;
        this.d = null;
        this.b = emVar;
        this.e = aa.k(this.a);
        gc.a(0, eb.CONN_SUCCESS.a());
    }
}
