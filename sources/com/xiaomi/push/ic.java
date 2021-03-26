package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class ic extends ig {
    private static final il f = new il();
    protected boolean a = false;
    protected boolean b = true;
    protected int c;
    protected boolean d = false;
    private byte[] g = new byte[1];
    private byte[] h = new byte[2];
    private byte[] i = new byte[4];
    private byte[] j = new byte[8];
    private byte[] k = new byte[1];
    private byte[] l = new byte[2];
    private byte[] m = new byte[4];
    private byte[] n = new byte[8];

    public static class a implements ii {
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

        @Override // com.xiaomi.push.ii
        public ig a(iq iqVar) {
            ic icVar = new ic(iqVar, this.a, this.b);
            int i = this.c;
            if (i != 0) {
                icVar.c(i);
            }
            return icVar;
        }
    }

    public ic(iq iqVar, boolean z, boolean z2) {
        super(iqVar);
        this.a = z;
        this.b = z2;
    }

    private int a(byte[] bArr, int i2, int i3) {
        d(i3);
        return this.e.d(bArr, i2, i3);
    }

    @Override // com.xiaomi.push.ig
    public void a() {
    }

    @Override // com.xiaomi.push.ig
    public void a(byte b2) {
        this.g[0] = b2;
        this.e.b(this.g, 0, 1);
    }

    @Override // com.xiaomi.push.ig
    public void a(int i2) {
        byte[] bArr = this.i;
        bArr[0] = (byte) ((i2 >> 24) & 255);
        bArr[1] = (byte) ((i2 >> 16) & 255);
        bArr[2] = (byte) ((i2 >> 8) & 255);
        bArr[3] = (byte) (i2 & 255);
        this.e.b(this.i, 0, 4);
    }

    @Override // com.xiaomi.push.ig
    public void a(long j2) {
        byte[] bArr = this.j;
        bArr[0] = (byte) ((int) ((j2 >> 56) & 255));
        bArr[1] = (byte) ((int) ((j2 >> 48) & 255));
        bArr[2] = (byte) ((int) ((j2 >> 40) & 255));
        bArr[3] = (byte) ((int) ((j2 >> 32) & 255));
        bArr[4] = (byte) ((int) ((j2 >> 24) & 255));
        bArr[5] = (byte) ((int) ((j2 >> 16) & 255));
        bArr[6] = (byte) ((int) ((j2 >> 8) & 255));
        bArr[7] = (byte) ((int) (j2 & 255));
        this.e.b(this.j, 0, 8);
    }

    @Override // com.xiaomi.push.ig
    public void a(id idVar) {
        a(idVar.b);
        a(idVar.c);
    }

    @Override // com.xiaomi.push.ig
    public void a(ie ieVar) {
        a(ieVar.a);
        a(ieVar.b);
    }

    @Override // com.xiaomi.push.ig
    public void a(Cif ifVar) {
        a(ifVar.a);
        a(ifVar.b);
        a(ifVar.c);
    }

    @Override // com.xiaomi.push.ig
    public void a(il ilVar) {
    }

    @Override // com.xiaomi.push.ig
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.e.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new ia("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ig
    public void a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        a(limit);
        this.e.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.ig
    public void a(short s) {
        byte[] bArr = this.h;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.e.b(this.h, 0, 2);
    }

    @Override // com.xiaomi.push.ig
    public void a(boolean z) {
        a(z ? (byte) 1 : 0);
    }

    public String b(int i2) {
        try {
            d(i2);
            byte[] bArr = new byte[i2];
            this.e.d(bArr, 0, i2);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new ia("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ig
    public void b() {
    }

    @Override // com.xiaomi.push.ig
    public void c() {
        a((byte) 0);
    }

    public void c(int i2) {
        this.c = i2;
        this.d = true;
    }

    @Override // com.xiaomi.push.ig
    public void d() {
    }

    protected void d(int i2) {
        if (i2 < 0) {
            throw new ia("Negative length: " + i2);
        } else if (this.d) {
            int i3 = this.c - i2;
            this.c = i3;
            if (i3 < 0) {
                throw new ia("Message length exceeded: " + i2);
            }
        }
    }

    @Override // com.xiaomi.push.ig
    public void e() {
    }

    @Override // com.xiaomi.push.ig
    public il f() {
        return f;
    }

    @Override // com.xiaomi.push.ig
    public void g() {
    }

    @Override // com.xiaomi.push.ig
    public id h() {
        byte q = q();
        return new id("", q, q == 0 ? 0 : r());
    }

    @Override // com.xiaomi.push.ig
    public void i() {
    }

    @Override // com.xiaomi.push.ig
    public Cif j() {
        return new Cif(q(), q(), s());
    }

    @Override // com.xiaomi.push.ig
    public void k() {
    }

    @Override // com.xiaomi.push.ig
    public ie l() {
        return new ie(q(), s());
    }

    @Override // com.xiaomi.push.ig
    public void m() {
    }

    @Override // com.xiaomi.push.ig
    public ik n() {
        return new ik(q(), s());
    }

    @Override // com.xiaomi.push.ig
    public void o() {
    }

    @Override // com.xiaomi.push.ig
    public boolean p() {
        return q() == 1;
    }

    @Override // com.xiaomi.push.ig
    public byte q() {
        if (this.e.c() >= 1) {
            byte b2 = this.e.a()[this.e.b()];
            this.e.a(1);
            return b2;
        }
        a(this.k, 0, 1);
        return this.k[0];
    }

    @Override // com.xiaomi.push.ig
    public short r() {
        byte[] bArr = this.l;
        int i2 = 0;
        if (this.e.c() >= 2) {
            bArr = this.e.a();
            i2 = this.e.b();
            this.e.a(2);
        } else {
            a(this.l, 0, 2);
        }
        return (short) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    @Override // com.xiaomi.push.ig
    public int s() {
        byte[] bArr = this.m;
        int i2 = 0;
        if (this.e.c() >= 4) {
            bArr = this.e.a();
            i2 = this.e.b();
            this.e.a(4);
        } else {
            a(this.m, 0, 4);
        }
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    @Override // com.xiaomi.push.ig
    public long t() {
        byte[] bArr = this.n;
        int i2 = 0;
        if (this.e.c() >= 8) {
            bArr = this.e.a();
            i2 = this.e.b();
            this.e.a(8);
        } else {
            a(this.n, 0, 8);
        }
        return ((long) (bArr[i2 + 7] & 255)) | (((long) (bArr[i2] & 255)) << 56) | (((long) (bArr[i2 + 1] & 255)) << 48) | (((long) (bArr[i2 + 2] & 255)) << 40) | (((long) (bArr[i2 + 3] & 255)) << 32) | (((long) (bArr[i2 + 4] & 255)) << 24) | (((long) (bArr[i2 + 5] & 255)) << 16) | (((long) (bArr[i2 + 6] & 255)) << 8);
    }

    @Override // com.xiaomi.push.ig
    public double u() {
        return Double.longBitsToDouble(t());
    }

    @Override // com.xiaomi.push.ig
    public String v() {
        int s = s();
        if (this.e.c() < s) {
            return b(s);
        }
        try {
            String str = new String(this.e.a(), this.e.b(), s, "UTF-8");
            this.e.a(s);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new ia("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ig
    public ByteBuffer w() {
        int s = s();
        d(s);
        if (this.e.c() >= s) {
            ByteBuffer wrap = ByteBuffer.wrap(this.e.a(), this.e.b(), s);
            this.e.a(s);
            return wrap;
        }
        byte[] bArr = new byte[s];
        this.e.d(bArr, 0, s);
        return ByteBuffer.wrap(bArr);
    }
}
