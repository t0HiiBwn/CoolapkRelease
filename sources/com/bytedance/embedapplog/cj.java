package com.bytedance.embedapplog;

import android.content.Context;
import android.os.SystemProperties;
import android.util.Base64;
import android.util.Log;
import com.bytedance.embed_dr.VivoIdentifier;
import com.bytedance.embedapplog.cf;

final class cj implements cf {
    private static final String a = a("cGVyc2lzdC5zeXMuaWRlbnRpZmllcmlkLnN1cHBvcnRlZA==");
    private static final bs<Boolean> b = new bs<Boolean>() {
        /* class com.bytedance.embedapplog.cj.AnonymousClass1 */

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            return Boolean.valueOf("1".equals(cj.b(cj.a, "0")));
        }
    };
    private VivoIdentifier c;

    cj(Context context) {
        try {
            co.a(context);
        } catch (Throwable unused) {
        }
        try {
            VivoIdentifier vivoIdentifier = new VivoIdentifier();
            this.c = vivoIdentifier;
            vivoIdentifier.preloadOaid(context);
        } catch (Throwable th) {
            bx.b("OaidVivo", Log.getStackTraceString(th));
        }
    }

    static boolean a() {
        return b.b(new Object[0]).booleanValue();
    }

    @Override // com.bytedance.embedapplog.cf
    public boolean a(Context context) {
        return a();
    }

    @Override // com.bytedance.embedapplog.cf
    public cf.a b(Context context) {
        VivoIdentifier vivoIdentifier = this.c;
        if (vivoIdentifier == null) {
            return null;
        }
        return vivoIdentifier.getOaid(context);
    }

    /* access modifiers changed from: private */
    public static String b(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static String a(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 2));
        } catch (Exception unused) {
            return "";
        }
    }
}
