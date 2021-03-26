package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.de;
import com.xiaomi.push.dj;
import com.xiaomi.push.dn;
import com.xiaomi.push.gg;
import com.xiaomi.push.gi;
import com.xiaomi.push.gs;
import com.xiaomi.push.hi;
import com.xiaomi.push.ht;
import java.util.HashMap;

public class w implements dn {
    @Override // com.xiaomi.push.dn
    public void a(Context context, HashMap<String, String> hashMap) {
        hi hiVar = new hi();
        hiVar.b(dj.a(context).b());
        hiVar.d(dj.a(context).c());
        hiVar.c(gs.AwakeAppResponse.S);
        hiVar.a(o.a());
        hiVar.h = hashMap;
        byte[] a = ht.a(bu.a(hiVar.l(), hiVar.e(), hiVar, gi.Notification));
        if (context instanceof XMPushService) {
            c.a("MoleInfo : send data directly in pushLayer " + hiVar.c());
            ((XMPushService) context).a(context.getPackageName(), a, true);
            return;
        }
        c.a("MoleInfo : context is not correct in pushLayer " + hiVar.c());
    }

    @Override // com.xiaomi.push.dn
    public void b(Context context, HashMap<String, String> hashMap) {
        gg a = gg.a(context);
        if (a != null) {
            a.a("category_awake_app", "wake_up_app", 1, de.a(hashMap));
        }
    }

    @Override // com.xiaomi.push.dn
    public void c(Context context, HashMap<String, String> hashMap) {
        c.a("MoleInfo：　" + de.b(hashMap));
    }
}
