package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hh;
import com.xiaomi.push.service.an;

class f extends an.a {
    final /* synthetic */ e a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    f(e eVar, int i, String str) {
        super(i, str);
        this.a = eVar;
    }

    @Override // com.xiaomi.push.service.an.a
    protected void onCallback() {
        boolean a2 = an.a(e.a(this.a)).a(hh.AggregatePushSwitch.a(), true);
        if (e.a(this.a) != a2) {
            this.a.f172a = a2;
            h.b(e.a(this.a));
        }
    }
}
