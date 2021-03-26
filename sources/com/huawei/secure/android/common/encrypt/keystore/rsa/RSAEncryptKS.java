package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
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
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public abstract class RSAEncryptKS {
    private static final String C = "AndroidKeyStore";
    private static final String G = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    private static final int H = 2048;
    private static final int I = 3072;
    private static final String TAG = "RSAEncryptKS";
    private static final String i = "";

    @Deprecated
    public static String encrypt(String str, String str2) {
        b.d(TAG, "r ks en begin 1");
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encrypt(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            b.f(str3, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        }
    }

    @Deprecated
    public static String decrpyt(String str, String str2) {
        b.d(TAG, "r ks de begin 1");
        try {
            return new String(decrpyt(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            b.f(str3, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        } catch (Exception e2) {
            String str4 = TAG;
            b.f(str4, "Exception: " + e2.getMessage());
            return "";
        }
    }

    @Deprecated
    public static byte[] encrypt(String str, byte[] bArr) {
        return a(str, bArr, false);
    }

    @Deprecated
    public static byte[] decrpyt(String str, byte[] bArr) {
        String str2 = TAG;
        b.d(str2, "r ks de begin 2");
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.f(str2, "alias or encrypted content is null");
            return bArr2;
        } else if (!isBuildVersionHigherThan22()) {
            b.f(str2, "sdk version is too low");
            return bArr2;
        } else {
            PrivateKey privateKey = getPrivateKey(str);
            if (privateKey == null) {
                b.f(str2, "Private key is null");
                return bArr2;
            }
            try {
                Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
                instance.init(2, privateKey, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
                return instance.doFinal(bArr);
            } catch (NoSuchAlgorithmException e) {
                String str3 = TAG;
                b.f(str3, "NoSuchAlgorithmException: " + e.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e2) {
                String str4 = TAG;
                b.f(str4, "NoSuchPaddingException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                String str5 = TAG;
                b.f(str5, "InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e4) {
                String str6 = TAG;
                b.f(str6, "InvalidAlgorithmParameterException: " + e4.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e5) {
                String str7 = TAG;
                b.f(str7, "IllegalBlockSizeException: " + e5.getMessage());
                return bArr2;
            } catch (BadPaddingException e6) {
                String str8 = TAG;
                b.f(str8, "BadPaddingException: " + e6.getMessage());
                return bArr2;
            } catch (Exception e7) {
                String str9 = TAG;
                b.f(str9, "Exception: " + e7.getMessage());
                return bArr2;
            }
        }
    }

    public static String encryptNew(String str, String str2) {
        b.d(TAG, "r ks en begin 1");
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encryptNew(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            b.f(str3, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        }
    }

    public static String decrpytNew(String str, String str2) {
        b.d(TAG, "r ks de begin 1");
        try {
            return new String(decrpytNew(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            String str3 = TAG;
            b.f(str3, "UnsupportedEncodingException: " + e.getMessage());
            return "";
        } catch (Exception e2) {
            String str4 = TAG;
            b.f(str4, "Exception: " + e2.getMessage());
            return "";
        }
    }

    public static byte[] encryptNew(String str, byte[] bArr) {
        return a(str, bArr, true);
    }

    public static byte[] decrpytNew(String str, byte[] bArr) {
        return decrpyt(str, bArr);
    }

    private static byte[] a(String str, byte[] bArr, boolean z) {
        String str2 = TAG;
        b.d(str2, "r ks en begin 2");
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            b.f(str2, "alias or content is null");
            return bArr2;
        } else if (!isBuildVersionHigherThan22()) {
            b.f(str2, "sdk version is too low");
            return bArr2;
        } else {
            PublicKey b = b(str, z);
            if (b == null) {
                b.f(str2, "Public key is null");
                return bArr2;
            }
            try {
                Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
                instance.init(1, b, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
                return instance.doFinal(bArr);
            } catch (NoSuchAlgorithmException e) {
                String str3 = TAG;
                b.f(str3, "NoSuchAlgorithmException: " + e.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e2) {
                String str4 = TAG;
                b.f(str4, "NoSuchPaddingException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                String str5 = TAG;
                b.f(str5, "InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (InvalidAlgorithmParameterException e4) {
                String str6 = TAG;
                b.f(str6, "InvalidAlgorithmParameterException: " + e4.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e5) {
                String str7 = TAG;
                b.f(str7, "IllegalBlockSizeException: " + e5.getMessage());
                return bArr2;
            } catch (BadPaddingException e6) {
                String str8 = TAG;
                b.f(str8, "BadPaddingException: " + e6.getMessage());
                return bArr2;
            } catch (Exception e7) {
                String str9 = TAG;
                b.f(str9, "Exception: " + e7.getMessage());
                return bArr2;
            }
        }
    }

    private static synchronized KeyPair a(String str, boolean z) {
        synchronized (RSAEncryptKS.class) {
            KeyPair keyPair = null;
            if (g(str)) {
                b.f(TAG, "Key pair exits");
                return null;
            }
            b.d(TAG, "generate key pair.");
            try {
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                if (!z) {
                    instance.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("OAEPPadding").setKeySize(2048).build());
                } else {
                    instance.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("OAEPPadding").setKeySize(3072).build());
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
            } catch (Exception e4) {
                String str5 = TAG;
                b.f(str5, "Exception: " + e4.getMessage());
            }
            return keyPair;
        }
    }

    private static PublicKey b(String str, boolean z) {
        if (!g(str)) {
            a(str, z);
        }
        Certificate f = f(str);
        if (f != null) {
            return f.getPublicKey();
        }
        return null;
    }

    private static Certificate f(String str) {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            return instance.getCertificate(str);
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
        } catch (Exception e5) {
            String str6 = TAG;
            b.f(str6, "Exception: " + e5.getMessage());
            return null;
        }
    }

    private static PrivateKey getPrivateKey(String str) {
        if (!g(str)) {
            return null;
        }
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            return (PrivateKey) instance.getKey(str, null);
        } catch (KeyStoreException e) {
            String str2 = TAG;
            b.f(str2, "KeyStoreException: " + e.getMessage());
            return null;
        } catch (CertificateException e2) {
            String str3 = TAG;
            b.f(str3, "CertificateException: " + e2.getMessage());
            return null;
        } catch (UnrecoverableKeyException e3) {
            String str4 = TAG;
            b.f(str4, "UnrecoverableKeyException: " + e3.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e4) {
            String str5 = TAG;
            b.f(str5, "NoSuchAlgorithmException: " + e4.getMessage());
            return null;
        } catch (IOException e5) {
            String str6 = TAG;
            b.f(str6, "IOException: " + e5.getMessage());
            return null;
        } catch (Exception e6) {
            String str7 = TAG;
            b.f(str7, "Exception: " + e6.getMessage());
            return null;
        }
    }

    private static boolean isBuildVersionHigherThan22() {
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
        } catch (Exception e6) {
            String str7 = TAG;
            b.f(str7, "Exception: " + e6.getMessage());
            return false;
        }
    }
}
