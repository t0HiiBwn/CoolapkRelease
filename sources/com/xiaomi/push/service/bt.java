package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ey;
import com.xiaomi.push.hf;
import com.xiaomi.push.service.XMPushService;

final class bt extends XMPushService.i {
    final /* synthetic */ XMPushService a;
    final /* synthetic */ hf b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bt(int i, XMPushService xMPushService, hf hfVar, String str, String str2) {
        super(i);
        this.a = xMPushService;
        this.b = hfVar;
        this.c = str;
        this.d = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            hf a2 = bn.a((Context) this.a, this.b);
            a2.h.a("error", this.c);
            a2.h.a("reason", this.d);
            bu.a(this.a, a2);
        } catch (ey e) {
            c.a(e);
            this.a.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "send wrong message ack for message.";
    }
}
