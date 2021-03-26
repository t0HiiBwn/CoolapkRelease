package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.ab;
import com.xiaomi.push.fj;
import com.xiaomi.push.service.XMPushService;

class cb extends XMPushService.i {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f1010a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f1011a;
    final /* synthetic */ int b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cb(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        super(i);
        this.a = xMPushService;
        this.b = i2;
        this.f1011a = bArr;
        this.f1010a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "clear account cache.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo649a() {
        l.m661a((Context) this.a);
        as.a().m628a("5");
        ab.a(this.b);
        XMPushService.a(this.a).c(fj.a());
        this.a.a(this.f1011a, this.f1010a);
    }
}
