package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bj;

class ay implements bj.a {
    final /* synthetic */ XMPushService.i a;
    final /* synthetic */ XMPushService b;

    ay(XMPushService xMPushService, XMPushService.i iVar) {
        this.b = xMPushService;
        this.a = iVar;
    }

    @Override // com.xiaomi.push.service.bj.a
    public void a() {
        this.b.a(this.a);
    }
}
