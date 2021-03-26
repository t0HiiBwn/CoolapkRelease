package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ey;
import com.xiaomi.push.hf;
import com.xiaomi.push.service.XMPushService;

final class bs extends XMPushService.i {
    final /* synthetic */ XMPushService a;
    final /* synthetic */ hf b;
    final /* synthetic */ String c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bs(int i, XMPushService xMPushService, hf hfVar, String str) {
        super(i);
        this.a = xMPushService;
        this.b = hfVar;
        this.c = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            hf a2 = bn.a((Context) this.a, this.b);
            a2.m().a("absent_target_package", this.c);
            bu.a(this.a, a2);
        } catch (ey e) {
            c.a(e);
            this.a.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "send app absent ack message for message.";
    }
}
