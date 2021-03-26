package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.hc;
import com.xiaomi.push.hm;
import com.xiaomi.push.i;
import com.xiaomi.push.ib;
import com.xiaomi.push.im;
import com.xiaomi.push.service.bj;
import java.util.HashMap;

final class y extends bj.a {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ k f1046a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    y(String str, long j, XMPushService xMPushService, k kVar) {
        super(str, j);
        this.a = xMPushService;
        this.f1046a = kVar;
    }

    @Override // com.xiaomi.push.service.bj.a
    void a(bj bjVar) {
        String a2 = bjVar.a("GAID", "gaid");
        String a3 = i.a((Context) this.a);
        b.c("gaid :" + a3);
        if (!TextUtils.isEmpty(a3) && !TextUtils.equals(a2, a3)) {
            bjVar.a("GAID", "gaid", a3);
            ib ibVar = new ib();
            ibVar.b(this.f1046a.d);
            ibVar.c(hm.ClientInfoUpdate.f576a);
            ibVar.a(aq.a());
            ibVar.a(new HashMap());
            ibVar.m481a().put("gaid", a3);
            byte[] a4 = im.a(x.a(this.a.getPackageName(), this.f1046a.d, ibVar, hc.Notification));
            XMPushService xMPushService = this.a;
            xMPushService.a(xMPushService.getPackageName(), a4, true);
        }
    }
}
