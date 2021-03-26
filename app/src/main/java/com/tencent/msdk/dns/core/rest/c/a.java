package com.tencent.msdk.dns.core.rest.c;

import android.text.TextUtils;
import com.tencent.msdk.dns.core.rest.share.f;
import java.nio.charset.Charset;

/* compiled from: CipherSuite */
final class a {
    private static final byte[] a = {77, 78, 65, 64, 50, 48, 49, 55, 71, 79, 72, 69, 65, 68, 33, 33};

    static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                byte[] bytes = str.getBytes("utf-8");
                return f.a(com.tencent.msdk.dns.base.jni.a.a(bytes, str2 + "12345578", 0, a));
            } catch (Exception unused) {
            }
        }
        return "";
    }

    static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                byte[] a2 = f.a(str);
                byte[] a3 = com.tencent.msdk.dns.base.jni.a.a(a2, str2 + "12345578", 1, a);
                if (a3 == null) {
                    return "";
                }
                return new String(a3, Charset.forName("UTF-8"));
            } catch (Exception unused) {
            }
        }
        return "";
    }
}
