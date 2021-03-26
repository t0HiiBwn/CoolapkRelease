package com.umeng.analytics.pro;

/* compiled from: TMessage */
public final class cf {
    public final String a;
    public final byte b;
    public final int c;

    public cf() {
        this("", (byte) 0, 0);
    }

    public cf(String str, byte b2, int i) {
        this.a = str;
        this.b = b2;
        this.c = i;
    }

    public String toString() {
        return "<TMessage name:'" + this.a + "' type: " + ((int) this.b) + " seqid:" + this.c + ">";
    }

    public boolean equals(Object obj) {
        if (obj instanceof cf) {
            return a((cf) obj);
        }
        return false;
    }

    public boolean a(cf cfVar) {
        return this.a.equals(cfVar.a) && this.b == cfVar.b && this.c == cfVar.c;
    }
}
