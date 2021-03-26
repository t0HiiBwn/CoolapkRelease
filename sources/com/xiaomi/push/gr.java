package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class gr implements hu<gr, Object>, Serializable, Cloneable {
    private static final il d = new il("NormalConfig");
    private static final id e = new id("", (byte) 8, 1);
    private static final id f = new id("", (byte) 15, 2);
    private static final id g = new id("", (byte) 8, 3);
    public int a;
    public List<gt> b;
    public go c;
    private BitSet h = new BitSet(1);

    public int a() {
        return this.a;
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
                    if (s == 3 && h2.b == 8) {
                        this.c = go.a(igVar.s());
                        igVar.i();
                    }
                } else if (h2.b == 15) {
                    ie l = igVar.l();
                    this.b = new ArrayList(l.b);
                    for (int i = 0; i < l.b; i++) {
                        gt gtVar = new gt();
                        gtVar.a(igVar);
                        this.b.add(gtVar);
                    }
                    igVar.m();
                    igVar.i();
                }
            } else if (h2.b == 8) {
                this.a = igVar.s();
                a(true);
                igVar.i();
            }
            ij.a(igVar, h2.b);
            igVar.i();
        }
        igVar.g();
        if (b()) {
            f();
            return;
        }
        throw new ih("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.h.set(0, z);
    }

    public boolean a(gr grVar) {
        if (grVar == null || this.a != grVar.a) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = grVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.b.equals(grVar.b))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = grVar.e();
        if (e2 || e3) {
            return e2 && e3 && this.c.equals(grVar.c);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(gr grVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(grVar.getClass())) {
            return getClass().getName().compareTo(grVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(grVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b() && (a4 = hv.a(this.a, grVar.a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(grVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a3 = hv.a(this.b, grVar.b)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(grVar.e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!e() || (a2 = hv.a(this.c, grVar.c)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        f();
        igVar.a(d);
        igVar.a(e);
        igVar.a(this.a);
        igVar.b();
        if (this.b != null) {
            igVar.a(f);
            igVar.a(new ie((byte) 12, this.b.size()));
            for (gt gtVar : this.b) {
                gtVar.b(igVar);
            }
            igVar.e();
            igVar.b();
        }
        if (this.c != null && e()) {
            igVar.a(g);
            igVar.a(this.c.a());
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public boolean b() {
        return this.h.get(0);
    }

    public boolean c() {
        return this.b != null;
    }

    public go d() {
        return this.c;
    }

    public boolean e() {
        return this.c != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gr)) {
            return a((gr) obj);
        }
        return false;
    }

    public void f() {
        if (this.b == null) {
            throw new ih("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("configItems:");
        List<gt> list = this.b;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            go goVar = this.c;
            if (goVar == null) {
                sb.append("null");
            } else {
                sb.append(goVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
