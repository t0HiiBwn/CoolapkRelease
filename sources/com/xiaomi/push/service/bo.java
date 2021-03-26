package com.xiaomi.push.service;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ey;
import com.xiaomi.push.hf;
import com.xiaomi.push.service.XMPushService;

final class bo extends XMPushService.i {
    final /* synthetic */ XMPushService a;
    final /* synthetic */ hf b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bo(int i, XMPushService xMPushService, hf hfVar) {
        super(i);
        this.a = xMPushService;
        this.b = hfVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            bu.a(this.a, bu.a(this.b.j(), this.b.h()));
        } catch (ey e) {
            c.a(e);
            this.a.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "send app absent message.";
    }
}
