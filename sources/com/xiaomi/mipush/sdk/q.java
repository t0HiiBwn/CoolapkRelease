package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.dg;
import com.xiaomi.push.hc;
import com.xiaomi.push.hp;
import com.xiaomi.push.ib;

public class q implements dg {
    private Context a;

    public q(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.dg
    public String a() {
        return b.m75a(this.a).d();
    }

    @Override // com.xiaomi.push.dg
    public void a(ib ibVar, hc hcVar, hp hpVar) {
        ak.a(this.a).a((ak) ibVar, hcVar, hpVar);
    }
}
