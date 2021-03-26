package com.xiaomi.push;

public final class jh extends ji {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f885a;
    private int b;

    @Override // com.xiaomi.push.ji
    /* renamed from: a */
    public int mo564a() {
        return this.a;
    }

    @Override // com.xiaomi.push.ji
    /* renamed from: a */
    public int mo561a(byte[] bArr, int i, int i2) {
        int b2 = b();
        if (i2 > b2) {
            i2 = b2;
        }
        if (i2 > 0) {
            System.arraycopy(this.f885a, this.a, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.xiaomi.push.ji
    public void a(int i) {
        this.a += i;
    }

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.ji
    /* renamed from: a  reason: collision with other method in class */
    public void mo563a(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.ji
    /* renamed from: a  reason: collision with other method in class */
    public byte[] mo564a() {
        return this.f885a;
    }

    @Override // com.xiaomi.push.ji
    public int b() {
        return this.b - this.a;
    }

    @Override // com.xiaomi.push.ji
    public void b(byte[] bArr, int i, int i2) {
        this.f885a = bArr;
        this.a = i;
        this.b = i + i2;
    }
}
