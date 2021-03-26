package com.huawei.hms.stats;

public class bv {
    static bv a = new bv();
    bq b = null;

    public static bv a() {
        return a;
    }

    public void a(bq bqVar) {
        this.b = bqVar;
    }

    public bq b() {
        return this.b;
    }

    public boolean c() {
        return this.b != null;
    }
}
