package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

class ew extends XMPushService.i {
    final /* synthetic */ int a;
    final /* synthetic */ Exception b;
    final /* synthetic */ et c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ew(et etVar, int i, int i2, Exception exc) {
        super(i);
        this.c = etVar;
        this.a = i2;
        this.b = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        this.c.r.a(this.a, this.b);
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "shutdown the connection. " + this.a + ", " + this.b;
    }
}
