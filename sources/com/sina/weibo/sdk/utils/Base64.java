package com.sina.weibo.sdk.utils;

public final class Base64 {
    private static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    private static byte[] codes = new byte[256];

    static {
        for (int i = 0; i < 256; i++) {
            codes[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            codes[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            codes[i3] = (byte) ((i3 + 26) - 97);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            codes[i4] = (byte) ((i4 + 52) - 48);
        }
        byte[] bArr = codes;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static byte[] decode(byte[] bArr) {
        int length = ((bArr.length + 3) / 4) * 3;
        if (bArr.length > 0 && bArr[bArr.length - 1] == 61) {
            length--;
        }
        if (bArr.length > 1 && bArr[bArr.length - 2] == 61) {
            length--;
        }
        byte[] bArr2 = new byte[length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (byte b : bArr) {
            byte b2 = codes[b & 255];
            if (b2 >= 0) {
                i3 += 6;
                i2 = (i2 << 6) | b2;
                if (i3 >= 8) {
                    i3 -= 8;
                    bArr2[i] = (byte) ((i2 >> i3) & 255);
                    i++;
                }
            }
        }
        if (i == length) {
            return bArr2;
        }
        throw new RuntimeException("miscalculated data length!");
    }

    public static char[] encode(byte[] bArr) {
        boolean z;
        char[] cArr = new char[(((bArr.length + 2) / 3) * 4)];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = (bArr[i] & 255) << 8;
            int i4 = i + 1;
            boolean z2 = true;
            if (i4 < bArr.length) {
                i3 |= bArr[i4] & 255;
                z = true;
            } else {
                z = false;
            }
            int i5 = i3 << 8;
            int i6 = i + 2;
            if (i6 < bArr.length) {
                i5 |= bArr[i6] & 255;
            } else {
                z2 = false;
            }
            int i7 = i2 + 3;
            char[] cArr2 = alphabet;
            int i8 = 64;
            cArr[i7] = cArr2[z2 ? i5 & 63 : 64];
            int i9 = i5 >> 6;
            int i10 = i2 + 2;
            if (z) {
                i8 = i9 & 63;
            }
            cArr[i10] = cArr2[i8];
            int i11 = i9 >> 6;
            cArr[i2 + 1] = cArr2[i11 & 63];
            cArr[i2 + 0] = cArr2[(i11 >> 6) & 63];
            i += 3;
            i2 += 4;
        }
        return cArr;
    }

    public static byte[] encodebyte(byte[] bArr) {
        boolean z;
        byte[] bArr2 = new byte[(((bArr.length + 2) / 3) * 4)];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = (bArr[i] & 255) << 8;
            int i4 = i + 1;
            boolean z2 = true;
            if (i4 < bArr.length) {
                i3 |= bArr[i4] & 255;
                z = true;
            } else {
                z = false;
            }
            int i5 = i3 << 8;
            int i6 = i + 2;
            if (i6 < bArr.length) {
                i5 |= bArr[i6] & 255;
            } else {
                z2 = false;
            }
            int i7 = i2 + 3;
            char[] cArr = alphabet;
            int i8 = 64;
            bArr2[i7] = (byte) cArr[z2 ? i5 & 63 : 64];
            int i9 = i5 >> 6;
            int i10 = i2 + 2;
            if (z) {
                i8 = i9 & 63;
            }
            bArr2[i10] = (byte) cArr[i8];
            int i11 = i9 >> 6;
            bArr2[i2 + 1] = (byte) cArr[i11 & 63];
            bArr2[i2 + 0] = (byte) cArr[(i11 >> 6) & 63];
            i += 3;
            i2 += 4;
        }
        return bArr2;
    }
}
