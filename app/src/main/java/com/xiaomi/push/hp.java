package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class hp implements in<hp, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f606a = new jd("PushMetaInfo");
    private static final iv b = new iv("", (byte) 10, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 11, 5);
    private static final iv f = new iv("", (byte) 8, 6);
    private static final iv g = new iv("", (byte) 11, 7);
    private static final iv h = new iv("", (byte) 8, 8);
    private static final iv i = new iv("", (byte) 8, 9);
    private static final iv j = new iv("", (byte) 13, 10);
    private static final iv k = new iv("", (byte) 13, 11);

    /* renamed from: l  reason: collision with root package name */
    private static final iv f1505l = new iv("", (byte) 2, 12);
    private static final iv m = new iv("", (byte) 13, 13);

    /* renamed from: a  reason: collision with other field name */
    public int f607a;

    /* renamed from: a  reason: collision with other field name */
    public long f608a;

    /* renamed from: a  reason: collision with other field name */
    public String f609a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f610a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f611a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f612a;

    /* renamed from: b  reason: collision with other field name */
    public int f613b;

    /* renamed from: b  reason: collision with other field name */
    public String f614b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f615b;

    /* renamed from: c  reason: collision with other field name */
    public int f616c;

    /* renamed from: c  reason: collision with other field name */
    public String f617c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f618c;

    /* renamed from: d  reason: collision with other field name */
    public String f619d;

    /* renamed from: e  reason: collision with other field name */
    public String f620e;

    public hp() {
        this.f610a = new BitSet(5);
        this.f612a = false;
    }

    public hp(hp hpVar) {
        BitSet bitSet = new BitSet(5);
        this.f610a = bitSet;
        bitSet.clear();
        this.f610a.or(hpVar.f610a);
        if (hpVar.m425a()) {
            this.f609a = hpVar.f609a;
        }
        this.f608a = hpVar.f608a;
        if (hpVar.m431c()) {
            this.f614b = hpVar.f614b;
        }
        if (hpVar.m432d()) {
            this.f617c = hpVar.f617c;
        }
        if (hpVar.e()) {
            this.f619d = hpVar.f619d;
        }
        this.f607a = hpVar.f607a;
        if (hpVar.g()) {
            this.f620e = hpVar.f620e;
        }
        this.f613b = hpVar.f613b;
        this.f616c = hpVar.f616c;
        if (hpVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hpVar.f611a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f611a = hashMap;
        }
        if (hpVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hpVar.f615b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f615b = hashMap2;
        }
        this.f612a = hpVar.f612a;
        if (hpVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hpVar.f618c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f618c = hashMap3;
        }
    }

    public int a() {
        return this.f607a;
    }

    /* renamed from: a */
    public int compareTo(hp hpVar) {
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
        int a14;
        if (!getClass().equals(hpVar.getClass())) {
            return getClass().getName().compareTo(hpVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m425a()).compareTo(Boolean.valueOf(hpVar.m425a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m425a() && (a14 = io.a(this.f609a, hpVar.f609a)) != 0) {
            return a14;
        }
        int compareTo2 = Boolean.valueOf(m429b()).compareTo(Boolean.valueOf(hpVar.m429b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m429b() && (a13 = io.a(this.f608a, hpVar.f608a)) != 0) {
            return a13;
        }
        int compareTo3 = Boolean.valueOf(m431c()).compareTo(Boolean.valueOf(hpVar.m431c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m431c() && (a12 = io.a(this.f614b, hpVar.f614b)) != 0) {
            return a12;
        }
        int compareTo4 = Boolean.valueOf(m432d()).compareTo(Boolean.valueOf(hpVar.m432d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m432d() && (a11 = io.a(this.f617c, hpVar.f617c)) != 0) {
            return a11;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hpVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a10 = io.a(this.f619d, hpVar.f619d)) != 0) {
            return a10;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hpVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a9 = io.a(this.f607a, hpVar.f607a)) != 0) {
            return a9;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hpVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a8 = io.a(this.f620e, hpVar.f620e)) != 0) {
            return a8;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hpVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a7 = io.a(this.f613b, hpVar.f613b)) != 0) {
            return a7;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hpVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a6 = io.a(this.f616c, hpVar.f616c)) != 0) {
            return a6;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hpVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a5 = io.a(this.f611a, hpVar.f611a)) != 0) {
            return a5;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hpVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a4 = io.a(this.f615b, hpVar.f615b)) != 0) {
            return a4;
        }
        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hpVar.m()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m() && (a3 = io.a(this.f612a, hpVar.f612a)) != 0) {
            return a3;
        }
        int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hpVar.n()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (!n() || (a2 = io.a(this.f618c, hpVar.f618c)) == 0) {
            return 0;
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m420a() {
        return this.f608a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hp m421a() {
        return new hp(this);
    }

    public hp a(int i2) {
        this.f607a = i2;
        b(true);
        return this;
    }

    public hp a(String str) {
        this.f609a = str;
        return this;
    }

    public hp a(Map<String, String> map) {
        this.f611a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m422a() {
        return this.f609a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m423a() {
        return this.f611a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m424a() {
        if (this.f609a == null) {
            throw new iz("Required field 'id' was not present! Struct: " + toString());
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                iyVar.f();
                if (m429b()) {
                    m424a();
                    return;
                }
                throw new iz("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (a2.f877a) {
                case 1:
                    if (a2.a == 11) {
                        this.f609a = iyVar.m552a();
                        break;
                    }
                    jb.a(iyVar, a2.a);
                    break;
                case 2:
                    if (a2.a == 10) {
                        this.f608a = iyVar.m546a();
                        a(true);
                        break;
                    }
                    jb.a(iyVar, a2.a);
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f614b = iyVar.m552a();
                        break;
                    }
                    jb.a(iyVar, a2.a);
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f617c = iyVar.m552a();
                        break;
                    }
                    jb.a(iyVar, a2.a);
                    break;
                case 5:
                    if (a2.a == 11) {
                        this.f619d = iyVar.m552a();
                        break;
                    }
                    jb.a(iyVar, a2.a);
                    break;
                case 6:
                    if (a2.a == 8) {
                        this.f607a = iyVar.m545a();
                        b(true);
                        break;
                    }
                    jb.a(iyVar, a2.a);
                    break;
                case 7:
                    if (a2.a == 11) {
                        this.f620e = iyVar.m552a();
                        break;
                    }
                    jb.a(iyVar, a2.a);
                    break;
                case 8:
                    if (a2.a == 8) {
                        this.f613b = iyVar.m545a();
                        c(true);
                        break;
                    }
                    jb.a(iyVar, a2.a);
                    break;
                case 9:
                    if (a2.a == 8) {
                        this.f616c = iyVar.m545a();
                        d(true);
                        break;
                    }
                    jb.a(iyVar, a2.a);
                    break;
                case 10:
                    if (a2.a == 13) {
                        ix a3 = iyVar.m549a();
                        this.f611a = new HashMap(a3.f879a * 2);
                        while (i2 < a3.f879a) {
                            this.f611a.put(iyVar.m552a(), iyVar.m552a());
                            i2++;
                        }
                        iyVar.h();
                        break;
                    }
                    jb.a(iyVar, a2.a);
                    break;
                case 11:
                    if (a2.a == 13) {
                        ix a4 = iyVar.m549a();
                        this.f615b = new HashMap(a4.f879a * 2);
                        while (i2 < a4.f879a) {
                            this.f615b.put(iyVar.m552a(), iyVar.m552a());
                            i2++;
                        }
                        iyVar.h();
                        break;
                    }
                    jb.a(iyVar, a2.a);
                    break;
                case 12:
                    if (a2.a == 2) {
                        this.f612a = iyVar.m556a();
                        e(true);
                        break;
                    }
                    jb.a(iyVar, a2.a);
                    break;
                case 13:
                    if (a2.a == 13) {
                        ix a5 = iyVar.m549a();
                        this.f618c = new HashMap(a5.f879a * 2);
                        while (i2 < a5.f879a) {
                            this.f618c.put(iyVar.m552a(), iyVar.m552a());
                            i2++;
                        }
                        iyVar.h();
                        break;
                    }
                    jb.a(iyVar, a2.a);
                    break;
                default:
                    jb.a(iyVar, a2.a);
                    break;
            }
            iyVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f611a == null) {
            this.f611a = new HashMap();
        }
        this.f611a.put(str, str2);
    }

    public void a(boolean z) {
        this.f610a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m425a() {
        return this.f609a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m426a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        boolean a2 = m425a();
        boolean a3 = hpVar.m425a();
        if (((a2 || a3) && (!a2 || !a3 || !this.f609a.equals(hpVar.f609a))) || this.f608a != hpVar.f608a) {
            return false;
        }
        boolean c2 = m431c();
        boolean c3 = hpVar.m431c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f614b.equals(hpVar.f614b))) {
            return false;
        }
        boolean d2 = m432d();
        boolean d3 = hpVar.m432d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f617c.equals(hpVar.f617c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hpVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f619d.equals(hpVar.f619d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hpVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f607a != hpVar.f607a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hpVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f620e.equals(hpVar.f620e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hpVar.h();
        if ((h2 || h3) && (!h2 || !h3 || this.f613b != hpVar.f613b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hpVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.f616c != hpVar.f616c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hpVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f611a.equals(hpVar.f611a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hpVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f615b.equals(hpVar.f615b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hpVar.m();
        if ((m2 || m3) && (!m2 || !m3 || this.f612a != hpVar.f612a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = hpVar.n();
        if (n || n2) {
            return n && n2 && this.f618c.equals(hpVar.f618c);
        }
        return true;
    }

    public int b() {
        return this.f613b;
    }

    public hp b(int i2) {
        this.f613b = i2;
        c(true);
        return this;
    }

    public hp b(String str) {
        this.f614b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m427b() {
        return this.f614b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m428b() {
        return this.f615b;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m424a();
        iyVar.a(f606a);
        if (this.f609a != null) {
            iyVar.a(a);
            iyVar.a(this.f609a);
            iyVar.b();
        }
        iyVar.a(b);
        iyVar.a(this.f608a);
        iyVar.b();
        if (this.f614b != null && m431c()) {
            iyVar.a(c);
            iyVar.a(this.f614b);
            iyVar.b();
        }
        if (this.f617c != null && m432d()) {
            iyVar.a(d);
            iyVar.a(this.f617c);
            iyVar.b();
        }
        if (this.f619d != null && e()) {
            iyVar.a(e);
            iyVar.a(this.f619d);
            iyVar.b();
        }
        if (f()) {
            iyVar.a(f);
            iyVar.mo543a(this.f607a);
            iyVar.b();
        }
        if (this.f620e != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f620e);
            iyVar.b();
        }
        if (h()) {
            iyVar.a(h);
            iyVar.mo543a(this.f613b);
            iyVar.b();
        }
        if (i()) {
            iyVar.a(i);
            iyVar.mo543a(this.f616c);
            iyVar.b();
        }
        if (this.f611a != null && j()) {
            iyVar.a(j);
            iyVar.a(new ix((byte) 11, (byte) 11, this.f611a.size()));
            for (Map.Entry<String, String> entry : this.f611a.entrySet()) {
                iyVar.a(entry.getKey());
                iyVar.a(entry.getValue());
            }
            iyVar.d();
            iyVar.b();
        }
        if (this.f615b != null && k()) {
            iyVar.a(k);
            iyVar.a(new ix((byte) 11, (byte) 11, this.f615b.size()));
            for (Map.Entry<String, String> entry2 : this.f615b.entrySet()) {
                iyVar.a(entry2.getKey());
                iyVar.a(entry2.getValue());
            }
            iyVar.d();
            iyVar.b();
        }
        if (m()) {
            iyVar.a(f1505l);
            iyVar.a(this.f612a);
            iyVar.b();
        }
        if (this.f618c != null && n()) {
            iyVar.a(m);
            iyVar.a(new ix((byte) 11, (byte) 11, this.f618c.size()));
            for (Map.Entry<String, String> entry3 : this.f618c.entrySet()) {
                iyVar.a(entry3.getKey());
                iyVar.a(entry3.getValue());
            }
            iyVar.d();
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public void b(String str, String str2) {
        if (this.f615b == null) {
            this.f615b = new HashMap();
        }
        this.f615b.put(str, str2);
    }

    public void b(boolean z) {
        this.f610a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m429b() {
        return this.f610a.get(0);
    }

    public int c() {
        return this.f616c;
    }

    public hp c(int i2) {
        this.f616c = i2;
        d(true);
        return this;
    }

    public hp c(String str) {
        this.f617c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m430c() {
        return this.f617c;
    }

    public void c(boolean z) {
        this.f610a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m431c() {
        return this.f614b != null;
    }

    public hp d(String str) {
        this.f619d = str;
        return this;
    }

    public String d() {
        return this.f619d;
    }

    public void d(boolean z) {
        this.f610a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m432d() {
        return this.f617c != null;
    }

    public void e(boolean z) {
        this.f610a.set(4, z);
    }

    public boolean e() {
        return this.f619d != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m426a((hp) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f610a.get(1);
    }

    public boolean g() {
        return this.f620e != null;
    }

    public boolean h() {
        return this.f610a.get(2);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f610a.get(3);
    }

    public boolean j() {
        return this.f611a != null;
    }

    public boolean k() {
        return this.f615b != null;
    }

    public boolean l() {
        return this.f612a;
    }

    public boolean m() {
        return this.f610a.get(4);
    }

    public boolean n() {
        return this.f618c != null;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f609a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f608a);
        if (m431c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f614b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (m432d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f617c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f619d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f607a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f620e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f613b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f616c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f611a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f615b;
            if (map2 == null) {
                sb.append("null");
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f612a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f618c;
            if (map3 == null) {
                sb.append("null");
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
