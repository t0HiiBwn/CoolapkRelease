package com.tencent.android.tpush.service.channel.security;

/* compiled from: ProGuard */
public class d {
    static final /* synthetic */ boolean a = true;
    private int[] b = new int[4];

    public d(byte[] bArr) {
        if (bArr == null) {
            throw new RuntimeException("Invalid key: Key was null");
        } else if (bArr.length >= 16) {
            int i = 0;
            int i2 = 0;
            while (i < 4) {
                int[] iArr = this.b;
                int i3 = i2 + 1;
                int i4 = i3 + 1;
                int i5 = (bArr[i2] & 255) | ((bArr[i3] & 255) << 8);
                int i6 = i4 + 1;
                int i7 = i5 | ((bArr[i4] & 255) << 16);
                iArr[i] = i7 | ((bArr[i6] & 255) << 24);
                i++;
                i2 = i6 + 1;
            }
        } else {
            throw new RuntimeException("Invalid key: Length was less than 16 bytes");
        }
    }
}
