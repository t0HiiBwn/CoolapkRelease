package com.ali.auth.third.core.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class Rsa {
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    private static PublicKey a(String str, String str2) throws NoSuchAlgorithmException, Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(Base64.decode(str2)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057 A[SYNTHETIC, Splitter:B:25:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0064 A[SYNTHETIC, Splitter:B:32:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    public static String encrypt(String str, String str2) {
        Throwable th;
        Exception e;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            PublicKey a = a("RSA", str2);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, a);
            byte[] bytes = str.getBytes("UTF-8");
            int blockSize = instance.getBlockSize();
            byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i = 0; i < bytes.length; i += blockSize) {
                try {
                    byteArrayOutputStream.write(instance.doFinal(bytes, i, bytes.length - i < blockSize ? bytes.length - i : blockSize));
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            return null;
                        }
                        try {
                            byteArrayOutputStream.close();
                            return null;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }
            String str3 = new String(Base64.encode(byteArrayOutputStream.toByteArray()));
            try {
                byteArrayOutputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return str3;
        } catch (Exception e6) {
            e = e6;
            byteArrayOutputStream = null;
            e.printStackTrace();
            if (byteArrayOutputStream != null) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (byteArrayOutputStream2 != null) {
            }
            throw th;
        }
    }
}
