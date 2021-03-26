package com.huawei.updatesdk.service.d.a;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;

public final class a {
    private static final String a = "a";
    private static String b;

    private a() {
    }

    public static String a() {
        String str = b;
        if (str != null) {
            return str;
        }
        try {
            String packageName = com.huawei.updatesdk.a.b.a.a.a().b().getPackageName();
            PackageInfo packageInfo = com.huawei.updatesdk.a.b.a.a.a().b().getPackageManager().getPackageInfo(com.huawei.updatesdk.a.b.a.a.a().b().getPackageName(), 0);
            if (packageInfo != null) {
                packageName = packageName + packageInfo.versionName;
            }
            String str2 = Build.BRAND;
            if (TextUtils.isEmpty(str2)) {
                str2 = "other";
            }
            a(packageName + "_" + str2);
            return b;
        } catch (Exception e) {
            com.huawei.updatesdk.a.a.b.a.a.a.d(a, "getUserAgent() " + e.toString());
            return null;
        }
    }

    private static void a(String str) {
        b = str;
    }
}
