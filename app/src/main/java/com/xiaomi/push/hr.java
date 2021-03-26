package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class hr implements in<hr, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 10, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f623a = new jd("Target");
    private static final iv b = new iv("", (byte) 11, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 2, 5);
    private static final iv f = new iv("", (byte) 11, 7);

    /* renamed from: a  reason: collision with other field name */
    public long f624a = 5;

    /* renamed from: a  reason: collision with other field name */
    public String f625a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f626a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f627a = false;

    /* renamed from: b  reason: collision with other field name */
    public String f628b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f629c = "";

    /* renamed from: d  reason: collision with other field name */
    public String f630d;

    /* renamed from: a */
    public int compareTo(hr hrVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (!getClass().equals(hrVar.getClass())) {
            return getClass().getName().compareTo(hrVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m433a()).compareTo(Boolean.valueOf(hrVar.m433a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m433a() && (a7 = io.a(this.f624a, hrVar.f624a)) != 0) {
            return a7;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hrVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a6 = io.a(this.f625a, hrVar.f625a)) != 0) {
            return a6;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hrVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a5 = io.a(this.f628b, hrVar.f628b)) != 0) {
            return a5;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hrVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a4 = io.a(this.f629c, hrVar.f629c)) != 0) {
            return a4;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hrVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a3 = io.a(this.f627a, hrVar.f627a)) != 0) {
            return a3;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hrVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (!f() || (a2 = io.a(this.f630d, hrVar.f630d)) == 0) {
            return 0;
        }
        return a2;
    }

    public void a() {
        if (this.f625a == null) {
            throw new iz("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                break;
            }
            short s = a2.f877a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        if (s != 4) {
                            if (s != 5) {
                                if (s == 7 && a2.a == 11) {
                                    this.f630d = iyVar.m552a();
                                    iyVar.g();
                                }
                            } else if (a2.a == 2) {
                                this.f627a = iyVar.m556a();
                                b(true);
                                iyVar.g();
                            }
                        } else if (a2.a == 11) {
                            this.f629c = iyVar.m552a();
                            iyVar.g();
                        }
                    } else if (a2.a == 11) {
                        this.f628b = iyVar.m552a();
                        iyVar.g();
                    }
                } else if (a2.a == 11) {
                    this.f625a = iyVar.m552a();
                    iyVar.g();
                }
            } else if (a2.a == 10) {
                this.f624a = iyVar.m546a();
                a(true);
                iyVar.g();
            }
            jb.a(iyVar, a2.a);
            iyVar.g();
        }
        iyVar.f();
        if (m433a()) {
            a();
            return;
        }
        throw new iz("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f626a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m433a() {
        return this.f626a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m434a(hr hrVar) {
        if (hrVar == null || this.f624a != hrVar.f624a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hrVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f625a.equals(hrVar.f625a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hrVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f628b.equals(hrVar.f628b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hrVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f629c.equals(hrVar.f629c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hrVar.e();
        if ((e2 || e3) && (!e2 || !e3 || this.f627a != hrVar.f627a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hrVar.f();
        if (f2 || f3) {
            return f2 && f3 && this.f630d.equals(hrVar.f630d);
        }
        return true;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        a();
        iyVar.a(f623a);
        iyVar.a(a);
        iyVar.a(this.f624a);
        iyVar.b();
        if (this.f625a != null) {
            iyVar.a(b);
            iyVar.a(this.f625a);
            iyVar.b();
        }
        if (this.f628b != null && c()) {
            iyVar.a(c);
            iyVar.a(this.f628b);
            iyVar.b();
        }
        if (this.f629c != null && d()) {
            iyVar.a(d);
            iyVar.a(this.f629c);
            iyVar.b();
        }
        if (e()) {
            iyVar.a(e);
            iyVar.a(this.f627a);
            iyVar.b();
        }
        if (this.f630d != null && f()) {
            iyVar.a(f);
            iyVar.a(this.f630d);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public void b(boolean z) {
        this.f626a.set(1, z);
    }

    public boolean b() {
        return this.f625a != null;
    }

    public boolean c() {
        return this.f628b != null;
    }

    public boolean d() {
        return this.f629c != null;
    }

    public boolean e() {
        return this.f626a.get(1);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hr)) {
            return m434a((hr) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f630d != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f624a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.f625a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.f628b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.f629c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f627a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f630d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
