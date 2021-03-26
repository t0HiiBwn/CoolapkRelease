package com.huawei.secure.android.common.encrypt.hash;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public abstract class PBKDF2 {
    private static final int A = 1000;
    private static final String TAG = "PBKDF2";
    private static final String i = "";
    private static final String u = "PBKDF2WithHmacSHA1";
    private static final String v = "PBKDF2WithHmacSHA256";
    private static final int w = 8;
    private static final int x = 16;
    private static final int y = 32;
    private static final int z = 10000;

    @Deprecated
    public static String pbkdf2Encrypt(String str) {
        return pbkdf2Encrypt(str, 10000);
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str, int i2) {
        return pbkdf2Encrypt(str, EncryptUtil.generateSecureRandom(8), i2, 32);
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str, byte[] bArr, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            b.f(TAG, "pwd is null.");
            return "";
        } else if (i2 < 1000) {
            b.f(TAG, "iterations times is not enough.");
            return "";
        } else if (bArr == null || bArr.length < 8) {
            b.f(TAG, "salt parameter is null or length is not enough");
            return "";
        } else if (i3 < 32) {
            b.f(TAG, "cipherLen length is not enough");
            return "";
        } else {
            byte[] pbkdf2 = pbkdf2(str.toCharArray(), bArr, i2, i3 * 8);
            return HexUtil.byteArray2HexStr(bArr) + HexUtil.byteArray2HexStr(pbkdf2);
        }
    }

    @Deprecated
    public static boolean validatePassword(String str, String str2) {
        return validatePassword(str, str2, 10000);
    }

    @Deprecated
    public static boolean validatePassword(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 16) {
            return false;
        }
        return b(pbkdf2(str.toCharArray(), HexUtil.hexStr2ByteArray(str2.substring(0, 16)), i2, 256), HexUtil.hexStr2ByteArray(str2.substring(16)));
    }

    public static byte[] pbkdf2(char[] cArr, byte[] bArr, int i2, int i3) {
        return a(cArr, bArr, i2, i3, false);
    }

    public static byte[] pbkdf2SHA256(char[] cArr, byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[0];
        if (Build.VERSION.SDK_INT >= 26) {
            return a(cArr, bArr, i2, i3, true);
        }
        b.f(TAG, "system version not high than 26");
        return bArr2;
    }

    private static byte[] a(char[] cArr, byte[] bArr, int i2, int i3, boolean z2) {
        SecretKeyFactory secretKeyFactory;
        try {
            PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr, bArr, i2, i3);
            if (z2) {
                secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            } else {
                secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            }
            return secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            String str = TAG;
            b.f(str, "pbkdf exception : " + e.getMessage());
            return new byte[0];
        }
    }

    private static boolean b(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        int length = bArr.length ^ bArr2.length;
        int i2 = 0;
        while (i2 < bArr.length && i2 < bArr2.length) {
            length |= bArr[i2] ^ bArr2[i2];
            i2++;
        }
        if (length == 0) {
            return true;
        }
        return false;
    }

    public static String pbkdf2EncryptNew(String str) {
        return pbkdf2EncryptNew(str, 10000);
    }

    public static String pbkdf2EncryptNew(String str, int i2) {
        return pbkdf2EncryptNew(str, EncryptUtil.generateSecureRandom(16), i2, 32);
    }

    public static String pbkdf2EncryptNew(String str, byte[] bArr, int i2, int i3) {
        byte[] bArr2;
        if (TextUtils.isEmpty(str)) {
            b.f(TAG, "pwd is null.");
            return "";
        } else if (i2 < 1000) {
            b.f(TAG, "iterations times is not enough.");
            return "";
        } else if (bArr == null || bArr.length < 16) {
            b.f(TAG, "salt parameter is null or length is not enough");
            return "";
        } else if (i3 < 32) {
            b.f(TAG, "cipherLen length is not enough");
            return "";
        } else {
            if (Build.VERSION.SDK_INT < 26) {
                b.d(TAG, "sha 1");
                bArr2 = pbkdf2(str.toCharArray(), bArr, i2, i3 * 8);
            } else {
                b.d(TAG, "sha 256");
                bArr2 = pbkdf2SHA256(str.toCharArray(), bArr, i2, i3 * 8);
            }
            return HexUtil.byteArray2HexStr(bArr) + HexUtil.byteArray2HexStr(bArr2);
        }
    }

    public static boolean validatePasswordNew(String str, String str2) {
        return validatePasswordNew(str, str2, 10000);
    }

    public static boolean validatePasswordNew(String str, String str2, int i2) {
        byte[] bArr;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 32) {
            return false;
        }
        String substring = str2.substring(0, 32);
        String substring2 = str2.substring(32);
        if (Build.VERSION.SDK_INT < 26) {
            bArr = pbkdf2(str.toCharArray(), HexUtil.hexStr2ByteArray(substring), i2, 256);
        } else {
            bArr = pbkdf2SHA256(str.toCharArray(), HexUtil.hexStr2ByteArray(substring), i2, 256);
        }
        return b(bArr, HexUtil.hexStr2ByteArray(substring2));
    }
}
