package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class hl implements hu<hl, Object>, Serializable, Cloneable {
    private static final il h = new il("XmPushActionSendFeedbackResult");
    private static final id i = new id("", (byte) 11, 1);
    private static final id j = new id("", (byte) 12, 2);
    private static final id k = new id("", (byte) 11, 3);
    private static final id l = new id("", (byte) 11, 4);
    private static final id m = new id("", (byte) 10, 6);
    private static final id n = new id("", (byte) 11, 7);
    private static final id o = new id("", (byte) 11, 8);
    public String a;
    public gy b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;
    private BitSet p = new BitSet(1);

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                if (e()) {
                    h();
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
            }
            ij.a(igVar, h2.b);
            igVar.i();
        }
    }

    public void a(boolean z) {
        this.p.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hl hlVar) {
        if (hlVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = hlVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(hlVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hlVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.a(hlVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hlVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(hlVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hlVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.d.equals(hlVar.d))) || this.e != hlVar.e) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hlVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f.equals(hlVar.f))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hlVar.g();
        if (g2 || g3) {
            return g2 && g3 && this.g.equals(hlVar.g);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(hl hlVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(hlVar.getClass())) {
            return getClass().getName().compareTo(hlVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hlVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a8 = hv.a(this.a, hlVar.a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hlVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a7 = hv.a(this.b, hlVar.b)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hlVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a6 = hv.a(this.c, hlVar.c)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hlVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a5 = hv.a(this.d, hlVar.d)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hlVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a4 = hv.a(this.e, hlVar.e)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hlVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a3 = hv.a(this.f, hlVar.f)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hlVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!g() || (a2 = hv.a(this.g, hlVar.g)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        h();
        igVar.a(h);
        if (this.a != null && a()) {
            igVar.a(i);
            igVar.a(this.a);
            igVar.b();
        }
        if (this.b != null && b()) {
            igVar.a(j);
            this.b.b(igVar);
            igVar.b();
        }
        if (this.c != null) {
            igVar.a(k);
            igVar.a(this.c);
            igVar.b();
        }
        if (this.d != null) {
            igVar.a(l);
            igVar.a(this.d);
            igVar.b();
        }
        igVar.a(m);
        igVar.a(this.e);
        igVar.b();
        if (this.f != null && f()) {
            igVar.a(n);
            igVar.a(this.f);
            igVar.b();
        }
        if (this.g != null && g()) {
            igVar.a(o);
            igVar.a(this.g);
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
        return this.p.get(0);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hl)) {
            return a((hl) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f != null;
    }

    public boolean g() {
        return this.g != null;
    }

    public void h() {
        if (this.c == null) {
            throw new ih("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new ih("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
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
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
