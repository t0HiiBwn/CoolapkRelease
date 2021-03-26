package com.huawei.updatesdk.a.a.c;

import android.text.TextUtils;
import com.huawei.updatesdk.a.a.b.a.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Locale;

public abstract class g {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("~", "%7E");
        } catch (UnsupportedEncodingException e) {
            a.a("StringUtils", "encode2utf8 error", e);
            return null;
        }
    }

    public static boolean b(String str) {
        return str != null && str.trim().startsWith("{") && str.trim().endsWith("}");
    }

    public static String c(String str) {
        String e = e(str);
        if (e == null) {
            return null;
        }
        return e.toLowerCase(Locale.getDefault());
    }

    public static byte[] d(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int digit = Character.digit(charArray[i2 + 1], 16) | (Character.digit(charArray[i2], 16) << 4);
            if (digit > 127) {
                digit -= 256;
            }
            bArr[i] = Byte.valueOf(String.valueOf(digit)).byteValue();
        }
        return bArr;
    }

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes("UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : instance.digest()) {
                stringBuffer.append(String.format(Locale.ROOT, "%02X", Byte.valueOf(b)));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            a.d("StringUtils", "sha256EncryptStr error:Exception");
            return null;
        }
    }
}
