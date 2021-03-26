package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.security.PublicKey;

/* compiled from: ClientInfo */
public final class bl {
    public static String a(Context context, String str, String str2) {
        try {
            String e = bi.e(context);
            return bq.a(e + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            cd.a(th, "CI", "Sco");
            return null;
        }
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = "1";
            if (!bi.a()) {
                str = "0";
            }
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            cd.a(th, "CI", "TS");
            return null;
        }
    }

    public static byte[] a(Context context, boolean z) {
        try {
            return a(b(context, z));
        } catch (Throwable th) {
            cd.a(th, "CI", "gz");
            return null;
        }
    }

    public static String a(Context context) {
        try {
            return bn.b(a(b(context, false)));
        } catch (Throwable th) {
            cd.a(th, "CI", "gCXi");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c8 A[SYNTHETIC, Splitter:B:20:0x00c8] */
    private static byte[] a(a aVar) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                a(byteArrayOutputStream, aVar.a);
                a(byteArrayOutputStream, aVar.b);
                a(byteArrayOutputStream, aVar.c);
                a(byteArrayOutputStream, aVar.d);
                a(byteArrayOutputStream, aVar.e);
                a(byteArrayOutputStream, aVar.f);
                a(byteArrayOutputStream, aVar.g);
                a(byteArrayOutputStream, aVar.h);
                a(byteArrayOutputStream, aVar.i);
                a(byteArrayOutputStream, aVar.j);
                a(byteArrayOutputStream, aVar.k);
                a(byteArrayOutputStream, aVar.l);
                a(byteArrayOutputStream, aVar.m);
                a(byteArrayOutputStream, aVar.n);
                a(byteArrayOutputStream, aVar.o);
                a(byteArrayOutputStream, aVar.p);
                a(byteArrayOutputStream, aVar.q);
                a(byteArrayOutputStream, aVar.r);
                a(byteArrayOutputStream, aVar.s);
                a(byteArrayOutputStream, aVar.t);
                a(byteArrayOutputStream, aVar.u);
                a(byteArrayOutputStream, aVar.v);
                a(byteArrayOutputStream, aVar.w);
                a(byteArrayOutputStream, aVar.x);
                a(byteArrayOutputStream, aVar.y);
                byte[] b = bs.b(byteArrayOutputStream.toByteArray());
                PublicKey d = bs.d();
                if (b.length > 117) {
                    byte[] bArr2 = new byte[117];
                    System.arraycopy(b, 0, bArr2, 0, 117);
                    byte[] a2 = bn.a(bArr2, d);
                    bArr = new byte[((b.length + 128) - 117)];
                    System.arraycopy(a2, 0, bArr, 0, 128);
                    System.arraycopy(b, 117, bArr, 128, b.length - 117);
                } else {
                    bArr = bn.a(b, d);
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                try {
                    cd.a(th, "CI", "gzx");
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream = null;
            cd.a(th, "CI", "gzx");
            if (byteArrayOutputStream != null) {
            }
            return null;
        }
        throw th;
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        byte b;
        if (!TextUtils.isEmpty(str)) {
            if (str.getBytes().length > 255) {
                b = -1;
            } else {
                b = (byte) str.getBytes().length;
            }
            bs.a(byteArrayOutputStream, b, bs.a(str));
            return;
        }
        bs.a(byteArrayOutputStream, (byte) 0, new byte[0]);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0054: INVOKE  (r4v0 int) = (r5v0 android.content.Context) type: STATIC call: com.amap.api.col.s.bm.p(android.content.Context):int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0066: INVOKE  (r4v1 int) = (r5v0 android.content.Context) type: STATIC call: com.amap.api.col.s.bm.o(android.content.Context):int)] */
    private static a b(Context context, boolean z) {
        a aVar = new a((byte) 0);
        aVar.a = bm.t(context);
        aVar.b = bm.m(context);
        String h = bm.h(context);
        if (h == null) {
            h = "";
        }
        aVar.c = h;
        aVar.d = bi.c(context);
        aVar.e = Build.MODEL;
        aVar.f = Build.MANUFACTURER;
        aVar.g = Build.DEVICE;
        aVar.h = bi.b(context);
        aVar.i = bi.d(context);
        aVar.j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.k = bm.v(context);
        aVar.l = bm.q(context);
        StringBuilder sb = new StringBuilder();
        sb.append(bm.p(context));
        aVar.m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bm.o(context));
        aVar.n = sb2.toString();
        aVar.o = bm.x(context);
        aVar.p = bm.n(context);
        aVar.q = bm.l(context);
        aVar.r = bm.k(context);
        String[] d = bm.d();
        aVar.s = d[0];
        aVar.t = d[1];
        aVar.w = bm.a();
        String a2 = bm.a(context);
        if (!TextUtils.isEmpty(a2)) {
            aVar.x = a2;
        } else {
            aVar.x = "";
        }
        aVar.y = "aid=" + bm.j(context);
        if ((z && cc.d) || cc.e) {
            String g = bm.g(context);
            if (!TextUtils.isEmpty(g)) {
                aVar.y += "|oaid=" + g;
            }
        }
        String a3 = bm.a(context, ",");
        if (!TextUtils.isEmpty(a3)) {
            aVar.y += "|multiImeis=" + a3;
        }
        String u = bm.u(context);
        if (!TextUtils.isEmpty(u)) {
            aVar.y += "|meid=" + u;
        }
        aVar.y += "|serial=" + bm.i(context);
        String b = bm.b();
        if (!TextUtils.isEmpty(b)) {
            aVar.y += "|adiuExtras=" + b;
        }
        aVar.y += "|storage=" + bm.e() + "|ram=" + bm.w(context) + "|arch=" + bm.f();
        return aVar;
    }

    /* compiled from: ClientInfo */
    private static class a {
        String a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        String l;
        String m;
        String n;
        String o;
        String p;
        String q;
        String r;
        String s;
        String t;
        String u;
        String v;
        String w;
        String x;
        String y;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
