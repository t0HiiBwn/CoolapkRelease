package com.huawei.secure.android.common.encrypt.aes;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesGcm {
    private static final String TAG = "AesGcm";
    private static final String f = "security:";
    private static final String h = "AES";
    private static final String i = "";
    private static final String l = "AES/GCM/NoPadding";
    private static final int m = 16;
    private static final int n = 12;
    private static final int o = 2;

    private AesGcm() {
    }

    public static String encrypt(String str, String str2) {
        String str3 = TAG;
        b.d(str3, "a g en begin 1");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !a()) {
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray.length >= 16) {
            return encrypt(str, hexStr2ByteArray);
        }
        b.f(str3, "key length is not right");
        return "";
    }

    public static String decrypt(String str, String str2) {
        String str3 = TAG;
        b.d(str3, "a g de begin 1");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !a()) {
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray.length >= 16) {
            return decrypt(str, hexStr2ByteArray);
        }
        b.f(str3, "key length is not right");
        return "";
    }

    public static String encrypt(String str, byte[] bArr) {
        byte[] generateSecureRandom;
        byte[] a;
        b.d(TAG, "a g en begin 2");
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || !a() || (a = a(str, bArr, (generateSecureRandom = EncryptUtil.generateSecureRandom(12)))) == null || a.length == 0) {
            return "";
        }
        String byteArray2HexStr = HexUtil.byteArray2HexStr(generateSecureRandom);
        String byteArray2HexStr2 = HexUtil.byteArray2HexStr(a);
        return byteArray2HexStr + byteArray2HexStr2;
    }

    public static String decrypt(String str, byte[] bArr) {
        String str2 = TAG;
        b.d(str2, "a g de begin 2");
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16 && a()) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
                String a = a(str);
                String b = b(str);
                if (!TextUtils.isEmpty(a)) {
                    if (!TextUtils.isEmpty(b)) {
                        instance.init(2, secretKeySpec, e(HexUtil.hexStr2ByteArray(a)));
                        return new String(instance.doFinal(HexUtil.hexStr2ByteArray(b)), "UTF-8");
                    }
                }
                b.f(str2, "ivParameter or encrypedWord is null");
                return "";
            } catch (UnsupportedEncodingException | GeneralSecurityException e) {
                String str3 = TAG;
                b.f(str3, "GCM decrypt data exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static String encrypt(String str, String str2, String str3) {
        String str4 = TAG;
        b.d(str4, "a g en begin 3");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !a()) {
            b.f(str4, "gcm encrypt parameter is not right");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length >= 16 && str3.length() >= 12) {
            return encrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
        }
        b.f(str4, "key length or iv length is not right");
        return "";
    }

    public static String decrypt(String str, String str2, String str3) {
        String str4 = TAG;
        b.d(str4, "a g de begin 3");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !a()) {
            b.f(str4, "gcm decrypt param is not right");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length >= 16 && hexStr2ByteArray2.length >= 12) {
            return decrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
        }
        b.f(str4, "key length or iv length is not right");
        return "";
    }

    public static String encrypt(String str, byte[] bArr, byte[] bArr2) {
        String str2 = TAG;
        b.d(str2, "a g en begin 4");
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16 && bArr2 != null && bArr2.length >= 12 && a()) {
            return HexUtil.byteArray2HexStr(a(str, bArr, bArr2));
        }
        b.f(str2, "gcm encrypt param is not right");
        return "";
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        b.d(TAG, "a g de begin 4");
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16 && bArr2 != null && bArr2.length >= 12 && a()) {
            try {
                return new String(decrypt(HexUtil.hexStr2ByteArray(str), bArr, bArr2), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                String str2 = TAG;
                b.f(str2, "GCM decrypt data exception: " + e.getMessage());
            }
        }
        return "";
    }

    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || bArr2 == null || bArr2.length < 12 || !a()) {
            b.f(TAG, "gcm encrypt param is not right");
            return new byte[0];
        }
        try {
            return encrypt(str.getBytes("UTF-8"), bArr, bArr2);
        } catch (UnsupportedEncodingException e) {
            String str2 = TAG;
            b.f(str2, "GCM encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        String str = TAG;
        b.d(str, "a g en begin 5");
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length < 16 || bArr3 == null || bArr3.length < 12 || !a()) {
            b.f(str, "gcm encrypt param is not right");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(1, secretKeySpec, e(bArr3));
            return instance.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            String str2 = TAG;
            b.f(str2, "GCM encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        b.d(TAG, "a g de begin 5");
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length < 16 || !a()) {
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            instance.init(2, secretKeySpec, e(bArr3));
            return instance.doFinal(bArr);
        } catch (GeneralSecurityException e) {
            String str = TAG;
            b.f(str, "GCM decrypt data exception: " + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        b.d(TAG, "a g en begin 6");
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(12);
        return a(generateSecureRandom, encrypt(bArr, bArr2, generateSecureRandom));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        b.d(TAG, "a g de begin 6");
        return decrypt(b(bArr), bArr2, a(bArr));
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[12];
        System.arraycopy(bArr, 0, bArr2, 0, 12);
        return bArr2;
    }

    private static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length - 12)];
        System.arraycopy(bArr, 12, bArr2, 0, bArr.length - 12);
        return bArr2;
    }

    private static String a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        b.f(TAG, "IV is invalid.");
        return "";
    }

    private static String b(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static String decryptWithCryptHead(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String c = AesCbc.c(str);
            if ("".equals(c)) {
                return "";
            }
            int indexOf = c.indexOf(58);
            if (indexOf >= 0) {
                return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(c.substring(indexOf + 1))), bArr, HexUtil.hexStr2ByteArray(c.substring(0, indexOf)));
            }
            b.f(TAG, " gcm cipherText data missing colon");
        }
        return "";
    }

    public static String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr2 == null || bArr2.length < 16)) {
            byte[] c = AesCbc.c(bArr);
            if (c.length == 0) {
                return "";
            }
            int d = d(c);
            if (d >= 0) {
                byte[] copyOf = Arrays.copyOf(c, d);
                int length = (c.length - copyOf.length) - 1;
                byte[] bArr3 = new byte[length];
                System.arraycopy(c, d + 1, bArr3, 0, length);
                return decrypt(HexUtil.byteArray2HexStr(bArr3), bArr2, copyOf);
            }
            b.f(TAG, " gcm cipherText data missing colon");
        }
        return "";
    }

    private static int d(byte[] bArr) {
        return bArr[12] == 58 ? 12 : -1;
    }

    private static AlgorithmParameterSpec e(byte[] bArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return new IvParameterSpec(bArr);
        }
        return new GCMParameterSpec(128, bArr);
    }
}
