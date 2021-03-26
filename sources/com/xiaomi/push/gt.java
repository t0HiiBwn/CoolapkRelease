package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class gt implements hu<gt, Object>, Serializable, Cloneable {
    private static final il h = new il("OnlineConfigItem");
    private static final id i = new id("", (byte) 8, 1);
    private static final id j = new id("", (byte) 8, 2);
    private static final id k = new id("", (byte) 2, 3);
    private static final id l = new id("", (byte) 8, 4);
    private static final id m = new id("", (byte) 10, 5);
    private static final id n = new id("", (byte) 11, 6);
    private static final id o = new id("", (byte) 2, 7);
    public int a;
    public int b;
    public boolean c;
    public int d;
    public long e;
    public String f;
    public boolean g;
    private BitSet p = new BitSet(6);

    public int a() {
        return this.a;
    }

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                n();
                return;
            }
            switch (h2.c) {
                case 1:
                    if (h2.b == 8) {
                        this.a = igVar.s();
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
                    if (h2.b == 2) {
                        this.c = igVar.p();
                        c(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 4:
                    if (h2.b == 8) {
                        this.d = igVar.s();
                        d(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 5:
                    if (h2.b == 10) {
                        this.e = igVar.t();
                        e(true);
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
                    if (h2.b == 2) {
                        this.g = igVar.p();
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

    public void a(boolean z) {
        this.p.set(0, z);
    }

    public boolean a(gt gtVar) {
        if (gtVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = gtVar.b();
        if ((b2 || b3) && (!b2 || !b3 || this.a != gtVar.a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = gtVar.d();
        if ((d2 || d3) && (!d2 || !d3 || this.b != gtVar.b)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = gtVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.c != gtVar.c)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = gtVar.g();
        if ((g2 || g3) && (!g2 || !g3 || this.d != gtVar.d)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = gtVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.e != gtVar.e)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = gtVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f.equals(gtVar.f))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = gtVar.m();
        if (m2 || m3) {
            return m2 && m3 && this.g == gtVar.g;
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(gt gtVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(gtVar.getClass())) {
            return getClass().getName().compareTo(gtVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gtVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b() && (a8 = hv.a(this.a, gtVar.a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gtVar.d()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (d() && (a7 = hv.a(this.b, gtVar.b)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gtVar.e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (e() && (a6 = hv.a(this.c, gtVar.c)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gtVar.g()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (g() && (a5 = hv.a(this.d, gtVar.d)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gtVar.i()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (i() && (a4 = hv.a(this.e, gtVar.e)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gtVar.k()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (k() && (a3 = hv.a(this.f, gtVar.f)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gtVar.m()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!m() || (a2 = hv.a(this.g, gtVar.g)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        n();
        igVar.a(h);
        if (b()) {
            igVar.a(i);
            igVar.a(this.a);
            igVar.b();
        }
        if (d()) {
            igVar.a(j);
            igVar.a(this.b);
            igVar.b();
        }
        if (e()) {
            igVar.a(k);
            igVar.a(this.c);
            igVar.b();
        }
        if (g()) {
            igVar.a(l);
            igVar.a(this.d);
            igVar.b();
        }
        if (i()) {
            igVar.a(m);
            igVar.a(this.e);
            igVar.b();
        }
        if (this.f != null && k()) {
            igVar.a(n);
            igVar.a(this.f);
            igVar.b();
        }
        if (m()) {
            igVar.a(o);
            igVar.a(this.g);
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public void b(boolean z) {
        this.p.set(1, z);
    }

    public boolean b() {
        return this.p.get(0);
    }

    public int c() {
        return this.b;
    }

    public void c(boolean z) {
        this.p.set(2, z);
    }

    public void d(boolean z) {
        this.p.set(3, z);
    }

    public boolean d() {
        return this.p.get(1);
    }

    public void e(boolean z) {
        this.p.set(4, z);
    }

    public boolean e() {
        return this.p.get(2);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gt)) {
            return a((gt) obj);
        }
        return false;
    }

    public int f() {
        return this.d;
    }

    public void f(boolean z) {
        this.p.set(5, z);
    }

    public boolean g() {
        return this.p.get(3);
    }

    public long h() {
        return this.e;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.p.get(4);
    }

    public String j() {
        return this.f;
    }

    public boolean k() {
        return this.f != null;
    }

    public boolean l() {
        return this.g;
    }

    public boolean m() {
        return this.p.get(5);
    }

    public void n() {
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = false;
        if (b()) {
            sb.append("key:");
            sb.append(this.a);
            z = false;
        } else {
            z = true;
        }
        if (d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.b);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.c);
            z = false;
        }
        if (g()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.d);
            z = false;
        }
        if (i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.e);
            z = false;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f;
            if (str == null) {
                str = "null";
            }
            sb.append(str);
        } else {
            z2 = z;
        }
        if (m()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.g);
        }
        sb.append(")");
        return sb.toString();
    }
}
