package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dx;
import com.xiaomi.push.ec;
import com.xiaomi.push.eg;
import com.xiaomi.push.ha;
import com.xiaomi.push.hc;
import com.xiaomi.push.hm;
import com.xiaomi.push.ib;
import com.xiaomi.push.im;
import java.util.HashMap;

public class ay implements eg {
    @Override // com.xiaomi.push.eg
    public void a(Context context, HashMap<String, String> hashMap) {
        ib ibVar = new ib();
        ibVar.b(ec.a(context).m290a());
        ibVar.d(ec.a(context).b());
        ibVar.c(hm.AwakeAppResponse.f576a);
        ibVar.a(aq.a());
        ibVar.f717a = hashMap;
        byte[] a = im.a(x.a(ibVar.c(), ibVar.b(), ibVar, hc.Notification));
        if (context instanceof XMPushService) {
            b.m41a("MoleInfo : send data directly in pushLayer " + ibVar.m480a());
            ((XMPushService) context).a(context.getPackageName(), a, true);
            return;
        }
        b.m41a("MoleInfo : context is not correct in pushLayer " + ibVar.m480a());
    }

    @Override // com.xiaomi.push.eg
    public void b(Context context, HashMap<String, String> hashMap) {
        ha a = ha.a(context);
        if (a != null) {
            a.a("category_awake_app", "wake_up_app", 1, dx.a(hashMap));
        }
    }

    @Override // com.xiaomi.push.eg
    public void c(Context context, HashMap<String, String> hashMap) {
        b.m41a("MoleInfo：　" + dx.b(hashMap));
    }
}
