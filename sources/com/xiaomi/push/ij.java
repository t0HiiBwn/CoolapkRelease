package com.xiaomi.push;

public class ij {
    private static int a = Integer.MAX_VALUE;

    public static void a(ig igVar, byte b) {
        a(igVar, b, a);
    }

    public static void a(ig igVar, byte b, int i) {
        if (i > 0) {
            int i2 = 0;
            switch (b) {
                case 2:
                    igVar.p();
                    return;
                case 3:
                    igVar.q();
                    return;
                case 4:
                    igVar.u();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    igVar.r();
                    return;
                case 8:
                    igVar.s();
                    return;
                case 10:
                    igVar.t();
                    return;
                case 11:
                    igVar.w();
                    return;
                case 12:
                    igVar.f();
                    while (true) {
                        id h = igVar.h();
                        if (h.b == 0) {
                            igVar.g();
                            return;
                        } else {
                            a(igVar, h.b, i - 1);
                            igVar.i();
                        }
                    }
                case 13:
                    Cif j = igVar.j();
                    while (i2 < j.c) {
                        int i3 = i - 1;
                        a(igVar, j.a, i3);
                        a(igVar, j.b, i3);
                        i2++;
                    }
                    igVar.k();
                    return;
                case 14:
                    ik n = igVar.n();
                    while (i2 < n.b) {
                        a(igVar, n.a, i - 1);
                        i2++;
                    }
                    igVar.o();
                    return;
                case 15:
                    ie l = igVar.l();
                    while (i2 < l.b) {
                        a(igVar, l.a, i - 1);
                        i2++;
                    }
                    igVar.m();
                    return;
            }
        } else {
            throw new ia("Maximum skip depth exceeded");
        }
    }
}
