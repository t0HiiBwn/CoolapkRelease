package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ft;
import com.xiaomi.push.service.XMPushService;

class br extends XMPushService.i {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f1006a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f1007a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    br(XMPushService xMPushService, int i, String str, byte[] bArr) {
        super(i);
        this.a = xMPushService;
        this.f1006a = str;
        this.f1007a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "send mi push message";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo645a() {
        try {
            x.a(this.a, this.f1006a, this.f1007a);
        } catch (ft e) {
            b.a(e);
            this.a.a(10, e);
        }
    }
}
