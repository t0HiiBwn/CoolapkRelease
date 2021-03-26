package com.xiaomi.push.service;

import com.xiaomi.push.ef;
import com.xiaomi.push.er;
import com.xiaomi.push.fe;
import com.xiaomi.push.service.XMPushService;

class an implements er {
    final /* synthetic */ XMPushService a;

    an(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.er
    public void a(ef efVar) {
        XMPushService xMPushService = this.a;
        xMPushService.a(new XMPushService.c(efVar));
    }

    @Override // com.xiaomi.push.er
    public void b(fe feVar) {
        XMPushService xMPushService = this.a;
        xMPushService.a(new XMPushService.k(feVar));
    }
}
