package com.huawei.hms.stats;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class h implements i {
    @Override // com.huawei.hms.stats.i
    public String a(String str, String str2) {
        af.b("HmacSHA256Crypt", "No HMAC_SHA256 decryption method");
        return "";
    }

    @Override // com.huawei.hms.stats.i
    public String a(String str, byte[] bArr) {
        String str2;
        if (bArr == null || bArr.length == 0) {
            af.c("HmacSHA256Crypt", "encrypt: content is empty or null");
            return "";
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(Charset.forName("UTF-8")), "HmacSHA256");
        try {
            Mac instance = Mac.getInstance(secretKeySpec.getAlgorithm());
            instance.init(secretKeySpec);
            return g.a(instance.doFinal(bArr));
        } catch (NoSuchAlgorithmException unused) {
            str2 = "When digest2byte executed Exception has happened!From Algorithm error !";
            af.c("HmacSHA256Crypt", str2);
            return "";
        } catch (InvalidKeyException unused2) {
            str2 = "Exception has happened when digest2byte,From Invalid key!";
            af.c("HmacSHA256Crypt", str2);
            return "";
        }
    }

    @Override // com.huawei.hms.stats.i
    public String b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            af.c("HmacSHA256Crypt", "key or content is empty");
            return "";
        }
        try {
            return a(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            af.b("HmacSHA256Crypt", "Unsupported encoding exception,utf-8");
            return "";
        }
    }
}
