package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gu;
import com.xiaomi.push.service.XMPushService;

class bc {
    private static int d = 300000;
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f983a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f984a;
    private int b = 0;
    private int c = 0;

    public bc(XMPushService xMPushService) {
        this.f984a = xMPushService;
        this.a = 500;
        this.f983a = 0;
    }

    private int a() {
        if (this.b > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i = this.b;
        if (i > 4) {
            return (int) (random * 60000.0d);
        }
        if (i > 1) {
            return (int) (random * 10000.0d);
        }
        if (this.f983a == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f983a < 310000) {
            int i2 = this.a;
            int i3 = d;
            if (i2 >= i3) {
                return i2;
            }
            int i4 = this.c + 1;
            this.c = i4;
            if (i4 >= 4) {
                return i3;
            }
            this.a = (int) (((double) i2) * 1.5d);
            return i2;
        }
        this.a = 1000;
        this.c = 0;
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m637a() {
        this.f983a = System.currentTimeMillis();
        this.f984a.a(1);
        this.b = 0;
    }

    public void a(boolean z) {
        if (!this.f984a.m584a()) {
            b.c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.f984a.m585a(1)) {
                this.b++;
            }
            this.f984a.a(1);
            XMPushService xMPushService = this.f984a;
            xMPushService.getClass();
            xMPushService.a(new XMPushService.d());
        } else if (!this.f984a.m585a(1)) {
            int a2 = a();
            this.b++;
            b.m41a("schedule reconnect in " + a2 + "ms");
            XMPushService xMPushService2 = this.f984a;
            xMPushService2.getClass();
            xMPushService2.a(new XMPushService.d(), (long) a2);
            if (this.b == 2 && gu.m378a().m383a()) {
                af.b();
            }
            if (this.b == 3) {
                af.a();
            }
        }
    }
}
