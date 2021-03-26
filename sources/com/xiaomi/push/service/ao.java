package com.xiaomi.push.service;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ey;
import com.xiaomi.push.service.XMPushService;

class ao extends XMPushService.i {
    final /* synthetic */ String a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ XMPushService c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ao(XMPushService xMPushService, int i, String str, byte[] bArr) {
        super(i);
        this.c = xMPushService;
        this.a = str;
        this.b = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            bu.a(this.c, this.a, this.b);
        } catch (ey e) {
            c.a(e);
            this.c.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "send mi push message";
    }
}
