package com.loc;

import java.util.ArrayList;
import java.util.List;

/* compiled from: RssiManager */
public final class ct {

    /* compiled from: RssiManager */
    public static class a implements cr {
        private int a;
        private int b;
        private int c;

        a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // com.loc.cr
        public final long a() {
            return ct.a(this.a, this.b);
        }

        @Override // com.loc.cr
        public final int b() {
            return this.c;
        }
    }

    /* compiled from: RssiManager */
    public static class b implements cr {
        private long a;
        private int b;

        b(long j, int i) {
            this.a = j;
            this.b = i;
        }

        @Override // com.loc.cr
        public final long a() {
            return this.a;
        }

        @Override // com.loc.cr
        public final int b() {
            return this.b;
        }
    }

    public static long a(int i, int i2) {
        return (((long) i2) & 4294967295L) | ((((long) i) & 4294967295L) << 32);
    }

    public static synchronized short a(long j) {
        short a2;
        synchronized (ct.class) {
            a2 = cs.a().a(j);
        }
        return a2;
    }

    public static synchronized void a(List<cw> list) {
        a aVar;
        synchronized (ct.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (cw cwVar : list) {
                        if (cwVar instanceof cy) {
                            cy cyVar = (cy) cwVar;
                            aVar = new a(cyVar.j, cyVar.k, cyVar.c);
                        } else if (cwVar instanceof cz) {
                            cz czVar = (cz) cwVar;
                            aVar = new a(czVar.j, czVar.k, czVar.c);
                        } else if (cwVar instanceof da) {
                            da daVar = (da) cwVar;
                            aVar = new a(daVar.j, daVar.k, daVar.c);
                        } else if (cwVar instanceof cx) {
                            cx cxVar = (cx) cwVar;
                            aVar = new a(cxVar.k, cxVar.f1357l, cxVar.c);
                        }
                        arrayList.add(aVar);
                    }
                    cs.a().a(arrayList);
                }
            }
        }
    }

    public static synchronized short b(long j) {
        short b2;
        synchronized (ct.class) {
            b2 = cs.a().b(j);
        }
        return b2;
    }

    public static synchronized void b(List<dd> list) {
        synchronized (ct.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (dd ddVar : list) {
                        arrayList.add(new b(ddVar.a, ddVar.c));
                    }
                    cs.a().b(arrayList);
                }
            }
        }
    }
}
