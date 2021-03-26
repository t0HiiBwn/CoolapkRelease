package com.xiaomi.push.service;

import com.xiaomi.push.bc;
import com.xiaomi.push.service.XMPushService;

class bz extends XMPushService.i {
    final /* synthetic */ XMPushService a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bz(XMPushService xMPushService, int i) {
        super(i);
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "prepare the mi push account.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo647a() {
        x.a(this.a);
        if (bc.b(this.a)) {
            this.a.a(true);
        }
    }
}
