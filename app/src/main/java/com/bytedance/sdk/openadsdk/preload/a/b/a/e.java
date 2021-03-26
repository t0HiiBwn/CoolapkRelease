package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.d.a;
import com.bytedance.sdk.openadsdk.preload.a.d.b;
import com.bytedance.sdk.openadsdk.preload.a.i;
import com.bytedance.sdk.openadsdk.preload.a.n;
import com.bytedance.sdk.openadsdk.preload.a.o;
import com.bytedance.sdk.openadsdk.preload.a.q;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* compiled from: JsonTreeReader */
public final class e extends a {
    private static final Reader b = new Reader() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.a.e.AnonymousClass1 */

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object c = new Object();
    private Object[] d;
    private int e;
    private String[] f;
    private int[] g;

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void a() throws IOException {
        a(b.BEGIN_ARRAY);
        a(((i) t()).iterator());
        this.g[this.e - 1] = 0;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void b() throws IOException {
        a(b.END_ARRAY);
        u();
        u();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void c() throws IOException {
        a(b.BEGIN_OBJECT);
        a(((o) t()).n().iterator());
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void d() throws IOException {
        a(b.END_OBJECT);
        u();
        u();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public boolean e() throws IOException {
        b f2 = f();
        return (f2 == b.END_OBJECT || f2 == b.END_ARRAY) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public b f() throws IOException {
        if (this.e == 0) {
            return b.END_DOCUMENT;
        }
        Object t = t();
        if (t instanceof Iterator) {
            boolean z = this.d[this.e - 2] instanceof o;
            Iterator it2 = (Iterator) t;
            if (!it2.hasNext()) {
                return z ? b.END_OBJECT : b.END_ARRAY;
            }
            if (z) {
                return b.NAME;
            }
            a(it2.next());
            return f();
        } else if (t instanceof o) {
            return b.BEGIN_OBJECT;
        } else {
            if (t instanceof i) {
                return b.BEGIN_ARRAY;
            }
            if (t instanceof q) {
                q qVar = (q) t;
                if (qVar.p()) {
                    return b.STRING;
                }
                if (qVar.n()) {
                    return b.BOOLEAN;
                }
                if (qVar.o()) {
                    return b.NUMBER;
                }
                throw new AssertionError();
            } else if (t instanceof n) {
                return b.NULL;
            } else {
                if (t == c) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object t() {
        return this.d[this.e - 1];
    }

    private Object u() {
        Object[] objArr = this.d;
        int i = this.e - 1;
        this.e = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    private void a(b bVar) throws IOException {
        if (f() != bVar) {
            throw new IllegalStateException("Expected " + bVar + " but was " + f() + v());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public String g() throws IOException {
        a(b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
        String str = (String) entry.getKey();
        this.f[this.e - 1] = str;
        a(entry.getValue());
        return str;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public String h() throws IOException {
        b f2 = f();
        if (f2 == b.STRING || f2 == b.NUMBER) {
            String b2 = ((q) u()).b();
            int i = this.e;
            if (i > 0) {
                int[] iArr = this.g;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return b2;
        }
        throw new IllegalStateException("Expected " + b.STRING + " but was " + f2 + v());
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public boolean i() throws IOException {
        a(b.BOOLEAN);
        boolean f2 = ((q) u()).f();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return f2;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void j() throws IOException {
        a(b.NULL);
        u();
        int i = this.e;
        if (i > 0) {
            int[] iArr = this.g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public double k() throws IOException {
        b f2 = f();
        if (f2 == b.NUMBER || f2 == b.STRING) {
            double c2 = ((q) t()).c();
            if (q() || (!Double.isNaN(c2) && !Double.isInfinite(c2))) {
                u();
                int i = this.e;
                if (i > 0) {
                    int[] iArr = this.g;
                    int i2 = i - 1;
                    iArr[i2] = iArr[i2] + 1;
                }
                return c2;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + c2);
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f2 + v());
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public long l() throws IOException {
        b f2 = f();
        if (f2 == b.NUMBER || f2 == b.STRING) {
            long d2 = ((q) t()).d();
            u();
            int i = this.e;
            if (i > 0) {
                int[] iArr = this.g;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return d2;
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f2 + v());
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public int m() throws IOException {
        b f2 = f();
        if (f2 == b.NUMBER || f2 == b.STRING) {
            int e2 = ((q) t()).e();
            u();
            int i = this.e;
            if (i > 0) {
                int[] iArr = this.g;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return e2;
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f2 + v());
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d = new Object[]{c};
        this.e = 1;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void n() throws IOException {
        if (f() == b.NAME) {
            g();
            this.f[this.e - 2] = "null";
        } else {
            u();
            int i = this.e;
            if (i > 0) {
                this.f[i - 1] = "null";
            }
        }
        int i2 = this.e;
        if (i2 > 0) {
            int[] iArr = this.g;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a, java.lang.Object
    public String toString() {
        return getClass().getSimpleName();
    }

    public void o() throws IOException {
        a(b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
        a(entry.getValue());
        a(new q((String) entry.getKey()));
    }

    private void a(Object obj) {
        int i = this.e;
        Object[] objArr = this.d;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.d = Arrays.copyOf(objArr, i2);
            this.g = Arrays.copyOf(this.g, i2);
            this.f = (String[]) Arrays.copyOf(this.f, i2);
        }
        Object[] objArr2 = this.d;
        int i3 = this.e;
        this.e = i3 + 1;
        objArr2[i3] = obj;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public String p() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (i < this.e) {
            Object[] objArr = this.d;
            if (objArr[i] instanceof i) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.g[i]);
                    sb.append(']');
                }
            } else if (objArr[i] instanceof o) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.f;
                    if (strArr[i] != null) {
                        sb.append(strArr[i]);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    private String v() {
        return " at path " + p();
    }
}
