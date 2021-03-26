package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.ci;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cm;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.cp;
import com.umeng.analytics.pro.cq;
import com.umeng.analytics.pro.cr;
import com.umeng.analytics.pro.cs;
import com.umeng.analytics.pro.ct;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IdJournal */
public class a implements bi<a, e>, Serializable, Cloneable {
    public static final Map<e, bu> e;
    private static final long f = 9132678615281394583L;
    private static final cm g = new cm("IdJournal");
    private static final cc h = new cc("domain", (byte) 11, 1);
    private static final cc i = new cc("old_id", (byte) 11, 2);
    private static final cc j = new cc("new_id", (byte) 11, 3);
    private static final cc k = new cc("ts", (byte) 10, 4);

    /* renamed from: l  reason: collision with root package name */
    private static final Map<Class<? extends cp>, cq> f1492l;
    private static final int m = 0;
    public String a;
    public String b;
    public String c;
    public long d;
    private byte n;
    private e[] o;

    static {
        HashMap hashMap = new HashMap();
        f1492l = hashMap;
        hashMap.put(cr.class, new b());
        hashMap.put(cs.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.DOMAIN, (e) new bu("domain", (byte) 1, new bv((byte) 11)));
        enumMap.put((EnumMap) e.OLD_ID, (e) new bu("old_id", (byte) 2, new bv((byte) 11)));
        enumMap.put((EnumMap) e.NEW_ID, (e) new bu("new_id", (byte) 1, new bv((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new bu("ts", (byte) 1, new bv((byte) 10)));
        Map<e, bu> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        e = unmodifiableMap;
        bu.a(a.class, unmodifiableMap);
    }

    /* compiled from: IdJournal */
    public enum e implements bp {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");
        
        private static final Map<String, e> e = new HashMap();
        private final short f;
        private final String g;

        static {
            Iterator it2 = EnumSet.allOf(e.class).iterator();
            while (it2.hasNext()) {
                e eVar = (e) it2.next();
                e.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            if (i == 1) {
                return DOMAIN;
            }
            if (i == 2) {
                return OLD_ID;
            }
            if (i == 3) {
                return NEW_ID;
            }
            if (i != 4) {
                return null;
            }
            return TS;
        }

        public static e b(int i) {
            e a = a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return e.get(str);
        }

        private e(short s, String str) {
            this.f = s;
            this.g = str;
        }

        @Override // com.umeng.analytics.pro.bp
        public short a() {
            return this.f;
        }

        @Override // com.umeng.analytics.pro.bp
        public String b() {
            return this.g;
        }
    }

    public a() {
        this.n = 0;
        this.o = new e[]{e.OLD_ID};
    }

    public a(String str, String str2, long j2) {
        this();
        this.a = str;
        this.c = str2;
        this.d = j2;
        d(true);
    }

    public a(a aVar) {
        this.n = 0;
        this.o = new e[]{e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.a = aVar.a;
        }
        if (aVar.g()) {
            this.b = aVar.b;
        }
        if (aVar.j()) {
            this.c = aVar.c;
        }
        this.d = aVar.d;
    }

    /* renamed from: a */
    public a deepCopy() {
        return new a(this);
    }

    @Override // com.umeng.analytics.pro.bi
    public void clear() {
        this.a = null;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0;
    }

    public String b() {
        return this.a;
    }

    public a a(String str) {
        this.a = str;
        return this;
    }

    public void c() {
        this.a = null;
    }

    public boolean d() {
        return this.a != null;
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public String e() {
        return this.b;
    }

    public a b(String str) {
        this.b = str;
        return this;
    }

    public void f() {
        this.b = null;
    }

    public boolean g() {
        return this.b != null;
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public String h() {
        return this.c;
    }

    public a c(String str) {
        this.c = str;
        return this;
    }

    public void i() {
        this.c = null;
    }

    public boolean j() {
        return this.c != null;
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public long k() {
        return this.d;
    }

    public a a(long j2) {
        this.d = j2;
        d(true);
        return this;
    }

    public void l() {
        this.n = bf.b(this.n, 0);
    }

    public boolean m() {
        return bf.a(this.n, 0);
    }

    public void d(boolean z) {
        this.n = bf.a(this.n, 0, z);
    }

    /* renamed from: a */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    @Override // com.umeng.analytics.pro.bi
    public void read(ch chVar) throws bo {
        f1492l.get(chVar.D()).b().b(chVar, this);
    }

    @Override // com.umeng.analytics.pro.bi
    public void write(ch chVar) throws bo {
        f1492l.get(chVar.D()).b().a(chVar, this);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.d);
        sb.append(")");
        return sb.toString();
    }

    public void n() throws bo {
        if (this.a == null) {
            throw new ci("Required field 'domain' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new ci("Required field 'new_id' was not present! Struct: " + toString());
        }
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new cb(new ct(objectOutputStream)));
        } catch (bo e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.n = 0;
            read(new cb(new ct(objectInputStream)));
        } catch (bo e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* compiled from: IdJournal */
    private static class b implements cq {
        private b() {
        }

        /* renamed from: a */
        public C0151a b() {
            return new C0151a();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a  reason: collision with other inner class name */
    /* compiled from: IdJournal */
    private static class C0151a extends cr<a> {
        private C0151a() {
        }

        /* renamed from: a */
        public void b(ch chVar, a aVar) throws bo {
            chVar.j();
            while (true) {
                cc l2 = chVar.l();
                if (l2.b == 0) {
                    break;
                }
                short s = l2.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            if (s != 4) {
                                ck.a(chVar, l2.b);
                            } else if (l2.b == 10) {
                                aVar.d = chVar.x();
                                aVar.d(true);
                            } else {
                                ck.a(chVar, l2.b);
                            }
                        } else if (l2.b == 11) {
                            aVar.c = chVar.z();
                            aVar.c(true);
                        } else {
                            ck.a(chVar, l2.b);
                        }
                    } else if (l2.b == 11) {
                        aVar.b = chVar.z();
                        aVar.b(true);
                    } else {
                        ck.a(chVar, l2.b);
                    }
                } else if (l2.b == 11) {
                    aVar.a = chVar.z();
                    aVar.a(true);
                } else {
                    ck.a(chVar, l2.b);
                }
                chVar.m();
            }
            chVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new ci("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        /* renamed from: b */
        public void a(ch chVar, a aVar) throws bo {
            aVar.n();
            chVar.a(a.g);
            if (aVar.a != null) {
                chVar.a(a.h);
                chVar.a(aVar.a);
                chVar.c();
            }
            if (aVar.b != null && aVar.g()) {
                chVar.a(a.i);
                chVar.a(aVar.b);
                chVar.c();
            }
            if (aVar.c != null) {
                chVar.a(a.j);
                chVar.a(aVar.c);
                chVar.c();
            }
            chVar.a(a.k);
            chVar.a(aVar.d);
            chVar.c();
            chVar.d();
            chVar.b();
        }
    }

    /* compiled from: IdJournal */
    private static class d implements cq {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* compiled from: IdJournal */
    private static class c extends cs<a> {
        private c() {
        }

        public void a(ch chVar, a aVar) throws bo {
            cn cnVar = (cn) chVar;
            cnVar.a(aVar.a);
            cnVar.a(aVar.c);
            cnVar.a(aVar.d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            cnVar.a(bitSet, 1);
            if (aVar.g()) {
                cnVar.a(aVar.b);
            }
        }

        public void b(ch chVar, a aVar) throws bo {
            cn cnVar = (cn) chVar;
            aVar.a = cnVar.z();
            aVar.a(true);
            aVar.c = cnVar.z();
            aVar.c(true);
            aVar.d = cnVar.x();
            aVar.d(true);
            if (cnVar.b(1).get(0)) {
                aVar.b = cnVar.z();
                aVar.b(true);
            }
        }
    }
}
