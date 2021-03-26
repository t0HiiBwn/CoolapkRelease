package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.de;
import com.xiaomi.push.dj;
import com.xiaomi.push.dn;
import com.xiaomi.push.gi;
import com.xiaomi.push.gs;
import com.xiaomi.push.gv;
import com.xiaomi.push.hi;
import com.xiaomi.push.service.o;
import java.util.HashMap;

public class c implements dn {
    @Override // com.xiaomi.push.dn
    public void a(Context context, HashMap<String, String> hashMap) {
        hi hiVar = new hi();
        hiVar.b(dj.a(context).b());
        hiVar.d(dj.a(context).c());
        hiVar.c(gs.AwakeAppResponse.S);
        hiVar.a(o.a());
        hiVar.h = hashMap;
        aq.a(context).a((aq) hiVar, gi.Notification, true, (gv) null, true);
        com.xiaomi.a.a.a.c.a("MoleInfo：　send data in app layer");
    }

    @Override // com.xiaomi.push.dn
    public void b(Context context, HashMap<String, String> hashMap) {
        MiTinyDataClient.upload("category_awake_app", "wake_up_app", 1, de.a(hashMap));
        com.xiaomi.a.a.a.c.a("MoleInfo：　send data in app layer");
    }

    @Override // com.xiaomi.push.dn
    public void c(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.a.a.a.c.a("MoleInfo：　" + de.b(hashMap));
        String str = hashMap.get("awake_info");
        if (String.valueOf(1007).equals(hashMap.get("event_type"))) {
            n.a(context, str);
        }
    }
}
