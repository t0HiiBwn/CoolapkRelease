package com.huawei.secure.android.common.encrypt.rsa;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.keystore.rsa.RSASignKS;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

public abstract class RSASign {
    private static final String CHARSET = "UTF-8";
    private static final String L = "SHA256WithRSA/PSS";
    private static final String TAG = "RSASign";
    private static final String i = "";
    private static final String s = "SHA256WithRSA";

    @Deprecated
    public static String sign(String str, String str2) {
        return a(str, str2, false);
    }

    public static String newSign(String str, String str2) {
        if (RSASignKS.isBuildVersionHigherThan22()) {
            return a(str, str2, true);
        }
        b.f(TAG, "sdk version is too low");
        return "";
    }

    private static String a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.f(TAG, "sign content or key is null");
            return "";
        }
        PrivateKey privateKey = EncryptUtil.getPrivateKey(str2);
        if (z) {
            return newSign(str, privateKey);
        }
        return sign(str, privateKey);
    }

    @Deprecated
    public static String sign(String str, PrivateKey privateKey) {
        return a(str, privateKey, false);
    }

    public static String newSign(String str, PrivateKey privateKey) {
        if (RSASignKS.isBuildVersionHigherThan22()) {
            return a(str, privateKey, true);
        }
        b.f(TAG, "sdk version is too low");
        return "";
    }

    private static String a(String str, PrivateKey privateKey, boolean z) {
        try {
            return Base64.encodeToString(sign(str.getBytes("UTF-8"), privateKey, z), 0);
        } catch (UnsupportedEncodingException e) {
            String str2 = TAG;
            b.f(str2, "sign UnsupportedEncodingException: " + e.getMessage());
            return "";
        }
    }

    public static byte[] sign(byte[] bArr, PrivateKey privateKey, boolean z) {
        Signature signature;
        byte[] bArr2 = new byte[0];
        if (bArr == null || privateKey == null || !RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            b.f(TAG, "content or privateKey is null , or length is too short");
            return bArr2;
        }
        if (z) {
            try {
                signature = Signature.getInstance("SHA256WithRSA/PSS");
                signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } catch (NoSuchAlgorithmException e) {
                String str = TAG;
                b.f(str, "sign NoSuchAlgorithmException: " + e.getMessage());
                return bArr2;
            } catch (InvalidKeyException e2) {
                String str2 = TAG;
                b.f(str2, "sign InvalidKeyException: " + e2.getMessage());
                return bArr2;
            } catch (SignatureException e3) {
                String str3 = TAG;
                b.f(str3, "sign SignatureException: " + e3.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e4) {
                String str4 = TAG;
                b.f(str4, "sign InvalidAlgorithmParameterException: " + e4.getMessage());
                return bArr2;
            } catch (Exception e5) {
                String str5 = TAG;
                b.f(str5, "sign Exception: " + e5.getMessage());
                return bArr2;
            }
        } else {
            signature = Signature.getInstance("SHA256WithRSA");
        }
        signature.initSign(privateKey);
        signature.update(bArr);
        return signature.sign();
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, String str3) {
        return a(str, str2, str3, false);
    }

    public static boolean newVerifySign(String str, String str2, String str3) {
        if (RSASignKS.isBuildVersionHigherThan22()) {
            return a(str, str2, str3, true);
        }
        b.f(TAG, "sdk version is too low");
        return false;
    }

    private static boolean a(String str, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            b.f(TAG, "content or public key or sign value is null");
            return false;
        }
        RSAPublicKey publicKey = EncryptUtil.getPublicKey(str3);
        if (z) {
            return newVerifySign(str, str2, publicKey);
        }
        return verifySign(str, str2, publicKey);
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, PublicKey publicKey) {
        return a(str, str2, publicKey, false);
    }

    public static boolean newVerifySign(String str, String str2, PublicKey publicKey) {
        if (RSASignKS.isBuildVersionHigherThan22()) {
            return a(str, str2, publicKey, true);
        }
        b.f(TAG, "sdk version is too low");
        return false;
    }

    private static boolean a(String str, String str2, PublicKey publicKey, boolean z) {
        try {
            return verifySign(str.getBytes("UTF-8"), Base64.decode(str2, 0), publicKey, z);
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            b.f(str3, "verifySign UnsupportedEncodingException: " + e.getMessage());
            return false;
        } catch (Exception e2) {
            String str4 = TAG;
            b.f(str4, "base64 decode Exception : " + e2.getMessage());
            return false;
        }
    }

    public static boolean verifySign(byte[] bArr, byte[] bArr2, PublicKey publicKey, boolean z) {
        Signature signature;
        if (bArr == null || publicKey == null || bArr2 == null || !RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            b.f(TAG, "content or publicKey is null , or length is too short");
            return false;
        }
        if (z) {
            try {
                signature = Signature.getInstance("SHA256WithRSA/PSS");
                signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            } catch (GeneralSecurityException e) {
                String str = TAG;
                b.f(str, "check sign exception: " + e.getMessage());
                return false;
            } catch (Exception e2) {
                String str2 = TAG;
                b.f(str2, "exception : " + e2.getMessage());
                return false;
            }
        } else {
            signature = Signature.getInstance("SHA256WithRSA");
        }
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }
}
