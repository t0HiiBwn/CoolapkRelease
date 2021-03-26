package com.xiaomi.push.service;

import com.xiaomi.push.fb;
import com.xiaomi.push.fn;
import com.xiaomi.push.fz;
import com.xiaomi.push.service.XMPushService;

class bq implements fn {
    final /* synthetic */ XMPushService a;

    bq(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // com.xiaomi.push.fn
    public void a(fb fbVar) {
        XMPushService xMPushService = this.a;
        xMPushService.a(new XMPushService.c(fbVar));
    }

    @Override // com.xiaomi.push.fn, com.xiaomi.push.fv
    /* renamed from: a */
    public void mo148a(fz fzVar) {
        XMPushService xMPushService = this.a;
        xMPushService.a(new XMPushService.k(fzVar));
    }
}
