package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class hq implements hu<hq, Object>, Serializable, Cloneable {
    private static final il j = new il("XmPushActionUnRegistrationResult");
    private static final id k = new id("", (byte) 11, 1);
    private static final id l = new id("", (byte) 12, 2);
    private static final id m = new id("", (byte) 11, 3);
    private static final id n = new id("", (byte) 11, 4);
    private static final id o = new id("", (byte) 10, 6);
    private static final id p = new id("", (byte) 11, 7);
    private static final id q = new id("", (byte) 11, 8);
    private static final id r = new id("", (byte) 10, 9);
    private static final id s = new id("", (byte) 10, 10);
    public String a;
    public gy b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;
    public long h;
    public long i;
    private BitSet t = new BitSet(3);

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                if (e()) {
                    k();
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
                    if (h2.b == 10) {
                        this.h = igVar.t();
                        b(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 10:
                    if (h2.b == 10) {
                        this.i = igVar.t();
                        c(true);
                        continue;
                        igVar.i();
                    }
                    break;
            }
            ij.a(igVar, h2.b);
            igVar.i();
        }
    }

    public void a(boolean z) {
        this.t.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hq hqVar) {
        if (hqVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = hqVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(hqVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hqVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(hqVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hqVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(hqVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hqVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.d.equals(hqVar.d))) || this.e != hqVar.e) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hqVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f.equals(hqVar.f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hqVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.g.equals(hqVar.g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hqVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.h != hqVar.h)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hqVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.i == hqVar.i;
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(hq hqVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (!getClass().equals(hqVar.getClass())) {
            return getClass().getName().compareTo(hqVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hqVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a10 = hv.a(this.a, hqVar.a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hqVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a9 = hv.a(this.b, hqVar.b)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hqVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a8 = hv.a(this.c, hqVar.c)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hqVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = hv.a(this.d, hqVar.d)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hqVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = hv.a(this.e, hqVar.e)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hqVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = hv.a(this.f, hqVar.f)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hqVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h() && (a4 = hv.a(this.g, hqVar.g)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hqVar.i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (i() && (a3 = hv.a(this.h, hqVar.h)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hqVar.j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!j() || (a2 = hv.a(this.i, hqVar.i)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        k();
        igVar.a(j);
        if (this.a != null && a()) {
            igVar.a(k);
            igVar.a(this.a);
            igVar.b();
        }
        if (this.b != null && b()) {
            igVar.a(l);
            this.b.b(igVar);
            igVar.b();
        }
        if (this.c != null) {
            igVar.a(m);
            igVar.a(this.c);
            igVar.b();
        }
        if (this.d != null) {
            igVar.a(n);
            igVar.a(this.d);
            igVar.b();
        }
        igVar.a(o);
        igVar.a(this.e);
        igVar.b();
        if (this.f != null && f()) {
            igVar.a(p);
            igVar.a(this.f);
            igVar.b();
        }
        if (this.g != null && h()) {
            igVar.a(q);
            igVar.a(this.g);
            igVar.b();
        }
        if (i()) {
            igVar.a(r);
            igVar.a(this.h);
            igVar.b();
        }
        if (j()) {
            igVar.a(s);
            igVar.a(this.i);
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public void b(boolean z) {
        this.t.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public void c(boolean z) {
        this.t.set(2, z);
    }

    public boolean c() {
        return this.c != null;
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.t.get(0);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hq)) {
            return a((hq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f != null;
    }

    public String g() {
        return this.g;
    }

    public boolean h() {
        return this.g != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.t.get(1);
    }

    public boolean j() {
        return this.t.get(2);
    }

    public void k() {
        if (this.c == null) {
            throw new ih("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new ih("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = false;
        if (a()) {
            sb.append("debug:");
            String str = this.a;
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
            gy gyVar = this.b;
            if (gyVar == null) {
                sb.append("null");
            } else {
                sb.append(gyVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
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
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.h);
        }
        if (j()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.i);
        }
        sb.append(")");
        return sb.toString();
    }
}
