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

/* compiled from: ImprintValue */
public class e implements bi<e, EnumC0182e>, Serializable, Cloneable {
    public static final Map<EnumC0182e, bu> d;
    private static final long e = 7501688097813630241L;
    private static final cm f = new cm("ImprintValue");
    private static final cc g = new cc("value", (byte) 11, 1);
    private static final cc h = new cc("ts", (byte) 10, 2);
    private static final cc i = new cc("guid", (byte) 11, 3);
    private static final Map<Class<? extends cp>, cq> j;
    private static final int k = 0;
    public String a;
    public long b;
    public String c;
    private byte l;
    private EnumC0182e[] m;

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(cr.class, new b());
        hashMap.put(cs.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0182e.class);
        enumMap.put((EnumMap) EnumC0182e.VALUE, (EnumC0182e) new bu("value", (byte) 2, new bv((byte) 11)));
        enumMap.put((EnumMap) EnumC0182e.TS, (EnumC0182e) new bu("ts", (byte) 1, new bv((byte) 10)));
        enumMap.put((EnumMap) EnumC0182e.GUID, (EnumC0182e) new bu("guid", (byte) 1, new bv((byte) 11)));
        Map<EnumC0182e, bu> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        bu.a(e.class, unmodifiableMap);
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e  reason: collision with other inner class name */
    /* compiled from: ImprintValue */
    public enum EnumC0182e implements bp {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");
        
        private static final Map<String, EnumC0182e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            Iterator it2 = EnumSet.allOf(EnumC0182e.class).iterator();
            while (it2.hasNext()) {
                EnumC0182e eVar = (EnumC0182e) it2.next();
                d.put(eVar.b(), eVar);
            }
        }

        public static EnumC0182e a(int i) {
            if (i == 1) {
                return VALUE;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0182e b(int i) {
            EnumC0182e a = a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static EnumC0182e a(String str) {
            return d.get(str);
        }

        private EnumC0182e(short s, String str) {
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

    public e() {
        this.l = 0;
        this.m = new EnumC0182e[]{EnumC0182e.VALUE};
    }

    public e(long j2, String str) {
        this();
        this.b = j2;
        b(true);
        this.c = str;
    }

    public e(e eVar) {
        this.l = 0;
        this.m = new EnumC0182e[]{EnumC0182e.VALUE};
        this.l = eVar.l;
        if (eVar.d()) {
            this.a = eVar.a;
        }
        this.b = eVar.b;
        if (eVar.j()) {
            this.c = eVar.c;
        }
    }

    /* renamed from: a */
    public e deepCopy() {
        return new e(this);
    }

    @Override // com.umeng.analytics.pro.bi
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0;
        this.c = null;
    }

    public String b() {
        return this.a;
    }

    public e a(String str) {
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

    public e a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public void f() {
        this.l = bf.b(this.l, 0);
    }

    public boolean g() {
        return bf.a(this.l, 0);
    }

    public void b(boolean z) {
        this.l = bf.a(this.l, 0, z);
    }

    public String h() {
        return this.c;
    }

    public e b(String str) {
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

    /* renamed from: a */
    public EnumC0182e fieldForId(int i2) {
        return EnumC0182e.a(i2);
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
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    public void k() throws bo {
        if (this.c == null) {
            throw new ci("Required field 'guid' was not present! Struct: " + toString());
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
            this.l = 0;
            read(new cb(new ct(objectInputStream)));
        } catch (bo e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* compiled from: ImprintValue */
    private static class b implements cq {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* compiled from: ImprintValue */
    private static class a extends cr<e> {
        private a() {
        }

        /* renamed from: a */
        public void b(ch chVar, e eVar) throws bo {
            chVar.j();
            while (true) {
                cc l = chVar.l();
                if (l.b == 0) {
                    break;
                }
                short s = l.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            ck.a(chVar, l.b);
                        } else if (l.b == 11) {
                            eVar.c = chVar.z();
                            eVar.c(true);
                        } else {
                            ck.a(chVar, l.b);
                        }
                    } else if (l.b == 10) {
                        eVar.b = chVar.x();
                        eVar.b(true);
                    } else {
                        ck.a(chVar, l.b);
                    }
                } else if (l.b == 11) {
                    eVar.a = chVar.z();
                    eVar.a(true);
                } else {
                    ck.a(chVar, l.b);
                }
                chVar.m();
            }
            chVar.k();
            if (eVar.g()) {
                eVar.k();
                return;
            }
            throw new ci("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        /* renamed from: b */
        public void a(ch chVar, e eVar) throws bo {
            eVar.k();
            chVar.a(e.f);
            if (eVar.a != null && eVar.d()) {
                chVar.a(e.g);
                chVar.a(eVar.a);
                chVar.c();
            }
            chVar.a(e.h);
            chVar.a(eVar.b);
            chVar.c();
            if (eVar.c != null) {
                chVar.a(e.i);
                chVar.a(eVar.c);
                chVar.c();
            }
            chVar.d();
            chVar.b();
        }
    }

    /* compiled from: ImprintValue */
    private static class d implements cq {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* compiled from: ImprintValue */
    private static class c extends cs<e> {
        private c() {
        }

        public void a(ch chVar, e eVar) throws bo {
            cn cnVar = (cn) chVar;
            cnVar.a(eVar.b);
            cnVar.a(eVar.c);
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            cnVar.a(bitSet, 1);
            if (eVar.d()) {
                cnVar.a(eVar.a);
            }
        }

        public void b(ch chVar, e eVar) throws bo {
            cn cnVar = (cn) chVar;
            eVar.b = cnVar.x();
            eVar.b(true);
            eVar.c = cnVar.z();
            eVar.c(true);
            if (cnVar.b(1).get(0)) {
                eVar.a = cnVar.z();
                eVar.a(true);
            }
        }
    }
}
