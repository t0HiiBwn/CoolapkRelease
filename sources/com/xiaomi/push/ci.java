package com.xiaomi.push;

public class ci {
    private static volatile ci b;
    private ch a;

    public static ci a() {
        if (b == null) {
            synchronized (ci.class) {
                if (b == null) {
                    b = new ci();
                }
            }
        }
        return b;
    }

    public void a(ch chVar) {
        this.a = chVar;
    }

    public ch b() {
        return this.a;
    }
}
