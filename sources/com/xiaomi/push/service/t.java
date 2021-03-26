package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.q;

class t extends XMPushService.i {
    final /* synthetic */ q.b.c a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    t(q.b.c cVar, int i) {
        super(i);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (q.a().b(this.a.a.h, this.a.a.b).o == null) {
            q.b.this.t.a(this.a.a.h, this.a.a.b, 2, null, null);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "check peer job";
    }
}
