package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class gy implements hu<gy, Object>, Serializable, Cloneable {
    private static final il g = new il("Target");
    private static final id h = new id("", (byte) 10, 1);
    private static final id i = new id("", (byte) 11, 2);
    private static final id j = new id("", (byte) 11, 3);
    private static final id k = new id("", (byte) 11, 4);
    private static final id l = new id("", (byte) 2, 5);
    private static final id m = new id("", (byte) 11, 7);
    public long a = 5;
    public String b;
    public String c = "xiaomi.com";
    public String d = "";
    public boolean e = false;
    public String f;
    private BitSet n = new BitSet(2);

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                break;
            }
            short s = h2.c;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        if (s != 4) {
                            if (s != 5) {
                                if (s == 7 && h2.b == 11) {
                                    this.f = igVar.v();
                                    igVar.i();
                                }
                            } else if (h2.b == 2) {
                                this.e = igVar.p();
                                b(true);
                                igVar.i();
                            }
                        } else if (h2.b == 11) {
                            this.d = igVar.v();
                            igVar.i();
                        }
                    } else if (h2.b == 11) {
                        this.c = igVar.v();
                        igVar.i();
                    }
                } else if (h2.b == 11) {
                    this.b = igVar.v();
                    igVar.i();
                }
            } else if (h2.b == 10) {
                this.a = igVar.t();
                a(true);
                igVar.i();
            }
            ij.a(igVar, h2.b);
            igVar.i();
        }
        igVar.g();
        if (a()) {
            g();
            return;
        }
        throw new ih("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.n.set(0, z);
    }

    public boolean a() {
        return this.n.get(0);
    }

    public boolean a(gy gyVar) {
        if (gyVar == null || this.a != gyVar.a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = gyVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.equals(gyVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = gyVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.c.equals(gyVar.c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = gyVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.d.equals(gyVar.d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = gyVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.e != gyVar.e)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = gyVar.f();
        if (f2 || f3) {
            return f2 && f3 && this.f.equals(gyVar.f);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(gy gyVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (!getClass().equals(gyVar.getClass())) {
            return getClass().getName().compareTo(gyVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gyVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a7 = hv.a(this.a, gyVar.a)) != 0) {
            return a7;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gyVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a6 = hv.a(this.b, gyVar.b)) != 0) {
            return a6;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gyVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a5 = hv.a(this.c, gyVar.c)) != 0) {
            return a5;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gyVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a4 = hv.a(this.d, gyVar.d)) != 0) {
            return a4;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gyVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a3 = hv.a(this.e, gyVar.e)) != 0) {
            return a3;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gyVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (!f() || (a2 = hv.a(this.f, gyVar.f)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        g();
        igVar.a(g);
        igVar.a(h);
        igVar.a(this.a);
        igVar.b();
        if (this.b != null) {
            igVar.a(i);
            igVar.a(this.b);
            igVar.b();
        }
        if (this.c != null && c()) {
            igVar.a(j);
            igVar.a(this.c);
            igVar.b();
        }
        if (this.d != null && d()) {
            igVar.a(k);
            igVar.a(this.d);
            igVar.b();
        }
        if (e()) {
            igVar.a(l);
            igVar.a(this.e);
            igVar.b();
        }
        if (this.f != null && f()) {
            igVar.a(m);
            igVar.a(this.f);
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public void b(boolean z) {
        this.n.set(1, z);
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
        return this.n.get(1);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gy)) {
            return a((gy) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f != null;
    }

    public void g() {
        if (this.b == null) {
            throw new ih("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.b;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.c;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.d;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.e);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
