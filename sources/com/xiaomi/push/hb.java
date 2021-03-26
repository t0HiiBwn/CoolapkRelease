package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class hb implements hu<hb, Object>, Serializable, Cloneable {
    private static final il c = new il("XmPushActionCheckClientInfo");
    private static final id d = new id("", (byte) 8, 1);
    private static final id e = new id("", (byte) 8, 2);
    public int a;
    public int b;
    private BitSet f = new BitSet(2);

    public hb a(int i) {
        this.a = i;
        a(true);
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h = igVar.h();
            if (h.b == 0) {
                break;
            }
            short s = h.c;
            if (s != 1) {
                if (s == 2 && h.b == 8) {
                    this.b = igVar.s();
                    b(true);
                    igVar.i();
                }
            } else if (h.b == 8) {
                this.a = igVar.s();
                a(true);
                igVar.i();
            }
            ij.a(igVar, h.b);
            igVar.i();
        }
        igVar.g();
        if (!a()) {
            throw new ih("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        } else if (b()) {
            c();
        } else {
            throw new ih("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        this.f.set(0, z);
    }

    public boolean a() {
        return this.f.get(0);
    }

    public boolean a(hb hbVar) {
        return hbVar != null && this.a == hbVar.a && this.b == hbVar.b;
    }

    /* renamed from: b */
    public int compareTo(hb hbVar) {
        int a2;
        int a3;
        if (!getClass().equals(hbVar.getClass())) {
            return getClass().getName().compareTo(hbVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hbVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a3 = hv.a(this.a, hbVar.a)) != 0) {
            return a3;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hbVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (!b() || (a2 = hv.a(this.b, hbVar.b)) == 0) {
            return 0;
        }
        return a2;
    }

    public hb b(int i) {
        this.b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        c();
        igVar.a(c);
        igVar.a(d);
        igVar.a(this.a);
        igVar.b();
        igVar.a(e);
        igVar.a(this.b);
        igVar.b();
        igVar.c();
        igVar.a();
    }

    public void b(boolean z) {
        this.f.set(1, z);
    }

    public boolean b() {
        return this.f.get(1);
    }

    public void c() {
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hb)) {
            return a((hb) obj);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.a + ", pluginConfigVersion:" + this.b + ")";
    }
}
