package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.gi;
import com.xiaomi.push.gs;
import com.xiaomi.push.gw;
import com.xiaomi.push.hi;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.ai;
import java.util.HashMap;

final class bv extends ai.a {
    final /* synthetic */ XMPushService c;
    final /* synthetic */ bi d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bv(String str, long j, XMPushService xMPushService, bi biVar) {
        super(str, j);
        this.c = xMPushService;
        this.d = biVar;
    }

    @Override // com.xiaomi.push.service.ai.a
    void a(ai aiVar) {
        String a = aiVar.a("GAID", "gaid");
        String b = gw.b(this.c);
        c.c("gaid :" + b);
        if (!TextUtils.isEmpty(b) && !TextUtils.equals(a, b)) {
            aiVar.a("GAID", "gaid", b);
            hi hiVar = new hi();
            hiVar.b(this.d.d);
            hiVar.c(gs.ClientInfoUpdate.S);
            hiVar.a(o.a());
            hiVar.a(new HashMap());
            hiVar.j().put("gaid", b);
            byte[] a2 = ht.a(bu.a(this.c.getPackageName(), this.d.d, hiVar, gi.Notification));
            XMPushService xMPushService = this.c;
            xMPushService.a(xMPushService.getPackageName(), a2, true);
        }
    }
}
