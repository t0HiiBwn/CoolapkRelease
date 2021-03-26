package com.xiaomi.push;

public class jg extends ji {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private iq f884a;

    public jg(int i) {
        this.f884a = new iq(i);
    }

    @Override // com.xiaomi.push.ji
    /* renamed from: a */
    public int mo561a(byte[] bArr, int i, int i2) {
        byte[] a2 = this.f884a.m531a();
        if (i2 > this.f884a.a() - this.a) {
            i2 = this.f884a.a() - this.a;
        }
        if (i2 > 0) {
            System.arraycopy(a2, this.a, bArr, i, i2);
            this.a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.ji
    /* renamed from: a  reason: collision with other method in class */
    public void mo562a(byte[] bArr, int i, int i2) {
        this.f884a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f884a.size();
    }
}
