package com.huawei.hms.stats;

public class s {
    private p a;
    private p b;
    private p c;
    private p d;
    private String e;

    public s(String str) {
        this.e = str;
    }

    public p a() {
        return this.a;
    }

    public p a(String str) {
        if (str.equals("oper")) {
            return b();
        }
        if (str.equals("maint")) {
            return a();
        }
        if (str.equals("diffprivacy")) {
            return d();
        }
        if (str.equals("preins")) {
            return c();
        }
        af.c("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + str);
        return null;
    }

    public void a(p pVar) {
        this.a = pVar;
    }

    public p b() {
        return this.b;
    }

    public void b(p pVar) {
        this.b = pVar;
    }

    public p c() {
        return this.d;
    }

    public void c(p pVar) {
        this.d = pVar;
    }

    public p d() {
        return this.c;
    }

    public void d(p pVar) {
        this.c = pVar;
    }
}
