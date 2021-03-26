package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class hs implements hu<hs, Object>, Serializable, Cloneable {
    private static final il j = new il("XmPushActionUnSubscriptionResult");
    private static final id k = new id("", (byte) 11, 1);
    private static final id l = new id("", (byte) 12, 2);
    private static final id m = new id("", (byte) 11, 3);
    private static final id n = new id("", (byte) 11, 4);
    private static final id o = new id("", (byte) 10, 6);
    private static final id p = new id("", (byte) 11, 7);
    private static final id q = new id("", (byte) 11, 8);
    private static final id r = new id("", (byte) 11, 9);
    private static final id s = new id("", (byte) 11, 10);
    public String a;
    public gy b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;
    public String h;
    public String i;
    private BitSet t = new BitSet(1);

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                l();
                return;
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
                    if (h2.b == 11) {
                        this.h = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 10:
                    if (h2.b == 11) {
                        this.i = igVar.v();
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

    public boolean a(hs hsVar) {
        if (hsVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = hsVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(hsVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hsVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(hsVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hsVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(hsVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hsVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.d.equals(hsVar.d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hsVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.e != hsVar.e)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hsVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f.equals(hsVar.f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hsVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.g.equals(hsVar.g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hsVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.h.equals(hsVar.h))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hsVar.k();
        if (k2 || k3) {
            return k2 && k3 && this.i.equals(hsVar.i);
        }
        return true;
    }

    /* renamed from: b */
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
        if (!getClass().equals(hsVar.getClass())) {
            return getClass().getName().compareTo(hsVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hsVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a10 = hv.a(this.a, hsVar.a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hsVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a9 = hv.a(this.b, hsVar.b)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hsVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a8 = hv.a(this.c, hsVar.c)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hsVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = hv.a(this.d, hsVar.d)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hsVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = hv.a(this.e, hsVar.e)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hsVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = hv.a(this.f, hsVar.f)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hsVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h() && (a4 = hv.a(this.g, hsVar.g)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hsVar.i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (i() && (a3 = hv.a(this.h, hsVar.h)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hsVar.k()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!k() || (a2 = hv.a(this.i, hsVar.i)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        l();
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
        if (this.d != null && d()) {
            igVar.a(n);
            igVar.a(this.d);
            igVar.b();
        }
        if (e()) {
            igVar.a(o);
            igVar.a(this.e);
            igVar.b();
        }
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
        if (this.h != null && i()) {
            igVar.a(r);
            igVar.a(this.h);
            igVar.b();
        }
        if (this.i != null && k()) {
            igVar.a(s);
            igVar.a(this.i);
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public boolean b() {
        return this.b != null;
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
        if (obj != null && (obj instanceof hs)) {
            return a((hs) obj);
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
        return this.h != null;
    }

    public String j() {
        return this.i;
    }

    public boolean k() {
        return this.i != null;
    }

    public void l() {
        if (this.c == null) {
            throw new ih("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
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
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.d;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.e);
        }
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
            sb.append("topic:");
            String str5 = this.g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.h;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.i;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
