package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class hw implements in<hw, Object>, Serializable, Cloneable {
    private static final iv a = new iv("", (byte) 12, 2);

    /* renamed from: a  reason: collision with other field name */
    private static final jd f671a = new jd("XmPushActionCommand");
    private static final iv b = new iv("", (byte) 11, 3);
    private static final iv c = new iv("", (byte) 11, 4);
    private static final iv d = new iv("", (byte) 11, 5);
    private static final iv e = new iv("", (byte) 15, 6);
    private static final iv f = new iv("", (byte) 11, 7);
    private static final iv g = new iv("", (byte) 11, 9);
    private static final iv h = new iv("", (byte) 2, 10);
    private static final iv i = new iv("", (byte) 2, 11);
    private static final iv j = new iv("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    public long f672a;

    /* renamed from: a  reason: collision with other field name */
    public hr f673a;

    /* renamed from: a  reason: collision with other field name */
    public String f674a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f675a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public List<String> f676a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f677a = false;

    /* renamed from: b  reason: collision with other field name */
    public String f678b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f679b = true;

    /* renamed from: c  reason: collision with other field name */
    public String f680c;

    /* renamed from: d  reason: collision with other field name */
    public String f681d;

    /* renamed from: e  reason: collision with other field name */
    public String f682e;

    /* renamed from: a */
    public int compareTo(hw hwVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        if (!getClass().equals(hwVar.getClass())) {
            return getClass().getName().compareTo(hwVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m448a()).compareTo(Boolean.valueOf(hwVar.m448a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m448a() && (a11 = io.a(this.f673a, hwVar.f673a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hwVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a10 = io.a(this.f674a, hwVar.f674a)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hwVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a9 = io.a(this.f678b, hwVar.f678b)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hwVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a8 = io.a(this.f680c, hwVar.f680c)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a7 = io.a(this.f676a, hwVar.f676a)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (f() && (a6 = io.a(this.f681d, hwVar.f681d)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hwVar.g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (g() && (a5 = io.a(this.f682e, hwVar.f682e)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hwVar.h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (h() && (a4 = io.a(this.f677a, hwVar.f677a)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hwVar.i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (i() && (a3 = io.a(this.f679b, hwVar.f679b)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hwVar.j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!j() || (a2 = io.a(this.f672a, hwVar.f672a)) == 0) {
            return 0;
        }
        return a2;
    }

    public hw a(String str) {
        this.f674a = str;
        return this;
    }

    public hw a(List<String> list) {
        this.f676a = list;
        return this;
    }

    public String a() {
        return this.f680c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m446a() {
        if (this.f674a == null) {
            throw new iz("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f678b == null) {
            throw new iz("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f680c == null) {
            throw new iz("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.in
    public void a(iy iyVar) {
        iyVar.m551a();
        while (true) {
            iv a2 = iyVar.m547a();
            if (a2.a == 0) {
                iyVar.f();
                m446a();
                return;
            }
            switch (a2.f877a) {
                case 2:
                    if (a2.a == 12) {
                        hr hrVar = new hr();
                        this.f673a = hrVar;
                        hrVar.a(iyVar);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 3:
                    if (a2.a == 11) {
                        this.f674a = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 4:
                    if (a2.a == 11) {
                        this.f678b = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 5:
                    if (a2.a == 11) {
                        this.f680c = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 6:
                    if (a2.a == 15) {
                        iw a3 = iyVar.m548a();
                        this.f676a = new ArrayList(a3.f878a);
                        for (int i2 = 0; i2 < a3.f878a; i2++) {
                            this.f676a.add(iyVar.m552a());
                        }
                        iyVar.i();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 7:
                    if (a2.a == 11) {
                        this.f681d = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 9:
                    if (a2.a == 11) {
                        this.f682e = iyVar.m552a();
                        continue;
                        iyVar.g();
                    }
                    break;
                case 10:
                    if (a2.a == 2) {
                        this.f677a = iyVar.m556a();
                        a(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 11:
                    if (a2.a == 2) {
                        this.f679b = iyVar.m556a();
                        b(true);
                        continue;
                        iyVar.g();
                    }
                    break;
                case 12:
                    if (a2.a == 10) {
                        this.f672a = iyVar.m546a();
                        c(true);
                        continue;
                        iyVar.g();
                    }
                    break;
            }
            jb.a(iyVar, a2.a);
            iyVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m447a(String str) {
        if (this.f676a == null) {
            this.f676a = new ArrayList();
        }
        this.f676a.add(str);
    }

    public void a(boolean z) {
        this.f675a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m448a() {
        return this.f673a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m449a(hw hwVar) {
        if (hwVar == null) {
            return false;
        }
        boolean a2 = m448a();
        boolean a3 = hwVar.m448a();
        if ((a2 || a3) && (!a2 || !a3 || !this.f673a.m434a(hwVar.f673a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hwVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.f674a.equals(hwVar.f674a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hwVar.c();
        if ((c2 || c3) && (!c2 || !c3 || !this.f678b.equals(hwVar.f678b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hwVar.d();
        if ((d2 || d3) && (!d2 || !d3 || !this.f680c.equals(hwVar.f680c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hwVar.e();
        if ((e2 || e3) && (!e2 || !e3 || !this.f676a.equals(hwVar.f676a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hwVar.f();
        if ((f2 || f3) && (!f2 || !f3 || !this.f681d.equals(hwVar.f681d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hwVar.g();
        if ((g2 || g3) && (!g2 || !g3 || !this.f682e.equals(hwVar.f682e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hwVar.h();
        if ((h2 || h3) && (!h2 || !h3 || this.f677a != hwVar.f677a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hwVar.i();
        if ((i2 || i3) && (!i2 || !i3 || this.f679b != hwVar.f679b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hwVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f672a == hwVar.f672a;
        }
        return true;
    }

    public hw b(String str) {
        this.f678b = str;
        return this;
    }

    @Override // com.xiaomi.push.in
    public void b(iy iyVar) {
        m446a();
        iyVar.a(f671a);
        if (this.f673a != null && m448a()) {
            iyVar.a(a);
            this.f673a.b(iyVar);
            iyVar.b();
        }
        if (this.f674a != null) {
            iyVar.a(b);
            iyVar.a(this.f674a);
            iyVar.b();
        }
        if (this.f678b != null) {
            iyVar.a(c);
            iyVar.a(this.f678b);
            iyVar.b();
        }
        if (this.f680c != null) {
            iyVar.a(d);
            iyVar.a(this.f680c);
            iyVar.b();
        }
        if (this.f676a != null && e()) {
            iyVar.a(e);
            iyVar.a(new iw((byte) 11, this.f676a.size()));
            for (String str : this.f676a) {
                iyVar.a(str);
            }
            iyVar.e();
            iyVar.b();
        }
        if (this.f681d != null && f()) {
            iyVar.a(f);
            iyVar.a(this.f681d);
            iyVar.b();
        }
        if (this.f682e != null && g()) {
            iyVar.a(g);
            iyVar.a(this.f682e);
            iyVar.b();
        }
        if (h()) {
            iyVar.a(h);
            iyVar.a(this.f677a);
            iyVar.b();
        }
        if (i()) {
            iyVar.a(i);
            iyVar.a(this.f679b);
            iyVar.b();
        }
        if (j()) {
            iyVar.a(j);
            iyVar.a(this.f672a);
            iyVar.b();
        }
        iyVar.c();
        iyVar.m555a();
    }

    public void b(boolean z) {
        this.f675a.set(1, z);
    }

    public boolean b() {
        return this.f674a != null;
    }

    public hw c(String str) {
        this.f680c = str;
        return this;
    }

    public void c(boolean z) {
        this.f675a.set(2, z);
    }

    public boolean c() {
        return this.f678b != null;
    }

    public hw d(String str) {
        this.f681d = str;
        return this;
    }

    public boolean d() {
        return this.f680c != null;
    }

    public hw e(String str) {
        this.f682e = str;
        return this;
    }

    public boolean e() {
        return this.f676a != null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hw)) {
            return m449a((hw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f681d != null;
    }

    public boolean g() {
        return this.f682e != null;
    }

    public boolean h() {
        return this.f675a.get(0);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f675a.get(1);
    }

    public boolean j() {
        return this.f675a.get(2);
    }

    @Override // java.lang.Object
    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m448a()) {
            sb.append("target:");
            hr hrVar = this.f673a;
            if (hrVar == null) {
                sb.append("null");
            } else {
                sb.append(hrVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f674a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f678b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f680c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f676a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f681d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f682e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f677a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f679b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f672a);
        }
        sb.append(")");
        return sb.toString();
    }
}
