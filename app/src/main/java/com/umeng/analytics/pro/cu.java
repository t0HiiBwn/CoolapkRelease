package com.umeng.analytics.pro;

/* compiled from: TMemoryInputTransport */
public final class cu extends cv {
    private byte[] a;
    private int b;
    private int c;

    @Override // com.umeng.analytics.pro.cv
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.cv
    public void b() throws cw {
    }

    @Override // com.umeng.analytics.pro.cv
    public void c() {
    }

    public cu() {
    }

    public cu(byte[] bArr) {
        a(bArr);
    }

    public cu(byte[] bArr, int i, int i2) {
        c(bArr, i, i2);
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    public void c(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i + i2;
    }

    public void e() {
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.cv
    public int a(byte[] bArr, int i, int i2) throws cw {
        int h = h();
        if (i2 > h) {
            i2 = h;
        }
        if (i2 > 0) {
            System.arraycopy(this.a, this.b, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.umeng.analytics.pro.cv
    public void b(byte[] bArr, int i, int i2) throws cw {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.cv
    public byte[] f() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.cv
    public int g() {
        return this.b;
    }

    @Override // com.umeng.analytics.pro.cv
    public int h() {
        return this.c - this.b;
    }

    @Override // com.umeng.analytics.pro.cv
    public void a(int i) {
        this.b += i;
    }
}
