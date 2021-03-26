package com.xiaomi.push;

public enum hq {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f622a;

    private hq(int i) {
        this.f622a = i;
    }

    public static hq a(int i) {
        if (i == 0) {
            return RegIdExpired;
        }
        if (i == 1) {
            return PackageUnregistered;
        }
        if (i != 2) {
            return null;
        }
        return Init;
    }

    public int a() {
        return this.f622a;
    }
}
