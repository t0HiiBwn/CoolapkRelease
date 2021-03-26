package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ig implements in<ig, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f802a = new jd("XmPushActionSubscription");
    private static final iv b = new iv("", (byte) 12, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 11, 5);
    private static final iv f = new iv("", (byte) 11, 6);
    private static final iv g = new iv("", (byte) 11, 7);
    private static final iv h = new iv("", (byte) 15, 8);

    /* renamed from: a  reason: collision with other field name */
    public hr f803a;

    /* renamed from: a  reason: collision with other field name */
    public String f804a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f805a;

    /* renamed from: b  reason: collision with other field name */
    public String f806b;

    /* renamed from: c  reason: collision with other field name */
    public String f807c;

    /* renamed from: d  reason: collision with other field name */
    public String f808d;

    /* renamed from: e  reason: collision with other field name */
    public String f809e;

    /* renamed from: f  reason: collision with other field name */
    public String f810f;

    /* renamed from: a */
    public int compareTo(ig igVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(igVar.getClass())) {
            return getClass().getName().compareTo(igVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m510a()).compareTo(Boolean.valueOf(igVar.m510a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m510a() && (a9 = io.a(this.f804a, igVar.f804a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(igVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a8 = io.a(this.f803a, igVar.f803a)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(igVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a7 = io.a(this.f806b, igVar.f806b)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a6 = io.a(this.f807c, igVar.f807c)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a5 = io.a(this.f808d, igVar.f808d)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a4 = io.a(this.f809e, igVar.f809e)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a3 = io.a(this.f810f, igVar.f810f)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!h() || (a2 = io.a(this.f805a, igVar.f805a)) == 0) {
            return 0;
        }
        return a2;
    }

    public ig a(String str) {
        this.f806b = str;
        return this;
    }

    public void a() {
        if (this.f806b == null) {
            throw new iz("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f807c == null) {
            throw new iz("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f808d == null) {
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
                        this.f804a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 2:
                    if (a2.a == 12) {
                        hr hrVar = new hr();
                        this.f803a = hrVar;
                        hrVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f806b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f807c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 5:
                    if (a2.a == 11) {
                        this.f808d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 6:
                    if (a2.a == 11) {
                        this.f809e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 11) {
                        this.f810f = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 8:
                    if (a2.a == 15) {
                        iw a3 = iyVar.m548a();
                        this.f805a = new ArrayList(a3.f878a);
                        for (int i = 0; i < a3.f878a; i++) {
                            this.f805a.add(iyVar.m552a());
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
    public boolean m510a() {
        return this.f804a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m511a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean a2 = m510a();
        boolean a3 = igVar.m510a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f804a.equals(igVar.f804a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = igVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f803a.m434a(igVar.f803a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = igVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f806b.equals(igVar.f806b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = igVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f807c.equals(igVar.f807c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = igVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f808d.equals(igVar.f808d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = igVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f809e.equals(igVar.f809e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = igVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f810f.equals(igVar.f810f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = igVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f805a.equals(igVar.f805a);
        }
        return true;
    }

    public ig b(String str) {
        this.f807c = str;
        return this;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        a();
        iyVar.a(f802a);
        if (this.f804a != null && m510a()) {
            iyVar.a(a);
            iyVar.a(this.f804a);
            iyVar.b();
        }
        if (this.f803a != null && b()) {
            iyVar.a(b);
            this.f803a.b(iyVar);
            iyVar.b();
        }
        if (this.f806b != null) {
            iyVar.a(c);
            iyVar.a(this.f806b);
            iyVar.b();
        }
        if (this.f807c != null) {
            iyVar.a(d);
            iyVar.a(this.f807c);
            iyVar.b();
        }
        if (this.f808d != null) {
            iyVar.a(e);
            iyVar.a(this.f808d);
            iyVar.b();
        }
        if (this.f809e != null && f()) {
            iyVar.a(f);
            iyVar.a(this.f809e);
            iyVar.b();
        }
        if (this.f810f != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f810f);
            iyVar.b();
        }
        if (this.f805a != null && h()) {
            iyVar.a(h);
            iyVar.a(new iw((byte) 11, this.f805a.size()));
            for (String str : this.f805a) {
                iyVar.a(str);
            }
            iyVar.e();
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public boolean b() {
        return this.f803a != null;
    }

    public ig c(String str) {
        this.f808d = str;
        return this;
    }

    public boolean c() {
        return this.f806b != null;
    }

    public ig d(String str) {
        this.f809e = str;
        return this;
    }

    public boolean d() {
        return this.f807c != null;
    }

    public ig e(String str) {
        this.f810f = str;
        return this;
    }

    public boolean e() {
        return this.f808d != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m511a((ig) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f809e != null;
    }

    public boolean g() {
        return this.f810f != null;
    }

    public boolean h() {
        return this.f805a != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = false;
        if (m510a()) {
            sb.append("debug:");
            String str = this.f804a;
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
            hr hrVar = this.f803a;
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
        String str2 = this.f806b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f807c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f808d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f809e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f810f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f805a;
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
