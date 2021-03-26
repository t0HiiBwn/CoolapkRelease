package com.alibaba.alibclinkpartner.smartlink.util;

import android.content.Context;
import android.text.TextUtils;

public class ALSLSystemUtil {
    private static String a;
    private static String b;

    public static String getAppName(Context context) {
        if (TextUtils.isEmpty(b)) {
            try {
                b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
            } catch (Exception e) {
                ALSLLogUtil.d("ALSLSystemUtil", "getAppName", e.toString());
            }
        }
        return b;
    }

    public static String getPackageName(Context context) {
        if (TextUtils.isEmpty(a)) {
            a = context.getPackageName();
        }
        return a;
    }
}
