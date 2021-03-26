package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

public class hf implements hu<hf, Object>, Serializable, Cloneable {
    private static final il i = new il("XmPushActionContainer");
    private static final id j = new id("", (byte) 8, 1);
    private static final id k = new id("", (byte) 2, 2);
    private static final id l = new id("", (byte) 2, 3);
    private static final id m = new id("", (byte) 11, 4);
    private static final id n = new id("", (byte) 11, 5);
    private static final id o = new id("", (byte) 11, 6);
    private static final id p = new id("", (byte) 12, 7);
    private static final id q = new id("", (byte) 12, 8);
    public gi a;
    public boolean b = true;
    public boolean c = true;
    public ByteBuffer d;
    public String e;
    public String f;
    public gy g;
    public gv h;
    private BitSet r = new BitSet(2);

    public gi a() {
        return this.a;
    }

    public hf a(gi giVar) {
        this.a = giVar;
        return this;
    }

    public hf a(gv gvVar) {
        this.h = gvVar;
        return this;
    }

    public hf a(gy gyVar) {
        this.g = gyVar;
        return this;
    }

    public hf a(String str) {
        this.e = str;
        return this;
    }

    public hf a(ByteBuffer byteBuffer) {
        this.d = byteBuffer;
        return this;
    }

    public hf a(boolean z) {
        this.b = z;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h2 = igVar.h();
            if (h2.b == 0) {
                igVar.g();
                if (!d()) {
                    throw new ih("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (e()) {
                    o();
                    return;
                } else {
                    throw new ih("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            } else {
                switch (h2.c) {
                    case 1:
                        if (h2.b == 8) {
                            this.a = gi.a(igVar.s());
                            continue;
                            igVar.i();
                        }
                        break;
                    case 2:
                        if (h2.b == 2) {
                            this.b = igVar.p();
                            b(true);
                            continue;
                            igVar.i();
                        }
                        break;
                    case 3:
                        if (h2.b == 2) {
                            this.c = igVar.p();
                            d(true);
                            continue;
                            igVar.i();
                        }
                        break;
                    case 4:
                        if (h2.b == 11) {
                            this.d = igVar.w();
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
                        if (h2.b == 12) {
                            gy gyVar = new gy();
                            this.g = gyVar;
                            gyVar.a(igVar);
                            continue;
                            igVar.i();
                        }
                        break;
                    case 8:
                        if (h2.b == 12) {
                            gv gvVar = new gv();
                            this.h = gvVar;
                            gvVar.a(igVar);
                            continue;
                            igVar.i();
                        }
                        break;
                }
                ij.a(igVar, h2.b);
                igVar.i();
            }
        }
    }

    public boolean a(hf hfVar) {
        if (hfVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hfVar.b();
        if (((b2 || b3) && (!b2 || !b3 || !this.a.equals(hfVar.a))) || this.b != hfVar.b || this.c != hfVar.c) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hfVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.d.equals(hfVar.d))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hfVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.e.equals(hfVar.e))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hfVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f.equals(hfVar.f))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hfVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.g.a(hfVar.g))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hfVar.n();
        if (n2 || n3) {
            return n2 && n3 && this.h.a(hfVar.h);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(hf hfVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(hfVar.getClass())) {
            return getClass().getName().compareTo(hfVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hfVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b() && (a9 = hv.a(this.a, hfVar.a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hfVar.d()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (d() && (a8 = hv.a(this.b, hfVar.b)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hfVar.e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (e() && (a7 = hv.a(this.c, hfVar.c)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hfVar.g()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (g() && (a6 = hv.a(this.d, hfVar.d)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hfVar.i()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (i() && (a5 = hv.a(this.e, hfVar.e)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hfVar.k()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (k() && (a4 = hv.a(this.f, hfVar.f)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hfVar.l()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (l() && (a3 = hv.a(this.g, hfVar.g)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hfVar.n()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!n() || (a2 = hv.a(this.h, hfVar.h)) == 0) {
            return 0;
        }
        return a2;
    }

    public hf b(String str) {
        this.f = str;
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        o();
        igVar.a(i);
        if (this.a != null) {
            igVar.a(j);
            igVar.a(this.a.a());
            igVar.b();
        }
        igVar.a(k);
        igVar.a(this.b);
        igVar.b();
        igVar.a(l);
        igVar.a(this.c);
        igVar.b();
        if (this.d != null) {
            igVar.a(m);
            igVar.a(this.d);
            igVar.b();
        }
        if (this.e != null && i()) {
            igVar.a(n);
            igVar.a(this.e);
            igVar.b();
        }
        if (this.f != null && k()) {
            igVar.a(o);
            igVar.a(this.f);
            igVar.b();
        }
        if (this.g != null) {
            igVar.a(p);
            this.g.b(igVar);
            igVar.b();
        }
        if (this.h != null && n()) {
            igVar.a(q);
            this.h.b(igVar);
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public void b(boolean z) {
        this.r.set(0, z);
    }

    public boolean b() {
        return this.a != null;
    }

    public hf c(boolean z) {
        this.c = z;
        d(true);
        return this;
    }

    public boolean c() {
        return this.b;
    }

    public void d(boolean z) {
        this.r.set(1, z);
    }

    public boolean d() {
        return this.r.get(0);
    }

    public boolean e() {
        return this.r.get(1);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hf)) {
            return a((hf) obj);
        }
        return false;
    }

    public byte[] f() {
        a(hv.c(this.d));
        return this.d.array();
    }

    public boolean g() {
        return this.d != null;
    }

    public String h() {
        return this.e;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.e != null;
    }

    public String j() {
        return this.f;
    }

    public boolean k() {
        return this.f != null;
    }

    public boolean l() {
        return this.g != null;
    }

    public gv m() {
        return this.h;
    }

    public boolean n() {
        return this.h != null;
    }

    public void o() {
        if (this.a == null) {
            throw new ih("Required field 'action' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new ih("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.g == null) {
            throw new ih("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        gi giVar = this.a;
        if (giVar == null) {
            sb.append("null");
        } else {
            sb.append(giVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.c);
        sb.append(", ");
        sb.append("pushAction:");
        ByteBuffer byteBuffer = this.d;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            hv.a(byteBuffer, sb);
        }
        if (i()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.e;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        gy gyVar = this.g;
        if (gyVar == null) {
            sb.append("null");
        } else {
            sb.append(gyVar);
        }
        if (n()) {
            sb.append(", ");
            sb.append("metaInfo:");
            gv gvVar = this.h;
            if (gvVar == null) {
                sb.append("null");
            } else {
                sb.append(gvVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
