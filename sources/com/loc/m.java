package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.security.PublicKey;

/* compiled from: ClientInfo */
public final class m {

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

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = "1";
            if (!k.a()) {
                str = "0";
            }
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            y.a(th, "CI", "TS");
            return null;
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            String e = k.e(context);
            return r.a(e + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            y.a(th, "CI", "Sco");
            return null;
        }
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            u.a(byteArrayOutputStream, str.getBytes().length > 255 ? -1 : (byte) str.getBytes().length, u.a(str));
        } else {
            u.a(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0054: INVOKE  (r4v0 int) = (r5v0 android.content.Context) type: STATIC call: com.loc.n.q(android.content.Context):int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0066: INVOKE  (r4v1 int) = (r5v0 android.content.Context) type: STATIC call: com.loc.n.p(android.content.Context):int)] */
    public static byte[] a(Context context, boolean z, boolean z2) {
        try {
            a aVar = new a((byte) 0);
            aVar.a = n.x(context);
            aVar.b = n.m(context);
            String h = n.h(context);
            if (h == null) {
                h = "";
            }
            aVar.c = h;
            aVar.d = k.c(context);
            aVar.e = Build.MODEL;
            aVar.f = Build.MANUFACTURER;
            aVar.g = Build.DEVICE;
            aVar.h = k.b(context);
            aVar.i = k.d(context);
            aVar.j = String.valueOf(Build.VERSION.SDK_INT);
            aVar.k = n.A(context);
            aVar.l = n.t(context);
            StringBuilder sb = new StringBuilder();
            sb.append(n.q(context));
            aVar.m = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(n.p(context));
            aVar.n = sb2.toString();
            aVar.o = n.C(context);
            aVar.p = n.o(context);
            if (z) {
                aVar.q = "";
            } else {
                aVar.q = n.l(context);
            }
            if (z) {
                aVar.r = "";
            } else {
                aVar.r = n.k(context);
            }
            if (z) {
                aVar.s = "";
                aVar.t = "";
            } else {
                String[] c = n.c();
                aVar.s = c[0];
                aVar.t = c[1];
            }
            aVar.w = n.a();
            String a2 = n.a(context);
            if (!TextUtils.isEmpty(a2)) {
                aVar.x = a2;
            } else {
                aVar.x = "";
            }
            aVar.y = "aid=" + n.j(context);
            if ((z2 && v.d) || v.e) {
                String g = n.g(context);
                if (!TextUtils.isEmpty(g)) {
                    aVar.y += "|oaid=" + g;
                }
            }
            String a3 = n.a(context, ",");
            if (!TextUtils.isEmpty(a3)) {
                aVar.y += "|multiImeis=" + a3;
            }
            String z3 = n.z(context);
            if (!TextUtils.isEmpty(z3)) {
                aVar.y += "|meid=" + z3;
            }
            aVar.y += "|serial=" + n.i(context);
            String b = n.b();
            if (!TextUtils.isEmpty(b)) {
                aVar.y += "|adiuExtras=" + b;
            }
            aVar.y += "|storage=" + n.d() + "|ram=" + n.B(context) + "|arch=" + n.e();
            return a(aVar);
        } catch (Throwable th) {
            y.a(th, "CI", "gz");
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
                byte[] b = u.b(byteArrayOutputStream.toByteArray());
                PublicKey d = u.d();
                if (b.length > 117) {
                    byte[] bArr2 = new byte[117];
                    System.arraycopy(b, 0, bArr2, 0, 117);
                    byte[] a2 = o.a(bArr2, d);
                    bArr = new byte[((b.length + 128) - 117)];
                    System.arraycopy(a2, 0, bArr, 0, 128);
                    System.arraycopy(b, 117, bArr, 128, b.length - 117);
                } else {
                    bArr = o.a(b, d);
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
                    y.a(th, "CI", "gzx");
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
            y.a(th, "CI", "gzx");
            if (byteArrayOutputStream != null) {
            }
            return null;
        }
        throw th;
    }
}
