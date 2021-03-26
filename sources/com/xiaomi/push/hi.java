package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class hi implements hu<hi, Object>, Serializable, Cloneable {
    private static final id A = new id("", (byte) 11, 12);
    private static final id B = new id("", (byte) 11, 13);
    private static final id C = new id("", (byte) 11, 14);
    private static final id D = new id("", (byte) 10, 15);
    private static final id E = new id("", (byte) 2, 20);
    private static final il p = new il("XmPushActionNotification");
    private static final id q = new id("", (byte) 11, 1);
    private static final id r = new id("", (byte) 12, 2);
    private static final id s = new id("", (byte) 11, 3);
    private static final id t = new id("", (byte) 11, 4);
    private static final id u = new id("", (byte) 11, 5);
    private static final id v = new id("", (byte) 2, 6);
    private static final id w = new id("", (byte) 11, 7);
    private static final id x = new id("", (byte) 13, 8);
    private static final id y = new id("", (byte) 11, 9);
    private static final id z = new id("", (byte) 11, 10);
    private BitSet F;
    public String a;
    public gy b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public String g;
    public Map<String, String> h;
    public String i;
    public String j;
    public String k;
    public String l;
    public ByteBuffer m;
    public long n;
    public boolean o;

    public hi() {
        this.F = new BitSet(3);
        this.f = true;
        this.o = false;
    }

    public hi(String str, boolean z2) {
        this();
        this.c = str;
        this.f = z2;
        b(true);
    }

    public hi a(String str) {
        this.c = str;
        return this;
    }

    public hi a(ByteBuffer byteBuffer) {
        this.m = byteBuffer;
        return this;
    }

    public hi a(Map<String, String> map) {
        this.h = map;
        return this;
    }

    public hi a(boolean z2) {
        this.f = z2;
        b(true);
        return this;
    }

    public hi a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                if (h()) {
                    u();
                    return;
                }
                throw new ih("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
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
                    if (h2.b == 2) {
                        this.f = igVar.p();
                        b(true);
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
                    if (h2.b == 13) {
                        Cif j2 = igVar.j();
                        this.h = new HashMap(j2.c * 2);
                        for (int i2 = 0; i2 < j2.c; i2++) {
                            this.h.put(igVar.v(), igVar.v());
                        }
                        igVar.k();
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
                    if (h2.b == 11) {
                        this.m = igVar.w();
                        continue;
                        igVar.i();
                    }
                    break;
                case 15:
                    if (h2.b == 10) {
                        this.n = igVar.t();
                        c(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 20:
                    if (h2.b == 2) {
                        this.o = igVar.p();
                        d(true);
                        continue;
                        igVar.i();
                    }
                    break;
            }
            ij.a(igVar, h2.b);
            igVar.i();
        }
    }

    public void a(String str, String str2) {
        if (this.h == null) {
            this.h = new HashMap();
        }
        this.h.put(str, str2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hi hiVar) {
        if (hiVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = hiVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(hiVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hiVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(hiVar.b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hiVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.c.equals(hiVar.c))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hiVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.d.equals(hiVar.d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hiVar.g();
        if (((g2 || g3) && (!g2 || !g3 || !this.e.equals(hiVar.e))) || this.f != hiVar.f) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hiVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.g.equals(hiVar.g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hiVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.h.equals(hiVar.h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hiVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.i.equals(hiVar.i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hiVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.j.equals(hiVar.j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hiVar.o();
        if ((o2 || o3) && (!o2 || !o3 || !this.k.equals(hiVar.k))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hiVar.p();
        if ((p2 || p3) && (!p2 || !p3 || !this.l.equals(hiVar.l))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hiVar.r();
        if ((r2 || r3) && (!r2 || !r3 || !this.m.equals(hiVar.m))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hiVar.s();
        if ((s2 || s3) && (!s2 || !s3 || this.n != hiVar.n)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hiVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.o == hiVar.o;
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(hi hiVar) {
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
        if (!getClass().equals(hiVar.getClass())) {
            return getClass().getName().compareTo(hiVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hiVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a16 = hv.a(this.a, hiVar.a)) != 0) {
            return a16;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hiVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a15 = hv.a(this.b, hiVar.b)) != 0) {
            return a15;
        }
        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hiVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d() && (a14 = hv.a(this.c, hiVar.c)) != 0) {
            return a14;
        }
        int compareTo4 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hiVar.f()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (f() && (a13 = hv.a(this.d, hiVar.d)) != 0) {
            return a13;
        }
        int compareTo5 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hiVar.g()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (g() && (a12 = hv.a(this.e, hiVar.e)) != 0) {
            return a12;
        }
        int compareTo6 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hiVar.h()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (h() && (a11 = hv.a(this.f, hiVar.f)) != 0) {
            return a11;
        }
        int compareTo7 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hiVar.i()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (i() && (a10 = hv.a(this.g, hiVar.g)) != 0) {
            return a10;
        }
        int compareTo8 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hiVar.k()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (k() && (a9 = hv.a(this.h, hiVar.h)) != 0) {
            return a9;
        }
        int compareTo9 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hiVar.m()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m() && (a8 = hv.a(this.i, hiVar.i)) != 0) {
            return a8;
        }
        int compareTo10 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hiVar.n()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (n() && (a7 = hv.a(this.j, hiVar.j)) != 0) {
            return a7;
        }
        int compareTo11 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hiVar.o()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (o() && (a6 = hv.a(this.k, hiVar.k)) != 0) {
            return a6;
        }
        int compareTo12 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hiVar.p()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (p() && (a5 = hv.a(this.l, hiVar.l)) != 0) {
            return a5;
        }
        int compareTo13 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hiVar.r()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (r() && (a4 = hv.a(this.m, hiVar.m)) != 0) {
            return a4;
        }
        int compareTo14 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hiVar.s()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (s() && (a3 = hv.a(this.n, hiVar.n)) != 0) {
            return a3;
        }
        int compareTo15 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hiVar.t()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (!t() || (a2 = hv.a(this.o, hiVar.o)) == 0) {
            return 0;
        }
        return a2;
    }

    public hi b(String str) {
        this.d = str;
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        u();
        igVar.a(p);
        if (this.a != null && a()) {
            igVar.a(q);
            igVar.a(this.a);
            igVar.b();
        }
        if (this.b != null && b()) {
            igVar.a(r);
            this.b.b(igVar);
            igVar.b();
        }
        if (this.c != null) {
            igVar.a(s);
            igVar.a(this.c);
            igVar.b();
        }
        if (this.d != null && f()) {
            igVar.a(t);
            igVar.a(this.d);
            igVar.b();
        }
        if (this.e != null && g()) {
            igVar.a(u);
            igVar.a(this.e);
            igVar.b();
        }
        igVar.a(v);
        igVar.a(this.f);
        igVar.b();
        if (this.g != null && i()) {
            igVar.a(w);
            igVar.a(this.g);
            igVar.b();
        }
        if (this.h != null && k()) {
            igVar.a(x);
            igVar.a(new Cif((byte) 11, (byte) 11, this.h.size()));
            for (Map.Entry<String, String> entry : this.h.entrySet()) {
                igVar.a(entry.getKey());
                igVar.a(entry.getValue());
            }
            igVar.d();
            igVar.b();
        }
        if (this.i != null && m()) {
            igVar.a(y);
            igVar.a(this.i);
            igVar.b();
        }
        if (this.j != null && n()) {
            igVar.a(z);
            igVar.a(this.j);
            igVar.b();
        }
        if (this.k != null && o()) {
            igVar.a(A);
            igVar.a(this.k);
            igVar.b();
        }
        if (this.l != null && p()) {
            igVar.a(B);
            igVar.a(this.l);
            igVar.b();
        }
        if (this.m != null && r()) {
            igVar.a(C);
            igVar.a(this.m);
            igVar.b();
        }
        if (s()) {
            igVar.a(D);
            igVar.a(this.n);
            igVar.b();
        }
        if (t()) {
            igVar.a(E);
            igVar.a(this.o);
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public void b(boolean z2) {
        this.F.set(0, z2);
    }

    public boolean b() {
        return this.b != null;
    }

    public hi c(String str) {
        this.e = str;
        return this;
    }

    public String c() {
        return this.c;
    }

    public void c(boolean z2) {
        this.F.set(1, z2);
    }

    public hi d(String str) {
        this.i = str;
        return this;
    }

    public void d(boolean z2) {
        this.F.set(2, z2);
    }

    public boolean d() {
        return this.c != null;
    }

    public String e() {
        return this.d;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hi)) {
            return a((hi) obj);
        }
        return false;
    }

    public boolean f() {
        return this.d != null;
    }

    public boolean g() {
        return this.e != null;
    }

    public boolean h() {
        return this.F.get(0);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.g != null;
    }

    public Map<String, String> j() {
        return this.h;
    }

    public boolean k() {
        return this.h != null;
    }

    public String l() {
        return this.i;
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

    public byte[] q() {
        a(hv.c(this.m));
        return this.m.array();
    }

    public boolean r() {
        return this.m != null;
    }

    public boolean s() {
        return this.F.get(1);
    }

    public boolean t() {
        return this.F.get(2);
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
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
        if (f()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.d;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f);
        if (i()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.h;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("packageName:");
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
            sb.append("regId:");
            String str8 = this.k;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.l;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.m;
            if (byteBuffer == null) {
                sb.append("null");
            } else {
                hv.a(byteBuffer, sb);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.n);
        }
        if (t()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.o);
        }
        sb.append(")");
        return sb.toString();
    }

    public void u() {
        if (this.c == null) {
            throw new ih("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
