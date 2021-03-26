package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.as;

class au extends XMPushService.i {
    final /* synthetic */ as.b.c a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    au(as.b.c cVar, int i) {
        super(i);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo632a() {
        if (this.a.a == this.a.f975a.f962a) {
            b.b("clean peer, chid = " + this.a.f975a.g);
            this.a.f975a.f962a = null;
        }
    }
}
