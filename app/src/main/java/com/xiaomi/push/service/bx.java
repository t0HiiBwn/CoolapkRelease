package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;

class bx extends ContentObserver {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bx(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        boolean a2 = XMPushService.a(this.a);
        b.m41a("ExtremePowerMode:" + a2);
        if (a2) {
            XMPushService xMPushService = this.a;
            xMPushService.a(new XMPushService.f(23, null));
            return;
        }
        this.a.a(true);
    }
}
