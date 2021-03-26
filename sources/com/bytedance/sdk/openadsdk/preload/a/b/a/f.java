package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.d.c;
import com.bytedance.sdk.openadsdk.preload.a.i;
import com.bytedance.sdk.openadsdk.preload.a.l;
import com.bytedance.sdk.openadsdk.preload.a.n;
import com.bytedance.sdk.openadsdk.preload.a.o;
import com.bytedance.sdk.openadsdk.preload.a.q;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: JsonTreeWriter */
public final class f extends c {
    private static final Writer a = new Writer() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.a.f.AnonymousClass1 */

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };
    private static final q b = new q("closed");
    private final List<l> c = new ArrayList();
    private String d;
    private l e = n.a;

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c, java.io.Flushable
    public void flush() throws IOException {
    }

    public f() {
        super(a);
    }

    public l a() {
        if (this.c.isEmpty()) {
            return this.e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.c);
    }

    private l j() {
        List<l> list = this.c;
        return list.get(list.size() - 1);
    }

    private void a(l lVar) {
        if (this.d != null) {
            if (!lVar.j() || i()) {
                ((o) j()).a(this.d, lVar);
            }
            this.d = null;
        } else if (this.c.isEmpty()) {
            this.e = lVar;
        } else {
            l j = j();
            if (j instanceof i) {
                ((i) j).a(lVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public c b() throws IOException {
        i iVar = new i();
        a(iVar);
        this.c.add(iVar);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public c c() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        } else if (j() instanceof i) {
            List<l> list = this.c;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public c d() throws IOException {
        o oVar = new o();
        a(oVar);
        this.c.add(oVar);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public c e() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        } else if (j() instanceof o) {
            List<l> list = this.c;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public c a(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        } else if (j() instanceof o) {
            this.d = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public c b(String str) throws IOException {
        if (str == null) {
            return f();
        }
        a(new q(str));
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public c f() throws IOException {
        a(n.a);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public c a(boolean z) throws IOException {
        a(new q(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public c a(Boolean bool) throws IOException {
        if (bool == null) {
            return f();
        }
        a(new q(bool));
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public c a(long j) throws IOException {
        a(new q(Long.valueOf(j)));
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public c a(Number number) throws IOException {
        if (number == null) {
            return f();
        }
        if (!g()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new q(number));
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c.isEmpty()) {
            this.c.add(b);
            return;
        }
        throw new IOException("Incomplete document");
    }
}
