package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class ib implements in<ib, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f711a = new jd("XmPushActionNotification");
    private static final iv b = new iv("", (byte) 12, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 11, 5);
    private static final iv f = new iv("", (byte) 2, 6);
    private static final iv g = new iv("", (byte) 11, 7);
    private static final iv h = new iv("", (byte) 13, 8);
    private static final iv i = new iv("", (byte) 11, 9);
    private static final iv j = new iv("", (byte) 11, 10);
    private static final iv k = new iv("", (byte) 11, 12);

    /* renamed from: l  reason: collision with root package name */
    private static final iv f1507l = new iv("", (byte) 11, 13);
    private static final iv m = new iv("", (byte) 11, 14);
    private static final iv n = new iv("", (byte) 10, 15);
    private static final iv o = new iv("", (byte) 2, 20);

    /* renamed from: a  reason: collision with other field name */
    public long f712a;

    /* renamed from: a  reason: collision with other field name */
    public hr f713a;

    /* renamed from: a  reason: collision with other field name */
    public String f714a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f715a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f716a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f717a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f718a;

    /* renamed from: b  reason: collision with other field name */
    public String f719b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f720b;

    /* renamed from: c  reason: collision with other field name */
    public String f721c;

    /* renamed from: d  reason: collision with other field name */
    public String f722d;

    /* renamed from: e  reason: collision with other field name */
    public String f723e;

    /* renamed from: f  reason: collision with other field name */
    public String f724f;

    /* renamed from: g  reason: collision with other field name */
    public String f725g;

    /* renamed from: h  reason: collision with other field name */
    public String f726h;

    /* renamed from: i  reason: collision with other field name */
    public String f727i;

    public ib() {
        this.f716a = new BitSet(3);
        this.f718a = true;
        this.f720b = false;
    }

    public ib(String str, boolean z) {
        this();
        this.f719b = str;
        this.f718a = z;
        m483a(true);
    }

    /* renamed from: a */
    public int compareTo(ib ibVar) {
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
        int a15;
        int a16;
        if (!getClass().equals(ibVar.getClass())) {
            return getClass().getName().compareTo(ibVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m484a()).compareTo(Boolean.valueOf(ibVar.m484a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m484a() && (a16 = io.a(this.f714a, ibVar.f714a)) != 0) {
            return a16;
        }
        int compareTo2 = Boolean.valueOf(m487b()).compareTo(Boolean.valueOf(ibVar.m487b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m487b() && (a15 = io.a(this.f713a, ibVar.f713a)) != 0) {
            return a15;
        }
        int compareTo3 = Boolean.valueOf(m488c()).compareTo(Boolean.valueOf(ibVar.m488c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m488c() && (a14 = io.a(this.f719b, ibVar.f719b)) != 0) {
            return a14;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ibVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a13 = io.a(this.f721c, ibVar.f721c)) != 0) {
            return a13;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ibVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a12 = io.a(this.f722d, ibVar.f722d)) != 0) {
            return a12;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ibVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a11 = io.a(this.f718a, ibVar.f718a)) != 0) {
            return a11;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ibVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a10 = io.a(this.f723e, ibVar.f723e)) != 0) {
            return a10;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ibVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a9 = io.a(this.f717a, ibVar.f717a)) != 0) {
            return a9;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ibVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a8 = io.a(this.f724f, ibVar.f724f)) != 0) {
            return a8;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ibVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (j() && (a7 = io.a(this.f725g, ibVar.f725g)) != 0) {
            return a7;
        }
        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ibVar.k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (k() && (a6 = io.a(this.f726h, ibVar.f726h)) != 0) {
            return a6;
        }
        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ibVar.l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (l() && (a5 = io.a(this.f727i, ibVar.f727i)) != 0) {
            return a5;
        }
        int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ibVar.m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m() && (a4 = io.a(this.f715a, ibVar.f715a)) != 0) {
            return a4;
        }
        int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ibVar.n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (n() && (a3 = io.a(this.f712a, ibVar.f712a)) != 0) {
            return a3;
        }
        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ibVar.o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (!o() || (a2 = io.a(this.f720b, ibVar.f720b)) == 0) {
            return 0;
        }
        return a2;
    }

    public hr a() {
        return this.f713a;
    }

    public ib a(String str) {
        this.f719b = str;
        return this;
    }

    public ib a(ByteBuffer byteBuffer) {
        this.f715a = byteBuffer;
        return this;
    }

    public ib a(Map<String, String> map) {
        this.f717a = map;
        return this;
    }

    public ib a(boolean z) {
        this.f718a = z;
        m483a(true);
        return this;
    }

    public ib a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m480a() {
        return this.f719b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m481a() {
        return this.f717a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m482a() {
        if (this.f719b == null) {
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
                if (f()) {
                    m482a();
                    return;
                }
                throw new iz("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (a2.f877a) {
                case 1:
                    if (a2.a == 11) {
                        this.f714a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 2:
                    if (a2.a == 12) {
                        hr hrVar = new hr();
                        this.f713a = hrVar;
                        hrVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f719b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f721c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 5:
                    if (a2.a == 11) {
                        this.f722d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 6:
                    if (a2.a == 2) {
                        this.f718a = iyVar.m556a();
                        m483a(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 11) {
                        this.f723e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 8:
                    if (a2.a == 13) {
                        ix a3 = iyVar.m549a();
                        this.f717a = new HashMap(a3.f879a * 2);
                        for (int i2 = 0; i2 < a3.f879a; i2++) {
                            this.f717a.put(iyVar.m552a(), iyVar.m552a());
                        }
                        iyVar.h();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 9:
                    if (a2.a == 11) {
                        this.f724f = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 10:
                    if (a2.a == 11) {
                        this.f725g = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 12:
                    if (a2.a == 11) {
                        this.f726h = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 13:
                    if (a2.a == 11) {
                        this.f727i = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 14:
                    if (a2.a == 11) {
                        this.f715a = iyVar.m553a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 15:
                    if (a2.a == 10) {
                        this.f712a = iyVar.m546a();
                        b(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 20:
                    if (a2.a == 2) {
                        this.f720b = iyVar.m556a();
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

    public void a(String str, String str2) {
        if (this.f717a == null) {
            this.f717a = new HashMap();
        }
        this.f717a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m483a(boolean z) {
        this.f716a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m484a() {
        return this.f714a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m485a(ib ibVar) {
        if (ibVar == null) {
            return false;
        }
        boolean a2 = m484a();
        boolean a3 = ibVar.m484a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f714a.equals(ibVar.f714a))) {
            return false;
        }
        boolean b2 = m487b();
        boolean b3 = ibVar.m487b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f713a.m434a(ibVar.f713a))) {
            return false;
        }
        boolean c2 = m488c();
        boolean c3 = ibVar.m488c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f719b.equals(ibVar.f719b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ibVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f721c.equals(ibVar.f721c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ibVar.e();
        if (((e2 || e3) && (!e2 || !e3 || !this.f722d.equals(ibVar.f722d))) || this.f718a != ibVar.f718a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ibVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f723e.equals(ibVar.f723e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ibVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f717a.equals(ibVar.f717a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ibVar.i();
        if ((i2 || i3) && (!i2 || !i3 || !this.f724f.equals(ibVar.f724f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ibVar.j();
        if ((j2 || j3) && (!j2 || !j3 || !this.f725g.equals(ibVar.f725g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ibVar.k();
        if ((k2 || k3) && (!k2 || !k3 || !this.f726h.equals(ibVar.f726h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ibVar.l();
        if ((l2 || l3) && (!l2 || !l3 || !this.f727i.equals(ibVar.f727i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ibVar.m();
        if ((m2 || m3) && (!m2 || !m3 || !this.f715a.equals(ibVar.f715a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ibVar.n();
        if ((n2 || n3) && (!n2 || !n3 || this.f712a != ibVar.f712a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ibVar.o();
        if (o2 || o3) {
            return o2 && o3 && this.f720b == ibVar.f720b;
        }
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m486a() {
        a(io.a(this.f715a));
        return this.f715a.array();
    }

    public ib b(String str) {
        this.f721c = str;
        return this;
    }

    public String b() {
        return this.f721c;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m482a();
        iyVar.a(f711a);
        if (this.f714a != null && m484a()) {
            iyVar.a(a);
            iyVar.a(this.f714a);
            iyVar.b();
        }
        if (this.f713a != null && m487b()) {
            iyVar.a(b);
            this.f713a.b(iyVar);
            iyVar.b();
        }
        if (this.f719b != null) {
            iyVar.a(c);
            iyVar.a(this.f719b);
            iyVar.b();
        }
        if (this.f721c != null && d()) {
            iyVar.a(d);
            iyVar.a(this.f721c);
            iyVar.b();
        }
        if (this.f722d != null && e()) {
            iyVar.a(e);
            iyVar.a(this.f722d);
            iyVar.b();
        }
        iyVar.a(f);
        iyVar.a(this.f718a);
        iyVar.b();
        if (this.f723e != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f723e);
            iyVar.b();
        }
        if (this.f717a != null && h()) {
            iyVar.a(h);
            iyVar.a(new ix((byte) 11, (byte) 11, this.f717a.size()));
            for (Map.Entry<String, String> entry : this.f717a.entrySet()) {
                iyVar.a(entry.getKey());
                iyVar.a(entry.getValue());
            }
            iyVar.d();
            iyVar.b();
        }
        if (this.f724f != null && i()) {
            iyVar.a(i);
            iyVar.a(this.f724f);
            iyVar.b();
        }
        if (this.f725g != null && j()) {
            iyVar.a(j);
            iyVar.a(this.f725g);
            iyVar.b();
        }
        if (this.f726h != null && k()) {
            iyVar.a(k);
            iyVar.a(this.f726h);
            iyVar.b();
        }
        if (this.f727i != null && l()) {
            iyVar.a(f1507l);
            iyVar.a(this.f727i);
            iyVar.b();
        }
        if (this.f715a != null && m()) {
            iyVar.a(m);
            iyVar.a(this.f715a);
            iyVar.b();
        }
        if (n()) {
            iyVar.a(n);
            iyVar.a(this.f712a);
            iyVar.b();
        }
        if (o()) {
            iyVar.a(o);
            iyVar.a(this.f720b);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public void b(boolean z) {
        this.f716a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m487b() {
        return this.f713a != null;
    }

    public ib c(String str) {
        this.f722d = str;
        return this;
    }

    public String c() {
        return this.f724f;
    }

    public void c(boolean z) {
        this.f716a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m488c() {
        return this.f719b != null;
    }

    public ib d(String str) {
        this.f724f = str;
        return this;
    }

    public boolean d() {
        return this.f721c != null;
    }

    public boolean e() {
        return this.f722d != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m485a((ib) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f716a.get(0);
    }

    public boolean g() {
        return this.f723e != null;
    }

    public boolean h() {
        return this.f717a != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f724f != null;
    }

    public boolean j() {
        return this.f725g != null;
    }

    public boolean k() {
        return this.f726h != null;
    }

    public boolean l() {
        return this.f727i != null;
    }

    public boolean m() {
        return this.f715a != null;
    }

    public boolean n() {
        return this.f716a.get(1);
    }

    public boolean o() {
        return this.f716a.get(2);
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = false;
        if (m484a()) {
            sb.append("debug:");
            String str = this.f714a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m487b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hr hrVar = this.f713a;
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
        String str2 = this.f719b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f721c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f722d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f718a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.f723e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f717a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f724f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f725g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f726h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f727i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f715a;
            if (byteBuffer == null) {
                sb.append("null");
            } else {
                io.a(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f712a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f720b);
        }
        sb.append(")");
        return sb.toString();
    }
}
