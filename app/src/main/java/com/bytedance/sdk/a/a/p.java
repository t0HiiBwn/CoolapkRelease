package com.bytedance.sdk.a.a;

/* compiled from: SegmentPool */
final class p {
    static o a;
    static long b;

    private p() {
    }

    static o a() {
        synchronized (p.class) {
            o oVar = a;
            if (oVar == null) {
                return new o();
            }
            a = oVar.f;
            oVar.f = null;
            b -= 8192;
            return oVar;
        }
    }

    static void a(o oVar) {
        if (oVar.f != null || oVar.g != null) {
            throw new IllegalArgumentException();
        } else if (!oVar.d) {
            synchronized (p.class) {
                long j = b;
                if (j + 8192 <= 65536) {
                    b = j + 8192;
                    oVar.f = a;
                    oVar.c = 0;
                    oVar.b = 0;
                    a = oVar;
                }
            }
        }
    }
}
