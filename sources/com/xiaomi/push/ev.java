package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

class ev extends XMPushService.i {
    final /* synthetic */ long a;
    final /* synthetic */ et b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ev(et etVar, int i, long j) {
        super(i);
        this.b = etVar;
        this.a = j;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        Thread.yield();
        if (this.b.j() && !this.b.a(this.a)) {
            this.b.r.a(22, (Exception) null);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "check the ping-pong." + this.a;
    }
}
