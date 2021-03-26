package com.amap.api.col.s;

import android.text.TextUtils;
import java.net.URLConnection;
import java.util.Map;

/* compiled from: BaseNetManager */
public class cs {
    public static int a = 0;
    public static String b = "";
    private static cs c;

    /* compiled from: BaseNetManager */
    public interface a {
        URLConnection a();
    }

    public static cs a() {
        if (c == null) {
            c = new cs();
        }
        return c;
    }

    public static byte[] a(cy cyVar) throws bh {
        try {
            cz a2 = a(cyVar, true);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (bh e) {
            throw e;
        } catch (Throwable unused) {
            throw new bh("未知的错误");
        }
    }

    public byte[] b(cy cyVar) throws bh {
        try {
            cz a2 = a(cyVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (bh e) {
            throw e;
        } catch (Throwable th) {
            cd.a(th, "bm", "msp");
            throw new bh("未知的错误");
        }
    }

    protected static void c(cy cyVar) throws bh {
        if (cyVar == null) {
            throw new bh("requeust is null");
        } else if (cyVar.h() == null || "".equals(cyVar.h())) {
            throw new bh("request url is empty");
        }
    }

    public static cz a(cy cyVar, boolean z) throws bh {
        cz czVar;
        int a2 = cv.a(cyVar);
        try {
            czVar = a(cyVar, z, a2);
        } catch (bh e) {
            if (cv.a(a2)) {
                czVar = null;
            } else {
                throw e;
            }
        }
        if ((czVar != null && czVar.a != null && czVar.a.length > 0) || !cv.a(a2)) {
            return czVar;
        }
        try {
            return a(cyVar, z, 3);
        } catch (bh e2) {
            throw e2;
        }
    }

    private static cz a(cy cyVar, boolean z, int i) throws bh {
        byte[] bArr;
        try {
            c(cyVar);
            cv cvVar = new cv(cyVar, z);
            String m = cyVar.m();
            String n = cyVar.n();
            boolean o = cyVar.o();
            String j = cyVar.j();
            Map<String, String> f = cyVar.f();
            byte[] g = cyVar.g();
            if (g == null || g.length == 0) {
                String a2 = cv.a(cyVar.e());
                if (!TextUtils.isEmpty(a2)) {
                    bArr = bs.a(a2);
                    return cvVar.a(m, n, o, j, f, bArr, i);
                }
            }
            bArr = g;
            return cvVar.a(m, n, o, j, f, bArr, i);
        } catch (bh e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new bh("未知的错误");
        }
    }
}
