package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class ey implements in<ey, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 3, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f422a = new jd("StatsEvent");
    private static final iv b = new iv("", (byte) 8, 2);
    private static final iv c = new iv("", (byte) 8, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 11, 5);
    private static final iv f = new iv("", (byte) 8, 6);
    private static final iv g = new iv("", (byte) 11, 7);
    private static final iv h = new iv("", (byte) 11, 8);
    private static final iv i = new iv("", (byte) 8, 9);
    private static final iv j = new iv("", (byte) 8, 10);

    /* renamed from: a  reason: collision with other field name */
    public byte f423a;

    /* renamed from: a  reason: collision with other field name */
    public int f424a;

    /* renamed from: a  reason: collision with other field name */
    public String f425a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f426a = new BitSet(6);

    /* renamed from: b  reason: collision with other field name */
    public int f427b;

    /* renamed from: b  reason: collision with other field name */
    public String f428b;

    /* renamed from: c  reason: collision with other field name */
    public int f429c;

    /* renamed from: c  reason: collision with other field name */
    public String f430c;

    /* renamed from: d  reason: collision with other field name */
    public int f431d;

    /* renamed from: d  reason: collision with other field name */
    public String f432d;

    /* renamed from: e  reason: collision with other field name */
    public int f433e;

    /* renamed from: a */
    public int compareTo(ey eyVar) {
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
        if (!getClass().equals(eyVar.getClass())) {
            return getClass().getName().compareTo(eyVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m313a()).compareTo(Boolean.valueOf(eyVar.m313a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m313a() && (a11 = io.a(this.f423a, eyVar.f423a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(eyVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = io.a(this.f424a, eyVar.f424a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(eyVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = io.a(this.f427b, eyVar.f427b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(eyVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = io.a(this.f425a, eyVar.f425a)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(eyVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = io.a(this.f428b, eyVar.f428b)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(eyVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = io.a(this.f429c, eyVar.f429c)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(eyVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = io.a(this.f430c, eyVar.f430c)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(eyVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = io.a(this.f432d, eyVar.f432d)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(eyVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = io.a(this.f431d, eyVar.f431d)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(eyVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a2 = io.a(this.f433e, eyVar.f433e)) == 0) {
            return 0;
        }
        return a2;
    }

    public ey a(byte b2) {
        this.f423a = b2;
        a(true);
        return this;
    }

    public ey a(int i2) {
        this.f424a = i2;
        b(true);
        return this;
    }

    public ey a(String str) {
        this.f425a = str;
        return this;
    }

    public void a() {
        if (this.f425a == null) {
            throw new iz("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                iyVar.f();
                if (!m313a()) {
                    throw new iz("Required field 'chid' was not found in serialized data! Struct: " + toString());
                } else if (!b()) {
                    throw new iz("Required field 'type' was not found in serialized data! Struct: " + toString());
                } else if (c()) {
                    a();
                    return;
                } else {
                    throw new iz("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
            } else {
                switch (a2.f877a) {
                    case 1:
                        if (a2.a == 3) {
                            this.f423a = iyVar.mo532a();
                            a(true);
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 2:
                        if (a2.a == 8) {
                            this.f424a = iyVar.m545a();
                            b(true);
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 3:
                        if (a2.a == 8) {
                            this.f427b = iyVar.m545a();
                            c(true);
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 4:
                        if (a2.a == 11) {
                            this.f425a = iyVar.m552a();
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 5:
                        if (a2.a == 11) {
                            this.f428b = iyVar.m552a();
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 6:
                        if (a2.a == 8) {
                            this.f429c = iyVar.m545a();
                            d(true);
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 7:
                        if (a2.a == 11) {
                            this.f430c = iyVar.m552a();
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 8:
                        if (a2.a == 11) {
                            this.f432d = iyVar.m552a();
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 9:
                        if (a2.a == 8) {
                            this.f431d = iyVar.m545a();
                            e(true);
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 10:
                        if (a2.a == 8) {
                            this.f433e = iyVar.m545a();
                            f(true);
                            continue;
                            iyVar.g();
                        }
                        break;
                }
                jb.a(iyVar, a2.a);
                iyVar.g();
            }
        }
    }

    public void a(boolean z) {
        this.f426a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m313a() {
        return this.f426a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m314a(ey eyVar) {
        if (eyVar == null || this.f423a != eyVar.f423a || this.f424a != eyVar.f424a || this.f427b != eyVar.f427b) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = eyVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f425a.equals(eyVar.f425a))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = eyVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f428b.equals(eyVar.f428b))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = eyVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f429c != eyVar.f429c)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = eyVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f430c.equals(eyVar.f430c))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = eyVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f432d.equals(eyVar.f432d))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = eyVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.f431d != eyVar.f431d)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = eyVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f433e == eyVar.f433e;
        }
        return true;
    }

    public ey b(int i2) {
        this.f427b = i2;
        c(true);
        return this;
    }

    public ey b(String str) {
        this.f428b = str;
        return this;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        a();
        iyVar.a(f422a);
        iyVar.a(a);
        iyVar.a(this.f423a);
        iyVar.b();
        iyVar.a(b);
        iyVar.mo543a(this.f424a);
        iyVar.b();
        iyVar.a(c);
        iyVar.mo543a(this.f427b);
        iyVar.b();
        if (this.f425a != null) {
            iyVar.a(d);
            iyVar.a(this.f425a);
            iyVar.b();
        }
        if (this.f428b != null && e()) {
            iyVar.a(e);
            iyVar.a(this.f428b);
            iyVar.b();
        }
        if (f()) {
            iyVar.a(f);
            iyVar.mo543a(this.f429c);
            iyVar.b();
        }
        if (this.f430c != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f430c);
            iyVar.b();
        }
        if (this.f432d != null && h()) {
            iyVar.a(h);
            iyVar.a(this.f432d);
            iyVar.b();
        }
        if (i()) {
            iyVar.a(i);
            iyVar.mo543a(this.f431d);
            iyVar.b();
        }
        if (j()) {
            iyVar.a(j);
            iyVar.mo543a(this.f433e);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public void b(boolean z) {
        this.f426a.set(1, z);
    }

    public boolean b() {
        return this.f426a.get(1);
    }

    public ey c(int i2) {
        this.f429c = i2;
        d(true);
        return this;
    }

    public ey c(String str) {
        this.f430c = str;
        return this;
    }

    public void c(boolean z) {
        this.f426a.set(2, z);
    }

    public boolean c() {
        return this.f426a.get(2);
    }

    public ey d(int i2) {
        this.f431d = i2;
        e(true);
        return this;
    }

    public ey d(String str) {
        this.f432d = str;
        return this;
    }

    public void d(boolean z) {
        this.f426a.set(3, z);
    }

    public boolean d() {
        return this.f425a != null;
    }

    public void e(boolean z) {
        this.f426a.set(4, z);
    }

    public boolean e() {
        return this.f428b != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ey)) {
            return m314a((ey) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f426a.set(5, z);
    }

    public boolean f() {
        return this.f426a.get(3);
    }

    public boolean g() {
        return this.f430c != null;
    }

    public boolean h() {
        return this.f432d != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f426a.get(4);
    }

    public boolean j() {
        return this.f426a.get(5);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f423a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f424a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f427b);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.f425a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.f428b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f429c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.f430c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.f432d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f431d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f433e);
        }
        sb.append(")");
        return sb.toString();
    }
}
