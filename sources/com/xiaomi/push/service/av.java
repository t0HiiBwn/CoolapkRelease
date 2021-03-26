package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.XMPushService;

class av extends ContentObserver {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    av(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        boolean z2 = this.a.p();
        c.a("ExtremePowerMode:" + z2);
        if (z2) {
            XMPushService xMPushService = this.a;
            xMPushService.a(new XMPushService.f(23, null));
            return;
        }
        this.a.a(true);
    }
}
