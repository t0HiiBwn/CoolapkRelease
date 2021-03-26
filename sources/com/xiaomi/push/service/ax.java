package com.xiaomi.push.service;

import com.xiaomi.push.aa;
import com.xiaomi.push.service.XMPushService;

class ax extends XMPushService.i {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ax(XMPushService xMPushService, int i) {
        super(i);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        bu.a(this.a);
        if (aa.c(this.a)) {
            this.a.a(true);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "prepare the mi push account.";
    }
}
