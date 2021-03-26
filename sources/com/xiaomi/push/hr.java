package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class hr implements hu<hr, Object>, Serializable, Cloneable {
    private static final il i = new il("XmPushActionUnSubscription");
    private static final id j = new id("", (byte) 11, 1);
    private static final id k = new id("", (byte) 12, 2);
    private static final id l = new id("", (byte) 11, 3);
    private static final id m = new id("", (byte) 11, 4);
    private static final id n = new id("", (byte) 11, 5);
    private static final id o = new id("", (byte) 11, 6);
    private static final id p = new id("", (byte) 11, 7);
    private static final id q = new id("", (byte) 15, 8);
    public String a;
    public gy b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public List<String> h;

    public hr a(String str) {
        this.c = str;
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                i();
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
                case 5:
                    if (h2.b == 11) {
                        this.e = igVar.v();
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
                    if (h2.b == 15) {
                        ie l2 = igVar.l();
                        this.h = new ArrayList(l2.b);
                        for (int i2 = 0; i2 < l2.b; i2++) {
                            this.h.add(igVar.v());
                        }
                        igVar.m();
                        continue;
                        igVar.i();
                    }
                    break;
            }
            ij.a(igVar, h2.b);
            igVar.i();
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hr hrVar) {
        if (hrVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = hrVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(hrVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hrVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(hrVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hrVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(hrVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hrVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.d.equals(hrVar.d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hrVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.e.equals(hrVar.e))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hrVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f.equals(hrVar.f))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hrVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.g.equals(hrVar.g))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hrVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.h.equals(hrVar.h);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(hr hrVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(hrVar.getClass())) {
            return getClass().getName().compareTo(hrVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hrVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a9 = hv.a(this.a, hrVar.a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hrVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a8 = hv.a(this.b, hrVar.b)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hrVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a7 = hv.a(this.c, hrVar.c)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hrVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a6 = hv.a(this.d, hrVar.d)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hrVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a5 = hv.a(this.e, hrVar.e)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hrVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a4 = hv.a(this.f, hrVar.f)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hrVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a3 = hv.a(this.g, hrVar.g)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hrVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (a2 = hv.a(this.h, hrVar.h)) == 0) {
            return 0;
        }
        return a2;
    }

    public hr b(String str) {
        this.d = str;
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        i();
        igVar.a(i);
        if (this.a != null && a()) {
            igVar.a(j);
            igVar.a(this.a);
            igVar.b();
        }
        if (this.b != null && b()) {
            igVar.a(k);
            this.b.b(igVar);
            igVar.b();
        }
        if (this.c != null) {
            igVar.a(l);
            igVar.a(this.c);
            igVar.b();
        }
        if (this.d != null) {
            igVar.a(m);
            igVar.a(this.d);
            igVar.b();
        }
        if (this.e != null) {
            igVar.a(n);
            igVar.a(this.e);
            igVar.b();
        }
        if (this.f != null && f()) {
            igVar.a(o);
            igVar.a(this.f);
            igVar.b();
        }
        if (this.g != null && g()) {
            igVar.a(p);
            igVar.a(this.g);
            igVar.b();
        }
        if (this.h != null && h()) {
            igVar.a(q);
            igVar.a(new ie((byte) 11, this.h.size()));
            for (String str : this.h) {
                igVar.a(str);
            }
            igVar.e();
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public hr c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public hr d(String str) {
        this.f = str;
        return this;
    }

    public boolean d() {
        return this.d != null;
    }

    public hr e(String str) {
        this.g = str;
        return this;
    }

    public boolean e() {
        return this.e != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hr)) {
            return a((hr) obj);
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

    public void i() {
        if (this.c == null) {
            throw new ih("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new ih("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.e == null) {
            throw new ih("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
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
        sb.append("topic:");
        String str4 = this.e;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.h;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
