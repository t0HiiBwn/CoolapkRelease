package com.xiaomi.push;

public class iv {
    public final byte a;

    /* renamed from: a  reason: collision with other field name */
    public final String f876a;

    /* renamed from: a  reason: collision with other field name */
    public final short f877a;

    public iv() {
        this("", (byte) 0, 0);
    }

    public iv(String str, byte b, short s) {
        this.f876a = str;
        this.a = b;
        this.f877a = s;
    }

    public String toString() {
        return "<TField name:'" + this.f876a + "' type:" + ((int) this.a) + " field-id:" + ((int) this.f877a) + ">";
    }
}
