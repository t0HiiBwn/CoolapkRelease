package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.if  reason: invalid class name */
public class Cif implements in<Cif, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f788a = new jd("XmPushActionSendMessage");
    private static final iv b = new iv("", (byte) 12, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 11, 5);
    private static final iv f = new iv("", (byte) 11, 6);
    private static final iv g = new iv("", (byte) 11, 7);
    private static final iv h = new iv("", (byte) 12, 8);
    private static final iv i = new iv("", (byte) 2, 9);
    private static final iv j = new iv("", (byte) 13, 10);
    private static final iv k = new iv("", (byte) 11, 11);

    /* renamed from: l  reason: collision with root package name */
    private static final iv f1510l = new iv("", (byte) 11, 12);

    /* renamed from: a  reason: collision with other field name */
    public ho f789a;

    /* renamed from: a  reason: collision with other field name */
    public hr f790a;

    /* renamed from: a  reason: collision with other field name */
    public String f791a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f792a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f793a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f794a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f795b;

    /* renamed from: c  reason: collision with other field name */
    public String f796c;

    /* renamed from: d  reason: collision with other field name */
    public String f797d;

    /* renamed from: e  reason: collision with other field name */
    public String f798e;

    /* renamed from: f  reason: collision with other field name */
    public String f799f;

    /* renamed from: g  reason: collision with other field name */
    public String f800g;

    /* renamed from: h  reason: collision with other field name */
    public String f801h;

    /* renamed from: a */
    public int compareTo(Cif ifVar) {
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
        if (!getClass().equals(ifVar.getClass())) {
            return getClass().getName().compareTo(ifVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m503a()).compareTo(Boolean.valueOf(ifVar.m503a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m503a() && (a13 = io.a(this.f791a, ifVar.f791a)) != 0) {
            return a13;
        }
        int compareTo2 = Boolean.valueOf(m505b()).compareTo(Boolean.valueOf(ifVar.m505b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m505b() && (a12 = io.a(this.f790a, ifVar.f790a)) != 0) {
            return a12;
        }
        int compareTo3 = Boolean.valueOf(m506c()).compareTo(Boolean.valueOf(ifVar.m506c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m506c() && (a11 = io.a(this.f795b, ifVar.f795b)) != 0) {
            return a11;
        }
        int compareTo4 = Boolean.valueOf(m507d()).compareTo(Boolean.valueOf(ifVar.m507d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m507d() && (a10 = io.a(this.f796c, ifVar.f796c)) != 0) {
            return a10;
        }
        int compareTo5 = Boolean.valueOf(m508e()).compareTo(Boolean.valueOf(ifVar.m508e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m508e() && (a9 = io.a(this.f797d, ifVar.f797d)) != 0) {
            return a9;
        }
        int compareTo6 = Boolean.valueOf(m509f()).compareTo(Boolean.valueOf(ifVar.m509f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m509f() && (a8 = io.a(this.f798e, ifVar.f798e)) != 0) {
            return a8;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ifVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a7 = io.a(this.f799f, ifVar.f799f)) != 0) {
            return a7;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ifVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a6 = io.a(this.f789a, ifVar.f789a)) != 0) {
            return a6;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ifVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a5 = io.a(this.f794a, ifVar.f794a)) != 0) {
            return a5;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ifVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a4 = io.a(this.f793a, ifVar.f793a)) != 0) {
            return a4;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ifVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a3 = io.a(this.f800g, ifVar.f800g)) != 0) {
            return a3;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ifVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!l() || (a2 = io.a(this.f801h, ifVar.f801h)) == 0) {
            return 0;
        }
        return a2;
    }

    public ho a() {
        return this.f789a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m501a() {
        return this.f795b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m502a() {
        if (this.f795b == null) {
            throw new iz("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f796c == null) {
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
                m502a();
                return;
            }
            switch (a2.f877a) {
                case 1:
                    if (a2.a == 11) {
                        this.f791a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 2:
                    if (a2.a == 12) {
                        hr hrVar = new hr();
                        this.f790a = hrVar;
                        hrVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f795b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f796c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 5:
                    if (a2.a == 11) {
                        this.f797d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 6:
                    if (a2.a == 11) {
                        this.f798e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 11) {
                        this.f799f = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 8:
                    if (a2.a == 12) {
                        ho hoVar = new ho();
                        this.f789a = hoVar;
                        hoVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 9:
                    if (a2.a == 2) {
                        this.f794a = iyVar.m556a();
                        a(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 10:
                    if (a2.a == 13) {
                        ix a3 = iyVar.m549a();
                        this.f793a = new HashMap(a3.f879a * 2);
                        for (int i2 = 0; i2 < a3.f879a; i2++) {
                            this.f793a.put(iyVar.m552a(), iyVar.m552a());
                        }
                        iyVar.h();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 11:
                    if (a2.a == 11) {
                        this.f800g = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 12:
                    if (a2.a == 11) {
                        this.f801h = iyVar.m552a();
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
        this.f792a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m503a() {
        return this.f791a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m504a(Cif ifVar) {
        if (ifVar == null) {
            return false;
        }
        boolean a2 = m503a();
        boolean a3 = ifVar.m503a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f791a.equals(ifVar.f791a))) {
            return false;
        }
        boolean b2 = m505b();
        boolean b3 = ifVar.m505b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f790a.m434a(ifVar.f790a))) {
            return false;
        }
        boolean c2 = m506c();
        boolean c3 = ifVar.m506c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f795b.equals(ifVar.f795b))) {
            return false;
        }
        boolean d2 = m507d();
        boolean d3 = ifVar.m507d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f796c.equals(ifVar.f796c))) {
            return false;
        }
        boolean e2 = m508e();
        boolean e3 = ifVar.m508e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f797d.equals(ifVar.f797d))) {
            return false;
        }
        boolean f2 = m509f();
        boolean f3 = ifVar.m509f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f798e.equals(ifVar.f798e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ifVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f799f.equals(ifVar.f799f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ifVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f789a.m417a(ifVar.f789a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ifVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.f794a != ifVar.f794a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ifVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f793a.equals(ifVar.f793a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ifVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f800g.equals(ifVar.f800g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ifVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f801h.equals(ifVar.f801h);
        }
        return true;
    }

    public String b() {
        return this.f796c;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m502a();
        iyVar.a(f788a);
        if (this.f791a != null && m503a()) {
            iyVar.a(a);
            iyVar.a(this.f791a);
            iyVar.b();
        }
        if (this.f790a != null && m505b()) {
            iyVar.a(b);
            this.f790a.b(iyVar);
            iyVar.b();
        }
        if (this.f795b != null) {
            iyVar.a(c);
            iyVar.a(this.f795b);
            iyVar.b();
        }
        if (this.f796c != null) {
            iyVar.a(d);
            iyVar.a(this.f796c);
            iyVar.b();
        }
        if (this.f797d != null && m508e()) {
            iyVar.a(e);
            iyVar.a(this.f797d);
            iyVar.b();
        }
        if (this.f798e != null && m509f()) {
            iyVar.a(f);
            iyVar.a(this.f798e);
            iyVar.b();
        }
        if (this.f799f != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f799f);
            iyVar.b();
        }
        if (this.f789a != null && h()) {
            iyVar.a(h);
            this.f789a.b(iyVar);
            iyVar.b();
        }
        if (i()) {
            iyVar.a(i);
            iyVar.a(this.f794a);
            iyVar.b();
        }
        if (this.f793a != null && j()) {
            iyVar.a(j);
            iyVar.a(new ix((byte) 11, (byte) 11, this.f793a.size()));
            for (Map.Entry<String, String> entry : this.f793a.entrySet()) {
                iyVar.a(entry.getKey());
                iyVar.a(entry.getValue());
            }
            iyVar.d();
            iyVar.b();
        }
        if (this.f800g != null && k()) {
            iyVar.a(k);
            iyVar.a(this.f800g);
            iyVar.b();
        }
        if (this.f801h != null && l()) {
            iyVar.a(f1510l);
            iyVar.a(this.f801h);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m505b() {
        return this.f790a != null;
    }

    public String c() {
        return this.f798e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m506c() {
        return this.f795b != null;
    }

    public String d() {
        return this.f799f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m507d() {
        return this.f796c != null;
    }

    public String e() {
        return this.f800g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m508e() {
        return this.f797d != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m504a((Cif) obj);
        }
        return false;
    }

    public String f() {
        return this.f801h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m509f() {
        return this.f798e != null;
    }

    public boolean g() {
        return this.f799f != null;
    }

    public boolean h() {
        return this.f789a != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f792a.get(0);
    }

    public boolean j() {
        return this.f793a != null;
    }

    public boolean k() {
        return this.f800g != null;
    }

    public boolean l() {
        return this.f801h != null;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = false;
        if (m503a()) {
            sb.append("debug:");
            String str = this.f791a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m505b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hr hrVar = this.f790a;
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
        String str2 = this.f795b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f796c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (m508e()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f797d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m509f()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f798e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.f799f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            ho hoVar = this.f789a;
            if (hoVar == null) {
                sb.append("null");
            } else {
                sb.append(hoVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f794a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.f793a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f800g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.f801h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
