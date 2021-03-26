package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public abstract class HMACSHA256 {
    private static final String TAG = "HMACSHA256";
    private static final String i = "";
    private static final String s = "HmacSHA256";
    private static final int t = 32;

    public static String hmacSHA256Encrypt(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : hmacSHA256Encrypt(str, HexUtil.hexStr2ByteArray(str2));
    }

    public static String hmacSHA256Encrypt(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (bArr.length < 32) {
                b.f(TAG, "hmac key length is not right");
                return "";
            }
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "HmacSHA256");
                Mac instance = Mac.getInstance(secretKeySpec.getAlgorithm());
                instance.init(secretKeySpec);
                return HexUtil.byteArray2HexStr(instance.doFinal(str.getBytes("UTF-8")));
            } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException e) {
                String str2 = TAG;
                b.f(str2, "hmacsha256 encrypt exception" + e.getMessage());
            }
        }
        return "";
    }
}
