package com.alibaba.baichuan.android.trade.usertracker.monitor;

public abstract class BaseTradeMonitorPoint {
    public String a = "0";
    public String b = "url";
    public long c;
    public long d;

    public void a() {
        this.c = System.currentTimeMillis();
    }

    public void b() {
        this.c = System.currentTimeMillis() - this.c;
    }

    public void c() {
        this.d = System.currentTimeMillis();
    }

    public void d() {
        this.d = System.currentTimeMillis() - this.d;
    }
}
