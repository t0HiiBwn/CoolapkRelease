package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

public class hy implements in<hy, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 8, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f695a = new jd("XmPushActionContainer");
    private static final iv b = new iv("", (byte) 2, 2);
    private static final iv c = new iv("", (byte) 2, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 11, 5);
    private static final iv f = new iv("", (byte) 11, 6);
    private static final iv g = new iv("", (byte) 12, 7);
    private static final iv h = new iv("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    public hc f696a;

    /* renamed from: a  reason: collision with other field name */
    public hp f697a;

    /* renamed from: a  reason: collision with other field name */
    public hr f698a;

    /* renamed from: a  reason: collision with other field name */
    public String f699a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f700a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f701a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f702a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f703b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f704b = true;

    /* renamed from: a */
    public int compareTo(hy hyVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (!getClass().equals(hyVar.getClass())) {
            return getClass().getName().compareTo(hyVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m460a()).compareTo(Boolean.valueOf(hyVar.m460a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m460a() && (a9 = io.a(this.f696a, hyVar.f696a)) != 0) {
            return a9;
        }
        int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hyVar.c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (c() && (a8 = io.a(this.f702a, hyVar.f702a)) != 0) {
            return a8;
        }
        int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hyVar.d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (d() && (a7 = io.a(this.f704b, hyVar.f704b)) != 0) {
            return a7;
        }
        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hyVar.e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (e() && (a6 = io.a(this.f700a, hyVar.f700a)) != 0) {
            return a6;
        }
        int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hyVar.f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (f() && (a5 = io.a(this.f699a, hyVar.f699a)) != 0) {
            return a5;
        }
        int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hyVar.g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (g() && (a4 = io.a(this.f703b, hyVar.f703b)) != 0) {
            return a4;
        }
        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hyVar.h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (h() && (a3 = io.a(this.f698a, hyVar.f698a)) != 0) {
            return a3;
        }
        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hyVar.i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!i() || (a2 = io.a(this.f697a, hyVar.f697a)) == 0) {
            return 0;
        }
        return a2;
    }

    public hc a() {
        return this.f696a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hp m456a() {
        return this.f697a;
    }

    public hy a(hc hcVar) {
        this.f696a = hcVar;
        return this;
    }

    public hy a(hp hpVar) {
        this.f697a = hpVar;
        return this;
    }

    public hy a(hr hrVar) {
        this.f698a = hrVar;
        return this;
    }

    public hy a(String str) {
        this.f699a = str;
        return this;
    }

    public hy a(ByteBuffer byteBuffer) {
        this.f700a = byteBuffer;
        return this;
    }

    public hy a(boolean z) {
        this.f702a = z;
        m459a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m457a() {
        return this.f699a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m458a() {
        if (this.f696a == null) {
            throw new iz("Required field 'action' was not present! Struct: " + toString());
        } else if (this.f700a == null) {
            throw new iz("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.f698a == null) {
            throw new iz("Required field 'target' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                iyVar.f();
                if (!c()) {
                    throw new iz("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (d()) {
                    m458a();
                    return;
                } else {
                    throw new iz("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            } else {
                switch (a2.f877a) {
                    case 1:
                        if (a2.a == 8) {
                            this.f696a = hc.a(iyVar.m545a());
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 2:
                        if (a2.a == 2) {
                            this.f702a = iyVar.m556a();
                            m459a(true);
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 3:
                        if (a2.a == 2) {
                            this.f704b = iyVar.m556a();
                            m463b(true);
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 4:
                        if (a2.a == 11) {
                            this.f700a = iyVar.m553a();
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 5:
                        if (a2.a == 11) {
                            this.f699a = iyVar.m552a();
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 6:
                        if (a2.a == 11) {
                            this.f703b = iyVar.m552a();
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 7:
                        if (a2.a == 12) {
                            hr hrVar = new hr();
                            this.f698a = hrVar;
                            hrVar.a(iyVar);
                            continue;
                            iyVar.g();
                        }
                        break;
                    case 8:
                        if (a2.a == 12) {
                            hp hpVar = new hp();
                            this.f697a = hpVar;
                            hpVar.a(iyVar);
                            continue;
                            iyVar.g();
                        }
                        break;
                }
                jb.a(iyVar, a2.a);
                iyVar.g();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m459a(boolean z) {
        this.f701a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m460a() {
        return this.f696a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m461a(hy hyVar) {
        if (hyVar == null) {
            return false;
        }
        boolean a2 = m460a();
        boolean a3 = hyVar.m460a();
        if (((a2 || a3) && (!a2 || !a3 || !this.f696a.equals(hyVar.f696a))) || this.f702a != hyVar.f702a || this.f704b != hyVar.f704b) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hyVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f700a.equals(hyVar.f700a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hyVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f699a.equals(hyVar.f699a))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hyVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f703b.equals(hyVar.f703b))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hyVar.h();
        if ((h2 || h3) && (!h2 || !h3 || !this.f698a.m434a(hyVar.f698a))) {
            return false;
        }
        boolean i = i();
        boolean i2 = hyVar.i();
        if (i || i2) {
            return i && i2 && this.f697a.m426a(hyVar.f697a);
        }
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m462a() {
        a(io.a(this.f700a));
        return this.f700a.array();
    }

    public hy b(String str) {
        this.f703b = str;
        return this;
    }

    public hy b(boolean z) {
        this.f704b = z;
        m463b(true);
        return this;
    }

    public String b() {
        return this.f703b;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m458a();
        iyVar.a(f695a);
        if (this.f696a != null) {
            iyVar.a(a);
            iyVar.mo543a(this.f696a.a());
            iyVar.b();
        }
        iyVar.a(b);
        iyVar.a(this.f702a);
        iyVar.b();
        iyVar.a(c);
        iyVar.a(this.f704b);
        iyVar.b();
        if (this.f700a != null) {
            iyVar.a(d);
            iyVar.a(this.f700a);
            iyVar.b();
        }
        if (this.f699a != null && f()) {
            iyVar.a(e);
            iyVar.a(this.f699a);
            iyVar.b();
        }
        if (this.f703b != null && g()) {
            iyVar.a(f);
            iyVar.a(this.f703b);
            iyVar.b();
        }
        if (this.f698a != null) {
            iyVar.a(g);
            this.f698a.b(iyVar);
            iyVar.b();
        }
        if (this.f697a != null && i()) {
            iyVar.a(h);
            this.f697a.b(iyVar);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m463b(boolean z) {
        this.f701a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m464b() {
        return this.f702a;
    }

    public boolean c() {
        return this.f701a.get(0);
    }

    public boolean d() {
        return this.f701a.get(1);
    }

    public boolean e() {
        return this.f700a != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m461a((hy) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f699a != null;
    }

    public boolean g() {
        return this.f703b != null;
    }

    public boolean h() {
        return this.f698a != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f697a != null;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        hc hcVar = this.f696a;
        if (hcVar == null) {
            sb.append("null");
        } else {
            sb.append(hcVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f702a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f704b);
        sb.append(", ");
        sb.append("pushAction:");
        ByteBuffer byteBuffer = this.f700a;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            io.a(byteBuffer, sb);
        }
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f699a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f703b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        hr hrVar = this.f698a;
        if (hrVar == null) {
            sb.append("null");
        } else {
            sb.append(hrVar);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            hp hpVar = this.f697a;
            if (hpVar == null) {
                sb.append("null");
            } else {
                sb.append(hpVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
