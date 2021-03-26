package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ft;
import com.xiaomi.push.hy;
import com.xiaomi.push.service.XMPushService;

final class v extends XMPushService.i {
    final /* synthetic */ hy a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1042a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f1043a;
    final /* synthetic */ String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    v(int i, XMPushService xMPushService, hy hyVar, String str, String str2) {
        super(i);
        this.f1042a = xMPushService;
        this.a = hyVar;
        this.f1043a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo672a() {
        try {
            hy a2 = p.a((Context) this.f1042a, this.a);
            a2.f697a.a("error", this.f1043a);
            a2.f697a.a("reason", this.b);
            x.a(this.f1042a, a2);
        } catch (ft e) {
            b.a(e);
            this.f1042a.a(10, e);
        }
    }
}
