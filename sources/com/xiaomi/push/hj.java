package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class hj implements hu<hj, Object>, Serializable, Cloneable {
    private static final il C = new il("XmPushActionRegistration");
    private static final id D = new id("", (byte) 11, 1);
    private static final id E = new id("", (byte) 12, 2);
    private static final id F = new id("", (byte) 11, 3);
    private static final id G = new id("", (byte) 11, 4);
    private static final id H = new id("", (byte) 11, 5);
    private static final id I = new id("", (byte) 11, 6);
    private static final id J = new id("", (byte) 11, 7);
    private static final id K = new id("", (byte) 11, 8);
    private static final id L = new id("", (byte) 11, 9);
    private static final id M = new id("", (byte) 11, 10);
    private static final id N = new id("", (byte) 11, 11);
    private static final id O = new id("", (byte) 11, 12);
    private static final id P = new id("", (byte) 8, 13);
    private static final id Q = new id("", (byte) 8, 14);
    private static final id R = new id("", (byte) 11, 15);
    private static final id S = new id("", (byte) 11, 16);
    private static final id T = new id("", (byte) 11, 17);
    private static final id U = new id("", (byte) 11, 18);
    private static final id V = new id("", (byte) 8, 19);
    private static final id W = new id("", (byte) 8, 20);
    private static final id X = new id("", (byte) 2, 21);
    private static final id Y = new id("", (byte) 10, 22);
    private static final id Z = new id("", (byte) 10, 23);
    private static final id aa = new id("", (byte) 11, 24);
    private static final id ab = new id("", (byte) 11, 25);
    private static final id ac = new id("", (byte) 13, 100);
    private static final id ad = new id("", (byte) 2, 101);
    private static final id ae = new id("", (byte) 11, 102);
    public boolean A = false;
    public String B;
    public String a;
    private BitSet af = new BitSet(7);
    public gy b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public int m;
    public int n;
    public String o;
    public String p;
    public String q;
    public String r;
    public int s;
    public gx t;
    public boolean u = true;
    public long v;
    public long w;
    public String x;
    public String y;
    public Map<String, String> z;

    public boolean A() {
        return this.x != null;
    }

    public boolean B() {
        return this.y != null;
    }

    public boolean C() {
        return this.z != null;
    }

    public boolean D() {
        return this.af.get(6);
    }

    public boolean E() {
        return this.B != null;
    }

    public void F() {
        if (this.c == null) {
            throw new ih("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new ih("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.g == null) {
            throw new ih("Required field 'token' was not present! Struct: " + toString());
        }
    }

    public hj a(int i2) {
        this.m = i2;
        a(true);
        return this;
    }

    public hj a(gx gxVar) {
        this.t = gxVar;
        return this;
    }

    public hj a(String str) {
        this.c = str;
        return this;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                F();
                return;
            }
            short s2 = h2.c;
            switch (s2) {
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
                case 13:
                    if (h2.b == 8) {
                        this.m = igVar.s();
                        a(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 14:
                    if (h2.b == 8) {
                        this.n = igVar.s();
                        b(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 15:
                    if (h2.b == 11) {
                        this.o = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 16:
                    if (h2.b == 11) {
                        this.p = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 17:
                    if (h2.b == 11) {
                        this.q = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 18:
                    if (h2.b == 11) {
                        this.r = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 19:
                    if (h2.b == 8) {
                        this.s = igVar.s();
                        c(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 20:
                    if (h2.b == 8) {
                        this.t = gx.a(igVar.s());
                        continue;
                        igVar.i();
                    }
                    break;
                case 21:
                    if (h2.b == 2) {
                        this.u = igVar.p();
                        d(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 22:
                    if (h2.b == 10) {
                        this.v = igVar.t();
                        e(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 23:
                    if (h2.b == 10) {
                        this.w = igVar.t();
                        f(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 24:
                    if (h2.b == 11) {
                        this.x = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 25:
                    if (h2.b == 11) {
                        this.y = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                default:
                    switch (s2) {
                        case 100:
                            if (h2.b == 13) {
                                Cif j2 = igVar.j();
                                this.z = new HashMap(j2.c * 2);
                                for (int i2 = 0; i2 < j2.c; i2++) {
                                    this.z.put(igVar.v(), igVar.v());
                                }
                                igVar.k();
                                break;
                            }
                            break;
                        case 101:
                            if (h2.b == 2) {
                                this.A = igVar.p();
                                g(true);
                                break;
                            }
                            break;
                        case 102:
                            if (h2.b == 11) {
                                this.B = igVar.v();
                                continue;
                            }
                            break;
                    }
                    igVar.i();
                    break;
            }
            ij.a(igVar, h2.b);
            igVar.i();
        }
    }

    public void a(boolean z2) {
        this.af.set(0, z2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = hjVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(hjVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hjVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(hjVar.b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hjVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.c.equals(hjVar.c))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hjVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.d.equals(hjVar.d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hjVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.e.equals(hjVar.e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hjVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f.equals(hjVar.f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hjVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.g.equals(hjVar.g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hjVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.h.equals(hjVar.h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hjVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.i.equals(hjVar.i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hjVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.j.equals(hjVar.j))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hjVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.k.equals(hjVar.k))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hjVar.o();
        if ((o2 || o3) && (!o2 || !o3 || !this.l.equals(hjVar.l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hjVar.p();
        if ((p2 || p3) && (!p2 || !p3 || this.m != hjVar.m)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hjVar.q();
        if ((q2 || q3) && (!q2 || !q3 || this.n != hjVar.n)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hjVar.r();
        if ((r2 || r3) && (!r2 || !r3 || !this.o.equals(hjVar.o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hjVar.s();
        if ((s2 || s3) && (!s2 || !s3 || !this.p.equals(hjVar.p))) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hjVar.t();
        if ((t2 || t3) && (!t2 || !t3 || !this.q.equals(hjVar.q))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = hjVar.u();
        if ((u2 || u3) && (!u2 || !u3 || !this.r.equals(hjVar.r))) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = hjVar.v();
        if ((v2 || v3) && (!v2 || !v3 || this.s != hjVar.s)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = hjVar.w();
        if ((w2 || w3) && (!w2 || !w3 || !this.t.equals(hjVar.t))) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = hjVar.x();
        if ((x2 || x3) && (!x2 || !x3 || this.u != hjVar.u)) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = hjVar.y();
        if ((y2 || y3) && (!y2 || !y3 || this.v != hjVar.v)) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = hjVar.z();
        if ((z2 || z3) && (!z2 || !z3 || this.w != hjVar.w)) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = hjVar.A();
        if ((A2 || A3) && (!A2 || !A3 || !this.x.equals(hjVar.x))) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = hjVar.B();
        if ((B2 || B3) && (!B2 || !B3 || !this.y.equals(hjVar.y))) {
            return false;
        }
        boolean C2 = C();
        boolean C3 = hjVar.C();
        if ((C2 || C3) && (!C2 || !C3 || !this.z.equals(hjVar.z))) {
            return false;
        }
        boolean D2 = D();
        boolean D3 = hjVar.D();
        if ((D2 || D3) && (!D2 || !D3 || this.A != hjVar.A)) {
            return false;
        }
        boolean E2 = E();
        boolean E3 = hjVar.E();
        if (E2 || E3) {
            return E2 && E3 && this.B.equals(hjVar.B);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(hj hjVar) {
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
        int a20;
        int a21;
        int a22;
        int a23;
        int a24;
        int a25;
        int a26;
        int a27;
        int a28;
        int a29;
        if (!getClass().equals(hjVar.getClass())) {
            return getClass().getName().compareTo(hjVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hjVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a29 = hv.a(this.a, hjVar.a)) != 0) {
            return a29;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hjVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a28 = hv.a(this.b, hjVar.b)) != 0) {
            return a28;
        }
        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hjVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d() && (a27 = hv.a(this.c, hjVar.c)) != 0) {
            return a27;
        }
        int compareTo4 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hjVar.f()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (f() && (a26 = hv.a(this.d, hjVar.d)) != 0) {
            return a26;
        }
        int compareTo5 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hjVar.g()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (g() && (a25 = hv.a(this.e, hjVar.e)) != 0) {
            return a25;
        }
        int compareTo6 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hjVar.h()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (h() && (a24 = hv.a(this.f, hjVar.f)) != 0) {
            return a24;
        }
        int compareTo7 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hjVar.j()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (j() && (a23 = hv.a(this.g, hjVar.g)) != 0) {
            return a23;
        }
        int compareTo8 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hjVar.k()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (k() && (a22 = hv.a(this.h, hjVar.h)) != 0) {
            return a22;
        }
        int compareTo9 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hjVar.l()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (l() && (a21 = hv.a(this.i, hjVar.i)) != 0) {
            return a21;
        }
        int compareTo10 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hjVar.m()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m() && (a20 = hv.a(this.j, hjVar.j)) != 0) {
            return a20;
        }
        int compareTo11 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hjVar.n()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (n() && (a19 = hv.a(this.k, hjVar.k)) != 0) {
            return a19;
        }
        int compareTo12 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hjVar.o()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (o() && (a18 = hv.a(this.l, hjVar.l)) != 0) {
            return a18;
        }
        int compareTo13 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hjVar.p()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (p() && (a17 = hv.a(this.m, hjVar.m)) != 0) {
            return a17;
        }
        int compareTo14 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hjVar.q()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (q() && (a16 = hv.a(this.n, hjVar.n)) != 0) {
            return a16;
        }
        int compareTo15 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hjVar.r()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (r() && (a15 = hv.a(this.o, hjVar.o)) != 0) {
            return a15;
        }
        int compareTo16 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hjVar.s()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (s() && (a14 = hv.a(this.p, hjVar.p)) != 0) {
            return a14;
        }
        int compareTo17 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hjVar.t()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (t() && (a13 = hv.a(this.q, hjVar.q)) != 0) {
            return a13;
        }
        int compareTo18 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(hjVar.u()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (u() && (a12 = hv.a(this.r, hjVar.r)) != 0) {
            return a12;
        }
        int compareTo19 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(hjVar.v()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (v() && (a11 = hv.a(this.s, hjVar.s)) != 0) {
            return a11;
        }
        int compareTo20 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(hjVar.w()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (w() && (a10 = hv.a(this.t, hjVar.t)) != 0) {
            return a10;
        }
        int compareTo21 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(hjVar.x()));
        if (compareTo21 != 0) {
            return compareTo21;
        }
        if (x() && (a9 = hv.a(this.u, hjVar.u)) != 0) {
            return a9;
        }
        int compareTo22 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(hjVar.y()));
        if (compareTo22 != 0) {
            return compareTo22;
        }
        if (y() && (a8 = hv.a(this.v, hjVar.v)) != 0) {
            return a8;
        }
        int compareTo23 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(hjVar.z()));
        if (compareTo23 != 0) {
            return compareTo23;
        }
        if (z() && (a7 = hv.a(this.w, hjVar.w)) != 0) {
            return a7;
        }
        int compareTo24 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(hjVar.A()));
        if (compareTo24 != 0) {
            return compareTo24;
        }
        if (A() && (a6 = hv.a(this.x, hjVar.x)) != 0) {
            return a6;
        }
        int compareTo25 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(hjVar.B()));
        if (compareTo25 != 0) {
            return compareTo25;
        }
        if (B() && (a5 = hv.a(this.y, hjVar.y)) != 0) {
            return a5;
        }
        int compareTo26 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(hjVar.C()));
        if (compareTo26 != 0) {
            return compareTo26;
        }
        if (C() && (a4 = hv.a(this.z, hjVar.z)) != 0) {
            return a4;
        }
        int compareTo27 = Boolean.valueOf(D()).compareTo(Boolean.valueOf(hjVar.D()));
        if (compareTo27 != 0) {
            return compareTo27;
        }
        if (D() && (a3 = hv.a(this.A, hjVar.A)) != 0) {
            return a3;
        }
        int compareTo28 = Boolean.valueOf(E()).compareTo(Boolean.valueOf(hjVar.E()));
        if (compareTo28 != 0) {
            return compareTo28;
        }
        if (!E() || (a2 = hv.a(this.B, hjVar.B)) == 0) {
            return 0;
        }
        return a2;
    }

    public hj b(int i2) {
        this.n = i2;
        b(true);
        return this;
    }

    public hj b(String str) {
        this.d = str;
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        F();
        igVar.a(C);
        if (this.a != null && a()) {
            igVar.a(D);
            igVar.a(this.a);
            igVar.b();
        }
        if (this.b != null && b()) {
            igVar.a(E);
            this.b.b(igVar);
            igVar.b();
        }
        if (this.c != null) {
            igVar.a(F);
            igVar.a(this.c);
            igVar.b();
        }
        if (this.d != null) {
            igVar.a(G);
            igVar.a(this.d);
            igVar.b();
        }
        if (this.e != null && g()) {
            igVar.a(H);
            igVar.a(this.e);
            igVar.b();
        }
        if (this.f != null && h()) {
            igVar.a(I);
            igVar.a(this.f);
            igVar.b();
        }
        if (this.g != null) {
            igVar.a(J);
            igVar.a(this.g);
            igVar.b();
        }
        if (this.h != null && k()) {
            igVar.a(K);
            igVar.a(this.h);
            igVar.b();
        }
        if (this.i != null && l()) {
            igVar.a(L);
            igVar.a(this.i);
            igVar.b();
        }
        if (this.j != null && m()) {
            igVar.a(M);
            igVar.a(this.j);
            igVar.b();
        }
        if (this.k != null && n()) {
            igVar.a(N);
            igVar.a(this.k);
            igVar.b();
        }
        if (this.l != null && o()) {
            igVar.a(O);
            igVar.a(this.l);
            igVar.b();
        }
        if (p()) {
            igVar.a(P);
            igVar.a(this.m);
            igVar.b();
        }
        if (q()) {
            igVar.a(Q);
            igVar.a(this.n);
            igVar.b();
        }
        if (this.o != null && r()) {
            igVar.a(R);
            igVar.a(this.o);
            igVar.b();
        }
        if (this.p != null && s()) {
            igVar.a(S);
            igVar.a(this.p);
            igVar.b();
        }
        if (this.q != null && t()) {
            igVar.a(T);
            igVar.a(this.q);
            igVar.b();
        }
        if (this.r != null && u()) {
            igVar.a(U);
            igVar.a(this.r);
            igVar.b();
        }
        if (v()) {
            igVar.a(V);
            igVar.a(this.s);
            igVar.b();
        }
        if (this.t != null && w()) {
            igVar.a(W);
            igVar.a(this.t.a());
            igVar.b();
        }
        if (x()) {
            igVar.a(X);
            igVar.a(this.u);
            igVar.b();
        }
        if (y()) {
            igVar.a(Y);
            igVar.a(this.v);
            igVar.b();
        }
        if (z()) {
            igVar.a(Z);
            igVar.a(this.w);
            igVar.b();
        }
        if (this.x != null && A()) {
            igVar.a(aa);
            igVar.a(this.x);
            igVar.b();
        }
        if (this.y != null && B()) {
            igVar.a(ab);
            igVar.a(this.y);
            igVar.b();
        }
        if (this.z != null && C()) {
            igVar.a(ac);
            igVar.a(new Cif((byte) 11, (byte) 11, this.z.size()));
            for (Map.Entry<String, String> entry : this.z.entrySet()) {
                igVar.a(entry.getKey());
                igVar.a(entry.getValue());
            }
            igVar.d();
            igVar.b();
        }
        if (D()) {
            igVar.a(ad);
            igVar.a(this.A);
            igVar.b();
        }
        if (this.B != null && E()) {
            igVar.a(ae);
            igVar.a(this.B);
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public void b(boolean z2) {
        this.af.set(1, z2);
    }

    public boolean b() {
        return this.b != null;
    }

    public hj c(int i2) {
        this.s = i2;
        c(true);
        return this;
    }

    public hj c(String str) {
        this.e = str;
        return this;
    }

    public String c() {
        return this.c;
    }

    public void c(boolean z2) {
        this.af.set(2, z2);
    }

    public hj d(String str) {
        this.f = str;
        return this;
    }

    public void d(boolean z2) {
        this.af.set(3, z2);
    }

    public boolean d() {
        return this.c != null;
    }

    public hj e(String str) {
        this.g = str;
        return this;
    }

    public String e() {
        return this.d;
    }

    public void e(boolean z2) {
        this.af.set(4, z2);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return a((hj) obj);
        }
        return false;
    }

    public hj f(String str) {
        this.h = str;
        return this;
    }

    public void f(boolean z2) {
        this.af.set(5, z2);
    }

    public boolean f() {
        return this.d != null;
    }

    public hj g(String str) {
        this.i = str;
        return this;
    }

    public void g(boolean z2) {
        this.af.set(6, z2);
    }

    public boolean g() {
        return this.e != null;
    }

    public hj h(String str) {
        this.l = str;
        return this;
    }

    public boolean h() {
        return this.f != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public hj i(String str) {
        this.o = str;
        return this;
    }

    public String i() {
        return this.g;
    }

    public hj j(String str) {
        this.q = str;
        return this;
    }

    public boolean j() {
        return this.g != null;
    }

    public hj k(String str) {
        this.r = str;
        return this;
    }

    public boolean k() {
        return this.h != null;
    }

    public boolean l() {
        return this.i != null;
    }

    public boolean m() {
        return this.j != null;
    }

    public boolean n() {
        return this.k != null;
    }

    public boolean o() {
        return this.l != null;
    }

    public boolean p() {
        return this.af.get(0);
    }

    public boolean q() {
        return this.af.get(1);
    }

    public boolean r() {
        return this.o != null;
    }

    public boolean s() {
        return this.p != null;
    }

    public boolean t() {
        return this.q != null;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
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
            sb.append("appVersion:");
            String str4 = this.e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.g;
        if (str6 == null) {
            sb.append("null");
        } else {
            sb.append(str6);
        }
        if (k()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.h;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.i;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.j;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.k;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.l;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.m);
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.n);
        }
        if (r()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.o;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.p;
            if (str13 == null) {
                sb.append("null");
            } else {
                sb.append(str13);
            }
        }
        if (t()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.q;
            if (str14 == null) {
                sb.append("null");
            } else {
                sb.append(str14);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.r;
            if (str15 == null) {
                sb.append("null");
            } else {
                sb.append(str15);
            }
        }
        if (v()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.s);
        }
        if (w()) {
            sb.append(", ");
            sb.append("reason:");
            gx gxVar = this.t;
            if (gxVar == null) {
                sb.append("null");
            } else {
                sb.append(gxVar);
            }
        }
        if (x()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.u);
        }
        if (y()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.v);
        }
        if (z()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.w);
        }
        if (A()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.x;
            if (str16 == null) {
                sb.append("null");
            } else {
                sb.append(str16);
            }
        }
        if (B()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.y;
            if (str17 == null) {
                sb.append("null");
            } else {
                sb.append(str17);
            }
        }
        if (C()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.z;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (D()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.A);
        }
        if (E()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.B;
            if (str18 == null) {
                sb.append("null");
            } else {
                sb.append(str18);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.r != null;
    }

    public boolean v() {
        return this.af.get(2);
    }

    public boolean w() {
        return this.t != null;
    }

    public boolean x() {
        return this.af.get(3);
    }

    public boolean y() {
        return this.af.get(4);
    }

    public boolean z() {
        return this.af.get(5);
    }
}
