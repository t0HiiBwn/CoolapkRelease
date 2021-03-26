package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.a.d;
import com.bytedance.sdk.a.b.a.a.e;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: Cache */
public final class c implements Closeable, Flushable {
    final e a;
    final d b;

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.b.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }
}
