package com.tencent.beacon.core.protocol.a;

import android.content.Context;
import android.util.Base64;
import com.tencent.beacon.core.d.h;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: EncryUtil */
public final class c {
    private static byte[] a(String str, byte[] bArr) throws Exception {
        if (str == null || bArr == null) {
            return null;
        }
        for (int length = str.length(); length < 16; length++) {
            str = str + "0";
        }
        String substring = str.substring(0, 16);
        SecretKeySpec secretKeySpec = new SecretKeySpec(substring.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(substring.getBytes()));
        return instance.doFinal(bArr);
    }

    private static byte[] b(String str, byte[] bArr) throws Exception, NoSuchAlgorithmException {
        if (str == null || bArr == null) {
            return null;
        }
        for (int length = str.length(); length < 16; length++) {
            str = str + "0";
        }
        String substring = str.substring(0, 16);
        SecretKeySpec secretKeySpec = new SecretKeySpec(substring.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(substring.getBytes()));
        return instance.doFinal(bArr);
    }

    public static byte[] a(Context context, String str) {
        KeyFactory keyFactory;
        if (str == null) {
            return null;
        }
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsAxNCSLyNUCOP1QqYStE8ZeiU\nv4afaMqEmoLCKb0mUZYvYOoVN7LPMi2IVY2MRaFJvuND3glVw1RDm2VJJtjQkwUd\n3kpR9TrHAf7UQOVTpNo3Vi7pXTOqZ6bh3ZA/fs56jDCCKV6+wT/pCeu8N6vVnPrD\nz3SdHIeNeWb/woazCwIDAQAB", 0));
            if (context.getApplicationInfo().targetSdkVersion >= 28) {
                keyFactory = KeyFactory.getInstance("RSA");
            } else {
                keyFactory = KeyFactory.getInstance("RSA", "BC");
            }
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, (RSAPublicKey) keyFactory.generatePublic(x509EncodedKeySpec));
            return instance.doFinal(str.getBytes());
        } catch (Exception e) {
            h.a((Throwable) e);
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(int i, String str, byte[] bArr) throws Exception {
        if (i == 1) {
            if (str == null || bArr == null) {
                return null;
            }
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF-8"))), new IvParameterSpec(str.getBytes("UTF-8")));
            return instance.doFinal(bArr);
        } else if (i == 3) {
            return a(str, bArr);
        } else {
            return null;
        }
    }

    public static byte[] b(int i, String str, byte[] bArr) throws Exception, NoSuchAlgorithmException {
        if (i == 1) {
            if (str == null || bArr == null) {
                return null;
            }
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF-8"))), new IvParameterSpec(str.getBytes("UTF-8")));
            return instance.doFinal(bArr);
        } else if (i == 3) {
            return b(str, bArr);
        } else {
            return null;
        }
    }
}
