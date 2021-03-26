package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.as;

class av extends XMPushService.i {
    final /* synthetic */ as.b.c a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    av(as.b.c cVar, int i) {
        super(i);
        this.a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "check peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo633a() {
        if (as.a().a(this.a.f975a.g, this.a.f975a.f971b).f962a == null) {
            as.b.this.f964a.a(this.a.f975a.g, this.a.f975a.f971b, 2, null, null);
        }
    }
}
