package com.ali.auth.third.core.storage.aes;

import android.util.Base64;
import android.util.Log;
import com.ali.auth.third.core.util.CommonUtils;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AESCrypt {
    public static boolean DEBUG_LOG_ENABLED = false;
    private static final byte[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    private AESCrypt() {
    }

    private static SecretKeySpec a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes("UTF-8");
        instance.update(bytes, 0, bytes.length);
        byte[] digest = instance.digest();
        a("SHA-256 key ", digest);
        return new SecretKeySpec(digest, "AES");
    }

    private static void a(String str, String str2) {
        if (DEBUG_LOG_ENABLED) {
            Log.d("AESCrypt", str + "[" + str2.length() + "] [" + str2 + "]");
        }
    }

    private static void a(String str, byte[] bArr) {
        if (DEBUG_LOG_ENABLED) {
            Log.d("AESCrypt", str + "[" + bArr.length + "] [" + CommonUtils.getHashString(bArr) + "]");
        }
    }

    public static String decrypt(String str, String str2) throws GeneralSecurityException {
        try {
            SecretKeySpec a2 = a(str);
            a("base64EncodedCipherText", str2);
            byte[] decode = Base64.decode(str2, 2);
            a("decodedCipherText", decode);
            byte[] decrypt = decrypt(a2, a, decode);
            a("decryptedBytes", decrypt);
            String str3 = new String(decrypt, "UTF-8");
            a("message", str3);
            return str3;
        } catch (UnsupportedEncodingException e) {
            if (DEBUG_LOG_ENABLED) {
                Log.e("AESCrypt", "UnsupportedEncodingException ", e);
            }
            throw new GeneralSecurityException(e);
        }
    }

    public static byte[] decrypt(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(bArr));
        byte[] doFinal = instance.doFinal(bArr2);
        a("decryptedBytes", doFinal);
        return doFinal;
    }

    public static String encrypt(String str, String str2) throws GeneralSecurityException {
        try {
            SecretKeySpec a2 = a(str);
            a("message", str2);
            String encodeToString = Base64.encodeToString(encrypt(a2, a, str2.getBytes("UTF-8")), 2);
            a("Base64.NO_WRAP", encodeToString);
            return encodeToString;
        } catch (UnsupportedEncodingException e) {
            if (DEBUG_LOG_ENABLED) {
                Log.e("AESCrypt", "UnsupportedEncodingException ", e);
            }
            throw new GeneralSecurityException(e);
        }
    }

    public static byte[] encrypt(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(bArr));
        byte[] doFinal = instance.doFinal(bArr2);
        a("cipherText", doFinal);
        return doFinal;
    }
}
