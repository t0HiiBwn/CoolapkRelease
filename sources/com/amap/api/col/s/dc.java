package com.amap.api.col.s;

import android.content.Context;

/* compiled from: OfflineLocEntity */
public final class dc {
    private Context a;
    private br b;
    private String c;

    final byte[] a() {
        return bs.a(a(this.a, this.b, this.c));
    }

    private static String a(Context context, br brVar, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(brVar.d());
            sb.append("\",\"product\":\"");
            sb.append(brVar.b());
            sb.append("\",\"nt\":\"");
            sb.append(bm.d(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }
}
