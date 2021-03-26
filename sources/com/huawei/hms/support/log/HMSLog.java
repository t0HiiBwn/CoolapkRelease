package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class HMSLog {
    private static final a a = new a();

    public static void init(Context context, int i, String str) {
        a aVar = a;
        aVar.a(context, i, str);
        aVar.a(str, "============================================================================\n====== " + a(context) + "\n============================================================================");
    }

    private static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 16384);
                return "HMS-" + packageInfo.versionName + "(" + packageInfo.versionCode + ")";
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return "HMS-[unknown-version]";
    }

    public static boolean isInfoEnable() {
        return a.a(4);
    }

    public static boolean isWarnEnable() {
        return a.a(5);
    }

    public static boolean isErrorEnable() {
        return a.a(6);
    }

    public static void d(String str, String str2) {
        a.a(3, str, str2);
    }

    public static void i(String str, String str2) {
        a.a(4, str, str2);
    }

    public static void w(String str, String str2) {
        a.a(5, str, str2);
    }

    public static void e(String str, String str2) {
        a.a(6, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        a.a(6, str, str2, th);
    }

    public static void e(String str, long j, String str2) {
        a aVar = a;
        aVar.a(6, str, "[" + j + "] " + str2);
    }

    public static void e(String str, long j, String str2, Throwable th) {
        a aVar = a;
        aVar.a(6, str, "[" + j + "] " + str2, th);
    }
}
