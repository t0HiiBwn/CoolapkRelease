package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.ce;
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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Imprint */
public class d implements bi<d, e>, Serializable, Cloneable {
    public static final Map<e, bu> d;
    private static final long e = 2846460275012375038L;
    private static final cm f = new cm("Imprint");
    private static final cc g = new cc("property", (byte) 13, 1);
    private static final cc h = new cc("version", (byte) 8, 2);
    private static final cc i = new cc("checksum", (byte) 11, 3);
    private static final Map<Class<? extends cp>, cq> j;
    private static final int k = 0;
    public Map<String, e> a;
    public int b;
    public String c;

    /* renamed from: l  reason: collision with root package name */
    private byte f1494l;

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(cr.class, new b());
        hashMap.put(cs.class, new C0154d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.PROPERTY, (e) new bu("property", (byte) 1, new bx((byte) 13, new bv((byte) 11), new bz((byte) 12, e.class))));
        enumMap.put((EnumMap) e.VERSION, (e) new bu("version", (byte) 1, new bv((byte) 8)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new bu("checksum", (byte) 1, new bv((byte) 11)));
        Map<e, bu> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        bu.a(d.class, unmodifiableMap);
    }

    /* compiled from: Imprint */
    public enum e implements bp {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");
        
        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            Iterator it2 = EnumSet.allOf(e.class).iterator();
            while (it2.hasNext()) {
                e eVar = (e) it2.next();
                d.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            if (i == 1) {
                return PROPERTY;
            }
            if (i == 2) {
                return VERSION;
            }
            if (i != 3) {
                return null;
            }
            return CHECKSUM;
        }

        public static e b(int i) {
            e a = a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return d.get(str);
        }

        private e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        @Override // com.umeng.analytics.pro.bp
        public short a() {
            return this.e;
        }

        @Override // com.umeng.analytics.pro.bp
        public String b() {
            return this.f;
        }
    }

    public d() {
        this.f1494l = 0;
    }

    public d(Map<String, e> map, int i2, String str) {
        this();
        this.a = map;
        this.b = i2;
        b(true);
        this.c = str;
    }

    public d(d dVar) {
        this.f1494l = 0;
        this.f1494l = dVar.f1494l;
        if (dVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, e> entry : dVar.a.entrySet()) {
                hashMap.put(entry.getKey(), new e(entry.getValue()));
            }
            this.a = hashMap;
        }
        this.b = dVar.b;
        if (dVar.k()) {
            this.c = dVar.c;
        }
    }

    /* renamed from: a */
    public d deepCopy() {
        return new d(this);
    }

    @Override // com.umeng.analytics.pro.bi
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0;
        this.c = null;
    }

    public int b() {
        Map<String, e> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public void a(String str, e eVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, eVar);
    }

    public Map<String, e> c() {
        return this.a;
    }

    public d a(Map<String, e> map) {
        this.a = map;
        return this;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public int f() {
        return this.b;
    }

    public d a(int i2) {
        this.b = i2;
        b(true);
        return this;
    }

    public void g() {
        this.f1494l = bf.b(this.f1494l, 0);
    }

    public boolean h() {
        return bf.a(this.f1494l, 0);
    }

    public void b(boolean z) {
        this.f1494l = bf.a(this.f1494l, 0, z);
    }

    public String i() {
        return this.c;
    }

    public d a(String str) {
        this.c = str;
        return this;
    }

    public void j() {
        this.c = null;
    }

    public boolean k() {
        return this.c != null;
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    /* renamed from: b */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    @Override // com.umeng.analytics.pro.bi
    public void read(ch chVar) throws bo {
        j.get(chVar.D()).b().b(chVar, this);
    }

    @Override // com.umeng.analytics.pro.bi
    public void write(ch chVar) throws bo {
        j.get(chVar.D()).b().a(chVar, this);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, e> map = this.a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    public void l() throws bo {
        if (this.a == null) {
            throw new ci("Required field 'property' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new ci("Required field 'checksum' was not present! Struct: " + toString());
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
            this.f1494l = 0;
            read(new cb(new ct(objectInputStream)));
        } catch (bo e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* compiled from: Imprint */
    private static class b implements cq {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* compiled from: Imprint */
    private static class a extends cr<d> {
        private a() {
        }

        /* renamed from: a */
        public void b(ch chVar, d dVar) throws bo {
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
                            ck.a(chVar, l2.b);
                        } else if (l2.b == 11) {
                            dVar.c = chVar.z();
                            dVar.c(true);
                        } else {
                            ck.a(chVar, l2.b);
                        }
                    } else if (l2.b == 8) {
                        dVar.b = chVar.w();
                        dVar.b(true);
                    } else {
                        ck.a(chVar, l2.b);
                    }
                } else if (l2.b == 13) {
                    ce n = chVar.n();
                    dVar.a = new HashMap(n.c * 2);
                    for (int i = 0; i < n.c; i++) {
                        String z = chVar.z();
                        e eVar = new e();
                        eVar.read(chVar);
                        dVar.a.put(z, eVar);
                    }
                    chVar.o();
                    dVar.a(true);
                } else {
                    ck.a(chVar, l2.b);
                }
                chVar.m();
            }
            chVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new ci("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        /* renamed from: b */
        public void a(ch chVar, d dVar) throws bo {
            dVar.l();
            chVar.a(d.f);
            if (dVar.a != null) {
                chVar.a(d.g);
                chVar.a(new ce((byte) 11, (byte) 12, dVar.a.size()));
                for (Map.Entry<String, e> entry : dVar.a.entrySet()) {
                    chVar.a(entry.getKey());
                    entry.getValue().write(chVar);
                }
                chVar.e();
                chVar.c();
            }
            chVar.a(d.h);
            chVar.a(dVar.b);
            chVar.c();
            if (dVar.c != null) {
                chVar.a(d.i);
                chVar.a(dVar.c);
                chVar.c();
            }
            chVar.d();
            chVar.b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d  reason: collision with other inner class name */
    /* compiled from: Imprint */
    private static class C0154d implements cq {
        private C0154d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* compiled from: Imprint */
    private static class c extends cs<d> {
        private c() {
        }

        public void a(ch chVar, d dVar) throws bo {
            cn cnVar = (cn) chVar;
            cnVar.a(dVar.a.size());
            for (Map.Entry<String, e> entry : dVar.a.entrySet()) {
                cnVar.a(entry.getKey());
                entry.getValue().write(cnVar);
            }
            cnVar.a(dVar.b);
            cnVar.a(dVar.c);
        }

        public void b(ch chVar, d dVar) throws bo {
            cn cnVar = (cn) chVar;
            ce ceVar = new ce((byte) 11, (byte) 12, cnVar.w());
            dVar.a = new HashMap(ceVar.c * 2);
            for (int i = 0; i < ceVar.c; i++) {
                String z = cnVar.z();
                e eVar = new e();
                eVar.read(cnVar);
                dVar.a.put(z, eVar);
            }
            dVar.a(true);
            dVar.b = cnVar.w();
            dVar.b(true);
            dVar.c = cnVar.z();
            dVar.c(true);
        }
    }
}
