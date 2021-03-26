package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.util.List;

public class h {
    private static final String TAG = "h";

    public static boolean g(String str) {
        PackageManager packageManager;
        Context k = c.k();
        if (!(k == null || (packageManager = k.getPackageManager()) == null)) {
            try {
                List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(0);
                if (installedApplications != null) {
                    for (ApplicationInfo applicationInfo : installedApplications) {
                        if (applicationInfo.packageName.equals(str)) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
                g.e(TAG, "exception");
            } catch (Throwable unused2) {
                g.e(TAG, "throwable");
            }
        }
        return false;
    }

    public static String h(String str) {
        Context k = c.k();
        if (k == null) {
            return "";
        }
        try {
            return k.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            String str2 = TAG;
            g.e(str2, "getVersion NameNotFoundException : " + e.getMessage());
            return "";
        } catch (Exception e2) {
            String str3 = TAG;
            g.e(str3, "getVersion: " + e2.getMessage());
            return "";
        } catch (Throwable unused) {
            g.e(TAG, "throwable");
            return "";
        }
    }

    public static int i(String str) {
        Context k = c.k();
        if (k == null) {
            return 0;
        }
        try {
            return k.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            g.e(TAG, "getVersion NameNotFoundException");
            return 0;
        } catch (Exception e) {
            String str2 = TAG;
            g.e(str2, "getVersion: " + e.getMessage());
            return 0;
        }
    }
}
