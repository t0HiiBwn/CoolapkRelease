package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ey;
import com.xiaomi.push.hf;
import com.xiaomi.push.service.XMPushService;

final class bq extends XMPushService.i {
    final /* synthetic */ XMPushService a;
    final /* synthetic */ hf b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bq(int i, XMPushService xMPushService, hf hfVar) {
        super(i);
        this.a = xMPushService;
        this.b = hfVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            hf a2 = bn.a((Context) this.a, this.b);
            a2.m().a("message_obsleted", "1");
            bu.a(this.a, a2);
        } catch (ey e) {
            c.a(e);
            this.a.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "send ack message for obsleted message.";
    }
}
