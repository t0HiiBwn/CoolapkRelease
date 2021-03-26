package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.ax;
import com.xiaomi.push.hc;
import com.xiaomi.push.hm;
import com.xiaomi.push.ib;
import com.xiaomi.push.im;
import com.xiaomi.push.service.bj;
import java.util.HashMap;

final class z extends bj.a {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ k f1047a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    z(String str, long j, XMPushService xMPushService, k kVar) {
        super(str, j);
        this.a = xMPushService;
        this.f1047a = kVar;
    }

    @Override // com.xiaomi.push.service.bj.a
    void a(bj bjVar) {
        ax a2 = ax.a(this.a);
        String a3 = bjVar.a("MSAID", "msaid");
        String str = a2.mo105a() + a2.mo106b() + a2.c() + a2.d();
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(a3, str)) {
            bjVar.a("MSAID", "msaid", str);
            ib ibVar = new ib();
            ibVar.b(this.f1047a.d);
            ibVar.c(hm.ClientInfoUpdate.f576a);
            ibVar.a(aq.a());
            ibVar.a(new HashMap());
            a2.a(ibVar.m481a());
            byte[] a4 = im.a(x.a(this.a.getPackageName(), this.f1047a.d, ibVar, hc.Notification));
            XMPushService xMPushService = this.a;
            xMPushService.a(xMPushService.getPackageName(), a4, true);
        }
    }
}
