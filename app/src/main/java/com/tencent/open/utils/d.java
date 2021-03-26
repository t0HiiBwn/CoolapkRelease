package com.tencent.open.utils;

import android.util.Base64;
import com.tencent.open.a.f;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: ProGuard */
public class d {
    private static byte[] a = {1, 2, 3, 4, 5, 6, 7, 8};

    public static String a(String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "DES");
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(instance.doFinal(str.getBytes()), 0);
        } catch (Exception e) {
            f.c("DESUtils", "encode " + e.toString());
            return null;
        }
    }

    public static String b(String str, String str2) {
        try {
            byte[] decode = Base64.decode(str, 0);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "DES");
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            return new String(instance.doFinal(decode));
        } catch (Exception e) {
            f.c("DESUtils", "decode " + e.toString());
            return null;
        }
    }
}
