package com.loc;

/* compiled from: RootTUploadData */
public final class cd extends es {
    public static int a(er erVar, int i, int i2, int i3) {
        erVar.b(3);
        erVar.b(2, i3);
        erVar.b(1, i2);
        erVar.b(0, i);
        return erVar.b();
    }

    public static int a(er erVar, byte[] bArr) {
        erVar.a(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            erVar.a(bArr[length]);
        }
        return erVar.a();
    }

    public static int a(er erVar, int[] iArr) {
        erVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            erVar.a(iArr[length]);
        }
        return erVar.a();
    }

    public static int b(er erVar, byte[] bArr) {
        erVar.a(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            erVar.a(bArr[length]);
        }
        return erVar.a();
    }
}
