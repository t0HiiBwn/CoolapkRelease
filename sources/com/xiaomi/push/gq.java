package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class gq implements hu<gq, Object>, Serializable, Cloneable {
    private static final il d = new il("DataCollectionItem");
    private static final id e = new id("", (byte) 10, 1);
    private static final id f = new id("", (byte) 8, 2);
    private static final id g = new id("", (byte) 11, 3);
    public long a;
    public gk b;
    public String c;
    private BitSet h = new BitSet(1);

    public gq a(long j) {
        this.a = j;
        a(true);
        return this;
    }

    public gq a(gk gkVar) {
        this.b = gkVar;
        return this;
    }

    public gq a(String str) {
        this.c = str;
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                break;
            }
            short s = h2.c;
            if (s != 1) {
                if (s != 2) {
                    if (s == 3 && h2.b == 11) {
                        this.c = igVar.v();
                        igVar.i();
                    }
                } else if (h2.b == 8) {
                    this.b = gk.a(igVar.s());
                    igVar.i();
                }
            } else if (h2.b == 10) {
                this.a = igVar.t();
                a(true);
                igVar.i();
            }
            ij.a(igVar, h2.b);
            igVar.i();
        }
        igVar.g();
        if (a()) {
            e();
            return;
        }
        throw new ih("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.h.set(0, z);
    }

    public boolean a() {
        return this.h.get(0);
    }

    public boolean a(gq gqVar) {
        if (gqVar == null || this.a != gqVar.a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = gqVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.equals(gqVar.b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = gqVar.d();
        if (d2 || d3) {
            return d2 && d3 && this.c.equals(gqVar.c);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(gq gqVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(gqVar.getClass())) {
            return getClass().getName().compareTo(gqVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gqVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a4 = hv.a(this.a, gqVar.a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gqVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = hv.a(this.b, gqVar.b)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gqVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!d() || (a2 = hv.a(this.c, gqVar.c)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        e();
        igVar.a(d);
        igVar.a(e);
        igVar.a(this.a);
        igVar.b();
        if (this.b != null) {
            igVar.a(f);
            igVar.a(this.b.a());
            igVar.b();
        }
        if (this.c != null) {
            igVar.a(g);
            igVar.a(this.c);
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.c;
    }

    public boolean d() {
        return this.c != null;
    }

    public void e() {
        if (this.b == null) {
            throw new ih("Required field 'collectionType' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new ih("Required field 'content' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gq)) {
            return a((gq) obj);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("collectionType:");
        gk gkVar = this.b;
        if (gkVar == null) {
            sb.append("null");
        } else {
            sb.append(gkVar);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }
}
