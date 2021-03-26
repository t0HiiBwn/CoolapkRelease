package com.tencent.android.tpush.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import com.tencent.android.tpush.logging.TLogger;

/* compiled from: ProGuard */
public class b {
    private static String a = "";

    public static String a(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str == null) {
                return "";
            }
            return str;
        } catch (Throwable th) {
            TLogger.e("AppInfos", "get app version error", th);
            return "";
        }
    }

    public static String b(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static String c(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
        } catch (Throwable th) {
            TLogger.e("AppInfos", "", th);
            return null;
        }
    }

    public static ApplicationInfo d(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        } catch (Throwable th) {
            TLogger.ee("AppInfos", "Failed to get Application info", th);
            return null;
        }
    }

    public static int a() {
        return Build.VERSION.SDK_INT;
    }

    public static String e(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null || resolveActivity.activityInfo == null || resolveActivity.activityInfo.packageName.equals("android")) {
            return null;
        }
        return resolveActivity.activityInfo.packageName;
    }

    public static boolean f(Context context) {
        try {
            ApplicationInfo d = d(context);
            if (d == null) {
                TLogger.ee("AppInfos", "Failed to init due to null ApplicationInfo.");
                return false;
            } else if (d.icon != 0) {
                return true;
            } else {
                TLogger.ee("AppInfos", "Failed to get Application icon in AndroidManifest.xml, You App maybe can not show notification, Please add Application icon in AndroidManifest.xml");
                return false;
            }
        } catch (Throwable th) {
            TLogger.w("AppInfos", "unexpected for checkApplicationIcon:" + th.getMessage());
            return false;
        }
    }

    public static boolean g(Context context) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return false;
            }
            return bundle.getBoolean("XG_SERVICE_PULL_UP_OFF");
        } catch (Throwable th) {
            TLogger.w("AppInfos", "unexpected for forbidPullupService", th);
            return false;
        }
    }
}
