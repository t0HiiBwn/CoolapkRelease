package com.amap.api.mapcore2d;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: LocNetManager */
public final class gq {
    private static gq b;
    er a = null;
    private Context c = null;
    private int d = 0;
    private int e = gu.f;
    private boolean f = false;
    private int g = 0;

    private gq(Context context) {
        try {
            cw.a().a(context);
        } catch (Throwable unused) {
        }
        this.c = context;
        this.a = er.a();
    }

    public static gq a(Context context) {
        if (b == null) {
            b = new gq(context);
        }
        return b;
    }

    public final ey a(gr grVar) throws Throwable {
        long b2 = gy.b();
        ey a2 = this.a.a(grVar, this.f || gy.e(this.c));
        this.d = Long.valueOf(gy.b() - b2).intValue();
        return a2;
    }

    public final gr a(Context context, byte[] bArr, String str) {
        String str2;
        try {
            HashMap hashMap = new HashMap(16);
            gr grVar = new gr(context, gu.b());
            try {
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put("Connection", "Keep-Alive");
                hashMap.put("User-Agent", "AMAP_Location_SDK_Android 4.7.0");
                hashMap.put("KEY", cq.f(context));
                hashMap.put("enginever", "5.1");
                String a2 = ct.a();
                String a3 = ct.a(context, a2, "key=" + cq.f(context));
                hashMap.put("ts", a2);
                hashMap.put("scode", a3);
                hashMap.put("encr", "1");
                grVar.b(hashMap);
                grVar.r();
                grVar.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "4.7.0", "loc", 3));
                grVar.q();
                grVar.b(str);
                grVar.b(gy.a(bArr));
                grVar.a(cy.a(context));
                HashMap hashMap2 = new HashMap(16);
                hashMap2.put("output", "bin");
                hashMap2.put("policy", "3103");
                int i = this.g;
                if (i != 0) {
                    if (i == 1) {
                        str2 = "language:cn";
                    } else if (i == 2) {
                        str2 = "language:en";
                    }
                    hashMap2.put("custom", str2);
                    grVar.a(hashMap2);
                    grVar.a(this.e);
                    grVar.b(this.e);
                    if ((this.f && !gy.e(context)) || !str.startsWith("http:")) {
                        return grVar;
                    }
                    grVar.b(grVar.h().replace("https:", "https:"));
                    return grVar;
                }
                hashMap2.remove("custom");
                grVar.a(hashMap2);
                grVar.a(this.e);
                grVar.b(this.e);
                if (this.f) {
                }
                grVar.b(grVar.h().replace("https:", "https:"));
                return grVar;
            } catch (Throwable unused) {
                return grVar;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final void a(long j, boolean z) {
        try {
            this.f = z;
            try {
                cw.a().a(z);
            } catch (Throwable unused) {
            }
            this.e = Long.valueOf(j).intValue();
            this.g = 0;
        } catch (Throwable th) {
            gu.a(th, "LocNetManager", "setOption");
        }
    }
}
