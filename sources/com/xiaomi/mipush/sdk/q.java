package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ch;
import com.xiaomi.push.gi;
import com.xiaomi.push.gv;
import com.xiaomi.push.hi;

public class q implements ch {
    private Context a;

    public q(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.ch
    public String a() {
        return b.m54a(this.a).d();
    }

    @Override // com.xiaomi.push.ch
    public void a(hi hiVar, gi giVar, gv gvVar) {
        aq.a(this.a).a((aq) hiVar, giVar, gvVar);
    }
}
