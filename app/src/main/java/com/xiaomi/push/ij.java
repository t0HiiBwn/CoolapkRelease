package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class ij implements in<ij, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f836a = new jd("XmPushActionUnRegistrationResult");
    private static final iv b = new iv("", (byte) 12, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 10, 6);
    private static final iv f = new iv("", (byte) 11, 7);
    private static final iv g = new iv("", (byte) 11, 8);
    private static final iv h = new iv("", (byte) 10, 9);
    private static final iv i = new iv("", (byte) 10, 10);

    /* renamed from: a  reason: collision with other field name */
    public long f837a;

    /* renamed from: a  reason: collision with other field name */
    public hr f838a;

    /* renamed from: a  reason: collision with other field name */
    public String f839a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f840a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f841b;

    /* renamed from: b  reason: collision with other field name */
    public String f842b;

    /* renamed from: c  reason: collision with other field name */
    public long f843c;

    /* renamed from: c  reason: collision with other field name */
    public String f844c;

    /* renamed from: d  reason: collision with other field name */
    public String f845d;

    /* renamed from: e  reason: collision with other field name */
    public String f846e;

    /* renamed from: a */
    public int compareTo(ij ijVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (!getClass().equals(ijVar.getClass())) {
            return getClass().getName().compareTo(ijVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m520a()).compareTo(Boolean.valueOf(ijVar.m520a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m520a() && (a10 = io.a(this.f839a, ijVar.f839a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ijVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a9 = io.a(this.f838a, ijVar.f838a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ijVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a8 = io.a(this.f842b, ijVar.f842b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ijVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = io.a(this.f844c, ijVar.f844c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ijVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = io.a(this.f837a, ijVar.f837a)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ijVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = io.a(this.f845d, ijVar.f845d)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ijVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a4 = io.a(this.f846e, ijVar.f846e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ijVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a3 = io.a(this.f841b, ijVar.f841b)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ijVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (a2 = io.a(this.f843c, ijVar.f843c)) == 0) {
            return 0;
        }
        return a2;
    }

    public String a() {
        return this.f846e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m519a() {
        if (this.f842b == null) {
            throw new iz("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f844c == null) {
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
                if (e()) {
                    m519a();
                    return;
                }
                throw new iz("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (a2.f877a) {
                case 1:
                    if (a2.a == 11) {
                        this.f839a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 2:
                    if (a2.a == 12) {
                        hr hrVar = new hr();
                        this.f838a = hrVar;
                        hrVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f842b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f844c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 6:
                    if (a2.a == 10) {
                        this.f837a = iyVar.m546a();
                        a(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 11) {
                        this.f845d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 8:
                    if (a2.a == 11) {
                        this.f846e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 9:
                    if (a2.a == 10) {
                        this.f841b = iyVar.m546a();
                        b(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 10:
                    if (a2.a == 10) {
                        this.f843c = iyVar.m546a();
                        c(true);
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
        this.f840a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m520a() {
        return this.f839a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m521a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean a2 = m520a();
        boolean a3 = ijVar.m520a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f839a.equals(ijVar.f839a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ijVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f838a.m434a(ijVar.f838a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ijVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f842b.equals(ijVar.f842b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ijVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.f844c.equals(ijVar.f844c))) || this.f837a != ijVar.f837a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ijVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f845d.equals(ijVar.f845d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ijVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f846e.equals(ijVar.f846e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ijVar.h();
        if ((h2 || h3) && (!h2 || !h3 || this.f841b != ijVar.f841b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ijVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f843c == ijVar.f843c;
        }
        return true;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m519a();
        iyVar.a(f836a);
        if (this.f839a != null && m520a()) {
            iyVar.a(a);
            iyVar.a(this.f839a);
            iyVar.b();
        }
        if (this.f838a != null && b()) {
            iyVar.a(b);
            this.f838a.b(iyVar);
            iyVar.b();
        }
        if (this.f842b != null) {
            iyVar.a(c);
            iyVar.a(this.f842b);
            iyVar.b();
        }
        if (this.f844c != null) {
            iyVar.a(d);
            iyVar.a(this.f844c);
            iyVar.b();
        }
        iyVar.a(e);
        iyVar.a(this.f837a);
        iyVar.b();
        if (this.f845d != null && f()) {
            iyVar.a(f);
            iyVar.a(this.f845d);
            iyVar.b();
        }
        if (this.f846e != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f846e);
            iyVar.b();
        }
        if (h()) {
            iyVar.a(h);
            iyVar.a(this.f841b);
            iyVar.b();
        }
        if (i()) {
            iyVar.a(i);
            iyVar.a(this.f843c);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public void b(boolean z) {
        this.f840a.set(1, z);
    }

    public boolean b() {
        return this.f838a != null;
    }

    public void c(boolean z) {
        this.f840a.set(2, z);
    }

    public boolean c() {
        return this.f842b != null;
    }

    public boolean d() {
        return this.f844c != null;
    }

    public boolean e() {
        return this.f840a.get(0);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m521a((ij) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f845d != null;
    }

    public boolean g() {
        return this.f846e != null;
    }

    public boolean h() {
        return this.f840a.get(1);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f840a.get(2);
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = false;
        if (m520a()) {
            sb.append("debug:");
            String str = this.f839a;
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
            hr hrVar = this.f838a;
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
        String str2 = this.f842b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f844c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f837a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f845d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f846e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f841b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f843c);
        }
        sb.append(")");
        return sb.toString();
    }
}
