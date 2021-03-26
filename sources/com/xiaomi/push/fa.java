package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dw;
import com.xiaomi.push.service.as;
import java.util.HashMap;

class fa {
    public static void a(as.b bVar, String str, fi fiVar) {
        String str2;
        dw.c cVar = new dw.c();
        if (!TextUtils.isEmpty(bVar.c)) {
            cVar.a(bVar.c);
        }
        if (!TextUtils.isEmpty(bVar.e)) {
            cVar.d(bVar.e);
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            cVar.e(bVar.f);
        }
        cVar.b(bVar.f970a ? "1" : "0");
        if (!TextUtils.isEmpty(bVar.d)) {
            cVar.c(bVar.d);
        } else {
            cVar.c("XIAOMI-SASL");
        }
        fb fbVar = new fb();
        fbVar.c(bVar.f971b);
        fbVar.a(Integer.parseInt(bVar.g));
        fbVar.b(bVar.f968a);
        fbVar.a("BIND", (String) null);
        fbVar.a(fbVar.e());
        b.m41a("[Slim]: bind id=" + fbVar.e());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.c);
        hashMap.put("chid", bVar.g);
        hashMap.put("from", bVar.f971b);
        hashMap.put("id", fbVar.e());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f970a) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (!TextUtils.isEmpty(bVar.e)) {
            hashMap.put("client_attrs", bVar.e);
        } else {
            hashMap.put("client_attrs", "");
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            hashMap.put("cloud_attrs", bVar.f);
        } else {
            hashMap.put("cloud_attrs", "");
        }
        if (bVar.d.equals("XIAOMI-PASS") || bVar.d.equals("XMPUSH-PASS")) {
            str2 = bg.a(bVar.d, null, hashMap, bVar.h);
        } else {
            bVar.d.equals("XIAOMI-SASL");
            str2 = null;
        }
        cVar.f(str2);
        fbVar.a(cVar.mo211a(), (String) null);
        fiVar.b(fbVar);
    }

    public static void a(String str, String str2, fi fiVar) {
        fb fbVar = new fb();
        fbVar.c(str2);
        fbVar.a(Integer.parseInt(str));
        fbVar.a("UBND", (String) null);
        fiVar.b(fbVar);
    }
}
