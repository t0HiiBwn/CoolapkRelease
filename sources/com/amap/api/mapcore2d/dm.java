package com.amap.api.mapcore2d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Log */
public class dm {
    public static final String a = "/a/";
    static final String b = "b";
    static final String c = "c";
    static final String d = "d";
    static final String e = "i";
    public static final String f = "g";
    public static final String g = "h";
    public static final String h = "e";
    public static final String i = "f";
    public static final String j = "j";

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    public static void a(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static String a(Context context) {
        return c(context, e);
    }

    public static String c(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + a + str;
    }

    public static void b(final Context context) {
        try {
            ExecutorService d2 = Cdo.d();
            if (d2 == null) {
                return;
            }
            if (!d2.isShutdown()) {
                d2.submit(new Runnable() {
                    /* class com.amap.api.mapcore2d.dm.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            fc.a(context);
                            dp.b(context);
                            dp.d(context);
                            dp.c(context);
                            fg.a(context);
                            fe.a(context);
                        } catch (RejectedExecutionException unused) {
                        } catch (Throwable th) {
                            Cdo.c(th, "Lg", "proL");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            Cdo.c(th, "Lg", "proL");
        }
    }

    static List<da> c(Context context) {
        List<da> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                list = new dy(context, false).a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return list;
    }

    static boolean a(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            try {
                for (String str2 : str.split("\n")) {
                    String trim = str2.trim();
                    if (a(trim)) {
                        return false;
                    }
                    if (b(strArr, trim)) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("uncaughtException")) {
            return true;
        }
        return false;
    }

    static boolean b(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            try {
                for (String str2 : strArr) {
                    str = str.trim();
                    if (str.startsWith("at ")) {
                        if (str.contains(str2 + ".") && str.endsWith(")") && !str.contains("uncaughtException")) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }
}
