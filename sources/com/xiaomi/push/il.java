package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class il implements in<il, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f856a = new jd("XmPushActionUnSubscriptionResult");
    private static final iv b = new iv("", (byte) 12, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 10, 6);
    private static final iv f = new iv("", (byte) 11, 7);
    private static final iv g = new iv("", (byte) 11, 8);
    private static final iv h = new iv("", (byte) 11, 9);
    private static final iv i = new iv("", (byte) 11, 10);

    /* renamed from: a  reason: collision with other field name */
    public long f857a;

    /* renamed from: a  reason: collision with other field name */
    public hr f858a;

    /* renamed from: a  reason: collision with other field name */
    public String f859a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f860a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f861b;

    /* renamed from: c  reason: collision with other field name */
    public String f862c;

    /* renamed from: d  reason: collision with other field name */
    public String f863d;

    /* renamed from: e  reason: collision with other field name */
    public String f864e;

    /* renamed from: f  reason: collision with other field name */
    public String f865f;

    /* renamed from: g  reason: collision with other field name */
    public String f866g;

    /* renamed from: a */
    public int compareTo(il ilVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (!getClass().equals(ilVar.getClass())) {
            return getClass().getName().compareTo(ilVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m525a()).compareTo(Boolean.valueOf(ilVar.m525a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m525a() && (a10 = io.a(this.f859a, ilVar.f859a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(m527b()).compareTo(Boolean.valueOf(ilVar.m527b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m527b() && (a9 = io.a(this.f858a, ilVar.f858a)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(m528c()).compareTo(Boolean.valueOf(ilVar.m528c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m528c() && (a8 = io.a(this.f861b, ilVar.f861b)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a7 = io.a(this.f862c, ilVar.f862c)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a6 = io.a(this.f857a, ilVar.f857a)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a5 = io.a(this.f863d, ilVar.f863d)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a4 = io.a(this.f864e, ilVar.f864e)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a3 = io.a(this.f865f, ilVar.f865f)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!i() || (a2 = io.a(this.f866g, ilVar.f866g)) == 0) {
            return 0;
        }
        return a2;
    }

    public String a() {
        return this.f861b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m524a() {
        if (this.f861b == null) {
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
                m524a();
                return;
            }
            switch (a2.f877a) {
                case 1:
                    if (a2.a == 11) {
                        this.f859a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 2:
                    if (a2.a == 12) {
                        hr hrVar = new hr();
                        this.f858a = hrVar;
                        hrVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f861b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f862c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 6:
                    if (a2.a == 10) {
                        this.f857a = iyVar.m546a();
                        a(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 11) {
                        this.f863d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 8:
                    if (a2.a == 11) {
                        this.f864e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 9:
                    if (a2.a == 11) {
                        this.f865f = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 10:
                    if (a2.a == 11) {
                        this.f866g = iyVar.m552a();
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
        this.f860a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m525a() {
        return this.f859a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m526a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean a2 = m525a();
        boolean a3 = ilVar.m525a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f859a.equals(ilVar.f859a))) {
            return false;
        }
        boolean b2 = m527b();
        boolean b3 = ilVar.m527b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f858a.m434a(ilVar.f858a))) {
            return false;
        }
        boolean c2 = m528c();
        boolean c3 = ilVar.m528c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f861b.equals(ilVar.f861b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f862c.equals(ilVar.f862c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ilVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f857a != ilVar.f857a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ilVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f863d.equals(ilVar.f863d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f864e.equals(ilVar.f864e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ilVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f865f.equals(ilVar.f865f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ilVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f866g.equals(ilVar.f866g);
        }
        return true;
    }

    public String b() {
        return this.f864e;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m524a();
        iyVar.a(f856a);
        if (this.f859a != null && m525a()) {
            iyVar.a(a);
            iyVar.a(this.f859a);
            iyVar.b();
        }
        if (this.f858a != null && m527b()) {
            iyVar.a(b);
            this.f858a.b(iyVar);
            iyVar.b();
        }
        if (this.f861b != null) {
            iyVar.a(c);
            iyVar.a(this.f861b);
            iyVar.b();
        }
        if (this.f862c != null && d()) {
            iyVar.a(d);
            iyVar.a(this.f862c);
            iyVar.b();
        }
        if (e()) {
            iyVar.a(e);
            iyVar.a(this.f857a);
            iyVar.b();
        }
        if (this.f863d != null && f()) {
            iyVar.a(f);
            iyVar.a(this.f863d);
            iyVar.b();
        }
        if (this.f864e != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f864e);
            iyVar.b();
        }
        if (this.f865f != null && h()) {
            iyVar.a(h);
            iyVar.a(this.f865f);
            iyVar.b();
        }
        if (this.f866g != null && i()) {
            iyVar.a(i);
            iyVar.a(this.f866g);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m527b() {
        return this.f858a != null;
    }

    public String c() {
        return this.f866g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m528c() {
        return this.f861b != null;
    }

    public boolean d() {
        return this.f862c != null;
    }

    public boolean e() {
        return this.f860a.get(0);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m526a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f863d != null;
    }

    public boolean g() {
        return this.f864e != null;
    }

    public boolean h() {
        return this.f865f != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f866g != null;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = false;
        if (m525a()) {
            sb.append("debug:");
            String str = this.f859a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m527b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hr hrVar = this.f858a;
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
        String str2 = this.f861b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f862c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f857a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f863d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f864e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f865f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f866g;
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
