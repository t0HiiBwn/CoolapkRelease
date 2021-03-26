package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES */
public class a {
    public static String a(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(1, secretKeySpec);
            return Base64.encodeToString(instance.doFinal(str.getBytes("utf-8")), 0);
        } catch (Throwable th) {
            u.a(th.getMessage());
            return null;
        }
    }

    public static String a(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS7Padding");
            instance.init(1, secretKeySpec);
            return Base64.encodeToString(instance.doFinal(bArr), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, secretKeySpec);
            return new String(instance.doFinal(decode));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a() {
        String d = aj.d();
        if (d == null || d.length() != 16) {
            return null;
        }
        return d;
    }

    public static String a(String str) {
        if (str == null || str.length() != 16) {
            return null;
        }
        return str.concat(str).substring(8, 24);
    }
}
