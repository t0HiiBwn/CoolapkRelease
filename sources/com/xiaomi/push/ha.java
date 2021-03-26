package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class ha implements hu<ha, Object>, Serializable, Cloneable {
    private static final il k = new il("XmPushActionAckNotification");
    private static final id l = new id("", (byte) 11, 1);
    private static final id m = new id("", (byte) 12, 2);
    private static final id n = new id("", (byte) 11, 3);
    private static final id o = new id("", (byte) 11, 4);
    private static final id p = new id("", (byte) 11, 5);
    private static final id q = new id("", (byte) 10, 7);
    private static final id r = new id("", (byte) 11, 8);
    private static final id s = new id("", (byte) 13, 9);
    private static final id t = new id("", (byte) 11, 10);
    private static final id u = new id("", (byte) 11, 11);
    public String a;
    public gy b;
    public String c;
    public String d;
    public String e;
    public long f = 0;
    public String g;
    public Map<String, String> h;
    public String i;
    public String j;
    private BitSet v = new BitSet(1);

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                m();
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
                case 7:
                    if (h2.b == 10) {
                        this.f = igVar.t();
                        a(true);
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
                case 10:
                    if (h2.b == 11) {
                        this.i = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 11:
                    if (h2.b == 11) {
                        this.j = igVar.v();
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
        this.v.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(ha haVar) {
        if (haVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = haVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(haVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = haVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(haVar.b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = haVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.c.equals(haVar.c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = haVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.d.equals(haVar.d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = haVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.e.equals(haVar.e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = haVar.g();
        if ((g2 || g3) && (!g2 || !g3 || this.f != haVar.f)) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = haVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.g.equals(haVar.g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = haVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.h.equals(haVar.h))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = haVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.i.equals(haVar.i))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = haVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.j.equals(haVar.j);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(ha haVar) {
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
        if (!getClass().equals(haVar.getClass())) {
            return getClass().getName().compareTo(haVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(haVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a11 = hv.a(this.a, haVar.a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(haVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = hv.a(this.b, haVar.b)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(haVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d() && (a9 = hv.a(this.c, haVar.c)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(haVar.e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (e() && (a8 = hv.a(this.d, haVar.d)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(haVar.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f() && (a7 = hv.a(this.e, haVar.e)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(haVar.g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (g() && (a6 = hv.a(this.f, haVar.f)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(haVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h() && (a5 = hv.a(this.g, haVar.g)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(haVar.j()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (j() && (a4 = hv.a(this.h, haVar.h)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(haVar.k()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (k() && (a3 = hv.a(this.i, haVar.i)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(haVar.l()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!l() || (a2 = hv.a(this.j, haVar.j)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        m();
        igVar.a(k);
        if (this.a != null && a()) {
            igVar.a(l);
            igVar.a(this.a);
            igVar.b();
        }
        if (this.b != null && b()) {
            igVar.a(m);
            this.b.b(igVar);
            igVar.b();
        }
        if (this.c != null) {
            igVar.a(n);
            igVar.a(this.c);
            igVar.b();
        }
        if (this.d != null && e()) {
            igVar.a(o);
            igVar.a(this.d);
            igVar.b();
        }
        if (this.e != null && f()) {
            igVar.a(p);
            igVar.a(this.e);
            igVar.b();
        }
        if (g()) {
            igVar.a(q);
            igVar.a(this.f);
            igVar.b();
        }
        if (this.g != null && h()) {
            igVar.a(r);
            igVar.a(this.g);
            igVar.b();
        }
        if (this.h != null && j()) {
            igVar.a(s);
            igVar.a(new Cif((byte) 11, (byte) 11, this.h.size()));
            for (Map.Entry<String, String> entry : this.h.entrySet()) {
                igVar.a(entry.getKey());
                igVar.a(entry.getValue());
            }
            igVar.d();
            igVar.b();
        }
        if (this.i != null && k()) {
            igVar.a(t);
            igVar.a(this.i);
            igVar.b();
        }
        if (this.j != null && l()) {
            igVar.a(u);
            igVar.a(this.j);
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.c;
    }

    public boolean d() {
        return this.c != null;
    }

    public boolean e() {
        return this.d != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ha)) {
            return a((ha) obj);
        }
        return false;
    }

    public boolean f() {
        return this.e != null;
    }

    public boolean g() {
        return this.v.get(0);
    }

    public boolean h() {
        return this.g != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public Map<String, String> i() {
        return this.h;
    }

    public boolean j() {
        return this.h != null;
    }

    public boolean k() {
        return this.i != null;
    }

    public boolean l() {
        return this.j != null;
    }

    public void m() {
        if (this.c == null) {
            throw new ih("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
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
        if (e()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.d;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f);
        }
        if (h()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.h;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.i;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.j;
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
