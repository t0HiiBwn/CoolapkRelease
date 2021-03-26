package com.amap.api.col.s;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5 */
public final class bq {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return bs.e(c(str));
    }

    public static String b(String str) {
        return bs.f(d(str));
    }

    private static byte[] a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return instance.digest();
        } catch (Throwable th) {
            cd.a(th, "MD5", "gmb");
            return null;
        }
    }

    private static byte[] c(String str) {
        try {
            return e(str);
        } catch (Throwable th) {
            cd.a(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    private static byte[] d(String str) {
        try {
            return e(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] e(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance(bs.c("ETUQ1"));
        instance.update(bs.a(str));
        return instance.digest();
    }

    public static String a(byte[] bArr) {
        return bs.e(a(bArr, bs.c("ETUQ1")));
    }
}
