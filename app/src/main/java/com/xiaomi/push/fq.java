package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

class fq extends XMPushService.i {
    final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ fp f480a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    fq(fp fpVar, int i, long j) {
        super(i);
        this.f480a = fpVar;
        this.a = j;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "check the ping-pong." + this.a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo344a() {
        Thread.yield();
        if (this.f480a.c() && !this.f480a.a(this.a)) {
            this.f480a.b.a(22, (Exception) null);
        }
    }
}
