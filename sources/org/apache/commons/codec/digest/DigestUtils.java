package org.apache.commons.codec.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

public class DigestUtils {
    static MessageDigest getDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static MessageDigest getMd5Digest() {
        return getDigest("MD5");
    }

    private static MessageDigest getShaDigest() {
        return getDigest("SHA");
    }

    public static byte[] md5(byte[] bArr) {
        return getMd5Digest().digest(bArr);
    }

    public static byte[] md5(String str) {
        return md5(str.getBytes());
    }

    public static String md5Hex(byte[] bArr) {
        return new String(Hex.encodeHex(md5(bArr)));
    }

    public static String md5Hex(String str) {
        return new String(Hex.encodeHex(md5(str)));
    }

    public static byte[] sha(byte[] bArr) {
        return getShaDigest().digest(bArr);
    }

    public static byte[] sha(String str) {
        return sha(str.getBytes());
    }

    public static String shaHex(byte[] bArr) {
        return new String(Hex.encodeHex(sha(bArr)));
    }

    public static String shaHex(String str) {
        return new String(Hex.encodeHex(sha(str)));
    }
}
