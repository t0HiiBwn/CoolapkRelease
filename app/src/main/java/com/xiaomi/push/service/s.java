package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ft;
import com.xiaomi.push.hy;
import com.xiaomi.push.service.XMPushService;

final class s extends XMPushService.i {
    final /* synthetic */ hy a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1038a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    s(int i, XMPushService xMPushService, hy hyVar) {
        super(i);
        this.f1038a = xMPushService;
        this.a = hyVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "send ack message for obsleted message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo669a() {
        try {
            hy a2 = p.a((Context) this.f1038a, this.a);
            a2.m456a().a("message_obsleted", "1");
            x.a(this.f1038a, a2);
        } catch (ft e) {
            b.a(e);
            this.f1038a.a(10, e);
        }
    }
}
