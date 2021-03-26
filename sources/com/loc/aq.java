package com.loc;

import android.text.TextUtils;
import java.net.URLConnection;
import java.util.Map;

/* compiled from: BaseNetManager */
public final class aq {
    public static int a = 0;
    public static String b = "";
    private static aq c;

    /* compiled from: BaseNetManager */
    public interface a {
        URLConnection a();
    }

    public static aq a() {
        if (c == null) {
            c = new aq();
        }
        return c;
    }

    public static aw a(av avVar, boolean z) throws j {
        aw awVar;
        int a2 = at.a(avVar);
        try {
            awVar = a(avVar, z, a2);
        } catch (j e) {
            if (at.a(a2)) {
                awVar = null;
            } else {
                throw e;
            }
        }
        if ((awVar != null && awVar.a != null && awVar.a.length > 0) || !at.a(a2)) {
            return awVar;
        }
        try {
            return a(avVar, z, 3);
        } catch (j e2) {
            throw e2;
        }
    }

    public static aw a(av avVar, boolean z, int i) throws j {
        byte[] bArr;
        if (avVar != null) {
            try {
                if (avVar.c() == null || "".equals(avVar.c())) {
                    throw new j("request url is empty");
                }
                at atVar = new at(avVar, z);
                String m = avVar.m();
                String n = avVar.n();
                boolean o = avVar.o();
                String h = avVar.h();
                Map<String, String> b2 = avVar.b();
                byte[] e = avVar.e();
                if (e == null || e.length == 0) {
                    String a2 = at.a(avVar.b_());
                    if (!TextUtils.isEmpty(a2)) {
                        bArr = u.a(a2);
                        return atVar.a(m, n, o, h, b2, bArr, i);
                    }
                }
                bArr = e;
                return atVar.a(m, n, o, h, b2, bArr, i);
            } catch (j e2) {
                throw e2;
            } catch (Throwable th) {
                th.printStackTrace();
                throw new j("未知的错误");
            }
        } else {
            throw new j("requeust is null");
        }
    }

    public static byte[] a(av avVar) throws j {
        try {
            aw a2 = a(avVar, true);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (j e) {
            throw e;
        } catch (Throwable unused) {
            throw new j("未知的错误");
        }
    }

    public static byte[] b(av avVar) throws j {
        try {
            aw a2 = a(avVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (j e) {
            throw e;
        } catch (Throwable th) {
            y.a(th, "bm", "msp");
            throw new j("未知的错误");
        }
    }

    public static aw c(av avVar) throws j {
        try {
            aw a2 = a(avVar, false);
            if (a2 != null) {
                return a2;
            }
            return null;
        } catch (j e) {
            throw e;
        } catch (Throwable th) {
            y.a(th, "bm", "mp");
            throw new j("未知的错误");
        }
    }
}
