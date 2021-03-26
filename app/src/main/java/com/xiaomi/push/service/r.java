package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ft;
import com.xiaomi.push.hy;
import com.xiaomi.push.service.XMPushService;

final class r extends XMPushService.i {
    final /* synthetic */ hy a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1032a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    r(int i, XMPushService xMPushService, hy hyVar) {
        super(i);
        this.f1032a = xMPushService;
        this.a = hyVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "send ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo668a() {
        try {
            x.a(this.f1032a, p.a((Context) this.f1032a, this.a));
        } catch (ft e) {
            b.a(e);
            this.f1032a.a(10, e);
        }
    }
}
