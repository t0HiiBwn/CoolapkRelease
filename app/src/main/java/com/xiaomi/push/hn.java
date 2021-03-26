package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class hn implements in<hn, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 8, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f577a = new jd("OnlineConfigItem");
    private static final iv b = new iv("", (byte) 8, 2);
    private static final iv c = new iv("", (byte) 2, 3);
    private static final iv d = new iv("", (byte) 8, 4);
    private static final iv e = new iv("", (byte) 10, 5);
    private static final iv f = new iv("", (byte) 11, 6);
    private static final iv g = new iv("", (byte) 2, 7);

    /* renamed from: a  reason: collision with other field name */
    public int f578a;

    /* renamed from: a  reason: collision with other field name */
    public long f579a;

    /* renamed from: a  reason: collision with other field name */
    public String f580a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f581a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f582a;

    /* renamed from: b  reason: collision with other field name */
    public int f583b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f584b;

    /* renamed from: c  reason: collision with other field name */
    public int f585c;

    public int a() {
        return this.f578a;
    }

    /* renamed from: a */
    public int compareTo(hn hnVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(hnVar.getClass())) {
            return getClass().getName().compareTo(hnVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m410a()).compareTo(Boolean.valueOf(hnVar.m410a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m410a() && (a8 = io.a(this.f578a, hnVar.f578a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(m412b()).compareTo(Boolean.valueOf(hnVar.m412b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m412b() && (a7 = io.a(this.f583b, hnVar.f583b)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(m413c()).compareTo(Boolean.valueOf(hnVar.m413c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m413c() && (a6 = io.a(this.f582a, hnVar.f582a)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hnVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a5 = io.a(this.f585c, hnVar.f585c)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hnVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a4 = io.a(this.f579a, hnVar.f579a)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hnVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a3 = io.a(this.f580a, hnVar.f580a)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hnVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!h() || (a2 = io.a(this.f584b, hnVar.f584b)) == 0) {
            return 0;
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m407a() {
        return this.f579a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m408a() {
        return this.f580a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m409a() {
    }

    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                iyVar.f();
                m409a();
                return;
            }
            switch (a2.f877a) {
                case 1:
                    if (a2.a == 8) {
                        this.f578a = iyVar.m545a();
                        a(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 2:
                    if (a2.a == 8) {
                        this.f583b = iyVar.m545a();
                        b(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 2) {
                        this.f582a = iyVar.m556a();
                        c(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 8) {
                        this.f585c = iyVar.m545a();
                        d(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 5:
                    if (a2.a == 10) {
                        this.f579a = iyVar.m546a();
                        e(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 6:
                    if (a2.a == 11) {
                        this.f580a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 2) {
                        this.f584b = iyVar.m556a();
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

    public void a(boolean z) {
        this.f581a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m410a() {
        return this.f581a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m411a(hn hnVar) {
        if (hnVar == null) {
            return false;
        }
        boolean a2 = m410a();
        boolean a3 = hnVar.m410a();
        if ((a2 || a3) && (!a2 || !a3 || this.f578a != hnVar.f578a)) {
            return false;
        }
        boolean b2 = m412b();
        boolean b3 = hnVar.m412b();
        if ((b2 || b3) && (!b2 || !b3 || this.f583b != hnVar.f583b)) {
            return false;
        }
        boolean c2 = m413c();
        boolean c3 = hnVar.m413c();
        if ((c2 || c3) && (!c2 || !c3 || this.f582a != hnVar.f582a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hnVar.d();
        if ((d2 || d3) && (!d2 || !d3 || this.f585c != hnVar.f585c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hnVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f579a != hnVar.f579a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hnVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f580a.equals(hnVar.f580a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = hnVar.h();
        if (h || h2) {
            return h && h2 && this.f584b == hnVar.f584b;
        }
        return true;
    }

    public int b() {
        return this.f583b;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m409a();
        iyVar.a(f577a);
        if (m410a()) {
            iyVar.a(a);
            iyVar.mo543a(this.f578a);
            iyVar.b();
        }
        if (m412b()) {
            iyVar.a(b);
            iyVar.mo543a(this.f583b);
            iyVar.b();
        }
        if (m413c()) {
            iyVar.a(c);
            iyVar.a(this.f582a);
            iyVar.b();
        }
        if (d()) {
            iyVar.a(d);
            iyVar.mo543a(this.f585c);
            iyVar.b();
        }
        if (e()) {
            iyVar.a(e);
            iyVar.a(this.f579a);
            iyVar.b();
        }
        if (this.f580a != null && f()) {
            iyVar.a(f);
            iyVar.a(this.f580a);
            iyVar.b();
        }
        if (h()) {
            iyVar.a(g);
            iyVar.a(this.f584b);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public void b(boolean z) {
        this.f581a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m412b() {
        return this.f581a.get(1);
    }

    public int c() {
        return this.f585c;
    }

    public void c(boolean z) {
        this.f581a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m413c() {
        return this.f581a.get(2);
    }

    public void d(boolean z) {
        this.f581a.set(3, z);
    }

    public boolean d() {
        return this.f581a.get(3);
    }

    public void e(boolean z) {
        this.f581a.set(4, z);
    }

    public boolean e() {
        return this.f581a.get(4);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hn)) {
            return m411a((hn) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f581a.set(5, z);
    }

    public boolean f() {
        return this.f580a != null;
    }

    public boolean g() {
        return this.f584b;
    }

    public boolean h() {
        return this.f581a.get(5);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = false;
        if (m410a()) {
            sb.append("key:");
            sb.append(this.f578a);
            z = false;
        } else {
            z = true;
        }
        if (m412b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f583b);
            z = false;
        }
        if (m413c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f582a);
            z = false;
        }
        if (d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f585c);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f579a);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f580a;
            if (str == null) {
                str = "null";
            }
            sb.append(str);
        } else {
            z2 = z;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f584b);
        }
        sb.append(")");
        return sb.toString();
    }
}
