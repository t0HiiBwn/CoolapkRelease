package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.dd;
import com.xiaomi.push.service.q;
import java.util.HashMap;

class ee {
    public static void a(q.b bVar, String str, em emVar) {
        String str2;
        dd.c cVar = new dd.c();
        if (!TextUtils.isEmpty(bVar.c)) {
            cVar.a(bVar.c);
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            cVar.d(bVar.f);
        }
        if (!TextUtils.isEmpty(bVar.g)) {
            cVar.e(bVar.g);
        }
        cVar.b(bVar.e ? "1" : "0");
        if (!TextUtils.isEmpty(bVar.d)) {
            cVar.c(bVar.d);
        } else {
            cVar.c("XIAOMI-SASL");
        }
        ef efVar = new ef();
        efVar.c(bVar.b);
        efVar.a(Integer.parseInt(bVar.h));
        efVar.b(bVar.a);
        efVar.a("BIND", (String) null);
        efVar.a(efVar.h());
        c.a("[Slim]: bind id=" + efVar.h());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.c);
        hashMap.put("chid", bVar.h);
        hashMap.put("from", bVar.b);
        hashMap.put("id", efVar.h());
        hashMap.put("to", "xiaomi.com");
        if (bVar.e) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            hashMap.put("client_attrs", bVar.f);
        } else {
            hashMap.put("client_attrs", "");
        }
        if (!TextUtils.isEmpty(bVar.g)) {
            hashMap.put("cloud_attrs", bVar.g);
        } else {
            hashMap.put("cloud_attrs", "");
        }
        if (bVar.d.equals("XIAOMI-PASS") || bVar.d.equals("XMPUSH-PASS")) {
            str2 = af.a(bVar.d, null, hashMap, bVar.i);
        } else {
            bVar.d.equals("XIAOMI-SASL");
            str2 = null;
        }
        cVar.f(str2);
        efVar.a(cVar.c(), (String) null);
        emVar.b(efVar);
    }

    public static void a(String str, String str2, em emVar) {
        ef efVar = new ef();
        efVar.c(str2);
        efVar.a(Integer.parseInt(str));
        efVar.a("UBND", (String) null);
        emVar.b(efVar);
    }
}
