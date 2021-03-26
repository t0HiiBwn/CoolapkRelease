package com.amap.api.mapcore2d;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: CellAgeEstimator */
public final class gl {
    private HashMap<Long, gm> a = new HashMap<>();
    private long b = 0;

    private static long a(int i, int i2) {
        return (((long) i2) & 65535) | ((((long) i) & 65535) << 32);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a  */
    public final long a(gm gmVar) {
        long j;
        gm gmVar2;
        int i;
        int i2;
        if (gmVar == null || !gmVar.p) {
            return 0;
        }
        HashMap<Long, gm> hashMap = this.a;
        int i3 = gmVar.k;
        if (i3 != 1) {
            if (i3 == 2) {
                i2 = gmVar.c();
                i = gmVar.d();
                j = a(i2, i);
                gmVar2 = hashMap.get(Long.valueOf(j));
                if (gmVar2 == null) {
                }
            } else if (!(i3 == 3 || i3 == 4)) {
                j = 0;
                gmVar2 = hashMap.get(Long.valueOf(j));
                if (gmVar2 == null) {
                    gmVar.m = gy.b();
                    hashMap.put(Long.valueOf(j), gmVar);
                    return 0;
                } else if (gmVar2.e() != gmVar.e()) {
                    gmVar.m = gy.b();
                    hashMap.put(Long.valueOf(j), gmVar);
                    return 0;
                } else {
                    gmVar.m = gmVar2.m;
                    hashMap.put(Long.valueOf(j), gmVar);
                    return (gy.b() - gmVar2.m) / 1000;
                }
            }
        }
        i2 = gmVar.a();
        i = gmVar.b();
        j = a(i2, i);
        gmVar2 = hashMap.get(Long.valueOf(j));
        if (gmVar2 == null) {
        }
    }

    public final void a() {
        this.a.clear();
        this.b = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (r13 != 4) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (r12 != 4) goto L_0x009b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0065 A[SYNTHETIC] */
    public final void a(ArrayList<? extends gm> arrayList) {
        int i;
        int i2;
        gm gmVar;
        int i3;
        int i4;
        if (arrayList != null) {
            long b2 = gy.b();
            long j = this.b;
            long j2 = 0;
            if (j <= 0 || b2 - j >= 60000) {
                HashMap<Long, gm> hashMap = this.a;
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    gm gmVar2 = (gm) arrayList.get(i5);
                    if (gmVar2.p) {
                        int i6 = gmVar2.k;
                        if (i6 != 1) {
                            if (i6 == 2) {
                                i4 = gmVar2.h;
                                i3 = gmVar2.i;
                                j2 = a(i4, i3);
                                gmVar = hashMap.get(Long.valueOf(j2));
                                if (gmVar != null) {
                                    if (gmVar.e() == gmVar2.e()) {
                                        gmVar2.m = gmVar.m;
                                    } else {
                                        gmVar2.m = b2;
                                    }
                                }
                            } else if (i6 != 3) {
                            }
                        }
                        i4 = gmVar2.c;
                        i3 = gmVar2.d;
                        j2 = a(i4, i3);
                        gmVar = hashMap.get(Long.valueOf(j2));
                        if (gmVar != null) {
                        }
                    }
                }
                hashMap.clear();
                int size2 = arrayList.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    gm gmVar3 = (gm) arrayList.get(i7);
                    if (gmVar3.p) {
                        int i8 = gmVar3.k;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                i2 = gmVar3.c();
                                i = gmVar3.d();
                                j2 = a(i2, i);
                                hashMap.put(Long.valueOf(j2), gmVar3);
                            } else if (i8 != 3) {
                            }
                        }
                        i2 = gmVar3.a();
                        i = gmVar3.b();
                        j2 = a(i2, i);
                        hashMap.put(Long.valueOf(j2), gmVar3);
                    }
                }
                this.b = b2;
            }
        }
    }
}
