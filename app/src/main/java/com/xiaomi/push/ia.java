package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ia implements in<ia, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 15, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f709a = new jd("XmPushActionNormalConfig");

    /* renamed from: a  reason: collision with other field name */
    public List<hl> f710a;

    /* renamed from: a */
    public int compareTo(ia iaVar) {
        int a2;
        if (!getClass().equals(iaVar.getClass())) {
            return getClass().getName().compareTo(iaVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m478a()).compareTo(Boolean.valueOf(iaVar.m478a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m478a() || (a2 = io.a(this.f710a, iaVar.f710a)) == 0) {
            return 0;
        }
        return a2;
    }

    public List<hl> a() {
        return this.f710a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m477a() {
        if (this.f710a == null) {
            throw new iz("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                iyVar.f();
                m477a();
                return;
            }
            if (a2.f877a == 1 && a2.a == 15) {
                iw a3 = iyVar.m548a();
                this.f710a = new ArrayList(a3.f878a);
                for (int i = 0; i < a3.f878a; i++) {
                    hl hlVar = new hl();
                    hlVar.a(iyVar);
                    this.f710a.add(hlVar);
                }
                iyVar.i();
            } else {
                jb.a(iyVar, a2.a);
            }
            iyVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m478a() {
        return this.f710a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m479a(ia iaVar) {
        if (iaVar == null) {
            return false;
        }
        boolean a2 = m478a();
        boolean a3 = iaVar.m478a();
        if (a2 || a3) {
            return a2 && a3 && this.f710a.equals(iaVar.f710a);
        }
        return true;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m477a();
        iyVar.a(f709a);
        if (this.f710a != null) {
            iyVar.a(a);
            iyVar.a(new iw((byte) 12, this.f710a.size()));
            for (hl hlVar : this.f710a) {
                hlVar.b(iyVar);
            }
            iyVar.e();
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ia)) {
            return m479a((ia) obj);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<hl> list = this.f710a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
