package com.xiaomi.push.service;

import com.xiaomi.push.service.q;

final class bx implements q.b.a {
    final /* synthetic */ XMPushService a;

    bx(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.q.b.a
    public void a(q.c cVar, q.c cVar2, int i) {
        if (cVar2 == q.c.binded) {
            bm.a(this.a);
            bm.b(this.a);
        } else if (cVar2 == q.c.unbind) {
            bm.a(this.a, 70000001, " the push is not connected.");
        }
    }
}
