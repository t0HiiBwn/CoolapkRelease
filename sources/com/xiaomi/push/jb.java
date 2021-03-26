package com.xiaomi.push;

public class jb {
    private static int a = Integer.MAX_VALUE;

    public static void a(iy iyVar, byte b) {
        a(iyVar, b, a);
    }

    public static void a(iy iyVar, byte b, int i) {
        if (i > 0) {
            int i2 = 0;
            switch (b) {
                case 2:
                    iyVar.m556a();
                    return;
                case 3:
                    iyVar.mo532a();
                    return;
                case 4:
                    iyVar.a();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    iyVar.m554a();
                    return;
                case 8:
                    iyVar.m545a();
                    return;
                case 10:
                    iyVar.m546a();
                    return;
                case 11:
                    iyVar.m553a();
                    return;
                case 12:
                    iyVar.m551a();
                    while (true) {
                        iv a2 = iyVar.m547a();
                        if (a2.a == 0) {
                            iyVar.f();
                            return;
                        } else {
                            a(iyVar, a2.a, i - 1);
                            iyVar.g();
                        }
                    }
                case 13:
                    ix a3 = iyVar.m549a();
                    while (i2 < a3.f879a) {
                        int i3 = i - 1;
                        a(iyVar, a3.a, i3);
                        a(iyVar, a3.b, i3);
                        i2++;
                    }
                    iyVar.h();
                    return;
                case 14:
                    jc a4 = iyVar.m550a();
                    while (i2 < a4.f882a) {
                        a(iyVar, a4.a, i - 1);
                        i2++;
                    }
                    iyVar.j();
                    return;
                case 15:
                    iw a5 = iyVar.m548a();
                    while (i2 < a5.f878a) {
                        a(iyVar, a5.a, i - 1);
                        i2++;
                    }
                    iyVar.i();
                    return;
            }
        } else {
            throw new is("Maximum skip depth exceeded");
        }
    }
}
