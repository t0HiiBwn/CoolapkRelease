package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class gv implements hu<gv, Object>, Serializable, Cloneable {
    private static final id A = new id("", (byte) 13, 13);
    private static final il n = new il("PushMetaInfo");
    private static final id o = new id("", (byte) 11, 1);
    private static final id p = new id("", (byte) 10, 2);
    private static final id q = new id("", (byte) 11, 3);
    private static final id r = new id("", (byte) 11, 4);
    private static final id s = new id("", (byte) 11, 5);
    private static final id t = new id("", (byte) 8, 6);
    private static final id u = new id("", (byte) 11, 7);
    private static final id v = new id("", (byte) 8, 8);
    private static final id w = new id("", (byte) 8, 9);
    private static final id x = new id("", (byte) 13, 10);
    private static final id y = new id("", (byte) 13, 11);
    private static final id z = new id("", (byte) 2, 12);
    private BitSet B;
    public String a;
    public long b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public int h;
    public int i;
    public Map<String, String> j;
    public Map<String, String> k;
    public boolean l;
    public Map<String, String> m;

    public gv() {
        this.B = new BitSet(5);
        this.l = false;
    }

    public gv(gv gvVar) {
        BitSet bitSet = new BitSet(5);
        this.B = bitSet;
        bitSet.clear();
        this.B.or(gvVar.B);
        if (gvVar.c()) {
            this.a = gvVar.a;
        }
        this.b = gvVar.b;
        if (gvVar.g()) {
            this.c = gvVar.c;
        }
        if (gvVar.i()) {
            this.d = gvVar.d;
        }
        if (gvVar.k()) {
            this.e = gvVar.e;
        }
        this.f = gvVar.f;
        if (gvVar.n()) {
            this.g = gvVar.g;
        }
        this.h = gvVar.h;
        this.i = gvVar.i;
        if (gvVar.t()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : gvVar.j.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.j = hashMap;
        }
        if (gvVar.v()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : gvVar.k.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.k = hashMap2;
        }
        this.l = gvVar.l;
        if (gvVar.y()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : gvVar.m.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.m = hashMap3;
        }
    }

    public gv a() {
        return new gv(this);
    }

    public gv a(int i2) {
        this.f = i2;
        b(true);
        return this;
    }

    public gv a(String str) {
        this.a = str;
        return this;
    }

    public gv a(Map<String, String> map) {
        this.j = map;
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
                if (e()) {
                    z();
                    return;
                }
                throw new ih("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (h2.c) {
                case 1:
                    if (h2.b == 11) {
                        this.a = igVar.v();
                        break;
                    }
                    ij.a(igVar, h2.b);
                    break;
                case 2:
                    if (h2.b == 10) {
                        this.b = igVar.t();
                        a(true);
                        break;
                    }
                    ij.a(igVar, h2.b);
                    break;
                case 3:
                    if (h2.b == 11) {
                        this.c = igVar.v();
                        break;
                    }
                    ij.a(igVar, h2.b);
                    break;
                case 4:
                    if (h2.b == 11) {
                        this.d = igVar.v();
                        break;
                    }
                    ij.a(igVar, h2.b);
                    break;
                case 5:
                    if (h2.b == 11) {
                        this.e = igVar.v();
                        break;
                    }
                    ij.a(igVar, h2.b);
                    break;
                case 6:
                    if (h2.b == 8) {
                        this.f = igVar.s();
                        b(true);
                        break;
                    }
                    ij.a(igVar, h2.b);
                    break;
                case 7:
                    if (h2.b == 11) {
                        this.g = igVar.v();
                        break;
                    }
                    ij.a(igVar, h2.b);
                    break;
                case 8:
                    if (h2.b == 8) {
                        this.h = igVar.s();
                        c(true);
                        break;
                    }
                    ij.a(igVar, h2.b);
                    break;
                case 9:
                    if (h2.b == 8) {
                        this.i = igVar.s();
                        d(true);
                        break;
                    }
                    ij.a(igVar, h2.b);
                    break;
                case 10:
                    if (h2.b == 13) {
                        Cif j2 = igVar.j();
                        this.j = new HashMap(j2.c * 2);
                        while (i2 < j2.c) {
                            this.j.put(igVar.v(), igVar.v());
                            i2++;
                        }
                        igVar.k();
                        break;
                    }
                    ij.a(igVar, h2.b);
                    break;
                case 11:
                    if (h2.b == 13) {
                        Cif j3 = igVar.j();
                        this.k = new HashMap(j3.c * 2);
                        while (i2 < j3.c) {
                            this.k.put(igVar.v(), igVar.v());
                            i2++;
                        }
                        igVar.k();
                        break;
                    }
                    ij.a(igVar, h2.b);
                    break;
                case 12:
                    if (h2.b == 2) {
                        this.l = igVar.p();
                        e(true);
                        break;
                    }
                    ij.a(igVar, h2.b);
                    break;
                case 13:
                    if (h2.b == 13) {
                        Cif j4 = igVar.j();
                        this.m = new HashMap(j4.c * 2);
                        while (i2 < j4.c) {
                            this.m.put(igVar.v(), igVar.v());
                            i2++;
                        }
                        igVar.k();
                        break;
                    }
                    ij.a(igVar, h2.b);
                    break;
                default:
                    ij.a(igVar, h2.b);
                    break;
            }
            igVar.i();
        }
    }

    public void a(String str, String str2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        this.j.put(str, str2);
    }

    public void a(boolean z2) {
        this.B.set(0, z2);
    }

    public boolean a(gv gvVar) {
        if (gvVar == null) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = gvVar.c();
        if (((c2 || c3) && (!c2 || !c3 || !this.a.equals(gvVar.a))) || this.b != gvVar.b) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = gvVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.c.equals(gvVar.c))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = gvVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.d.equals(gvVar.d))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = gvVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.e.equals(gvVar.e))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = gvVar.m();
        if ((m2 || m3) && (!m2 || !m3 || this.f != gvVar.f)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = gvVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.g.equals(gvVar.g))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = gvVar.p();
        if ((p2 || p3) && (!p2 || !p3 || this.h != gvVar.h)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = gvVar.r();
        if ((r2 || r3) && (!r2 || !r3 || this.i != gvVar.i)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = gvVar.t();
        if ((t2 || t3) && (!t2 || !t3 || !this.j.equals(gvVar.j))) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = gvVar.v();
        if ((v2 || v3) && (!v2 || !v3 || !this.k.equals(gvVar.k))) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = gvVar.x();
        if ((x2 || x3) && (!x2 || !x3 || this.l != gvVar.l)) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = gvVar.y();
        if (y2 || y3) {
            return y2 && y3 && this.m.equals(gvVar.m);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(gv gvVar) {
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
        if (!getClass().equals(gvVar.getClass())) {
            return getClass().getName().compareTo(gvVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gvVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c() && (a14 = hv.a(this.a, gvVar.a)) != 0) {
            return a14;
        }
        int compareTo2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gvVar.e()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (e() && (a13 = hv.a(this.b, gvVar.b)) != 0) {
            return a13;
        }
        int compareTo3 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gvVar.g()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (g() && (a12 = hv.a(this.c, gvVar.c)) != 0) {
            return a12;
        }
        int compareTo4 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gvVar.i()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (i() && (a11 = hv.a(this.d, gvVar.d)) != 0) {
            return a11;
        }
        int compareTo5 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gvVar.k()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (k() && (a10 = hv.a(this.e, gvVar.e)) != 0) {
            return a10;
        }
        int compareTo6 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gvVar.m()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m() && (a9 = hv.a(this.f, gvVar.f)) != 0) {
            return a9;
        }
        int compareTo7 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gvVar.n()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (n() && (a8 = hv.a(this.g, gvVar.g)) != 0) {
            return a8;
        }
        int compareTo8 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(gvVar.p()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (p() && (a7 = hv.a(this.h, gvVar.h)) != 0) {
            return a7;
        }
        int compareTo9 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(gvVar.r()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (r() && (a6 = hv.a(this.i, gvVar.i)) != 0) {
            return a6;
        }
        int compareTo10 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(gvVar.t()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (t() && (a5 = hv.a(this.j, gvVar.j)) != 0) {
            return a5;
        }
        int compareTo11 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(gvVar.v()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (v() && (a4 = hv.a(this.k, gvVar.k)) != 0) {
            return a4;
        }
        int compareTo12 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(gvVar.x()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (x() && (a3 = hv.a(this.l, gvVar.l)) != 0) {
            return a3;
        }
        int compareTo13 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(gvVar.y()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (!y() || (a2 = hv.a(this.m, gvVar.m)) == 0) {
            return 0;
        }
        return a2;
    }

    public gv b(int i2) {
        this.h = i2;
        c(true);
        return this;
    }

    public gv b(String str) {
        this.c = str;
        return this;
    }

    public String b() {
        return this.a;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        z();
        igVar.a(n);
        if (this.a != null) {
            igVar.a(o);
            igVar.a(this.a);
            igVar.b();
        }
        igVar.a(p);
        igVar.a(this.b);
        igVar.b();
        if (this.c != null && g()) {
            igVar.a(q);
            igVar.a(this.c);
            igVar.b();
        }
        if (this.d != null && i()) {
            igVar.a(r);
            igVar.a(this.d);
            igVar.b();
        }
        if (this.e != null && k()) {
            igVar.a(s);
            igVar.a(this.e);
            igVar.b();
        }
        if (m()) {
            igVar.a(t);
            igVar.a(this.f);
            igVar.b();
        }
        if (this.g != null && n()) {
            igVar.a(u);
            igVar.a(this.g);
            igVar.b();
        }
        if (p()) {
            igVar.a(v);
            igVar.a(this.h);
            igVar.b();
        }
        if (r()) {
            igVar.a(w);
            igVar.a(this.i);
            igVar.b();
        }
        if (this.j != null && t()) {
            igVar.a(x);
            igVar.a(new Cif((byte) 11, (byte) 11, this.j.size()));
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                igVar.a(entry.getKey());
                igVar.a(entry.getValue());
            }
            igVar.d();
            igVar.b();
        }
        if (this.k != null && v()) {
            igVar.a(y);
            igVar.a(new Cif((byte) 11, (byte) 11, this.k.size()));
            for (Map.Entry<String, String> entry2 : this.k.entrySet()) {
                igVar.a(entry2.getKey());
                igVar.a(entry2.getValue());
            }
            igVar.d();
            igVar.b();
        }
        if (x()) {
            igVar.a(z);
            igVar.a(this.l);
            igVar.b();
        }
        if (this.m != null && y()) {
            igVar.a(A);
            igVar.a(new Cif((byte) 11, (byte) 11, this.m.size()));
            for (Map.Entry<String, String> entry3 : this.m.entrySet()) {
                igVar.a(entry3.getKey());
                igVar.a(entry3.getValue());
            }
            igVar.d();
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public void b(String str, String str2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        this.k.put(str, str2);
    }

    public void b(boolean z2) {
        this.B.set(1, z2);
    }

    public gv c(int i2) {
        this.i = i2;
        d(true);
        return this;
    }

    public gv c(String str) {
        this.d = str;
        return this;
    }

    public void c(boolean z2) {
        this.B.set(2, z2);
    }

    public boolean c() {
        return this.a != null;
    }

    public long d() {
        return this.b;
    }

    public gv d(String str) {
        this.e = str;
        return this;
    }

    public void d(boolean z2) {
        this.B.set(3, z2);
    }

    public void e(boolean z2) {
        this.B.set(4, z2);
    }

    public boolean e() {
        return this.B.get(0);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gv)) {
            return a((gv) obj);
        }
        return false;
    }

    public String f() {
        return this.c;
    }

    public boolean g() {
        return this.c != null;
    }

    public String h() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.d != null;
    }

    public String j() {
        return this.e;
    }

    public boolean k() {
        return this.e != null;
    }

    public int l() {
        return this.f;
    }

    public boolean m() {
        return this.B.get(1);
    }

    public boolean n() {
        return this.g != null;
    }

    public int o() {
        return this.h;
    }

    public boolean p() {
        return this.B.get(2);
    }

    public int q() {
        return this.i;
    }

    public boolean r() {
        return this.B.get(3);
    }

    public Map<String, String> s() {
        return this.j;
    }

    public boolean t() {
        return this.j != null;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.b);
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.c;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.d;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f);
        }
        if (n()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.h);
        }
        if (r()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.i);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.j;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (v()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.k;
            if (map2 == null) {
                sb.append("null");
            } else {
                sb.append(map2);
            }
        }
        if (x()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.l);
        }
        if (y()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.m;
            if (map3 == null) {
                sb.append("null");
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public Map<String, String> u() {
        return this.k;
    }

    public boolean v() {
        return this.k != null;
    }

    public boolean w() {
        return this.l;
    }

    public boolean x() {
        return this.B.get(4);
    }

    public boolean y() {
        return this.m != null;
    }

    public void z() {
        if (this.a == null) {
            throw new ih("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
