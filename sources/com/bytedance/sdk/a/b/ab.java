package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.a.e;
import com.bytedance.sdk.a.b.a.c;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

/* compiled from: ResponseBody */
public abstract class ab implements Closeable {
    public abstract u a();

    public abstract long b();

    public abstract e d();

    public final InputStream c() {
        return d().f();
    }

    public final String e() throws IOException {
        e d = d();
        try {
            return d.a(c.a(d, f()));
        } finally {
            c.a(d);
        }
    }

    private Charset f() {
        u a = a();
        return a != null ? a.a(c.e) : c.e;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c.a(d());
    }

    public static ab a(u uVar, byte[] bArr) {
        return a(uVar, (long) bArr.length, new com.bytedance.sdk.a.a.c().c(bArr));
    }

    public static ab a(final u uVar, final long j, final e eVar) {
        Objects.requireNonNull(eVar, "source == null");
        return new ab() {
            /* class com.bytedance.sdk.a.b.ab.AnonymousClass1 */

            @Override // com.bytedance.sdk.a.b.ab
            public u a() {
                return uVar;
            }

            @Override // com.bytedance.sdk.a.b.ab
            public long b() {
                return j;
            }

            @Override // com.bytedance.sdk.a.b.ab
            public e d() {
                return eVar;
            }
        };
    }
}
