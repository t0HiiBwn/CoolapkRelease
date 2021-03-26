package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* compiled from: Buffer */
public final class c implements d, e, Cloneable, ByteChannel {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    o a;
    long b;

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.e
    public c c() {
        return this;
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* renamed from: d */
    public c u() {
        return this;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final long b() {
        return this.b;
    }

    @Override // com.bytedance.sdk.a.a.e
    public boolean e() {
        return this.b == 0;
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(long j) throws EOFException {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public InputStream f() {
        return new InputStream() {
            /* class com.bytedance.sdk.a.a.c.AnonymousClass1 */

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (c.this.b > 0) {
                    return c.this.h() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return c.this.a(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(c.this.b, 2147483647L);
            }

            @Override // java.lang.Object
            public String toString() {
                return c.this + ".inputStream()";
            }
        };
    }

    public final c a(c cVar, long j, long j2) {
        if (cVar != null) {
            u.a(this.b, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.b += j2;
            o oVar = this.a;
            while (j >= ((long) (oVar.c - oVar.b))) {
                j -= (long) (oVar.c - oVar.b);
                oVar = oVar.f;
            }
            while (j2 > 0) {
                o a2 = oVar.a();
                a2.b = (int) (((long) a2.b) + j);
                a2.c = Math.min(a2.b + ((int) j2), a2.c);
                o oVar2 = cVar.a;
                if (oVar2 == null) {
                    a2.g = a2;
                    a2.f = a2;
                    cVar.a = a2;
                } else {
                    oVar2.g.a(a2);
                }
                j2 -= (long) (a2.c - a2.b);
                oVar = oVar.f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final long g() {
        long j = this.b;
        if (j == 0) {
            return 0;
        }
        o oVar = this.a.g;
        return (oVar.c >= 8192 || !oVar.e) ? j : j - ((long) (oVar.c - oVar.b));
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte h() {
        if (this.b != 0) {
            o oVar = this.a;
            int i = oVar.b;
            int i2 = oVar.c;
            int i3 = i + 1;
            byte b2 = oVar.a[i];
            this.b--;
            if (i3 == i2) {
                this.a = oVar.b();
                p.a(oVar);
            } else {
                oVar.b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public final byte b(long j) {
        u.a(this.b, j, 1);
        long j2 = this.b;
        if (j2 - j > j) {
            o oVar = this.a;
            while (true) {
                long j3 = (long) (oVar.c - oVar.b);
                if (j < j3) {
                    return oVar.a[oVar.b + ((int) j)];
                }
                j -= j3;
                oVar = oVar.f;
            }
        } else {
            long j4 = j - j2;
            o oVar2 = this.a;
            do {
                oVar2 = oVar2.g;
                j4 += (long) (oVar2.c - oVar2.b);
            } while (j4 < 0);
            return oVar2.a[oVar2.b + ((int) j4)];
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public short i() {
        if (this.b >= 2) {
            o oVar = this.a;
            int i = oVar.b;
            int i2 = oVar.c;
            if (i2 - i < 2) {
                return (short) (((h() & 255) << 8) | (h() & 255));
            }
            byte[] bArr = oVar.a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.b -= 2;
            if (i4 == i2) {
                this.a = oVar.b();
                p.a(oVar);
            } else {
                oVar.b = i4;
            }
            return (short) i5;
        }
        throw new IllegalStateException("size < 2: " + this.b);
    }

    @Override // com.bytedance.sdk.a.a.e
    public int j() {
        if (this.b >= 4) {
            o oVar = this.a;
            int i = oVar.b;
            int i2 = oVar.c;
            if (i2 - i < 4) {
                return ((h() & 255) << 24) | ((h() & 255) << 16) | ((h() & 255) << 8) | (h() & 255);
            }
            byte[] bArr = oVar.a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            this.b -= 4;
            if (i8 == i2) {
                this.a = oVar.b();
                p.a(oVar);
            } else {
                oVar.b = i8;
            }
            return i9;
        }
        throw new IllegalStateException("size < 4: " + this.b);
    }

    @Override // com.bytedance.sdk.a.a.e
    public short k() {
        return u.a(i());
    }

    @Override // com.bytedance.sdk.a.a.e
    public int l() {
        return u.a(j());
    }

    @Override // com.bytedance.sdk.a.a.e
    public long m() {
        byte b2;
        int i;
        int i2;
        if (this.b != 0) {
            int i3 = 0;
            long j = 0;
            boolean z = false;
            do {
                o oVar = this.a;
                byte[] bArr = oVar.a;
                int i4 = oVar.b;
                int i5 = oVar.c;
                while (true) {
                    if (i4 >= i5) {
                        break;
                    }
                    b2 = bArr[i4];
                    if (b2 < 48 || b2 > 57) {
                        if (b2 >= 97 && b2 <= 102) {
                            i2 = b2 - 97;
                        } else if (b2 < 65 || b2 > 70) {
                            break;
                        } else {
                            i2 = b2 - 65;
                        }
                        i = i2 + 10;
                    } else {
                        i = b2 - 48;
                    }
                    if ((-1152921504606846976L & j) == 0) {
                        j = (j << 4) | ((long) i);
                        i4++;
                        i3++;
                    } else {
                        c b3 = new c().k(j).i((int) b2);
                        throw new NumberFormatException("Number too large: " + b3.o());
                    }
                }
                if (i3 != 0) {
                    z = true;
                    if (i4 == i5) {
                        this.a = oVar.b();
                        p.a(oVar);
                    } else {
                        oVar.b = i4;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b2));
                }
            } while (this.a != null);
            this.b -= (long) i3;
            return j;
        }
        throw new IllegalStateException("size == 0");
    }

    public f n() {
        return new f(q());
    }

    @Override // com.bytedance.sdk.a.a.e
    public f c(long j) throws EOFException {
        return new f(g(j));
    }

    public String o() {
        try {
            return a(this.b, u.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String d(long j) throws EOFException {
        return a(j, u.a);
    }

    @Override // com.bytedance.sdk.a.a.e
    public String a(Charset charset) {
        try {
            return a(this.b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String a(long j, Charset charset) throws EOFException {
        u.a(this.b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            o oVar = this.a;
            if (((long) oVar.b) + j > ((long) oVar.c)) {
                return new String(g(j), charset);
            }
            String str = new String(oVar.a, oVar.b, (int) j, charset);
            oVar.b = (int) (((long) oVar.b) + j);
            this.b -= j;
            if (oVar.b == oVar.c) {
                this.a = oVar.b();
                p.a(oVar);
            }
            return str;
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public String p() throws EOFException {
        return e(Long.MAX_VALUE);
    }

    @Override // com.bytedance.sdk.a.a.e
    public String e(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long a2 = a((byte) 10, 0, j2);
            if (a2 != -1) {
                return f(a2);
            }
            if (j2 < b() && b(j2 - 1) == 13 && b(j2) == 10) {
                return f(j2);
            }
            c cVar = new c();
            a(cVar, 0, Math.min(32L, b()));
            throw new EOFException("\\n not found: limit=" + Math.min(b(), j) + " content=" + cVar.n().e() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    String f(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (b(j2) == 13) {
                String d = d(j2);
                h(2L);
                return d;
            }
        }
        String d2 = d(j);
        h(1L);
        return d2;
    }

    public byte[] q() {
        try {
            return g(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte[] g(long j) throws EOFException {
        u.a(this.b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 != -1) {
                i += a2;
            } else {
                throw new EOFException();
            }
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        u.a((long) bArr.length, (long) i, (long) i2);
        o oVar = this.a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i2, oVar.c - oVar.b);
        System.arraycopy(oVar.a, oVar.b, bArr, i, min);
        oVar.b += min;
        this.b -= (long) min;
        if (oVar.b == oVar.c) {
            this.a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        o oVar = this.a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.c - oVar.b);
        byteBuffer.put(oVar.a, oVar.b, min);
        oVar.b += min;
        this.b -= (long) min;
        if (oVar.b == oVar.c) {
            this.a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    public final void r() {
        try {
            h(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public void h(long j) throws EOFException {
        while (j > 0) {
            o oVar = this.a;
            if (oVar != null) {
                int min = (int) Math.min(j, (long) (oVar.c - this.a.b));
                long j2 = (long) min;
                this.b -= j2;
                j -= j2;
                this.a.b += min;
                if (this.a.b == this.a.c) {
                    o oVar2 = this.a;
                    this.a = oVar2.b();
                    p.a(oVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public c a(f fVar) {
        if (fVar != null) {
            fVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: a */
    public c b(String str) {
        return a(str, 0, str.length());
    }

    public c a(String str, int i, int i2) {
        char c2;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    o e = e(1);
                    byte[] bArr = e.a;
                    int i3 = e.c - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (i4 < min) {
                        char charAt2 = str.charAt(i4);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i4 + i3] = (byte) charAt2;
                        i4++;
                    }
                    int i5 = (i3 + i4) - e.c;
                    e.c += i5;
                    this.b += (long) i5;
                    i = i4;
                } else {
                    if (charAt < 2048) {
                        i((charAt >> 6) | 192);
                        i((charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        i((charAt >> '\f') | 224);
                        i(((charAt >> 6) & 63) | 128);
                        i((charAt & '?') | 128);
                    } else {
                        int i6 = i + 1;
                        if (i6 < i2) {
                            c2 = str.charAt(i6);
                        } else {
                            c2 = 0;
                        }
                        if (charAt > 56319 || c2 < 56320 || c2 > 57343) {
                            i(63);
                            i = i6;
                        } else {
                            int i7 = (((charAt & 10239) << 10) | (9215 & c2)) + 65536;
                            i((i7 >> 18) | 240);
                            i(((i7 >> 12) & 63) | 128);
                            i(((i7 >> 6) & 63) | 128);
                            i((i7 & 63) | 128);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    public c a(int i) {
        if (i < 128) {
            i(i);
        } else if (i < 2048) {
            i((i >> 6) | 192);
            i((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                i((i >> 12) | 224);
                i(((i >> 6) & 63) | 128);
                i((i & 63) | 128);
            } else {
                i(63);
            }
        } else if (i <= 1114111) {
            i((i >> 18) | 240);
            i(((i >> 12) & 63) | 128);
            i(((i >> 6) & 63) | 128);
            i((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public c a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(u.a)) {
            return a(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return c(bytes, 0, bytes.length);
        }
    }

    /* renamed from: b */
    public c c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: b */
    public c c(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            u.a((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                o e = e(1);
                int min = Math.min(i3 - i, 8192 - e.c);
                System.arraycopy(bArr, i, e.a, e.c, min);
                i += min;
                e.c += min;
            }
            this.b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                o e = e(1);
                int min = Math.min(i, 8192 - e.c);
                byteBuffer.get(e.a, e.c, min);
                i -= min;
                e.c += min;
            }
            this.b += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long a(s sVar) throws IOException {
        if (sVar != null) {
            long j = 0;
            while (true) {
                long a2 = sVar.a(this, 8192);
                if (a2 == -1) {
                    return j;
                }
                j += a2;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: b */
    public c i(int i) {
        o e = e(1);
        byte[] bArr = e.a;
        int i2 = e.c;
        e.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    /* renamed from: c */
    public c h(int i) {
        o e = e(2);
        byte[] bArr = e.a;
        int i2 = e.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        e.c = i3 + 1;
        this.b += 2;
        return this;
    }

    /* renamed from: d */
    public c g(int i) {
        o e = e(4);
        byte[] bArr = e.a;
        int i2 = e.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        e.c = i5 + 1;
        this.b += 4;
        return this;
    }

    /* renamed from: i */
    public c l(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return i(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        o e = e(i2);
        byte[] bArr = e.a;
        int i3 = e.c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        e.c += i2;
        this.b += (long) i2;
        return this;
    }

    /* renamed from: j */
    public c k(long j) {
        if (j == 0) {
            return i(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        o e = e(numberOfTrailingZeros);
        byte[] bArr = e.a;
        int i = e.c;
        for (int i2 = (e.c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        e.c += numberOfTrailingZeros;
        this.b += (long) numberOfTrailingZeros;
        return this;
    }

    o e(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        o oVar = this.a;
        if (oVar == null) {
            o a2 = p.a();
            this.a = a2;
            a2.g = a2;
            a2.f = a2;
            return a2;
        }
        o oVar2 = oVar.g;
        return (oVar2.c + i > 8192 || !oVar2.e) ? oVar2.a(p.a()) : oVar2;
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a_(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (cVar != this) {
            u.a(cVar.b, 0, j);
            while (j > 0) {
                if (j < ((long) (cVar.a.c - cVar.a.b))) {
                    o oVar = this.a;
                    o oVar2 = oVar != null ? oVar.g : null;
                    if (oVar2 != null && oVar2.e) {
                        if ((((long) oVar2.c) + j) - ((long) (oVar2.d ? 0 : oVar2.b)) <= 8192) {
                            cVar.a.a(oVar2, (int) j);
                            cVar.b -= j;
                            this.b += j;
                            return;
                        }
                    }
                    cVar.a = cVar.a.a((int) j);
                }
                o oVar3 = cVar.a;
                long j2 = (long) (oVar3.c - oVar3.b);
                cVar.a = oVar3.b();
                o oVar4 = this.a;
                if (oVar4 == null) {
                    this.a = oVar3;
                    oVar3.g = oVar3;
                    oVar3.f = oVar3;
                } else {
                    oVar4.g.a(oVar3).c();
                }
                cVar.b -= j2;
                this.b += j2;
                j -= j2;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    @Override // com.bytedance.sdk.a.a.s
    public long a(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.b;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            cVar.a_(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public long a(byte b2) {
        return a(b2, 0, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) {
        o oVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.b), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.b;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (oVar = this.a) == null) {
            return -1;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                oVar = oVar.g;
                j4 -= (long) (oVar.c - oVar.b);
            }
        } else {
            while (true) {
                long j6 = ((long) (oVar.c - oVar.b)) + j3;
                if (j6 >= j) {
                    break;
                }
                oVar = oVar.f;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = oVar.a;
            int min = (int) Math.min((long) oVar.c, (((long) oVar.b) + j5) - j4);
            for (int i = (int) ((((long) oVar.b) + j7) - j4); i < min; i++) {
                if (bArr[i] == b2) {
                    return ((long) (i - oVar.b)) + j4;
                }
            }
            j4 += (long) (oVar.c - oVar.b);
            oVar = oVar.f;
            j7 = j4;
        }
        return -1;
    }

    @Override // com.bytedance.sdk.a.a.e
    public boolean a(long j, f fVar) {
        return a(j, fVar, 0, fVar.g());
    }

    public boolean a(long j, f fVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.b - j < ((long) i2) || fVar.g() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (b(((long) i3) + j) != fVar.a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.a.a.r
    public t a() {
        return t.c;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j = this.b;
        if (j != cVar.b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        o oVar = this.a;
        o oVar2 = cVar.a;
        int i = oVar.b;
        int i2 = oVar2.b;
        while (j2 < this.b) {
            long min = (long) Math.min(oVar.c - i, oVar2.c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (oVar.a[i] != oVar2.a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == oVar.c) {
                oVar = oVar.f;
                i = oVar.b;
            }
            if (i2 == oVar2.c) {
                oVar2 = oVar2.f;
                i2 = oVar2.b;
            }
            j2 += min;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        o oVar = this.a;
        if (oVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = oVar.c;
            for (int i3 = oVar.b; i3 < i2; i3++) {
                i = (i * 31) + oVar.a[i3];
            }
            oVar = oVar.f;
        } while (oVar != this.a);
        return i;
    }

    @Override // java.lang.Object
    public String toString() {
        return t().toString();
    }

    /* renamed from: s */
    public c clone() {
        c cVar = new c();
        if (this.b == 0) {
            return cVar;
        }
        o a2 = this.a.a();
        cVar.a = a2;
        a2.g = a2;
        a2.f = a2;
        o oVar = this.a;
        while (true) {
            oVar = oVar.f;
            if (oVar != this.a) {
                cVar.a.g.a(oVar.a());
            } else {
                cVar.b = this.b;
                return cVar;
            }
        }
    }

    public final f t() {
        long j = this.b;
        if (j <= 2147483647L) {
            return f((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }

    public final f f(int i) {
        if (i == 0) {
            return f.b;
        }
        return new q(this, i);
    }
}
