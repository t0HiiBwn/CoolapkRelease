package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class AesCbcKS {
    private static final String C = "AndroidKeyStore";
    private static final int D = 16;
    private static final int E = 256;
    private static final String TAG = "AesCbcKS";
    private static final String g = "AES/CBC/PKCS7Padding";
    private static final String i = "";

    public static String encrypt(String str, String str2) {
        String str3 = TAG;
        b.d(str3, "a c ks en begin 1");
        if (TextUtils.isEmpty(str2)) {
            b.f(str3, "encrypt: content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            b.f(TAG, "encrypt: UnsupportedEncodingException");
            return "";
        }
    }

    public static String decrypt(String str, String str2) {
        String str3 = TAG;
        b.d(str3, "a c ks de begin 1");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.f(str3, "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            b.f(TAG, "encrypt: UnsupportedEncodingException");
            return "";
        }
    }

    private static synchronized SecretKey e(String str) {
        SecretKey secretKey;
        synchronized (AesCbcKS.class) {
            secretKey = null;
            try {
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                instance.load(null);
                Key key = instance.getKey(str, null);
                if (key == null || !(key instanceof SecretKey)) {
                    KeyGenerator instance2 = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                    instance2.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setKeySize(256).build());
                    secretKey = instance2.generateKey();
                } else {
                    secretKey = (SecretKey) key;
                }
            } catch (KeyStoreException e) {
                String str2 = TAG;
                b.f(str2, "KeyStoreException: " + e.getMessage());
            } catch (IOException e2) {
                String str3 = TAG;
                b.f(str3, "IOException: " + e2.getMessage());
            } catch (CertificateException e3) {
                String str4 = TAG;
                b.f(str4, "CertificateException: " + e3.getMessage());
            } catch (NoSuchAlgorithmException e4) {
                String str5 = TAG;
                b.f(str5, "NoSuchAlgorithmException: " + e4.getMessage());
            } catch (UnrecoverableKeyException e5) {
                String str6 = TAG;
                b.f(str6, "UnrecoverableKeyException: " + e5.getMessage());
            } catch (InvalidAlgorithmParameterException e6) {
                String str7 = TAG;
                b.f(str7, "InvalidAlgorithmParameterException: " + e6.getMessage());
            } catch (NoSuchProviderException e7) {
                String str8 = TAG;
                b.f(str8, "NoSuchProviderException: " + e7.getMessage());
            } catch (Exception e8) {
                String str9 = TAG;
                b.f(str9, "Exception: " + e8.getMessage());
            }
        }
        return secretKey;
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        String str2 = TAG;
        b.d(str2, "a c ks en begin 2");
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.f(str2, "alias or encrypt content is null");
            return bArr2;
        } else if (!isBuildVersionHigherThan22()) {
            b.f(str2, "sdk version is too low");
            return bArr2;
        } else {
            try {
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                SecretKey e = e(str);
                if (e == null) {
                    b.f(str2, "encrypt secret key is null");
                    return bArr2;
                }
                instance.init(1, e);
                byte[] doFinal = instance.doFinal(bArr);
                byte[] iv = instance.getIV();
                if (iv != null) {
                    if (iv.length == 16) {
                        byte[] copyOf = Arrays.copyOf(iv, iv.length + doFinal.length);
                        System.arraycopy(doFinal, 0, copyOf, iv.length, doFinal.length);
                        return copyOf;
                    }
                }
                b.f(str2, "IV is invalid.");
                return bArr2;
            } catch (NoSuchAlgorithmException e2) {
                String str3 = TAG;
                b.f(str3, "NoSuchAlgorithmException: " + e2.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e3) {
                String str4 = TAG;
                b.f(str4, "NoSuchPaddingException: " + e3.getMessage());
                return bArr2;
            } catch (BadPaddingException e4) {
                String str5 = TAG;
                b.f(str5, "BadPaddingException: " + e4.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e5) {
                String str6 = TAG;
                b.f(str6, "IllegalBlockSizeException: " + e5.getMessage());
                return bArr2;
            } catch (InvalidKeyException e6) {
                String str7 = TAG;
                b.f(str7, "InvalidKeyException: " + e6.getMessage());
                return bArr2;
            } catch (Exception e7) {
                String str8 = TAG;
                b.f(str8, "Exception: " + e7.getMessage());
                return bArr2;
            }
        }
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        String str2 = TAG;
        b.d(str2, "a c ks de begin 2");
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.f(str2, "alias or encrypt content is null");
            return bArr2;
        } else if (!isBuildVersionHigherThan22()) {
            b.f(str2, "sdk version is too low");
            return bArr2;
        } else if (bArr.length <= 16) {
            b.f(str2, "Decrypt source data is invalid.");
            return bArr2;
        } else {
            SecretKey e = e(str);
            if (e == null) {
                b.f(str2, "decrypt secret key is null");
                return bArr2;
            }
            byte[] copyOf = Arrays.copyOf(bArr, 16);
            try {
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                instance.init(2, e, new IvParameterSpec(copyOf));
                return instance.doFinal(bArr, 16, bArr.length - 16);
            } catch (NoSuchAlgorithmException e2) {
                String str3 = TAG;
                b.f(str3, "NoSuchAlgorithmException: " + e2.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e3) {
                String str4 = TAG;
                b.f(str4, "NoSuchPaddingException: " + e3.getMessage());
                return bArr2;
            } catch (InvalidKeyException e4) {
                String str5 = TAG;
                b.f(str5, "InvalidKeyException: " + e4.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e5) {
                String str6 = TAG;
                b.f(str6, "InvalidAlgorithmParameterException: " + e5.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e6) {
                String str7 = TAG;
                b.f(str7, "IllegalBlockSizeException: " + e6.getMessage());
                return bArr2;
            } catch (BadPaddingException e7) {
                String str8 = TAG;
                b.f(str8, "BadPaddingException: " + e7.getMessage());
                return bArr2;
            } catch (Exception e8) {
                String str9 = TAG;
                b.f(str9, "Exception: " + e8.getMessage());
                return bArr2;
            }
        }
    }

    private static boolean isBuildVersionHigherThan22() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
