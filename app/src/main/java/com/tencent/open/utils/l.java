package com.tencent.open.utils;

/* compiled from: ProGuard */
public final class l implements Cloneable {
    private int a;

    public l(byte[] bArr) {
        this(bArr, 0);
    }

    public l(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] << 8) & 65280;
        this.a = i2;
        this.a = i2 + (bArr[i] & 255);
    }

    public l(int i) {
        this.a = i;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof l) || this.a != ((l) obj).b()) {
            return false;
        }
        return true;
    }

    public byte[] a() {
        int i = this.a;
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public int b() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a;
    }
}
