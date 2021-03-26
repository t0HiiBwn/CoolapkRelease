package com.xiaomi.push;

import java.io.IOException;

public abstract class cs {
    public abstract int a();

    public abstract cs a(ab abVar);

    public cs a(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public abstract void a(bc bcVar);

    public void a(byte[] bArr, int i, int i2) {
        try {
            bc a = bc.a(bArr, i, i2);
            a(a);
            a.c();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    protected boolean a(ab abVar, int i) {
        return abVar.b(i);
    }

    public abstract int b();

    public cs b(byte[] bArr, int i, int i2) {
        try {
            ab a = ab.a(bArr, i, i2);
            a(a);
            a.a(0);
            return this;
        } catch (br e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public byte[] c() {
        int b = b();
        byte[] bArr = new byte[b];
        a(bArr, 0, b);
        return bArr;
    }
}
