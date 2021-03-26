package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: IdTracking */
public class c implements bi<c, e>, Serializable, Cloneable {
    public static final Map<e, bu> d;
    private static final long e = -5764118265293965743L;
    private static final cm f = new cm("IdTracking");
    private static final cc g = new cc("snapshots", (byte) 13, 1);
    private static final cc h = new cc("journals", (byte) 15, 2);
    private static final cc i = new cc("checksum", (byte) 11, 3);
    private static final Map<Class<? extends cp>, cq> j;
    public Map<String, b> a;
    public List<a> b;
    public String c;
    private e[] k;

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(cr.class, new b());
        hashMap.put(cs.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.SNAPSHOTS, (e) new bu("snapshots", (byte) 1, new bx((byte) 13, new bv((byte) 11), new bz((byte) 12, b.class))));
        enumMap.put((EnumMap) e.JOURNALS, (e) new bu("journals", (byte) 2, new bw((byte) 15, new bz((byte) 12, a.class))));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new bu("checksum", (byte) 2, new bv((byte) 11)));
        Map<e, bu> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        bu.a(c.class, unmodifiableMap);
    }

    /* compiled from: IdTracking */
    public enum e implements bp {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
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
                return SNAPSHOTS;
            }
            if (i == 2) {
                return JOURNALS;
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

    public c() {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    public c(Map<String, b> map) {
        this();
        this.a = map;
    }

    public c(c cVar) {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, b> entry : cVar.a.entrySet()) {
                hashMap.put(entry.getKey(), new b(entry.getValue()));
            }
            this.a = hashMap;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            for (a aVar : cVar.b) {
                arrayList.add(new a(aVar));
            }
            this.b = arrayList;
        }
        if (cVar.m()) {
            this.c = cVar.c;
        }
    }

    /* renamed from: a */
    public c deepCopy() {
        return new c(this);
    }

    @Override // com.umeng.analytics.pro.bi
    public void clear() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public int b() {
        Map<String, b> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public void a(String str, b bVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, bVar);
    }

    public Map<String, b> c() {
        return this.a;
    }

    public c a(Map<String, b> map) {
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
        List<a> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<a> g() {
        List<a> list = this.b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public void a(a aVar) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(aVar);
    }

    public List<a> h() {
        return this.b;
    }

    public c a(List<a> list) {
        this.b = list;
        return this;
    }

    public void i() {
        this.b = null;
    }

    public boolean j() {
        return this.b != null;
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public String k() {
        return this.c;
    }

    public c a(String str) {
        this.c = str;
        return this;
    }

    public void l() {
        this.c = null;
    }

    public boolean m() {
        return this.c != null;
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    /* renamed from: a */
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
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, b> map = this.a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<a> list = this.b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void n() throws bo {
        if (this.a == null) {
            throw new ci("Required field 'snapshots' was not present! Struct: " + toString());
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
            read(new cb(new ct(objectInputStream)));
        } catch (bo e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* compiled from: IdTracking */
    private static class b implements cq {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* compiled from: IdTracking */
    private static class a extends cr<c> {
        private a() {
        }

        /* renamed from: a */
        public void b(ch chVar, c cVar) throws bo {
            chVar.j();
            while (true) {
                cc l2 = chVar.l();
                if (l2.b == 0) {
                    chVar.k();
                    cVar.n();
                    return;
                }
                short s = l2.c;
                int i = 0;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            ck.a(chVar, l2.b);
                        } else if (l2.b == 11) {
                            cVar.c = chVar.z();
                            cVar.c(true);
                        } else {
                            ck.a(chVar, l2.b);
                        }
                    } else if (l2.b == 15) {
                        cd p = chVar.p();
                        cVar.b = new ArrayList(p.b);
                        while (i < p.b) {
                            a aVar = new a();
                            aVar.read(chVar);
                            cVar.b.add(aVar);
                            i++;
                        }
                        chVar.q();
                        cVar.b(true);
                    } else {
                        ck.a(chVar, l2.b);
                    }
                } else if (l2.b == 13) {
                    ce n = chVar.n();
                    cVar.a = new HashMap(n.c * 2);
                    while (i < n.c) {
                        String z = chVar.z();
                        b bVar = new b();
                        bVar.read(chVar);
                        cVar.a.put(z, bVar);
                        i++;
                    }
                    chVar.o();
                    cVar.a(true);
                } else {
                    ck.a(chVar, l2.b);
                }
                chVar.m();
            }
        }

        /* renamed from: b */
        public void a(ch chVar, c cVar) throws bo {
            cVar.n();
            chVar.a(c.f);
            if (cVar.a != null) {
                chVar.a(c.g);
                chVar.a(new ce((byte) 11, (byte) 12, cVar.a.size()));
                for (Map.Entry<String, b> entry : cVar.a.entrySet()) {
                    chVar.a(entry.getKey());
                    entry.getValue().write(chVar);
                }
                chVar.e();
                chVar.c();
            }
            if (cVar.b != null && cVar.j()) {
                chVar.a(c.h);
                chVar.a(new cd((byte) 12, cVar.b.size()));
                for (a aVar : cVar.b) {
                    aVar.write(chVar);
                }
                chVar.f();
                chVar.c();
            }
            if (cVar.c != null && cVar.m()) {
                chVar.a(c.i);
                chVar.a(cVar.c);
                chVar.c();
            }
            chVar.d();
            chVar.b();
        }
    }

    /* compiled from: IdTracking */
    private static class d implements cq {
        private d() {
        }

        /* renamed from: a */
        public C0153c b() {
            return new C0153c();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c  reason: collision with other inner class name */
    /* compiled from: IdTracking */
    private static class C0153c extends cs<c> {
        private C0153c() {
        }

        public void a(ch chVar, c cVar) throws bo {
            cn cnVar = (cn) chVar;
            cnVar.a(cVar.a.size());
            for (Map.Entry<String, b> entry : cVar.a.entrySet()) {
                cnVar.a(entry.getKey());
                entry.getValue().write(cnVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            cnVar.a(bitSet, 2);
            if (cVar.j()) {
                cnVar.a(cVar.b.size());
                for (a aVar : cVar.b) {
                    aVar.write(cnVar);
                }
            }
            if (cVar.m()) {
                cnVar.a(cVar.c);
            }
        }

        public void b(ch chVar, c cVar) throws bo {
            cn cnVar = (cn) chVar;
            ce ceVar = new ce((byte) 11, (byte) 12, cnVar.w());
            cVar.a = new HashMap(ceVar.c * 2);
            for (int i = 0; i < ceVar.c; i++) {
                String z = cnVar.z();
                b bVar = new b();
                bVar.read(cnVar);
                cVar.a.put(z, bVar);
            }
            cVar.a(true);
            BitSet b = cnVar.b(2);
            if (b.get(0)) {
                cd cdVar = new cd((byte) 12, cnVar.w());
                cVar.b = new ArrayList(cdVar.b);
                for (int i2 = 0; i2 < cdVar.b; i2++) {
                    a aVar = new a();
                    aVar.read(cnVar);
                    cVar.b.add(aVar);
                }
                cVar.b(true);
            }
            if (b.get(1)) {
                cVar.c = cnVar.z();
                cVar.c(true);
            }
        }
    }
}
