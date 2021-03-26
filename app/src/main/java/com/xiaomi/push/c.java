package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class c {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final OutputStream f249a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f250a;
    private int b;

    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f249a = outputStream;
        this.f250a = bArr;
        this.b = 0;
        this.a = bArr.length;
    }

    private c(byte[] bArr, int i, int i2) {
        this.f249a = null;
        this.f250a = bArr;
        this.b = i;
        this.a = i + i2;
    }

    public static int a(int i) {
        if (i >= 0) {
            return d(i);
        }
        return 10;
    }

    public static int a(int i, int i2) {
        return c(i) + a(i2);
    }

    public static int a(int i, long j) {
        return c(i) + a(j);
    }

    public static int a(int i, a aVar) {
        return c(i) + a(aVar);
    }

    public static int a(int i, e eVar) {
        return c(i) + a(eVar);
    }

    public static int a(int i, String str) {
        return c(i) + a(str);
    }

    public static int a(int i, boolean z) {
        return c(i) + a(z);
    }

    public static int a(long j) {
        return c(j);
    }

    public static int a(a aVar) {
        return d(aVar.a()) + aVar.a();
    }

    public static int a(e eVar) {
        int b2 = eVar.mo212b();
        return d(b2) + b2;
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(boolean z) {
        return 1;
    }

    public static c a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static c a(OutputStream outputStream, int i) {
        return new c(outputStream, new byte[i]);
    }

    public static c a(byte[] bArr, int i, int i2) {
        return new c(bArr, i, i2);
    }

    public static int b(int i) {
        return d(i);
    }

    public static int b(int i, int i2) {
        return c(i) + b(i2);
    }

    public static int b(int i, long j) {
        return c(i) + b(j);
    }

    public static int b(long j) {
        return c(j);
    }

    public static int c(int i) {
        return d(f.a(i, 0));
    }

    public static int c(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private void c() {
        OutputStream outputStream = this.f249a;
        if (outputStream != null) {
            outputStream.write(this.f250a, 0, this.b);
            this.b = 0;
            return;
        }
        throw new a();
    }

    public static int d(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public int a() {
        if (this.f249a == null) {
            return this.a - this.b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m150a() {
        if (this.f249a != null) {
            c();
        }
    }

    public void a(byte b2) {
        if (this.b == this.a) {
            c();
        }
        byte[] bArr = this.f250a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m151a(int i) {
        if (i >= 0) {
            m170d(i);
        } else {
            m169c((long) i);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m152a(int i, int i2) {
        c(i, 0);
        m151a(i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m153a(int i, long j) {
        c(i, 0);
        m158a(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m154a(int i, a aVar) {
        c(i, 2);
        m159a(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m155a(int i, e eVar) {
        c(i, 2);
        m160a(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m156a(int i, String str) {
        c(i, 2);
        m161a(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m157a(int i, boolean z) {
        c(i, 0);
        m162a(z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m158a(long j) {
        m169c(j);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m159a(a aVar) {
        byte[] a2 = aVar.m99a();
        m170d(a2.length);
        a(a2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m160a(e eVar) {
        m170d(eVar.mo211a());
        eVar.a(this);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m161a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m170d(bytes.length);
        a(bytes);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m162a(boolean z) {
        m168c(z ? 1 : 0);
    }

    public void a(byte[] bArr) {
        m163a(bArr, 0, bArr.length);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m163a(byte[] bArr, int i, int i2) {
        int i3 = this.a;
        int i4 = this.b;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f250a, i4, i2);
            this.b += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f250a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.b = this.a;
        c();
        if (i7 <= this.a) {
            System.arraycopy(bArr, i6, this.f250a, 0, i7);
            this.b = i7;
            return;
        }
        this.f249a.write(bArr, i6, i7);
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m164b(int i) {
        m170d(i);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m165b(int i, int i2) {
        c(i, 0);
        m164b(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m166b(int i, long j) {
        c(i, 0);
        m167b(j);
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m167b(long j) {
        m169c(j);
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m168c(int i) {
        a((byte) i);
    }

    public void c(int i, int i2) {
        m170d(f.a(i, i2));
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m169c(long j) {
        while ((-128 & j) != 0) {
            m168c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m168c((int) j);
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m170d(int i) {
        while ((i & -128) != 0) {
            m168c((i & 127) | 128);
            i >>>= 7;
        }
        m168c(i);
    }
}
