package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class ht implements in<ht, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f653a = new jd("XmPushActionAckNotification");
    private static final iv b = new iv("", (byte) 12, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 11, 5);
    private static final iv f = new iv("", (byte) 10, 7);
    private static final iv g = new iv("", (byte) 11, 8);
    private static final iv h = new iv("", (byte) 13, 9);
    private static final iv i = new iv("", (byte) 11, 10);
    private static final iv j = new iv("", (byte) 11, 11);

    /* renamed from: a  reason: collision with other field name */
    public long f654a = 0;

    /* renamed from: a  reason: collision with other field name */
    public hr f655a;

    /* renamed from: a  reason: collision with other field name */
    public String f656a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f657a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f658a;

    /* renamed from: b  reason: collision with other field name */
    public String f659b;

    /* renamed from: c  reason: collision with other field name */
    public String f660c;

    /* renamed from: d  reason: collision with other field name */
    public String f661d;

    /* renamed from: e  reason: collision with other field name */
    public String f662e;

    /* renamed from: f  reason: collision with other field name */
    public String f663f;

    /* renamed from: g  reason: collision with other field name */
    public String f664g;

    /* renamed from: a */
    public int compareTo(ht htVar) {
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
        if (!getClass().equals(htVar.getClass())) {
            return getClass().getName().compareTo(htVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m439a()).compareTo(Boolean.valueOf(htVar.m439a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m439a() && (a11 = io.a(this.f656a, htVar.f656a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(m441b()).compareTo(Boolean.valueOf(htVar.m441b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m441b() && (a10 = io.a(this.f655a, htVar.f655a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(htVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = io.a(this.f659b, htVar.f659b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(htVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = io.a(this.f660c, htVar.f660c)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(htVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = io.a(this.f661d, htVar.f661d)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(htVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = io.a(this.f654a, htVar.f654a)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(htVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = io.a(this.f662e, htVar.f662e)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(htVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = io.a(this.f658a, htVar.f658a)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(htVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = io.a(this.f663f, htVar.f663f)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(htVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a2 = io.a(this.f664g, htVar.f664g)) == 0) {
            return 0;
        }
        return a2;
    }

    public ht a(long j2) {
        this.f654a = j2;
        a(true);
        return this;
    }

    public ht a(hr hrVar) {
        this.f655a = hrVar;
        return this;
    }

    public ht a(String str) {
        this.f659b = str;
        return this;
    }

    public String a() {
        return this.f659b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m437a() {
        return this.f658a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m438a() {
        if (this.f659b == null) {
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
                m438a();
                return;
            }
            switch (a2.f877a) {
                case 1:
                    if (a2.a == 11) {
                        this.f656a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 2:
                    if (a2.a == 12) {
                        hr hrVar = new hr();
                        this.f655a = hrVar;
                        hrVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f659b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f660c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 5:
                    if (a2.a == 11) {
                        this.f661d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 10) {
                        this.f654a = iyVar.m546a();
                        a(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 8:
                    if (a2.a == 11) {
                        this.f662e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 9:
                    if (a2.a == 13) {
                        ix a3 = iyVar.m549a();
                        this.f658a = new HashMap(a3.f879a * 2);
                        for (int i2 = 0; i2 < a3.f879a; i2++) {
                            this.f658a.put(iyVar.m552a(), iyVar.m552a());
                        }
                        iyVar.h();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 10:
                    if (a2.a == 11) {
                        this.f663f = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 11:
                    if (a2.a == 11) {
                        this.f664g = iyVar.m552a();
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
        this.f657a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m439a() {
        return this.f656a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m440a(ht htVar) {
        if (htVar == null) {
            return false;
        }
        boolean a2 = m439a();
        boolean a3 = htVar.m439a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f656a.equals(htVar.f656a))) {
            return false;
        }
        boolean b2 = m441b();
        boolean b3 = htVar.m441b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f655a.m434a(htVar.f655a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = htVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f659b.equals(htVar.f659b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = htVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f660c.equals(htVar.f660c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = htVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f661d.equals(htVar.f661d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = htVar.f();
        if ((f2 || f3) && (!f2 || !f3 || this.f654a != htVar.f654a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = htVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f662e.equals(htVar.f662e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = htVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f658a.equals(htVar.f658a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = htVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f663f.equals(htVar.f663f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = htVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f664g.equals(htVar.f664g);
        }
        return true;
    }

    public ht b(String str) {
        this.f660c = str;
        return this;
    }

    public String b() {
        return this.f661d;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m438a();
        iyVar.a(f653a);
        if (this.f656a != null && m439a()) {
            iyVar.a(a);
            iyVar.a(this.f656a);
            iyVar.b();
        }
        if (this.f655a != null && m441b()) {
            iyVar.a(b);
            this.f655a.b(iyVar);
            iyVar.b();
        }
        if (this.f659b != null) {
            iyVar.a(c);
            iyVar.a(this.f659b);
            iyVar.b();
        }
        if (this.f660c != null && d()) {
            iyVar.a(d);
            iyVar.a(this.f660c);
            iyVar.b();
        }
        if (this.f661d != null && e()) {
            iyVar.a(e);
            iyVar.a(this.f661d);
            iyVar.b();
        }
        if (f()) {
            iyVar.a(f);
            iyVar.a(this.f654a);
            iyVar.b();
        }
        if (this.f662e != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f662e);
            iyVar.b();
        }
        if (this.f658a != null && h()) {
            iyVar.a(h);
            iyVar.a(new ix((byte) 11, (byte) 11, this.f658a.size()));
            for (Map.Entry<String, String> entry : this.f658a.entrySet()) {
                iyVar.a(entry.getKey());
                iyVar.a(entry.getValue());
            }
            iyVar.d();
            iyVar.b();
        }
        if (this.f663f != null && i()) {
            iyVar.a(i);
            iyVar.a(this.f663f);
            iyVar.b();
        }
        if (this.f664g != null && j()) {
            iyVar.a(j);
            iyVar.a(this.f664g);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m441b() {
        return this.f655a != null;
    }

    public ht c(String str) {
        this.f661d = str;
        return this;
    }

    public boolean c() {
        return this.f659b != null;
    }

    public ht d(String str) {
        this.f662e = str;
        return this;
    }

    public boolean d() {
        return this.f660c != null;
    }

    public ht e(String str) {
        this.f663f = str;
        return this;
    }

    public boolean e() {
        return this.f661d != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ht)) {
            return m440a((ht) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f657a.get(0);
    }

    public boolean g() {
        return this.f662e != null;
    }

    public boolean h() {
        return this.f658a != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f663f != null;
    }

    public boolean j() {
        return this.f664g != null;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = false;
        if (m439a()) {
            sb.append("debug:");
            String str = this.f656a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m441b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hr hrVar = this.f655a;
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
        String str2 = this.f659b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f660c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f661d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f654a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.f662e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f658a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f663f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f664g;
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
