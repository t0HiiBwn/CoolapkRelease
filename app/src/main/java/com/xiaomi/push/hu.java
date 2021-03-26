package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class hu implements in<hu, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 8, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f665a = new jd("XmPushActionCheckClientInfo");
    private static final iv b = new iv("", (byte) 8, 2);

    /* renamed from: a  reason: collision with other field name */
    public int f666a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f667a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f668b;

    /* renamed from: a */
    public int compareTo(hu huVar) {
        int a2;
        int a3;
        if (!getClass().equals(huVar.getClass())) {
            return getClass().getName().compareTo(huVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m442a()).compareTo(Boolean.valueOf(huVar.m442a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m442a() && (a3 = io.a(this.f666a, huVar.f666a)) != 0) {
            return a3;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(huVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (!b() || (a2 = io.a(this.f668b, huVar.f668b)) == 0) {
            return 0;
        }
        return a2;
    }

    public hu a(int i) {
        this.f666a = i;
        a(true);
        return this;
    }

    public void a() {
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
                if (s == 2 && a2.a == 8) {
                    this.f668b = iyVar.m545a();
                    b(true);
                    iyVar.g();
                }
            } else if (a2.a == 8) {
                this.f666a = iyVar.m545a();
                a(true);
                iyVar.g();
            }
            jb.a(iyVar, a2.a);
            iyVar.g();
        }
        iyVar.f();
        if (!m442a()) {
            throw new iz("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        } else if (b()) {
            a();
        } else {
            throw new iz("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        this.f667a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m442a() {
        return this.f667a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m443a(hu huVar) {
        return huVar != null && this.f666a == huVar.f666a && this.f668b == huVar.f668b;
    }

    public hu b(int i) {
        this.f668b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        a();
        iyVar.a(f665a);
        iyVar.a(a);
        iyVar.mo543a(this.f666a);
        iyVar.b();
        iyVar.a(b);
        iyVar.mo543a(this.f668b);
        iyVar.b();
        iyVar.c();
        iyVar.m555a();
    }

    public void b(boolean z) {
        this.f667a.set(1, z);
    }

    public boolean b() {
        return this.f667a.get(1);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hu)) {
            return m443a((hu) obj);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f666a + ", pluginConfigVersion:" + this.f668b + ")";
    }
}
