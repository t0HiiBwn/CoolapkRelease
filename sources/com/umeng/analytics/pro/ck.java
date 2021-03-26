package com.umeng.analytics.pro;

import com.umeng.analytics.pro.cb;

/* compiled from: TProtocolUtil */
public class ck {
    private static int a = Integer.MAX_VALUE;

    public static void a(int i) {
        a = i;
    }

    public static void a(ch chVar, byte b) throws bo {
        a(chVar, b, a);
    }

    public static void a(ch chVar, byte b, int i) throws bo {
        if (i > 0) {
            int i2 = 0;
            switch (b) {
                case 2:
                    chVar.t();
                    return;
                case 3:
                    chVar.u();
                    return;
                case 4:
                    chVar.y();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    chVar.v();
                    return;
                case 8:
                    chVar.w();
                    return;
                case 10:
                    chVar.x();
                    return;
                case 11:
                    chVar.A();
                    return;
                case 12:
                    chVar.j();
                    while (true) {
                        cc l = chVar.l();
                        if (l.b == 0) {
                            chVar.k();
                            return;
                        } else {
                            a(chVar, l.b, i - 1);
                            chVar.m();
                        }
                    }
                case 13:
                    ce n = chVar.n();
                    while (i2 < n.c) {
                        int i3 = i - 1;
                        a(chVar, n.a, i3);
                        a(chVar, n.b, i3);
                        i2++;
                    }
                    chVar.o();
                    return;
                case 14:
                    cl r = chVar.r();
                    while (i2 < r.b) {
                        a(chVar, r.a, i - 1);
                        i2++;
                    }
                    chVar.s();
                    return;
                case 15:
                    cd p = chVar.p();
                    while (i2 < p.b) {
                        a(chVar, p.a, i - 1);
                        i2++;
                    }
                    chVar.q();
                    return;
            }
        } else {
            throw new bo("Maximum skip depth exceeded");
        }
    }

    public static cj a(byte[] bArr, cj cjVar) {
        if (bArr[0] > 16) {
            return new cb.a();
        }
        return (bArr.length <= 1 || (bArr[1] & 128) == 0) ? cjVar : new cb.a();
    }
}
