package com.huawei.hms.stats;

public class ax {
    private byte[] a;
    private int b;
    private int c;

    public ax() {
        this.a = null;
        this.b = 1024;
        this.c = 0;
        this.a = new byte[1024];
    }

    public ax(int i) {
        this.a = null;
        this.b = 1024;
        this.c = 0;
        this.b = i;
        this.a = new byte[i];
    }

    public int a() {
        return this.c;
    }

    public void a(byte[] bArr, int i) {
        if (i > 0) {
            byte[] bArr2 = this.a;
            int length = bArr2.length;
            int i2 = this.c;
            if (length - i2 >= i) {
                System.arraycopy(bArr, 0, bArr2, i2, i);
            } else {
                byte[] bArr3 = new byte[((bArr2.length + i) << 1)];
                System.arraycopy(bArr2, 0, bArr3, 0, i2);
                System.arraycopy(bArr, 0, bArr3, this.c, i);
                this.a = bArr3;
            }
            this.c += i;
        }
    }

    public byte[] b() {
        int i = this.c;
        if (i <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.a, 0, bArr, 0, i);
        return bArr;
    }
}
