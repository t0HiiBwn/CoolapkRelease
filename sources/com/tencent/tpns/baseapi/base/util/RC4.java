package com.tencent.tpns.baseapi.base.util;

import android.os.Build;
import android.util.Base64;

/* compiled from: ProGuard */
public class RC4 {
    static byte[] a() {
        return Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0);
    }

    public static byte[] encrypt(byte[] bArr) {
        return a(bArr, a());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: byte */
    /* JADX WARN: Multi-variable type inference failed */
    static byte[] a(byte[] bArr, byte[] bArr2) {
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        int length = bArr2.length;
        if (length < 1 || length > 256) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        for (int i = 0; i < 256; i++) {
            iArr[i] = i;
            iArr2[i] = bArr2[i % length];
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            i2 = (i2 + iArr[i3] + iArr2[i3]) & 255;
            int i4 = iArr[i3];
            iArr[i3] = iArr[i2];
            iArr[i2] = i4;
        }
        byte[] bArr3 = new byte[bArr.length];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < bArr.length; i7++) {
            i5 = (i5 + 1) & 255;
            i6 = (i6 + iArr[i5]) & 255;
            int i8 = iArr[i5];
            iArr[i5] = iArr[i6];
            iArr[i6] = i8;
            bArr3[i7] = (byte) (iArr[(iArr[i5] + iArr[i6]) & 255] ^ bArr[i7]);
        }
        return bArr3;
    }

    public static byte[] decrypt(byte[] bArr) {
        return decrypt(bArr, a());
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2);
    }

    public static String decode(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(decrypt(Base64.decode(str.getBytes("UTF-8"), 0)), "UTF-8");
        } catch (Throwable th) {
            Logger.e("RC4", "decode error", th);
            return str;
        }
    }

    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(Base64.encode(encrypt(str.getBytes("UTF-8")), 0), "UTF-8");
        } catch (Throwable th) {
            Logger.e("RC4", "encode error", th);
            return str;
        }
    }
}
