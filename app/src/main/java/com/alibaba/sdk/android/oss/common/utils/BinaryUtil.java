package com.alibaba.sdk.android.oss.common.utils;

import android.util.Base64;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BinaryUtil {
    public static String toBase64String(byte[] bArr) {
        return new String(Base64.encode(bArr, 0)).trim();
    }

    public static byte[] fromBase64String(String str) {
        return Base64.decode(str, 0);
    }

    public static byte[] calculateMd5(FileDescriptor fileDescriptor) throws IOException {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[10240];
            FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return instance.digest();
                }
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new RuntimeException("MD5 algorithm not found.");
        }
    }

    public static byte[] calculateMd5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException unused) {
            throw new RuntimeException("MD5 algorithm not found.");
        }
    }

    public static byte[] calculateMd5(String str) throws IOException {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[10240];
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return instance.digest();
                }
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new RuntimeException("MD5 algorithm not found.");
        }
    }

    public static String calculateMd5Str(byte[] bArr) {
        return getMd5StrFromBytes(calculateMd5(bArr));
    }

    public static String calculateMd5Str(String str) throws IOException {
        return getMd5StrFromBytes(calculateMd5(str));
    }

    public static String calculateMd5Str(FileDescriptor fileDescriptor) throws IOException {
        return getMd5StrFromBytes(calculateMd5(fileDescriptor));
    }

    public static String calculateBase64Md5(byte[] bArr) {
        return toBase64String(calculateMd5(bArr));
    }

    public static String calculateBase64Md5(String str) throws IOException {
        return toBase64String(calculateMd5(str));
    }

    public static String calculateBase64Md5(FileDescriptor fileDescriptor) throws IOException {
        return toBase64String(calculateMd5(fileDescriptor));
    }

    public static String getMd5StrFromBytes(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(String.format("%02x", Byte.valueOf(bArr[i])));
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0033 A[SYNTHETIC, Splitter:B:21:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003a A[SYNTHETIC, Splitter:B:28:0x003a] */
    public static String fileToSHA1(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[1024];
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                int i = 0;
                while (i != -1) {
                    i = fileInputStream.read(bArr);
                    if (i > 0) {
                        instance.update(bArr, 0, i);
                    }
                }
                String convertHashToString = convertHashToString(instance.digest());
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                return convertHashToString;
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

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0033 A[SYNTHETIC, Splitter:B:21:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003a A[SYNTHETIC, Splitter:B:28:0x003a] */
    public static String fileToSHA1(FileDescriptor fileDescriptor) {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(fileDescriptor);
            try {
                byte[] bArr = new byte[1024];
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                int i = 0;
                while (i != -1) {
                    i = fileInputStream.read(bArr);
                    if (i > 0) {
                        instance.update(bArr, 0, i);
                    }
                }
                String convertHashToString = convertHashToString(instance.digest());
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                return convertHashToString;
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

    private static String convertHashToString(byte[] bArr) {
        String str = "";
        for (int i = 0; i < bArr.length; i++) {
            str = str + Integer.toString((bArr[i] & 255) + 256, 16).substring(1);
        }
        return str.toLowerCase();
    }
}
