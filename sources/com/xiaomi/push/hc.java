package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class hc implements hu<hc, Object>, Serializable, Cloneable {
    private static final il b = new il("XmPushActionCollectData");
    private static final id c = new id("", (byte) 15, 1);
    public List<gq> a;

    public hc a(List<gq> list) {
        this.a = list;
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h = igVar.h();
            if (h.b == 0) {
                igVar.g();
                b();
                return;
            }
            if (h.c == 1 && h.b == 15) {
                ie l = igVar.l();
                this.a = new ArrayList(l.b);
                for (int i = 0; i < l.b; i++) {
                    gq gqVar = new gq();
                    gqVar.a(igVar);
                    this.a.add(gqVar);
                }
                igVar.m();
            } else {
                ij.a(igVar, h.b);
            }
            igVar.i();
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hc hcVar) {
        if (hcVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = hcVar.a();
        if (a2 || a3) {
            return a2 && a3 && this.a.equals(hcVar.a);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(hc hcVar) {
        int a2;
        if (!getClass().equals(hcVar.getClass())) {
            return getClass().getName().compareTo(hcVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hcVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!a() || (a2 = hv.a(this.a, hcVar.a)) == 0) {
            return 0;
        }
        return a2;
    }

    public void b() {
        if (this.a == null) {
            throw new ih("Required field 'dataCollectionItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        b();
        igVar.a(b);
        if (this.a != null) {
            igVar.a(c);
            igVar.a(new ie((byte) 12, this.a.size()));
            for (gq gqVar : this.a) {
                gqVar.b(igVar);
            }
            igVar.e();
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hc)) {
            return a((hc) obj);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<gq> list = this.a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
