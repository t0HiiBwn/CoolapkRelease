package com.bytedance.sdk.openadsdk.utils;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Objects;

/* compiled from: DigestUtils */
public class j {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        Objects.requireNonNull(bArr, "bytes is null");
        return a(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "bytes is null");
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + i] & 255;
            int i7 = i4 + 1;
            char[] cArr2 = a;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new String(cArr, 0, i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0032 A[SYNTHETIC, Splitter:B:22:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0039 A[SYNTHETIC, Splitter:B:29:0x0039] */
    public static String a(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            if (instance == null) {
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 8192);
                    if (read <= 0) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                String a2 = a(instance.digest());
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                return a2;
            } catch (Exception unused2) {
                if (fileInputStream != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
        } catch (Exception unused3) {
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused4) {
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    public static String a(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    instance.update(str.getBytes("UTF-8"));
                    return a(instance.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
