package com.huawei.updatesdk.service.e;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class c {
    private static Integer a;
    private static boolean b;
    private static boolean c;
    private static Field d;

    public enum a {
        NOT_INSTALLED,
        INSTALLED,
        INSTALLED_LOWCODE
    }

    public static PackageInfo a(String str, Context context) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (Exception unused) {
            com.huawei.updatesdk.a.a.b.a.a.a.d("PackageUtils", "not found: " + str);
            return null;
        }
    }

    public static a a(Context context) {
        a aVar = a.NOT_INSTALLED;
        if (context == null) {
            return aVar;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.appmarket", 0);
            if (packageInfo == null) {
                return aVar;
            }
            Log.i("PackageUtils", "appmarket info,versioncode = " + packageInfo.versionCode + "versionName = " + packageInfo.versionName);
            return packageInfo.versionCode < 70203000 ? a.INSTALLED_LOWCODE : a.INSTALLED;
        } catch (Exception e) {
            com.huawei.updatesdk.a.a.b.a.a.a.b("PackageUtils", "isInstallByPackage Exception:" + e.toString());
            return aVar;
        }
    }

    public static Integer a() {
        String str;
        StringBuilder sb;
        String str2;
        if (b) {
            return a;
        }
        try {
            Class<?> cls = Class.forName("android.content.pm.PackageParser");
            a = Integer.valueOf(cls.getDeclaredField("PARSE_IS_REMOVABLE_PREINSTALLED_APK").getInt(cls));
        } catch (NoSuchFieldException e) {
            sb = new StringBuilder();
            sb.append("isDelApp error NoSuchFieldException:");
            str2 = e.toString();
        } catch (ClassNotFoundException e2) {
            sb = new StringBuilder();
            sb.append("isDelApp error ClassNotFoundException:");
            str2 = e2.toString();
        } catch (IllegalAccessException e3) {
            sb = new StringBuilder();
            sb.append("isDelApp error IllegalAccessException:");
            str2 = e3.toString();
        } catch (IllegalArgumentException e4) {
            sb = new StringBuilder();
            sb.append("isDelApp error IllegalArgumentException:");
            str2 = e4.toString();
        } catch (Exception e5) {
            str = e5.toString();
            com.huawei.updatesdk.a.a.b.a.a.a.a("PackageUtils", str);
            b = true;
            return a;
        }
        b = true;
        return a;
        sb.append(str2);
        str = sb.toString();
        com.huawei.updatesdk.a.a.b.a.a.a.a("PackageUtils", str);
        b = true;
        return a;
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0) != null;
            } catch (Exception e) {
                com.huawei.updatesdk.a.a.b.a.a.a.b("PackageUtils", "isAppInstalled NameNotFoundException:" + e.toString());
            }
        }
        return false;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!Pattern.compile("(\\.)+[\\\\/]+").matcher(str).find()) {
            return new File(str).delete();
        }
        com.huawei.updatesdk.a.a.b.a.a.a.a("PackageUtils", "remov APK fail. the apk path is not valid");
        return false;
    }

    public static int b(String str) {
        try {
            PackageInfo packageInfo = com.huawei.updatesdk.a.b.a.a.a().b().getPackageManager().getPackageInfo(str, 128);
            return (packageInfo == null || packageInfo.applicationInfo == null || packageInfo.applicationInfo.metaData == null || !packageInfo.applicationInfo.metaData.containsKey("com.huawei.maple.flag")) ? 0 : 1;
        } catch (Exception unused) {
            com.huawei.updatesdk.a.a.b.a.a.a.d("PackageUtils", "getMapleStatus not found: " + str);
            return 0;
        }
    }

    public static Field b() {
        if (c) {
            return d;
        }
        try {
            d = ApplicationInfo.class.getField("hwFlags");
        } catch (NoSuchFieldException unused) {
            com.huawei.updatesdk.a.a.b.a.a.a.a("PackageUtils", "can not find hwFlags");
        }
        c = true;
        return d;
    }

    public static boolean b(Context context) {
        return d(context) > 90000000;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 23 && new ContextWrapper(com.huawei.updatesdk.a.b.a.a.a().b()).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static boolean c(Context context) {
        return d(context) > 100200000;
    }

    private static int d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.appmarket", 0).versionCode;
        } catch (Exception e) {
            com.huawei.updatesdk.a.a.b.a.a.a.b("PackageUtils", "isInstallByPackage Exception:" + e.toString());
            return 0;
        }
    }
}
