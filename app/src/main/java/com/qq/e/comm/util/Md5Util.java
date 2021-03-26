package com.qq.e.comm.util;

import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class Md5Util {
    private static final String[] a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x000f */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: byte */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static String byteArrayToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            if (b < 0) {
                b += 256;
            }
            int i = (b == true ? 1 : 0) / 16;
            StringBuilder sb = new StringBuilder();
            String[] strArr = a;
            sb.append(strArr[i]);
            sb.append(strArr[b % 16]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0034 A[SYNTHETIC, Splitter:B:23:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x003b A[SYNTHETIC, Splitter:B:29:0x003b] */
    public static String encode(File file) {
        Throwable th;
        if (file == null) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                String byteArrayToHexString = byteArrayToHexString(instance.digest());
                try {
                    fileInputStream2.close();
                } catch (Exception unused) {
                }
                return byteArrayToHexString;
            } catch (Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (Exception unused3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused4) {
                }
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    public static String encode(String str) {
        String str2;
        try {
            str2 = new String(str);
            try {
                return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(str2.getBytes("UTF-8")));
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str2 = null;
            return str2;
        }
    }

    public static String encodeBase64String(String str) {
        try {
            return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(Base64.decode(str, 0)));
        } catch (Exception e) {
            GDTLogger.e("Exception while md5 base64String", e);
            return null;
        }
    }

    public static byte[] hexStringtoByteArray(String str) {
        if (str.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() - 1; i += 2) {
            char charAt = str.charAt(i);
            char charAt2 = str.charAt(i + 1);
            char lowerCase = Character.toLowerCase(charAt);
            char lowerCase2 = Character.toLowerCase(charAt2);
            int i2 = ((lowerCase <= '9' ? lowerCase - '0' : (lowerCase - 'a') + 10) << 4) + (lowerCase2 <= '9' ? lowerCase2 - '0' : (lowerCase2 - 'a') + 10);
            if (i2 > 127) {
                i2 -= 256;
            }
            bArr[i / 2] = (byte) i2;
        }
        return bArr;
    }
}
