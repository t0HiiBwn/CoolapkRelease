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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IdSnapshot */
public class b implements bi<b, e>, Serializable, Cloneable {
    public static final Map<e, bu> d;
    private static final long e = -6496538196005191531L;
    private static final cm f = new cm("IdSnapshot");
    private static final cc g = new cc("identity", (byte) 11, 1);
    private static final cc h = new cc("ts", (byte) 10, 2);
    private static final cc i = new cc("version", (byte) 8, 3);
    private static final Map<Class<? extends cp>, cq> j;
    private static final int k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static final int f1493l = 1;
    public String a;
    public long b;
    public int c;
    private byte m;

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(cr.class, new C0152b());
        hashMap.put(cs.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.IDENTITY, (e) new bu("identity", (byte) 1, new bv((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new bu("ts", (byte) 1, new bv((byte) 10)));
        enumMap.put((EnumMap) e.VERSION, (e) new bu("version", (byte) 1, new bv((byte) 8)));
        Map<e, bu> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        bu.a(b.class, unmodifiableMap);
    }

    /* compiled from: IdSnapshot */
    public enum e implements bp {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");
        
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
                return IDENTITY;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return VERSION;
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

    public b() {
        this.m = 0;
    }

    public b(String str, long j2, int i2) {
        this();
        this.a = str;
        this.b = j2;
        b(true);
        this.c = i2;
        c(true);
    }

    public b(b bVar) {
        this.m = 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.a = bVar.a;
        }
        this.b = bVar.b;
        this.c = bVar.c;
    }

    /* renamed from: a */
    public b deepCopy() {
        return new b(this);
    }

    @Override // com.umeng.analytics.pro.bi
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0;
        c(false);
        this.c = 0;
    }

    public String b() {
        return this.a;
    }

    public b a(String str) {
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

    public long e() {
        return this.b;
    }

    public b a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public void f() {
        this.m = bf.b(this.m, 0);
    }

    public boolean g() {
        return bf.a(this.m, 0);
    }

    public void b(boolean z) {
        this.m = bf.a(this.m, 0, z);
    }

    public int h() {
        return this.c;
    }

    public b a(int i2) {
        this.c = i2;
        c(true);
        return this;
    }

    public void i() {
        this.m = bf.b(this.m, 1);
    }

    public boolean j() {
        return bf.a(this.m, 1);
    }

    public void c(boolean z) {
        this.m = bf.a(this.m, 1, z);
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
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.c);
        sb.append(")");
        return sb.toString();
    }

    public void k() throws bo {
        if (this.a == null) {
            throw new ci("Required field 'identity' was not present! Struct: " + toString());
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
            this.m = 0;
            read(new cb(new ct(objectInputStream)));
        } catch (bo e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b  reason: collision with other inner class name */
    /* compiled from: IdSnapshot */
    private static class C0152b implements cq {
        private C0152b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* compiled from: IdSnapshot */
    private static class a extends cr<b> {
        private a() {
        }

        /* renamed from: a */
        public void b(ch chVar, b bVar) throws bo {
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
                        } else if (l2.b == 8) {
                            bVar.c = chVar.w();
                            bVar.c(true);
                        } else {
                            ck.a(chVar, l2.b);
                        }
                    } else if (l2.b == 10) {
                        bVar.b = chVar.x();
                        bVar.b(true);
                    } else {
                        ck.a(chVar, l2.b);
                    }
                } else if (l2.b == 11) {
                    bVar.a = chVar.z();
                    bVar.a(true);
                } else {
                    ck.a(chVar, l2.b);
                }
                chVar.m();
            }
            chVar.k();
            if (!bVar.g()) {
                throw new ci("Required field 'ts' was not found in serialized data! Struct: " + toString());
            } else if (bVar.j()) {
                bVar.k();
            } else {
                throw new ci("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
        }

        /* renamed from: b */
        public void a(ch chVar, b bVar) throws bo {
            bVar.k();
            chVar.a(b.f);
            if (bVar.a != null) {
                chVar.a(b.g);
                chVar.a(bVar.a);
                chVar.c();
            }
            chVar.a(b.h);
            chVar.a(bVar.b);
            chVar.c();
            chVar.a(b.i);
            chVar.a(bVar.c);
            chVar.c();
            chVar.d();
            chVar.b();
        }
    }

    /* compiled from: IdSnapshot */
    private static class d implements cq {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* compiled from: IdSnapshot */
    private static class c extends cs<b> {
        private c() {
        }

        public void a(ch chVar, b bVar) throws bo {
            cn cnVar = (cn) chVar;
            cnVar.a(bVar.a);
            cnVar.a(bVar.b);
            cnVar.a(bVar.c);
        }

        public void b(ch chVar, b bVar) throws bo {
            cn cnVar = (cn) chVar;
            bVar.a = cnVar.z();
            bVar.a(true);
            bVar.b = cnVar.x();
            bVar.b(true);
            bVar.c = cnVar.w();
            bVar.c(true);
        }
    }
}
