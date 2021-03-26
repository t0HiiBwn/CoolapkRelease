package com.xiaomi.push;

public class io extends iq {
    private hy a;
    private int b;

    public io(int i) {
        this.a = new hy(i);
    }

    @Override // com.xiaomi.push.iq
    public int a(byte[] bArr, int i, int i2) {
        byte[] a2 = this.a.a();
        if (i2 > this.a.b() - this.b) {
            i2 = this.a.b() - this.b;
        }
        if (i2 > 0) {
            System.arraycopy(a2, this.b, bArr, i, i2);
            this.b += i2;
        }
        return i2;
    }

    public int a_() {
        return this.a.size();
    }

    @Override // com.xiaomi.push.iq
    public void b(byte[] bArr, int i, int i2) {
        this.a.write(bArr, i, i2);
    }
}
