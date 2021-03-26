package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class hk implements in<hk, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 10, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f565a = new jd("DataCollectionItem");
    private static final iv b = new iv("", (byte) 8, 2);
    private static final iv c = new iv("", (byte) 11, 3);

    /* renamed from: a  reason: collision with other field name */
    public long f566a;

    /* renamed from: a  reason: collision with other field name */
    public he f567a;

    /* renamed from: a  reason: collision with other field name */
    public String f568a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f569a = new BitSet(1);

    /* renamed from: a */
    public int compareTo(hk hkVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(hkVar.getClass())) {
            return getClass().getName().compareTo(hkVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m401a()).compareTo(Boolean.valueOf(hkVar.m401a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m401a() && (a4 = io.a(this.f566a, hkVar.f566a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hkVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = io.a(this.f567a, hkVar.f567a)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hkVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a2 = io.a(this.f568a, hkVar.f568a)) == 0) {
            return 0;
        }
        return a2;
    }

    public hk a(long j) {
        this.f566a = j;
        a(true);
        return this;
    }

    public hk a(he heVar) {
        this.f567a = heVar;
        return this;
    }

    public hk a(String str) {
        this.f568a = str;
        return this;
    }

    public String a() {
        return this.f568a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m400a() {
        if (this.f567a == null) {
            throw new iz("Required field 'collectionType' was not present! Struct: " + toString());
        } else if (this.f568a == null) {
            throw new iz("Required field 'content' was not present! Struct: " + toString());
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
                    if (s == 3 && a2.a == 11) {
                        this.f568a = iyVar.m552a();
                        iyVar.g();
                    }
                } else if (a2.a == 8) {
                    this.f567a = he.a(iyVar.m545a());
                    iyVar.g();
                }
            } else if (a2.a == 10) {
                this.f566a = iyVar.m546a();
                a(true);
                iyVar.g();
            }
            jb.a(iyVar, a2.a);
            iyVar.g();
        }
        iyVar.f();
        if (m401a()) {
            m400a();
            return;
        }
        throw new iz("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f569a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m401a() {
        return this.f569a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m402a(hk hkVar) {
        if (hkVar == null || this.f566a != hkVar.f566a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hkVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f567a.equals(hkVar.f567a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hkVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.f568a.equals(hkVar.f568a);
        }
        return true;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m400a();
        iyVar.a(f565a);
        iyVar.a(a);
        iyVar.a(this.f566a);
        iyVar.b();
        if (this.f567a != null) {
            iyVar.a(b);
            iyVar.mo543a(this.f567a.a());
            iyVar.b();
        }
        if (this.f568a != null) {
            iyVar.a(c);
            iyVar.a(this.f568a);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public boolean b() {
        return this.f567a != null;
    }

    public boolean c() {
        return this.f568a != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m402a((hk) obj);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f566a);
        sb.append(", ");
        sb.append("collectionType:");
        he heVar = this.f567a;
        if (heVar == null) {
            sb.append("null");
        } else {
            sb.append(heVar);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.f568a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }
}
