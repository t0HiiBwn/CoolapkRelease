package com.kepler.sdk;

import java.security.MessageDigest;

public class ac {
    public String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return "";
        }
    }

    String b(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            str = hexString.length() == 1 ? str + "0" + hexString : str + hexString;
        }
        return str;
    }

    public String c(byte[] bArr) {
        String str;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr);
            str = b(instance.digest());
        } catch (Exception unused) {
            str = "";
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
