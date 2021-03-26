package com.bytedance.sdk.openadsdk.preload.geckox.buffer.a;

import com.bytedance.sdk.openadsdk.preload.geckox.buffer.a;
import java.io.IOException;

/* compiled from: BufferOutputStream */
public class b extends c {
    private a a;

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
    }

    public b(a aVar) {
        this.a = aVar;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.a.a(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.a.a(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.a.a(bArr, i, i2);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
    }
}
