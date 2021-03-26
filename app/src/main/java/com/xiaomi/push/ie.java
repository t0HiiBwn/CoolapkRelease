package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

public class ie implements in<ie, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 11, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f779a = new jd("XmPushActionSendFeedbackResult");
    private static final iv b = new iv("", (byte) 12, 2);
    private static final iv c = new iv("", (byte) 11, 3);
    private static final iv d = new iv("", (byte) 11, 4);
    private static final iv e = new iv("", (byte) 10, 6);
    private static final iv f = new iv("", (byte) 11, 7);
    private static final iv g = new iv("", (byte) 11, 8);

    /* renamed from: a  reason: collision with other field name */
    public long f780a;

    /* renamed from: a  reason: collision with other field name */
    public hr f781a;

    /* renamed from: a  reason: collision with other field name */
    public String f782a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f783a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f784b;

    /* renamed from: c  reason: collision with other field name */
    public String f785c;

    /* renamed from: d  reason: collision with other field name */
    public String f786d;

    /* renamed from: e  reason: collision with other field name */
    public String f787e;

    /* renamed from: a */
    public int compareTo(ie ieVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(ieVar.getClass())) {
            return getClass().getName().compareTo(ieVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m499a()).compareTo(Boolean.valueOf(ieVar.m499a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m499a() && (a8 = io.a(this.f782a, ieVar.f782a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ieVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a7 = io.a(this.f781a, ieVar.f781a)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ieVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a6 = io.a(this.f784b, ieVar.f784b)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ieVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a5 = io.a(this.f785c, ieVar.f785c)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ieVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a4 = io.a(this.f780a, ieVar.f780a)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ieVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a3 = io.a(this.f786d, ieVar.f786d)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ieVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!g() || (a2 = io.a(this.f787e, ieVar.f787e)) == 0) {
            return 0;
        }
        return a2;
    }

    public void a() {
        if (this.f784b == null) {
            throw new iz("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f785c == null) {
            throw new iz("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                iyVar.f();
                if (e()) {
                    a();
                    return;
                }
                throw new iz("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (a2.f877a) {
                case 1:
                    if (a2.a == 11) {
                        this.f782a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 2:
                    if (a2.a == 12) {
                        hr hrVar = new hr();
                        this.f781a = hrVar;
                        hrVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f784b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f785c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 6:
                    if (a2.a == 10) {
                        this.f780a = iyVar.m546a();
                        a(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 11) {
                        this.f786d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 8:
                    if (a2.a == 11) {
                        this.f787e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
            }
            jb.a(iyVar, a2.a);
            iyVar.g();
        }
    }

    public void a(boolean z) {
        this.f783a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m499a() {
        return this.f782a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m500a(ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean a2 = m499a();
        boolean a3 = ieVar.m499a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f782a.equals(ieVar.f782a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ieVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f781a.m434a(ieVar.f781a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ieVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f784b.equals(ieVar.f784b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ieVar.d();
        if (((d2 || d3) && (!d2 || !d3 || !this.f785c.equals(ieVar.f785c))) || this.f780a != ieVar.f780a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ieVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f786d.equals(ieVar.f786d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ieVar.g();
        if (g2 || g3) {
            return g2 && g3 && this.f787e.equals(ieVar.f787e);
        }
        return true;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        a();
        iyVar.a(f779a);
        if (this.f782a != null && m499a()) {
            iyVar.a(a);
            iyVar.a(this.f782a);
            iyVar.b();
        }
        if (this.f781a != null && b()) {
            iyVar.a(b);
            this.f781a.b(iyVar);
            iyVar.b();
        }
        if (this.f784b != null) {
            iyVar.a(c);
            iyVar.a(this.f784b);
            iyVar.b();
        }
        if (this.f785c != null) {
            iyVar.a(d);
            iyVar.a(this.f785c);
            iyVar.b();
        }
        iyVar.a(e);
        iyVar.a(this.f780a);
        iyVar.b();
        if (this.f786d != null && f()) {
            iyVar.a(f);
            iyVar.a(this.f786d);
            iyVar.b();
        }
        if (this.f787e != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f787e);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public boolean b() {
        return this.f781a != null;
    }

    public boolean c() {
        return this.f784b != null;
    }

    public boolean d() {
        return this.f785c != null;
    }

    public boolean e() {
        return this.f783a.get(0);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m500a((ie) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f786d != null;
    }

    public boolean g() {
        return this.f787e != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = false;
        if (m499a()) {
            sb.append("debug:");
            String str = this.f782a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hr hrVar = this.f781a;
            if (hrVar == null) {
                sb.append("null");
            } else {
                sb.append(hrVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f784b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f785c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f780a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f786d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f787e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
