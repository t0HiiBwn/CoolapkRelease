package com.loc;

import android.os.SystemClock;
import com.loc.bx;
import java.util.List;

/* compiled from: FpsBufferBuilder */
public final class bu extends bt {
    public bu() {
        super(2048);
    }

    public final byte[] a(dc dcVar, bx.a aVar, long j, List<dd> list) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        bv bvVar;
        int i6;
        int i7;
        int i8;
        byte b;
        int i9;
        int a;
        short a2;
        super.a();
        try {
            int a3 = cj.a(this.a, dcVar.c, dcVar.k, (int) (dcVar.e * 1000000.0d), (int) (dcVar.d * 1000000.0d), (int) dcVar.f, (int) dcVar.i, (int) dcVar.g, (short) ((int) dcVar.h), dcVar.l);
            if (aVar == null || aVar.f == null || aVar.f.size() <= 0) {
                i = a3;
                i2 = -1;
            } else {
                List<cw> list2 = aVar.f;
                if (list2 != null) {
                    if (list2.size() != 0) {
                        for (cw cwVar : list2) {
                            if (cwVar instanceof cy) {
                                cy cyVar = (cy) cwVar;
                                a2 = ct.a(ct.a(cyVar.j, cyVar.k));
                            } else if (cwVar instanceof cz) {
                                cz czVar = (cz) cwVar;
                                a2 = ct.a(ct.a(czVar.j, czVar.k));
                            } else if (cwVar instanceof da) {
                                da daVar = (da) cwVar;
                                a2 = ct.a(ct.a(daVar.j, daVar.k));
                            } else if (cwVar instanceof cx) {
                                cx cxVar = (cx) cwVar;
                                a2 = ct.a(ct.a(cxVar.k, cxVar.l));
                            }
                            cwVar.g = a2;
                        }
                    }
                }
                int size = aVar.f.size();
                int[] iArr = new int[size];
                int i10 = 0;
                while (true) {
                    if (i10 < size) {
                        cw cwVar2 = aVar.f.get(i10);
                        if (cwVar2 instanceof cy) {
                            cy cyVar2 = (cy) cwVar2;
                            if (!cyVar2.i) {
                                a = ck.a(this.a, cyVar2.j, cyVar2.k, cyVar2.c, cyVar2.l);
                                i = a3;
                                i8 = size;
                            } else {
                                i8 = size;
                                i = a3;
                                a = ck.a(this.a, cyVar2.b(), cyVar2.c(), cyVar2.j, cyVar2.k, cyVar2.c, cyVar2.m, cyVar2.n, cyVar2.d, cyVar2.l);
                            }
                            i9 = a;
                            i2 = -1;
                            b = 1;
                        } else {
                            i = a3;
                            i8 = size;
                            if (cwVar2 instanceof cz) {
                                cz czVar2 = (cz) cwVar2;
                                i9 = cl.a(this.a, czVar2.b(), czVar2.c(), czVar2.j, czVar2.k, czVar2.l, czVar2.c, czVar2.m, czVar2.d);
                                i2 = -1;
                                b = 3;
                            } else if (cwVar2 instanceof cx) {
                                cx cxVar2 = (cx) cwVar2;
                                i9 = !cxVar2.i ? ce.a(this.a, cxVar2.j, cxVar2.k, cxVar2.l, cxVar2.m, cxVar2.n, cxVar2.c) : ce.a(this.a, cxVar2.j, cxVar2.k, cxVar2.l, cxVar2.m, cxVar2.n, cxVar2.c, cxVar2.d);
                                i2 = -1;
                                b = 2;
                            } else if (cwVar2 instanceof da) {
                                da daVar2 = (da) cwVar2;
                                i9 = co.a(this.a, daVar2.b(), daVar2.c(), daVar2.j, daVar2.k, daVar2.l, daVar2.c, daVar2.m, daVar2.d);
                                i2 = -1;
                                b = 4;
                            } else {
                                i9 = -1;
                                i2 = -1;
                                b = 0;
                            }
                        }
                        if (i9 == i2) {
                            break;
                        }
                        iArr[i10] = ch.a(this.a, (byte) (cwVar2.h ? 1 : 0), (byte) (cwVar2.i ? 1 : 0), (short) cwVar2.g, b, i9);
                        i10++;
                        size = i8;
                        a3 = i;
                    } else {
                        i = a3;
                        i2 = -1;
                        int a4 = this.a.a(aVar.b);
                        int a5 = cf.a(this.a, iArr);
                        int size2 = aVar.g.size();
                        int[] iArr2 = new int[size2];
                        for (int i11 = 0; i11 < size2; i11++) {
                            cw cwVar3 = aVar.g.get(i11);
                            long elapsedRealtime = (SystemClock.elapsedRealtime() - cwVar3.e) / 1000;
                            if (elapsedRealtime > 32767 || elapsedRealtime < 0) {
                                elapsedRealtime = 32767;
                            }
                            if (cwVar3 instanceof cy) {
                                cy cyVar3 = (cy) cwVar3;
                                bvVar = this.a;
                                i6 = cyVar3.j;
                                i7 = cyVar3.k;
                            } else if (cwVar3 instanceof cz) {
                                cz czVar3 = (cz) cwVar3;
                                bvVar = this.a;
                                i6 = czVar3.j;
                                i7 = czVar3.k;
                            } else {
                                if (cwVar3 instanceof cx) {
                                    cx cxVar3 = (cx) cwVar3;
                                    i5 = cm.a(this.a, cxVar3.j, cxVar3.k, cxVar3.l, (short) ((int) elapsedRealtime));
                                    i4 = 2;
                                } else if (cwVar3 instanceof da) {
                                    da daVar3 = (da) cwVar3;
                                    bvVar = this.a;
                                    i6 = daVar3.j;
                                    i7 = daVar3.k;
                                } else {
                                    i5 = 0;
                                    i4 = 0;
                                }
                                iArr2[i11] = cg.a(this.a, (byte) i4, i5);
                            }
                            i5 = cn.a(bvVar, i6, i7, (short) ((int) elapsedRealtime));
                            i4 = 1;
                            iArr2[i11] = cg.a(this.a, (byte) i4, i5);
                        }
                        i3 = cf.a(this.a, a4, aVar.a, a5, cf.b(this.a, iArr2));
                    }
                }
            }
            i3 = -1;
            if (list != null && list.size() > 0) {
                for (dd ddVar : list) {
                    ddVar.g = ct.b(ddVar.a);
                }
                int size3 = list.size();
                if (size3 > 0) {
                    int[] iArr3 = new int[size3];
                    for (int i12 = 0; i12 < size3; i12++) {
                        dd ddVar2 = list.get(i12);
                        iArr3[i12] = cq.a(this.a, ddVar2.a == j && ddVar2.a != -1, ddVar2.a, (short) ddVar2.c, this.a.a(ddVar2.b), ddVar2.g, (short) ddVar2.d);
                    }
                    i2 = cp.a(this.a, cp.a(this.a, iArr3));
                }
            }
            cc.a(this.a);
            cc.a(this.a, i);
            if (i3 > 0) {
                cc.c(this.a, i3);
            }
            if (i2 > 0) {
                cc.b(this.a, i2);
            }
            this.a.c(cc.b(this.a));
            return this.a.c();
        } catch (Throwable th) {
            dg.a(th);
            return null;
        }
    }
}
