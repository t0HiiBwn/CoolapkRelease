package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesCbc {
    private static final String TAG = "AesCbc";
    private static final String f = "security:";
    private static final String g = "AES/CBC/PKCS5Padding";
    private static final String h = "AES";
    private static final String i = "";
    private static final int j = 16;
    private static final int k = 16;

    private AesCbc() {
    }

    public static String encrypt(String str, String str2) {
        String str3 = TAG;
        b.d(str3, "a c en begin");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.f(str3, "cbc encrypt param is not right");
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
        b.d(str3, "a c de begin");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.f(str3, "content or key is null");
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
        String str2 = TAG;
        b.d(str2, "a c en begin 2");
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16) {
            b.f(str2, "cbc encrypt param is not right");
            return "";
        }
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(16);
        byte[] a = a(str, bArr, generateSecureRandom);
        if (a == null || a.length == 0) {
            return "";
        }
        return a(HexUtil.byteArray2HexStr(generateSecureRandom), HexUtil.byteArray2HexStr(a));
    }

    public static String decrypt(String str, byte[] bArr) {
        String str2 = TAG;
        b.d(str2, "a c de begin 2");
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String a = a(str);
            String b = b(str);
            if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(b)) {
                return decrypt(b, bArr, HexUtil.hexStr2ByteArray(a));
            }
            b.f(str2, "ivParameter or encrypedWord is null");
        }
        return "";
    }

    public static String encrypt(String str, String str2, String str3) {
        String str4 = TAG;
        b.d(str4, "a c en begin 3");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            b.f(str4, "cbc encrypt param is not right");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length >= 16 && hexStr2ByteArray2.length >= 16) {
            return encrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
        }
        b.f(str4, "key length or ivParameter length is not right");
        return "";
    }

    public static String decrypt(String str, String str2, String str3) {
        String str4 = TAG;
        b.d(str4, "a c de begin 3");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            b.f(str4, "cbc decrypt param is not right");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length >= 16 && hexStr2ByteArray2.length >= 16) {
            return decrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
        }
        b.f(str4, "key length or ivParameter is not right");
        return "";
    }

    public static String encrypt(String str, byte[] bArr, byte[] bArr2) {
        String str2 = TAG;
        b.d(str2, "a c en begin 4");
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16 && bArr2 != null && bArr2.length >= 16) {
            return HexUtil.byteArray2HexStr(a(str, bArr, bArr2));
        }
        b.f(str2, "cbc encrypt param is not right");
        return "";
    }

    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.f(TAG, "cbc encrypt param is not right");
            return new byte[0];
        }
        try {
            return encrypt(str.getBytes("UTF-8"), bArr, bArr2);
        } catch (UnsupportedEncodingException e) {
            String str2 = TAG;
            b.f(str2, " cbc encrypt data error" + e.getMessage());
            return new byte[0];
        }
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        String str2 = TAG;
        b.d(str2, "a c de begin 4");
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length < 16 || bArr2 == null || bArr2.length < 16) {
            b.f(str2, "cbc decrypt param is not right");
            return "";
        }
        try {
            return new String(decrypt(HexUtil.hexStr2ByteArray(str), bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            b.f(str3, " cbc decrypt data error" + e.getMessage());
            return "";
        }
    }

    private static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
            } catch (Exception e) {
                String str3 = TAG;
                b.f(str3, "mix exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        String str = TAG;
        b.d(str, "a c en begin 5");
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length < 16 || bArr3 == null || bArr3.length < 16) {
            b.f(str, "cbc encrypt param is not right");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return instance.doFinal(bArr);
        } catch (NoSuchAlgorithmException e) {
            String str2 = TAG;
            b.f(str2, "NoSuchAlgorithmException: " + e.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e2) {
            String str3 = TAG;
            b.f(str3, "NoSuchPaddingException: " + e2.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e3) {
            String str4 = TAG;
            b.f(str4, "InvalidKeyException: " + e3.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e4) {
            String str5 = TAG;
            b.f(str5, "InvalidAlgorithmParameterException: " + e4.getMessage());
            return new byte[0];
        } catch (IllegalBlockSizeException e5) {
            String str6 = TAG;
            b.f(str6, "IllegalBlockSizeException: " + e5.getMessage());
            return new byte[0];
        } catch (BadPaddingException e6) {
            String str7 = TAG;
            b.f(str7, "BadPaddingException: " + e6.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        String str = TAG;
        b.d(str, "a c de begin 5");
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length < 16 || bArr3 == null || bArr3.length < 16) {
            b.f(str, "cbc decrypt param is not right");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return instance.doFinal(bArr);
        } catch (NoSuchAlgorithmException e) {
            String str2 = TAG;
            b.f(str2, "NoSuchAlgorithmException: " + e.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e2) {
            String str3 = TAG;
            b.f(str3, "NoSuchPaddingException: " + e2.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e3) {
            String str4 = TAG;
            b.f(str4, "InvalidKeyException: " + e3.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e4) {
            String str5 = TAG;
            b.f(str5, "InvalidAlgorithmParameterException: " + e4.getMessage());
            return new byte[0];
        } catch (IllegalBlockSizeException e5) {
            String str6 = TAG;
            b.f(str6, "IllegalBlockSizeException: " + e5.getMessage());
            return new byte[0];
        } catch (BadPaddingException e6) {
            String str7 = TAG;
            b.f(str7, "BadPaddingException: " + e6.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        b.d(TAG, "a c en begin 6");
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(16);
        return a(generateSecureRandom, encrypt(bArr, bArr2, generateSecureRandom));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        b.d(TAG, "a c de begin 6");
        return decrypt(b(bArr), bArr2, a(bArr));
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        return bArr2;
    }

    private static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length - 16)];
        System.arraycopy(bArr, 16, bArr2, 0, bArr.length - 16);
        return bArr2;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
        } catch (Exception e) {
            String str2 = TAG;
            b.f(str2, "getIv exception : " + e.getMessage());
            return "";
        }
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
        } catch (Exception e) {
            String str2 = TAG;
            b.f(str2, "get encryptword exception : " + e.getMessage());
            return "";
        }
    }

    static String c(String str) {
        if (!TextUtils.isEmpty(str) && str.indexOf("security:") != -1) {
            return str.substring(9);
        }
        return "";
    }

    static byte[] c(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            String str2 = TAG;
            b.f(str2, "stripCryptHead: exception : " + e.getMessage());
            str = "";
        }
        if (!str.startsWith("security:")) {
            return new byte[0];
        }
        if (bArr.length <= 9) {
            return new byte[0];
        }
        int length = bArr.length - 9;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 9, bArr2, 0, length);
        return bArr2;
    }

    public static String decryptWithCryptHead(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String c = c(str);
            if ("".equals(c)) {
                return "";
            }
            int indexOf = c.indexOf(58);
            if (indexOf >= 0) {
                return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(c.substring(indexOf + 1))), bArr, HexUtil.hexStr2ByteArray(c.substring(0, indexOf)));
            }
            b.f(TAG, " cbc cipherText data missing colon");
        }
        return "";
    }

    public static String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr2 == null || bArr2.length < 16)) {
            byte[] c = c(bArr);
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
            b.f(TAG, " cbc cipherText data missing colon");
        }
        return "";
    }

    private static int d(byte[] bArr) {
        return bArr[16] == 58 ? 16 : -1;
    }
}
