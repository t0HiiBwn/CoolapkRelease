package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.q;

class au implements q.a {
    final /* synthetic */ XMPushService a;

    au(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.q.a
    public void a() {
        this.a.s();
        if (q.a().c() <= 0) {
            XMPushService xMPushService = this.a;
            xMPushService.a(new XMPushService.f(12, null));
        }
    }
}
