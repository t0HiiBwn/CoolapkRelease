package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.gi;
import com.xiaomi.push.gs;
import com.xiaomi.push.hi;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.ai;
import com.xiaomi.push.v;
import java.util.HashMap;

final class bw extends ai.a {
    final /* synthetic */ XMPushService c;
    final /* synthetic */ bi d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bw(String str, long j, XMPushService xMPushService, bi biVar) {
        super(str, j);
        this.c = xMPushService;
        this.d = biVar;
    }

    @Override // com.xiaomi.push.service.ai.a
    void a(ai aiVar) {
        v a = v.a(this.c);
        String a2 = aiVar.a("MSAID", "msaid");
        String str = a.b() + a.c() + a.d() + a.e();
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(a2, str)) {
            aiVar.a("MSAID", "msaid", str);
            hi hiVar = new hi();
            hiVar.b(this.d.d);
            hiVar.c(gs.ClientInfoUpdate.S);
            hiVar.a(o.a());
            hiVar.a(new HashMap());
            a.a(hiVar.j());
            byte[] a3 = ht.a(bu.a(this.c.getPackageName(), this.d.d, hiVar, gi.Notification));
            XMPushService xMPushService = this.c;
            xMPushService.a(xMPushService.getPackageName(), a3, true);
        }
    }
}
