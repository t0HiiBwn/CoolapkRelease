package com.loc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* compiled from: FlatBufferBuilder */
public class er {
    static final Charset c = Charset.forName("UTF-8");
    static final /* synthetic */ boolean p = true;
    ByteBuffer a;
    int b;
    int d;
    int[] e;
    int f;
    boolean g;
    boolean h;
    int i;
    int[] j;
    int k;
    int l;
    boolean m;
    CharsetEncoder n;
    ByteBuffer o;

    private er() {
        this.d = 1;
        this.e = null;
        this.f = 0;
        this.g = false;
        this.h = false;
        this.j = new int[16];
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.n = c.newEncoder();
        this.b = 1024;
        this.a = d(1024);
    }

    public er(ByteBuffer byteBuffer) {
        this.d = 1;
        this.e = null;
        this.f = 0;
        this.g = false;
        this.h = false;
        this.j = new int[16];
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.n = c.newEncoder();
        a(byteBuffer);
    }

    private void a(short s) {
        c(2, 0);
        ByteBuffer byteBuffer = this.a;
        int i2 = this.b - 2;
        this.b = i2;
        byteBuffer.putShort(i2, s);
    }

    private void c(int i2, int i3) {
        if (i2 > this.d) {
            this.d = i2;
        }
        int i4 = ((~((this.a.capacity() - this.b) + i3)) + 1) & (i2 - 1);
        while (this.b < i4 + i2 + i3) {
            int capacity = this.a.capacity();
            ByteBuffer byteBuffer = this.a;
            int capacity2 = byteBuffer.capacity();
            if ((-1073741824 & capacity2) == 0) {
                int i5 = capacity2 << 1;
                byteBuffer.position(0);
                ByteBuffer d2 = d(i5);
                d2.position(i5 - capacity2);
                d2.put(byteBuffer);
                this.a = d2;
                this.b += d2.capacity() - capacity;
            } else {
                throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
            }
        }
        e(i4);
    }

    private int d() {
        return this.a.capacity() - this.b;
    }

    private static ByteBuffer d(int i2) {
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return allocate;
    }

    private void e() {
        if (this.g) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    private void e(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer byteBuffer = this.a;
            int i4 = this.b - 1;
            this.b = i4;
            byteBuffer.put(i4, (byte) 0);
        }
    }

    private void f(int i2) {
        ByteBuffer byteBuffer = this.a;
        int i3 = this.b - 4;
        this.b = i3;
        byteBuffer.putInt(i3, i2);
    }

    private void g(int i2) {
        c(4, 0);
        f(i2);
    }

    private void h(int i2) {
        this.e[i2] = d();
    }

    public final int a() {
        if (this.g) {
            this.g = false;
            f(this.l);
            return d();
        }
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public int a(CharSequence charSequence) {
        int length = (int) (((float) charSequence.length()) * this.n.maxBytesPerChar());
        ByteBuffer byteBuffer = this.o;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            this.o = ByteBuffer.allocate(Math.max(128, length));
        }
        this.o.clear();
        CoderResult encode = this.n.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), this.o, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e2) {
                throw new Error(e2);
            }
        }
        this.o.flip();
        ByteBuffer byteBuffer2 = this.o;
        int remaining = byteBuffer2.remaining();
        a((byte) 0);
        a(1, remaining, 1);
        ByteBuffer byteBuffer3 = this.a;
        int i2 = this.b - remaining;
        this.b = i2;
        byteBuffer3.position(i2);
        this.a.put(byteBuffer2);
        return a();
    }

    public final er a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        byteBuffer.clear();
        this.a.order(ByteOrder.LITTLE_ENDIAN);
        this.d = 1;
        this.b = this.a.capacity();
        this.f = 0;
        this.g = false;
        this.h = false;
        this.i = 0;
        this.k = 0;
        this.l = 0;
        return this;
    }

    public final void a(byte b2) {
        c(1, 0);
        ByteBuffer byteBuffer = this.a;
        int i2 = this.b - 1;
        this.b = i2;
        byteBuffer.put(i2, b2);
    }

    public final void a(int i2) {
        c(4, 0);
        if (p || i2 <= d()) {
            f((d() - i2) + 4);
            return;
        }
        throw new AssertionError();
    }

    public final void a(int i2, byte b2) {
        if (this.m || b2 != 0) {
            a(b2);
            h(i2);
        }
    }

    public final void a(int i2, int i3) {
        if (this.m || i3 != 0) {
            g(i3);
            h(i2);
        }
    }

    public final void a(int i2, int i3, int i4) {
        e();
        this.l = i3;
        int i5 = i2 * i3;
        c(4, i5);
        c(i4, i5);
        this.g = true;
    }

    public final void a(int i2, long j2) {
        if (this.m || j2 != 0) {
            c(8, 0);
            ByteBuffer byteBuffer = this.a;
            int i3 = this.b - 8;
            this.b = i3;
            byteBuffer.putLong(i3, j2);
            h(i2);
        }
    }

    public final void a(int i2, short s) {
        if (this.m || s != 0) {
            a(s);
            h(i2);
        }
    }

    public final void a(boolean z) {
        if (this.m || z) {
            c(1, 0);
            ByteBuffer byteBuffer = this.a;
            int i2 = this.b - 1;
            this.b = i2;
            byteBuffer.put(i2, z ? (byte) 1 : 0);
            h(0);
        }
    }

    public final int b() {
        int i2;
        if (this.e == null || !this.g) {
            throw new AssertionError("FlatBuffers: endObject called without startObject");
        }
        g(0);
        int d2 = d();
        for (int i3 = this.f - 1; i3 >= 0; i3--) {
            int[] iArr = this.e;
            a((short) (iArr[i3] != 0 ? d2 - iArr[i3] : 0));
        }
        a((short) (d2 - this.i));
        a((short) ((this.f + 2) * 2));
        int i4 = 0;
        loop1:
        while (true) {
            if (i4 >= this.k) {
                i2 = 0;
                break;
            }
            int capacity = this.a.capacity() - this.j[i4];
            int i5 = this.b;
            short s = this.a.getShort(capacity);
            if (s == this.a.getShort(i5)) {
                for (int i6 = 2; i6 < s; i6 += 2) {
                    if (this.a.getShort(capacity + i6) == this.a.getShort(i5 + i6)) {
                    }
                }
                i2 = this.j[i4];
                break loop1;
            }
            i4++;
        }
        if (i2 != 0) {
            int capacity2 = this.a.capacity() - d2;
            this.b = capacity2;
            this.a.putInt(capacity2, i2 - d2);
        } else {
            int i7 = this.k;
            int[] iArr2 = this.j;
            if (i7 == iArr2.length) {
                this.j = Arrays.copyOf(iArr2, i7 * 2);
            }
            int[] iArr3 = this.j;
            int i8 = this.k;
            this.k = i8 + 1;
            iArr3[i8] = d();
            ByteBuffer byteBuffer = this.a;
            byteBuffer.putInt(byteBuffer.capacity() - d2, d() - d2);
        }
        this.g = false;
        return d2;
    }

    public final void b(int i2) {
        e();
        int[] iArr = this.e;
        if (iArr == null || iArr.length < i2) {
            this.e = new int[i2];
        }
        this.f = i2;
        Arrays.fill(this.e, 0, i2, 0);
        this.g = true;
        this.i = d();
    }

    public final void b(int i2, int i3) {
        if (this.m || i3 != 0) {
            a(i3);
            h(i2);
        }
    }

    public final void c(int i2) {
        c(this.d, 4);
        a(i2);
        this.a.position(this.b);
        this.h = true;
    }

    public final byte[] c() {
        int i2 = this.b;
        int capacity = this.a.capacity() - this.b;
        if (this.h) {
            byte[] bArr = new byte[capacity];
            this.a.position(i2);
            this.a.get(bArr);
            return bArr;
        }
        throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
    }
}
