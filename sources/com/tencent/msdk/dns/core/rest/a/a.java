package com.tencent.msdk.dns.core.rest.a;

import android.text.TextUtils;
import com.tencent.msdk.dns.core.rest.share.f;
import java.nio.charset.Charset;
import java.security.SecureRandom;

/* compiled from: AesHttpCipherSuite */
final class a {
    static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                byte[] bArr = new byte[16];
                new SecureRandom().nextBytes(bArr);
                return f.a(com.tencent.msdk.dns.base.e.a.a(bArr, com.tencent.msdk.dns.base.jni.a.a(str.getBytes("utf-8"), str2, 0, bArr)));
            } catch (Exception unused) {
            }
        }
        return "";
    }

    static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                byte[] a = f.a(str);
                if (a.length < 16) {
                    return "";
                }
                byte[] bArr = new byte[16];
                System.arraycopy(a, 0, bArr, 0, 16);
                int length = a.length - 16;
                byte[] bArr2 = new byte[length];
                System.arraycopy(a, 16, bArr2, 0, length);
                byte[] a2 = com.tencent.msdk.dns.base.jni.a.a(bArr2, str2, 1, bArr);
                if (a2 == null) {
                    return "";
                }
                return new String(a2, Charset.forName("UTF-8"));
            } catch (Exception unused) {
            }
        }
        return "";
    }
}
