package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TBinaryProtocol */
public class ca extends ch {
    protected static final int a = -65536;
    protected static final int b = -2147418112;
    private static final cm h = new cm();
    protected boolean c;
    protected boolean d;
    protected int e;
    protected boolean f;
    private byte[] i;
    private byte[] j;
    private byte[] k;

    /* renamed from: l  reason: collision with root package name */
    private byte[] f1464l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;

    @Override // com.umeng.analytics.pro.ch
    public void a() {
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(cm cmVar) {
    }

    @Override // com.umeng.analytics.pro.ch
    public void b() {
    }

    @Override // com.umeng.analytics.pro.ch
    public void c() {
    }

    @Override // com.umeng.analytics.pro.ch
    public void e() {
    }

    @Override // com.umeng.analytics.pro.ch
    public void f() {
    }

    @Override // com.umeng.analytics.pro.ch
    public void g() {
    }

    @Override // com.umeng.analytics.pro.ch
    public void i() {
    }

    @Override // com.umeng.analytics.pro.ch
    public void k() {
    }

    @Override // com.umeng.analytics.pro.ch
    public void m() {
    }

    @Override // com.umeng.analytics.pro.ch
    public void o() {
    }

    @Override // com.umeng.analytics.pro.ch
    public void q() {
    }

    @Override // com.umeng.analytics.pro.ch
    public void s() {
    }

    /* compiled from: TBinaryProtocol */
    public static class a implements cj {
        protected boolean a;
        protected boolean b;
        protected int c;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.a = false;
            this.b = true;
            this.a = z;
            this.b = z2;
            this.c = i;
        }

        @Override // com.umeng.analytics.pro.cj
        public ch a(cv cvVar) {
            ca caVar = new ca(cvVar, this.a, this.b);
            int i = this.c;
            if (i != 0) {
                caVar.c(i);
            }
            return caVar;
        }
    }

    public ca(cv cvVar) {
        this(cvVar, false, true);
    }

    public ca(cv cvVar, boolean z, boolean z2) {
        super(cvVar);
        this.c = false;
        this.d = true;
        this.f = false;
        this.i = new byte[1];
        this.j = new byte[2];
        this.k = new byte[4];
        this.f1464l = new byte[8];
        this.m = new byte[1];
        this.n = new byte[2];
        this.o = new byte[4];
        this.p = new byte[8];
        this.c = z;
        this.d = z2;
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(cf cfVar) throws bo {
        if (this.d) {
            a(-2147418112 | cfVar.b);
            a(cfVar.a);
            a(cfVar.c);
            return;
        }
        a(cfVar.a);
        a(cfVar.b);
        a(cfVar.c);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(cc ccVar) throws bo {
        a(ccVar.b);
        a(ccVar.c);
    }

    @Override // com.umeng.analytics.pro.ch
    public void d() throws bo {
        a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(ce ceVar) throws bo {
        a(ceVar.a);
        a(ceVar.b);
        a(ceVar.c);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(cd cdVar) throws bo {
        a(cdVar.a);
        a(cdVar.b);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(cl clVar) throws bo {
        a(clVar.a);
        a(clVar.b);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(boolean z) throws bo {
        a(z ? (byte) 1 : 0);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(byte b2) throws bo {
        this.i[0] = b2;
        this.g.b(this.i, 0, 1);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(short s) throws bo {
        byte[] bArr = this.j;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.g.b(this.j, 0, 2);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(int i2) throws bo {
        byte[] bArr = this.k;
        bArr[0] = (byte) ((i2 >> 24) & 255);
        bArr[1] = (byte) ((i2 >> 16) & 255);
        bArr[2] = (byte) ((i2 >> 8) & 255);
        bArr[3] = (byte) (i2 & 255);
        this.g.b(this.k, 0, 4);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(long j2) throws bo {
        byte[] bArr = this.f1464l;
        bArr[0] = (byte) ((int) ((j2 >> 56) & 255));
        bArr[1] = (byte) ((int) ((j2 >> 48) & 255));
        bArr[2] = (byte) ((int) ((j2 >> 40) & 255));
        bArr[3] = (byte) ((int) ((j2 >> 32) & 255));
        bArr[4] = (byte) ((int) ((j2 >> 24) & 255));
        bArr[5] = (byte) ((int) ((j2 >> 16) & 255));
        bArr[6] = (byte) ((int) ((j2 >> 8) & 255));
        bArr[7] = (byte) ((int) (j2 & 255));
        this.g.b(this.f1464l, 0, 8);
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(double d2) throws bo {
        a(Double.doubleToLongBits(d2));
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(String str) throws bo {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bo("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.ch
    public void a(ByteBuffer byteBuffer) throws bo {
        int limit = byteBuffer.limit() - byteBuffer.position();
        a(limit);
        this.g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.umeng.analytics.pro.ch
    public cf h() throws bo {
        int w = w();
        if (w < 0) {
            if ((-65536 & w) == -2147418112) {
                return new cf(z(), (byte) (w & 255), w());
            }
            throw new ci(4, "Bad version in readMessageBegin");
        } else if (!this.c) {
            return new cf(b(w), u(), w());
        } else {
            throw new ci(4, "Missing version in readMessageBegin, old client?");
        }
    }

    @Override // com.umeng.analytics.pro.ch
    public cm j() {
        return h;
    }

    @Override // com.umeng.analytics.pro.ch
    public cc l() throws bo {
        short s;
        byte u = u();
        if (u == 0) {
            s = 0;
        } else {
            s = v();
        }
        return new cc("", u, s);
    }

    @Override // com.umeng.analytics.pro.ch
    public ce n() throws bo {
        return new ce(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.ch
    public cd p() throws bo {
        return new cd(u(), w());
    }

    @Override // com.umeng.analytics.pro.ch
    public cl r() throws bo {
        return new cl(u(), w());
    }

    @Override // com.umeng.analytics.pro.ch
    public boolean t() throws bo {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.ch
    public byte u() throws bo {
        if (this.g.h() >= 1) {
            byte b2 = this.g.f()[this.g.g()];
            this.g.a(1);
            return b2;
        }
        a(this.m, 0, 1);
        return this.m[0];
    }

    @Override // com.umeng.analytics.pro.ch
    public short v() throws bo {
        byte[] bArr = this.n;
        int i2 = 0;
        if (this.g.h() >= 2) {
            bArr = this.g.f();
            i2 = this.g.g();
            this.g.a(2);
        } else {
            a(this.n, 0, 2);
        }
        return (short) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    @Override // com.umeng.analytics.pro.ch
    public int w() throws bo {
        byte[] bArr = this.o;
        int i2 = 0;
        if (this.g.h() >= 4) {
            bArr = this.g.f();
            i2 = this.g.g();
            this.g.a(4);
        } else {
            a(this.o, 0, 4);
        }
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.ch
    public long x() throws bo {
        byte[] bArr = this.p;
        int i2 = 0;
        if (this.g.h() >= 8) {
            bArr = this.g.f();
            i2 = this.g.g();
            this.g.a(8);
        } else {
            a(this.p, 0, 8);
        }
        return ((long) (bArr[i2 + 7] & 255)) | (((long) (bArr[i2] & 255)) << 56) | (((long) (bArr[i2 + 1] & 255)) << 48) | (((long) (bArr[i2 + 2] & 255)) << 40) | (((long) (bArr[i2 + 3] & 255)) << 32) | (((long) (bArr[i2 + 4] & 255)) << 24) | (((long) (bArr[i2 + 5] & 255)) << 16) | (((long) (bArr[i2 + 6] & 255)) << 8);
    }

    @Override // com.umeng.analytics.pro.ch
    public double y() throws bo {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.ch
    public String z() throws bo {
        int w = w();
        if (this.g.h() < w) {
            return b(w);
        }
        try {
            String str = new String(this.g.f(), this.g.g(), w, "UTF-8");
            this.g.a(w);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new bo("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public String b(int i2) throws bo {
        try {
            d(i2);
            byte[] bArr = new byte[i2];
            this.g.d(bArr, 0, i2);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new bo("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.ch
    public ByteBuffer A() throws bo {
        int w = w();
        d(w);
        if (this.g.h() >= w) {
            ByteBuffer wrap = ByteBuffer.wrap(this.g.f(), this.g.g(), w);
            this.g.a(w);
            return wrap;
        }
        byte[] bArr = new byte[w];
        this.g.d(bArr, 0, w);
        return ByteBuffer.wrap(bArr);
    }

    private int a(byte[] bArr, int i2, int i3) throws bo {
        d(i3);
        return this.g.d(bArr, i2, i3);
    }

    public void c(int i2) {
        this.e = i2;
        this.f = true;
    }

    protected void d(int i2) throws bo {
        if (i2 < 0) {
            throw new ci("Negative length: " + i2);
        } else if (this.f) {
            int i3 = this.e - i2;
            this.e = i3;
            if (i3 < 0) {
                throw new ci("Message length exceeded: " + i2);
            }
        }
    }
}
