package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class he implements hu<he, Object>, Serializable, Cloneable {
    private static final il k = new il("XmPushActionCommandResult");
    private static final id l = new id("", (byte) 12, 2);
    private static final id m = new id("", (byte) 11, 3);
    private static final id n = new id("", (byte) 11, 4);
    private static final id o = new id("", (byte) 11, 5);
    private static final id p = new id("", (byte) 10, 7);
    private static final id q = new id("", (byte) 11, 8);
    private static final id r = new id("", (byte) 11, 9);
    private static final id s = new id("", (byte) 15, 10);
    private static final id t = new id("", (byte) 11, 12);
    private static final id u = new id("", (byte) 2, 13);
    public gy a;
    public String b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;
    public List<String> h;
    public String i;
    public boolean j = true;
    private BitSet v = new BitSet(2);

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                if (f()) {
                    n();
                    return;
                }
                throw new ih("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
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
                case 7:
                    if (h2.b == 10) {
                        this.e = igVar.t();
                        a(true);
                        continue;
                        igVar.i();
                    }
                    break;
                case 8:
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
                case 12:
                    if (h2.b == 11) {
                        this.i = igVar.v();
                        continue;
                        igVar.i();
                    }
                    break;
                case 13:
                    if (h2.b == 2) {
                        this.j = igVar.p();
                        b(true);
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

    public boolean a(he heVar) {
        if (heVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = heVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.a(heVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = heVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.equals(heVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = heVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(heVar.c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = heVar.e();
        if (((e2 || e3) && (!e2 || !e3 || !this.d.equals(heVar.d))) || this.e != heVar.e) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = heVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f.equals(heVar.f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = heVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.g.equals(heVar.g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = heVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.h.equals(heVar.h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = heVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.i.equals(heVar.i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = heVar.m();
        if (m2 || m3) {
            return m2 && m3 && this.j == heVar.j;
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(he heVar) {
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
        if (!getClass().equals(heVar.getClass())) {
            return getClass().getName().compareTo(heVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(heVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a11 = hv.a(this.a, heVar.a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(heVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = hv.a(this.b, heVar.b)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(heVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = hv.a(this.c, heVar.c)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(heVar.e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (e() && (a8 = hv.a(this.d, heVar.d)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(heVar.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f() && (a7 = hv.a(this.e, heVar.e)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(heVar.g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (g() && (a6 = hv.a(this.f, heVar.f)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(heVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h() && (a5 = hv.a(this.g, heVar.g)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(heVar.j()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (j() && (a4 = hv.a(this.h, heVar.h)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(heVar.l()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (l() && (a3 = hv.a(this.i, heVar.i)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(heVar.m()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!m() || (a2 = hv.a(this.j, heVar.j)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        n();
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
        igVar.a(p);
        igVar.a(this.e);
        igVar.b();
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
        if (this.h != null && j()) {
            igVar.a(s);
            igVar.a(new ie((byte) 11, this.h.size()));
            for (String str : this.h) {
                igVar.a(str);
            }
            igVar.e();
            igVar.b();
        }
        if (this.i != null && l()) {
            igVar.a(t);
            igVar.a(this.i);
            igVar.b();
        }
        if (m()) {
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

    public boolean c() {
        return this.c != null;
    }

    public String d() {
        return this.d;
    }

    public boolean e() {
        return this.d != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof he)) {
            return a((he) obj);
        }
        return false;
    }

    public boolean f() {
        return this.v.get(0);
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

    public List<String> i() {
        return this.h;
    }

    public boolean j() {
        return this.h != null;
    }

    public String k() {
        return this.i;
    }

    public boolean l() {
        return this.i != null;
    }

    public boolean m() {
        return this.v.get(1);
    }

    public void n() {
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
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
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
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.e);
        if (g()) {
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
        if (j()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.h;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.i;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }
}
