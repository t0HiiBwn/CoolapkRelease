package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public abstract class RSASignKS {
    private static final String C = "AndroidKeyStore";
    private static final int H = 2048;
    private static final int I = 3072;
    private static final String J = "SHA256withRSA/PSS";
    private static final String TAG = "RSASignKS";
    private static final String i = "";

    @Deprecated
    public static String sign(String str, String str2) {
        b.d(TAG, "r ks si begin ");
        try {
            return Base64.encodeToString(sign(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            Log.e(str3, "sign UnsupportedEncodingException : " + e.getMessage());
            return "";
        }
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, String str3) {
        b.d(TAG, "r ks v si begin ");
        try {
            return verifySign(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e) {
            String str4 = TAG;
            Log.e(str4, "verifySign UnsupportedEncodingException: " + e.getMessage());
            return false;
        } catch (Exception e2) {
            String str5 = TAG;
            b.f(str5, "base64 decode Exception" + e2.getMessage());
            return false;
        }
    }

    public static String signNew(String str, String str2) {
        b.d(TAG, "r ks si begin ");
        try {
            return Base64.encodeToString(signNew(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            Log.e(str3, "sign UnsupportedEncodingException : " + e.getMessage());
            return "";
        }
    }

    public static boolean verifySignNew(String str, String str2, String str3) {
        b.d(TAG, "r ks v si begin ");
        try {
            return verifySignNew(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e) {
            String str4 = TAG;
            Log.e(str4, "verifySign UnsupportedEncodingException: " + e.getMessage());
            return false;
        } catch (Exception e2) {
            String str5 = TAG;
            b.f(str5, "base64 decode Exception" + e2.getMessage());
            return false;
        }
    }

    @Deprecated
    public static byte[] sign(String str, byte[] bArr) {
        return b(str, bArr, false);
    }

    @Deprecated
    public static boolean verifySign(String str, byte[] bArr, byte[] bArr2) {
        return a(str, bArr, bArr2, false);
    }

    public static byte[] signNew(String str, byte[] bArr) {
        return b(str, bArr, true);
    }

    public static boolean verifySignNew(String str, byte[] bArr, byte[] bArr2) {
        return a(str, bArr, bArr2, true);
    }

    private static byte[] b(String str, byte[] bArr, boolean z) {
        String str2 = TAG;
        b.d(str2, "r ks si begin ");
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.f(str2, "alias or content is null");
            return bArr2;
        } else if (!isBuildVersionHigherThan22()) {
            b.f(str2, "sdk version is too low");
            return bArr2;
        } else {
            KeyStore.Entry c = c(str, z);
            if (!(c instanceof KeyStore.PrivateKeyEntry)) {
                b.f(str2, "Not an instance of a PrivateKeyEntry");
                return bArr2;
            }
            try {
                Signature instance = Signature.getInstance("SHA256withRSA/PSS");
                instance.initSign(((KeyStore.PrivateKeyEntry) c).getPrivateKey());
                instance.update(bArr);
                return instance.sign();
            } catch (NoSuchAlgorithmException e) {
                String str3 = TAG;
                b.f(str3, "NoSuchAlgorithmException: " + e.getMessage());
                return bArr2;
            } catch (SignatureException e2) {
                String str4 = TAG;
                b.f(str4, "SignatureException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                String str5 = TAG;
                b.f(str5, "InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (Exception e4) {
                String str6 = TAG;
                b.f(str6, "Exception: " + e4.getMessage());
                return bArr2;
            }
        }
    }

    private static boolean a(String str, byte[] bArr, byte[] bArr2, boolean z) {
        String str2 = TAG;
        b.d(str2, "r ks v si begin ");
        if (TextUtils.isEmpty(str) || bArr == null || bArr2 == null) {
            b.f(str2, "alias or content or sign value is null");
            return false;
        } else if (!isBuildVersionHigherThan22()) {
            b.f(str2, "sdk version is too low");
            return false;
        } else {
            KeyStore.Entry c = c(str, z);
            if (!(c instanceof KeyStore.PrivateKeyEntry)) {
                b.f(str2, "Not an instance of a PrivateKeyEntry");
                return false;
            }
            try {
                Signature instance = Signature.getInstance("SHA256withRSA/PSS");
                instance.initVerify(((KeyStore.PrivateKeyEntry) c).getCertificate());
                instance.update(bArr);
                return instance.verify(bArr2);
            } catch (NoSuchAlgorithmException e) {
                String str3 = TAG;
                b.f(str3, "NoSuchAlgorithmException: " + e.getMessage());
                return false;
            } catch (SignatureException e2) {
                String str4 = TAG;
                b.f(str4, "SignatureException: " + e2.getMessage());
                return false;
            } catch (InvalidKeyException e3) {
                String str5 = TAG;
                b.f(str5, "InvalidKeyException: " + e3.getMessage());
                return false;
            } catch (Exception e4) {
                String str6 = TAG;
                b.f(str6, "Exception: " + e4.getMessage());
                return false;
            }
        }
    }

    private static synchronized KeyPair a(String str, boolean z) {
        synchronized (RSASignKS.class) {
            KeyPair keyPair = null;
            if (g(str)) {
                b.f(TAG, "Key pair exits");
                return null;
            }
            try {
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                if (!z) {
                    instance.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests("SHA-256", "SHA-512").setSignaturePaddings("PSS").setKeySize(2048).build());
                } else {
                    instance.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests("SHA-256", "SHA-512").setSignaturePaddings("PSS").setKeySize(3072).build());
                }
                keyPair = instance.generateKeyPair();
            } catch (NoSuchAlgorithmException e) {
                String str2 = TAG;
                b.f(str2, "NoSuchAlgorithmException: " + e.getMessage());
            } catch (NoSuchProviderException e2) {
                String str3 = TAG;
                b.f(str3, "NoSuchProviderException: " + e2.getMessage());
            } catch (InvalidAlgorithmParameterException e3) {
                String str4 = TAG;
                b.f(str4, "InvalidAlgorithmParameterException: " + e3.getMessage());
            }
            return keyPair;
        }
    }

    private static KeyStore.Entry c(String str, boolean z) {
        if (!g(str)) {
            a(str, z);
        }
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            return instance.getEntry(str, null);
        } catch (KeyStoreException e) {
            String str2 = TAG;
            b.f(str2, "KeyStoreException: " + e.getMessage());
            return null;
        } catch (CertificateException e2) {
            String str3 = TAG;
            b.f(str3, "CertificateException: " + e2.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e3) {
            String str4 = TAG;
            b.f(str4, "NoSuchAlgorithmException: " + e3.getMessage());
            return null;
        } catch (IOException e4) {
            String str5 = TAG;
            b.f(str5, "IOException: " + e4.getMessage());
            return null;
        } catch (UnrecoverableEntryException e5) {
            String str6 = TAG;
            b.f(str6, "UnrecoverableEntryException: " + e5.getMessage());
            return null;
        }
    }

    public static boolean isBuildVersionHigherThan22() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static boolean g(String str) {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            if (instance.getKey(str, null) != null) {
                return true;
            }
            return false;
        } catch (KeyStoreException e) {
            String str2 = TAG;
            b.f(str2, "KeyStoreException: " + e.getMessage());
            return false;
        } catch (CertificateException e2) {
            String str3 = TAG;
            b.f(str3, "CertificateException: " + e2.getMessage());
            return false;
        } catch (UnrecoverableKeyException e3) {
            String str4 = TAG;
            b.f(str4, "UnrecoverableKeyException: " + e3.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e4) {
            String str5 = TAG;
            b.f(str5, "NoSuchAlgorithmException: " + e4.getMessage());
            return false;
        } catch (IOException e5) {
            String str6 = TAG;
            b.f(str6, "IOException: " + e5.getMessage());
            return false;
        }
    }
}
