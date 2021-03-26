package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

class fr extends XMPushService.i {
    final /* synthetic */ fp a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Exception f481a;
    final /* synthetic */ int b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    fr(fp fpVar, int i, int i2, Exception exc) {
        super(i);
        this.a = fpVar;
        this.b = i2;
        this.f481a = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "shutdown the connection. " + this.b + ", " + this.f481a;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo345a() {
        this.a.b.a(this.b, this.f481a);
    }
}
