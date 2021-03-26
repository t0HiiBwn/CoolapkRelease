package com.xiaomi.push;

public final class a {
    public static final a a = new a(new byte[0]);

    /* renamed from: a  reason: collision with other field name */
    private volatile int f181a = 0;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f182a;

    private a(byte[] bArr) {
        this.f182a = bArr;
    }

    public static a a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static a a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new a(bArr2);
    }

    public int a() {
        return this.f182a.length;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m99a() {
        byte[] bArr = this.f182a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        byte[] bArr = this.f182a;
        int length = bArr.length;
        byte[] bArr2 = ((a) obj).f182a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f181a;
        if (i == 0) {
            byte[] bArr = this.f182a;
            int length = bArr.length;
            int i2 = length;
            for (byte b : bArr) {
                i2 = (i2 * 31) + b;
            }
            i = i2 == 0 ? 1 : i2;
            this.f181a = i;
        }
        return i;
    }
}
