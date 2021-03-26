package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: UMEnvelope */
public class bb implements bi<bb, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;
    public static final Map<e, bu> k;
    private static final long l = 420342210744516016L;
    private static final cm m = new cm("UMEnvelope");
    private static final cc n = new cc("version", (byte) 11, 1);
    private static final cc o = new cc("address", (byte) 11, 2);
    private static final cc p = new cc("signature", (byte) 11, 3);
    private static final cc q = new cc("serial_num", (byte) 8, 4);
    private static final cc r = new cc("ts_secs", (byte) 8, 5);
    private static final cc s = new cc("length", (byte) 8, 6);
    private static final cc t = new cc("entity", (byte) 11, 7);
    private static final cc u = new cc("guid", (byte) 11, 8);
    private static final cc v = new cc("checksum", (byte) 11, 9);
    private static final cc w = new cc("codex", (byte) 8, 10);
    private static final Map<Class<? extends cp>, cq> x;
    private static final int y = 0;
    private static final int z = 1;
    private byte C;
    private e[] D;
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public ByteBuffer g;
    public String h;
    public String i;
    public int j;

    static {
        HashMap hashMap = new HashMap();
        x = hashMap;
        hashMap.put(cr.class, new b());
        hashMap.put(cs.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.VERSION, (e) new bu("version", (byte) 1, new bv((byte) 11)));
        enumMap.put((EnumMap) e.ADDRESS, (e) new bu("address", (byte) 1, new bv((byte) 11)));
        enumMap.put((EnumMap) e.SIGNATURE, (e) new bu("signature", (byte) 1, new bv((byte) 11)));
        enumMap.put((EnumMap) e.SERIAL_NUM, (e) new bu("serial_num", (byte) 1, new bv((byte) 8)));
        enumMap.put((EnumMap) e.TS_SECS, (e) new bu("ts_secs", (byte) 1, new bv((byte) 8)));
        enumMap.put((EnumMap) e.LENGTH, (e) new bu("length", (byte) 1, new bv((byte) 8)));
        enumMap.put((EnumMap) e.ENTITY, (e) new bu("entity", (byte) 1, new bv((byte) 11, true)));
        enumMap.put((EnumMap) e.GUID, (e) new bu("guid", (byte) 1, new bv((byte) 11)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new bu("checksum", (byte) 1, new bv((byte) 11)));
        enumMap.put((EnumMap) e.CODEX, (e) new bu("codex", (byte) 2, new bv((byte) 8)));
        Map<e, bu> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        k = unmodifiableMap;
        bu.a(bb.class, unmodifiableMap);
    }

    /* compiled from: UMEnvelope */
    public enum e implements bp {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");
        
        private static final Map<String, e> k = new HashMap();
        private final short l;
        private final String m;

        static {
            Iterator it2 = EnumSet.allOf(e.class).iterator();
            while (it2.hasNext()) {
                e eVar = (e) it2.next();
                k.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
        }

        public static e b(int i) {
            e a = a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return k.get(str);
        }

        private e(short s, String str) {
            this.l = s;
            this.m = str;
        }

        @Override // com.umeng.analytics.pro.bp
        public short a() {
            return this.l;
        }

        @Override // com.umeng.analytics.pro.bp
        public String b() {
            return this.m;
        }
    }

    public bb() {
        this.C = 0;
        this.D = new e[]{e.CODEX};
    }

    public bb(String str, String str2, String str3, int i2, int i3, int i4, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i2;
        d(true);
        this.e = i3;
        e(true);
        this.f = i4;
        f(true);
        this.g = byteBuffer;
        this.h = str4;
        this.i = str5;
    }

    public bb(bb bbVar) {
        this.C = 0;
        this.D = new e[]{e.CODEX};
        this.C = bbVar.C;
        if (bbVar.d()) {
            this.a = bbVar.a;
        }
        if (bbVar.g()) {
            this.b = bbVar.b;
        }
        if (bbVar.j()) {
            this.c = bbVar.c;
        }
        this.d = bbVar.d;
        this.e = bbVar.e;
        this.f = bbVar.f;
        if (bbVar.w()) {
            this.g = bj.d(bbVar.g);
        }
        if (bbVar.z()) {
            this.h = bbVar.h;
        }
        if (bbVar.C()) {
            this.i = bbVar.i;
        }
        this.j = bbVar.j;
    }

    /* renamed from: a */
    public bb deepCopy() {
        return new bb(this);
    }

    @Override // com.umeng.analytics.pro.bi
    public void clear() {
        this.a = null;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0;
        e(false);
        this.e = 0;
        f(false);
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        j(false);
        this.j = 0;
    }

    public String b() {
        return this.a;
    }

    public bb a(String str) {
        this.a = str;
        return this;
    }

    public void c() {
        this.a = null;
    }

    public boolean d() {
        return this.a != null;
    }

    public void a(boolean z2) {
        if (!z2) {
            this.a = null;
        }
    }

    public String e() {
        return this.b;
    }

    public bb b(String str) {
        this.b = str;
        return this;
    }

    public void f() {
        this.b = null;
    }

    public boolean g() {
        return this.b != null;
    }

    public void b(boolean z2) {
        if (!z2) {
            this.b = null;
        }
    }

    public String h() {
        return this.c;
    }

    public bb c(String str) {
        this.c = str;
        return this;
    }

    public void i() {
        this.c = null;
    }

    public boolean j() {
        return this.c != null;
    }

    public void c(boolean z2) {
        if (!z2) {
            this.c = null;
        }
    }

    public int k() {
        return this.d;
    }

    public bb a(int i2) {
        this.d = i2;
        d(true);
        return this;
    }

    public void l() {
        this.C = bf.b(this.C, 0);
    }

    public boolean m() {
        return bf.a(this.C, 0);
    }

    public void d(boolean z2) {
        this.C = bf.a(this.C, 0, z2);
    }

    public int n() {
        return this.e;
    }

    public bb b(int i2) {
        this.e = i2;
        e(true);
        return this;
    }

    public void o() {
        this.C = bf.b(this.C, 1);
    }

    public boolean p() {
        return bf.a(this.C, 1);
    }

    public void e(boolean z2) {
        this.C = bf.a(this.C, 1, z2);
    }

    public int q() {
        return this.f;
    }

    public bb c(int i2) {
        this.f = i2;
        f(true);
        return this;
    }

    public void r() {
        this.C = bf.b(this.C, 2);
    }

    public boolean s() {
        return bf.a(this.C, 2);
    }

    public void f(boolean z2) {
        this.C = bf.a(this.C, 2, z2);
    }

    public byte[] t() {
        a(bj.c(this.g));
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public ByteBuffer u() {
        return this.g;
    }

    public bb a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public bb a(ByteBuffer byteBuffer) {
        this.g = byteBuffer;
        return this;
    }

    public void v() {
        this.g = null;
    }

    public boolean w() {
        return this.g != null;
    }

    public void g(boolean z2) {
        if (!z2) {
            this.g = null;
        }
    }

    public String x() {
        return this.h;
    }

    public bb d(String str) {
        this.h = str;
        return this;
    }

    public void y() {
        this.h = null;
    }

    public boolean z() {
        return this.h != null;
    }

    public void h(boolean z2) {
        if (!z2) {
            this.h = null;
        }
    }

    public String A() {
        return this.i;
    }

    public bb e(String str) {
        this.i = str;
        return this;
    }

    public void B() {
        this.i = null;
    }

    public boolean C() {
        return this.i != null;
    }

    public void i(boolean z2) {
        if (!z2) {
            this.i = null;
        }
    }

    public int D() {
        return this.j;
    }

    public bb d(int i2) {
        this.j = i2;
        j(true);
        return this;
    }

    public void E() {
        this.C = bf.b(this.C, 3);
    }

    public boolean F() {
        return bf.a(this.C, 3);
    }

    public void j(boolean z2) {
        this.C = bf.a(this.C, 3, z2);
    }

    /* renamed from: e */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    @Override // com.umeng.analytics.pro.bi
    public void read(ch chVar) throws bo {
        x.get(chVar.D()).b().b(chVar, this);
    }

    @Override // com.umeng.analytics.pro.bi
    public void write(ch chVar) throws bo {
        x.get(chVar.D()).b().a(chVar, this);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            bj.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }

    public void G() throws bo {
        if (this.a == null) {
            throw new ci("Required field 'version' was not present! Struct: " + toString());
        } else if (this.b == null) {
            throw new ci("Required field 'address' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new ci("Required field 'signature' was not present! Struct: " + toString());
        } else if (this.g == null) {
            throw new ci("Required field 'entity' was not present! Struct: " + toString());
        } else if (this.h == null) {
            throw new ci("Required field 'guid' was not present! Struct: " + toString());
        } else if (this.i == null) {
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
            this.C = 0;
            read(new cb(new ct(objectInputStream)));
        } catch (bo e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* compiled from: UMEnvelope */
    private static class b implements cq {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* compiled from: UMEnvelope */
    private static class a extends cr<bb> {
        private a() {
        }

        /* renamed from: a */
        public void b(ch chVar, bb bbVar) throws bo {
            chVar.j();
            while (true) {
                cc l = chVar.l();
                if (l.b == 0) {
                    chVar.k();
                    if (!bbVar.m()) {
                        throw new ci("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    } else if (!bbVar.p()) {
                        throw new ci("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    } else if (bbVar.s()) {
                        bbVar.G();
                        return;
                    } else {
                        throw new ci("Required field 'length' was not found in serialized data! Struct: " + toString());
                    }
                } else {
                    switch (l.c) {
                        case 1:
                            if (l.b != 11) {
                                ck.a(chVar, l.b);
                                break;
                            } else {
                                bbVar.a = chVar.z();
                                bbVar.a(true);
                                break;
                            }
                        case 2:
                            if (l.b != 11) {
                                ck.a(chVar, l.b);
                                break;
                            } else {
                                bbVar.b = chVar.z();
                                bbVar.b(true);
                                break;
                            }
                        case 3:
                            if (l.b != 11) {
                                ck.a(chVar, l.b);
                                break;
                            } else {
                                bbVar.c = chVar.z();
                                bbVar.c(true);
                                break;
                            }
                        case 4:
                            if (l.b != 8) {
                                ck.a(chVar, l.b);
                                break;
                            } else {
                                bbVar.d = chVar.w();
                                bbVar.d(true);
                                break;
                            }
                        case 5:
                            if (l.b != 8) {
                                ck.a(chVar, l.b);
                                break;
                            } else {
                                bbVar.e = chVar.w();
                                bbVar.e(true);
                                break;
                            }
                        case 6:
                            if (l.b != 8) {
                                ck.a(chVar, l.b);
                                break;
                            } else {
                                bbVar.f = chVar.w();
                                bbVar.f(true);
                                break;
                            }
                        case 7:
                            if (l.b != 11) {
                                ck.a(chVar, l.b);
                                break;
                            } else {
                                bbVar.g = chVar.A();
                                bbVar.g(true);
                                break;
                            }
                        case 8:
                            if (l.b != 11) {
                                ck.a(chVar, l.b);
                                break;
                            } else {
                                bbVar.h = chVar.z();
                                bbVar.h(true);
                                break;
                            }
                        case 9:
                            if (l.b != 11) {
                                ck.a(chVar, l.b);
                                break;
                            } else {
                                bbVar.i = chVar.z();
                                bbVar.i(true);
                                break;
                            }
                        case 10:
                            if (l.b != 8) {
                                ck.a(chVar, l.b);
                                break;
                            } else {
                                bbVar.j = chVar.w();
                                bbVar.j(true);
                                break;
                            }
                        default:
                            ck.a(chVar, l.b);
                            break;
                    }
                    chVar.m();
                }
            }
        }

        /* renamed from: b */
        public void a(ch chVar, bb bbVar) throws bo {
            bbVar.G();
            chVar.a(bb.m);
            if (bbVar.a != null) {
                chVar.a(bb.n);
                chVar.a(bbVar.a);
                chVar.c();
            }
            if (bbVar.b != null) {
                chVar.a(bb.o);
                chVar.a(bbVar.b);
                chVar.c();
            }
            if (bbVar.c != null) {
                chVar.a(bb.p);
                chVar.a(bbVar.c);
                chVar.c();
            }
            chVar.a(bb.q);
            chVar.a(bbVar.d);
            chVar.c();
            chVar.a(bb.r);
            chVar.a(bbVar.e);
            chVar.c();
            chVar.a(bb.s);
            chVar.a(bbVar.f);
            chVar.c();
            if (bbVar.g != null) {
                chVar.a(bb.t);
                chVar.a(bbVar.g);
                chVar.c();
            }
            if (bbVar.h != null) {
                chVar.a(bb.u);
                chVar.a(bbVar.h);
                chVar.c();
            }
            if (bbVar.i != null) {
                chVar.a(bb.v);
                chVar.a(bbVar.i);
                chVar.c();
            }
            if (bbVar.F()) {
                chVar.a(bb.w);
                chVar.a(bbVar.j);
                chVar.c();
            }
            chVar.d();
            chVar.b();
        }
    }

    /* compiled from: UMEnvelope */
    private static class d implements cq {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* compiled from: UMEnvelope */
    private static class c extends cs<bb> {
        private c() {
        }

        public void a(ch chVar, bb bbVar) throws bo {
            cn cnVar = (cn) chVar;
            cnVar.a(bbVar.a);
            cnVar.a(bbVar.b);
            cnVar.a(bbVar.c);
            cnVar.a(bbVar.d);
            cnVar.a(bbVar.e);
            cnVar.a(bbVar.f);
            cnVar.a(bbVar.g);
            cnVar.a(bbVar.h);
            cnVar.a(bbVar.i);
            BitSet bitSet = new BitSet();
            if (bbVar.F()) {
                bitSet.set(0);
            }
            cnVar.a(bitSet, 1);
            if (bbVar.F()) {
                cnVar.a(bbVar.j);
            }
        }

        public void b(ch chVar, bb bbVar) throws bo {
            cn cnVar = (cn) chVar;
            bbVar.a = cnVar.z();
            bbVar.a(true);
            bbVar.b = cnVar.z();
            bbVar.b(true);
            bbVar.c = cnVar.z();
            bbVar.c(true);
            bbVar.d = cnVar.w();
            bbVar.d(true);
            bbVar.e = cnVar.w();
            bbVar.e(true);
            bbVar.f = cnVar.w();
            bbVar.f(true);
            bbVar.g = cnVar.A();
            bbVar.g(true);
            bbVar.h = cnVar.z();
            bbVar.h(true);
            bbVar.i = cnVar.z();
            bbVar.i(true);
            if (cnVar.b(1).get(0)) {
                bbVar.j = cnVar.w();
                bbVar.j(true);
            }
        }
    }
}
