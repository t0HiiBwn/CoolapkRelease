package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ai;
import com.xiaomi.push.hc;
import com.xiaomi.push.hp;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.aq;

final class o extends ai.a {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ib f175a;

    o(ib ibVar, Context context) {
        this.f175a = ibVar;
        this.a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo141a() {
        return "22";
    }

    @Override // java.lang.Runnable
    public void run() {
        ib ibVar = this.f175a;
        if (ibVar != null) {
            ibVar.a(aq.a());
            ak.a(this.a.getApplicationContext()).a((ak) this.f175a, hc.Notification, true, (hp) null, true);
        }
    }
}
