package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;

public class gt implements fl {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f523a = 0;

    /* renamed from: a  reason: collision with other field name */
    fi f524a;

    /* renamed from: a  reason: collision with other field name */
    XMPushService f525a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f526a;

    /* renamed from: a  reason: collision with other field name */
    private String f527a;
    private long b = 0;
    private long c = 0;
    private long d = 0;
    private long e = 0;
    private long f = 0;

    gt(XMPushService xMPushService) {
        this.f525a = xMPushService;
        this.f527a = "";
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            b.m41a("Failed to obtain traffic data during initialization: " + e2);
            this.f = -1;
            this.e = -1;
        }
    }

    private void b() {
        this.b = 0;
        this.d = 0;
        this.f523a = 0;
        this.c = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (bc.b(this.f525a)) {
            this.f523a = elapsedRealtime;
        }
        if (this.f525a.m588c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        b.c("stat connpt = " + this.f527a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        ey eyVar = new ey();
        eyVar.f423a = 0;
        eyVar.a(ex.CHANNEL_ONLINE_RATE.a());
        eyVar.a(this.f527a);
        eyVar.d((int) (System.currentTimeMillis() / 1000));
        eyVar.b((int) (this.b / 1000));
        eyVar.c((int) (this.d / 1000));
        gu.m378a().a(eyVar);
        b();
    }

    Exception a() {
        return this.f526a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m377a() {
        XMPushService xMPushService = this.f525a;
        if (xMPushService != null) {
            String a2 = bc.m129a((Context) xMPushService);
            boolean b2 = bc.b(this.f525a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.f523a;
            if (j > 0) {
                this.b += elapsedRealtime - j;
                this.f523a = 0;
            }
            long j2 = this.c;
            if (j2 != 0) {
                this.d += elapsedRealtime - j2;
                this.c = 0;
            }
            if (b2) {
                if ((!TextUtils.equals(this.f527a, a2) && this.b > 30000) || this.b > 5400000) {
                    c();
                }
                this.f527a = a2;
                if (this.f523a == 0) {
                    this.f523a = elapsedRealtime;
                }
                if (this.f525a.m588c()) {
                    this.c = elapsedRealtime;
                }
            }
        }
    }

    @Override // com.xiaomi.push.fl
    public void a(fi fiVar) {
        m377a();
        this.c = SystemClock.elapsedRealtime();
        gw.a(0, ex.CONN_SUCCESS.a(), fiVar.m331a(), fiVar.mo328a());
    }

    @Override // com.xiaomi.push.fl
    public void a(fi fiVar, int i, Exception exc) {
        long j;
        if (this.a == 0 && this.f526a == null) {
            this.a = i;
            this.f526a = exc;
            gw.b(fiVar.m331a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long a2 = fiVar.a() - this.c;
            if (a2 < 0) {
                a2 = 0;
            }
            this.d += a2 + ((long) (fo.b() / 2));
            this.c = 0;
        }
        m377a();
        int myUid = Process.myUid();
        long j2 = -1;
        try {
            j2 = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            b.m41a("Failed to obtain traffic data: " + e2);
            j = -1;
        }
        b.c("Stats rx=" + (j2 - this.f) + ", tx=" + (j - this.e));
        this.f = j2;
        this.e = j;
    }

    @Override // com.xiaomi.push.fl
    public void a(fi fiVar, Exception exc) {
        gw.a(0, ex.CHANNEL_CON_FAIL.a(), 1, fiVar.m331a(), bc.b(this.f525a) ? 1 : 0);
        m377a();
    }

    @Override // com.xiaomi.push.fl
    public void b(fi fiVar) {
        this.a = 0;
        this.f526a = null;
        this.f524a = fiVar;
        this.f527a = bc.m129a((Context) this.f525a);
        gw.a(0, ex.CONN_SUCCESS.a());
    }
}
