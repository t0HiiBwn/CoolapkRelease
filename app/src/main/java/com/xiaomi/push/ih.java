package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class ih implements in<ih, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f811a = new jd("XmPushActionSubscriptionResult");
    private static final iv b = new iv("", (byte) 12, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 10, 6);
    private static final iv f = new iv("", (byte) 11, 7);
    private static final iv g = new iv("", (byte) 11, 8);
    private static final iv h = new iv("", (byte) 11, 9);
    private static final iv i = new iv("", (byte) 11, 10);

    /* renamed from: a  reason: collision with other field name */
    public long f812a;

    /* renamed from: a  reason: collision with other field name */
    public hr f813a;

    /* renamed from: a  reason: collision with other field name */
    public String f814a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f815a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f816b;

    /* renamed from: c  reason: collision with other field name */
    public String f817c;

    /* renamed from: d  reason: collision with other field name */
    public String f818d;

    /* renamed from: e  reason: collision with other field name */
    public String f819e;

    /* renamed from: f  reason: collision with other field name */
    public String f820f;

    /* renamed from: g  reason: collision with other field name */
    public String f821g;

    /* renamed from: a */
    public int compareTo(ih ihVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (!getClass().equals(ihVar.getClass())) {
            return getClass().getName().compareTo(ihVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m513a()).compareTo(Boolean.valueOf(ihVar.m513a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m513a() && (a10 = io.a(this.f814a, ihVar.f814a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(m515b()).compareTo(Boolean.valueOf(ihVar.m515b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m515b() && (a9 = io.a(this.f813a, ihVar.f813a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(m516c()).compareTo(Boolean.valueOf(ihVar.m516c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m516c() && (a8 = io.a(this.f816b, ihVar.f816b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ihVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = io.a(this.f817c, ihVar.f817c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ihVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = io.a(this.f812a, ihVar.f812a)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ihVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = io.a(this.f818d, ihVar.f818d)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ihVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a4 = io.a(this.f819e, ihVar.f819e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ihVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a3 = io.a(this.f820f, ihVar.f820f)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ihVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (a2 = io.a(this.f821g, ihVar.f821g)) == 0) {
            return 0;
        }
        return a2;
    }

    public String a() {
        return this.f816b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m512a() {
        if (this.f816b == null) {
            throw new iz("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                iyVar.f();
                m512a();
                return;
            }
            switch (a2.f877a) {
                case 1:
                    if (a2.a == 11) {
                        this.f814a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 2:
                    if (a2.a == 12) {
                        hr hrVar = new hr();
                        this.f813a = hrVar;
                        hrVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f816b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f817c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 6:
                    if (a2.a == 10) {
                        this.f812a = iyVar.m546a();
                        a(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 11) {
                        this.f818d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 8:
                    if (a2.a == 11) {
                        this.f819e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 9:
                    if (a2.a == 11) {
                        this.f820f = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 10:
                    if (a2.a == 11) {
                        this.f821g = iyVar.m552a();
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
        this.f815a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m513a() {
        return this.f814a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m514a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean a2 = m513a();
        boolean a3 = ihVar.m513a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f814a.equals(ihVar.f814a))) {
            return false;
        }
        boolean b2 = m515b();
        boolean b3 = ihVar.m515b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f813a.m434a(ihVar.f813a))) {
            return false;
        }
        boolean c2 = m516c();
        boolean c3 = ihVar.m516c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f816b.equals(ihVar.f816b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ihVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f817c.equals(ihVar.f817c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ihVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f812a != ihVar.f812a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ihVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f818d.equals(ihVar.f818d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ihVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f819e.equals(ihVar.f819e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ihVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f820f.equals(ihVar.f820f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ihVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f821g.equals(ihVar.f821g);
        }
        return true;
    }

    public String b() {
        return this.f819e;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m512a();
        iyVar.a(f811a);
        if (this.f814a != null && m513a()) {
            iyVar.a(a);
            iyVar.a(this.f814a);
            iyVar.b();
        }
        if (this.f813a != null && m515b()) {
            iyVar.a(b);
            this.f813a.b(iyVar);
            iyVar.b();
        }
        if (this.f816b != null) {
            iyVar.a(c);
            iyVar.a(this.f816b);
            iyVar.b();
        }
        if (this.f817c != null && d()) {
            iyVar.a(d);
            iyVar.a(this.f817c);
            iyVar.b();
        }
        if (e()) {
            iyVar.a(e);
            iyVar.a(this.f812a);
            iyVar.b();
        }
        if (this.f818d != null && f()) {
            iyVar.a(f);
            iyVar.a(this.f818d);
            iyVar.b();
        }
        if (this.f819e != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f819e);
            iyVar.b();
        }
        if (this.f820f != null && h()) {
            iyVar.a(h);
            iyVar.a(this.f820f);
            iyVar.b();
        }
        if (this.f821g != null && i()) {
            iyVar.a(i);
            iyVar.a(this.f821g);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m515b() {
        return this.f813a != null;
    }

    public String c() {
        return this.f821g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m516c() {
        return this.f816b != null;
    }

    public boolean d() {
        return this.f817c != null;
    }

    public boolean e() {
        return this.f815a.get(0);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m514a((ih) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f818d != null;
    }

    public boolean g() {
        return this.f819e != null;
    }

    public boolean h() {
        return this.f820f != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f821g != null;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = false;
        if (m513a()) {
            sb.append("debug:");
            String str = this.f814a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m515b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hr hrVar = this.f813a;
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
        String str2 = this.f816b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f817c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f812a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f818d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f819e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f820f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f821g;
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
