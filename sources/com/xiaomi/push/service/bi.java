package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.eu;
import com.xiaomi.push.jb;
import com.xiaomi.push.service.q;
import java.util.Locale;

public class bi {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;

    public bi(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = i;
    }

    public static boolean a() {
        try {
            return jb.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    private static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public q.b a(XMPushService xMPushService) {
        q.b bVar = new q.b(xMPushService);
        a(bVar, xMPushService, xMPushService.e(), "c");
        return bVar;
    }

    public q.b a(q.b bVar, Context context, bb bbVar, String str) {
        bVar.a = context.getPackageName();
        bVar.b = this.a;
        bVar.i = this.c;
        bVar.c = this.b;
        bVar.h = "5";
        bVar.d = "XMPUSH-PASS";
        bVar.e = false;
        bVar.f = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s:%7$s:%8$s,%9$s:%10$s,%11$s:%12$s", "sdk_ver", 39, "cpvn", "3_7_5", "cpvc", 30705, "aapn", b(context) ? eu.b(context) : "", "country_code", a.a(context).b(), "region", a.a(context).a());
        bVar.g = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s,sync:1", "appid", b(context) ? "1000271" : this.d, "locale", Locale.getDefault().toString(), "miid", jb.c(context));
        if (a(context)) {
            bVar.g += String.format(",%1$s:%2$s", "ab", str);
        }
        bVar.k = bbVar;
        return bVar;
    }
}
