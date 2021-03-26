package com.loc;

import android.os.SystemClock;
import com.loc.bx;
import java.util.List;

/* compiled from: FpsCollector */
public final class by {
    private static volatile by g;
    private static Object h = new Object();
    private bx a = new bx();
    private bz b = new bz();
    private long c;
    private dc d;
    private bu e = new bu();
    private dc f = new dc();

    /* compiled from: FpsCollector */
    public static class a {
        public dc a;
        public List<dd> b;
        public long c;
        public long d;
        public boolean e;
        public long f;
        public byte g;
        public String h;
        public List<cw> i;
        public boolean j;
    }

    private by() {
    }

    public static by a() {
        if (g == null) {
            synchronized (h) {
                if (g == null) {
                    g = new by();
                }
            }
        }
        return g;
    }

    public final ca a(a aVar) {
        ca caVar = null;
        if (aVar == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.d == null || aVar.a.a(this.d) >= 10.0d) {
            bx.a a2 = this.a.a(aVar.a, aVar.j, aVar.g, aVar.h, aVar.i);
            List<dd> a3 = this.b.a(aVar.a, aVar.b, aVar.e, aVar.d, currentTimeMillis);
            if (!(a2 == null && a3 == null)) {
                dc dcVar = this.f;
                dc dcVar2 = aVar.a;
                long j = aVar.f;
                dcVar.k = j;
                dcVar.b = j;
                dcVar.c = currentTimeMillis;
                dcVar.e = dcVar2.e;
                dcVar.d = dcVar2.d;
                dcVar.f = dcVar2.f;
                dcVar.i = dcVar2.i;
                dcVar.g = dcVar2.g;
                dcVar.h = dcVar2.h;
                caVar = new ca(0, this.e.a(this.f, a2, aVar.c, a3));
            }
            this.d = aVar.a;
            this.c = elapsedRealtime;
        }
        return caVar;
    }
}
