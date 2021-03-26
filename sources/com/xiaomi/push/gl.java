package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class gl implements hu<gl, Object>, Serializable, Cloneable {
    private static final il b = new il("ClientUploadData");
    private static final id c = new id("", (byte) 15, 1);
    public List<gm> a;

    public int a() {
        List<gm> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void a(gm gmVar) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(gmVar);
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
                    gm gmVar = new gm();
                    gmVar.a(igVar);
                    this.a.add(gmVar);
                }
                igVar.m();
            } else {
                ij.a(igVar, h.b);
            }
            igVar.i();
        }
    }

    public boolean a(gl glVar) {
        if (glVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = glVar.b();
        if (b2 || b3) {
            return b2 && b3 && this.a.equals(glVar.a);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(gl glVar) {
        int a2;
        if (!getClass().equals(glVar.getClass())) {
            return getClass().getName().compareTo(glVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(glVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!b() || (a2 = hv.a(this.a, glVar.a)) == 0) {
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
            for (gm gmVar : this.a) {
                gmVar.b(igVar);
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
            throw new ih("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gl)) {
            return a((gl) obj);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<gm> list = this.a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
