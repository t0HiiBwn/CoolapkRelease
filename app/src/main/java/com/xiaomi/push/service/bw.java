package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.as;

class bw implements as.a {
    final /* synthetic */ XMPushService a;

    bw(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.as.a
    public void a() {
        XMPushService.a(this.a);
        if (as.a().m623a() <= 0) {
            XMPushService xMPushService = this.a;
            xMPushService.a(new XMPushService.f(12, null));
        }
    }
}
