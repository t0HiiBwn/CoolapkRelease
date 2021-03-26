package com.xiaomi.push.service;

import com.xiaomi.push.service.as;

final class aa implements as.b.a {
    final /* synthetic */ XMPushService a;

    aa(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.as.b.a
    public void a(as.c cVar, as.c cVar2, int i) {
        if (cVar2 == as.c.binded) {
            o.a(this.a);
            o.b(this.a);
        } else if (cVar2 == as.c.unbind) {
            o.a(this.a, 70000001, " the push is not connected.");
        }
    }
}
