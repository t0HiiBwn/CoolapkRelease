package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;

class by extends ContentObserver {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    by(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        boolean b = XMPushService.b(this.a);
        b.m41a("SuperPowerMode:" + b);
        XMPushService.a(this.a);
        if (b) {
            XMPushService xMPushService = this.a;
            xMPushService.a(new XMPushService.f(24, null));
            return;
        }
        this.a.a(true);
    }
}
