package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ez implements in<ez, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f434a = new jd("StatsEvents");
    private static final iv b = new iv("", (byte) 11, 2);
    private static final iv c = new iv("", (byte) 15, 3);

    /* renamed from: a  reason: collision with other field name */
    public String f435a;

    /* renamed from: a  reason: collision with other field name */
    public List<ey> f436a;

    /* renamed from: b  reason: collision with other field name */
    public String f437b;

    public ez() {
    }

    public ez(String str, List<ey> list) {
        this();
        this.f435a = str;
        this.f436a = list;
    }

    /* renamed from: a */
    public int compareTo(ez ezVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(ezVar.getClass())) {
            return getClass().getName().compareTo(ezVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m315a()).compareTo(Boolean.valueOf(ezVar.m315a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m315a() && (a4 = io.a(this.f435a, ezVar.f435a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ezVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = io.a(this.f437b, ezVar.f437b)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ezVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a2 = io.a(this.f436a, ezVar.f436a)) == 0) {
            return 0;
        }
        return a2;
    }

    public ez a(String str) {
        this.f437b = str;
        return this;
    }

    public void a() {
        if (this.f435a == null) {
            throw new iz("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f436a == null) {
            throw new iz("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                iyVar.f();
                a();
                return;
            }
            short s = a2.f877a;
            if (s != 1) {
                if (s != 2) {
                    if (s == 3 && a2.a == 15) {
                        iw a3 = iyVar.m548a();
                        this.f436a = new ArrayList(a3.f878a);
                        for (int i = 0; i < a3.f878a; i++) {
                            ey eyVar = new ey();
                            eyVar.a(iyVar);
                            this.f436a.add(eyVar);
                        }
                        iyVar.i();
                        iyVar.g();
                    }
                } else if (a2.a == 11) {
                    this.f437b = iyVar.m552a();
                    iyVar.g();
                }
            } else if (a2.a == 11) {
                this.f435a = iyVar.m552a();
                iyVar.g();
            }
            jb.a(iyVar, a2.a);
            iyVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m315a() {
        return this.f435a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m316a(ez ezVar) {
        if (ezVar == null) {
            return false;
        }
        boolean a2 = m315a();
        boolean a3 = ezVar.m315a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f435a.equals(ezVar.f435a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ezVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f437b.equals(ezVar.f437b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ezVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.f436a.equals(ezVar.f436a);
        }
        return true;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        a();
        iyVar.a(f434a);
        if (this.f435a != null) {
            iyVar.a(a);
            iyVar.a(this.f435a);
            iyVar.b();
        }
        if (this.f437b != null && b()) {
            iyVar.a(b);
            iyVar.a(this.f437b);
            iyVar.b();
        }
        if (this.f436a != null) {
            iyVar.a(c);
            iyVar.a(new iw((byte) 12, this.f436a.size()));
            for (ey eyVar : this.f436a) {
                eyVar.b(iyVar);
            }
            iyVar.e();
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public boolean b() {
        return this.f437b != null;
    }

    public boolean c() {
        return this.f436a != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ez)) {
            return m316a((ez) obj);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f435a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.f437b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<ey> list = this.f436a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
