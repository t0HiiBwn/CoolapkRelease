package com.loc;

/* compiled from: TData */
public final class ci extends es {
    public static int a(er erVar, byte b, int i) {
        erVar.b(2);
        erVar.b(1, i);
        erVar.a(0, b);
        return erVar.b();
    }

    public static int a(er erVar, byte[] bArr) {
        erVar.a(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            erVar.a(bArr[length]);
        }
        return erVar.a();
    }
}
