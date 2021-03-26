package com.xiaomi.push.service;

import com.xiaomi.push.c;
import com.xiaomi.push.en;
import com.xiaomi.push.service.XMPushService;

class az extends XMPushService.i {
    final /* synthetic */ int a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ String c;
    final /* synthetic */ XMPushService d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    az(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        super(i);
        this.d = xMPushService;
        this.a = i2;
        this.b = bArr;
        this.c = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        bj.c(this.d);
        q.a().a("5");
        c.a(this.a);
        this.d.d.c(en.a());
        this.d.a(this.b, this.c);
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "clear account cache.";
    }
}
