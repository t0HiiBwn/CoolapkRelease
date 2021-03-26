package com.huawei.hms.stats;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class j implements i {
    private PublicKey a(byte[] bArr) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
    }

    private byte[] a(byte[] bArr, PublicKey publicKey) {
        String str;
        if (publicKey != null) {
            try {
                Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
                instance.init(1, publicKey);
                return instance.doFinal(bArr);
            } catch (UnsupportedEncodingException unused) {
                str = "rsaEncrypt(): getBytes - Unsupported coding format!";
                af.c("Rsa", str);
                return new byte[0];
            } catch (NoSuchAlgorithmException unused2) {
                str = "rsaEncrypt(): getInstance - No such algorithm,transformation";
                af.c("Rsa", str);
                return new byte[0];
            } catch (InvalidKeyException unused3) {
                str = "rsaEncrypt(): init - Invalid key!";
                af.c("Rsa", str);
                return new byte[0];
            } catch (NoSuchPaddingException unused4) {
                str = "rsaEncrypt():  No such filling parameters ";
                af.c("Rsa", str);
                return new byte[0];
            } catch (BadPaddingException unused5) {
                str = "rsaEncrypt():False filling parameters!";
                af.c("Rsa", str);
                return new byte[0];
            } catch (IllegalBlockSizeException unused6) {
                str = "rsaEncrypt(): doFinal - The provided block is not filled with";
                af.c("Rsa", str);
                return new byte[0];
            }
        } else {
            throw new UnsupportedEncodingException("The loaded public key is null");
        }
    }

    @Override // com.huawei.hms.stats.i
    public String a(String str, String str2) {
        af.b("Rsa", "No RSA decryption method");
        return "";
    }

    @Override // com.huawei.hms.stats.i
    public String a(String str, byte[] bArr) {
        String str2;
        if (bArr == null || bArr.length == 0) {
            af.c("Rsa", "encrypt: content is empty or null");
            return "";
        }
        try {
            return g.a(a(bArr, a(g.a(str))));
        } catch (NoSuchAlgorithmException unused) {
            str2 = "encrypt(): getInstance - No such algorithm,transformation";
            af.c("Rsa", str2);
            return "";
        } catch (InvalidKeySpecException unused2) {
            str2 = "encrypt(): Invalid key specification";
            af.c("Rsa", str2);
            return "";
        }
    }

    @Override // com.huawei.hms.stats.i
    public String b(String str, String str2) {
        try {
            return a(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            af.b("Rsa", "Unsupported encoding exception,utf-8");
            return "";
        }
    }
}
