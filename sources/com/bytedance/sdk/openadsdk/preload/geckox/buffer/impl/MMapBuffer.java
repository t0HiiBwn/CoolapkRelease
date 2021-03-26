package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import com.bytedance.sdk.openadsdk.preload.geckox.buffer.a;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.c;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.g;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

class MMapBuffer implements a {
    private long a;
    private long b;
    private long c;
    private AtomicBoolean d = new AtomicBoolean(false);
    private File e;

    private native long nCreate(String str, long j) throws IOException;

    private native int nFlush(long j, long j2) throws IOException;

    private native void nRead(long j, long j2, byte[] bArr, int i, int i2);

    private native int nRelease(long j, long j2);

    private native void nWrite(long j, long j2, byte[] bArr, int i, int i2);

    static {
        g.a("buffer_pg");
    }

    MMapBuffer(long j, File file) throws IOException {
        d(j);
        this.e = file;
        file.getParentFile().mkdirs();
        c(nCreate(file.getAbsolutePath(), j));
    }

    void c(long j) {
        this.b = j;
    }

    void d(long j) {
        this.a = j;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a() throws IOException {
        if (!this.d.get()) {
            nFlush(this.b, this.a);
            return;
        }
        throw new IOException("released!");
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
        if (this.d.get()) {
            throw new IOException("released!");
        } else if (j <= 0) {
            return 0;
        } else {
            long j2 = this.c;
            long j3 = j + j2;
            this.c = j3;
            if (j3 < 0) {
                this.c = 0;
            } else {
                long j4 = this.a;
                if (j3 > j4) {
                    this.c = j4;
                }
            }
            return this.c - j2;
        }
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
                long j = this.c;
                long j2 = this.a;
                if (j == j2) {
                    return 0;
                }
                if (((long) i2) + j > j2) {
                    i2 = (int) (j2 - j);
                }
                nWrite(this.b, j, bArr, i, i2);
                this.c += (long) i2;
                return i2;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long c() throws IOException {
        if (!this.d.get()) {
            return this.c;
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
            this.c = j;
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
        if (this.d.get()) {
            throw new IOException("released!");
        } else if (bArr == null || i2 < 1 || i < 0 || i >= bArr.length) {
            return 0;
        } else {
            if (i + i2 > bArr.length) {
                i2 = bArr.length - i;
            }
            synchronized (this) {
                long j = this.c;
                long j2 = this.a;
                if (j == j2) {
                    return -1;
                }
                if (((long) i2) + j > j2) {
                    i2 = (int) (j2 - j);
                }
                nRead(this.b, j, bArr, i, i2);
                this.c += (long) i2;
                return i2;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void e() {
        if (!this.d.getAndSet(true)) {
            nRelease(this.b, this.a);
            this.b = 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public File f() {
        return this.e;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        try {
            e();
        } catch (Exception e2) {
            c.a(e2);
        }
    }
}
