package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

class gq extends XMPushService.i {
    final /* synthetic */ gp a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    gq(gp gpVar, int i) {
        super(i);
        this.a = gpVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "Handling bind stats";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo375a() {
        gp.a(this.a);
    }
}
