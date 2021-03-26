package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class hg implements in<hg, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f546a = new jd("ClientUploadDataItem");
    private static final iv b = new iv("", (byte) 11, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 10, 4);
    private static final iv e = new iv("", (byte) 10, 5);
    private static final iv f = new iv("", (byte) 2, 6);
    private static final iv g = new iv("", (byte) 11, 7);
    private static final iv h = new iv("", (byte) 11, 8);
    private static final iv i = new iv("", (byte) 11, 9);
    private static final iv j = new iv("", (byte) 13, 10);
    private static final iv k = new iv("", (byte) 11, 11);

    /* renamed from: a  reason: collision with other field name */
    public long f547a;

    /* renamed from: a  reason: collision with other field name */
    public String f548a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f549a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f550a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f551a;

    /* renamed from: b  reason: collision with other field name */
    public long f552b;

    /* renamed from: b  reason: collision with other field name */
    public String f553b;

    /* renamed from: c  reason: collision with other field name */
    public String f554c;

    /* renamed from: d  reason: collision with other field name */
    public String f555d;

    /* renamed from: e  reason: collision with other field name */
    public String f556e;

    /* renamed from: f  reason: collision with other field name */
    public String f557f;

    /* renamed from: g  reason: collision with other field name */
    public String f558g;

    /* renamed from: a */
    public int compareTo(hg hgVar) {
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
        if (!getClass().equals(hgVar.getClass())) {
            return getClass().getName().compareTo(hgVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m394a()).compareTo(Boolean.valueOf(hgVar.m394a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m394a() && (a12 = io.a(this.f548a, hgVar.f548a)) != 0) {
            return a12;
        }
        int compareTo2 = Boolean.valueOf(m396b()).compareTo(Boolean.valueOf(hgVar.m396b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m396b() && (a11 = io.a(this.f553b, hgVar.f553b)) != 0) {
            return a11;
        }
        int compareTo3 = Boolean.valueOf(m397c()).compareTo(Boolean.valueOf(hgVar.m397c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m397c() && (a10 = io.a(this.f554c, hgVar.f554c)) != 0) {
            return a10;
        }
        int compareTo4 = Boolean.valueOf(m398d()).compareTo(Boolean.valueOf(hgVar.m398d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m398d() && (a9 = io.a(this.f547a, hgVar.f547a)) != 0) {
            return a9;
        }
        int compareTo5 = Boolean.valueOf(m399e()).compareTo(Boolean.valueOf(hgVar.m399e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m399e() && (a8 = io.a(this.f552b, hgVar.f552b)) != 0) {
            return a8;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hgVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a7 = io.a(this.f551a, hgVar.f551a)) != 0) {
            return a7;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hgVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a6 = io.a(this.f555d, hgVar.f555d)) != 0) {
            return a6;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hgVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a5 = io.a(this.f556e, hgVar.f556e)) != 0) {
            return a5;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hgVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a4 = io.a(this.f557f, hgVar.f557f)) != 0) {
            return a4;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hgVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a3 = io.a(this.f550a, hgVar.f550a)) != 0) {
            return a3;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hgVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!k() || (a2 = io.a(this.f558g, hgVar.f558g)) == 0) {
            return 0;
        }
        return a2;
    }

    public long a() {
        return this.f552b;
    }

    public hg a(long j2) {
        this.f547a = j2;
        m393a(true);
        return this;
    }

    public hg a(String str) {
        this.f548a = str;
        return this;
    }

    public hg a(Map<String, String> map) {
        this.f550a = map;
        return this;
    }

    public hg a(boolean z) {
        this.f551a = z;
        c(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m390a() {
        return this.f548a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m391a() {
        return this.f550a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m392a() {
    }

    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                iyVar.f();
                m392a();
                return;
            }
            switch (a2.f877a) {
                case 1:
                    if (a2.a == 11) {
                        this.f548a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 2:
                    if (a2.a == 11) {
                        this.f553b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f554c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 10) {
                        this.f547a = iyVar.m546a();
                        m393a(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 5:
                    if (a2.a == 10) {
                        this.f552b = iyVar.m546a();
                        b(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 6:
                    if (a2.a == 2) {
                        this.f551a = iyVar.m556a();
                        c(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 11) {
                        this.f555d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 8:
                    if (a2.a == 11) {
                        this.f556e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 9:
                    if (a2.a == 11) {
                        this.f557f = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 10:
                    if (a2.a == 13) {
                        ix a3 = iyVar.m549a();
                        this.f550a = new HashMap(a3.f879a * 2);
                        for (int i2 = 0; i2 < a3.f879a; i2++) {
                            this.f550a.put(iyVar.m552a(), iyVar.m552a());
                        }
                        iyVar.h();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 11:
                    if (a2.a == 11) {
                        this.f558g = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
            }
            jb.a(iyVar, a2.a);
            iyVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f550a == null) {
            this.f550a = new HashMap();
        }
        this.f550a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m393a(boolean z) {
        this.f549a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m394a() {
        return this.f548a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m395a(hg hgVar) {
        if (hgVar == null) {
            return false;
        }
        boolean a2 = m394a();
        boolean a3 = hgVar.m394a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f548a.equals(hgVar.f548a))) {
            return false;
        }
        boolean b2 = m396b();
        boolean b3 = hgVar.m396b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f553b.equals(hgVar.f553b))) {
            return false;
        }
        boolean c2 = m397c();
        boolean c3 = hgVar.m397c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f554c.equals(hgVar.f554c))) {
            return false;
        }
        boolean d2 = m398d();
        boolean d3 = hgVar.m398d();
        if ((d2 || d3) && (!d2 || !d3 || this.f547a != hgVar.f547a)) {
            return false;
        }
        boolean e2 = m399e();
        boolean e3 = hgVar.m399e();
        if ((e2 || e3) && (!e2 || !e3 || this.f552b != hgVar.f552b)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hgVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f551a != hgVar.f551a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hgVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f555d.equals(hgVar.f555d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hgVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f556e.equals(hgVar.f556e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hgVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f557f.equals(hgVar.f557f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hgVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f550a.equals(hgVar.f550a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hgVar.k();
        if (k2 || k3) {
            return k2 && k3 && this.f558g.equals(hgVar.f558g);
        }
        return true;
    }

    public hg b(long j2) {
        this.f552b = j2;
        b(true);
        return this;
    }

    public hg b(String str) {
        this.f553b = str;
        return this;
    }

    public String b() {
        return this.f554c;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m392a();
        iyVar.a(f546a);
        if (this.f548a != null && m394a()) {
            iyVar.a(a);
            iyVar.a(this.f548a);
            iyVar.b();
        }
        if (this.f553b != null && m396b()) {
            iyVar.a(b);
            iyVar.a(this.f553b);
            iyVar.b();
        }
        if (this.f554c != null && m397c()) {
            iyVar.a(c);
            iyVar.a(this.f554c);
            iyVar.b();
        }
        if (m398d()) {
            iyVar.a(d);
            iyVar.a(this.f547a);
            iyVar.b();
        }
        if (m399e()) {
            iyVar.a(e);
            iyVar.a(this.f552b);
            iyVar.b();
        }
        if (f()) {
            iyVar.a(f);
            iyVar.a(this.f551a);
            iyVar.b();
        }
        if (this.f555d != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f555d);
            iyVar.b();
        }
        if (this.f556e != null && h()) {
            iyVar.a(h);
            iyVar.a(this.f556e);
            iyVar.b();
        }
        if (this.f557f != null && i()) {
            iyVar.a(i);
            iyVar.a(this.f557f);
            iyVar.b();
        }
        if (this.f550a != null && j()) {
            iyVar.a(j);
            iyVar.a(new ix((byte) 11, (byte) 11, this.f550a.size()));
            for (Map.Entry<String, String> entry : this.f550a.entrySet()) {
                iyVar.a(entry.getKey());
                iyVar.a(entry.getValue());
            }
            iyVar.d();
            iyVar.b();
        }
        if (this.f558g != null && k()) {
            iyVar.a(k);
            iyVar.a(this.f558g);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public void b(boolean z) {
        this.f549a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m396b() {
        return this.f553b != null;
    }

    public hg c(String str) {
        this.f554c = str;
        return this;
    }

    public String c() {
        return this.f556e;
    }

    public void c(boolean z) {
        this.f549a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m397c() {
        return this.f554c != null;
    }

    public hg d(String str) {
        this.f555d = str;
        return this;
    }

    public String d() {
        return this.f557f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m398d() {
        return this.f549a.get(0);
    }

    public hg e(String str) {
        this.f556e = str;
        return this;
    }

    public String e() {
        return this.f558g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m399e() {
        return this.f549a.get(1);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hg)) {
            return m395a((hg) obj);
        }
        return false;
    }

    public hg f(String str) {
        this.f557f = str;
        return this;
    }

    public boolean f() {
        return this.f549a.get(2);
    }

    public hg g(String str) {
        this.f558g = str;
        return this;
    }

    public boolean g() {
        return this.f555d != null;
    }

    public boolean h() {
        return this.f556e != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f557f != null;
    }

    public boolean j() {
        return this.f550a != null;
    }

    public boolean k() {
        return this.f558g != null;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = false;
        if (m394a()) {
            sb.append("channel:");
            String str = this.f548a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m396b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.f553b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (m397c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.f554c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (m398d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f547a);
            z = false;
        }
        if (m399e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f552b);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f551a);
            z = false;
        }
        if (g()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.f555d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.f556e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.f557f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (j()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.f550a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        } else {
            z2 = z;
        }
        if (k()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            String str7 = this.f558g;
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
