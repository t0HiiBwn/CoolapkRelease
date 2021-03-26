package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class hm implements hu<hm, Object>, Serializable, Cloneable {
    private static final il m = new il("XmPushActionSendMessage");
    private static final id n = new id("", (byte) 11, 1);
    private static final id o = new id("", (byte) 12, 2);
    private static final id p = new id("", (byte) 11, 3);
    private static final id q = new id("", (byte) 11, 4);
    private static final id r = new id("", (byte) 11, 5);
    private static final id s = new id("", (byte) 11, 6);
    private static final id t = new id("", (byte) 11, 7);
    private static final id u = new id("", (byte) 12, 8);
    private static final id v = new id("", (byte) 2, 9);
    private static final id w = new id("", (byte) 13, 10);
    private static final id x = new id("", (byte) 11, 11);
    private static final id y = new id("", (byte) 11, 12);
    public String a;
    public gy b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public gu h;
    public boolean i = true;
    public Map<String, String> j;
    public String k;
    public String l;
    private BitSet z = new BitSet(1);

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                t();
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
                    if (h2.b == 12) {
                        gu guVar = new gu();
                        this.h = guVar;
                        guVar.a(igVar);
                        continue;
                        igVar.i();
                    }
                    break;
                case 9:
                    if (h2.b == 2) {
                        this.i = igVar.p();
                        a(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 10:
                    if (h2.b == 13) {
                        Cif j2 = igVar.j();
                        this.j = new HashMap(j2.c * 2);
                        for (int i2 = 0; i2 < j2.c; i2++) {
                            this.j.put(igVar.v(), igVar.v());
                        }
                        igVar.k();
                        continue;
                        igVar.i();
                    }
                    break;
                case 11:
                    if (h2.b == 11) {
                        this.k = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 12:
                    if (h2.b == 11) {
                        this.l = igVar.v();
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

    public boolean a(hm hmVar) {
        if (hmVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = hmVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(hmVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hmVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(hmVar.b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hmVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.c.equals(hmVar.c))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hmVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.d.equals(hmVar.d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hmVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.e.equals(hmVar.e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hmVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f.equals(hmVar.f))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hmVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.g.equals(hmVar.g))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hmVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.h.a(hmVar.h))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hmVar.n();
        if ((n2 || n3) && (!n2 || !n3 || this.i != hmVar.i)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hmVar.o();
        if ((o2 || o3) && (!o2 || !o3 || !this.j.equals(hmVar.j))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hmVar.q();
        if ((q2 || q3) && (!q2 || !q3 || !this.k.equals(hmVar.k))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hmVar.s();
        if (s2 || s3) {
            return s2 && s3 && this.l.equals(hmVar.l);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(hm hmVar) {
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
        if (!getClass().equals(hmVar.getClass())) {
            return getClass().getName().compareTo(hmVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hmVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a13 = hv.a(this.a, hmVar.a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hmVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a12 = hv.a(this.b, hmVar.b)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hmVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d() && (a11 = hv.a(this.c, hmVar.c)) != 0) {
            return a11;
        }
        int compareTo4 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hmVar.f()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (f() && (a10 = hv.a(this.d, hmVar.d)) != 0) {
            return a10;
        }
        int compareTo5 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hmVar.g()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (g() && (a9 = hv.a(this.e, hmVar.e)) != 0) {
            return a9;
        }
        int compareTo6 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hmVar.i()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (i() && (a8 = hv.a(this.f, hmVar.f)) != 0) {
            return a8;
        }
        int compareTo7 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hmVar.k()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (k() && (a7 = hv.a(this.g, hmVar.g)) != 0) {
            return a7;
        }
        int compareTo8 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hmVar.m()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m() && (a6 = hv.a(this.h, hmVar.h)) != 0) {
            return a6;
        }
        int compareTo9 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hmVar.n()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (n() && (a5 = hv.a(this.i, hmVar.i)) != 0) {
            return a5;
        }
        int compareTo10 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hmVar.o()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (o() && (a4 = hv.a(this.j, hmVar.j)) != 0) {
            return a4;
        }
        int compareTo11 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hmVar.q()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (q() && (a3 = hv.a(this.k, hmVar.k)) != 0) {
            return a3;
        }
        int compareTo12 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hmVar.s()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!s() || (a2 = hv.a(this.l, hmVar.l)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        t();
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
        if (this.e != null && g()) {
            igVar.a(r);
            igVar.a(this.e);
            igVar.b();
        }
        if (this.f != null && i()) {
            igVar.a(s);
            igVar.a(this.f);
            igVar.b();
        }
        if (this.g != null && k()) {
            igVar.a(t);
            igVar.a(this.g);
            igVar.b();
        }
        if (this.h != null && m()) {
            igVar.a(u);
            this.h.b(igVar);
            igVar.b();
        }
        if (n()) {
            igVar.a(v);
            igVar.a(this.i);
            igVar.b();
        }
        if (this.j != null && o()) {
            igVar.a(w);
            igVar.a(new Cif((byte) 11, (byte) 11, this.j.size()));
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                igVar.a(entry.getKey());
                igVar.a(entry.getValue());
            }
            igVar.d();
            igVar.b();
        }
        if (this.k != null && q()) {
            igVar.a(x);
            igVar.a(this.k);
            igVar.b();
        }
        if (this.l != null && s()) {
            igVar.a(y);
            igVar.a(this.l);
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

    public String e() {
        return this.d;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hm)) {
            return a((hm) obj);
        }
        return false;
    }

    public boolean f() {
        return this.d != null;
    }

    public boolean g() {
        return this.e != null;
    }

    public String h() {
        return this.f;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f != null;
    }

    public String j() {
        return this.g;
    }

    public boolean k() {
        return this.g != null;
    }

    public gu l() {
        return this.h;
    }

    public boolean m() {
        return this.h != null;
    }

    public boolean n() {
        return this.z.get(0);
    }

    public boolean o() {
        return this.j != null;
    }

    public String p() {
        return this.k;
    }

    public boolean q() {
        return this.k != null;
    }

    public String r() {
        return this.l;
    }

    public boolean s() {
        return this.l != null;
    }

    public void t() {
        if (this.c == null) {
            throw new ih("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new ih("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
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
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("message:");
            gu guVar = this.h;
            if (guVar == null) {
                sb.append("null");
            } else {
                sb.append(guVar);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.i);
        }
        if (o()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.j;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.k;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.l;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
