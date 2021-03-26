package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ed implements hu<ed, Object>, Serializable, Cloneable {
    private static final il d = new il("StatsEvents");
    private static final id e = new id("", (byte) 11, 1);
    private static final id f = new id("", (byte) 11, 2);
    private static final id g = new id("", (byte) 15, 3);
    public String a;
    public String b;
    public List<ec> c;

    public ed() {
    }

    public ed(String str, List<ec> list) {
        this();
        this.a = str;
        this.c = list;
    }

    public ed a(String str) {
        this.b = str;
        return this;
    }

    @Override // com.xiaomi.push.hu
    public void a(ig igVar) {
        igVar.f();
        while (true) {
            id h = igVar.h();
            if (h.b == 0) {
                igVar.g();
                d();
                return;
            }
            short s = h.c;
            if (s != 1) {
                if (s != 2) {
                    if (s == 3 && h.b == 15) {
                        ie l = igVar.l();
                        this.c = new ArrayList(l.b);
                        for (int i = 0; i < l.b; i++) {
                            ec ecVar = new ec();
                            ecVar.a(igVar);
                            this.c.add(ecVar);
                        }
                        igVar.m();
                        igVar.i();
                    }
                } else if (h.b == 11) {
                    this.b = igVar.v();
                    igVar.i();
                }
            } else if (h.b == 11) {
                this.a = igVar.v();
                igVar.i();
            }
            ij.a(igVar, h.b);
            igVar.i();
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(ed edVar) {
        if (edVar == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = edVar.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(edVar.a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = edVar.b();
        if ((b2 || b3) && (!b2 || !b3 || !this.b.equals(edVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = edVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.c.equals(edVar.c);
        }
        return true;
    }

    /* renamed from: b */
    public int compareTo(ed edVar) {
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(edVar.getClass())) {
            return getClass().getName().compareTo(edVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(edVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a() && (a4 = hv.a(this.a, edVar.a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(edVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = hv.a(this.b, edVar.b)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(edVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a2 = hv.a(this.c, edVar.c)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hu
    public void b(ig igVar) {
        d();
        igVar.a(d);
        if (this.a != null) {
            igVar.a(e);
            igVar.a(this.a);
            igVar.b();
        }
        if (this.b != null && b()) {
            igVar.a(f);
            igVar.a(this.b);
            igVar.b();
        }
        if (this.c != null) {
            igVar.a(g);
            igVar.a(new ie((byte) 12, this.c.size()));
            for (ec ecVar : this.c) {
                ecVar.b(igVar);
            }
            igVar.e();
            igVar.b();
        }
        igVar.c();
        igVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c() {
        return this.c != null;
    }

    public void d() {
        if (this.a == null) {
            throw new ih("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new ih("Required field 'events' was not present! Struct: " + toString());
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ed)) {
            return a((ed) obj);
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
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<ec> list = this.c;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
