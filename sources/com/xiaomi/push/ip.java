package com.xiaomi.push;

public final class ip extends iq {
    private byte[] a;
    private int b;
    private int c;

    @Override // com.xiaomi.push.iq
    public int a(byte[] bArr, int i, int i2) {
        int c2 = c();
        if (i2 > c2) {
            i2 = c2;
        }
        if (i2 > 0) {
            System.arraycopy(this.a, this.b, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.xiaomi.push.iq
    public void a(int i) {
        this.b += i;
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.iq
    public byte[] a() {
        return this.a;
    }

    @Override // com.xiaomi.push.iq
    public int b() {
        return this.b;
    }

    @Override // com.xiaomi.push.iq
    public void b(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.iq
    public int c() {
        return this.c - this.b;
    }

    public void c(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i + i2;
    }
}
