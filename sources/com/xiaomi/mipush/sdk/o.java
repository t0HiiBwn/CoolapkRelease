package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gi;
import com.xiaomi.push.gv;
import com.xiaomi.push.hi;
import com.xiaomi.push.j;

final class o extends j.a {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hi f157a;

    o(hi hiVar, Context context) {
        this.f157a = hiVar;
        this.a = context;
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        hi hiVar = this.f157a;
        if (hiVar != null) {
            hiVar.a(com.xiaomi.push.service.o.a());
            aq.a(this.a.getApplicationContext()).a((aq) this.f157a, gi.Notification, true, (gv) null, true);
        }
    }
}
