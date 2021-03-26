package com.loc;

import android.content.Context;

/* compiled from: OfflineLocEntity */
public final class az {
    private Context a;
    private t b;
    private String c;

    public az(Context context, t tVar, String str) {
        this.a = context.getApplicationContext();
        this.b = tVar;
        this.c = str;
    }

    private static String a(Context context, t tVar, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(tVar.c());
            sb.append("\",\"product\":\"");
            sb.append(tVar.a());
            sb.append("\",\"nt\":\"");
            sb.append(n.d(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    final byte[] a() {
        return u.a(a(this.a, this.b, this.c));
    }
}
