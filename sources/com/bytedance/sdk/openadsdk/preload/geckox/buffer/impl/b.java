package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import com.bytedance.sdk.openadsdk.preload.geckox.buffer.a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: FileBuffer */
class b implements a {
    private RandomAccessFile a;
    private AtomicBoolean b = new AtomicBoolean(false);
    private File c;

    b(File file) throws IOException {
        this.c = file;
        file.getParentFile().mkdirs();
        try {
            this.a = new RandomAccessFile(file, "rw");
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(this.a);
            throw new IOException("create raf mSwap failed! path: " + file.getAbsolutePath() + " caused by: " + e.getMessage(), e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a() throws IOException {
        if (this.b.get()) {
            throw new IOException("released!");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long b() throws IOException {
        return this.a.length();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a(int i) throws IOException {
        a(new byte[]{(byte) i});
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a(byte[] bArr) throws IOException {
        a(bArr, 0, bArr.length);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public synchronized long a(long j) throws IOException {
        int i;
        if (!this.b.get()) {
            i = (int) j;
            if (((long) i) == j) {
            } else {
                throw new IOException("too large:" + j);
            }
        } else {
            throw new IOException("released!");
        }
        return (long) this.a.skipBytes(i);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int a(byte[] bArr, int i, int i2) throws IOException {
        if (this.b.get()) {
            throw new IOException("released!");
        } else if (bArr == null || bArr.length == 0 || i2 < 1 || i < 0 || i >= bArr.length) {
            return 0;
        } else {
            if (i + i2 > bArr.length) {
                i2 = bArr.length - i;
            }
            synchronized (this) {
                this.a.write(bArr, i, i2);
            }
            return i2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long c() throws IOException {
        if (!this.b.get()) {
            return this.a.getFilePointer();
        }
        throw new IOException("released!");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void b(long j) throws IOException {
        if (!this.b.get()) {
            if (j < 0) {
                j = 0;
            }
            this.a.seek(j);
            return;
        }
        throw new IOException("released!");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int d() throws IOException {
        byte[] bArr = new byte[1];
        if (b(bArr) <= 0) {
            return -1;
        }
        return bArr[0];
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int b(byte[] bArr) throws IOException {
        return b(bArr, 0, bArr.length);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int b(byte[] bArr, int i, int i2) throws IOException {
        int read;
        if (this.b.get()) {
            throw new IOException("released!");
        } else if (bArr == null || i2 < 1 || i < 0 || i >= bArr.length) {
            return 0;
        } else {
            if (i + i2 > bArr.length) {
                i2 = bArr.length - i;
            }
            synchronized (this) {
                read = this.a.read(bArr, i, i2);
            }
            return read;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void e() {
        if (!this.b.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(this.a);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public File f() {
        return this.c;
    }
}
