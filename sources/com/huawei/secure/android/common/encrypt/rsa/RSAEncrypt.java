package com.huawei.secure.android.common.encrypt.rsa;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

public abstract class RSAEncrypt {
    private static final String CHARSET = "UTF-8";
    private static final int H = 2048;
    private static final String K = "RSA";
    private static final String TAG = "RSAEncrypt";
    private static final String i = "";
    private static final String s = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    public static String encrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return encrypt(str, EncryptUtil.getPublicKey(str2));
        }
        b.f("RSAEncrypt", "content or public key is null");
        return "";
    }

    public static String decrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return decrypt(str, EncryptUtil.getPrivateKey(str2));
        }
        b.f("RSAEncrypt", "content or private key is null");
        return "";
    }

    public static String encrypt(String str, PublicKey publicKey) {
        if (TextUtils.isEmpty(str) || publicKey == null || !isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            b.f("RSAEncrypt", "content or PublicKey is null , or length is too short");
            return "";
        }
        try {
            return Base64.encodeToString(encrypt(str.getBytes("UTF-8"), publicKey), 0);
        } catch (UnsupportedEncodingException unused) {
            b.f("RSAEncrypt", "encrypt: UnsupportedEncodingException");
            return "";
        } catch (Exception e) {
            b.f("RSAEncrypt", "exception : " + e.getMessage());
            return "";
        }
    }

    public static String decrypt(String str, PrivateKey privateKey) {
        if (TextUtils.isEmpty(str) || privateKey == null || !isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            b.f("RSAEncrypt", "content or privateKey is null , or length is too short");
            return "";
        }
        try {
            return new String(decrypt(Base64.decode(str, 0), privateKey), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            b.f("RSAEncrypt", "RSA decrypt exception : " + e.getMessage());
            return "";
        } catch (Exception e2) {
            b.f("RSAEncrypt", "exception : " + e2.getMessage());
            return "";
        }
    }

    public static byte[] encrypt(byte[] bArr, PublicKey publicKey) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || publicKey == null || !isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            b.f("RSAEncrypt", "content or PublicKey is null , or length is too short");
            return bArr2;
        }
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            b.f("RSAEncrypt", "RSA encrypt exception : " + e.getMessage());
            return bArr2;
        }
    }

    public static byte[] decrypt(byte[] bArr, PrivateKey privateKey) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || privateKey == null || !isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            b.f("RSAEncrypt", "content or privateKey is null , or length is too short");
            return bArr2;
        }
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            instance.init(2, privateKey);
            return instance.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            b.f("RSAEncrypt", "RSA decrypt exception : " + e.getMessage());
            return bArr2;
        }
    }

    public static boolean isPublicKeyLengthRight(RSAPublicKey rSAPublicKey) {
        return rSAPublicKey != null && rSAPublicKey.getModulus().bitLength() >= 2048;
    }

    public static boolean isPrivateKeyLengthRight(RSAPrivateKey rSAPrivateKey) {
        return rSAPrivateKey != null && rSAPrivateKey.getModulus().bitLength() >= 2048;
    }

    public static Map<String, Key> generateRSAKeyPair(int i2) throws NoSuchAlgorithmException {
        HashMap hashMap = new HashMap(2);
        if (i2 < 2048) {
            b.f("RSAEncrypt", "generateRSAKeyPair: key length is too short");
            return hashMap;
        }
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
        instance.initialize(i2, secureRandom);
        KeyPair generateKeyPair = instance.generateKeyPair();
        PublicKey publicKey = generateKeyPair.getPublic();
        PrivateKey privateKey = generateKeyPair.getPrivate();
        hashMap.put("publicKey", publicKey);
        hashMap.put("privateKey", privateKey);
        return hashMap;
    }
}
