package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class hs implements in<hs, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f631a = new jd("XmPushActionAckMessage");
    private static final iv b = new iv("", (byte) 12, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 10, 5);
    private static final iv f = new iv("", (byte) 11, 6);
    private static final iv g = new iv("", (byte) 11, 7);
    private static final iv h = new iv("", (byte) 12, 8);
    private static final iv i = new iv("", (byte) 11, 9);
    private static final iv j = new iv("", (byte) 11, 10);
    private static final iv k = new iv("", (byte) 2, 11);

    /* renamed from: l  reason: collision with root package name */
    private static final iv f1506l = new iv("", (byte) 11, 12);
    private static final iv m = new iv("", (byte) 11, 13);
    private static final iv n = new iv("", (byte) 11, 14);
    private static final iv o = new iv("", (byte) 6, 15);
    private static final iv p = new iv("", (byte) 6, 16);
    private static final iv q = new iv("", (byte) 11, 20);
    private static final iv r = new iv("", (byte) 11, 21);
    private static final iv s = new iv("", (byte) 8, 22);
    private static final iv t = new iv("", (byte) 13, 23);

    /* renamed from: a  reason: collision with other field name */
    public int f632a;

    /* renamed from: a  reason: collision with other field name */
    public long f633a;

    /* renamed from: a  reason: collision with other field name */
    public hr f634a;

    /* renamed from: a  reason: collision with other field name */
    public Cif f635a;

    /* renamed from: a  reason: collision with other field name */
    public String f636a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f637a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f638a;

    /* renamed from: a  reason: collision with other field name */
    public short f639a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f640a = false;

    /* renamed from: b  reason: collision with other field name */
    public String f641b;

    /* renamed from: b  reason: collision with other field name */
    public short f642b;

    /* renamed from: c  reason: collision with other field name */
    public String f643c;

    /* renamed from: d  reason: collision with other field name */
    public String f644d;

    /* renamed from: e  reason: collision with other field name */
    public String f645e;

    /* renamed from: f  reason: collision with other field name */
    public String f646f;

    /* renamed from: g  reason: collision with other field name */
    public String f647g;

    /* renamed from: h  reason: collision with other field name */
    public String f648h;

    /* renamed from: i  reason: collision with other field name */
    public String f649i;

    /* renamed from: j  reason: collision with other field name */
    public String f650j;

    /* renamed from: k  reason: collision with other field name */
    public String f651k;

    /* renamed from: l  reason: collision with other field name */
    public String f652l;

    /* renamed from: a */
    public int compareTo(hs hsVar) {
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
        if (!getClass().equals(hsVar.getClass())) {
            return getClass().getName().compareTo(hsVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m435a()).compareTo(Boolean.valueOf(hsVar.m435a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m435a() && (a21 = io.a(this.f636a, hsVar.f636a)) != 0) {
            return a21;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hsVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a20 = io.a(this.f634a, hsVar.f634a)) != 0) {
            return a20;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hsVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a19 = io.a(this.f641b, hsVar.f641b)) != 0) {
            return a19;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hsVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a18 = io.a(this.f643c, hsVar.f643c)) != 0) {
            return a18;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hsVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a17 = io.a(this.f633a, hsVar.f633a)) != 0) {
            return a17;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hsVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a16 = io.a(this.f644d, hsVar.f644d)) != 0) {
            return a16;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hsVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a15 = io.a(this.f645e, hsVar.f645e)) != 0) {
            return a15;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hsVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a14 = io.a(this.f635a, hsVar.f635a)) != 0) {
            return a14;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hsVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a13 = io.a(this.f646f, hsVar.f646f)) != 0) {
            return a13;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hsVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a12 = io.a(this.f647g, hsVar.f647g)) != 0) {
            return a12;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hsVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a11 = io.a(this.f640a, hsVar.f640a)) != 0) {
            return a11;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hsVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a10 = io.a(this.f648h, hsVar.f648h)) != 0) {
            return a10;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hsVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a9 = io.a(this.f649i, hsVar.f649i)) != 0) {
            return a9;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hsVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a8 = io.a(this.f650j, hsVar.f650j)) != 0) {
            return a8;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hsVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (o() && (a7 = io.a(this.f639a, hsVar.f639a)) != 0) {
            return a7;
        }
        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hsVar.p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (p() && (a6 = io.a(this.f642b, hsVar.f642b)) != 0) {
            return a6;
        }
        int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hsVar.q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (q() && (a5 = io.a(this.f651k, hsVar.f651k)) != 0) {
            return a5;
        }
        int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hsVar.r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (r() && (a4 = io.a(this.f652l, hsVar.f652l)) != 0) {
            return a4;
        }
        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hsVar.s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (s() && (a3 = io.a(this.f632a, hsVar.f632a)) != 0) {
            return a3;
        }
        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hsVar.t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!t() || (a2 = io.a(this.f638a, hsVar.f638a)) == 0) {
            return 0;
        }
        return a2;
    }

    public hs a(long j2) {
        this.f633a = j2;
        a(true);
        return this;
    }

    public hs a(String str) {
        this.f641b = str;
        return this;
    }

    public hs a(short s2) {
        this.f639a = s2;
        c(true);
        return this;
    }

    public void a() {
        if (this.f641b == null) {
            throw new iz("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f643c == null) {
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
                    a();
                    return;
                }
                throw new iz("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (a2.f877a) {
                case 1:
                    if (a2.a == 11) {
                        this.f636a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 2:
                    if (a2.a == 12) {
                        hr hrVar = new hr();
                        this.f634a = hrVar;
                        hrVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f641b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f643c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 5:
                    if (a2.a == 10) {
                        this.f633a = iyVar.m546a();
                        a(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 6:
                    if (a2.a == 11) {
                        this.f644d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 11) {
                        this.f645e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 8:
                    if (a2.a == 12) {
                        Cif ifVar = new Cif();
                        this.f635a = ifVar;
                        ifVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 9:
                    if (a2.a == 11) {
                        this.f646f = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 10:
                    if (a2.a == 11) {
                        this.f647g = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 11:
                    if (a2.a == 2) {
                        this.f640a = iyVar.m556a();
                        b(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 12:
                    if (a2.a == 11) {
                        this.f648h = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 13:
                    if (a2.a == 11) {
                        this.f649i = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 14:
                    if (a2.a == 11) {
                        this.f650j = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 15:
                    if (a2.a == 6) {
                        this.f639a = iyVar.m554a();
                        c(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 16:
                    if (a2.a == 6) {
                        this.f642b = iyVar.m554a();
                        d(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 20:
                    if (a2.a == 11) {
                        this.f651k = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 21:
                    if (a2.a == 11) {
                        this.f652l = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 22:
                    if (a2.a == 8) {
                        this.f632a = iyVar.m545a();
                        e(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 23:
                    if (a2.a == 13) {
                        ix a3 = iyVar.m549a();
                        this.f638a = new HashMap(a3.f879a * 2);
                        for (int i2 = 0; i2 < a3.f879a; i2++) {
                            this.f638a.put(iyVar.m552a(), iyVar.m552a());
                        }
                        iyVar.h();
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
        this.f637a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m435a() {
        return this.f636a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m436a(hs hsVar) {
        if (hsVar == null) {
            return false;
        }
        boolean a2 = m435a();
        boolean a3 = hsVar.m435a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f636a.equals(hsVar.f636a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hsVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f634a.m434a(hsVar.f634a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hsVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f641b.equals(hsVar.f641b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hsVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.f643c.equals(hsVar.f643c))) || this.f633a != hsVar.f633a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hsVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f644d.equals(hsVar.f644d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hsVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f645e.equals(hsVar.f645e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hsVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f635a.m504a(hsVar.f635a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hsVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f646f.equals(hsVar.f646f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hsVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f647g.equals(hsVar.f647g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hsVar.k();
        if ((k2 || k3) && (!k2 || !k3 || this.f640a != hsVar.f640a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hsVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.f648h.equals(hsVar.f648h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hsVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.f649i.equals(hsVar.f649i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hsVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.f650j.equals(hsVar.f650j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hsVar.o();
        if ((o2 || o3) && (!o2 || !o3 || this.f639a != hsVar.f639a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hsVar.p();
        if ((p2 || p3) && (!p2 || !p3 || this.f642b != hsVar.f642b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hsVar.q();
        if ((q2 || q3) && (!q2 || !q3 || !this.f651k.equals(hsVar.f651k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hsVar.r();
        if ((r2 || r3) && (!r2 || !r3 || !this.f652l.equals(hsVar.f652l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hsVar.s();
        if ((s2 || s3) && (!s2 || !s3 || this.f632a != hsVar.f632a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hsVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.f638a.equals(hsVar.f638a);
        }
        return true;
    }

    public hs b(String str) {
        this.f643c = str;
        return this;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        a();
        iyVar.a(f631a);
        if (this.f636a != null && m435a()) {
            iyVar.a(a);
            iyVar.a(this.f636a);
            iyVar.b();
        }
        if (this.f634a != null && b()) {
            iyVar.a(b);
            this.f634a.b(iyVar);
            iyVar.b();
        }
        if (this.f641b != null) {
            iyVar.a(c);
            iyVar.a(this.f641b);
            iyVar.b();
        }
        if (this.f643c != null) {
            iyVar.a(d);
            iyVar.a(this.f643c);
            iyVar.b();
        }
        iyVar.a(e);
        iyVar.a(this.f633a);
        iyVar.b();
        if (this.f644d != null && f()) {
            iyVar.a(f);
            iyVar.a(this.f644d);
            iyVar.b();
        }
        if (this.f645e != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f645e);
            iyVar.b();
        }
        if (this.f635a != null && h()) {
            iyVar.a(h);
            this.f635a.b(iyVar);
            iyVar.b();
        }
        if (this.f646f != null && i()) {
            iyVar.a(i);
            iyVar.a(this.f646f);
            iyVar.b();
        }
        if (this.f647g != null && j()) {
            iyVar.a(j);
            iyVar.a(this.f647g);
            iyVar.b();
        }
        if (k()) {
            iyVar.a(k);
            iyVar.a(this.f640a);
            iyVar.b();
        }
        if (this.f648h != null && l()) {
            iyVar.a(f1506l);
            iyVar.a(this.f648h);
            iyVar.b();
        }
        if (this.f649i != null && m()) {
            iyVar.a(m);
            iyVar.a(this.f649i);
            iyVar.b();
        }
        if (this.f650j != null && n()) {
            iyVar.a(n);
            iyVar.a(this.f650j);
            iyVar.b();
        }
        if (o()) {
            iyVar.a(o);
            iyVar.a(this.f639a);
            iyVar.b();
        }
        if (p()) {
            iyVar.a(p);
            iyVar.a(this.f642b);
            iyVar.b();
        }
        if (this.f651k != null && q()) {
            iyVar.a(q);
            iyVar.a(this.f651k);
            iyVar.b();
        }
        if (this.f652l != null && r()) {
            iyVar.a(r);
            iyVar.a(this.f652l);
            iyVar.b();
        }
        if (s()) {
            iyVar.a(s);
            iyVar.mo543a(this.f632a);
            iyVar.b();
        }
        if (this.f638a != null && t()) {
            iyVar.a(t);
            iyVar.a(new ix((byte) 11, (byte) 11, this.f638a.size()));
            for (Map.Entry<String, String> entry : this.f638a.entrySet()) {
                iyVar.a(entry.getKey());
                iyVar.a(entry.getValue());
            }
            iyVar.d();
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public void b(boolean z) {
        this.f637a.set(1, z);
    }

    public boolean b() {
        return this.f634a != null;
    }

    public hs c(String str) {
        this.f644d = str;
        return this;
    }

    public void c(boolean z) {
        this.f637a.set(2, z);
    }

    public boolean c() {
        return this.f641b != null;
    }

    public hs d(String str) {
        this.f645e = str;
        return this;
    }

    public void d(boolean z) {
        this.f637a.set(3, z);
    }

    public boolean d() {
        return this.f643c != null;
    }

    public void e(boolean z) {
        this.f637a.set(4, z);
    }

    public boolean e() {
        return this.f637a.get(0);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hs)) {
            return m436a((hs) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f644d != null;
    }

    public boolean g() {
        return this.f645e != null;
    }

    public boolean h() {
        return this.f635a != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f646f != null;
    }

    public boolean j() {
        return this.f647g != null;
    }

    public boolean k() {
        return this.f637a.get(1);
    }

    public boolean l() {
        return this.f648h != null;
    }

    public boolean m() {
        return this.f649i != null;
    }

    public boolean n() {
        return this.f650j != null;
    }

    public boolean o() {
        return this.f637a.get(2);
    }

    public boolean p() {
        return this.f637a.get(3);
    }

    public boolean q() {
        return this.f651k != null;
    }

    public boolean r() {
        return this.f652l != null;
    }

    public boolean s() {
        return this.f637a.get(4);
    }

    public boolean t() {
        return this.f638a != null;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = false;
        if (m435a()) {
            sb.append("debug:");
            String str = this.f636a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hr hrVar = this.f634a;
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
        String str2 = this.f641b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f643c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f633a);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f644d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f645e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            Cif ifVar = this.f635a;
            if (ifVar == null) {
                sb.append("null");
            } else {
                sb.append(ifVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f646f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f647g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f640a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f648h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f649i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f650j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f639a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f642b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f651k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f652l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f632a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f638a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
