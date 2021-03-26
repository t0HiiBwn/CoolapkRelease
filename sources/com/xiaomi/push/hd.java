package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class hd implements hu<hd, Object>, Serializable, Cloneable {
    private static final il k = new il("XmPushActionCommand");
    private static final id l = new id("", (byte) 12, 2);
    private static final id m = new id("", (byte) 11, 3);
    private static final id n = new id("", (byte) 11, 4);
    private static final id o = new id("", (byte) 11, 5);
    private static final id p = new id("", (byte) 15, 6);
    private static final id q = new id("", (byte) 11, 7);
    private static final id r = new id("", (byte) 11, 9);
    private static final id s = new id("", (byte) 2, 10);
    private static final id t = new id("", (byte) 2, 11);
    private static final id u = new id("", (byte) 10, 12);
    public gy a;
    public String b;
    public String c;
    public String d;
    public List<String> e;
    public String f;
    public String g;
    public boolean h = false;
    public boolean i = true;
    public long j;
    private BitSet v = new BitSet(3);

    public hd a(String str) {
        this.b = str;
        return this;
    }

    public hd a(List<String> list) {
        this.e = list;
        return this;
    }

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
                case 2:
                    if (h2.b == 12) {
                        gy gyVar = new gy();
                        this.a = gyVar;
                        gyVar.a(igVar);
                        continue;
                        igVar.i();
                    }
                    break;
                case 3:
                    if (h2.b == 11) {
                        this.b = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 4:
                    if (h2.b == 11) {
                        this.c = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 5:
                    if (h2.b == 11) {
                        this.d = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 6:
                    if (h2.b == 15) {
                        ie l2 = igVar.l();
                        this.e = new ArrayList(l2.b);
                        for (int i2 = 0; i2 < l2.b; i2++) {
                            this.e.add(igVar.v());
                        }
                        igVar.m();
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
                case 9:
                    if (h2.b == 11) {
                        this.g = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 10:
                    if (h2.b == 2) {
                        this.h = igVar.p();
                        a(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 11:
                    if (h2.b == 2) {
                        this.i = igVar.p();
                        b(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 12:
                    if (h2.b == 10) {
                        this.j = igVar.t();
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
        this.v.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hd hdVar) {
        if (hdVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = hdVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.a(hdVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hdVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.equals(hdVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hdVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(hdVar.c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hdVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.d.equals(hdVar.d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hdVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.e.equals(hdVar.e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hdVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f.equals(hdVar.f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hdVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.g.equals(hdVar.g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hdVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.h != hdVar.h)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hdVar.j();
        if ((j2 || j3) && (!j2 || !j3 || this.i != hdVar.i)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hdVar.k();
        if (k2 || k3) {
            return k2 && k3 && this.j == hdVar.j;
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(hd hdVar) {
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
        if (!getClass().equals(hdVar.getClass())) {
            return getClass().getName().compareTo(hdVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hdVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a11 = hv.a(this.a, hdVar.a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hdVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = hv.a(this.b, hdVar.b)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hdVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = hv.a(this.c, hdVar.c)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hdVar.e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (e() && (a8 = hv.a(this.d, hdVar.d)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hdVar.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f() && (a7 = hv.a(this.e, hdVar.e)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hdVar.g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (g() && (a6 = hv.a(this.f, hdVar.f)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hdVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h() && (a5 = hv.a(this.g, hdVar.g)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hdVar.i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (i() && (a4 = hv.a(this.h, hdVar.h)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hdVar.j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (j() && (a3 = hv.a(this.i, hdVar.i)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hdVar.k()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!k() || (a2 = hv.a(this.j, hdVar.j)) == 0) {
            return 0;
        }
        return a2;
    }

    public hd b(String str) {
        this.c = str;
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        l();
        igVar.a(k);
        if (this.a != null && a()) {
            igVar.a(l);
            this.a.b(igVar);
            igVar.b();
        }
        if (this.b != null) {
            igVar.a(m);
            igVar.a(this.b);
            igVar.b();
        }
        if (this.c != null) {
            igVar.a(n);
            igVar.a(this.c);
            igVar.b();
        }
        if (this.d != null) {
            igVar.a(o);
            igVar.a(this.d);
            igVar.b();
        }
        if (this.e != null && f()) {
            igVar.a(p);
            igVar.a(new ie((byte) 11, this.e.size()));
            for (String str : this.e) {
                igVar.a(str);
            }
            igVar.e();
            igVar.b();
        }
        if (this.f != null && g()) {
            igVar.a(q);
            igVar.a(this.f);
            igVar.b();
        }
        if (this.g != null && h()) {
            igVar.a(r);
            igVar.a(this.g);
            igVar.b();
        }
        if (i()) {
            igVar.a(s);
            igVar.a(this.h);
            igVar.b();
        }
        if (j()) {
            igVar.a(t);
            igVar.a(this.i);
            igVar.b();
        }
        if (k()) {
            igVar.a(u);
            igVar.a(this.j);
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public void b(boolean z) {
        this.v.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public hd c(String str) {
        this.d = str;
        return this;
    }

    public void c(boolean z) {
        this.v.set(2, z);
    }

    public boolean c() {
        return this.c != null;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.e.add(str);
    }

    public hd e(String str) {
        this.f = str;
        return this;
    }

    public boolean e() {
        return this.d != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hd)) {
            return a((hd) obj);
        }
        return false;
    }

    public hd f(String str) {
        this.g = str;
        return this;
    }

    public boolean f() {
        return this.e != null;
    }

    public boolean g() {
        return this.f != null;
    }

    public boolean h() {
        return this.g != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.v.get(0);
    }

    public boolean j() {
        return this.v.get(1);
    }

    public boolean k() {
        return this.v.get(2);
    }

    public void l() {
        if (this.b == null) {
            throw new ih("Required field 'id' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new ih("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new ih("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (a()) {
            sb.append("target:");
            gy gyVar = this.a;
            if (gyVar == null) {
                sb.append("null");
            } else {
                sb.append(gyVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.b;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (f()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.e;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.h);
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.i);
        }
        if (k()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }
}
