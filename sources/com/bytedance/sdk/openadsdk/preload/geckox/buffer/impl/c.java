package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import com.bytedance.sdk.openadsdk.preload.geckox.buffer.a;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.b;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RAFBuffer */
class c implements a {
    private long a;
    private long b;
    private RandomAccessFile c;
    private AtomicBoolean d = new AtomicBoolean(false);
    private File e;

    c(long j, File file) throws IOException {
        this.a = j;
        this.e = file;
        file.getParentFile().mkdirs();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.c = randomAccessFile;
            randomAccessFile.setLength(j);
        } catch (Exception e2) {
            b.a(this.c);
            throw new IOException("create raf swap failed! path: " + file.getAbsolutePath() + " caused by: " + e2.getMessage(), e2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a() throws IOException {
        if (this.d.get()) {
            throw new IOException("released!");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long b() {
        return this.a;
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
        int skipBytes;
        if (!this.d.get()) {
            int i = (int) j;
            if (((long) i) == j) {
                skipBytes = this.c.skipBytes(i);
                this.b = this.c.getFilePointer();
            } else {
                throw new IOException("too large:" + j);
            }
        } else {
            throw new IOException("released!");
        }
        return (long) skipBytes;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int a(byte[] bArr, int i, int i2) throws IOException {
        if (this.d.get()) {
            throw new IOException("released!");
        } else if (bArr == null || bArr.length == 0 || i2 < 1 || i < 0 || i >= bArr.length) {
            return 0;
        } else {
            if (i + i2 > bArr.length) {
                i2 = bArr.length - i;
            }
            synchronized (this) {
                long j = this.b;
                long j2 = this.a;
                if (j == j2) {
                    return 0;
                }
                if (((long) i2) + j > j2) {
                    i2 = (int) (j2 - j);
                }
                this.c.write(bArr, i, i2);
                this.b += (long) i2;
                return i2;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long c() throws IOException {
        if (!this.d.get()) {
            return this.b;
        }
        throw new IOException("released!");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (r4 > r0) goto L_0x000e;
     */
    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void b(long j) throws IOException {
        if (!this.d.get()) {
            long j2 = 0;
            if (j >= 0) {
                j2 = this.a;
            }
            j = j2;
            this.b = j;
            this.c.seek(j);
            return;
        }
        throw new IOException("released!");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int d() throws IOException {
        byte[] bArr = new byte[1];
        if (b(bArr) == 0) {
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
        if (this.d.get()) {
            throw new IOException("released!");
        } else if (bArr == null || i2 < 1 || i < 0 || i >= bArr.length) {
            return 0;
        } else {
            if (i + i2 > bArr.length) {
                i2 = bArr.length - i;
            }
            synchronized (this) {
                long j = this.b;
                long j2 = this.a;
                if (j == j2) {
                    return -1;
                }
                if (((long) i2) + j > j2) {
                    i2 = (int) (j2 - j);
                }
                int read = this.c.read(bArr, i, i2);
                if (read == -1) {
                    return -1;
                }
                this.b += (long) read;
                return read;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void e() {
        if (!this.d.getAndSet(true)) {
            b.a(this.c);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public File f() {
        return this.e;
    }
}
