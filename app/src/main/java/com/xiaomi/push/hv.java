package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class hv implements in<hv, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 15, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f669a = new jd("XmPushActionCollectData");

    /* renamed from: a  reason: collision with other field name */
    public List<hk> f670a;

    /* renamed from: a */
    public int compareTo(hv hvVar) {
        int a2;
        if (!getClass().equals(hvVar.getClass())) {
            return getClass().getName().compareTo(hvVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m444a()).compareTo(Boolean.valueOf(hvVar.m444a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m444a() || (a2 = io.a(this.f670a, hvVar.f670a)) == 0) {
            return 0;
        }
        return a2;
    }

    public hv a(List<hk> list) {
        this.f670a = list;
        return this;
    }

    public void a() {
        if (this.f670a == null) {
            throw new iz("Required field 'dataCollectionItems' was not present! Struct: " + toString());
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
            if (a2.f877a == 1 && a2.a == 15) {
                iw a3 = iyVar.m548a();
                this.f670a = new ArrayList(a3.f878a);
                for (int i = 0; i < a3.f878a; i++) {
                    hk hkVar = new hk();
                    hkVar.a(iyVar);
                    this.f670a.add(hkVar);
                }
                iyVar.i();
            } else {
                jb.a(iyVar, a2.a);
            }
            iyVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m444a() {
        return this.f670a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m445a(hv hvVar) {
        if (hvVar == null) {
            return false;
        }
        boolean a2 = m444a();
        boolean a3 = hvVar.m444a();
        if (a2 || a3) {
            return a2 && a3 && this.f670a.equals(hvVar.f670a);
        }
        return true;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        a();
        iyVar.a(f669a);
        if (this.f670a != null) {
            iyVar.a(a);
            iyVar.a(new iw((byte) 12, this.f670a.size()));
            for (hk hkVar : this.f670a) {
                hkVar.b(iyVar);
            }
            iyVar.e();
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hv)) {
            return m445a((hv) obj);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<hk> list = this.f670a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
