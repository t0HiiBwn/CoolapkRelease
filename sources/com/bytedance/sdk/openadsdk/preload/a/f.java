package com.bytedance.sdk.openadsdk.preload.a;

import com.bytedance.sdk.openadsdk.preload.a.b.a.b;
import com.bytedance.sdk.openadsdk.preload.a.b.a.g;
import com.bytedance.sdk.openadsdk.preload.a.b.a.h;
import com.bytedance.sdk.openadsdk.preload.a.b.a.i;
import com.bytedance.sdk.openadsdk.preload.a.b.a.j;
import com.bytedance.sdk.openadsdk.preload.a.b.a.k;
import com.bytedance.sdk.openadsdk.preload.a.b.a.n;
import com.bytedance.sdk.openadsdk.preload.a.b.c;
import com.bytedance.sdk.openadsdk.preload.a.b.d;
import com.bytedance.sdk.openadsdk.preload.a.b.l;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson */
public final class f {
    private static final com.bytedance.sdk.openadsdk.preload.a.c.a<?> r = com.bytedance.sdk.openadsdk.preload.a.c.a.b(Object.class);
    final List<w> a;
    final d b;
    final e c;
    final Map<Type, h<?>> d;
    final boolean e;
    final boolean f;
    final boolean g;
    final boolean h;
    final boolean i;
    final boolean j;
    final boolean k;

    /* renamed from: l  reason: collision with root package name */
    final String f1338l;
    final int m;
    final int n;
    final u o;
    final List<w> p;
    final List<w> q;
    private final ThreadLocal<Map<com.bytedance.sdk.openadsdk.preload.a.c.a<?>, a<?>>> s;
    private final Map<com.bytedance.sdk.openadsdk.preload.a.c.a<?>, v<?>> t;
    private final c u;
    private final com.bytedance.sdk.openadsdk.preload.a.b.a.d v;

    public f() {
        this(d.a, d.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, u.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    f(d dVar, e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, u uVar, String str, int i2, int i3, List<w> list, List<w> list2, List<w> list3) {
        this.s = new ThreadLocal<>();
        this.t = new ConcurrentHashMap();
        this.b = dVar;
        this.c = eVar;
        this.d = map;
        c cVar = new c(map);
        this.u = cVar;
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = z4;
        this.i = z5;
        this.j = z6;
        this.k = z7;
        this.o = uVar;
        this.f1338l = str;
        this.m = i2;
        this.n = i3;
        this.p = list;
        this.q = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(n.Y);
        arrayList.add(h.a);
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(n.D);
        arrayList.add(n.m);
        arrayList.add(n.g);
        arrayList.add(n.i);
        arrayList.add(n.k);
        v<Number> a2 = a(uVar);
        arrayList.add(n.a(Long.TYPE, Long.class, a2));
        arrayList.add(n.a(Double.TYPE, Double.class, a(z7)));
        arrayList.add(n.a(Float.TYPE, Float.class, b(z7)));
        arrayList.add(n.x);
        arrayList.add(n.o);
        arrayList.add(n.q);
        arrayList.add(n.a(AtomicLong.class, a(a2)));
        arrayList.add(n.a(AtomicLongArray.class, b(a2)));
        arrayList.add(n.s);
        arrayList.add(n.z);
        arrayList.add(n.F);
        arrayList.add(n.H);
        arrayList.add(n.a(BigDecimal.class, n.B));
        arrayList.add(n.a(BigInteger.class, n.C));
        arrayList.add(n.J);
        arrayList.add(n.L);
        arrayList.add(n.P);
        arrayList.add(n.R);
        arrayList.add(n.W);
        arrayList.add(n.N);
        arrayList.add(n.d);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.c.a);
        arrayList.add(n.U);
        arrayList.add(k.a);
        arrayList.add(j.a);
        arrayList.add(n.S);
        arrayList.add(com.bytedance.sdk.openadsdk.preload.a.b.a.a.a);
        arrayList.add(n.b);
        arrayList.add(new b(cVar));
        arrayList.add(new g(cVar, z2));
        com.bytedance.sdk.openadsdk.preload.a.b.a.d dVar2 = new com.bytedance.sdk.openadsdk.preload.a.b.a.d(cVar);
        this.v = dVar2;
        arrayList.add(dVar2);
        arrayList.add(n.Z);
        arrayList.add(new i(cVar, eVar, dVar, dVar2));
        this.a = Collections.unmodifiableList(arrayList);
    }

    private v<Number> a(boolean z) {
        if (z) {
            return n.v;
        }
        return new v<Number>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.f.AnonymousClass1 */

            /* renamed from: a */
            public Double b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    return Double.valueOf(aVar.k());
                }
                aVar.j();
                return null;
            }

            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                    return;
                }
                f.a(number.doubleValue());
                cVar.a(number);
            }
        };
    }

    private v<Number> b(boolean z) {
        if (z) {
            return n.u;
        }
        return new v<Number>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.f.AnonymousClass2 */

            /* renamed from: a */
            public Float b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    return Float.valueOf((float) aVar.k());
                }
                aVar.j();
                return null;
            }

            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                    return;
                }
                f.a((double) number.floatValue());
                cVar.a(number);
            }
        };
    }

    static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static v<Number> a(u uVar) {
        if (uVar == u.DEFAULT) {
            return n.t;
        }
        return new v<Number>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.f.AnonymousClass3 */

            /* renamed from: a */
            public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    return Long.valueOf(aVar.l());
                }
                aVar.j();
                return null;
            }

            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                } else {
                    cVar.b(number.toString());
                }
            }
        };
    }

    private static v<AtomicLong> a(final v<Number> vVar) {
        return new v<AtomicLong>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.f.AnonymousClass4 */

            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, AtomicLong atomicLong) throws IOException {
                vVar.a(cVar, Long.valueOf(atomicLong.get()));
            }

            /* renamed from: a */
            public AtomicLong b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                return new AtomicLong(((Number) vVar.b(aVar)).longValue());
            }
        }.a();
    }

    private static v<AtomicLongArray> b(final v<Number> vVar) {
        return new v<AtomicLongArray>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.f.AnonymousClass5 */

            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, AtomicLongArray atomicLongArray) throws IOException {
                cVar.b();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    vVar.a(cVar, Long.valueOf(atomicLongArray.get(i)));
                }
                cVar.c();
            }

            /* renamed from: a */
            public AtomicLongArray b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(Long.valueOf(((Number) vVar.b(aVar)).longValue()));
                }
                aVar.b();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }
        }.a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.util.Map<com.bytedance.sdk.openadsdk.preload.a.c.a<?>, com.bytedance.sdk.openadsdk.preload.a.v<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r4v4. Raw type applied. Possible types: com.bytedance.sdk.openadsdk.preload.a.v<T>, com.bytedance.sdk.openadsdk.preload.a.v<?> */
    public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        v<T> vVar = (v<T>) this.t.get(aVar == null ? r : aVar);
        if (vVar != null) {
            return vVar;
        }
        Map<com.bytedance.sdk.openadsdk.preload.a.c.a<?>, a<?>> map = this.s.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.s.set(map);
            z = true;
        }
        a<?> aVar2 = map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            a<?> aVar3 = new a<>();
            map.put(aVar, aVar3);
            for (w wVar : this.a) {
                v vVar2 = (v<T>) wVar.a(this, aVar);
                if (vVar2 != null) {
                    aVar3.a((v<?>) vVar2);
                    this.t.put(aVar, vVar2);
                    return vVar2;
                }
            }
            throw new IllegalArgumentException("GSON (pangle-v3200) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z) {
                this.s.remove();
            }
        }
    }

    public <T> v<T> a(w wVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        if (!this.a.contains(wVar)) {
            wVar = this.v;
        }
        boolean z = false;
        for (w wVar2 : this.a) {
            if (z) {
                v<T> a2 = wVar2.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (wVar2 == wVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> v<T> a(Class<T> cls) {
        return a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.b(cls));
    }

    public String a(Object obj) {
        if (obj == null) {
            return a((l) n.a);
        }
        return a(obj, obj.getClass());
    }

    public String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Type type, Appendable appendable) throws m {
        try {
            a(obj, type, a(l.a(appendable)));
        } catch (IOException e2) {
            throw new m(e2);
        }
    }

    public void a(Object obj, Type type, com.bytedance.sdk.openadsdk.preload.a.d.c cVar) throws m {
        v a2 = a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(type));
        boolean g2 = cVar.g();
        cVar.b(true);
        boolean h2 = cVar.h();
        cVar.c(this.h);
        boolean i2 = cVar.i();
        cVar.d(this.e);
        try {
            a2.a(cVar, obj);
            cVar.b(g2);
            cVar.c(h2);
            cVar.d(i2);
        } catch (IOException e2) {
            throw new m(e2);
        } catch (AssertionError e3) {
            AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e3.getMessage());
            assertionError.initCause(e3);
            throw assertionError;
        } catch (Throwable th) {
            cVar.b(g2);
            cVar.c(h2);
            cVar.d(i2);
            throw th;
        }
    }

    public String a(l lVar) {
        StringWriter stringWriter = new StringWriter();
        a(lVar, stringWriter);
        return stringWriter.toString();
    }

    public void a(l lVar, Appendable appendable) throws m {
        try {
            a(lVar, a(l.a(appendable)));
        } catch (IOException e2) {
            throw new m(e2);
        }
    }

    public com.bytedance.sdk.openadsdk.preload.a.d.c a(Writer writer) throws IOException {
        if (this.g) {
            writer.write(")]}'\n");
        }
        com.bytedance.sdk.openadsdk.preload.a.d.c cVar = new com.bytedance.sdk.openadsdk.preload.a.d.c(writer);
        if (this.i) {
            cVar.c("  ");
        }
        cVar.d(this.e);
        return cVar;
    }

    public com.bytedance.sdk.openadsdk.preload.a.d.a a(Reader reader) {
        com.bytedance.sdk.openadsdk.preload.a.d.a aVar = new com.bytedance.sdk.openadsdk.preload.a.d.a(reader);
        aVar.a(this.j);
        return aVar;
    }

    public void a(l lVar, com.bytedance.sdk.openadsdk.preload.a.d.c cVar) throws m {
        boolean g2 = cVar.g();
        cVar.b(true);
        boolean h2 = cVar.h();
        cVar.c(this.h);
        boolean i2 = cVar.i();
        cVar.d(this.e);
        try {
            l.a(lVar, cVar);
            cVar.b(g2);
            cVar.c(h2);
            cVar.d(i2);
        } catch (IOException e2) {
            throw new m(e2);
        } catch (AssertionError e3) {
            AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e3.getMessage());
            assertionError.initCause(e3);
            throw assertionError;
        } catch (Throwable th) {
            cVar.b(g2);
            cVar.c(h2);
            cVar.d(i2);
            throw th;
        }
    }

    public <T> T a(String str, Type type) throws t {
        if (str == null) {
            return null;
        }
        return (T) a((Reader) new StringReader(str), type);
    }

    public <T> T a(Reader reader, Type type) throws m, t {
        com.bytedance.sdk.openadsdk.preload.a.d.a a2 = a(reader);
        T t2 = (T) a(a2, type);
        a(t2, a2);
        return t2;
    }

    private static void a(Object obj, com.bytedance.sdk.openadsdk.preload.a.d.a aVar) {
        if (obj != null) {
            try {
                if (aVar.f() != com.bytedance.sdk.openadsdk.preload.a.d.b.END_DOCUMENT) {
                    throw new m("JSON document was not fully consumed.");
                }
            } catch (com.bytedance.sdk.openadsdk.preload.a.d.d e2) {
                throw new t(e2);
            } catch (IOException e3) {
                throw new m(e3);
            }
        }
    }

    public <T> T a(com.bytedance.sdk.openadsdk.preload.a.d.a aVar, Type type) throws m, t {
        boolean q2 = aVar.q();
        boolean z = true;
        aVar.a(true);
        try {
            aVar.f();
            z = false;
            T b2 = a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(type)).b(aVar);
            aVar.a(q2);
            return b2;
        } catch (EOFException e2) {
            if (z) {
                aVar.a(q2);
                return null;
            }
            throw new t(e2);
        } catch (IllegalStateException e3) {
            throw new t(e3);
        } catch (IOException e4) {
            throw new t(e4);
        } catch (AssertionError e5) {
            AssertionError assertionError = new AssertionError("AssertionError (GSON pangle-v3200): " + e5.getMessage());
            assertionError.initCause(e5);
            throw assertionError;
        } catch (Throwable th) {
            aVar.a(q2);
            throw th;
        }
    }

    /* compiled from: Gson */
    static class a<T> extends v<T> {
        private v<T> a;

        a() {
        }

        public void a(v<T> vVar) {
            if (this.a == null) {
                this.a = vVar;
                return;
            }
            throw new AssertionError();
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            v<T> vVar = this.a;
            if (vVar != null) {
                return vVar.b(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
            v<T> vVar = this.a;
            if (vVar != null) {
                vVar.a(cVar, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.e + ",factories:" + this.a + ",instanceCreators:" + this.u + "}";
    }
}
