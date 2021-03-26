package com.bytedance.embedapplog.util;

import com.bytedance.embedapplog.bo;

public class TTEncryptUtils {
    private static native byte[] ttEncrypt(byte[] bArr, int i);

    static {
        try {
            System.loadLibrary("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e) {
            bo.a(e);
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        try {
            return ttEncrypt(bArr, i);
        } catch (Throwable unused) {
            return null;
        }
    }
}
