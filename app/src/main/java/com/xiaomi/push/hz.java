package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class hz implements in<hz, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 15, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f705a = new jd("XmPushActionCustomConfig");

    /* renamed from: a  reason: collision with other field name */
    public List<hn> f706a;

    /* renamed from: a */
    public int compareTo(hz hzVar) {
        int a2;
        if (!getClass().equals(hzVar.getClass())) {
            return getClass().getName().compareTo(hzVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m466a()).compareTo(Boolean.valueOf(hzVar.m466a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m466a() || (a2 = io.a(this.f706a, hzVar.f706a)) == 0) {
            return 0;
        }
        return a2;
    }

    public List<hn> a() {
        return this.f706a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m465a() {
        if (this.f706a == null) {
            throw new iz("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                iyVar.f();
                m465a();
                return;
            }
            if (a2.f877a == 1 && a2.a == 15) {
                iw a3 = iyVar.m548a();
                this.f706a = new ArrayList(a3.f878a);
                for (int i = 0; i < a3.f878a; i++) {
                    hn hnVar = new hn();
                    hnVar.a(iyVar);
                    this.f706a.add(hnVar);
                }
                iyVar.i();
            } else {
                jb.a(iyVar, a2.a);
            }
            iyVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m466a() {
        return this.f706a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m467a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean a2 = m466a();
        boolean a3 = hzVar.m466a();
        if (a2 || a3) {
            return a2 && a3 && this.f706a.equals(hzVar.f706a);
        }
        return true;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m465a();
        iyVar.a(f705a);
        if (this.f706a != null) {
            iyVar.a(a);
            iyVar.a(new iw((byte) 12, this.f706a.size()));
            for (hn hnVar : this.f706a) {
                hnVar.b(iyVar);
            }
            iyVar.e();
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m467a((hz) obj);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<hn> list = this.f706a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
