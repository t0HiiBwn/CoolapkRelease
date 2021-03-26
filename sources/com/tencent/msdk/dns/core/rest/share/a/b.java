package com.tencent.msdk.dns.core.rest.share.a;

import android.text.TextUtils;
import com.tencent.msdk.dns.core.rest.share.e;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ResponseParser */
public final class b {
    private static final Pattern a = Pattern.compile("(.*)\\|(.*),(.*)");
    private static final Pattern b = Pattern.compile("(.*),(.*)\\|(.*)");

    public static a a(String str, int i, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bizId".concat(" can not be empty"));
        } else if (e.a(str)) {
            return a(i, str2);
        } else {
            return b(i, str2);
        }
    }

    private static a a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return a.a;
        }
        Matcher matcher = a.matcher(str);
        if (!matcher.matches() || 3 != matcher.groupCount()) {
            return a.a;
        }
        try {
            return new a(i, matcher.group(2), matcher.group(1).split(";"), Integer.parseInt(matcher.group(3)));
        } catch (Exception e) {
            com.tencent.msdk.dns.base.log.b.c(e, "Parse internal response failed", new Object[0]);
            return a.a;
        }
    }

    private static a b(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return a.a;
        }
        Matcher matcher = b.matcher(str);
        if (!matcher.matches() || 3 != matcher.groupCount()) {
            return a.a;
        }
        try {
            return new a(i, matcher.group(3), matcher.group(1).split(";"), Integer.parseInt(matcher.group(2)));
        } catch (Exception e) {
            com.tencent.msdk.dns.base.log.b.c(e, "Parse external response failed", new Object[0]);
            return a.a;
        }
    }
}
