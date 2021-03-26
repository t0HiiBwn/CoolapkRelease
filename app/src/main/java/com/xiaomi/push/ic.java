package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class ic implements in<ic, Object>, Serializable, Cloneable {
    private static final iv A = new iv("", (byte) 13, 100);
    private static final iv B = new iv("", (byte) 2, 101);
    private static final iv C = new iv("", (byte) 11, 102);
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f728a = new jd("XmPushActionRegistration");
    private static final iv b = new iv("", (byte) 12, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 11, 5);
    private static final iv f = new iv("", (byte) 11, 6);
    private static final iv g = new iv("", (byte) 11, 7);
    private static final iv h = new iv("", (byte) 11, 8);
    private static final iv i = new iv("", (byte) 11, 9);
    private static final iv j = new iv("", (byte) 11, 10);
    private static final iv k = new iv("", (byte) 11, 11);

    /* renamed from: l  reason: collision with root package name */
    private static final iv f1508l = new iv("", (byte) 11, 12);
    private static final iv m = new iv("", (byte) 8, 13);
    private static final iv n = new iv("", (byte) 8, 14);
    private static final iv o = new iv("", (byte) 11, 15);
    private static final iv p = new iv("", (byte) 11, 16);
    private static final iv q = new iv("", (byte) 11, 17);
    private static final iv r = new iv("", (byte) 11, 18);
    private static final iv s = new iv("", (byte) 8, 19);
    private static final iv t = new iv("", (byte) 8, 20);
    private static final iv u = new iv("", (byte) 2, 21);
    private static final iv v = new iv("", (byte) 10, 22);
    private static final iv w = new iv("", (byte) 10, 23);
    private static final iv x = new iv("", (byte) 11, 24);
    private static final iv y = new iv("", (byte) 11, 25);
    private static final iv z = new iv("", (byte) 2, 26);

    /* renamed from: a  reason: collision with other field name */
    public int f729a;

    /* renamed from: a  reason: collision with other field name */
    public long f730a;

    /* renamed from: a  reason: collision with other field name */
    public hq f731a;

    /* renamed from: a  reason: collision with other field name */
    public hr f732a;

    /* renamed from: a  reason: collision with other field name */
    public String f733a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f734a = new BitSet(8);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f735a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f736a = true;

    /* renamed from: b  reason: collision with other field name */
    public int f737b;

    /* renamed from: b  reason: collision with other field name */
    public long f738b;

    /* renamed from: b  reason: collision with other field name */
    public String f739b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f740b = false;

    /* renamed from: c  reason: collision with other field name */
    public int f741c;

    /* renamed from: c  reason: collision with other field name */
    public String f742c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f743c = false;

    /* renamed from: d  reason: collision with other field name */
    public String f744d;

    /* renamed from: e  reason: collision with other field name */
    public String f745e;

    /* renamed from: f  reason: collision with other field name */
    public String f746f;

    /* renamed from: g  reason: collision with other field name */
    public String f747g;

    /* renamed from: h  reason: collision with other field name */
    public String f748h;

    /* renamed from: i  reason: collision with other field name */
    public String f749i;

    /* renamed from: j  reason: collision with other field name */
    public String f750j;

    /* renamed from: k  reason: collision with other field name */
    public String f751k;

    /* renamed from: l  reason: collision with other field name */
    public String f752l;

    /* renamed from: m  reason: collision with other field name */
    public String f753m;

    /* renamed from: n  reason: collision with other field name */
    public String f754n;

    /* renamed from: o  reason: collision with other field name */
    public String f755o;

    /* renamed from: p  reason: collision with other field name */
    public String f756p;

    /* renamed from: q  reason: collision with other field name */
    public String f757q;

    /* renamed from: r  reason: collision with other field name */
    public String f758r;

    public boolean A() {
        return this.f735a != null;
    }

    public boolean B() {
        return this.f734a.get(7);
    }

    public boolean C() {
        return this.f758r != null;
    }

    /* renamed from: a */
    public int compareTo(ic icVar) {
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
        int a30;
        if (!getClass().equals(icVar.getClass())) {
            return getClass().getName().compareTo(icVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m490a()).compareTo(Boolean.valueOf(icVar.m490a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m490a() && (a30 = io.a(this.f733a, icVar.f733a)) != 0) {
            return a30;
        }
        int compareTo2 = Boolean.valueOf(m492b()).compareTo(Boolean.valueOf(icVar.m492b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m492b() && (a29 = io.a(this.f732a, icVar.f732a)) != 0) {
            return a29;
        }
        int compareTo3 = Boolean.valueOf(m493c()).compareTo(Boolean.valueOf(icVar.m493c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m493c() && (a28 = io.a(this.f739b, icVar.f739b)) != 0) {
            return a28;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(icVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a27 = io.a(this.f742c, icVar.f742c)) != 0) {
            return a27;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(icVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a26 = io.a(this.f744d, icVar.f744d)) != 0) {
            return a26;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(icVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a25 = io.a(this.f745e, icVar.f745e)) != 0) {
            return a25;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(icVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a24 = io.a(this.f746f, icVar.f746f)) != 0) {
            return a24;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(icVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a23 = io.a(this.f747g, icVar.f747g)) != 0) {
            return a23;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(icVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a22 = io.a(this.f748h, icVar.f748h)) != 0) {
            return a22;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(icVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a21 = io.a(this.f749i, icVar.f749i)) != 0) {
            return a21;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(icVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a20 = io.a(this.f750j, icVar.f750j)) != 0) {
            return a20;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(icVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a19 = io.a(this.f751k, icVar.f751k)) != 0) {
            return a19;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(icVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a18 = io.a(this.f729a, icVar.f729a)) != 0) {
            return a18;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(icVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a17 = io.a(this.f737b, icVar.f737b)) != 0) {
            return a17;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(icVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a16 = io.a(this.f752l, icVar.f752l)) != 0) {
            return a16;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(icVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a15 = io.a(this.f753m, icVar.f753m)) != 0) {
            return a15;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(icVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a14 = io.a(this.f754n, icVar.f754n)) != 0) {
            return a14;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(icVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (a13 = io.a(this.f755o, icVar.f755o)) != 0) {
            return a13;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(icVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (a12 = io.a(this.f741c, icVar.f741c)) != 0) {
            return a12;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(icVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (t() && (a11 = io.a(this.f731a, icVar.f731a)) != 0) {
            return a11;
        }
        int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(icVar.u()));
        if (compareTo21 != 0) {
            return compareTo21;
        }
        if (u() && (a10 = io.a(this.f736a, icVar.f736a)) != 0) {
            return a10;
        }
        int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(icVar.v()));
        if (compareTo22 != 0) {
            return compareTo22;
        }
        if (v() && (a9 = io.a(this.f730a, icVar.f730a)) != 0) {
            return a9;
        }
        int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(icVar.w()));
        if (compareTo23 != 0) {
            return compareTo23;
        }
        if (w() && (a8 = io.a(this.f738b, icVar.f738b)) != 0) {
            return a8;
        }
        int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(icVar.x()));
        if (compareTo24 != 0) {
            return compareTo24;
        }
        if (x() && (a7 = io.a(this.f756p, icVar.f756p)) != 0) {
            return a7;
        }
        int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(icVar.y()));
        if (compareTo25 != 0) {
            return compareTo25;
        }
        if (y() && (a6 = io.a(this.f757q, icVar.f757q)) != 0) {
            return a6;
        }
        int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(icVar.z()));
        if (compareTo26 != 0) {
            return compareTo26;
        }
        if (z() && (a5 = io.a(this.f740b, icVar.f740b)) != 0) {
            return a5;
        }
        int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(icVar.A()));
        if (compareTo27 != 0) {
            return compareTo27;
        }
        if (A() && (a4 = io.a(this.f735a, icVar.f735a)) != 0) {
            return a4;
        }
        int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(icVar.B()));
        if (compareTo28 != 0) {
            return compareTo28;
        }
        if (B() && (a3 = io.a(this.f743c, icVar.f743c)) != 0) {
            return a3;
        }
        int compareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(icVar.C()));
        if (compareTo29 != 0) {
            return compareTo29;
        }
        if (!C() || (a2 = io.a(this.f758r, icVar.f758r)) == 0) {
            return 0;
        }
        return a2;
    }

    public ic a(int i2) {
        this.f729a = i2;
        a(true);
        return this;
    }

    public ic a(hq hqVar) {
        this.f731a = hqVar;
        return this;
    }

    public ic a(String str) {
        this.f739b = str;
        return this;
    }

    public String a() {
        return this.f739b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m489a() {
        if (this.f739b == null) {
            throw new iz("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f742c == null) {
            throw new iz("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f746f == null) {
            throw new iz("Required field 'token' was not present! Struct: " + toString());
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                iyVar.f();
                m489a();
                return;
            }
            short s2 = a2.f877a;
            switch (s2) {
                case 1:
                    if (a2.a == 11) {
                        this.f733a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 2:
                    if (a2.a == 12) {
                        hr hrVar = new hr();
                        this.f732a = hrVar;
                        hrVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f739b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f742c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 5:
                    if (a2.a == 11) {
                        this.f744d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 6:
                    if (a2.a == 11) {
                        this.f745e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 11) {
                        this.f746f = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 8:
                    if (a2.a == 11) {
                        this.f747g = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 9:
                    if (a2.a == 11) {
                        this.f748h = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 10:
                    if (a2.a == 11) {
                        this.f749i = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 11:
                    if (a2.a == 11) {
                        this.f750j = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 12:
                    if (a2.a == 11) {
                        this.f751k = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 13:
                    if (a2.a == 8) {
                        this.f729a = iyVar.m545a();
                        a(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 14:
                    if (a2.a == 8) {
                        this.f737b = iyVar.m545a();
                        b(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 15:
                    if (a2.a == 11) {
                        this.f752l = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 16:
                    if (a2.a == 11) {
                        this.f753m = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 17:
                    if (a2.a == 11) {
                        this.f754n = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 18:
                    if (a2.a == 11) {
                        this.f755o = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 19:
                    if (a2.a == 8) {
                        this.f741c = iyVar.m545a();
                        c(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 20:
                    if (a2.a == 8) {
                        this.f731a = hq.a(iyVar.m545a());
                        continue;
                        iyVar.g();
                    }
                    break;
                case 21:
                    if (a2.a == 2) {
                        this.f736a = iyVar.m556a();
                        d(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 22:
                    if (a2.a == 10) {
                        this.f730a = iyVar.m546a();
                        e(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 23:
                    if (a2.a == 10) {
                        this.f738b = iyVar.m546a();
                        f(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 24:
                    if (a2.a == 11) {
                        this.f756p = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 25:
                    if (a2.a == 11) {
                        this.f757q = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 26:
                    if (a2.a == 2) {
                        this.f740b = iyVar.m556a();
                        g(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                default:
                    switch (s2) {
                        case 100:
                            if (a2.a == 13) {
                                ix a3 = iyVar.m549a();
                                this.f735a = new HashMap(a3.f879a * 2);
                                for (int i2 = 0; i2 < a3.f879a; i2++) {
                                    this.f735a.put(iyVar.m552a(), iyVar.m552a());
                                }
                                iyVar.h();
                                break;
                            }
                            break;
                        case 101:
                            if (a2.a == 2) {
                                this.f743c = iyVar.m556a();
                                h(true);
                                break;
                            }
                            break;
                        case 102:
                            if (a2.a == 11) {
                                this.f758r = iyVar.m552a();
                                continue;
                            }
                            break;
                    }
                    iyVar.g();
                    break;
            }
            jb.a(iyVar, a2.a);
            iyVar.g();
        }
    }

    public void a(boolean z2) {
        this.f734a.set(0, z2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m490a() {
        return this.f733a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m491a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean a2 = m490a();
        boolean a3 = icVar.m490a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f733a.equals(icVar.f733a))) {
            return false;
        }
        boolean b2 = m492b();
        boolean b3 = icVar.m492b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f732a.m434a(icVar.f732a))) {
            return false;
        }
        boolean c2 = m493c();
        boolean c3 = icVar.m493c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f739b.equals(icVar.f739b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = icVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f742c.equals(icVar.f742c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = icVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f744d.equals(icVar.f744d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = icVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f745e.equals(icVar.f745e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = icVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f746f.equals(icVar.f746f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = icVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f747g.equals(icVar.f747g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = icVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f748h.equals(icVar.f748h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = icVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f749i.equals(icVar.f749i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = icVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f750j.equals(icVar.f750j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = icVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.f751k.equals(icVar.f751k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = icVar.m();
        if ((m2 || m3) && (!m2 || !m3 || this.f729a != icVar.f729a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = icVar.n();
        if ((n2 || n3) && (!n2 || !n3 || this.f737b != icVar.f737b)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = icVar.o();
        if ((o2 || o3) && (!o2 || !o3 || !this.f752l.equals(icVar.f752l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = icVar.p();
        if ((p2 || p3) && (!p2 || !p3 || !this.f753m.equals(icVar.f753m))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = icVar.q();
        if ((q2 || q3) && (!q2 || !q3 || !this.f754n.equals(icVar.f754n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = icVar.r();
        if ((r2 || r3) && (!r2 || !r3 || !this.f755o.equals(icVar.f755o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = icVar.s();
        if ((s2 || s3) && (!s2 || !s3 || this.f741c != icVar.f741c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = icVar.t();
        if ((t2 || t3) && (!t2 || !t3 || !this.f731a.equals(icVar.f731a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = icVar.u();
        if ((u2 || u3) && (!u2 || !u3 || this.f736a != icVar.f736a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = icVar.v();
        if ((v2 || v3) && (!v2 || !v3 || this.f730a != icVar.f730a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = icVar.w();
        if ((w2 || w3) && (!w2 || !w3 || this.f738b != icVar.f738b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = icVar.x();
        if ((x2 || x3) && (!x2 || !x3 || !this.f756p.equals(icVar.f756p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = icVar.y();
        if ((y2 || y3) && (!y2 || !y3 || !this.f757q.equals(icVar.f757q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = icVar.z();
        if ((z2 || z3) && (!z2 || !z3 || this.f740b != icVar.f740b)) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = icVar.A();
        if ((A2 || A3) && (!A2 || !A3 || !this.f735a.equals(icVar.f735a))) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = icVar.B();
        if ((B2 || B3) && (!B2 || !B3 || this.f743c != icVar.f743c)) {
            return false;
        }
        boolean C2 = C();
        boolean C3 = icVar.C();
        if (C2 || C3) {
            return C2 && C3 && this.f758r.equals(icVar.f758r);
        }
        return true;
    }

    public ic b(int i2) {
        this.f737b = i2;
        b(true);
        return this;
    }

    public ic b(String str) {
        this.f742c = str;
        return this;
    }

    public String b() {
        return this.f742c;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m489a();
        iyVar.a(f728a);
        if (this.f733a != null && m490a()) {
            iyVar.a(a);
            iyVar.a(this.f733a);
            iyVar.b();
        }
        if (this.f732a != null && m492b()) {
            iyVar.a(b);
            this.f732a.b(iyVar);
            iyVar.b();
        }
        if (this.f739b != null) {
            iyVar.a(c);
            iyVar.a(this.f739b);
            iyVar.b();
        }
        if (this.f742c != null) {
            iyVar.a(d);
            iyVar.a(this.f742c);
            iyVar.b();
        }
        if (this.f744d != null && e()) {
            iyVar.a(e);
            iyVar.a(this.f744d);
            iyVar.b();
        }
        if (this.f745e != null && f()) {
            iyVar.a(f);
            iyVar.a(this.f745e);
            iyVar.b();
        }
        if (this.f746f != null) {
            iyVar.a(g);
            iyVar.a(this.f746f);
            iyVar.b();
        }
        if (this.f747g != null && h()) {
            iyVar.a(h);
            iyVar.a(this.f747g);
            iyVar.b();
        }
        if (this.f748h != null && i()) {
            iyVar.a(i);
            iyVar.a(this.f748h);
            iyVar.b();
        }
        if (this.f749i != null && j()) {
            iyVar.a(j);
            iyVar.a(this.f749i);
            iyVar.b();
        }
        if (this.f750j != null && k()) {
            iyVar.a(k);
            iyVar.a(this.f750j);
            iyVar.b();
        }
        if (this.f751k != null && l()) {
            iyVar.a(f1508l);
            iyVar.a(this.f751k);
            iyVar.b();
        }
        if (m()) {
            iyVar.a(m);
            iyVar.mo543a(this.f729a);
            iyVar.b();
        }
        if (n()) {
            iyVar.a(n);
            iyVar.mo543a(this.f737b);
            iyVar.b();
        }
        if (this.f752l != null && o()) {
            iyVar.a(o);
            iyVar.a(this.f752l);
            iyVar.b();
        }
        if (this.f753m != null && p()) {
            iyVar.a(p);
            iyVar.a(this.f753m);
            iyVar.b();
        }
        if (this.f754n != null && q()) {
            iyVar.a(q);
            iyVar.a(this.f754n);
            iyVar.b();
        }
        if (this.f755o != null && r()) {
            iyVar.a(r);
            iyVar.a(this.f755o);
            iyVar.b();
        }
        if (s()) {
            iyVar.a(s);
            iyVar.mo543a(this.f741c);
            iyVar.b();
        }
        if (this.f731a != null && t()) {
            iyVar.a(t);
            iyVar.mo543a(this.f731a.a());
            iyVar.b();
        }
        if (u()) {
            iyVar.a(u);
            iyVar.a(this.f736a);
            iyVar.b();
        }
        if (v()) {
            iyVar.a(v);
            iyVar.a(this.f730a);
            iyVar.b();
        }
        if (w()) {
            iyVar.a(w);
            iyVar.a(this.f738b);
            iyVar.b();
        }
        if (this.f756p != null && x()) {
            iyVar.a(x);
            iyVar.a(this.f756p);
            iyVar.b();
        }
        if (this.f757q != null && y()) {
            iyVar.a(y);
            iyVar.a(this.f757q);
            iyVar.b();
        }
        if (z()) {
            iyVar.a(z);
            iyVar.a(this.f740b);
            iyVar.b();
        }
        if (this.f735a != null && A()) {
            iyVar.a(A);
            iyVar.a(new ix((byte) 11, (byte) 11, this.f735a.size()));
            for (Map.Entry<String, String> entry : this.f735a.entrySet()) {
                iyVar.a(entry.getKey());
                iyVar.a(entry.getValue());
            }
            iyVar.d();
            iyVar.b();
        }
        if (B()) {
            iyVar.a(B);
            iyVar.a(this.f743c);
            iyVar.b();
        }
        if (this.f758r != null && C()) {
            iyVar.a(C);
            iyVar.a(this.f758r);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public void b(boolean z2) {
        this.f734a.set(1, z2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m492b() {
        return this.f732a != null;
    }

    public ic c(int i2) {
        this.f741c = i2;
        c(true);
        return this;
    }

    public ic c(String str) {
        this.f744d = str;
        return this;
    }

    public String c() {
        return this.f746f;
    }

    public void c(boolean z2) {
        this.f734a.set(2, z2);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m493c() {
        return this.f739b != null;
    }

    public ic d(String str) {
        this.f745e = str;
        return this;
    }

    public void d(boolean z2) {
        this.f734a.set(3, z2);
    }

    public boolean d() {
        return this.f742c != null;
    }

    public ic e(String str) {
        this.f746f = str;
        return this;
    }

    public void e(boolean z2) {
        this.f734a.set(4, z2);
    }

    public boolean e() {
        return this.f744d != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m491a((ic) obj);
        }
        return false;
    }

    public ic f(String str) {
        this.f747g = str;
        return this;
    }

    public void f(boolean z2) {
        this.f734a.set(5, z2);
    }

    public boolean f() {
        return this.f745e != null;
    }

    public ic g(String str) {
        this.f748h = str;
        return this;
    }

    public void g(boolean z2) {
        this.f734a.set(6, z2);
    }

    public boolean g() {
        return this.f746f != null;
    }

    public ic h(String str) {
        this.f751k = str;
        return this;
    }

    public void h(boolean z2) {
        this.f734a.set(7, z2);
    }

    public boolean h() {
        return this.f747g != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public ic i(String str) {
        this.f755o = str;
        return this;
    }

    public boolean i() {
        return this.f748h != null;
    }

    public boolean j() {
        return this.f749i != null;
    }

    public boolean k() {
        return this.f750j != null;
    }

    public boolean l() {
        return this.f751k != null;
    }

    public boolean m() {
        return this.f734a.get(0);
    }

    public boolean n() {
        return this.f734a.get(1);
    }

    public boolean o() {
        return this.f752l != null;
    }

    public boolean p() {
        return this.f753m != null;
    }

    public boolean q() {
        return this.f754n != null;
    }

    public boolean r() {
        return this.f755o != null;
    }

    public boolean s() {
        return this.f734a.get(2);
    }

    public boolean t() {
        return this.f731a != null;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z3 = false;
        if (m490a()) {
            sb.append("debug:");
            String str = this.f733a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (m492b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            hr hrVar = this.f732a;
            if (hrVar == null) {
                sb.append("null");
            } else {
                sb.append(hrVar);
            }
        } else {
            z3 = z2;
        }
        if (!z3) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f739b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f742c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.f744d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f745e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f746f;
        if (str6 == null) {
            sb.append("null");
        } else {
            sb.append(str6);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.f747g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f748h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.f749i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.f750j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.f751k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f729a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f737b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.f752l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.f753m;
            if (str13 == null) {
                sb.append("null");
            } else {
                sb.append(str13);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.f754n;
            if (str14 == null) {
                sb.append("null");
            } else {
                sb.append(str14);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.f755o;
            if (str15 == null) {
                sb.append("null");
            } else {
                sb.append(str15);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f741c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            hq hqVar = this.f731a;
            if (hqVar == null) {
                sb.append("null");
            } else {
                sb.append(hqVar);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f736a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f730a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f738b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.f756p;
            if (str16 == null) {
                sb.append("null");
            } else {
                sb.append(str16);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.f757q;
            if (str17 == null) {
                sb.append("null");
            } else {
                sb.append(str17);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f740b);
        }
        if (A()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f735a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (B()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f743c);
        }
        if (C()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.f758r;
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
        return this.f734a.get(3);
    }

    public boolean v() {
        return this.f734a.get(4);
    }

    public boolean w() {
        return this.f734a.get(5);
    }

    public boolean x() {
        return this.f756p != null;
    }

    public boolean y() {
        return this.f757q != null;
    }

    public boolean z() {
        return this.f734a.get(6);
    }
}
