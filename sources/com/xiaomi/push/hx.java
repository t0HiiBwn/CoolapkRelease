package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class hx implements in<hx, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 12, 2);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f683a = new jd("XmPushActionCommandResult");
    private static final iv b = new iv("", (byte) 11, 3);
    private static final iv c = new iv("", (byte) 11, 4);
    private static final iv d = new iv("", (byte) 11, 5);
    private static final iv e = new iv("", (byte) 10, 7);
    private static final iv f = new iv("", (byte) 11, 8);
    private static final iv g = new iv("", (byte) 11, 9);
    private static final iv h = new iv("", (byte) 15, 10);
    private static final iv i = new iv("", (byte) 11, 12);
    private static final iv j = new iv("", (byte) 2, 13);

    /* renamed from: a  reason: collision with other field name */
    public long f684a;

    /* renamed from: a  reason: collision with other field name */
    public hr f685a;

    /* renamed from: a  reason: collision with other field name */
    public String f686a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f687a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public List<String> f688a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f689a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f690b;

    /* renamed from: c  reason: collision with other field name */
    public String f691c;

    /* renamed from: d  reason: collision with other field name */
    public String f692d;

    /* renamed from: e  reason: collision with other field name */
    public String f693e;

    /* renamed from: f  reason: collision with other field name */
    public String f694f;

    /* renamed from: a */
    public int compareTo(hx hxVar) {
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
        if (!getClass().equals(hxVar.getClass())) {
            return getClass().getName().compareTo(hxVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m452a()).compareTo(Boolean.valueOf(hxVar.m452a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m452a() && (a11 = io.a(this.f685a, hxVar.f685a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(m454b()).compareTo(Boolean.valueOf(hxVar.m454b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m454b() && (a10 = io.a(this.f686a, hxVar.f686a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(m455c()).compareTo(Boolean.valueOf(hxVar.m455c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m455c() && (a9 = io.a(this.f690b, hxVar.f690b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = io.a(this.f691c, hxVar.f691c)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = io.a(this.f684a, hxVar.f684a)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = io.a(this.f692d, hxVar.f692d)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hxVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = io.a(this.f693e, hxVar.f693e)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = io.a(this.f688a, hxVar.f688a)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hxVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = io.a(this.f694f, hxVar.f694f)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hxVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a2 = io.a(this.f689a, hxVar.f689a)) == 0) {
            return 0;
        }
        return a2;
    }

    public String a() {
        return this.f686a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m450a() {
        return this.f688a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m451a() {
        if (this.f686a == null) {
            throw new iz("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f690b == null) {
            throw new iz("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f691c == null) {
            throw new iz("Required field 'cmdName' was not present! Struct: " + toString());
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
                    m451a();
                    return;
                }
                throw new iz("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (a2.f877a) {
                case 2:
                    if (a2.a == 12) {
                        hr hrVar = new hr();
                        this.f685a = hrVar;
                        hrVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f686a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f690b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 5:
                    if (a2.a == 11) {
                        this.f691c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 10) {
                        this.f684a = iyVar.m546a();
                        a(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 8:
                    if (a2.a == 11) {
                        this.f692d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 9:
                    if (a2.a == 11) {
                        this.f693e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 10:
                    if (a2.a == 15) {
                        iw a3 = iyVar.m548a();
                        this.f688a = new ArrayList(a3.f878a);
                        for (int i2 = 0; i2 < a3.f878a; i2++) {
                            this.f688a.add(iyVar.m552a());
                        }
                        iyVar.i();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 12:
                    if (a2.a == 11) {
                        this.f694f = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 13:
                    if (a2.a == 2) {
                        this.f689a = iyVar.m556a();
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
        this.f687a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m452a() {
        return this.f685a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m453a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean a2 = m452a();
        boolean a3 = hxVar.m452a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f685a.m434a(hxVar.f685a))) {
            return false;
        }
        boolean b2 = m454b();
        boolean b3 = hxVar.m454b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f686a.equals(hxVar.f686a))) {
            return false;
        }
        boolean c2 = m455c();
        boolean c3 = hxVar.m455c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f690b.equals(hxVar.f690b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.f691c.equals(hxVar.f691c))) || this.f684a != hxVar.f684a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f692d.equals(hxVar.f692d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hxVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f693e.equals(hxVar.f693e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hxVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f688a.equals(hxVar.f688a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hxVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f694f.equals(hxVar.f694f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hxVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f689a == hxVar.f689a;
        }
        return true;
    }

    public String b() {
        return this.f691c;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m451a();
        iyVar.a(f683a);
        if (this.f685a != null && m452a()) {
            iyVar.a(a);
            this.f685a.b(iyVar);
            iyVar.b();
        }
        if (this.f686a != null) {
            iyVar.a(b);
            iyVar.a(this.f686a);
            iyVar.b();
        }
        if (this.f690b != null) {
            iyVar.a(c);
            iyVar.a(this.f690b);
            iyVar.b();
        }
        if (this.f691c != null) {
            iyVar.a(d);
            iyVar.a(this.f691c);
            iyVar.b();
        }
        iyVar.a(e);
        iyVar.a(this.f684a);
        iyVar.b();
        if (this.f692d != null && f()) {
            iyVar.a(f);
            iyVar.a(this.f692d);
            iyVar.b();
        }
        if (this.f693e != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f693e);
            iyVar.b();
        }
        if (this.f688a != null && h()) {
            iyVar.a(h);
            iyVar.a(new iw((byte) 11, this.f688a.size()));
            for (String str : this.f688a) {
                iyVar.a(str);
            }
            iyVar.e();
            iyVar.b();
        }
        if (this.f694f != null && i()) {
            iyVar.a(i);
            iyVar.a(this.f694f);
            iyVar.b();
        }
        if (j()) {
            iyVar.a(j);
            iyVar.a(this.f689a);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public void b(boolean z) {
        this.f687a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m454b() {
        return this.f686a != null;
    }

    public String c() {
        return this.f694f;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m455c() {
        return this.f690b != null;
    }

    public boolean d() {
        return this.f691c != null;
    }

    public boolean e() {
        return this.f687a.get(0);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return m453a((hx) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f692d != null;
    }

    public boolean g() {
        return this.f693e != null;
    }

    public boolean h() {
        return this.f688a != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f694f != null;
    }

    public boolean j() {
        return this.f687a.get(1);
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m452a()) {
            sb.append("target:");
            hr hrVar = this.f685a;
            if (hrVar == null) {
                sb.append("null");
            } else {
                sb.append(hrVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f686a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f690b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f691c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f684a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f692d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f693e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f688a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f694f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f689a);
        }
        sb.append(")");
        return sb.toString();
    }
}
