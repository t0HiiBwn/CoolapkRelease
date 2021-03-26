package com.loc;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CellCollector */
public final class bx {
    private cw a;
    private cw b;
    private dc c;
    private a d = new a();
    private final List<cw> e = new ArrayList(3);

    /* compiled from: CellCollector */
    public static class a {
        public byte a;
        public String b;
        public cw c;
        public cw d;
        public cw e;
        public List<cw> f = new ArrayList();
        public List<cw> g = new ArrayList();

        public static boolean a(cw cwVar, cw cwVar2) {
            if (cwVar == null || cwVar2 == null) {
                return (cwVar == null) == (cwVar2 == null);
            } else if ((cwVar instanceof cy) && (cwVar2 instanceof cy)) {
                cy cyVar = (cy) cwVar;
                cy cyVar2 = (cy) cwVar2;
                return cyVar.j == cyVar2.j && cyVar.k == cyVar2.k;
            } else if ((cwVar instanceof cx) && (cwVar2 instanceof cx)) {
                cx cxVar = (cx) cwVar;
                cx cxVar2 = (cx) cwVar2;
                return cxVar.l == cxVar2.l && cxVar.k == cxVar2.k && cxVar.j == cxVar2.j;
            } else if (!(cwVar instanceof cz) || !(cwVar2 instanceof cz)) {
                if ((cwVar instanceof da) && (cwVar2 instanceof da)) {
                    da daVar = (da) cwVar;
                    da daVar2 = (da) cwVar2;
                    if (daVar.j == daVar2.j && daVar.k == daVar2.k) {
                        return true;
                    }
                }
                return false;
            } else {
                cz czVar = (cz) cwVar;
                cz czVar2 = (cz) cwVar2;
                return czVar.j == czVar2.j && czVar.k == czVar2.k;
            }
        }

        public final void a() {
            this.a = 0;
            this.b = "";
            this.c = null;
            this.d = null;
            this.e = null;
            this.f.clear();
            this.g.clear();
        }

        public final String toString() {
            return "CellInfo{radio=" + ((int) this.a) + ", operator='" + this.b + "', mainCell=" + this.c + ", mainOldInterCell=" + this.d + ", mainNewInterCell=" + this.e + ", cells=" + this.f + ", historyMainCellList=" + this.g + '}';
        }
    }

    final a a(dc dcVar, boolean z, byte b2, String str, List<cw> list) {
        List<cw> list2;
        if (z) {
            this.d.a();
            return null;
        }
        a aVar = this.d;
        aVar.a();
        aVar.a = b2;
        aVar.b = str;
        if (list != null) {
            aVar.f.addAll(list);
            for (cw cwVar : aVar.f) {
                if (!cwVar.i && cwVar.h) {
                    aVar.d = cwVar;
                } else if (cwVar.i && cwVar.h) {
                    aVar.e = cwVar;
                }
            }
        }
        aVar.c = aVar.d == null ? aVar.e : aVar.d;
        if (this.d.c == null) {
            return null;
        }
        boolean z2 = true;
        if (this.c != null) {
            if (!(dcVar.a(this.c) > ((double) ((dcVar.g > 10.0f ? 1 : (dcVar.g == 10.0f ? 0 : -1)) > 0 ? 2000.0f : (dcVar.g > 2.0f ? 1 : (dcVar.g == 2.0f ? 0 : -1)) > 0 ? 500.0f : 100.0f))) && a.a(this.d.d, this.a) && a.a(this.d.e, this.b)) {
                z2 = false;
            }
        }
        if (!z2) {
            return null;
        }
        this.a = this.d.d;
        this.b = this.d.e;
        this.c = dcVar;
        ct.a(this.d.f);
        a aVar2 = this.d;
        synchronized (this.e) {
            for (cw cwVar2 : aVar2.f) {
                if (cwVar2 != null && cwVar2.h) {
                    cw a2 = cwVar2.clone();
                    a2.e = SystemClock.elapsedRealtime();
                    int size = this.e.size();
                    if (size == 0) {
                        list2 = this.e;
                    } else {
                        long j = Long.MAX_VALUE;
                        int i = -1;
                        int i2 = 0;
                        int i3 = -1;
                        while (true) {
                            if (i2 >= size) {
                                i = i3;
                                break;
                            }
                            cw cwVar3 = this.e.get(i2);
                            if (!a2.equals(cwVar3)) {
                                j = Math.min(j, cwVar3.e);
                                if (j == cwVar3.e) {
                                    i3 = i2;
                                }
                                i2++;
                            } else if (a2.c != cwVar3.c) {
                                cwVar3.e = (long) a2.c;
                                cwVar3.c = a2.c;
                            }
                        }
                        if (i >= 0) {
                            if (size < 3) {
                                list2 = this.e;
                            } else if (a2.e > j && i < size) {
                                this.e.remove(i);
                                list2 = this.e;
                            }
                        }
                    }
                    list2.add(a2);
                }
            }
            this.d.g.clear();
            this.d.g.addAll(this.e);
        }
        return this.d;
    }
}
