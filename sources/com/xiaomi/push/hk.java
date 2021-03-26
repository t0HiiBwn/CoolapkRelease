package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class hk implements hu<hk, Object>, Serializable, Cloneable {
    private static final id A = new id("", (byte) 11, 9);
    private static final id B = new id("", (byte) 11, 10);
    private static final id C = new id("", (byte) 10, 11);
    private static final id D = new id("", (byte) 11, 12);
    private static final id E = new id("", (byte) 11, 13);
    private static final id F = new id("", (byte) 10, 14);
    private static final id G = new id("", (byte) 11, 15);
    private static final id H = new id("", (byte) 8, 16);
    private static final id I = new id("", (byte) 11, 17);
    private static final id J = new id("", (byte) 8, 18);
    private static final id K = new id("", (byte) 11, 19);
    private static final il s = new il("XmPushActionRegistrationResult");
    private static final id t = new id("", (byte) 11, 1);
    private static final id u = new id("", (byte) 12, 2);
    private static final id v = new id("", (byte) 11, 3);
    private static final id w = new id("", (byte) 11, 4);
    private static final id x = new id("", (byte) 10, 6);
    private static final id y = new id("", (byte) 11, 7);
    private static final id z = new id("", (byte) 11, 8);
    private BitSet L = new BitSet(5);
    public String a;
    public gy b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;
    public String h;
    public String i;
    public long j;
    public String k;
    public String l;
    public long m;
    public String n;
    public int o;
    public String p;
    public int q;
    public String r;

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                if (g()) {
                    v();
                    return;
                }
                throw new ih("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
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
                case 6:
                    if (h2.b == 10) {
                        this.e = igVar.t();
                        a(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 7:
                    if (h2.b == 11) {
                        this.f = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 8:
                    if (h2.b == 11) {
                        this.g = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 9:
                    if (h2.b == 11) {
                        this.h = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 10:
                    if (h2.b == 11) {
                        this.i = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 11:
                    if (h2.b == 10) {
                        this.j = igVar.t();
                        b(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 12:
                    if (h2.b == 11) {
                        this.k = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 13:
                    if (h2.b == 11) {
                        this.l = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 14:
                    if (h2.b == 10) {
                        this.m = igVar.t();
                        c(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 15:
                    if (h2.b == 11) {
                        this.n = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 16:
                    if (h2.b == 8) {
                        this.o = igVar.s();
                        d(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 17:
                    if (h2.b == 11) {
                        this.p = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 18:
                    if (h2.b == 8) {
                        this.q = igVar.s();
                        e(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 19:
                    if (h2.b == 11) {
                        this.r = igVar.v();
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
        this.L.set(0, z2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = hkVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(hkVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hkVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(hkVar.b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hkVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.c.equals(hkVar.c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hkVar.e();
        if (((e2 || e3) && (!e2 || !e3 || !this.d.equals(hkVar.d))) || this.e != hkVar.e) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hkVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f.equals(hkVar.f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hkVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.g.equals(hkVar.g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hkVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.h.equals(hkVar.h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hkVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.i.equals(hkVar.i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hkVar.m();
        if ((m2 || m3) && (!m2 || !m3 || this.j != hkVar.j)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hkVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.k.equals(hkVar.k))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hkVar.o();
        if ((o2 || o3) && (!o2 || !o3 || !this.l.equals(hkVar.l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hkVar.p();
        if ((p2 || p3) && (!p2 || !p3 || this.m != hkVar.m)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hkVar.q();
        if ((q2 || q3) && (!q2 || !q3 || !this.n.equals(hkVar.n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hkVar.r();
        if ((r2 || r3) && (!r2 || !r3 || this.o != hkVar.o)) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hkVar.s();
        if ((s2 || s3) && (!s2 || !s3 || !this.p.equals(hkVar.p))) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hkVar.t();
        if ((t2 || t3) && (!t2 || !t3 || this.q != hkVar.q)) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = hkVar.u();
        if (u2 || u3) {
            return u2 && u3 && this.r.equals(hkVar.r);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(hk hkVar) {
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
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        if (!getClass().equals(hkVar.getClass())) {
            return getClass().getName().compareTo(hkVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hkVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a19 = hv.a(this.a, hkVar.a)) != 0) {
            return a19;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hkVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a18 = hv.a(this.b, hkVar.b)) != 0) {
            return a18;
        }
        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hkVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d() && (a17 = hv.a(this.c, hkVar.c)) != 0) {
            return a17;
        }
        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hkVar.e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (e() && (a16 = hv.a(this.d, hkVar.d)) != 0) {
            return a16;
        }
        int compareTo5 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hkVar.g()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (g() && (a15 = hv.a(this.e, hkVar.e)) != 0) {
            return a15;
        }
        int compareTo6 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hkVar.h()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (h() && (a14 = hv.a(this.f, hkVar.f)) != 0) {
            return a14;
        }
        int compareTo7 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hkVar.i()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (i() && (a13 = hv.a(this.g, hkVar.g)) != 0) {
            return a13;
        }
        int compareTo8 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hkVar.j()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (j() && (a12 = hv.a(this.h, hkVar.h)) != 0) {
            return a12;
        }
        int compareTo9 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hkVar.l()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (l() && (a11 = hv.a(this.i, hkVar.i)) != 0) {
            return a11;
        }
        int compareTo10 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hkVar.m()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m() && (a10 = hv.a(this.j, hkVar.j)) != 0) {
            return a10;
        }
        int compareTo11 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hkVar.n()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (n() && (a9 = hv.a(this.k, hkVar.k)) != 0) {
            return a9;
        }
        int compareTo12 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hkVar.o()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (o() && (a8 = hv.a(this.l, hkVar.l)) != 0) {
            return a8;
        }
        int compareTo13 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hkVar.p()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (p() && (a7 = hv.a(this.m, hkVar.m)) != 0) {
            return a7;
        }
        int compareTo14 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hkVar.q()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (q() && (a6 = hv.a(this.n, hkVar.n)) != 0) {
            return a6;
        }
        int compareTo15 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hkVar.r()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (r() && (a5 = hv.a(this.o, hkVar.o)) != 0) {
            return a5;
        }
        int compareTo16 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hkVar.s()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (s() && (a4 = hv.a(this.p, hkVar.p)) != 0) {
            return a4;
        }
        int compareTo17 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hkVar.t()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (t() && (a3 = hv.a(this.q, hkVar.q)) != 0) {
            return a3;
        }
        int compareTo18 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(hkVar.u()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (!u() || (a2 = hv.a(this.r, hkVar.r)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        v();
        igVar.a(s);
        if (this.a != null && a()) {
            igVar.a(t);
            igVar.a(this.a);
            igVar.b();
        }
        if (this.b != null && b()) {
            igVar.a(u);
            this.b.b(igVar);
            igVar.b();
        }
        if (this.c != null) {
            igVar.a(v);
            igVar.a(this.c);
            igVar.b();
        }
        if (this.d != null) {
            igVar.a(w);
            igVar.a(this.d);
            igVar.b();
        }
        igVar.a(x);
        igVar.a(this.e);
        igVar.b();
        if (this.f != null && h()) {
            igVar.a(y);
            igVar.a(this.f);
            igVar.b();
        }
        if (this.g != null && i()) {
            igVar.a(z);
            igVar.a(this.g);
            igVar.b();
        }
        if (this.h != null && j()) {
            igVar.a(A);
            igVar.a(this.h);
            igVar.b();
        }
        if (this.i != null && l()) {
            igVar.a(B);
            igVar.a(this.i);
            igVar.b();
        }
        if (m()) {
            igVar.a(C);
            igVar.a(this.j);
            igVar.b();
        }
        if (this.k != null && n()) {
            igVar.a(D);
            igVar.a(this.k);
            igVar.b();
        }
        if (this.l != null && o()) {
            igVar.a(E);
            igVar.a(this.l);
            igVar.b();
        }
        if (p()) {
            igVar.a(F);
            igVar.a(this.m);
            igVar.b();
        }
        if (this.n != null && q()) {
            igVar.a(G);
            igVar.a(this.n);
            igVar.b();
        }
        if (r()) {
            igVar.a(H);
            igVar.a(this.o);
            igVar.b();
        }
        if (this.p != null && s()) {
            igVar.a(I);
            igVar.a(this.p);
            igVar.b();
        }
        if (t()) {
            igVar.a(J);
            igVar.a(this.q);
            igVar.b();
        }
        if (this.r != null && u()) {
            igVar.a(K);
            igVar.a(this.r);
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public void b(boolean z2) {
        this.L.set(1, z2);
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.c;
    }

    public void c(boolean z2) {
        this.L.set(2, z2);
    }

    public void d(boolean z2) {
        this.L.set(3, z2);
    }

    public boolean d() {
        return this.c != null;
    }

    public void e(boolean z2) {
        this.L.set(4, z2);
    }

    public boolean e() {
        return this.d != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return a((hk) obj);
        }
        return false;
    }

    public long f() {
        return this.e;
    }

    public boolean g() {
        return this.L.get(0);
    }

    public boolean h() {
        return this.f != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.g != null;
    }

    public boolean j() {
        return this.h != null;
    }

    public String k() {
        return this.i;
    }

    public boolean l() {
        return this.i != null;
    }

    public boolean m() {
        return this.L.get(1);
    }

    public boolean n() {
        return this.k != null;
    }

    public boolean o() {
        return this.l != null;
    }

    public boolean p() {
        return this.L.get(2);
    }

    public boolean q() {
        return this.n != null;
    }

    public boolean r() {
        return this.L.get(3);
    }

    public boolean s() {
        return this.p != null;
    }

    public boolean t() {
        return this.L.get(4);
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
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
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.e);
        if (h()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("regSecret:");
            String str6 = this.h;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("packageName:");
            String str7 = this.i;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.j);
        }
        if (n()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.k;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("clientId:");
            String str9 = this.l;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.m);
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str10 = this.n;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.o);
        }
        if (s()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str11 = this.p;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (t()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.q);
        }
        if (u()) {
            sb.append(", ");
            sb.append("region:");
            String str12 = this.r;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.r != null;
    }

    public void v() {
        if (this.c == null) {
            throw new ih("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new ih("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
