package com.amap.api.col.s;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: RSAUtil */
public final class bz {
    public static byte[] a(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher instance = Cipher.getInstance(bs.c("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(bs.c("EUlNB")).generatePublic(new X509EncodedKeySpec(bv.a(str)));
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused2) {
            throw new Exception("公钥非法");
        } catch (NullPointerException unused3) {
            throw new Exception("公钥数据为空");
        }
    }
}
