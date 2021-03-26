package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Log */
public final class ce {
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
    private static long l;
    private static Vector<br> m = new Vector<>();

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

    public static String c(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + a + str;
    }

    public static void a(final Context context) {
        try {
            if (System.currentTimeMillis() - l >= 60000) {
                l = System.currentTimeMillis();
                ExecutorService c2 = cg.c();
                if (c2 == null) {
                    return;
                }
                if (!c2.isShutdown()) {
                    c2.submit(new Runnable() {
                        /* class com.amap.api.col.s.ce.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                ch.b(context);
                                ch.d(context);
                                ch.c(context);
                                df.a(context);
                                dd.a(context);
                            } catch (RejectedExecutionException unused) {
                            } catch (Throwable th) {
                                cg.c(th, "Lg", "proL");
                            }
                        }
                    });
                }
            }
        } catch (Throwable th) {
            cg.c(th, "Lg", "proL");
        }
    }

    public static void a(br brVar) {
        try {
            synchronized (Looper.getMainLooper()) {
                if (brVar != null) {
                    if (!m.contains(brVar)) {
                        m.add(brVar);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    static List<br> a() {
        Vector<br> vector;
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
