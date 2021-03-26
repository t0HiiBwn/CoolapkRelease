package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: ClientInfo */
public class ct {
    public static String a(Context context, String str, String str2) {
        try {
            String e = cq.e(context);
            return cx.b(e + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            dl.a(th, "CI", "Sco");
            return null;
        }
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = "1";
            if (!cq.a()) {
                str = "0";
            }
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            dl.a(th, "CI", "TS");
            return null;
        }
    }

    public static String a(Context context) {
        try {
            a aVar = new a();
            aVar.d = cq.c(context);
            aVar.i = cq.d(context);
            return a(context, aVar);
        } catch (Throwable th) {
            dl.a(th, "CI", "IX");
            return null;
        }
    }

    public static byte[] a(Context context, byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return cv.a(bArr);
    }

    public static byte[] a(Context context, boolean z) {
        try {
            return b(context, b(context, z));
        } catch (Throwable th) {
            dl.a(th, "CI", "gz");
            return null;
        }
    }

    public static String b(Context context) {
        try {
            return a(context, b(context, false));
        } catch (Throwable th) {
            dl.a(th, "CI", "gCX");
            return null;
        }
    }

    public static byte[] b(Context context, byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey d = db.d();
        if (bArr.length <= 117) {
            return cv.a(bArr, d);
        }
        byte[] bArr2 = new byte[117];
        System.arraycopy(bArr, 0, bArr2, 0, 117);
        byte[] a2 = cv.a(bArr2, d);
        byte[] bArr3 = new byte[((bArr.length + 128) - 117)];
        System.arraycopy(a2, 0, bArr3, 0, 128);
        System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
        return bArr3;
    }

    private static String a(Context context, a aVar) {
        return cv.b(b(context, aVar));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x009d A[SYNTHETIC, Splitter:B:17:0x009d] */
    private static byte[] b(Context context, a aVar) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
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
                a(byteArrayOutputStream, aVar.f1229l);
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
                byte[] a2 = a(context, byteArrayOutputStream);
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return a2;
            } catch (Throwable th3) {
                th = th3;
                try {
                    dl.a(th, "CI", "gzx");
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
            dl.a(th, "CI", "gzx");
            if (byteArrayOutputStream != null) {
            }
            return null;
        }
        throw th;
    }

    private static byte[] a(Context context, ByteArrayOutputStream byteArrayOutputStream) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return b(context, db.b(byteArrayOutputStream.toByteArray()));
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        byte b;
        if (!TextUtils.isEmpty(str)) {
            if (str.getBytes().length > 255) {
                b = -1;
            } else {
                b = (byte) str.getBytes().length;
            }
            db.a(byteArrayOutputStream, b, db.a(str));
            return;
        }
        db.a(byteArrayOutputStream, (byte) 0, new byte[0]);
    }

    private static a b(Context context, boolean z) {
        a aVar = new a();
        aVar.a = cu.v(context);
        aVar.b = cu.m(context);
        String h = cu.h(context);
        if (h == null) {
            h = "";
        }
        aVar.c = h;
        aVar.d = cq.c(context);
        aVar.e = Build.MODEL;
        aVar.f = Build.MANUFACTURER;
        aVar.g = Build.DEVICE;
        aVar.h = cq.b(context);
        aVar.i = cq.d(context);
        aVar.j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.k = cu.x(context);
        aVar.f1229l = cu.u(context);
        aVar.m = cu.r(context) + "";
        aVar.n = cu.q(context) + "";
        aVar.o = cu.z(context);
        aVar.p = cu.p(context);
        if (z) {
            aVar.q = "";
        } else {
            aVar.q = cu.l(context);
        }
        if (z) {
            aVar.r = "";
        } else {
            aVar.r = cu.k(context);
        }
        if (z) {
            aVar.s = "";
            aVar.t = "";
        } else {
            String[] n = cu.n(context);
            aVar.s = n[0];
            aVar.t = n[1];
        }
        aVar.w = cu.a();
        String b = cu.b(context);
        if (!TextUtils.isEmpty(b)) {
            aVar.x = b;
        } else {
            aVar.x = "";
        }
        aVar.y = "aid=" + cu.j(context) + "|serial=" + cu.i(context) + "|storage=" + cu.c() + "|ram=" + cu.y(context) + "|arch=" + cu.d();
        String a2 = cu.a(context);
        if (!TextUtils.isEmpty(a2)) {
            aVar.y += "|adiuExtras=" + a2;
        }
        String a3 = cu.a(context, ",", true);
        if (!TextUtils.isEmpty(a3)) {
            aVar.y += "|multiImeis=" + a3;
        }
        String w = cu.w(context);
        if (!TextUtils.isEmpty(w)) {
            aVar.y += "|meid=" + w;
        }
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

        /* renamed from: l  reason: collision with root package name */
        String f1229l;
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
    }
}
