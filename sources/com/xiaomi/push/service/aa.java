package com.xiaomi.push.service;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ga;
import com.xiaomi.push.service.XMPushService;

class aa {
    private static int f = 300000;
    private XMPushService a;
    private int b;
    private long c;
    private int d = 0;
    private int e = 0;

    public aa(XMPushService xMPushService) {
        this.a = xMPushService;
        this.b = 500;
        this.c = 0;
    }

    private int b() {
        if (this.d > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i = this.d;
        if (i > 4) {
            return (int) (random * 60000.0d);
        }
        if (i > 1) {
            return (int) (random * 10000.0d);
        }
        if (this.c == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.c < 310000) {
            int i2 = this.b;
            int i3 = f;
            if (i2 >= i3) {
                return i2;
            }
            int i4 = this.e + 1;
            this.e = i4;
            if (i4 >= 4) {
                return i3;
            }
            this.b = (int) (((double) i2) * 1.5d);
            return i2;
        }
        this.b = 1000;
        this.e = 0;
        return 0;
    }

    public void a() {
        this.c = System.currentTimeMillis();
        this.a.a(1);
        this.d = 0;
    }

    public void a(boolean z) {
        if (!this.a.b()) {
            c.c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.a.b(1)) {
                this.d++;
            }
            this.a.a(1);
            XMPushService xMPushService = this.a;
            xMPushService.getClass();
            xMPushService.a(new XMPushService.d());
        } else if (!this.a.b(1)) {
            int b2 = b();
            this.d++;
            c.a("schedule reconnect in " + b2 + "ms");
            XMPushService xMPushService2 = this.a;
            xMPushService2.getClass();
            xMPushService2.a(new XMPushService.d(), (long) b2);
            if (this.d == 2 && ga.a().c()) {
                e.b();
            }
            if (this.d == 3) {
                e.a();
            }
        }
    }
}
