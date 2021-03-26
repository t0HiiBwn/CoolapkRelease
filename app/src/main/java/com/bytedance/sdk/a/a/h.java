package com.bytedance.sdk.a.a;

import java.io.IOException;

/* compiled from: ForwardingSource */
public abstract class h implements s {
    private final s a;

    public h(s sVar) {
        if (sVar != null) {
            this.a = sVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final s b() {
        return this.a;
    }

    @Override // com.bytedance.sdk.a.a.s
    public long a(c cVar, long j) throws IOException {
        return this.a.a(cVar, j);
    }

    @Override // com.bytedance.sdk.a.a.s
    public t a() {
        return this.a.a();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // java.lang.Object
    public String toString() {
        return getClass().getSimpleName() + "(" + this.a.toString() + ")";
    }
}
