package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class hf implements in<hf, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 15, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f544a = new jd("ClientUploadData");

    /* renamed from: a  reason: collision with other field name */
    public List<hg> f545a;

    public int a() {
        List<hg> list = this.f545a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: a */
    public int compareTo(hf hfVar) {
        int a2;
        if (!getClass().equals(hfVar.getClass())) {
            return getClass().getName().compareTo(hfVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m388a()).compareTo(Boolean.valueOf(hfVar.m388a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m388a() || (a2 = io.a(this.f545a, hfVar.f545a)) == 0) {
            return 0;
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m387a() {
        if (this.f545a == null) {
            throw new iz("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hg hgVar) {
        if (this.f545a == null) {
            this.f545a = new ArrayList();
        }
        this.f545a.add(hgVar);
    }

    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                iyVar.f();
                m387a();
                return;
            }
            if (a2.f877a == 1 && a2.a == 15) {
                iw a3 = iyVar.m548a();
                this.f545a = new ArrayList(a3.f878a);
                for (int i = 0; i < a3.f878a; i++) {
                    hg hgVar = new hg();
                    hgVar.a(iyVar);
                    this.f545a.add(hgVar);
                }
                iyVar.i();
            } else {
                jb.a(iyVar, a2.a);
            }
            iyVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m388a() {
        return this.f545a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m389a(hf hfVar) {
        if (hfVar == null) {
            return false;
        }
        boolean a2 = m388a();
        boolean a3 = hfVar.m388a();
        if (a2 || a3) {
            return a2 && a3 && this.f545a.equals(hfVar.f545a);
        }
        return true;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m387a();
        iyVar.a(f544a);
        if (this.f545a != null) {
            iyVar.a(a);
            iyVar.a(new iw((byte) 12, this.f545a.size()));
            for (hg hgVar : this.f545a) {
                hgVar.b(iyVar);
            }
            iyVar.e();
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hf)) {
            return m389a((hf) obj);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<hg> list = this.f545a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
