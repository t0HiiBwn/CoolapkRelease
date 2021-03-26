package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Log */
public final class z {
    public static final String a = "/a/";
    static final String b = "b";
    static final String c = "c";
    static final String d = "d";
    public static String e = "s";
    public static final String f = "g";
    public static final String g = "h";
    public static final String h = "e";
    public static final String i = "f";
    public static final String j = "j";
    public static final String k = "k";

    /* renamed from: l  reason: collision with root package name */
    private static long f1384l;
    private static Vector<t> m = new Vector<>();

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    static List<t> a() {
        Vector<t> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = m;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return m;
        }
    }

    public static void a(final Context context) {
        try {
            if (System.currentTimeMillis() - f1384l >= 60000) {
                f1384l = System.currentTimeMillis();
                ExecutorService d2 = ab.d();
                if (d2 == null) {
                    return;
                }
                if (!d2.isShutdown()) {
                    d2.submit(new Runnable() {
                        /* class com.loc.z.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                ac.b(context);
                                ac.d(context);
                                ac.c(context);
                                bc.a(context);
                                ba.a(context);
                            } catch (RejectedExecutionException unused) {
                            } catch (Throwable th) {
                                ab.b(th, "Lg", "proL");
                            }
                        }
                    });
                }
            }
        } catch (Throwable th) {
            ab.b(th, "Lg", "proL");
        }
    }

    public static void a(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void a(t tVar) {
        try {
            synchronized (Looper.getMainLooper()) {
                if (tVar != null) {
                    if (!m.contains(tVar)) {
                        m.add(tVar);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    static boolean a(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            try {
                String[] split = str.split("\n");
                int length = split.length;
                int i2 = 0;
                while (true) {
                    boolean z = true;
                    if (i2 < length) {
                        String trim = split[i2].trim();
                        if (TextUtils.isEmpty(trim) || !trim.startsWith("at ") || !trim.contains("uncaughtException")) {
                            z = false;
                        }
                        if (z) {
                            return false;
                        }
                        i2++;
                    } else {
                        for (String str2 : split) {
                            if (b(strArr, str2.trim())) {
                                return true;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static void b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
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

    public static String c(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + a + str;
    }
}
