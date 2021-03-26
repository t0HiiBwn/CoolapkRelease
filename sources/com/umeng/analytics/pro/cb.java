package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TCompactProtocol */
public class cb extends ch {
    private static final cm d = new cm("");
    private static final cc e = new cc("", (byte) 0, 0);
    private static final byte[] f;
    private static final byte h = -126;
    private static final byte i = 1;
    private static final byte j = 31;
    private static final byte k = -32;

    /* renamed from: l  reason: collision with root package name */
    private static final int f1465l = 5;
    byte[] a;
    byte[] b;
    byte[] c;
    private bg m;
    private short n;
    private cc o;
    private Boolean p;
    private final long q;
    private byte[] r;

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private long c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    private boolean c(byte b2) {
        int i2 = b2 & 15;
        return i2 == 1 || i2 == 2;
    }

    private long d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a() throws bo {
    }

    @Override // com.umeng.analytics.pro.ch
    public void c() throws bo {
    }

    @Override // com.umeng.analytics.pro.ch
    public void e() throws bo {
    }

    @Override // com.umeng.analytics.pro.ch
    public void f() throws bo {
    }

    @Override // com.umeng.analytics.pro.ch
    public void g() throws bo {
    }

    @Override // com.umeng.analytics.pro.ch
    public void i() throws bo {
    }

    @Override // com.umeng.analytics.pro.ch
    public void m() throws bo {
    }

    @Override // com.umeng.analytics.pro.ch
    public void o() throws bo {
    }

    @Override // com.umeng.analytics.pro.ch
    public void q() throws bo {
    }

    @Override // com.umeng.analytics.pro.ch
    public void s() throws bo {
    }

    static {
        byte[] bArr = new byte[16];
        f = bArr;
        bArr[0] = 0;
        bArr[2] = 1;
        bArr[3] = 3;
        bArr[6] = 4;
        bArr[8] = 5;
        bArr[10] = 6;
        bArr[4] = 7;
        bArr[11] = 8;
        bArr[15] = 9;
        bArr[14] = 10;
        bArr[13] = 11;
        bArr[12] = 12;
    }

    /* compiled from: TCompactProtocol */
    public static class a implements cj {
        private final long a;

        public a() {
            this.a = -1;
        }

        public a(int i) {
            this.a = (long) i;
        }

        @Override // com.umeng.analytics.pro.cj
        public ch a(cv cvVar) {
            return new cb(cvVar, this.a);
        }
    }

    /* compiled from: TCompactProtocol */
    private static class b {
        public static final byte a = 1;
        public static final byte b = 2;
        public static final byte c = 3;
        public static final byte d = 4;
        public static final byte e = 5;
        public static final byte f = 6;
        public static final byte g = 7;
        public static final byte h = 8;
        public static final byte i = 9;
        public static final byte j = 10;
        public static final byte k = 11;

        /* renamed from: l  reason: collision with root package name */
        public static final byte f1466l = 12;

        private b() {
        }
    }

    public cb(cv cvVar, long j2) {
        super(cvVar);
        this.m = new bg(15);
        this.n = 0;
        this.o = null;
        this.p = null;
        this.a = new byte[5];
        this.b = new byte[10];
        this.r = new byte[1];
        this.c = new byte[1];
        this.q = j2;
    }

    public cb(cv cvVar) {
        this(cvVar, -1);
    }

    @Override // com.umeng.analytics.pro.ch
    public void B() {
        this.m.c();
        this.n = 0;
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(cf cfVar) throws bo {
        b((byte) -126);
        d(((cfVar.b << 5) & -32) | 1);
        b(cfVar.c);
        a(cfVar.a);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(cm cmVar) throws bo {
        this.m.a(this.n);
        this.n = 0;
    }

    @Override // com.umeng.analytics.pro.ch
    public void b() throws bo {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(cc ccVar) throws bo {
        if (ccVar.b == 2) {
            this.o = ccVar;
        } else {
            a(ccVar, (byte) -1);
        }
    }

    private void a(cc ccVar, byte b2) throws bo {
        if (b2 == -1) {
            b2 = e(ccVar.b);
        }
        if (ccVar.c <= this.n || ccVar.c - this.n > 15) {
            b(b2);
            a(ccVar.c);
        } else {
            d(b2 | ((ccVar.c - this.n) << 4));
        }
        this.n = ccVar.c;
    }

    @Override // com.umeng.analytics.pro.ch
    public void d() throws bo {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(ce ceVar) throws bo {
        if (ceVar.c == 0) {
            d(0);
            return;
        }
        b(ceVar.c);
        d(e(ceVar.b) | (e(ceVar.a) << 4));
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(cd cdVar) throws bo {
        a(cdVar.a, cdVar.b);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(cl clVar) throws bo {
        a(clVar.a, clVar.b);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(boolean z) throws bo {
        cc ccVar = this.o;
        byte b2 = 1;
        if (ccVar != null) {
            if (!z) {
                b2 = 2;
            }
            a(ccVar, b2);
            this.o = null;
            return;
        }
        if (!z) {
            b2 = 2;
        }
        b(b2);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(byte b2) throws bo {
        b(b2);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(short s) throws bo {
        b(c((int) s));
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(int i2) throws bo {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(long j2) throws bo {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(double d2) throws bo {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(String str) throws bo {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bo("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(ByteBuffer byteBuffer) throws bo {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i2, int i3) throws bo {
        b(i3);
        this.g.b(bArr, i2, i3);
    }

    protected void a(byte b2, int i2) throws bo {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
            return;
        }
        d(e(b2) | 240);
        b(i2);
    }

    private void b(int i2) throws bo {
        int i3 = 0;
        while ((i2 & -128) != 0) {
            this.a[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i3++;
        }
        this.a[i3] = (byte) i2;
        this.g.b(this.a, 0, i3 + 1);
    }

    private void b(long j2) throws bo {
        int i2 = 0;
        while ((-128 & j2) != 0) {
            this.b[i2] = (byte) ((int) ((127 & j2) | 128));
            j2 >>>= 7;
            i2++;
        }
        this.b[i2] = (byte) ((int) j2);
        this.g.b(this.b, 0, i2 + 1);
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) ((int) (j2 & 255));
        bArr[i2 + 1] = (byte) ((int) ((j2 >> 8) & 255));
        bArr[i2 + 2] = (byte) ((int) ((j2 >> 16) & 255));
        bArr[i2 + 3] = (byte) ((int) ((j2 >> 24) & 255));
        bArr[i2 + 4] = (byte) ((int) ((j2 >> 32) & 255));
        bArr[i2 + 5] = (byte) ((int) ((j2 >> 40) & 255));
        bArr[i2 + 6] = (byte) ((int) ((j2 >> 48) & 255));
        bArr[i2 + 7] = (byte) ((int) ((j2 >> 56) & 255));
    }

    private void b(byte b2) throws bo {
        this.r[0] = b2;
        this.g.b(this.r);
    }

    private void d(int i2) throws bo {
        b((byte) i2);
    }

    @Override // com.umeng.analytics.pro.ch
    public cf h() throws bo {
        byte u = u();
        if (u == -126) {
            byte u2 = u();
            byte b2 = (byte) (u2 & 31);
            if (b2 == 1) {
                int E = E();
                return new cf(z(), (byte) ((u2 >> 5) & 3), E);
            }
            throw new ci("Expected version 1 but got " + ((int) b2));
        }
        throw new ci("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(u));
    }

    @Override // com.umeng.analytics.pro.ch
    public cm j() throws bo {
        this.m.a(this.n);
        this.n = 0;
        return d;
    }

    @Override // com.umeng.analytics.pro.ch
    public void k() throws bo {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.ch
    public cc l() throws bo {
        short s;
        byte u = u();
        if (u == 0) {
            return e;
        }
        short s2 = (short) ((u & 240) >> 4);
        if (s2 == 0) {
            s = v();
        } else {
            s = (short) (this.n + s2);
        }
        byte b2 = (byte) (u & 15);
        cc ccVar = new cc("", d(b2), s);
        if (c(u)) {
            this.p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = ccVar.c;
        return ccVar;
    }

    @Override // com.umeng.analytics.pro.ch
    public ce n() throws bo {
        byte b2;
        int E = E();
        if (E == 0) {
            b2 = 0;
        } else {
            b2 = u();
        }
        return new ce(d((byte) (b2 >> 4)), d((byte) (b2 & 15)), E);
    }

    @Override // com.umeng.analytics.pro.ch
    public cd p() throws bo {
        byte u = u();
        int i2 = (u >> 4) & 15;
        if (i2 == 15) {
            i2 = E();
        }
        return new cd(d(u), i2);
    }

    @Override // com.umeng.analytics.pro.ch
    public cl r() throws bo {
        return new cl(p());
    }

    @Override // com.umeng.analytics.pro.ch
    public boolean t() throws bo {
        Boolean bool = this.p;
        if (bool == null) {
            return u() == 1;
        }
        boolean booleanValue = bool.booleanValue();
        this.p = null;
        return booleanValue;
    }

    @Override // com.umeng.analytics.pro.ch
    public byte u() throws bo {
        if (this.g.h() > 0) {
            byte b2 = this.g.f()[this.g.g()];
            this.g.a(1);
            return b2;
        }
        this.g.d(this.c, 0, 1);
        return this.c[0];
    }

    @Override // com.umeng.analytics.pro.ch
    public short v() throws bo {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.ch
    public int w() throws bo {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.ch
    public long x() throws bo {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.ch
    public double y() throws bo {
        byte[] bArr = new byte[8];
        this.g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.ch
    public String z() throws bo {
        int E = E();
        f(E);
        if (E == 0) {
            return "";
        }
        try {
            if (this.g.h() < E) {
                return new String(e(E), "UTF-8");
            }
            String str = new String(this.g.f(), this.g.g(), E, "UTF-8");
            this.g.a(E);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new bo("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.ch
    public ByteBuffer A() throws bo {
        int E = E();
        f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.g.d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    private byte[] e(int i2) throws bo {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) throws ci {
        if (i2 >= 0) {
            long j2 = this.q;
            if (j2 != -1 && ((long) i2) > j2) {
                throw new ci("Length exceeded max allowed: " + i2);
            }
            return;
        }
        throw new ci("Negative length: " + i2);
    }

    private int E() throws bo {
        int i2 = 0;
        if (this.g.h() >= 5) {
            byte[] f2 = this.g.f();
            int g = this.g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = f2[g + i2];
                i3 |= (b2 & Byte.MAX_VALUE) << i4;
                if ((b2 & 128) != 128) {
                    this.g.a(i2 + 1);
                    return i3;
                }
                i4 += 7;
                i2++;
            }
        } else {
            int i5 = 0;
            while (true) {
                byte u = u();
                i2 |= (u & Byte.MAX_VALUE) << i5;
                if ((u & 128) != 128) {
                    return i2;
                }
                i5 += 7;
            }
        }
    }

    private long F() throws bo {
        int i2 = 0;
        long j2 = 0;
        if (this.g.h() >= 10) {
            byte[] f2 = this.g.f();
            int g = this.g.g();
            long j3 = 0;
            int i3 = 0;
            while (true) {
                byte b2 = f2[g + i2];
                j3 |= ((long) (b2 & Byte.MAX_VALUE)) << i3;
                if ((b2 & 128) != 128) {
                    this.g.a(i2 + 1);
                    return j3;
                }
                i3 += 7;
                i2++;
            }
        } else {
            while (true) {
                byte u = u();
                j2 |= ((long) (u & Byte.MAX_VALUE)) << i2;
                if ((u & 128) != 128) {
                    return j2;
                }
                i2 += 7;
            }
        }
    }

    private long a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (255 & ((long) bArr[0]));
    }

    private byte d(byte b2) throws ci {
        byte b3 = (byte) (b2 & 15);
        switch (b3) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 6;
            case 5:
                return 8;
            case 6:
                return 10;
            case 7:
                return 4;
            case 8:
                return 11;
            case 9:
                return 15;
            case 10:
                return 14;
            case 11:
                return 13;
            case 12:
                return 12;
            default:
                throw new ci("don't know what type: " + ((int) b3));
        }
    }

    private byte e(byte b2) {
        return f[b2];
    }
}
