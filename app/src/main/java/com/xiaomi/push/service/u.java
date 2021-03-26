package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ft;
import com.xiaomi.push.hy;
import com.xiaomi.push.service.XMPushService;

final class u extends XMPushService.i {
    final /* synthetic */ hy a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1040a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f1041a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    u(int i, XMPushService xMPushService, hy hyVar, String str) {
        super(i);
        this.f1040a = xMPushService;
        this.a = hyVar;
        this.f1041a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "send app absent ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo671a() {
        try {
            hy a2 = p.a((Context) this.f1040a, this.a);
            a2.m456a().a("absent_target_package", this.f1041a);
            x.a(this.f1040a, a2);
        } catch (ft e) {
            b.a(e);
            this.f1040a.a(10, e);
        }
    }
}
