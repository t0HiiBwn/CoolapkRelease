package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

class bs extends XMPushService.i {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bs(XMPushService xMPushService, int i) {
        super(i);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "disconnect for service destroy.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo646a() {
        if (this.a.f902a != null) {
            this.a.f902a.b(15, (Exception) null);
            this.a.f902a = null;
        }
    }
}
