package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.g;
import com.xiaomi.push.service.as;
import com.xiaomi.push.t;
import java.util.Locale;

public class k {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final String f1024a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public k(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f1024a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.a = i;
    }

    public static boolean a() {
        try {
            return t.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
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

    public as.b a(XMPushService xMPushService) {
        as.b bVar = new as.b(xMPushService);
        a(bVar, xMPushService, xMPushService.b(), "c");
        return bVar;
    }

    public as.b a(as.b bVar, Context context, d dVar, String str) {
        bVar.f968a = context.getPackageName();
        bVar.f971b = this.f1024a;
        bVar.h = this.c;
        bVar.c = this.b;
        bVar.g = "5";
        bVar.d = "XMPUSH-PASS";
        bVar.f970a = false;
        bVar.e = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s:%7$s:%8$s,%9$s:%10$s,%11$s:%12$s", "sdk_ver", 41, "cpvn", "3_7_9", "cpvc", 30709, "aapn", b(context) ? g.b(context) : "", "country_code", a.a(context).b(), "region", a.a(context).a());
        bVar.f = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s,sync:1", "appid", b(context) ? "1000271" : this.d, "locale", Locale.getDefault().toString(), "miid", t.a(context));
        if (a(context)) {
            bVar.f += String.format(",%1$s:%2$s", "ab", str);
        }
        bVar.f967a = dVar;
        return bVar;
    }
}
