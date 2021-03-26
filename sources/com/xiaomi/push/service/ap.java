package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

class ap extends XMPushService.i {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ap(XMPushService xMPushService, int i) {
        super(i);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        if (this.a.n != null) {
            this.a.n.b(15, (Exception) null);
            this.a.n = null;
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "disconnect for service destroy.";
    }
}
