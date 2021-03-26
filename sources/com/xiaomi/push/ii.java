package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class ii implements in<ii, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f822a = new jd("XmPushActionUnRegistration");
    private static final iv b = new iv("", (byte) 12, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 11, 5);
    private static final iv f = new iv("", (byte) 11, 6);
    private static final iv g = new iv("", (byte) 11, 7);
    private static final iv h = new iv("", (byte) 11, 8);
    private static final iv i = new iv("", (byte) 11, 9);
    private static final iv j = new iv("", (byte) 11, 10);
    private static final iv k = new iv("", (byte) 2, 11);

    /* renamed from: l  reason: collision with root package name */
    private static final iv f1511l = new iv("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    public long f823a;

    /* renamed from: a  reason: collision with other field name */
    public hr f824a;

    /* renamed from: a  reason: collision with other field name */
    public String f825a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f826a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f827a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f828b;

    /* renamed from: c  reason: collision with other field name */
    public String f829c;

    /* renamed from: d  reason: collision with other field name */
    public String f830d;

    /* renamed from: e  reason: collision with other field name */
    public String f831e;

    /* renamed from: f  reason: collision with other field name */
    public String f832f;

    /* renamed from: g  reason: collision with other field name */
    public String f833g;

    /* renamed from: h  reason: collision with other field name */
    public String f834h;

    /* renamed from: i  reason: collision with other field name */
    public String f835i;

    /* renamed from: a */
    public int compareTo(ii iiVar) {
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
        int a13;
        if (!getClass().equals(iiVar.getClass())) {
            return getClass().getName().compareTo(iiVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m517a()).compareTo(Boolean.valueOf(iiVar.m517a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m517a() && (a13 = io.a(this.f825a, iiVar.f825a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iiVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a12 = io.a(this.f824a, iiVar.f824a)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iiVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a11 = io.a(this.f828b, iiVar.f828b)) != 0) {
            return a11;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a10 = io.a(this.f829c, iiVar.f829c)) != 0) {
            return a10;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a9 = io.a(this.f830d, iiVar.f830d)) != 0) {
            return a9;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a8 = io.a(this.f831e, iiVar.f831e)) != 0) {
            return a8;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a7 = io.a(this.f832f, iiVar.f832f)) != 0) {
            return a7;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a6 = io.a(this.f833g, iiVar.f833g)) != 0) {
            return a6;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a5 = io.a(this.f834h, iiVar.f834h)) != 0) {
            return a5;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iiVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a4 = io.a(this.f835i, iiVar.f835i)) != 0) {
            return a4;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(iiVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a3 = io.a(this.f827a, iiVar.f827a)) != 0) {
            return a3;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(iiVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!l() || (a2 = io.a(this.f823a, iiVar.f823a)) == 0) {
            return 0;
        }
        return a2;
    }

    public ii a(String str) {
        this.f828b = str;
        return this;
    }

    public void a() {
        if (this.f828b == null) {
            throw new iz("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f829c == null) {
            throw new iz("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                iyVar.f();
                a();
                return;
            }
            switch (a2.f877a) {
                case 1:
                    if (a2.a == 11) {
                        this.f825a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 2:
                    if (a2.a == 12) {
                        hr hrVar = new hr();
                        this.f824a = hrVar;
                        hrVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f828b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f829c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 5:
                    if (a2.a == 11) {
                        this.f830d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 6:
                    if (a2.a == 11) {
                        this.f831e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 11) {
                        this.f832f = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 8:
                    if (a2.a == 11) {
                        this.f833g = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 9:
                    if (a2.a == 11) {
                        this.f834h = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 10:
                    if (a2.a == 11) {
                        this.f835i = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 11:
                    if (a2.a == 2) {
                        this.f827a = iyVar.m556a();
                        a(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 12:
                    if (a2.a == 10) {
                        this.f823a = iyVar.m546a();
                        b(true);
                        continue;
                        iyVar.g();
                    }
                    break;
            }
            jb.a(iyVar, a2.a);
            iyVar.g();
        }
    }

    public void a(boolean z) {
        this.f826a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m517a() {
        return this.f825a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m518a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean a2 = m517a();
        boolean a3 = iiVar.m517a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f825a.equals(iiVar.f825a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iiVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f824a.m434a(iiVar.f824a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iiVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f828b.equals(iiVar.f828b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iiVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f829c.equals(iiVar.f829c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iiVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f830d.equals(iiVar.f830d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iiVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f831e.equals(iiVar.f831e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iiVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f832f.equals(iiVar.f832f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iiVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f833g.equals(iiVar.f833g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iiVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f834h.equals(iiVar.f834h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = iiVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f835i.equals(iiVar.f835i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = iiVar.k();
        if ((k2 || k3) && (!k2 || !k3 || this.f827a != iiVar.f827a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = iiVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f823a == iiVar.f823a;
        }
        return true;
    }

    public ii b(String str) {
        this.f829c = str;
        return this;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        a();
        iyVar.a(f822a);
        if (this.f825a != null && m517a()) {
            iyVar.a(a);
            iyVar.a(this.f825a);
            iyVar.b();
        }
        if (this.f824a != null && b()) {
            iyVar.a(b);
            this.f824a.b(iyVar);
            iyVar.b();
        }
        if (this.f828b != null) {
            iyVar.a(c);
            iyVar.a(this.f828b);
            iyVar.b();
        }
        if (this.f829c != null) {
            iyVar.a(d);
            iyVar.a(this.f829c);
            iyVar.b();
        }
        if (this.f830d != null && e()) {
            iyVar.a(e);
            iyVar.a(this.f830d);
            iyVar.b();
        }
        if (this.f831e != null && f()) {
            iyVar.a(f);
            iyVar.a(this.f831e);
            iyVar.b();
        }
        if (this.f832f != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f832f);
            iyVar.b();
        }
        if (this.f833g != null && h()) {
            iyVar.a(h);
            iyVar.a(this.f833g);
            iyVar.b();
        }
        if (this.f834h != null && i()) {
            iyVar.a(i);
            iyVar.a(this.f834h);
            iyVar.b();
        }
        if (this.f835i != null && j()) {
            iyVar.a(j);
            iyVar.a(this.f835i);
            iyVar.b();
        }
        if (k()) {
            iyVar.a(k);
            iyVar.a(this.f827a);
            iyVar.b();
        }
        if (l()) {
            iyVar.a(f1511l);
            iyVar.a(this.f823a);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public void b(boolean z) {
        this.f826a.set(1, z);
    }

    public boolean b() {
        return this.f824a != null;
    }

    public ii c(String str) {
        this.f830d = str;
        return this;
    }

    public boolean c() {
        return this.f828b != null;
    }

    public ii d(String str) {
        this.f832f = str;
        return this;
    }

    public boolean d() {
        return this.f829c != null;
    }

    public ii e(String str) {
        this.f833g = str;
        return this;
    }

    public boolean e() {
        return this.f830d != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m518a((ii) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f831e != null;
    }

    public boolean g() {
        return this.f832f != null;
    }

    public boolean h() {
        return this.f833g != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f834h != null;
    }

    public boolean j() {
        return this.f835i != null;
    }

    public boolean k() {
        return this.f826a.get(0);
    }

    public boolean l() {
        return this.f826a.get(1);
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = false;
        if (m517a()) {
            sb.append("debug:");
            String str = this.f825a;
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
            hr hrVar = this.f824a;
            if (hrVar == null) {
                sb.append("null");
            } else {
                sb.append(hrVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f828b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f829c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.f830d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f831e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f832f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.f833g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.f834h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f835i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f827a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f823a);
        }
        sb.append(")");
        return sb.toString();
    }
}
