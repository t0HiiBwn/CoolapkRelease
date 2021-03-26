package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class ho implements in<ho, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 12, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f586a = new jd("PushMessage");
    private static final iv b = new iv("", (byte) 11, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 10, 5);
    private static final iv f = new iv("", (byte) 10, 6);
    private static final iv g = new iv("", (byte) 11, 7);
    private static final iv h = new iv("", (byte) 11, 8);
    private static final iv i = new iv("", (byte) 11, 9);
    private static final iv j = new iv("", (byte) 11, 10);
    private static final iv k = new iv("", (byte) 11, 11);

    /* renamed from: l  reason: collision with root package name */
    private static final iv f1504l = new iv("", (byte) 12, 12);
    private static final iv m = new iv("", (byte) 11, 13);
    private static final iv n = new iv("", (byte) 2, 14);
    private static final iv o = new iv("", (byte) 11, 15);
    private static final iv p = new iv("", (byte) 10, 16);
    private static final iv q = new iv("", (byte) 11, 20);
    private static final iv r = new iv("", (byte) 11, 21);

    /* renamed from: a  reason: collision with other field name */
    public long f587a;

    /* renamed from: a  reason: collision with other field name */
    public hp f588a;

    /* renamed from: a  reason: collision with other field name */
    public hr f589a;

    /* renamed from: a  reason: collision with other field name */
    public String f590a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f591a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f592a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f593b;

    /* renamed from: b  reason: collision with other field name */
    public String f594b;

    /* renamed from: c  reason: collision with other field name */
    public long f595c;

    /* renamed from: c  reason: collision with other field name */
    public String f596c;

    /* renamed from: d  reason: collision with other field name */
    public String f597d;

    /* renamed from: e  reason: collision with other field name */
    public String f598e;

    /* renamed from: f  reason: collision with other field name */
    public String f599f;

    /* renamed from: g  reason: collision with other field name */
    public String f600g;

    /* renamed from: h  reason: collision with other field name */
    public String f601h;

    /* renamed from: i  reason: collision with other field name */
    public String f602i;

    /* renamed from: j  reason: collision with other field name */
    public String f603j;

    /* renamed from: k  reason: collision with other field name */
    public String f604k;

    /* renamed from: l  reason: collision with other field name */
    public String f605l;

    /* renamed from: a */
    public int compareTo(ho hoVar) {
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
        if (!getClass().equals(hoVar.getClass())) {
            return getClass().getName().compareTo(hoVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m416a()).compareTo(Boolean.valueOf(hoVar.m416a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m416a() && (a19 = io.a(this.f589a, hoVar.f589a)) != 0) {
            return a19;
        }
        int compareTo2 = Boolean.valueOf(m418b()).compareTo(Boolean.valueOf(hoVar.m418b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m418b() && (a18 = io.a(this.f590a, hoVar.f590a)) != 0) {
            return a18;
        }
        int compareTo3 = Boolean.valueOf(m419c()).compareTo(Boolean.valueOf(hoVar.m419c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m419c() && (a17 = io.a(this.f594b, hoVar.f594b)) != 0) {
            return a17;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hoVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a16 = io.a(this.f596c, hoVar.f596c)) != 0) {
            return a16;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hoVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a15 = io.a(this.f587a, hoVar.f587a)) != 0) {
            return a15;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hoVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a14 = io.a(this.f593b, hoVar.f593b)) != 0) {
            return a14;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hoVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a13 = io.a(this.f597d, hoVar.f597d)) != 0) {
            return a13;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hoVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a12 = io.a(this.f598e, hoVar.f598e)) != 0) {
            return a12;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hoVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a11 = io.a(this.f599f, hoVar.f599f)) != 0) {
            return a11;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hoVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a10 = io.a(this.f600g, hoVar.f600g)) != 0) {
            return a10;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hoVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a9 = io.a(this.f601h, hoVar.f601h)) != 0) {
            return a9;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hoVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a8 = io.a(this.f588a, hoVar.f588a)) != 0) {
            return a8;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hoVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a7 = io.a(this.f602i, hoVar.f602i)) != 0) {
            return a7;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hoVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a6 = io.a(this.f592a, hoVar.f592a)) != 0) {
            return a6;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hoVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a5 = io.a(this.f603j, hoVar.f603j)) != 0) {
            return a5;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hoVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a4 = io.a(this.f595c, hoVar.f595c)) != 0) {
            return a4;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hoVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a3 = io.a(this.f604k, hoVar.f604k)) != 0) {
            return a3;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hoVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (!r() || (a2 = io.a(this.f605l, hoVar.f605l)) == 0) {
            return 0;
        }
        return a2;
    }

    public long a() {
        return this.f587a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m414a() {
        return this.f590a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m415a() {
        if (this.f590a == null) {
            throw new iz("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f594b == null) {
            throw new iz("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f596c == null) {
            throw new iz("Required field 'payload' was not present! Struct: " + toString());
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
                m415a();
                return;
            }
            short s = a2.f877a;
            if (s != 20) {
                if (s != 21) {
                    switch (s) {
                        case 1:
                            if (a2.a == 12) {
                                hr hrVar = new hr();
                                this.f589a = hrVar;
                                hrVar.a(iyVar);
                                break;
                            }
                            break;
                        case 2:
                            if (a2.a == 11) {
                                this.f590a = iyVar.m552a();
                                break;
                            }
                            break;
                        case 3:
                            if (a2.a == 11) {
                                this.f594b = iyVar.m552a();
                                break;
                            }
                            break;
                        case 4:
                            if (a2.a == 11) {
                                this.f596c = iyVar.m552a();
                                break;
                            }
                            break;
                        case 5:
                            if (a2.a == 10) {
                                this.f587a = iyVar.m546a();
                                a(true);
                                break;
                            }
                            break;
                        case 6:
                            if (a2.a == 10) {
                                this.f593b = iyVar.m546a();
                                b(true);
                                break;
                            }
                            break;
                        case 7:
                            if (a2.a == 11) {
                                this.f597d = iyVar.m552a();
                                break;
                            }
                            break;
                        case 8:
                            if (a2.a == 11) {
                                this.f598e = iyVar.m552a();
                                break;
                            }
                            break;
                        case 9:
                            if (a2.a == 11) {
                                this.f599f = iyVar.m552a();
                                break;
                            }
                            break;
                        case 10:
                            if (a2.a == 11) {
                                this.f600g = iyVar.m552a();
                                break;
                            }
                            break;
                        case 11:
                            if (a2.a == 11) {
                                this.f601h = iyVar.m552a();
                                break;
                            }
                            break;
                        case 12:
                            if (a2.a == 12) {
                                hp hpVar = new hp();
                                this.f588a = hpVar;
                                hpVar.a(iyVar);
                                break;
                            }
                            break;
                        case 13:
                            if (a2.a == 11) {
                                this.f602i = iyVar.m552a();
                                break;
                            }
                            break;
                        case 14:
                            if (a2.a == 2) {
                                this.f592a = iyVar.m556a();
                                c(true);
                                break;
                            }
                            break;
                        case 15:
                            if (a2.a == 11) {
                                this.f603j = iyVar.m552a();
                                break;
                            }
                            break;
                        case 16:
                            if (a2.a == 10) {
                                this.f595c = iyVar.m546a();
                                d(true);
                                break;
                            }
                            break;
                    }
                    iyVar.g();
                } else if (a2.a == 11) {
                    this.f605l = iyVar.m552a();
                    iyVar.g();
                }
            } else if (a2.a == 11) {
                this.f604k = iyVar.m552a();
                iyVar.g();
            }
            jb.a(iyVar, a2.a);
            iyVar.g();
        }
    }

    public void a(boolean z) {
        this.f591a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m416a() {
        return this.f589a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m417a(ho hoVar) {
        if (hoVar == null) {
            return false;
        }
        boolean a2 = m416a();
        boolean a3 = hoVar.m416a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f589a.m434a(hoVar.f589a))) {
            return false;
        }
        boolean b2 = m418b();
        boolean b3 = hoVar.m418b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f590a.equals(hoVar.f590a))) {
            return false;
        }
        boolean c2 = m419c();
        boolean c3 = hoVar.m419c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f594b.equals(hoVar.f594b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hoVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f596c.equals(hoVar.f596c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hoVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f587a != hoVar.f587a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hoVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f593b != hoVar.f593b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hoVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f597d.equals(hoVar.f597d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hoVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f598e.equals(hoVar.f598e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hoVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f599f.equals(hoVar.f599f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hoVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f600g.equals(hoVar.f600g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hoVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f601h.equals(hoVar.f601h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hoVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.f588a.m426a(hoVar.f588a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hoVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.f602i.equals(hoVar.f602i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hoVar.n();
        if ((n2 || n3) && (!n2 || !n3 || this.f592a != hoVar.f592a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hoVar.o();
        if ((o2 || o3) && (!o2 || !o3 || !this.f603j.equals(hoVar.f603j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hoVar.p();
        if ((p2 || p3) && (!p2 || !p3 || this.f595c != hoVar.f595c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hoVar.q();
        if ((q2 || q3) && (!q2 || !q3 || !this.f604k.equals(hoVar.f604k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hoVar.r();
        if (r2 || r3) {
            return r2 && r3 && this.f605l.equals(hoVar.f605l);
        }
        return true;
    }

    public String b() {
        return this.f594b;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m415a();
        iyVar.a(f586a);
        if (this.f589a != null && m416a()) {
            iyVar.a(a);
            this.f589a.b(iyVar);
            iyVar.b();
        }
        if (this.f590a != null) {
            iyVar.a(b);
            iyVar.a(this.f590a);
            iyVar.b();
        }
        if (this.f594b != null) {
            iyVar.a(c);
            iyVar.a(this.f594b);
            iyVar.b();
        }
        if (this.f596c != null) {
            iyVar.a(d);
            iyVar.a(this.f596c);
            iyVar.b();
        }
        if (e()) {
            iyVar.a(e);
            iyVar.a(this.f587a);
            iyVar.b();
        }
        if (f()) {
            iyVar.a(f);
            iyVar.a(this.f593b);
            iyVar.b();
        }
        if (this.f597d != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f597d);
            iyVar.b();
        }
        if (this.f598e != null && h()) {
            iyVar.a(h);
            iyVar.a(this.f598e);
            iyVar.b();
        }
        if (this.f599f != null && i()) {
            iyVar.a(i);
            iyVar.a(this.f599f);
            iyVar.b();
        }
        if (this.f600g != null && j()) {
            iyVar.a(j);
            iyVar.a(this.f600g);
            iyVar.b();
        }
        if (this.f601h != null && k()) {
            iyVar.a(k);
            iyVar.a(this.f601h);
            iyVar.b();
        }
        if (this.f588a != null && l()) {
            iyVar.a(f1504l);
            this.f588a.b(iyVar);
            iyVar.b();
        }
        if (this.f602i != null && m()) {
            iyVar.a(m);
            iyVar.a(this.f602i);
            iyVar.b();
        }
        if (n()) {
            iyVar.a(n);
            iyVar.a(this.f592a);
            iyVar.b();
        }
        if (this.f603j != null && o()) {
            iyVar.a(o);
            iyVar.a(this.f603j);
            iyVar.b();
        }
        if (p()) {
            iyVar.a(p);
            iyVar.a(this.f595c);
            iyVar.b();
        }
        if (this.f604k != null && q()) {
            iyVar.a(q);
            iyVar.a(this.f604k);
            iyVar.b();
        }
        if (this.f605l != null && r()) {
            iyVar.a(r);
            iyVar.a(this.f605l);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public void b(boolean z) {
        this.f591a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m418b() {
        return this.f590a != null;
    }

    public String c() {
        return this.f596c;
    }

    public void c(boolean z) {
        this.f591a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m419c() {
        return this.f594b != null;
    }

    public void d(boolean z) {
        this.f591a.set(3, z);
    }

    public boolean d() {
        return this.f596c != null;
    }

    public boolean e() {
        return this.f591a.get(0);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ho)) {
            return m417a((ho) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f591a.get(1);
    }

    public boolean g() {
        return this.f597d != null;
    }

    public boolean h() {
        return this.f598e != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f599f != null;
    }

    public boolean j() {
        return this.f600g != null;
    }

    public boolean k() {
        return this.f601h != null;
    }

    public boolean l() {
        return this.f588a != null;
    }

    public boolean m() {
        return this.f602i != null;
    }

    public boolean n() {
        return this.f591a.get(2);
    }

    public boolean o() {
        return this.f603j != null;
    }

    public boolean p() {
        return this.f591a.get(3);
    }

    public boolean q() {
        return this.f604k != null;
    }

    public boolean r() {
        return this.f605l != null;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (m416a()) {
            sb.append("to:");
            hr hrVar = this.f589a;
            if (hrVar == null) {
                sb.append("null");
            } else {
                sb.append(hrVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f590a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f594b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.f596c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f587a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f593b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.f597d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f598e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.f599f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f600g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.f601h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            hp hpVar = this.f588a;
            if (hpVar == null) {
                sb.append("null");
            } else {
                sb.append(hpVar);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f602i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f592a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f603j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f595c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f604k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f605l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
