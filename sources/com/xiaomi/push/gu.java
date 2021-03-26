package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class gu implements hu<gu, Object>, Serializable, Cloneable {
    private static final id A = new id("", (byte) 11, 8);
    private static final id B = new id("", (byte) 11, 9);
    private static final id C = new id("", (byte) 11, 10);
    private static final id D = new id("", (byte) 11, 11);
    private static final id E = new id("", (byte) 12, 12);
    private static final id F = new id("", (byte) 11, 13);
    private static final id G = new id("", (byte) 2, 14);
    private static final id H = new id("", (byte) 11, 15);
    private static final id I = new id("", (byte) 10, 16);
    private static final id J = new id("", (byte) 11, 20);
    private static final id K = new id("", (byte) 11, 21);
    private static final il s = new il("PushMessage");
    private static final id t = new id("", (byte) 12, 1);
    private static final id u = new id("", (byte) 11, 2);
    private static final id v = new id("", (byte) 11, 3);
    private static final id w = new id("", (byte) 11, 4);
    private static final id x = new id("", (byte) 10, 5);
    private static final id y = new id("", (byte) 10, 6);
    private static final id z = new id("", (byte) 11, 7);
    private BitSet L = new BitSet(4);
    public gy a;
    public String b;
    public String c;
    public String d;
    public long e;
    public long f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public gv l;
    public String m;
    public boolean n = false;
    public String o;
    public long p;
    public String q;
    public String r;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                w();
                return;
            }
            short s2 = h2.c;
            if (s2 != 20) {
                if (s2 != 21) {
                    switch (s2) {
                        case 1:
                            if (h2.b == 12) {
                                gy gyVar = new gy();
                                this.a = gyVar;
                                gyVar.a(igVar);
                                break;
                            }
                            break;
                        case 2:
                            if (h2.b == 11) {
                                this.b = igVar.v();
                                break;
                            }
                            break;
                        case 3:
                            if (h2.b == 11) {
                                this.c = igVar.v();
                                break;
                            }
                            break;
                        case 4:
                            if (h2.b == 11) {
                                this.d = igVar.v();
                                break;
                            }
                            break;
                        case 5:
                            if (h2.b == 10) {
                                this.e = igVar.t();
                                a(true);
                                break;
                            }
                            break;
                        case 6:
                            if (h2.b == 10) {
                                this.f = igVar.t();
                                b(true);
                                break;
                            }
                            break;
                        case 7:
                            if (h2.b == 11) {
                                this.g = igVar.v();
                                break;
                            }
                            break;
                        case 8:
                            if (h2.b == 11) {
                                this.h = igVar.v();
                                break;
                            }
                            break;
                        case 9:
                            if (h2.b == 11) {
                                this.i = igVar.v();
                                break;
                            }
                            break;
                        case 10:
                            if (h2.b == 11) {
                                this.j = igVar.v();
                                break;
                            }
                            break;
                        case 11:
                            if (h2.b == 11) {
                                this.k = igVar.v();
                                break;
                            }
                            break;
                        case 12:
                            if (h2.b == 12) {
                                gv gvVar = new gv();
                                this.l = gvVar;
                                gvVar.a(igVar);
                                break;
                            }
                            break;
                        case 13:
                            if (h2.b == 11) {
                                this.m = igVar.v();
                                break;
                            }
                            break;
                        case 14:
                            if (h2.b == 2) {
                                this.n = igVar.p();
                                c(true);
                                break;
                            }
                            break;
                        case 15:
                            if (h2.b == 11) {
                                this.o = igVar.v();
                                break;
                            }
                            break;
                        case 16:
                            if (h2.b == 10) {
                                this.p = igVar.t();
                                d(true);
                                break;
                            }
                            break;
                    }
                    igVar.i();
                } else if (h2.b == 11) {
                    this.r = igVar.v();
                    igVar.i();
                }
            } else if (h2.b == 11) {
                this.q = igVar.v();
                igVar.i();
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

    public boolean a(gu guVar) {
        if (guVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = guVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.a(guVar.a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = guVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.b.equals(guVar.b))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = guVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.c.equals(guVar.c))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = guVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.d.equals(guVar.d))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = guVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.e != guVar.e)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = guVar.j();
        if ((j2 || j3) && (!j2 || !j3 || this.f != guVar.f)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = guVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.g.equals(guVar.g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = guVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.h.equals(guVar.h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = guVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.i.equals(guVar.i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = guVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.j.equals(guVar.j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = guVar.o();
        if ((o2 || o3) && (!o2 || !o3 || !this.k.equals(guVar.k))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = guVar.p();
        if ((p2 || p3) && (!p2 || !p3 || !this.l.a(guVar.l))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = guVar.q();
        if ((q2 || q3) && (!q2 || !q3 || !this.m.equals(guVar.m))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = guVar.r();
        if ((r2 || r3) && (!r2 || !r3 || this.n != guVar.n)) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = guVar.s();
        if ((s2 || s3) && (!s2 || !s3 || !this.o.equals(guVar.o))) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = guVar.t();
        if ((t2 || t3) && (!t2 || !t3 || this.p != guVar.p)) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = guVar.u();
        if ((u2 || u3) && (!u2 || !u3 || !this.q.equals(guVar.q))) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = guVar.v();
        if (v2 || v3) {
            return v2 && v3 && this.r.equals(guVar.r);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(gu guVar) {
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
        if (!getClass().equals(guVar.getClass())) {
            return getClass().getName().compareTo(guVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(guVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a19 = hv.a(this.a, guVar.a)) != 0) {
            return a19;
        }
        int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(guVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a18 = hv.a(this.b, guVar.b)) != 0) {
            return a18;
        }
        int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(guVar.e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (e() && (a17 = hv.a(this.c, guVar.c)) != 0) {
            return a17;
        }
        int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(guVar.g()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (g() && (a16 = hv.a(this.d, guVar.d)) != 0) {
            return a16;
        }
        int compareTo5 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(guVar.i()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (i() && (a15 = hv.a(this.e, guVar.e)) != 0) {
            return a15;
        }
        int compareTo6 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(guVar.j()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (j() && (a14 = hv.a(this.f, guVar.f)) != 0) {
            return a14;
        }
        int compareTo7 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(guVar.k()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (k() && (a13 = hv.a(this.g, guVar.g)) != 0) {
            return a13;
        }
        int compareTo8 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(guVar.l()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (l() && (a12 = hv.a(this.h, guVar.h)) != 0) {
            return a12;
        }
        int compareTo9 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(guVar.m()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m() && (a11 = hv.a(this.i, guVar.i)) != 0) {
            return a11;
        }
        int compareTo10 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(guVar.n()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (n() && (a10 = hv.a(this.j, guVar.j)) != 0) {
            return a10;
        }
        int compareTo11 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(guVar.o()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (o() && (a9 = hv.a(this.k, guVar.k)) != 0) {
            return a9;
        }
        int compareTo12 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(guVar.p()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (p() && (a8 = hv.a(this.l, guVar.l)) != 0) {
            return a8;
        }
        int compareTo13 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(guVar.q()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (q() && (a7 = hv.a(this.m, guVar.m)) != 0) {
            return a7;
        }
        int compareTo14 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(guVar.r()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (r() && (a6 = hv.a(this.n, guVar.n)) != 0) {
            return a6;
        }
        int compareTo15 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(guVar.s()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (s() && (a5 = hv.a(this.o, guVar.o)) != 0) {
            return a5;
        }
        int compareTo16 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(guVar.t()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (t() && (a4 = hv.a(this.p, guVar.p)) != 0) {
            return a4;
        }
        int compareTo17 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(guVar.u()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (u() && (a3 = hv.a(this.q, guVar.q)) != 0) {
            return a3;
        }
        int compareTo18 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(guVar.v()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (!v() || (a2 = hv.a(this.r, guVar.r)) == 0) {
            return 0;
        }
        return a2;
    }

    public String b() {
        return this.b;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        w();
        igVar.a(s);
        if (this.a != null && a()) {
            igVar.a(t);
            this.a.b(igVar);
            igVar.b();
        }
        if (this.b != null) {
            igVar.a(u);
            igVar.a(this.b);
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
        if (i()) {
            igVar.a(x);
            igVar.a(this.e);
            igVar.b();
        }
        if (j()) {
            igVar.a(y);
            igVar.a(this.f);
            igVar.b();
        }
        if (this.g != null && k()) {
            igVar.a(z);
            igVar.a(this.g);
            igVar.b();
        }
        if (this.h != null && l()) {
            igVar.a(A);
            igVar.a(this.h);
            igVar.b();
        }
        if (this.i != null && m()) {
            igVar.a(B);
            igVar.a(this.i);
            igVar.b();
        }
        if (this.j != null && n()) {
            igVar.a(C);
            igVar.a(this.j);
            igVar.b();
        }
        if (this.k != null && o()) {
            igVar.a(D);
            igVar.a(this.k);
            igVar.b();
        }
        if (this.l != null && p()) {
            igVar.a(E);
            this.l.b(igVar);
            igVar.b();
        }
        if (this.m != null && q()) {
            igVar.a(F);
            igVar.a(this.m);
            igVar.b();
        }
        if (r()) {
            igVar.a(G);
            igVar.a(this.n);
            igVar.b();
        }
        if (this.o != null && s()) {
            igVar.a(H);
            igVar.a(this.o);
            igVar.b();
        }
        if (t()) {
            igVar.a(I);
            igVar.a(this.p);
            igVar.b();
        }
        if (this.q != null && u()) {
            igVar.a(J);
            igVar.a(this.q);
            igVar.b();
        }
        if (this.r != null && v()) {
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

    public void c(boolean z2) {
        this.L.set(2, z2);
    }

    public boolean c() {
        return this.b != null;
    }

    public String d() {
        return this.c;
    }

    public void d(boolean z2) {
        this.L.set(3, z2);
    }

    public boolean e() {
        return this.c != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gu)) {
            return a((gu) obj);
        }
        return false;
    }

    public String f() {
        return this.d;
    }

    public boolean g() {
        return this.d != null;
    }

    public long h() {
        return this.e;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.L.get(0);
    }

    public boolean j() {
        return this.L.get(1);
    }

    public boolean k() {
        return this.g != null;
    }

    public boolean l() {
        return this.h != null;
    }

    public boolean m() {
        return this.i != null;
    }

    public boolean n() {
        return this.j != null;
    }

    public boolean o() {
        return this.k != null;
    }

    public boolean p() {
        return this.l != null;
    }

    public boolean q() {
        return this.m != null;
    }

    public boolean r() {
        return this.L.get(2);
    }

    public boolean s() {
        return this.o != null;
    }

    public boolean t() {
        return this.L.get(3);
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (a()) {
            sb.append("to:");
            gy gyVar = this.a;
            if (gyVar == null) {
                sb.append("null");
            } else {
                sb.append(gyVar);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.b;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (i()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.e);
        }
        if (j()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f);
        }
        if (k()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.g;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.h;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.i;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.j;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.k;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("metaInfo:");
            gv gvVar = this.l;
            if (gvVar == null) {
                sb.append("null");
            } else {
                sb.append(gvVar);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.m;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.n);
        }
        if (s()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.o;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (t()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.p);
        }
        if (u()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.q;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (v()) {
            sb.append(", ");
            sb.append("deviceId:");
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
        return this.q != null;
    }

    public boolean v() {
        return this.r != null;
    }

    public void w() {
        if (this.b == null) {
            throw new ih("Required field 'id' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new ih("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new ih("Required field 'payload' was not present! Struct: " + toString());
        }
    }
}
