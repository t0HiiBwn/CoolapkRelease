package com.xiaomi.push;

public class dh {
    private static volatile dh a;

    /* renamed from: a  reason: collision with other field name */
    private dg f316a;

    public static dh a() {
        if (a == null) {
            synchronized (dh.class) {
                if (a == null) {
                    a = new dh();
                }
            }
        }
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dg m199a() {
        return this.f316a;
    }

    public void a(dg dgVar) {
        this.f316a = dgVar;
    }
}
