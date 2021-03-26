package com.xiaomi.push;

public class id {
    public final String a;
    public final byte b;
    public final short c;

    public id() {
        this("", (byte) 0, 0);
    }

    public id(String str, byte b2, short s) {
        this.a = str;
        this.b = b2;
        this.c = s;
    }

    public String toString() {
        return "<TField name:'" + this.a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.c) + ">";
    }
}
