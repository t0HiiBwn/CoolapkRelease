package com.amap.api.mapcore2d;

/* compiled from: AESMD5Util */
public class co {
    private static byte[] a = dq.a;
    private static byte[] b = dq.b;
    private static int c = 6;

    public static byte[] a(byte[] bArr) {
        try {
            return cv.b(a, bArr, b);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            return cv.a(a, bArr, b);
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
