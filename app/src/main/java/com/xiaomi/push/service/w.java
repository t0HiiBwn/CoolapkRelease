package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ft;
import com.xiaomi.push.hc;
import com.xiaomi.push.hm;
import com.xiaomi.push.ht;
import com.xiaomi.push.hy;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.XMPushService;

final class w extends XMPushService.i {
    final /* synthetic */ hy a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ib f1044a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1045a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    w(int i, ib ibVar, hy hyVar, XMPushService xMPushService) {
        super(i);
        this.f1044a = ibVar;
        this.a = hyVar;
        this.f1045a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "send ack message for clear push message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo673a() {
        try {
            ht htVar = new ht();
            htVar.c(hm.CancelPushMessageACK.f576a);
            htVar.a(this.f1044a.m480a());
            htVar.a(this.f1044a.a());
            htVar.b(this.f1044a.b());
            htVar.e(this.f1044a.c());
            htVar.a(0);
            htVar.d("success clear push message.");
            x.a(this.f1045a, x.b(this.a.b(), this.a.m457a(), htVar, hc.Notification));
        } catch (ft e) {
            b.d("clear push message. " + e);
            this.f1045a.a(10, e);
        }
    }
}
