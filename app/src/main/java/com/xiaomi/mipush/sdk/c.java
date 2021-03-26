package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dx;
import com.xiaomi.push.ec;
import com.xiaomi.push.eg;
import com.xiaomi.push.hc;
import com.xiaomi.push.hm;
import com.xiaomi.push.hp;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.aq;
import java.util.HashMap;

public class c implements eg {
    @Override // com.xiaomi.push.eg
    public void a(Context context, HashMap<String, String> hashMap) {
        ib ibVar = new ib();
        ibVar.b(ec.a(context).m290a());
        ibVar.d(ec.a(context).b());
        ibVar.c(hm.AwakeAppResponse.f576a);
        ibVar.a(aq.a());
        ibVar.f717a = hashMap;
        ak.a(context).a((ak) ibVar, hc.Notification, true, (hp) null, true);
        b.m41a("MoleInfo：　send data in app layer");
    }

    @Override // com.xiaomi.push.eg
    public void b(Context context, HashMap<String, String> hashMap) {
        MiTinyDataClient.upload("category_awake_app", "wake_up_app", 1, dx.a(hashMap));
        b.m41a("MoleInfo：　send data in app layer");
    }

    @Override // com.xiaomi.push.eg
    public void c(Context context, HashMap<String, String> hashMap) {
        b.m41a("MoleInfo：　" + dx.b(hashMap));
        String str = hashMap.get("awake_info");
        if (String.valueOf(1007).equals(hashMap.get("event_type"))) {
            n.a(context, str);
        }
    }
}
