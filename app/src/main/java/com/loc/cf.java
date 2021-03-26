package com.loc;

/* compiled from: TCell */
public final class cf extends es {
    public static int a(er erVar, int i, byte b, int i2, int i3) {
        erVar.b(4);
        erVar.b(3, i3);
        erVar.b(2, i2);
        erVar.b(0, i);
        erVar.a(1, b);
        return erVar.b();
    }

    public static int a(er erVar, int[] iArr) {
        erVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            erVar.a(iArr[length]);
        }
        return erVar.a();
    }

    public static int b(er erVar, int[] iArr) {
        erVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            erVar.a(iArr[length]);
        }
        return erVar.a();
    }
}
