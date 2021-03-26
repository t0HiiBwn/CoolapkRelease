package com.umeng.analytics.pro;

/* compiled from: TTransportException */
public class cw extends bo {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    private static final long g = 1;
    protected int f = 0;

    public cw() {
    }

    public cw(int i) {
        this.f = i;
    }

    public cw(int i, String str) {
        super(str);
        this.f = i;
    }

    public cw(String str) {
        super(str);
    }

    public cw(int i, Throwable th) {
        super(th);
        this.f = i;
    }

    public cw(Throwable th) {
        super(th);
    }

    public cw(String str, Throwable th) {
        super(str, th);
    }

    public cw(int i, String str, Throwable th) {
        super(str, th);
        this.f = i;
    }

    public int a() {
        return this.f;
    }
}
