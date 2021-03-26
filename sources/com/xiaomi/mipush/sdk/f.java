package com.xiaomi.mipush.sdk;

import com.xiaomi.push.gn;
import com.xiaomi.push.service.l;

class f extends l.a {
    final /* synthetic */ e a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    f(e eVar, int i, String str) {
        super(i, str);
        this.a = eVar;
    }

    @Override // com.xiaomi.push.service.l.a
    protected void onCallback() {
        boolean a2 = l.a(e.a(this.a)).a(gn.AggregatePushSwitch.a(), true);
        if (e.a(this.a) != a2) {
            this.a.f154a = a2;
            h.b(e.a(this.a));
        }
    }
}
