package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* compiled from: RealBufferedSource */
final class n implements e {
    public final c a = new c();
    public final s b;
    boolean c;

    n(s sVar) {
        Objects.requireNonNull(sVar, "source == null");
        this.b = sVar;
    }

    @Override // com.bytedance.sdk.a.a.e
    public c c() {
        return this.a;
    }

    @Override // com.bytedance.sdk.a.a.s
    public long a(c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.c) {
            throw new IllegalStateException("closed");
        } else if (this.a.b == 0 && this.b.a(this.a, 8192) == -1) {
            return -1;
        } else {
            return this.a.a(cVar, Math.min(j, this.a.b));
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public boolean e() throws IOException {
        if (!this.c) {
            return this.a.e() && this.b.a(this.a, 8192) == -1;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(long j) throws IOException {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    public boolean b(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.c) {
            while (this.a.b < j) {
                if (this.b.a(this.a, 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte h() throws IOException {
        a(1);
        return this.a.h();
    }

    @Override // com.bytedance.sdk.a.a.e
    public f c(long j) throws IOException {
        a(j);
        return this.a.c(j);
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte[] g(long j) throws IOException {
        a(j);
        return this.a.g(j);
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(byte[] bArr) throws IOException {
        try {
            a((long) bArr.length);
            this.a.a(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.a.b > 0) {
                c cVar = this.a;
                int a2 = cVar.a(bArr, i, (int) cVar.b);
                if (a2 != -1) {
                    i += a2;
                } else {
                    throw new AssertionError();
                }
            }
            throw e;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.a.b == 0 && this.b.a(this.a, 8192) == -1) {
            return -1;
        }
        return this.a.read(byteBuffer);
    }

    @Override // com.bytedance.sdk.a.a.e
    public String a(Charset charset) throws IOException {
        if (charset != null) {
            this.a.a(this.b);
            return this.a.a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.bytedance.sdk.a.a.e
    public String p() throws IOException {
        return e(Long.MAX_VALUE);
    }

    @Override // com.bytedance.sdk.a.a.e
    public String e(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long a2 = a((byte) 10, 0, j2);
            if (a2 != -1) {
                return this.a.f(a2);
            }
            if (j2 < Long.MAX_VALUE && b(j2) && this.a.b(j2 - 1) == 13 && b(1 + j2) && this.a.b(j2) == 10) {
                return this.a.f(j2);
            }
            c cVar = new c();
            c cVar2 = this.a;
            cVar2.a(cVar, 0, Math.min(32L, cVar2.b()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.a.b(), j) + " content=" + cVar.n().e() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // com.bytedance.sdk.a.a.e
    public short i() throws IOException {
        a(2);
        return this.a.i();
    }

    @Override // com.bytedance.sdk.a.a.e
    public short k() throws IOException {
        a(2);
        return this.a.k();
    }

    @Override // com.bytedance.sdk.a.a.e
    public int j() throws IOException {
        a(4);
        return this.a.j();
    }

    @Override // com.bytedance.sdk.a.a.e
    public int l() throws IOException {
        a(4);
        return this.a.l();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        if (r1 == 0) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // com.bytedance.sdk.a.a.e
    public long m() throws IOException {
        a(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!b((long) i2)) {
                break;
            }
            byte b2 = this.a.b((long) i);
            if ((b2 < 48 || b2 > 57) && ((b2 < 97 || b2 > 102) && (b2 < 65 || b2 > 70))) {
                break;
            }
            i = i2;
        }
        return this.a.m();
    }

    @Override // com.bytedance.sdk.a.a.e
    public void h(long j) throws IOException {
        if (!this.c) {
            while (j > 0) {
                if (this.a.b == 0 && this.b.a(this.a, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.a.b());
                this.a.h(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.a.a.e
    public long a(byte b2) throws IOException {
        return a(b2, 0, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        } else {
            while (j < j2) {
                long a2 = this.a.a(b2, j, j2);
                if (a2 == -1) {
                    long j3 = this.a.b;
                    if (j3 >= j2 || this.b.a(this.a, 8192) == -1) {
                        break;
                    }
                    j = Math.max(j, j3);
                } else {
                    return a2;
                }
            }
            return -1;
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public boolean a(long j, f fVar) throws IOException {
        return a(j, fVar, 0, fVar.g());
    }

    public boolean a(long j, f fVar, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || i < 0 || i2 < 0 || fVar.g() - i < i2) {
            return false;
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = ((long) i3) + j;
                if (!(b(1 + j2) && this.a.b(j2) == fVar.a(i + i3))) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public InputStream f() {
        return new InputStream() {
            /* class com.bytedance.sdk.a.a.n.AnonymousClass1 */

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (n.this.c) {
                    throw new IOException("closed");
                } else if (n.this.a.b == 0 && n.this.b.a(n.this.a, 8192) == -1) {
                    return -1;
                } else {
                    return n.this.a.h() & 255;
                }
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (!n.this.c) {
                    u.a((long) bArr.length, (long) i, (long) i2);
                    if (n.this.a.b == 0 && n.this.b.a(n.this.a, 8192) == -1) {
                        return -1;
                    }
                    return n.this.a.a(bArr, i, i2);
                }
                throw new IOException("closed");
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (!n.this.c) {
                    return (int) Math.min(n.this.a.b, 2147483647L);
                }
                throw new IOException("closed");
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                n.this.close();
            }

            @Override // java.lang.Object
            public String toString() {
                return n.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.c) {
            this.c = true;
            this.b.close();
            this.a.r();
        }
    }

    @Override // com.bytedance.sdk.a.a.s
    public t a() {
        return this.b.a();
    }

    @Override // java.lang.Object
    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
