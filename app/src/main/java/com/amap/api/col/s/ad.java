package com.amap.api.col.s;

import java.util.HashMap;

/* compiled from: RequestCacheControl */
public class ad {
    private static volatile ad a;
    private HashMap<String, ae> b = new HashMap<>();

    public static ad a() {
        if (a == null) {
            synchronized (ad.class) {
                if (a == null) {
                    a = new ad();
                }
            }
        }
        return a;
    }

    public final synchronized ae a(String str) {
        return this.b.get(str);
    }

    public final synchronized void a(String str, ae aeVar) {
        this.b.put(str, aeVar);
    }

    public final c a(b bVar) {
        c a2;
        if (bVar == null) {
            return null;
        }
        for (ae aeVar : this.b.values()) {
            if (!(aeVar == null || (a2 = aeVar.a(bVar)) == null)) {
                return a2;
            }
        }
        return null;
    }

    public final void a(b bVar, Object obj) {
        for (ae aeVar : this.b.values()) {
            if (aeVar != null) {
                aeVar.a(bVar, obj);
            }
        }
    }

    public final boolean b(b bVar) {
        if (bVar == null) {
            return false;
        }
        for (ae aeVar : this.b.values()) {
            if (aeVar != null && aeVar.b(bVar)) {
                return true;
            }
        }
        return false;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            for (ae aeVar : this.b.values()) {
                if (aeVar != null) {
                    aeVar.a(aVar);
                }
            }
        }
    }

    public final void a(String str, a aVar) {
        ae aeVar;
        if (str != null && aVar != null && (aeVar = this.b.get(str)) != null) {
            aeVar.a(aVar);
        }
    }

    /* compiled from: RequestCacheControl */
    static class c {
        Object a;
        boolean b;

        public c(Object obj, boolean z) {
            this.a = obj;
            this.b = z;
        }
    }

    /* compiled from: RequestCacheControl */
    static class b {
        String a;
        Object b;

        b() {
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                b bVar = (b) obj;
                String str = this.a;
                if (str == null) {
                    return bVar.a == null && this.b == bVar.b;
                }
                if (str.equals(bVar.a) && this.b == bVar.b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            Object obj = this.b;
            if (obj != null) {
                i = obj.hashCode();
            }
            return hashCode + i;
        }
    }

    /* compiled from: RequestCacheControl */
    static class a {
        private boolean a = true;
        private long b = 86400;
        private int c = 10;
        private double d = 0.0d;

        a() {
        }

        public final boolean a() {
            return this.a;
        }

        public final void a(boolean z) {
            this.a = z;
        }

        public final long b() {
            return this.b;
        }

        public final void a(long j) {
            this.b = j;
        }

        public final int c() {
            return this.c;
        }

        public final void a(int i) {
            this.c = i;
        }

        public final double d() {
            return this.d;
        }

        public final void a(double d2) {
            this.d = d2;
        }
    }
}
