package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class gm implements hu<gm, Object>, Serializable, Cloneable {
    private static final il l = new il("ClientUploadDataItem");
    private static final id m = new id("", (byte) 11, 1);
    private static final id n = new id("", (byte) 11, 2);
    private static final id o = new id("", (byte) 11, 3);
    private static final id p = new id("", (byte) 10, 4);
    private static final id q = new id("", (byte) 10, 5);
    private static final id r = new id("", (byte) 2, 6);
    private static final id s = new id("", (byte) 11, 7);
    private static final id t = new id("", (byte) 11, 8);
    private static final id u = new id("", (byte) 11, 9);
    private static final id v = new id("", (byte) 13, 10);
    private static final id w = new id("", (byte) 11, 11);
    public String a;
    public String b;
    public String c;
    public long d;
    public long e;
    public boolean f;
    public String g;
    public String h;
    public String i;
    public Map<String, String> j;
    public String k;
    private BitSet x = new BitSet(3);

    public gm a(long j2) {
        this.d = j2;
        a(true);
        return this;
    }

    public gm a(String str) {
        this.a = str;
        return this;
    }

    public String a() {
        return this.a;
    }

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                r();
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
                    if (h2.b == 11) {
                        this.b = igVar.v();
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
                    if (h2.b == 10) {
                        this.d = igVar.t();
                        a(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 5:
                    if (h2.b == 10) {
                        this.e = igVar.t();
                        b(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 6:
                    if (h2.b == 2) {
                        this.f = igVar.p();
                        d(true);
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
                    if (h2.b == 11) {
                        this.h = igVar.v();
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
                    if (h2.b == 13) {
                        Cif j2 = igVar.j();
                        this.j = new HashMap(j2.c * 2);
                        for (int i2 = 0; i2 < j2.c; i2++) {
                            this.j.put(igVar.v(), igVar.v());
                        }
                        igVar.k();
                        continue;
                        igVar.i();
                    }
                    break;
                case 11:
                    if (h2.b == 11) {
                        this.k = igVar.v();
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
        this.x.set(0, z);
    }

    public boolean a(gm gmVar) {
        if (gmVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = gmVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.a.equals(gmVar.a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = gmVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.b.equals(gmVar.b))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = gmVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.c.equals(gmVar.c))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = gmVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.d != gmVar.d)) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = gmVar.h();
        if ((h2 || h3) && (!h2 || !h3 || this.e != gmVar.e)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = gmVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.f != gmVar.f)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = gmVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.g.equals(gmVar.g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = gmVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.h.equals(gmVar.h))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = gmVar.n();
        if ((n2 || n3) && (!n2 || !n3 || !this.i.equals(gmVar.i))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = gmVar.o();
        if ((o2 || o3) && (!o2 || !o3 || !this.j.equals(gmVar.j))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = gmVar.q();
        if (q2 || q3) {
            return q2 && q3 && this.k.equals(gmVar.k);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(gm gmVar) {
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
        if (!getClass().equals(gmVar.getClass())) {
            return getClass().getName().compareTo(gmVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gmVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b() && (a12 = hv.a(this.a, gmVar.a)) != 0) {
            return a12;
        }
        int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gmVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a11 = hv.a(this.b, gmVar.b)) != 0) {
            return a11;
        }
        int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gmVar.e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (e() && (a10 = hv.a(this.c, gmVar.c)) != 0) {
            return a10;
        }
        int compareTo4 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gmVar.f()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (f() && (a9 = hv.a(this.d, gmVar.d)) != 0) {
            return a9;
        }
        int compareTo5 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gmVar.h()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (h() && (a8 = hv.a(this.e, gmVar.e)) != 0) {
            return a8;
        }
        int compareTo6 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gmVar.i()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (i() && (a7 = hv.a(this.f, gmVar.f)) != 0) {
            return a7;
        }
        int compareTo7 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gmVar.j()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (j() && (a6 = hv.a(this.g, gmVar.g)) != 0) {
            return a6;
        }
        int compareTo8 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(gmVar.l()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (l() && (a5 = hv.a(this.h, gmVar.h)) != 0) {
            return a5;
        }
        int compareTo9 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gmVar.n()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (n() && (a4 = hv.a(this.i, gmVar.i)) != 0) {
            return a4;
        }
        int compareTo10 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(gmVar.o()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (o() && (a3 = hv.a(this.j, gmVar.j)) != 0) {
            return a3;
        }
        int compareTo11 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(gmVar.q()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!q() || (a2 = hv.a(this.k, gmVar.k)) == 0) {
            return 0;
        }
        return a2;
    }

    public gm b(long j2) {
        this.e = j2;
        b(true);
        return this;
    }

    public gm b(String str) {
        this.b = str;
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        r();
        igVar.a(l);
        if (this.a != null && b()) {
            igVar.a(m);
            igVar.a(this.a);
            igVar.b();
        }
        if (this.b != null && c()) {
            igVar.a(n);
            igVar.a(this.b);
            igVar.b();
        }
        if (this.c != null && e()) {
            igVar.a(o);
            igVar.a(this.c);
            igVar.b();
        }
        if (f()) {
            igVar.a(p);
            igVar.a(this.d);
            igVar.b();
        }
        if (h()) {
            igVar.a(q);
            igVar.a(this.e);
            igVar.b();
        }
        if (i()) {
            igVar.a(r);
            igVar.a(this.f);
            igVar.b();
        }
        if (this.g != null && j()) {
            igVar.a(s);
            igVar.a(this.g);
            igVar.b();
        }
        if (this.h != null && l()) {
            igVar.a(t);
            igVar.a(this.h);
            igVar.b();
        }
        if (this.i != null && n()) {
            igVar.a(u);
            igVar.a(this.i);
            igVar.b();
        }
        if (this.j != null && o()) {
            igVar.a(v);
            igVar.a(new Cif((byte) 11, (byte) 11, this.j.size()));
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                igVar.a(entry.getKey());
                igVar.a(entry.getValue());
            }
            igVar.d();
            igVar.b();
        }
        if (this.k != null && q()) {
            igVar.a(w);
            igVar.a(this.k);
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public void b(boolean z) {
        this.x.set(1, z);
    }

    public boolean b() {
        return this.a != null;
    }

    public gm c(String str) {
        this.c = str;
        return this;
    }

    public gm c(boolean z) {
        this.f = z;
        d(true);
        return this;
    }

    public boolean c() {
        return this.b != null;
    }

    public gm d(String str) {
        this.g = str;
        return this;
    }

    public String d() {
        return this.c;
    }

    public void d(boolean z) {
        this.x.set(2, z);
    }

    public gm e(String str) {
        this.h = str;
        return this;
    }

    public boolean e() {
        return this.c != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gm)) {
            return a((gm) obj);
        }
        return false;
    }

    public gm f(String str) {
        this.i = str;
        return this;
    }

    public boolean f() {
        return this.x.get(0);
    }

    public long g() {
        return this.e;
    }

    public gm g(String str) {
        this.k = str;
        return this;
    }

    public boolean h() {
        return this.x.get(1);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.x.get(2);
    }

    public boolean j() {
        return this.g != null;
    }

    public String k() {
        return this.h;
    }

    public boolean l() {
        return this.h != null;
    }

    public String m() {
        return this.i;
    }

    public boolean n() {
        return this.i != null;
    }

    public boolean o() {
        return this.j != null;
    }

    public String p() {
        return this.k;
    }

    public boolean q() {
        return this.k != null;
    }

    public void r() {
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = false;
        if (b()) {
            sb.append("channel:");
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
        if (c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.d);
            z = false;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.e);
            z = false;
        }
        if (i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f);
            z = false;
        }
        if (j()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.g;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (l()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.h;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (n()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.i;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (o()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.j;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        } else {
            z2 = z;
        }
        if (q()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            String str7 = this.k;
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
