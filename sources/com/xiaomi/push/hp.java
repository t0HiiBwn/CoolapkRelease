package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class hp implements hu<hp, Object>, Serializable, Cloneable {
    private static final il m = new il("XmPushActionUnRegistration");
    private static final id n = new id("", (byte) 11, 1);
    private static final id o = new id("", (byte) 12, 2);
    private static final id p = new id("", (byte) 11, 3);
    private static final id q = new id("", (byte) 11, 4);
    private static final id r = new id("", (byte) 11, 5);
    private static final id s = new id("", (byte) 11, 6);
    private static final id t = new id("", (byte) 11, 7);
    private static final id u = new id("", (byte) 11, 8);
    private static final id v = new id("", (byte) 11, 9);
    private static final id w = new id("", (byte) 11, 10);
    private static final id x = new id("", (byte) 2, 11);
    private static final id y = new id("", (byte) 10, 12);
    public String a;
    public gy b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public boolean k = true;
    public long l;
    private BitSet z = new BitSet(2);

    public hp a(String str) {
        this.c = str;
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                m();
                return;
            }
            switch (h2.c) {
                case 1:
                    if (h2.b == 11) {
                        this.a = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 2:
                    if (h2.b == 12) {
                        gy gyVar = new gy();
                        this.b = gyVar;
                        gyVar.a(igVar);
                        continue;
                        igVar.i();
                    }
                    break;
                case 3:
                    if (h2.b == 11) {
                        this.c = igVar.v();
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
                    if (h2.b == 11) {
                        this.f = igVar.v();
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
                    if (h2.b == 11) {
                        this.i = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 10:
                    if (h2.b == 11) {
                        this.j = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 11:
                    if (h2.b == 2) {
                        this.k = igVar.p();
                        a(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 12:
                    if (h2.b == 10) {
                        this.l = igVar.t();
                        b(true);
                        continue;
                        igVar.i();
                    }
                    break;
            }
            ij.a(igVar, h2.b);
            igVar.i();
        }
    }

    public void a(boolean z2) {
        this.z.set(0, z2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = hpVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(hpVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hpVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(hpVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hpVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(hpVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hpVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.d.equals(hpVar.d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hpVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.e.equals(hpVar.e))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hpVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f.equals(hpVar.f))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hpVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.g.equals(hpVar.g))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hpVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.h.equals(hpVar.h))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hpVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.i.equals(hpVar.i))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hpVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.j.equals(hpVar.j))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hpVar.k();
        if ((k2 || k3) && (!k2 || !k3 || this.k != hpVar.k)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hpVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.l == hpVar.l;
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(hp hpVar) {
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
        int a12;
        int a13;
        if (!getClass().equals(hpVar.getClass())) {
            return getClass().getName().compareTo(hpVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hpVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a13 = hv.a(this.a, hpVar.a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hpVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a12 = hv.a(this.b, hpVar.b)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hpVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a11 = hv.a(this.c, hpVar.c)) != 0) {
            return a11;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hpVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a10 = hv.a(this.d, hpVar.d)) != 0) {
            return a10;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hpVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a9 = hv.a(this.e, hpVar.e)) != 0) {
            return a9;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hpVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a8 = hv.a(this.f, hpVar.f)) != 0) {
            return a8;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hpVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a7 = hv.a(this.g, hpVar.g)) != 0) {
            return a7;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hpVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a6 = hv.a(this.h, hpVar.h)) != 0) {
            return a6;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hpVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a5 = hv.a(this.i, hpVar.i)) != 0) {
            return a5;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hpVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a4 = hv.a(this.j, hpVar.j)) != 0) {
            return a4;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hpVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a3 = hv.a(this.k, hpVar.k)) != 0) {
            return a3;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hpVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!l() || (a2 = hv.a(this.l, hpVar.l)) == 0) {
            return 0;
        }
        return a2;
    }

    public hp b(String str) {
        this.d = str;
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        m();
        igVar.a(m);
        if (this.a != null && a()) {
            igVar.a(n);
            igVar.a(this.a);
            igVar.b();
        }
        if (this.b != null && b()) {
            igVar.a(o);
            this.b.b(igVar);
            igVar.b();
        }
        if (this.c != null) {
            igVar.a(p);
            igVar.a(this.c);
            igVar.b();
        }
        if (this.d != null) {
            igVar.a(q);
            igVar.a(this.d);
            igVar.b();
        }
        if (this.e != null && e()) {
            igVar.a(r);
            igVar.a(this.e);
            igVar.b();
        }
        if (this.f != null && f()) {
            igVar.a(s);
            igVar.a(this.f);
            igVar.b();
        }
        if (this.g != null && g()) {
            igVar.a(t);
            igVar.a(this.g);
            igVar.b();
        }
        if (this.h != null && h()) {
            igVar.a(u);
            igVar.a(this.h);
            igVar.b();
        }
        if (this.i != null && i()) {
            igVar.a(v);
            igVar.a(this.i);
            igVar.b();
        }
        if (this.j != null && j()) {
            igVar.a(w);
            igVar.a(this.j);
            igVar.b();
        }
        if (k()) {
            igVar.a(x);
            igVar.a(this.k);
            igVar.b();
        }
        if (l()) {
            igVar.a(y);
            igVar.a(this.l);
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public void b(boolean z2) {
        this.z.set(1, z2);
    }

    public boolean b() {
        return this.b != null;
    }

    public hp c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public hp d(String str) {
        this.g = str;
        return this;
    }

    public boolean d() {
        return this.d != null;
    }

    public hp e(String str) {
        this.h = str;
        return this;
    }

    public boolean e() {
        return this.e != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return a((hp) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f != null;
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
        return this.i != null;
    }

    public boolean j() {
        return this.j != null;
    }

    public boolean k() {
        return this.z.get(0);
    }

    public boolean l() {
        return this.z.get(1);
    }

    public void m() {
        if (this.c == null) {
            throw new ih("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new ih("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z3 = false;
        if (a()) {
            sb.append("debug:");
            String str = this.a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            gy gyVar = this.b;
            if (gyVar == null) {
                sb.append("null");
            } else {
                sb.append(gyVar);
            }
        } else {
            z3 = z2;
        }
        if (!z3) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.h;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.i;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.j;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.k);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.l);
        }
        sb.append(")");
        return sb.toString();
    }
}
