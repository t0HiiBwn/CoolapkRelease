package com.huawei.hms.stats;

import android.content.Context;
import android.text.TextUtils;

public abstract class l {
    public static String a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(a.c(str, str2))) {
            return a.c(str, str2);
        }
        af.b("hmsSdk", "getAndroidId(): to getConfigByType()");
        return c(context, str, str2);
    }

    public static String b(Context context, String str, String str2) {
        if (str2.equals("oper")) {
            return d(context, str, str2);
        }
        if (str2.equals("maint")) {
            return d(context, str, str2);
        }
        if (str2.equals("diffprivacy")) {
            return d(context, str, str2);
        }
        if (str2.equals("preins")) {
            return d(context, str, str2);
        }
        af.c("hmsSdk", "getChannel(): Invalid type: " + str2);
        return "";
    }

    private static String c(Context context, String str, String str2) {
        if (!a.i(str, str2)) {
            return "";
        }
        if (TextUtils.isEmpty(b.c())) {
            n.a().c().f(bi.c(context));
        }
        return b.c();
    }

    private static String d(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(c.b(str, str2))) {
            return c.b(str, str2);
        }
        q c = n.a().c();
        if (TextUtils.isEmpty(c.e())) {
            String d = bi.d(context);
            if (!az.a("channel", d, 256)) {
                d = "";
            }
            c.b(d);
        }
        return c.e();
    }
}
