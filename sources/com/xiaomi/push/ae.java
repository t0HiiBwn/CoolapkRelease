package com.xiaomi.push;

public class ae {
    private static final String a = System.getProperty("line.separator");
    private static char[] b = new char[64];
    private static byte[] c = new byte[128];

    static {
        char c2 = 'A';
        int i = 0;
        while (c2 <= 'Z') {
            b[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            b[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            b[i] = c4;
            c4 = (char) (c4 + 1);
            i++;
        }
        char[] cArr = b;
        cArr[i] = '+';
        cArr[i + 1] = '/';
        int i2 = 0;
        while (true) {
            byte[] bArr = c;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        for (int i3 = 0; i3 < 64; i3++) {
            c[b[i3]] = (byte) i3;
        }
    }

    public static String a(String str) {
        return new String(a(str.getBytes()));
    }

    public static byte[] a(char[] cArr) {
        return a(cArr, 0, cArr.length);
    }

    public static byte[] a(char[] cArr, int i, int i2) {
        int i3;
        char c2;
        char c3;
        int i4;
        if (i2 % 4 == 0) {
            while (i2 > 0 && cArr[(i + i2) - 1] == '=') {
                i2--;
            }
            int i5 = (i2 * 3) / 4;
            byte[] bArr = new byte[i5];
            int i6 = i2 + i;
            int i7 = 0;
            while (i < i6) {
                int i8 = i + 1;
                char c4 = cArr[i];
                int i9 = i8 + 1;
                char c5 = cArr[i8];
                if (i9 < i6) {
                    i3 = i9 + 1;
                    c2 = cArr[i9];
                } else {
                    i3 = i9;
                    c2 = 'A';
                }
                if (i3 < i6) {
                    i4 = i3 + 1;
                    c3 = cArr[i3];
                } else {
                    i4 = i3;
                    c3 = 'A';
                }
                if (c4 > 127 || c5 > 127 || c2 > 127 || c3 > 127) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                byte[] bArr2 = c;
                byte b2 = bArr2[c4];
                byte b3 = bArr2[c5];
                byte b4 = bArr2[c2];
                byte b5 = bArr2[c3];
                if (b2 < 0 || b3 < 0 || b4 < 0 || b5 < 0) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                int i10 = (b2 << 2) | (b3 >>> 4);
                int i11 = ((b3 & 15) << 4) | (b4 >>> 2);
                int i12 = ((b4 & 3) << 6) | b5;
                int i13 = i7 + 1;
                bArr[i7] = (byte) i10;
                if (i13 < i5) {
                    bArr[i13] = (byte) i11;
                    i13++;
                }
                if (i13 < i5) {
                    bArr[i13] = (byte) i12;
                    i7 = i13 + 1;
                } else {
                    i7 = i13;
                }
                i = i4;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }

    public static char[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static char[] a(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = ((i2 * 4) + 2) / 3;
        char[] cArr = new char[(((i2 + 2) / 3) * 4)];
        int i7 = i2 + i;
        int i8 = 0;
        while (i < i7) {
            int i9 = i + 1;
            int i10 = bArr[i] & 255;
            if (i9 < i7) {
                i3 = i9 + 1;
                i4 = bArr[i9] & 255;
            } else {
                i3 = i9;
                i4 = 0;
            }
            if (i3 < i7) {
                i5 = bArr[i3] & 255;
                i3++;
            } else {
                i5 = 0;
            }
            int i11 = i10 >>> 2;
            int i12 = ((i10 & 3) << 4) | (i4 >>> 4);
            int i13 = ((i4 & 15) << 2) | (i5 >>> 6);
            int i14 = i5 & 63;
            int i15 = i8 + 1;
            char[] cArr2 = b;
            cArr[i8] = cArr2[i11];
            int i16 = i15 + 1;
            cArr[i15] = cArr2[i12];
            char c2 = '=';
            cArr[i16] = i16 < i6 ? cArr2[i13] : '=';
            int i17 = i16 + 1;
            if (i17 < i6) {
                c2 = cArr2[i14];
            }
            cArr[i17] = c2;
            i8 = i17 + 1;
            i = i3;
        }
        return cArr;
    }

    public static String b(String str) {
        return new String(c(str));
    }

    public static byte[] c(String str) {
        return a(str.toCharArray());
    }
}
