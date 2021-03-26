package com.tencent.beacon.qimei;

import android.content.Context;
import com.tencent.beacon.core.b.d;
import com.tencent.beacon.core.b.e;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.event.o;

/* compiled from: QimeiInfo */
public final class a {

    /* renamed from: l  reason: collision with root package name */
    private static a f1429l;
    private String a = "";
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private String i = "";
    private boolean j = false;
    private String k = "";

    private a(Context context) {
        this.b = d.a(context).a();
        e.a(context);
        this.c = e.e(context);
        this.d = e.c(context);
        this.e = e.d(context);
        if ("".equals(this.c)) {
            e.d();
        }
        this.f = o.a();
        this.g = e.b();
        this.h = e.e();
        this.i = e.a();
        this.j = com.tencent.beacon.core.d.e.a().b();
        this.k = e.h();
        e.j(context);
        try {
            String loadQIMEI = QimeiUtil.loadQIMEI(context);
            if (loadQIMEI != null && !"".equals(loadQIMEI)) {
                this.a = loadQIMEI;
            }
        } catch (Exception e2) {
            b.d("load qimei error ", e2);
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f1429l == null) {
                f1429l = new a(context);
            }
            aVar = f1429l;
        }
        return aVar;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }

    public final String f() {
        return this.e;
    }

    public final String g() {
        return this.i;
    }

    public final boolean h() {
        return this.j;
    }

    public final String i() {
        return this.f;
    }

    public final String j() {
        return this.g;
    }

    public final String k() {
        return this.h;
    }

    public final String l() {
        return this.k;
    }
}
