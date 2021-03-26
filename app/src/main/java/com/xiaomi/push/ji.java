package com.xiaomi.push;

public abstract class ji {
    /* renamed from: a */
    public int mo564a() {
        return 0;
    }

    /* renamed from: a */
    public abstract int mo561a(byte[] bArr, int i, int i2);

    public void a(int i) {
    }

    public abstract void a(byte[] bArr, int i, int i2);

    public byte[] a() {
        return null;
    }

    public int b() {
        return -1;
    }

    public int b(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int a = mo561a(bArr, i + i3, i2 - i3);
            if (a > 0) {
                i3 += a;
            } else {
                throw new jj("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes.");
            }
        }
        return i3;
    }
}
