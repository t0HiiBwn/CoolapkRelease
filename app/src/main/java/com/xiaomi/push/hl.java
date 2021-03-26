package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class hl implements in<hl, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 8, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f570a = new jd("NormalConfig");
    private static final iv b = new iv("", (byte) 15, 2);
    private static final iv c = new iv("", (byte) 8, 3);

    /* renamed from: a  reason: collision with other field name */
    public int f571a;

    /* renamed from: a  reason: collision with other field name */
    public hi f572a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f573a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hn> f574a;

    public int a() {
        return this.f571a;
    }

    /* renamed from: a */
    public int compareTo(hl hlVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(hlVar.getClass())) {
            return getClass().getName().compareTo(hlVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m405a()).compareTo(Boolean.valueOf(hlVar.m405a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m405a() && (a4 = io.a(this.f571a, hlVar.f571a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hlVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = io.a(this.f574a, hlVar.f574a)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hlVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a2 = io.a(this.f572a, hlVar.f572a)) == 0) {
            return 0;
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hi m403a() {
        return this.f572a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m404a() {
        if (this.f574a == null) {
            throw new iz("Required field 'configItems' was not present! Struct: " + toString());
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
                    if (s == 3 && a2.a == 8) {
                        this.f572a = hi.a(iyVar.m545a());
                        iyVar.g();
                    }
                } else if (a2.a == 15) {
                    iw a3 = iyVar.m548a();
                    this.f574a = new ArrayList(a3.f878a);
                    for (int i = 0; i < a3.f878a; i++) {
                        hn hnVar = new hn();
                        hnVar.a(iyVar);
                        this.f574a.add(hnVar);
                    }
                    iyVar.i();
                    iyVar.g();
                }
            } else if (a2.a == 8) {
                this.f571a = iyVar.m545a();
                a(true);
                iyVar.g();
            }
            jb.a(iyVar, a2.a);
            iyVar.g();
        }
        iyVar.f();
        if (m405a()) {
            m404a();
            return;
        }
        throw new iz("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f573a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m405a() {
        return this.f573a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m406a(hl hlVar) {
        if (hlVar == null || this.f571a != hlVar.f571a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hlVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f574a.equals(hlVar.f574a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hlVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.f572a.equals(hlVar.f572a);
        }
        return true;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m404a();
        iyVar.a(f570a);
        iyVar.a(a);
        iyVar.mo543a(this.f571a);
        iyVar.b();
        if (this.f574a != null) {
            iyVar.a(b);
            iyVar.a(new iw((byte) 12, this.f574a.size()));
            for (hn hnVar : this.f574a) {
                hnVar.b(iyVar);
            }
            iyVar.e();
            iyVar.b();
        }
        if (this.f572a != null && c()) {
            iyVar.a(c);
            iyVar.mo543a(this.f572a.a());
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public boolean b() {
        return this.f574a != null;
    }

    public boolean c() {
        return this.f572a != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hl)) {
            return m406a((hl) obj);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f571a);
        sb.append(", ");
        sb.append("configItems:");
        List<hn> list = this.f574a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            hi hiVar = this.f572a;
            if (hiVar == null) {
                sb.append("null");
            } else {
                sb.append(hiVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
