package com.bytedance.sdk.a.a;

import java.io.UnsupportedEncodingException;

/* compiled from: Base64 */
final class b {
    private static final byte[] a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    public static String a(byte[] bArr) {
        return a(bArr, a);
    }

    private static String a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int i3 = i + 1;
            bArr3[i] = bArr2[(bArr[i2] & 255) >> 2];
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            bArr3[i3] = bArr2[((bArr[i2] & 3) << 4) | ((bArr[i5] & 255) >> 4)];
            int i6 = i4 + 1;
            int i7 = i2 + 2;
            bArr3[i4] = bArr2[((bArr[i5] & 15) << 2) | ((bArr[i7] & 255) >> 6)];
            i = i6 + 1;
            bArr3[i6] = bArr2[bArr[i7] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i8 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
            int i9 = i8 + 1;
            bArr3[i8] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i9] = 61;
            bArr3[i9 + 1] = 61;
        } else if (length2 == 2) {
            int i10 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
            int i11 = i10 + 1;
            int i12 = length + 1;
            bArr3[i10] = bArr2[((bArr[i12] & 255) >> 4) | ((bArr[length] & 3) << 4)];
            bArr3[i11] = bArr2[(bArr[i12] & 15) << 2];
            bArr3[i11 + 1] = 61;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
