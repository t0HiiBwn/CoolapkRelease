package com.amap.api.mapcore2d;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: BaseNetManager */
public class er {
    public static int a = 0;
    public static String b = "";
    private static er c;

    /* compiled from: BaseNetManager */
    public interface a {
        URLConnection a(Proxy proxy, URL url);
    }

    public static er a() {
        if (c == null) {
            c = new er();
        }
        return c;
    }

    public byte[] a(ew ewVar) throws cp {
        try {
            ey a2 = a(ewVar, true);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (cp e) {
            throw e;
        } catch (Throwable unused) {
            throw new cp("未知的错误");
        }
    }

    public byte[] b(ew ewVar) throws cp {
        try {
            ey a2 = a(ewVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (cp e) {
            throw e;
        } catch (Throwable th) {
            dl.a(th, "bm", "msp");
            throw new cp("未知的错误");
        }
    }

    protected void c(ew ewVar) throws cp {
        if (ewVar == null) {
            throw new cp("requeust is null");
        } else if (ewVar.h() == null || "".equals(ewVar.h())) {
            throw new cp("request url is empty");
        }
    }

    public ey a(ew ewVar, boolean z) throws cp {
        Proxy proxy;
        try {
            c(ewVar);
            if (ewVar.e == null) {
                proxy = null;
            } else {
                proxy = ewVar.e;
            }
            return new eu(ewVar.c, ewVar.d, proxy, z).a(ewVar.l(), ewVar.n(), ewVar.m(), ewVar.f(), ewVar.p(), ewVar.o());
        } catch (cp e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new cp("未知的错误");
        }
    }
}
