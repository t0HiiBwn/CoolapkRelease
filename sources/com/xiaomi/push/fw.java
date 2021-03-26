package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

class fw extends XMPushService.i {
    final /* synthetic */ fu a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    fw(fu fuVar, int i) {
        super(i);
        this.a = fuVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        fu.a(this.a);
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "Handling bind stats";
    }
}
