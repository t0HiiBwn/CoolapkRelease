package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ft;
import com.xiaomi.push.hy;
import com.xiaomi.push.service.XMPushService;

final class q extends XMPushService.i {
    final /* synthetic */ hy a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1031a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    q(int i, XMPushService xMPushService, hy hyVar) {
        super(i);
        this.f1031a = xMPushService;
        this.a = hyVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "send app absent message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo667a() {
        try {
            x.a(this.f1031a, x.a(this.a.b(), this.a.m457a()));
        } catch (ft e) {
            b.a(e);
            this.f1031a.a(10, e);
        }
    }
}
