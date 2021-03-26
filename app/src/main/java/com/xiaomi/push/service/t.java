package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ft;
import com.xiaomi.push.hy;
import com.xiaomi.push.service.XMPushService;

final class t extends XMPushService.i {
    final /* synthetic */ hy a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1039a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    t(int i, XMPushService xMPushService, hy hyVar) {
        super(i);
        this.f1039a = xMPushService;
        this.a = hyVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "send ack message for unrecognized new miui message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo670a() {
        try {
            hy a2 = p.a((Context) this.f1039a, this.a);
            a2.m456a().a("miui_message_unrecognized", "1");
            x.a(this.f1039a, a2);
        } catch (ft e) {
            b.a(e);
            this.f1039a.a(10, e);
        }
    }
}
