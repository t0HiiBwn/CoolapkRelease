package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.b.g;
import com.bytedance.sdk.openadsdk.preload.a.d.b;
import com.bytedance.sdk.openadsdk.preload.a.d.c;
import com.bytedance.sdk.openadsdk.preload.a.f;
import com.bytedance.sdk.openadsdk.preload.a.i;
import com.bytedance.sdk.openadsdk.preload.a.l;
import com.bytedance.sdk.openadsdk.preload.a.m;
import com.bytedance.sdk.openadsdk.preload.a.o;
import com.bytedance.sdk.openadsdk.preload.a.q;
import com.bytedance.sdk.openadsdk.preload.a.t;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: TypeAdapters */
public final class n {
    public static final v<String> A;
    public static final v<BigDecimal> B = new v<BigDecimal>() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass9 */

        /* renamed from: a */
        public BigDecimal b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return new BigDecimal(aVar.h());
            } catch (NumberFormatException e) {
                throw new t(e);
            }
        }

        public void a(c cVar, BigDecimal bigDecimal) throws IOException {
            cVar.a(bigDecimal);
        }
    };
    public static final v<BigInteger> C = new v<BigInteger>() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass10 */

        /* renamed from: a */
        public BigInteger b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return new BigInteger(aVar.h());
            } catch (NumberFormatException e) {
                throw new t(e);
            }
        }

        public void a(c cVar, BigInteger bigInteger) throws IOException {
            cVar.a(bigInteger);
        }
    };
    public static final w D;
    public static final v<StringBuilder> E;
    public static final w F;
    public static final v<StringBuffer> G;
    public static final w H;
    public static final v<URL> I;
    public static final w J;
    public static final v<URI> K;
    public static final w L;
    public static final v<InetAddress> M;
    public static final w N;
    public static final v<UUID> O;
    public static final w P;
    public static final v<Currency> Q;
    public static final w R;
    public static final w S = new w() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass19 */

        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
            if (aVar.a() != Timestamp.class) {
                return null;
            }
            final v<T> a = fVar.a((Class) Date.class);
            return new v<Timestamp>() {
                /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass19.AnonymousClass1 */

                /* renamed from: a */
                public Timestamp b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                    Date date = (Date) a.b(aVar);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                public void a(c cVar, Timestamp timestamp) throws IOException {
                    a.a(cVar, timestamp);
                }
            };
        }
    };
    public static final v<Calendar> T;
    public static final w U;
    public static final v<Locale> V;
    public static final w W;
    public static final v<l> X;
    public static final w Y;
    public static final w Z = new w() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass24 */

        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
            Class<? super Object> a = aVar.a();
            if (!Enum.class.isAssignableFrom(a) || a == Enum.class) {
                return null;
            }
            if (!a.isEnum()) {
                a = a.getSuperclass();
            }
            return new a(a);
        }
    };
    public static final v<Class> a;
    public static final w b;
    public static final v<BitSet> c;
    public static final w d;
    public static final v<Boolean> e;
    public static final v<Boolean> f = new v<Boolean>() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass31 */

        /* renamed from: a */
        public Boolean b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Boolean.valueOf(aVar.h());
            }
            aVar.j();
            return null;
        }

        public void a(c cVar, Boolean bool) throws IOException {
            cVar.b(bool == null ? "null" : bool.toString());
        }
    };
    public static final w g;
    public static final v<Number> h;
    public static final w i;
    public static final v<Number> j;
    public static final w k;
    public static final v<Number> l;
    public static final w m;
    public static final v<AtomicInteger> n;
    public static final w o;
    public static final v<AtomicBoolean> p;
    public static final w q;
    public static final v<AtomicIntegerArray> r;
    public static final w s;
    public static final v<Number> t = new v<Number>() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass3 */

        /* renamed from: a */
        public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Long.valueOf(aVar.l());
            } catch (NumberFormatException e) {
                throw new t(e);
            }
        }

        public void a(c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final v<Number> u = new v<Number>() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass4 */

        /* renamed from: a */
        public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Float.valueOf((float) aVar.k());
            }
            aVar.j();
            return null;
        }

        public void a(c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final v<Number> v = new v<Number>() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass5 */

        /* renamed from: a */
        public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Double.valueOf(aVar.k());
            }
            aVar.j();
            return null;
        }

        public void a(c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final v<Number> w;
    public static final w x;
    public static final v<Character> y;
    public static final w z;

    static {
        v<Class> a2 = new v<Class>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass1 */

            public void a(c cVar, Class cls) throws IOException {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
            }

            /* renamed from: a */
            public Class b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }
        }.a();
        a = a2;
        b = a(Class.class, a2);
        v<BitSet> a3 = new v<BitSet>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass12 */

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
                if (java.lang.Integer.parseInt(r1) != 0) goto L_0x0069;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
                if (r8.m() != 0) goto L_0x0069;
             */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x006b  */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x006e A[SYNTHETIC] */
            /* renamed from: a */
            public BitSet b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                BitSet bitSet = new BitSet();
                aVar.a();
                b f = aVar.f();
                int i = 0;
                while (f != b.END_ARRAY) {
                    int i2 = AnonymousClass30.a[f.ordinal()];
                    boolean z = true;
                    if (i2 != 1) {
                        if (i2 == 2) {
                            z = aVar.i();
                        } else if (i2 == 3) {
                            String h = aVar.h();
                            try {
                            } catch (NumberFormatException unused) {
                                throw new t("Error: Expecting: bitset number value (1, 0), Found: " + h);
                            }
                        } else {
                            throw new t("Invalid bitset value type: " + f);
                        }
                        if (!z) {
                            bitSet.set(i);
                        }
                        i++;
                        f = aVar.f();
                    }
                    z = false;
                    if (!z) {
                    }
                    i++;
                    f = aVar.f();
                }
                aVar.b();
                return bitSet;
            }

            public void a(c cVar, BitSet bitSet) throws IOException {
                cVar.b();
                int length = bitSet.length();
                for (int i = 0; i < length; i++) {
                    cVar.a(bitSet.get(i) ? 1 : 0);
                }
                cVar.c();
            }
        }.a();
        c = a3;
        d = a(BitSet.class, a3);
        AnonymousClass23 r0 = new v<Boolean>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass23 */

            /* renamed from: a */
            public Boolean b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                b f = aVar.f();
                if (f == b.NULL) {
                    aVar.j();
                    return null;
                } else if (f == b.STRING) {
                    return Boolean.valueOf(Boolean.parseBoolean(aVar.h()));
                } else {
                    return Boolean.valueOf(aVar.i());
                }
            }

            public void a(c cVar, Boolean bool) throws IOException {
                cVar.a(bool);
            }
        };
        e = r0;
        g = a(Boolean.TYPE, Boolean.class, r0);
        AnonymousClass32 r02 = new v<Number>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass32 */

            /* renamed from: a */
            public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) aVar.m());
                } catch (NumberFormatException e) {
                    throw new t(e);
                }
            }

            public void a(c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        h = r02;
        i = a(Byte.TYPE, Byte.class, r02);
        AnonymousClass33 r03 = new v<Number>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass33 */

            /* renamed from: a */
            public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Short.valueOf((short) aVar.m());
                } catch (NumberFormatException e) {
                    throw new t(e);
                }
            }

            public void a(c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        j = r03;
        k = a(Short.TYPE, Short.class, r03);
        AnonymousClass34 r04 = new v<Number>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass34 */

            /* renamed from: a */
            public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.m());
                } catch (NumberFormatException e) {
                    throw new t(e);
                }
            }

            public void a(c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        l = r04;
        m = a(Integer.TYPE, Integer.class, r04);
        v<AtomicInteger> a4 = new v<AtomicInteger>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass35 */

            /* renamed from: a */
            public AtomicInteger b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                try {
                    return new AtomicInteger(aVar.m());
                } catch (NumberFormatException e) {
                    throw new t(e);
                }
            }

            public void a(c cVar, AtomicInteger atomicInteger) throws IOException {
                cVar.a((long) atomicInteger.get());
            }
        }.a();
        n = a4;
        o = a(AtomicInteger.class, a4);
        v<AtomicBoolean> a5 = new v<AtomicBoolean>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass36 */

            /* renamed from: a */
            public AtomicBoolean b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                return new AtomicBoolean(aVar.i());
            }

            public void a(c cVar, AtomicBoolean atomicBoolean) throws IOException {
                cVar.a(atomicBoolean.get());
            }
        }.a();
        p = a5;
        q = a(AtomicBoolean.class, a5);
        v<AtomicIntegerArray> a6 = new v<AtomicIntegerArray>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass2 */

            /* renamed from: a */
            public AtomicIntegerArray b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    try {
                        arrayList.add(Integer.valueOf(aVar.m()));
                    } catch (NumberFormatException e) {
                        throw new t(e);
                    }
                }
                aVar.b();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i = 0; i < size; i++) {
                    atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
                }
                return atomicIntegerArray;
            }

            public void a(c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
                cVar.b();
                int length = atomicIntegerArray.length();
                for (int i = 0; i < length; i++) {
                    cVar.a((long) atomicIntegerArray.get(i));
                }
                cVar.c();
            }
        }.a();
        r = a6;
        s = a(AtomicIntegerArray.class, a6);
        AnonymousClass6 r05 = new v<Number>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass6 */

            /* renamed from: a */
            public Number b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                b f = aVar.f();
                int i = AnonymousClass30.a[f.ordinal()];
                if (i == 1 || i == 3) {
                    return new g(aVar.h());
                }
                if (i == 4) {
                    aVar.j();
                    return null;
                }
                throw new t("Expecting number, got: " + f);
            }

            public void a(c cVar, Number number) throws IOException {
                cVar.a(number);
            }
        };
        w = r05;
        x = a(Number.class, r05);
        AnonymousClass7 r06 = new v<Character>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass7 */

            /* renamed from: a */
            public Character b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.j();
                    return null;
                }
                String h = aVar.h();
                if (h.length() == 1) {
                    return Character.valueOf(h.charAt(0));
                }
                throw new t("Expecting character, got: " + h);
            }

            public void a(c cVar, Character ch) throws IOException {
                cVar.b(ch == null ? null : String.valueOf(ch));
            }
        };
        y = r06;
        z = a(Character.TYPE, Character.class, r06);
        AnonymousClass8 r07 = new v<String>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass8 */

            /* renamed from: a */
            public String b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                b f = aVar.f();
                if (f == b.NULL) {
                    aVar.j();
                    return null;
                } else if (f == b.BOOLEAN) {
                    return Boolean.toString(aVar.i());
                } else {
                    return aVar.h();
                }
            }

            public void a(c cVar, String str) throws IOException {
                cVar.b(str);
            }
        };
        A = r07;
        D = a(String.class, r07);
        AnonymousClass11 r08 = new v<StringBuilder>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass11 */

            /* renamed from: a */
            public StringBuilder b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return new StringBuilder(aVar.h());
                }
                aVar.j();
                return null;
            }

            public void a(c cVar, StringBuilder sb) throws IOException {
                cVar.b(sb == null ? null : sb.toString());
            }
        };
        E = r08;
        F = a(StringBuilder.class, r08);
        AnonymousClass13 r09 = new v<StringBuffer>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass13 */

            /* renamed from: a */
            public StringBuffer b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return new StringBuffer(aVar.h());
                }
                aVar.j();
                return null;
            }

            public void a(c cVar, StringBuffer stringBuffer) throws IOException {
                cVar.b(stringBuffer == null ? null : stringBuffer.toString());
            }
        };
        G = r09;
        H = a(StringBuffer.class, r09);
        AnonymousClass14 r010 = new v<URL>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass14 */

            /* renamed from: a */
            public URL b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.j();
                    return null;
                }
                String h = aVar.h();
                if ("null".equals(h)) {
                    return null;
                }
                return new URL(h);
            }

            public void a(c cVar, URL url) throws IOException {
                cVar.b(url == null ? null : url.toExternalForm());
            }
        };
        I = r010;
        J = a(URL.class, r010);
        AnonymousClass15 r011 = new v<URI>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass15 */

            /* renamed from: a */
            public URI b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    String h = aVar.h();
                    if ("null".equals(h)) {
                        return null;
                    }
                    return new URI(h);
                } catch (URISyntaxException e) {
                    throw new m(e);
                }
            }

            public void a(c cVar, URI uri) throws IOException {
                cVar.b(uri == null ? null : uri.toASCIIString());
            }
        };
        K = r011;
        L = a(URI.class, r011);
        AnonymousClass16 r012 = new v<InetAddress>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass16 */

            /* renamed from: a */
            public InetAddress b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return InetAddress.getByName(aVar.h());
                }
                aVar.j();
                return null;
            }

            public void a(c cVar, InetAddress inetAddress) throws IOException {
                cVar.b(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        M = r012;
        N = b(InetAddress.class, r012);
        AnonymousClass17 r013 = new v<UUID>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass17 */

            /* renamed from: a */
            public UUID b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return UUID.fromString(aVar.h());
                }
                aVar.j();
                return null;
            }

            public void a(c cVar, UUID uuid) throws IOException {
                cVar.b(uuid == null ? null : uuid.toString());
            }
        };
        O = r013;
        P = a(UUID.class, r013);
        v<Currency> a7 = new v<Currency>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass18 */

            /* renamed from: a */
            public Currency b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                return Currency.getInstance(aVar.h());
            }

            public void a(c cVar, Currency currency) throws IOException {
                cVar.b(currency.getCurrencyCode());
            }
        }.a();
        Q = a7;
        R = a(Currency.class, a7);
        AnonymousClass20 r014 = new v<Calendar>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass20 */

            /* renamed from: a */
            public Calendar b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.j();
                    return null;
                }
                aVar.c();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (aVar.f() != b.END_OBJECT) {
                    String g = aVar.g();
                    int m = aVar.m();
                    if ("year".equals(g)) {
                        i = m;
                    } else if ("month".equals(g)) {
                        i2 = m;
                    } else if ("dayOfMonth".equals(g)) {
                        i3 = m;
                    } else if ("hourOfDay".equals(g)) {
                        i4 = m;
                    } else if ("minute".equals(g)) {
                        i5 = m;
                    } else if ("second".equals(g)) {
                        i6 = m;
                    }
                }
                aVar.d();
                return new GregorianCalendar(i, i2, i3, i4, i5, i6);
            }

            public void a(c cVar, Calendar calendar) throws IOException {
                if (calendar == null) {
                    cVar.f();
                    return;
                }
                cVar.d();
                cVar.a("year");
                cVar.a((long) calendar.get(1));
                cVar.a("month");
                cVar.a((long) calendar.get(2));
                cVar.a("dayOfMonth");
                cVar.a((long) calendar.get(5));
                cVar.a("hourOfDay");
                cVar.a((long) calendar.get(11));
                cVar.a("minute");
                cVar.a((long) calendar.get(12));
                cVar.a("second");
                cVar.a((long) calendar.get(13));
                cVar.e();
            }
        };
        T = r014;
        U = b(Calendar.class, GregorianCalendar.class, r014);
        AnonymousClass21 r015 = new v<Locale>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass21 */

            /* renamed from: a */
            public Locale b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                String str = null;
                if (aVar.f() == b.NULL) {
                    aVar.j();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.h(), "_");
                String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                if (stringTokenizer.hasMoreElements()) {
                    str = stringTokenizer.nextToken();
                }
                if (nextToken2 == null && str == null) {
                    return new Locale(nextToken);
                }
                if (str == null) {
                    return new Locale(nextToken, nextToken2);
                }
                return new Locale(nextToken, nextToken2, str);
            }

            public void a(c cVar, Locale locale) throws IOException {
                cVar.b(locale == null ? null : locale.toString());
            }
        };
        V = r015;
        W = a(Locale.class, r015);
        AnonymousClass22 r016 = new v<l>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass22 */

            /* renamed from: a */
            public l b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                switch (AnonymousClass30.a[aVar.f().ordinal()]) {
                    case 1:
                        return new q(new g(aVar.h()));
                    case 2:
                        return new q(Boolean.valueOf(aVar.i()));
                    case 3:
                        return new q(aVar.h());
                    case 4:
                        aVar.j();
                        return com.bytedance.sdk.openadsdk.preload.a.n.a;
                    case 5:
                        i iVar = new i();
                        aVar.a();
                        while (aVar.e()) {
                            iVar.a(b(aVar));
                        }
                        aVar.b();
                        return iVar;
                    case 6:
                        o oVar = new o();
                        aVar.c();
                        while (aVar.e()) {
                            oVar.a(aVar.g(), b(aVar));
                        }
                        aVar.d();
                        return oVar;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            public void a(c cVar, l lVar) throws IOException {
                if (lVar == null || lVar.j()) {
                    cVar.f();
                } else if (lVar.i()) {
                    q m = lVar.m();
                    if (m.o()) {
                        cVar.a(m.a());
                    } else if (m.n()) {
                        cVar.a(m.f());
                    } else {
                        cVar.b(m.b());
                    }
                } else if (lVar.g()) {
                    cVar.b();
                    Iterator<l> it2 = lVar.l().iterator();
                    while (it2.hasNext()) {
                        a(cVar, it2.next());
                    }
                    cVar.c();
                } else if (lVar.h()) {
                    cVar.d();
                    for (Map.Entry<String, l> entry : lVar.k().n()) {
                        cVar.a(entry.getKey());
                        a(cVar, entry.getValue());
                    }
                    cVar.e();
                } else {
                    throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
                }
            }
        };
        X = r016;
        Y = b(l.class, r016);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.preload.a.b.a.n$30  reason: invalid class name */
    /* compiled from: TypeAdapters */
    static /* synthetic */ class AnonymousClass30 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[b.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[b.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[b.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[b.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: TypeAdapters */
    private static final class a<T extends Enum<T>> extends v<T> {
        private final Map<String, T> a = new HashMap();
        private final Map<T, String> b = new HashMap();

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.bytedance.sdk.openadsdk.preload.a.b.a.n$a<T extends java.lang.Enum<T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            a(cVar, (c) ((Enum) obj));
        }

        public a(Class<T> cls) {
            try {
                T[] enumConstants = cls.getEnumConstants();
                for (T t : enumConstants) {
                    String name = t.name();
                    com.bytedance.sdk.openadsdk.preload.a.a.c cVar = (com.bytedance.sdk.openadsdk.preload.a.a.c) cls.getField(name).getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.c.class);
                    if (cVar != null) {
                        name = cVar.a();
                        for (String str : cVar.b()) {
                            this.a.put(str, t);
                        }
                    }
                    this.a.put(name, t);
                    this.b.put(t, name);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        /* renamed from: a */
        public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return this.a.get(aVar.h());
            }
            aVar.j();
            return null;
        }

        public void a(c cVar, T t) throws IOException {
            cVar.b(t == null ? null : this.b.get(t));
        }
    }

    public static <TT> w a(final com.bytedance.sdk.openadsdk.preload.a.c.a<TT> aVar, final v<TT> vVar) {
        return new w() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass25 */

            @Override // com.bytedance.sdk.openadsdk.preload.a.w
            public <T> v<T> a(f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
                if (aVar.equals(aVar)) {
                    return vVar;
                }
                return null;
            }
        };
    }

    public static <TT> w a(final Class<TT> cls, final v<TT> vVar) {
        return new w() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass26 */

            @Override // com.bytedance.sdk.openadsdk.preload.a.w
            public <T> v<T> a(f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
                if (aVar.a() == cls) {
                    return vVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + vVar + "]";
            }
        };
    }

    public static <TT> w a(final Class<TT> cls, final Class<TT> cls2, final v<? super TT> vVar) {
        return new w() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass27 */

            @Override // com.bytedance.sdk.openadsdk.preload.a.w
            public <T> v<T> a(f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
                Class<? super T> a2 = aVar.a();
                if (a2 == cls || a2 == cls2) {
                    return vVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + vVar + "]";
            }
        };
    }

    public static <TT> w b(final Class<TT> cls, final Class<? extends TT> cls2, final v<? super TT> vVar) {
        return new w() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass28 */

            @Override // com.bytedance.sdk.openadsdk.preload.a.w
            public <T> v<T> a(f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
                Class<? super T> a2 = aVar.a();
                if (a2 == cls || a2 == cls2) {
                    return vVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + vVar + "]";
            }
        };
    }

    public static <T1> w b(final Class<T1> cls, final v<T1> vVar) {
        return new w() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass29 */

            @Override // com.bytedance.sdk.openadsdk.preload.a.w
            public <T2> v<T2> a(f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T2> aVar) {
                final Class<? super T2> a2 = aVar.a();
                if (!cls.isAssignableFrom(a2)) {
                    return null;
                }
                return new v<T1>() {
                    /* class com.bytedance.sdk.openadsdk.preload.a.b.a.n.AnonymousClass29.AnonymousClass1 */

                    @Override // com.bytedance.sdk.openadsdk.preload.a.v
                    public void a(c cVar, T1 t1) throws IOException {
                        vVar.a(cVar, t1);
                    }

                    @Override // com.bytedance.sdk.openadsdk.preload.a.v
                    public T1 b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                        T1 t1 = (T1) vVar.b(aVar);
                        if (t1 == null || a2.isInstance(t1)) {
                            return t1;
                        }
                        throw new t("Expected a " + a2.getName() + " but was " + t1.getClass().getName());
                    }
                };
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + vVar + "]";
            }
        };
    }
}
