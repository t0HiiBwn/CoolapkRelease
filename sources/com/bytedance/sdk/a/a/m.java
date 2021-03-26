package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* compiled from: RealBufferedSink */
final class m implements d {
    public final c a = new c();
    public final r b;
    boolean c;

    m(r rVar) {
        Objects.requireNonNull(rVar, "sink == null");
        this.b = rVar;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.e
    public c c() {
        return this.a;
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a_(c cVar, long j) throws IOException {
        if (!this.c) {
            this.a.a_(cVar, j);
            u();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d b(String str) throws IOException {
        if (!this.c) {
            this.a.b(str);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d c(byte[] bArr) throws IOException {
        if (!this.c) {
            this.a.c(bArr);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d c(byte[] bArr, int i, int i2) throws IOException {
        if (!this.c) {
            this.a.c(bArr, i, i2);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.c) {
            int write = this.a.write(byteBuffer);
            u();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d i(int i) throws IOException {
        if (!this.c) {
            this.a.i(i);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d h(int i) throws IOException {
        if (!this.c) {
            this.a.h(i);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d g(int i) throws IOException {
        if (!this.c) {
            this.a.g(i);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d l(long j) throws IOException {
        if (!this.c) {
            this.a.l(j);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d k(long j) throws IOException {
        if (!this.c) {
            this.a.k(j);
            return u();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d
    public d u() throws IOException {
        if (!this.c) {
            long g = this.a.g();
            if (g > 0) {
                this.b.a_(this.a, g);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() throws IOException {
        if (!this.c) {
            if (this.a.b > 0) {
                r rVar = this.b;
                c cVar = this.a;
                rVar.a_(cVar, cVar.b);
            }
            this.b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.c) {
            Throwable th = null;
            try {
                if (this.a.b > 0) {
                    r rVar = this.b;
                    c cVar = this.a;
                    rVar.a_(cVar, cVar.b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.c = true;
            if (th != null) {
                u.a(th);
            }
        }
    }

    @Override // com.bytedance.sdk.a.a.r
    public t a() {
        return this.b.a();
    }

    @Override // java.lang.Object
    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
