package com.umeng.analytics.pro;

import java.io.Serializable;

/* compiled from: FieldValueMetaData */
public class bv implements Serializable {
    private final boolean a;
    public final byte b;
    private final String c;
    private final boolean d;

    public bv(byte b2, boolean z) {
        this.b = b2;
        this.a = false;
        this.c = null;
        this.d = z;
    }

    public bv(byte b2) {
        this(b2, false);
    }

    public bv(byte b2, String str) {
        this.b = b2;
        this.a = true;
        this.c = str;
        this.d = false;
    }

    public boolean a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        return this.b == 12;
    }

    public boolean d() {
        byte b2 = this.b;
        return b2 == 15 || b2 == 13 || b2 == 14;
    }

    public boolean e() {
        return this.d;
    }
}
