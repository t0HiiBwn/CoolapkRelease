package com.xiaomi.push.service;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.q;

class s extends XMPushService.i {
    final /* synthetic */ q.b.c a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    s(q.b.c cVar, int i) {
        super(i);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (this.a.b == this.a.a.o) {
            c.b("clean peer, chid = " + this.a.a.h);
            this.a.a.o = null;
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "clear peer job";
    }
}
