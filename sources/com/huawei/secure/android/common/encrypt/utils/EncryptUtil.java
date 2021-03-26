package com.huawei.secure.android.common.encrypt.utils;

import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class EncryptUtil {
    private static final String P = "RSA";
    private static final int Q = 256;
    private static final String TAG = "EncryptUtil";

    public static byte[] generateSecureRandom(int i) {
        try {
            byte[] bArr = new byte[i];
            new SecureRandom().nextBytes(bArr);
            return bArr;
        } catch (Exception e) {
            b.f("EncryptUtil", "generate secure random error" + e.getMessage());
            return new byte[0];
        }
    }

    public static String generateSecureRandomStr(int i) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i));
    }

    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                b.f("EncryptUtil", "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.f("EncryptUtil", "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e2) {
            b.f("EncryptUtil", "base64 decode Exception" + e2.getMessage());
            return null;
        }
    }

    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                b.f("EncryptUtil", "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.f("EncryptUtil", "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e2) {
            b.f("EncryptUtil", "base64 decode Exception" + e2.getMessage());
            return null;
        }
    }
}
