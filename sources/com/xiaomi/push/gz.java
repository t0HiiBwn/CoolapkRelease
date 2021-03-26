package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class gz implements hu<gz, Object>, Serializable, Cloneable {
    private static final id A = new id("", (byte) 11, 6);
    private static final id B = new id("", (byte) 11, 7);
    private static final id C = new id("", (byte) 12, 8);
    private static final id D = new id("", (byte) 11, 9);
    private static final id E = new id("", (byte) 11, 10);
    private static final id F = new id("", (byte) 2, 11);
    private static final id G = new id("", (byte) 11, 12);
    private static final id H = new id("", (byte) 11, 13);
    private static final id I = new id("", (byte) 11, 14);
    private static final id J = new id("", (byte) 6, 15);
    private static final id K = new id("", (byte) 6, 16);
    private static final id L = new id("", (byte) 11, 20);
    private static final id M = new id("", (byte) 11, 21);
    private static final id N = new id("", (byte) 8, 22);
    private static final id O = new id("", (byte) 13, 23);
    private static final il u = new il("XmPushActionAckMessage");
    private static final id v = new id("", (byte) 11, 1);
    private static final id w = new id("", (byte) 12, 2);
    private static final id x = new id("", (byte) 11, 3);
    private static final id y = new id("", (byte) 11, 4);
    private static final id z = new id("", (byte) 10, 5);
    private BitSet P = new BitSet(5);
    public String a;
    public gy b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;
    public hm h;
    public String i;
    public String j;
    public boolean k = false;
    public String l;
    public String m;
    public String n;
    public short o;
    public short p;
    public String q;
    public String r;
    public int s;
    public Map<String, String> t;

    public gz a(long j2) {
        this.e = j2;
        a(true);
        return this;
    }

    public gz a(String str) {
        this.c = str;
        return this;
    }

    public gz a(short s2) {
        this.o = s2;
        c(true);
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                if (e()) {
                    u();
                    return;
                }
                throw new ih("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
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
                    if (h2.b == 10) {
                        this.e = igVar.t();
                        a(true);
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
                        hm hmVar = new hm();
                        this.h = hmVar;
                        hmVar.a(igVar);
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
                        b(true);
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
                    if (h2.b == 11) {
                        this.m = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 14:
                    if (h2.b == 11) {
                        this.n = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 15:
                    if (h2.b == 6) {
                        this.o = igVar.r();
                        c(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 16:
                    if (h2.b == 6) {
                        this.p = igVar.r();
                        d(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 20:
                    if (h2.b == 11) {
                        this.q = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 21:
                    if (h2.b == 11) {
                        this.r = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 22:
                    if (h2.b == 8) {
                        this.s = igVar.s();
                        e(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 23:
                    if (h2.b == 13) {
                        Cif j2 = igVar.j();
                        this.t = new HashMap(j2.c * 2);
                        for (int i2 = 0; i2 < j2.c; i2++) {
                            this.t.put(igVar.v(), igVar.v());
                        }
                        igVar.k();
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
        this.P.set(0, z2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(gz gzVar) {
        if (gzVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = gzVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(gzVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = gzVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(gzVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = gzVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(gzVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = gzVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.d.equals(gzVar.d))) || this.e != gzVar.e) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = gzVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f.equals(gzVar.f))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = gzVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.g.equals(gzVar.g))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = gzVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.h.a(gzVar.h))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = gzVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.i.equals(gzVar.i))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = gzVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.j.equals(gzVar.j))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = gzVar.k();
        if ((k2 || k3) && (!k2 || !k3 || this.k != gzVar.k)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = gzVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.l.equals(gzVar.l))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = gzVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.m.equals(gzVar.m))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = gzVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.n.equals(gzVar.n))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = gzVar.o();
        if ((o2 || o3) && (!o2 || !o3 || this.o != gzVar.o)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = gzVar.p();
        if ((p2 || p3) && (!p2 || !p3 || this.p != gzVar.p)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = gzVar.q();
        if ((q2 || q3) && (!q2 || !q3 || !this.q.equals(gzVar.q))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = gzVar.r();
        if ((r2 || r3) && (!r2 || !r3 || !this.r.equals(gzVar.r))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = gzVar.s();
        if ((s2 || s3) && (!s2 || !s3 || this.s != gzVar.s)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = gzVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.t.equals(gzVar.t);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(gz gzVar) {
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
        if (!getClass().equals(gzVar.getClass())) {
            return getClass().getName().compareTo(gzVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gzVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a21 = hv.a(this.a, gzVar.a)) != 0) {
            return a21;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gzVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a20 = hv.a(this.b, gzVar.b)) != 0) {
            return a20;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gzVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a19 = hv.a(this.c, gzVar.c)) != 0) {
            return a19;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gzVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a18 = hv.a(this.d, gzVar.d)) != 0) {
            return a18;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gzVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a17 = hv.a(this.e, gzVar.e)) != 0) {
            return a17;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gzVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a16 = hv.a(this.f, gzVar.f)) != 0) {
            return a16;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gzVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a15 = hv.a(this.g, gzVar.g)) != 0) {
            return a15;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gzVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a14 = hv.a(this.h, gzVar.h)) != 0) {
            return a14;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gzVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a13 = hv.a(this.i, gzVar.i)) != 0) {
            return a13;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gzVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a12 = hv.a(this.j, gzVar.j)) != 0) {
            return a12;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gzVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a11 = hv.a(this.k, gzVar.k)) != 0) {
            return a11;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(gzVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a10 = hv.a(this.l, gzVar.l)) != 0) {
            return a10;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gzVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a9 = hv.a(this.m, gzVar.m)) != 0) {
            return a9;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gzVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a8 = hv.a(this.n, gzVar.n)) != 0) {
            return a8;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(gzVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a7 = hv.a(this.o, gzVar.o)) != 0) {
            return a7;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(gzVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a6 = hv.a(this.p, gzVar.p)) != 0) {
            return a6;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(gzVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a5 = hv.a(this.q, gzVar.q)) != 0) {
            return a5;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(gzVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (a4 = hv.a(this.r, gzVar.r)) != 0) {
            return a4;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(gzVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (a3 = hv.a(this.s, gzVar.s)) != 0) {
            return a3;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(gzVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!t() || (a2 = hv.a(this.t, gzVar.t)) == 0) {
            return 0;
        }
        return a2;
    }

    public gz b(String str) {
        this.d = str;
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        u();
        igVar.a(u);
        if (this.a != null && a()) {
            igVar.a(v);
            igVar.a(this.a);
            igVar.b();
        }
        if (this.b != null && b()) {
            igVar.a(w);
            this.b.b(igVar);
            igVar.b();
        }
        if (this.c != null) {
            igVar.a(x);
            igVar.a(this.c);
            igVar.b();
        }
        if (this.d != null) {
            igVar.a(y);
            igVar.a(this.d);
            igVar.b();
        }
        igVar.a(z);
        igVar.a(this.e);
        igVar.b();
        if (this.f != null && f()) {
            igVar.a(A);
            igVar.a(this.f);
            igVar.b();
        }
        if (this.g != null && g()) {
            igVar.a(B);
            igVar.a(this.g);
            igVar.b();
        }
        if (this.h != null && h()) {
            igVar.a(C);
            this.h.b(igVar);
            igVar.b();
        }
        if (this.i != null && i()) {
            igVar.a(D);
            igVar.a(this.i);
            igVar.b();
        }
        if (this.j != null && j()) {
            igVar.a(E);
            igVar.a(this.j);
            igVar.b();
        }
        if (k()) {
            igVar.a(F);
            igVar.a(this.k);
            igVar.b();
        }
        if (this.l != null && l()) {
            igVar.a(G);
            igVar.a(this.l);
            igVar.b();
        }
        if (this.m != null && m()) {
            igVar.a(H);
            igVar.a(this.m);
            igVar.b();
        }
        if (this.n != null && n()) {
            igVar.a(I);
            igVar.a(this.n);
            igVar.b();
        }
        if (o()) {
            igVar.a(J);
            igVar.a(this.o);
            igVar.b();
        }
        if (p()) {
            igVar.a(K);
            igVar.a(this.p);
            igVar.b();
        }
        if (this.q != null && q()) {
            igVar.a(L);
            igVar.a(this.q);
            igVar.b();
        }
        if (this.r != null && r()) {
            igVar.a(M);
            igVar.a(this.r);
            igVar.b();
        }
        if (s()) {
            igVar.a(N);
            igVar.a(this.s);
            igVar.b();
        }
        if (this.t != null && t()) {
            igVar.a(O);
            igVar.a(new Cif((byte) 11, (byte) 11, this.t.size()));
            for (Map.Entry<String, String> entry : this.t.entrySet()) {
                igVar.a(entry.getKey());
                igVar.a(entry.getValue());
            }
            igVar.d();
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public void b(boolean z2) {
        this.P.set(1, z2);
    }

    public boolean b() {
        return this.b != null;
    }

    public gz c(String str) {
        this.f = str;
        return this;
    }

    public void c(boolean z2) {
        this.P.set(2, z2);
    }

    public boolean c() {
        return this.c != null;
    }

    public gz d(String str) {
        this.g = str;
        return this;
    }

    public void d(boolean z2) {
        this.P.set(3, z2);
    }

    public boolean d() {
        return this.d != null;
    }

    public void e(boolean z2) {
        this.P.set(4, z2);
    }

    public boolean e() {
        return this.P.get(0);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gz)) {
            return a((gz) obj);
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
        return this.P.get(1);
    }

    public boolean l() {
        return this.l != null;
    }

    public boolean m() {
        return this.m != null;
    }

    public boolean n() {
        return this.n != null;
    }

    public boolean o() {
        return this.P.get(2);
    }

    public boolean p() {
        return this.P.get(3);
    }

    public boolean q() {
        return this.q != null;
    }

    public boolean r() {
        return this.r != null;
    }

    public boolean s() {
        return this.P.get(4);
    }

    public boolean t() {
        return this.t != null;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
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
        sb.append("messageTs:");
        sb.append(this.e);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            hm hmVar = this.h;
            if (hmVar == null) {
                sb.append("null");
            } else {
                sb.append(hmVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.i;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.j;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.k);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.l;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.m;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.n;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.o);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.p);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.q;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.r;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.s);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.t;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void u() {
        if (this.c == null) {
            throw new ih("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new ih("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
