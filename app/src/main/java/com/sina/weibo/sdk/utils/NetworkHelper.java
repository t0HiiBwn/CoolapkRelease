package com.sina.weibo.sdk.utils;

import android.content.Context;

public class NetworkHelper {
    public static boolean hasInternetPermission(Context context) {
        return context.getPackageManager().checkPermission("android.permission.INTERNET", context.getPackageName()) == 0;
    }

    public static String generateUA(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("Android");
        sb.append("__");
        sb.append("weibo");
        sb.append("__");
        sb.append("sdk");
        sb.append("__");
        try {
            sb.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName.replaceAll("\\s+", "_"));
        } catch (Exception unused) {
            sb.append("unknown");
        }
        return sb.toString();
    }
}
