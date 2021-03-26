package com.tencent.msdk.dns.core.rest.b;

import android.text.TextUtils;
import com.tencent.msdk.dns.core.rest.share.f;
import java.nio.charset.Charset;

/* compiled from: DesHttpCipherSuite */
final class a {
    static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return f.a(com.tencent.msdk.dns.base.jni.a.a(str.getBytes("utf-8"), str2, 0));
            } catch (Exception unused) {
            }
        }
        return "";
    }

    static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                byte[] a = com.tencent.msdk.dns.base.jni.a.a(f.a(str), str2, 1);
                if (a == null) {
                    return "";
                }
                return new String(a, Charset.forName("UTF-8"));
            } catch (Exception unused) {
            }
        }
        return "";
    }
}
