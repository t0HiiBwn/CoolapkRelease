package com.huawei.hms.stats;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class f {
    static String a(String str) {
        String str2;
        try {
            return g.a(MessageDigest.getInstance("SHA-256").digest(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            str2 = "sha256Digest(): UnsupportedEncodingException: Exception when writing the log file.";
            af.c("EncryptUtil", str2);
            return "";
        } catch (NoSuchAlgorithmException unused2) {
            str2 = "sha256Digest(): NoSuch Algorithm Exception";
            af.c("EncryptUtil", str2);
            return "";
        }
    }

    static String a(char[] cArr, byte[] bArr) {
        String str;
        try {
            return g.a(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(cArr, bArr, 10000, 128)).getEncoded());
        } catch (InvalidKeySpecException unused) {
            str = "getAuthToken() encryptPBKDF2 Invalid key specification !";
            af.d("EncryptUtil", str);
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            str = "getAuthToken() encryptPBKDF2 No such algorithm!";
            af.d("EncryptUtil", str);
            return null;
        }
    }
}
