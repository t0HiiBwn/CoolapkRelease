package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.l;

class ca implements l.a {
    final /* synthetic */ XMPushService.i a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1009a;

    ca(XMPushService xMPushService, XMPushService.i iVar) {
        this.f1009a = xMPushService;
        this.a = iVar;
    }

    @Override // com.xiaomi.push.service.l.a
    public void a() {
        this.f1009a.a(this.a);
    }
}
