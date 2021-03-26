package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class hh implements hu<hh, Object>, Serializable, Cloneable {
    private static final il b = new il("XmPushActionNormalConfig");
    private static final id c = new id("", (byte) 15, 1);
    public List<gr> a;

    public List<gr> a() {
        return this.a;
    }

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h = igVar.h();
            if (h.b == 0) {
                igVar.g();
                c();
                return;
            }
            if (h.c == 1 && h.b == 15) {
                ie l = igVar.l();
                this.a = new ArrayList(l.b);
                for (int i = 0; i < l.b; i++) {
                    gr grVar = new gr();
                    grVar.a(igVar);
                    this.a.add(grVar);
                }
                igVar.m();
            } else {
                ij.a(igVar, h.b);
            }
            igVar.i();
        }
    }

    public boolean a(hh hhVar) {
        if (hhVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hhVar.b();
        if (b2 || b3) {
            return b2 && b3 && this.a.equals(hhVar.a);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(hh hhVar) {
        int a2;
        if (!getClass().equals(hhVar.getClass())) {
            return getClass().getName().compareTo(hhVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hhVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!b() || (a2 = hv.a(this.a, hhVar.a)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        c();
        igVar.a(b);
        if (this.a != null) {
            igVar.a(c);
            igVar.a(new ie((byte) 12, this.a.size()));
            for (gr grVar : this.a) {
                grVar.b(igVar);
            }
            igVar.e();
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public boolean b() {
        return this.a != null;
    }

    public void c() {
        if (this.a == null) {
            throw new ih("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hh)) {
            return a((hh) obj);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<gr> list = this.a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
