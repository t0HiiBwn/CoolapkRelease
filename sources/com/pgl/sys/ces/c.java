package com.pgl.sys.ces;

import android.content.Context;
import com.pgl.sys.ces.a.a;
import java.security.MessageDigest;
import java.util.Calendar;

public final class c {
    public static String a() {
        try {
            Context applicationContext = b.a().b != null ? b.a().b : a.b().getApplicationContext();
            return com.pgl.a.b.a.a(MessageDigest.getInstance("SHA1").digest(applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 64).signatures[0].toByteArray())).toUpperCase();
        } catch (Throwable unused) {
            return "0000000000000000000000000000000000000000";
        }
    }

    public static String a(String str) {
        int timeInMillis = (int) (Calendar.getInstance().getTimeInMillis() / 1000);
        b.a();
        String b = b.b();
        String c = b.c();
        try {
            return com.pgl.a.b.a.a((byte[]) a.meta(601, null, (str + "_" + b + "_" + c + "_" + timeInMillis).getBytes()));
        } catch (Throwable unused) {
            return "";
        }
    }
}
