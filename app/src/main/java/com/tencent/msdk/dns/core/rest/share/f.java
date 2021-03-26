package com.tencent.msdk.dns.core.rest.share;

import android.text.TextUtils;

/* compiled from: DataConverter */
public final class f {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
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

    public static byte[] a(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        while (true) {
            int i2 = i + 1;
            if (i2 >= length) {
                return bArr;
            }
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i2), 16));
            i += 2;
        }
    }
}
