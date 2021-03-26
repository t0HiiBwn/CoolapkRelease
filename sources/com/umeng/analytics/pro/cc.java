package com.umeng.analytics.pro;

/* compiled from: TField */
public class cc {
    public final String a;
    public final byte b;
    public final short c;

    public cc() {
        this("", (byte) 0, 0);
    }

    public cc(String str, byte b2, short s) {
        this.a = str;
        this.b = b2;
        this.c = s;
    }

    public String toString() {
        return "<TField name:'" + this.a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.c) + ">";
    }

    public boolean a(cc ccVar) {
        return this.b == ccVar.b && this.c == ccVar.c;
    }
}
