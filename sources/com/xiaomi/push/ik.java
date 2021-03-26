package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ik implements in<ik, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f847a = new jd("XmPushActionUnSubscription");
    private static final iv b = new iv("", (byte) 12, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 11, 5);
    private static final iv f = new iv("", (byte) 11, 6);
    private static final iv g = new iv("", (byte) 11, 7);
    private static final iv h = new iv("", (byte) 15, 8);

    /* renamed from: a  reason: collision with other field name */
    public hr f848a;

    /* renamed from: a  reason: collision with other field name */
    public String f849a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f850a;

    /* renamed from: b  reason: collision with other field name */
    public String f851b;

    /* renamed from: c  reason: collision with other field name */
    public String f852c;

    /* renamed from: d  reason: collision with other field name */
    public String f853d;

    /* renamed from: e  reason: collision with other field name */
    public String f854e;

    /* renamed from: f  reason: collision with other field name */
    public String f855f;

    /* renamed from: a */
    public int compareTo(ik ikVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(ikVar.getClass())) {
            return getClass().getName().compareTo(ikVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m522a()).compareTo(Boolean.valueOf(ikVar.m522a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m522a() && (a9 = io.a(this.f849a, ikVar.f849a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ikVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a8 = io.a(this.f848a, ikVar.f848a)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ikVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a7 = io.a(this.f851b, ikVar.f851b)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a6 = io.a(this.f852c, ikVar.f852c)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a5 = io.a(this.f853d, ikVar.f853d)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a4 = io.a(this.f854e, ikVar.f854e)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a3 = io.a(this.f855f, ikVar.f855f)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (a2 = io.a(this.f850a, ikVar.f850a)) == 0) {
            return 0;
        }
        return a2;
    }

    public ik a(String str) {
        this.f851b = str;
        return this;
    }

    public void a() {
        if (this.f851b == null) {
            throw new iz("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f852c == null) {
            throw new iz("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f853d == null) {
            throw new iz("Required field 'topic' was not present! Struct: " + toString());
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
                        this.f849a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 2:
                    if (a2.a == 12) {
                        hr hrVar = new hr();
                        this.f848a = hrVar;
                        hrVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f851b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f852c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 5:
                    if (a2.a == 11) {
                        this.f853d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 6:
                    if (a2.a == 11) {
                        this.f854e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 11) {
                        this.f855f = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 8:
                    if (a2.a == 15) {
                        iw a3 = iyVar.m548a();
                        this.f850a = new ArrayList(a3.f878a);
                        for (int i = 0; i < a3.f878a; i++) {
                            this.f850a.add(iyVar.m552a());
                        }
                        iyVar.i();
                        continue;
                        iyVar.g();
                    }
                    break;
            }
            jb.a(iyVar, a2.a);
            iyVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m522a() {
        return this.f849a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m523a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean a2 = m522a();
        boolean a3 = ikVar.m522a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f849a.equals(ikVar.f849a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ikVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f848a.m434a(ikVar.f848a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ikVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f851b.equals(ikVar.f851b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ikVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f852c.equals(ikVar.f852c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ikVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f853d.equals(ikVar.f853d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ikVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f854e.equals(ikVar.f854e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ikVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f855f.equals(ikVar.f855f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ikVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f850a.equals(ikVar.f850a);
        }
        return true;
    }

    public ik b(String str) {
        this.f852c = str;
        return this;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        a();
        iyVar.a(f847a);
        if (this.f849a != null && m522a()) {
            iyVar.a(a);
            iyVar.a(this.f849a);
            iyVar.b();
        }
        if (this.f848a != null && b()) {
            iyVar.a(b);
            this.f848a.b(iyVar);
            iyVar.b();
        }
        if (this.f851b != null) {
            iyVar.a(c);
            iyVar.a(this.f851b);
            iyVar.b();
        }
        if (this.f852c != null) {
            iyVar.a(d);
            iyVar.a(this.f852c);
            iyVar.b();
        }
        if (this.f853d != null) {
            iyVar.a(e);
            iyVar.a(this.f853d);
            iyVar.b();
        }
        if (this.f854e != null && f()) {
            iyVar.a(f);
            iyVar.a(this.f854e);
            iyVar.b();
        }
        if (this.f855f != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f855f);
            iyVar.b();
        }
        if (this.f850a != null && h()) {
            iyVar.a(h);
            iyVar.a(new iw((byte) 11, this.f850a.size()));
            for (String str : this.f850a) {
                iyVar.a(str);
            }
            iyVar.e();
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public boolean b() {
        return this.f848a != null;
    }

    public ik c(String str) {
        this.f853d = str;
        return this;
    }

    public boolean c() {
        return this.f851b != null;
    }

    public ik d(String str) {
        this.f854e = str;
        return this;
    }

    public boolean d() {
        return this.f852c != null;
    }

    public ik e(String str) {
        this.f855f = str;
        return this;
    }

    public boolean e() {
        return this.f853d != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m523a((ik) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f854e != null;
    }

    public boolean g() {
        return this.f855f != null;
    }

    public boolean h() {
        return this.f850a != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = false;
        if (m522a()) {
            sb.append("debug:");
            String str = this.f849a;
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
            hr hrVar = this.f848a;
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
        String str2 = this.f851b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f852c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f853d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f854e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f855f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f850a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
