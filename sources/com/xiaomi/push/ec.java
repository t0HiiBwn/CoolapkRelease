package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class ec implements hu<ec, Object>, Serializable, Cloneable {
    private static final il k = new il("StatsEvent");
    private static final id l = new id("", (byte) 3, 1);
    private static final id m = new id("", (byte) 8, 2);
    private static final id n = new id("", (byte) 8, 3);
    private static final id o = new id("", (byte) 11, 4);
    private static final id p = new id("", (byte) 11, 5);
    private static final id q = new id("", (byte) 8, 6);
    private static final id r = new id("", (byte) 11, 7);
    private static final id s = new id("", (byte) 11, 8);
    private static final id t = new id("", (byte) 8, 9);
    private static final id u = new id("", (byte) 8, 10);
    public byte a;
    public int b;
    public int c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public int i;
    public int j;
    private BitSet v = new BitSet(6);

    public ec a(byte b2) {
        this.a = b2;
        a(true);
        return this;
    }

    public ec a(int i2) {
        this.b = i2;
        b(true);
        return this;
    }

    public ec a(String str) {
        this.d = str;
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                if (!a()) {
                    throw new ih("Required field 'chid' was not found in serialized data! Struct: " + toString());
                } else if (!b()) {
                    throw new ih("Required field 'type' was not found in serialized data! Struct: " + toString());
                } else if (c()) {
                    k();
                    return;
                } else {
                    throw new ih("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
            } else {
                switch (h2.c) {
                    case 1:
                        if (h2.b == 3) {
                            this.a = igVar.q();
                            a(true);
                            continue;
                            igVar.i();
                        }
                        break;
                    case 2:
                        if (h2.b == 8) {
                            this.b = igVar.s();
                            b(true);
                            continue;
                            igVar.i();
                        }
                        break;
                    case 3:
                        if (h2.b == 8) {
                            this.c = igVar.s();
                            c(true);
                            continue;
                            igVar.i();
                        }
                        break;
                    case 4:
                        if (h2.b == 11) {
                            this.d = igVar.v();
                            continue;
                            igVar.i();
                        }
                        break;
                    case 5:
                        if (h2.b == 11) {
                            this.e = igVar.v();
                            continue;
                            igVar.i();
                        }
                        break;
                    case 6:
                        if (h2.b == 8) {
                            this.f = igVar.s();
                            d(true);
                            continue;
                            igVar.i();
                        }
                        break;
                    case 7:
                        if (h2.b == 11) {
                            this.g = igVar.v();
                            continue;
                            igVar.i();
                        }
                        break;
                    case 8:
                        if (h2.b == 11) {
                            this.h = igVar.v();
                            continue;
                            igVar.i();
                        }
                        break;
                    case 9:
                        if (h2.b == 8) {
                            this.i = igVar.s();
                            e(true);
                            continue;
                            igVar.i();
                        }
                        break;
                    case 10:
                        if (h2.b == 8) {
                            this.j = igVar.s();
                            f(true);
                            continue;
                            igVar.i();
                        }
                        break;
                }
                ij.a(igVar, h2.b);
                igVar.i();
            }
        }
    }

    public void a(boolean z) {
        this.v.set(0, z);
    }

    public boolean a() {
        return this.v.get(0);
    }

    public boolean a(ec ecVar) {
        if (ecVar == null || this.a != ecVar.a || this.b != ecVar.b || this.c != ecVar.c) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ecVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.d.equals(ecVar.d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ecVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.e.equals(ecVar.e))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ecVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f != ecVar.f)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ecVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.g.equals(ecVar.g))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ecVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.h.equals(ecVar.h))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ecVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.i != ecVar.i)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ecVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.j == ecVar.j;
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(ec ecVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        if (!getClass().equals(ecVar.getClass())) {
            return getClass().getName().compareTo(ecVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(ecVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a11 = hv.a(this.a, ecVar.a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ecVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = hv.a(this.b, ecVar.b)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ecVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = hv.a(this.c, ecVar.c)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ecVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = hv.a(this.d, ecVar.d)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ecVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = hv.a(this.e, ecVar.e)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ecVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = hv.a(this.f, ecVar.f)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ecVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = hv.a(this.g, ecVar.g)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ecVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = hv.a(this.h, ecVar.h)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ecVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = hv.a(this.i, ecVar.i)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ecVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a2 = hv.a(this.j, ecVar.j)) == 0) {
            return 0;
        }
        return a2;
    }

    public ec b(int i2) {
        this.c = i2;
        c(true);
        return this;
    }

    public ec b(String str) {
        this.e = str;
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        k();
        igVar.a(k);
        igVar.a(l);
        igVar.a(this.a);
        igVar.b();
        igVar.a(m);
        igVar.a(this.b);
        igVar.b();
        igVar.a(n);
        igVar.a(this.c);
        igVar.b();
        if (this.d != null) {
            igVar.a(o);
            igVar.a(this.d);
            igVar.b();
        }
        if (this.e != null && e()) {
            igVar.a(p);
            igVar.a(this.e);
            igVar.b();
        }
        if (f()) {
            igVar.a(q);
            igVar.a(this.f);
            igVar.b();
        }
        if (this.g != null && g()) {
            igVar.a(r);
            igVar.a(this.g);
            igVar.b();
        }
        if (this.h != null && h()) {
            igVar.a(s);
            igVar.a(this.h);
            igVar.b();
        }
        if (i()) {
            igVar.a(t);
            igVar.a(this.i);
            igVar.b();
        }
        if (j()) {
            igVar.a(u);
            igVar.a(this.j);
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public void b(boolean z) {
        this.v.set(1, z);
    }

    public boolean b() {
        return this.v.get(1);
    }

    public ec c(int i2) {
        this.f = i2;
        d(true);
        return this;
    }

    public ec c(String str) {
        this.g = str;
        return this;
    }

    public void c(boolean z) {
        this.v.set(2, z);
    }

    public boolean c() {
        return this.v.get(2);
    }

    public ec d(int i2) {
        this.i = i2;
        e(true);
        return this;
    }

    public ec d(String str) {
        this.h = str;
        return this;
    }

    public void d(boolean z) {
        this.v.set(3, z);
    }

    public boolean d() {
        return this.d != null;
    }

    public void e(boolean z) {
        this.v.set(4, z);
    }

    public boolean e() {
        return this.e != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ec)) {
            return a((ec) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.v.set(5, z);
    }

    public boolean f() {
        return this.v.get(3);
    }

    public boolean g() {
        return this.g != null;
    }

    public boolean h() {
        return this.h != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.v.get(4);
    }

    public boolean j() {
        return this.v.get(5);
    }

    public void k() {
        if (this.d == null) {
            throw new ih("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.c);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.d;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.e;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.g;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.h;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.i);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }
}
