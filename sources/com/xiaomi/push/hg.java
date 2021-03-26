package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class hg implements hu<hg, Object>, Serializable, Cloneable {
    private static final il b = new il("XmPushActionCustomConfig");
    private static final id c = new id("", (byte) 15, 1);
    public List<gt> a;

    public List<gt> a() {
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
                    gt gtVar = new gt();
                    gtVar.a(igVar);
                    this.a.add(gtVar);
                }
                igVar.m();
            } else {
                ij.a(igVar, h.b);
            }
            igVar.i();
        }
    }

    public boolean a(hg hgVar) {
        if (hgVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hgVar.b();
        if (b2 || b3) {
            return b2 && b3 && this.a.equals(hgVar.a);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(hg hgVar) {
        int a2;
        if (!getClass().equals(hgVar.getClass())) {
            return getClass().getName().compareTo(hgVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hgVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!b() || (a2 = hv.a(this.a, hgVar.a)) == 0) {
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
            for (gt gtVar : this.a) {
                gtVar.b(igVar);
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
            throw new ih("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hg)) {
            return a((hg) obj);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<gt> list = this.a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
