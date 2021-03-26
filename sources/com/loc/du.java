package com.loc;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: CellAgeEstimator */
public final class du {
    private HashMap<Long, dv> a = new HashMap<>();
    private long b = 0;

    private static long a(int i, int i2) {
        return (((long) i2) & 65535) | ((((long) i) & 65535) << 32);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042  */
    public final long a(dv dvVar) {
        long j;
        dv dvVar2;
        int i;
        int i2;
        if (dvVar == null || !dvVar.p) {
            return 0;
        }
        HashMap<Long, dv> hashMap = this.a;
        int i3 = dvVar.k;
        if (i3 != 1) {
            if (i3 == 2) {
                i2 = dvVar.h;
                i = dvVar.i;
                j = a(i2, i);
                dvVar2 = hashMap.get(Long.valueOf(j));
                if (dvVar2 == null) {
                }
            } else if (!(i3 == 3 || i3 == 4)) {
                j = 0;
                dvVar2 = hashMap.get(Long.valueOf(j));
                if (dvVar2 == null) {
                    dvVar.m = ep.b();
                    hashMap.put(Long.valueOf(j), dvVar);
                    return 0;
                } else if (dvVar2.j != dvVar.j) {
                    dvVar.m = ep.b();
                    hashMap.put(Long.valueOf(j), dvVar);
                    return 0;
                } else {
                    dvVar.m = dvVar2.m;
                    hashMap.put(Long.valueOf(j), dvVar);
                    return (ep.b() - dvVar2.m) / 1000;
                }
            }
        }
        i2 = dvVar.c;
        i = dvVar.d;
        j = a(i2, i);
        dvVar2 = hashMap.get(Long.valueOf(j));
        if (dvVar2 == null) {
        }
    }

    public final void a() {
        this.a.clear();
        this.b = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (r13 != 4) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007f, code lost:
        if (r12 != 4) goto L_0x008f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0061 A[SYNTHETIC] */
    public final void a(ArrayList<? extends dv> arrayList) {
        int i;
        int i2;
        dv dvVar;
        int i3;
        int i4;
        if (arrayList != null) {
            long b2 = ep.b();
            long j = this.b;
            long j2 = 0;
            if (j <= 0 || b2 - j >= 60000) {
                HashMap<Long, dv> hashMap = this.a;
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    dv dvVar2 = (dv) arrayList.get(i5);
                    if (dvVar2.p) {
                        int i6 = dvVar2.k;
                        if (i6 != 1) {
                            if (i6 == 2) {
                                i4 = dvVar2.h;
                                i3 = dvVar2.i;
                                j2 = a(i4, i3);
                                dvVar = hashMap.get(Long.valueOf(j2));
                                if (dvVar != null) {
                                    if (dvVar.j == dvVar2.j) {
                                        dvVar2.m = dvVar.m;
                                    } else {
                                        dvVar2.m = b2;
                                    }
                                }
                            } else if (i6 != 3) {
                            }
                        }
                        i4 = dvVar2.c;
                        i3 = dvVar2.d;
                        j2 = a(i4, i3);
                        dvVar = hashMap.get(Long.valueOf(j2));
                        if (dvVar != null) {
                        }
                    }
                }
                hashMap.clear();
                int size2 = arrayList.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    dv dvVar3 = (dv) arrayList.get(i7);
                    if (dvVar3.p) {
                        int i8 = dvVar3.k;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                i2 = dvVar3.h;
                                i = dvVar3.i;
                                j2 = a(i2, i);
                                hashMap.put(Long.valueOf(j2), dvVar3);
                            } else if (i8 != 3) {
                            }
                        }
                        i2 = dvVar3.c;
                        i = dvVar3.d;
                        j2 = a(i2, i);
                        hashMap.put(Long.valueOf(j2), dvVar3);
                    }
                }
                this.b = b2;
            }
        }
    }
}
