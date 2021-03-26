package com.alibaba.baichuan.trade.common.utils;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class AlibcCodeUtils {
    private static String a = "\\u";

    private static String a(char c) {
        if (c <= 255) {
            return Character.toString(c);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        String hexString = Integer.toHexString(c >> '\b');
        if (hexString.length() == 1) {
            sb.append("0");
        }
        sb.append(hexString);
        String hexString2 = Integer.toHexString(c & 255);
        if (hexString2.length() == 1) {
            sb.append("0");
        }
        sb.append(hexString2);
        return sb.toString();
    }

    private static PublicKey a(byte[] bArr) {
        try {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
            } catch (InvalidKeySpecException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String getBase64(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public static String getBase64(String str, int i) {
        return Base64.encodeToString(str.getBytes(), i);
    }

    public static String getFromBase64(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public static String md5Digest(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String native2Ascii(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(a(str.charAt(i)));
        }
        return sb.toString();
    }

    public static byte[] rsaDecrypt(byte[] bArr, byte[] bArr2) {
        try {
            PublicKey a2 = a(bArr2);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, a2);
            int blockSize = instance.getBlockSize();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i = 0; i < bArr.length; i += blockSize) {
                byteArrayOutputStream.write(instance.doFinal(bArr, i, bArr.length - i < blockSize ? bArr.length - i : blockSize));
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] rsaEncrypt(byte[] bArr, byte[] bArr2) {
        try {
            PublicKey a2 = a(bArr2);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, a2);
            int blockSize = instance.getBlockSize();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i = 0; i < bArr.length; i += blockSize) {
                byteArrayOutputStream.write(instance.doFinal(bArr, i, bArr.length - i < blockSize ? bArr.length - i : blockSize));
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
