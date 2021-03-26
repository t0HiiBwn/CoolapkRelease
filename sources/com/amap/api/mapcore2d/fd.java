package com.amap.api.mapcore2d;

import android.content.Context;

/* compiled from: OfflineLocEntity */
public class fd {
    private Context a;
    private da b;
    private String c;

    public fd(Context context, da daVar, String str) {
        this.a = context.getApplicationContext();
        this.b = daVar;
        this.c = str;
    }

    byte[] a() {
        return db.a(a(this.a, this.b, this.c));
    }

    private static String a(Context context, da daVar, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(daVar.c());
            sb.append("\",\"product\":\"");
            sb.append(daVar.a());
            sb.append("\",\"nt\":\"");
            sb.append(cu.e(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }
}
