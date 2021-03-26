package com.tencent.beacon.core.b;

import android.content.Context;
import com.tencent.beacon.core.a.c;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.g;
import com.tencent.beacon.core.d.h;

/* compiled from: DetailUserInfo */
public final class d {
    private static d a;
    private final Context b;
    private f c;
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d(context);
            }
            dVar = a;
        }
        return dVar;
    }

    private d(Context context) {
        if (context == null) {
            b.d("[core] create detail user info failed.", new Object[0]);
        }
        this.b = context;
        e.a(context);
        this.g = e.d(context);
        String e2 = e.e(context);
        this.e = e2;
        if (g.a(e2)) {
            this.e = e.d();
        }
        this.f = e.c(context);
        e.e();
        StringBuilder sb = new StringBuilder();
        sb.append(e.f());
        sb.append("m");
        if (i.a(context).a()) {
            this.h = e.h();
        } else {
            this.h = "";
        }
        e.a(context);
        String b2 = e.b(context);
        this.d = b2;
        if (!g.a(b2)) {
            try {
                c a2 = c.a(context);
                if (g.a(a2.a("IMEI_DENGTA", ""))) {
                    a2.a().a("IMEI_DENGTA", (Object) this.d).b();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                h.a((Throwable) e3);
            }
        }
        b.a("[core] imei: " + this.d, new Object[0]);
        this.c = new c(context);
    }

    public final synchronized String a() {
        if (g.a(this.d)) {
            this.d = c.a(this.b).a("IMEI_DENGTA", "");
        }
        return this.d;
    }

    public final synchronized String b() {
        return this.e;
    }

    public final synchronized String c() {
        return this.f;
    }

    public final synchronized String d() {
        return this.g;
    }

    public final String e() {
        return this.h;
    }

    public final synchronized String f() {
        f fVar = this.c;
        if (fVar == null) {
            return "";
        }
        return fVar.getQimei();
    }

    public final f g() {
        return this.c;
    }

    public final void a(f fVar) {
        this.c = fVar;
    }
}
