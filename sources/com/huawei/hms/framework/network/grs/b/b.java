package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.net.Uri;
import java.util.concurrent.Callable;

public class b {
    protected d a;
    private String b;
    private a c;
    private int d;
    private Context e;
    private String f;

    private enum a {
        GRSPOST,
        GRSGET,
        GRSDEFAULT
    }

    public b(String str, int i, a aVar, Context context, String str2) {
        this.b = str;
        this.c = aVar;
        this.d = i;
        this.e = context;
        this.f = str2;
    }

    private String a(String str) {
        return Uri.parse(str).getPath();
    }

    private a g() {
        if (this.b.isEmpty()) {
            return a.GRSDEFAULT;
        }
        String a2 = a(this.b);
        return a2.contains("1.0") ? a.GRSGET : a2.contains("2.0") ? a.GRSPOST : a.GRSDEFAULT;
    }

    public String a() {
        return this.b;
    }

    public a b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public Context d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public Callable<d> f() {
        if (a.GRSDEFAULT.equals(g())) {
            return null;
        }
        return a.GRSGET.equals(g()) ? new f(this.b, this.d, this.c, this.e, this.f) : new g(this.b, this.d, this.c, this.e, this.f);
    }
}
