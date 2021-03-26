package com.huawei.hms.stats;

import android.text.TextUtils;
import android.util.Pair;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class d implements i {
    private static final Charset a = Charset.forName("UTF-8");

    private Pair<byte[], byte[]> a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 32) {
            return new Pair<>(new byte[0], new byte[0]);
        }
        return new Pair<>(g.a(str.substring(0, 32)), g.a(str.substring(32)));
    }

    private String a(String str, byte[] bArr, byte[] bArr2) {
        return (bArr2 == null || str == null || bArr == null || bArr.length == 0) ? "" : a(bArr, g.a(b(str, bArr, bArr2)));
    }

    private String a(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            return str;
        }
        if (str == null) {
            str = "";
        }
        return g.a(bArr).concat(str);
    }

    private String a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        String str;
        if (bArr.length == 0 || bArr2.length == 0 || bArr3.length == 0) {
            af.c("Aes", "decrypt: parameter exception");
            return "";
        }
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
            return new String(instance.doFinal(bArr3), a);
        } catch (NoSuchAlgorithmException unused) {
            str = "aesDecrypt(): getInstance - No such algorithm,transformation";
            af.c("Aes", str);
            return "";
        } catch (InvalidKeyException unused2) {
            str = "aesDecrypt(): init - Invalid key!";
            af.c("Aes", str);
            return "";
        } catch (InvalidAlgorithmParameterException unused3) {
            str = "aesDecrypt(): init - Invalid algorithm parameters !";
            af.c("Aes", str);
            return "";
        } catch (NoSuchPaddingException unused4) {
            str = "aesDecrypt():  No such filling parameters ";
            af.c("Aes", str);
            return "";
        } catch (BadPaddingException unused5) {
            str = "aesDecrypt(): False filling parameters!";
            af.c("Aes", str);
            return "";
        } catch (IllegalBlockSizeException unused6) {
            str = "aesDecrypt(): doFinal - The provided block is not filled with";
            af.c("Aes", str);
            return "";
        }
    }

    private byte[] b(String str, byte[] bArr, byte[] bArr2) {
        String str2;
        if (TextUtils.isEmpty(str) || bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, new SecretKeySpec(g.a(str), "AES"), new IvParameterSpec(bArr));
            return instance.doFinal(bArr2);
        } catch (NoSuchAlgorithmException unused) {
            str2 = "aesEncrypt(): getInstance - No such algorithm,transformation";
            af.c("Aes", str2);
            return new byte[0];
        } catch (InvalidKeyException unused2) {
            str2 = "aesEncrypt(): init - Invalid key!";
            af.c("Aes", str2);
            return new byte[0];
        } catch (InvalidAlgorithmParameterException unused3) {
            str2 = "aesEncrypt(): init - Invalid algorithm parameters !";
            af.c("Aes", str2);
            return new byte[0];
        } catch (NoSuchPaddingException unused4) {
            str2 = "aesEncrypt(): No such filling parameters ";
            af.c("Aes", str2);
            return new byte[0];
        } catch (BadPaddingException unused5) {
            str2 = "aesEncrypt(): False filling parameters!";
            af.c("Aes", str2);
            return new byte[0];
        } catch (IllegalBlockSizeException unused6) {
            str2 = "aesEncrypt(): doFinal - The provided block is not filled with";
            af.c("Aes", str2);
            return new byte[0];
        }
    }

    @Override // com.huawei.hms.stats.i
    public String a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            af.c("Aes", "decrypt: content or key is empty");
            return "";
        }
        byte[] a2 = g.a(str);
        Pair<byte[], byte[]> a3 = a(str2);
        return a(a2, (byte[]) a3.first, (byte[]) a3.second);
    }

    @Override // com.huawei.hms.stats.i
    public String a(String str, byte[] bArr) {
        return a(str, g.a(), bArr);
    }

    @Override // com.huawei.hms.stats.i
    public String b(String str, String str2) {
        try {
            return a(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            af.b("Aes", "Unsupported Encoding Exception : utf-8");
            return "";
        }
    }
}
