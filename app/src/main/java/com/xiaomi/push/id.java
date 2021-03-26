package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class id implements in<id, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f759a = new jd("XmPushActionRegistrationResult");
    private static final iv b = new iv("", (byte) 12, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 10, 6);
    private static final iv f = new iv("", (byte) 11, 7);
    private static final iv g = new iv("", (byte) 11, 8);
    private static final iv h = new iv("", (byte) 11, 9);
    private static final iv i = new iv("", (byte) 11, 10);
    private static final iv j = new iv("", (byte) 10, 11);
    private static final iv k = new iv("", (byte) 11, 12);

    /* renamed from: l  reason: collision with root package name */
    private static final iv f1509l = new iv("", (byte) 11, 13);
    private static final iv m = new iv("", (byte) 10, 14);
    private static final iv n = new iv("", (byte) 11, 15);
    private static final iv o = new iv("", (byte) 8, 16);
    private static final iv p = new iv("", (byte) 11, 17);
    private static final iv q = new iv("", (byte) 8, 18);
    private static final iv r = new iv("", (byte) 11, 19);

    /* renamed from: a  reason: collision with other field name */
    public int f760a;

    /* renamed from: a  reason: collision with other field name */
    public long f761a;

    /* renamed from: a  reason: collision with other field name */
    public hr f762a;

    /* renamed from: a  reason: collision with other field name */
    public String f763a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f764a = new BitSet(5);

    /* renamed from: b  reason: collision with other field name */
    public int f765b;

    /* renamed from: b  reason: collision with other field name */
    public long f766b;

    /* renamed from: b  reason: collision with other field name */
    public String f767b;

    /* renamed from: c  reason: collision with other field name */
    public long f768c;

    /* renamed from: c  reason: collision with other field name */
    public String f769c;

    /* renamed from: d  reason: collision with other field name */
    public String f770d;

    /* renamed from: e  reason: collision with other field name */
    public String f771e;

    /* renamed from: f  reason: collision with other field name */
    public String f772f;

    /* renamed from: g  reason: collision with other field name */
    public String f773g;

    /* renamed from: h  reason: collision with other field name */
    public String f774h;

    /* renamed from: i  reason: collision with other field name */
    public String f775i;

    /* renamed from: j  reason: collision with other field name */
    public String f776j;

    /* renamed from: k  reason: collision with other field name */
    public String f777k;

    /* renamed from: l  reason: collision with other field name */
    public String f778l;

    /* renamed from: a */
    public int compareTo(id idVar) {
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
        if (!getClass().equals(idVar.getClass())) {
            return getClass().getName().compareTo(idVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m496a()).compareTo(Boolean.valueOf(idVar.m496a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m496a() && (a19 = io.a(this.f763a, idVar.f763a)) != 0) {
            return a19;
        }
        int compareTo2 = Boolean.valueOf(m498b()).compareTo(Boolean.valueOf(idVar.m498b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m498b() && (a18 = io.a(this.f762a, idVar.f762a)) != 0) {
            return a18;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a17 = io.a(this.f767b, idVar.f767b)) != 0) {
            return a17;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a16 = io.a(this.f769c, idVar.f769c)) != 0) {
            return a16;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a15 = io.a(this.f761a, idVar.f761a)) != 0) {
            return a15;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a14 = io.a(this.f770d, idVar.f770d)) != 0) {
            return a14;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a13 = io.a(this.f771e, idVar.f771e)) != 0) {
            return a13;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a12 = io.a(this.f772f, idVar.f772f)) != 0) {
            return a12;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a11 = io.a(this.f773g, idVar.f773g)) != 0) {
            return a11;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(idVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a10 = io.a(this.f766b, idVar.f766b)) != 0) {
            return a10;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(idVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a9 = io.a(this.f774h, idVar.f774h)) != 0) {
            return a9;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(idVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a8 = io.a(this.f775i, idVar.f775i)) != 0) {
            return a8;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(idVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a7 = io.a(this.f768c, idVar.f768c)) != 0) {
            return a7;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(idVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a6 = io.a(this.f776j, idVar.f776j)) != 0) {
            return a6;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(idVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a5 = io.a(this.f760a, idVar.f760a)) != 0) {
            return a5;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(idVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a4 = io.a(this.f777k, idVar.f777k)) != 0) {
            return a4;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(idVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a3 = io.a(this.f765b, idVar.f765b)) != 0) {
            return a3;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(idVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (!r() || (a2 = io.a(this.f778l, idVar.f778l)) == 0) {
            return 0;
        }
        return a2;
    }

    public long a() {
        return this.f761a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m494a() {
        return this.f767b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m495a() {
        if (this.f767b == null) {
            throw new iz("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f769c == null) {
            throw new iz("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                iyVar.f();
                if (e()) {
                    m495a();
                    return;
                }
                throw new iz("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (a2.f877a) {
                case 1:
                    if (a2.a == 11) {
                        this.f763a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 2:
                    if (a2.a == 12) {
                        hr hrVar = new hr();
                        this.f762a = hrVar;
                        hrVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f767b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f769c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 6:
                    if (a2.a == 10) {
                        this.f761a = iyVar.m546a();
                        a(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 11) {
                        this.f770d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 8:
                    if (a2.a == 11) {
                        this.f771e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 9:
                    if (a2.a == 11) {
                        this.f772f = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 10:
                    if (a2.a == 11) {
                        this.f773g = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 11:
                    if (a2.a == 10) {
                        this.f766b = iyVar.m546a();
                        b(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 12:
                    if (a2.a == 11) {
                        this.f774h = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 13:
                    if (a2.a == 11) {
                        this.f775i = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 14:
                    if (a2.a == 10) {
                        this.f768c = iyVar.m546a();
                        c(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 15:
                    if (a2.a == 11) {
                        this.f776j = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 16:
                    if (a2.a == 8) {
                        this.f760a = iyVar.m545a();
                        d(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 17:
                    if (a2.a == 11) {
                        this.f777k = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 18:
                    if (a2.a == 8) {
                        this.f765b = iyVar.m545a();
                        e(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 19:
                    if (a2.a == 11) {
                        this.f778l = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
            }
            jb.a(iyVar, a2.a);
            iyVar.g();
        }
    }

    public void a(boolean z) {
        this.f764a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m496a() {
        return this.f763a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m497a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean a2 = m496a();
        boolean a3 = idVar.m496a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f763a.equals(idVar.f763a))) {
            return false;
        }
        boolean b2 = m498b();
        boolean b3 = idVar.m498b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f762a.m434a(idVar.f762a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = idVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f767b.equals(idVar.f767b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = idVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.f769c.equals(idVar.f769c))) || this.f761a != idVar.f761a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = idVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f770d.equals(idVar.f770d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = idVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f771e.equals(idVar.f771e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = idVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f772f.equals(idVar.f772f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = idVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f773g.equals(idVar.f773g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = idVar.j();
        if ((j2 || j3) && (!j2 || !j3 || this.f766b != idVar.f766b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = idVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f774h.equals(idVar.f774h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = idVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.f775i.equals(idVar.f775i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = idVar.m();
        if ((m2 || m3) && (!m2 || !m3 || this.f768c != idVar.f768c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = idVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.f776j.equals(idVar.f776j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = idVar.o();
        if ((o2 || o3) && (!o2 || !o3 || this.f760a != idVar.f760a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = idVar.p();
        if ((p2 || p3) && (!p2 || !p3 || !this.f777k.equals(idVar.f777k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = idVar.q();
        if ((q2 || q3) && (!q2 || !q3 || this.f765b != idVar.f765b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = idVar.r();
        if (r2 || r3) {
            return r2 && r3 && this.f778l.equals(idVar.f778l);
        }
        return true;
    }

    public String b() {
        return this.f773g;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m495a();
        iyVar.a(f759a);
        if (this.f763a != null && m496a()) {
            iyVar.a(a);
            iyVar.a(this.f763a);
            iyVar.b();
        }
        if (this.f762a != null && m498b()) {
            iyVar.a(b);
            this.f762a.b(iyVar);
            iyVar.b();
        }
        if (this.f767b != null) {
            iyVar.a(c);
            iyVar.a(this.f767b);
            iyVar.b();
        }
        if (this.f769c != null) {
            iyVar.a(d);
            iyVar.a(this.f769c);
            iyVar.b();
        }
        iyVar.a(e);
        iyVar.a(this.f761a);
        iyVar.b();
        if (this.f770d != null && f()) {
            iyVar.a(f);
            iyVar.a(this.f770d);
            iyVar.b();
        }
        if (this.f771e != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f771e);
            iyVar.b();
        }
        if (this.f772f != null && h()) {
            iyVar.a(h);
            iyVar.a(this.f772f);
            iyVar.b();
        }
        if (this.f773g != null && i()) {
            iyVar.a(i);
            iyVar.a(this.f773g);
            iyVar.b();
        }
        if (j()) {
            iyVar.a(j);
            iyVar.a(this.f766b);
            iyVar.b();
        }
        if (this.f774h != null && k()) {
            iyVar.a(k);
            iyVar.a(this.f774h);
            iyVar.b();
        }
        if (this.f775i != null && l()) {
            iyVar.a(f1509l);
            iyVar.a(this.f775i);
            iyVar.b();
        }
        if (m()) {
            iyVar.a(m);
            iyVar.a(this.f768c);
            iyVar.b();
        }
        if (this.f776j != null && n()) {
            iyVar.a(n);
            iyVar.a(this.f776j);
            iyVar.b();
        }
        if (o()) {
            iyVar.a(o);
            iyVar.mo543a(this.f760a);
            iyVar.b();
        }
        if (this.f777k != null && p()) {
            iyVar.a(p);
            iyVar.a(this.f777k);
            iyVar.b();
        }
        if (q()) {
            iyVar.a(q);
            iyVar.mo543a(this.f765b);
            iyVar.b();
        }
        if (this.f778l != null && r()) {
            iyVar.a(r);
            iyVar.a(this.f778l);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public void b(boolean z) {
        this.f764a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m498b() {
        return this.f762a != null;
    }

    public void c(boolean z) {
        this.f764a.set(2, z);
    }

    public boolean c() {
        return this.f767b != null;
    }

    public void d(boolean z) {
        this.f764a.set(3, z);
    }

    public boolean d() {
        return this.f769c != null;
    }

    public void e(boolean z) {
        this.f764a.set(4, z);
    }

    public boolean e() {
        return this.f764a.get(0);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m497a((id) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f770d != null;
    }

    public boolean g() {
        return this.f771e != null;
    }

    public boolean h() {
        return this.f772f != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f773g != null;
    }

    public boolean j() {
        return this.f764a.get(1);
    }

    public boolean k() {
        return this.f774h != null;
    }

    public boolean l() {
        return this.f775i != null;
    }

    public boolean m() {
        return this.f764a.get(2);
    }

    public boolean n() {
        return this.f776j != null;
    }

    public boolean o() {
        return this.f764a.get(3);
    }

    public boolean p() {
        return this.f777k != null;
    }

    public boolean q() {
        return this.f764a.get(4);
    }

    public boolean r() {
        return this.f778l != null;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = false;
        if (m496a()) {
            sb.append("debug:");
            String str = this.f763a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m498b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hr hrVar = this.f762a;
            if (hrVar == null) {
                sb.append("null");
            } else {
                sb.append(hrVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f767b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f769c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f761a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f770d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.f771e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("regSecret:");
            String str6 = this.f772f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str7 = this.f773g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f766b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f774h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            String str9 = this.f775i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f768c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str10 = this.f776j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f760a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str11 = this.f777k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f765b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            String str12 = this.f778l;
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
