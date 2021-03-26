package com.bytedance.sdk.openadsdk.preload.geckox.buffer.a;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: BufferInputStream */
public class a extends InputStream {
    private com.bytedance.sdk.openadsdk.preload.geckox.buffer.a a;
    private long b;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public a(com.bytedance.sdk.openadsdk.preload.geckox.buffer.a aVar) {
        this.a = aVar;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.a.b(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.a.b(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.a.a(j);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        long b2 = this.a.b() - this.a.c();
        if (b2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) b2;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.b = (long) i;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.a.b(this.b);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.a.d();
    }
}
