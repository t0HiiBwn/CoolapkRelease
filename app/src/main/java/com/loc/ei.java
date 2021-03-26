package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.loc.l;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AuthUtil */
public final class ei {
    private static boolean A = true;
    private static int B = 80;
    private static boolean C = false;
    private static boolean D = true;
    private static boolean E = false;
    private static boolean F = true;
    private static long G = -1;
    private static boolean H = true;
    private static int I = 1;
    private static boolean J = true;
    private static int K = 5;
    private static boolean L = false;
    private static String M = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
    private static long N = 0;
    static long a = 3600000;
    public static volatile long b = 0;
    static boolean c = true;
    public static boolean d = false;
    public static boolean e = false;
    public static int f = 20480;
    public static int g = 10800000;
    private static volatile boolean h = false;
    private static boolean i = true;
    private static int j = 1000;
    private static int k = 200;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f1375l = false;
    private static int m = 20;
    private static int n = 0;
    private static volatile int o = 0;
    private static boolean p = true;
    private static boolean q = true;
    private static int r = -1;
    private static long s;
    private static ArrayList<String> t = new ArrayList<>();
    private static ArrayList<String> u = new ArrayList<>();
    private static volatile boolean v = false;
    private static boolean w = true;
    private static long x = 300000;
    private static boolean y = false;
    private static double z = 0.618d;

    public static void a(final Context context) {
        if (!h) {
            h = true;
            l.a(context, ej.c(), ej.d(), new l.a() {
                /* class com.loc.ei.AnonymousClass1 */

                @Override // com.loc.l.a
                public final void a(l.b bVar) {
                    ei.a(context, bVar);
                }
            });
        }
    }

    public static boolean a() {
        return i;
    }

    public static boolean a(long j2) {
        if (!w) {
            return false;
        }
        long a2 = ep.a() - j2;
        long j3 = x;
        return j3 < 0 || a2 < j3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x0246 A[Catch:{ all -> 0x0274 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x032c A[SYNTHETIC, Splitter:B:145:0x032c] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0333 A[SYNTHETIC, Splitter:B:153:0x0333] */
    /* JADX WARNING: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01cd A[Catch:{ all -> 0x01f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0200 A[Catch:{ all -> 0x023e }] */
    static boolean a(Context context, l.b bVar) {
        SharedPreferences.Editor editor;
        String str;
        JSONObject jSONObject;
        String str2;
        int parseInt;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONArray optJSONArray;
        JSONObject optJSONObject3;
        Throwable th;
        Throwable th2;
        try {
            editor = eo.a(context, "pref");
            try {
                l.b.a aVar = bVar.g;
                if (aVar != null) {
                    boolean z2 = aVar.a;
                    i = z2;
                    eo.a(editor, "exception", z2);
                    JSONObject jSONObject2 = aVar.c;
                    if (jSONObject2 != null) {
                        j = jSONObject2.optInt("fn", j);
                        int optInt = jSONObject2.optInt("mpn", k);
                        k = optInt;
                        if (optInt > 500) {
                            k = 500;
                        }
                        if (k < 30) {
                            k = 30;
                        }
                        f1375l = l.a(jSONObject2.optString("igu"), f1375l);
                        m = jSONObject2.optInt("ms", m);
                        o = jSONObject2.optInt("rot", 0);
                        n = jSONObject2.optInt("pms", 0);
                    }
                    str = "c";
                    try {
                        ba.a(j, f1375l, m, n);
                        bc.a(f1375l, n);
                        eo.a(editor, "fn", j);
                        eo.a(editor, "mpn", k);
                        eo.a(editor, "igu", f1375l);
                        eo.a(editor, "ms", m);
                        eo.a(editor, "rot", o);
                        eo.a(editor, "pms", n);
                    } catch (Throwable th3) {
                        th2 = th3;
                    }
                } else {
                    str = "c";
                }
            } catch (Throwable th4) {
                th2 = th4;
                str = "c";
                try {
                    ej.a(th2, "AuthUtil", "loadConfigDataUploadException");
                    c(context);
                    jSONObject = bVar.f;
                    if (jSONObject != null) {
                    }
                } catch (Throwable unused) {
                    if (editor != null) {
                    }
                }
            }
            c(context);
            jSONObject = bVar.f;
            if (jSONObject != null) {
                if (editor != null) {
                    try {
                        eo.a(editor);
                    } catch (Throwable unused2) {
                    }
                }
                return true;
            }
            try {
                JSONObject optJSONObject4 = jSONObject.optJSONObject("13S");
                if (optJSONObject4 != null) {
                    try {
                        long optInt2 = (long) (optJSONObject4.optInt("at", 123) * 60 * 1000);
                        a = optInt2;
                        eo.a(editor, "13S_at", optInt2);
                    } catch (Throwable th5) {
                        ej.a(th5, "AuthUtil", "requestSdkAuthInterval");
                    }
                    if (optJSONObject4 != null) {
                        try {
                            boolean a2 = l.a(optJSONObject4.optString("re"), c);
                            c = a2;
                            eo.a(editor, "fr", a2);
                        } catch (Throwable th6) {
                            ej.a(th6, "AuthUtil", "checkReLocationAble");
                        }
                    }
                    try {
                        boolean a3 = l.a(optJSONObject4.optString("nla"), D);
                        D = a3;
                        eo.a(editor, "13S_nla", a3);
                    } catch (Throwable unused3) {
                    }
                    try {
                        boolean a4 = l.a(optJSONObject4.optString("asw"), F);
                        F = a4;
                        eo.a(editor, "asw", a4);
                    } catch (Throwable unused4) {
                    }
                    try {
                        JSONArray optJSONArray2 = optJSONObject4.optJSONArray("mlpl");
                        if (optJSONArray2 == null || optJSONArray2.length() <= 0 || context == null) {
                            E = false;
                            eo.a(editor, "13S_mlpl");
                        } else {
                            eo.a(editor, "13S_mlpl", u.b(optJSONArray2.toString()));
                            E = a(context, optJSONArray2);
                        }
                    } catch (Throwable unused5) {
                    }
                }
            } catch (Throwable th7) {
                ej.a(th7, "AuthUtil", "loadConfigAbleStatus");
            }
            try {
                JSONObject optJSONObject5 = jSONObject.optJSONObject("11G");
                if (optJSONObject5 != null) {
                    boolean a5 = l.a(optJSONObject5.optString("able"), w);
                    w = a5;
                    if (a5) {
                        str2 = str;
                        try {
                            x = (long) (optJSONObject5.optInt(str2, 300) * 1000);
                        } catch (Throwable th8) {
                            th = th8;
                            ej.a(th, "AuthUtil", "loadConfigDataCacheAble");
                            optJSONObject3 = jSONObject.optJSONObject("13J");
                            if (optJSONObject3 != null) {
                            }
                            optJSONObject2 = jSONObject.optJSONObject("15O");
                            if (optJSONObject2 != null) {
                            }
                            optJSONObject = jSONObject.optJSONObject("15U");
                            if (optJSONObject != null) {
                            }
                            if (jSONObject != null) {
                            }
                            if (jSONObject != null) {
                            }
                            if (editor != null) {
                            }
                            return true;
                        }
                    } else {
                        str2 = str;
                    }
                    y = l.a(optJSONObject5.optString("fa"), y);
                    z = Math.min(1.0d, Math.max(0.2d, optJSONObject5.optDouble("ms")));
                    eo.a(editor, "ca", w);
                    eo.a(editor, "ct", x);
                    eo.a(editor, "11G_fa", y);
                    eo.a(editor, "11G_ms", String.valueOf(z));
                } else {
                    str2 = str;
                }
            } catch (Throwable th9) {
                th = th9;
                str2 = str;
                ej.a(th, "AuthUtil", "loadConfigDataCacheAble");
                optJSONObject3 = jSONObject.optJSONObject("13J");
                if (optJSONObject3 != null) {
                }
                optJSONObject2 = jSONObject.optJSONObject("15O");
                if (optJSONObject2 != null) {
                }
                optJSONObject = jSONObject.optJSONObject("15U");
                if (optJSONObject != null) {
                }
                if (jSONObject != null) {
                }
                if (jSONObject != null) {
                }
                if (editor != null) {
                }
                return true;
            }
            try {
                optJSONObject3 = jSONObject.optJSONObject("13J");
                if (optJSONObject3 != null) {
                    boolean a6 = l.a(optJSONObject3.optString("able"), A);
                    A = a6;
                    if (a6) {
                        B = optJSONObject3.optInt(str2, B);
                    }
                    eo.a(editor, "13J_able", A);
                    eo.a(editor, "13J_c", B);
                }
            } catch (Throwable th10) {
                ej.a(th10, "AuthUtil", "loadConfigDataGpsGeoAble");
            }
            try {
                optJSONObject2 = jSONObject.optJSONObject("15O");
                if (optJSONObject2 != null) {
                    if (!l.a(optJSONObject2.optString("able"), false) || ((optJSONArray = optJSONObject2.optJSONArray("fl")) != null && optJSONArray.length() > 0 && !optJSONArray.toString().contains(Build.MANUFACTURER))) {
                        G = -1;
                    } else {
                        G = (long) (optJSONObject2.optInt("iv", 30) * 1000);
                    }
                    eo.a(editor, "awsi", G);
                }
            } catch (Throwable unused6) {
            }
            try {
                optJSONObject = jSONObject.optJSONObject("15U");
                if (optJSONObject != null) {
                    boolean a7 = l.a(optJSONObject.optString("able"), H);
                    int optInt3 = optJSONObject.optInt("yn", I);
                    N = optJSONObject.optLong("sysTime", N);
                    eo.a(editor, "15ua", a7);
                    eo.a(editor, "15un", optInt3);
                    eo.a(editor, "15ust", N);
                }
            } catch (Throwable unused7) {
            }
            if (jSONObject != null) {
                try {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("17Y");
                    if (jSONObject3 != null) {
                        boolean a8 = l.a(jSONObject3.optString("able"), d);
                        d = a8;
                        eo.a(editor, "17ya", a8);
                        boolean a9 = l.a(jSONObject3.optString("mup"), e);
                        e = a9;
                        eo.a(editor, "17ym", a9);
                        int optInt4 = jSONObject3.optInt("max", 20);
                        if (optInt4 > 0) {
                            eo.a(editor, "17yx", optInt4);
                            f = optInt4 * 1024;
                        }
                        int optInt5 = jSONObject3.optInt("inv", 3);
                        if (optInt5 > 0) {
                            eo.a(editor, "17yi", optInt5);
                            g = optInt5 * 60 * 60 * 1000;
                        }
                    }
                } catch (Throwable unused8) {
                }
            }
            if (jSONObject != null) {
                try {
                    JSONObject optJSONObject6 = jSONObject.optJSONObject("17J");
                    if (optJSONObject6 != null) {
                        boolean a10 = l.a(optJSONObject6.optString("able"), false);
                        J = a10;
                        eo.a(editor, "ok9", a10);
                        if (a10) {
                            String optString = optJSONObject6.optString("auth");
                            String optString2 = optJSONObject6.optString("ht");
                            M = optString2;
                            eo.a(editor, "ok11", optString2);
                            l.a(optString, false);
                            L = l.a(optJSONObject6.optString("nr"), false);
                            String optString3 = optJSONObject6.optString("tm");
                            if (!TextUtils.isEmpty(optString3) && (parseInt = Integer.parseInt(optString3)) > 0 && parseInt < 20) {
                                K = parseInt;
                                eo.a(editor, "ok10", parseInt);
                            }
                        }
                    }
                } catch (Throwable unused9) {
                }
            }
            if (editor != null) {
                try {
                    eo.a(editor);
                } catch (Throwable unused10) {
                }
            }
            return true;
        } catch (Throwable unused11) {
            editor = null;
            if (editor != null) {
                return false;
            }
            try {
                eo.a(editor);
                return false;
            } catch (Throwable unused12) {
                return false;
            }
        }
    }

    private static boolean a(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0 && context != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        if (ep.b(context, jSONArray.getString(i2))) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static int b() {
        return k;
    }

    public static void b(Context context) {
        if (!v) {
            v = true;
            try {
                i = eo.a(context, "pref", "exception", i);
                c(context);
            } catch (Throwable th) {
                ej.a(th, "AuthUtil", "loadLastAbleState p1");
            }
            try {
                j = eo.a(context, "pref", "fn", j);
                k = eo.a(context, "pref", "mpn", k);
                f1375l = eo.a(context, "pref", "igu", f1375l);
                m = eo.a(context, "pref", "ms", m);
                o = eo.a(context, "pref", "rot", 0);
                int a2 = eo.a(context, "pref", "pms", 0);
                n = a2;
                ba.a(j, f1375l, m, a2);
                bc.a(f1375l, n);
            } catch (Throwable unused) {
            }
            try {
                w = eo.a(context, "pref", "ca", w);
                x = eo.a(context, "pref", "ct", x);
                y = eo.a(context, "pref", "11G_fa", y);
                double doubleValue = Double.valueOf(eo.a(context, "pref", "11G_ms", String.valueOf(z))).doubleValue();
                z = doubleValue;
                z = Math.max(0.2d, doubleValue);
            } catch (Throwable unused2) {
            }
            try {
                c = eo.a(context, "pref", "fr", c);
            } catch (Throwable unused3) {
            }
            try {
                F = eo.a(context, "pref", "asw", F);
            } catch (Throwable unused4) {
            }
            try {
                G = eo.a(context, "pref", "awsi", G);
            } catch (Throwable unused5) {
            }
            try {
                H = eo.a(context, "pref", "15ua", H);
                I = eo.a(context, "pref", "15un", I);
                N = eo.a(context, "pref", "15ust", N);
            } catch (Throwable unused6) {
            }
            try {
                J = eo.a(context, "pref", "ok9", J);
                K = eo.a(context, "pref", "ok10", K);
                M = eo.a(context, "pref", "ok11", M);
            } catch (Throwable unused7) {
            }
            try {
                d = eo.a(context, "pref", "17ya", false);
                e = eo.a(context, "pref", "17ym", false);
                g = eo.a(context, "pref", "17yi", 2) * 60 * 60 * 1000;
                f = eo.a(context, "pref", "17yx", 100) * 1024;
            } catch (Throwable unused8) {
            }
            try {
                b = ep.b();
                a = eo.a(context, "pref", "13S_at", a);
                D = eo.a(context, "pref", "13S_nla", D);
                A = eo.a(context, "pref", "13J_able", A);
                B = eo.a(context, "pref", "13J_c", B);
            } catch (Throwable unused9) {
            }
            l.b(context);
            try {
                String a3 = eo.a(context, "pref", "13S_mlpl", (String) null);
                if (!TextUtils.isEmpty(a3)) {
                    E = a(context, new JSONArray(u.c(a3)));
                }
            } catch (Throwable unused10) {
            }
        }
    }

    public static int c() {
        if (o < 0) {
            o = 0;
        }
        return o;
    }

    public static void c(Context context) {
        try {
            t c2 = ej.c();
            c2.a(i);
            ab.a(context, c2);
        } catch (Throwable unused) {
        }
    }

    public static long d() {
        return x;
    }

    public static boolean e() {
        return w;
    }

    public static boolean f() {
        return y;
    }

    public static double g() {
        return z;
    }

    public static boolean h() {
        return A;
    }

    public static int i() {
        return B;
    }

    public static boolean j() {
        return D;
    }

    public static boolean k() {
        return E;
    }

    public static boolean l() {
        return c;
    }

    public static boolean m() {
        return F;
    }

    public static long n() {
        return G;
    }

    public static boolean o() {
        return L;
    }

    public static boolean p() {
        return J;
    }

    public static int q() {
        return K;
    }

    public static String r() {
        return u.c(M);
    }

    public static boolean s() {
        return H && I > 0;
    }

    public static int t() {
        return I;
    }

    public static long u() {
        return N;
    }
}
