package com.tencent.msdk.dns.core.rest.share;

import android.text.TextUtils;
import java.util.Locale;

/* compiled from: RequestBuilder */
public final class h {
    public static String a(String str, String str2, int i) {
        return a(str, str2, i, true);
    }

    public static String b(String str, String str2, int i) {
        return a(str, str2, i, false);
    }

    private static String a(String str, String str2, int i, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("bizId".concat(" can not be empty"));
        } else if (TextUtils.isEmpty(str)) {
            return "";
        } else {
            return String.format(Locale.US, z ? "dn=%s&clientip=1&ttl=1&id=%s&token=%s" : "dn=%s&clientip=1&ttl=1&id=%s&token=%s&type=aaaa", str, str2, Integer.valueOf(i));
        }
    }
}
