package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
public final class e {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = a;
            cArr[i2 + 1] = cArr2[b & 15];
            cArr[i2] = cArr2[((byte) (b >>> 4)) & 15];
        }
        return new String(cArr);
    }
}
