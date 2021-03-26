package com.coolapk.market.util;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.coolapk.market.model.LocalApk;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class LocalApkUtils {
    private static Field privateFlagsField;

    public static List<LocalApk> getAppList(PackageManager packageManager, boolean z) {
        List<PackageInfo> list;
        try {
            list = packageManager.getInstalledPackages(8192);
        } catch (Exception e) {
            e.printStackTrace();
            list = null;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            LocalApk app = getApp(packageManager, list.get(i), z);
            if (app != null) {
                arrayList.add(app);
            }
        }
        return arrayList;
    }

    public static LocalApk getApp(PackageManager packageManager, PackageInfo packageInfo) {
        return getApp(packageManager, packageInfo, true);
    }

    public static LocalApk getApp(PackageManager packageManager, PackageInfo packageInfo, boolean z) {
        LocalApk.Builder builder;
        Intent intent;
        if (packageInfo == null) {
            return null;
        }
        try {
            if (!packageInfo.packageName.equalsIgnoreCase("android")) {
                if (!packageInfo.packageName.equalsIgnoreCase("android.os")) {
                    if (!isInstalledApp(packageInfo.applicationInfo)) {
                        return null;
                    }
                    if (z && isFrozen(packageInfo.applicationInfo)) {
                        return null;
                    }
                    int i = 0;
                    if (isSystemApp(packageInfo.applicationInfo)) {
                        try {
                            intent = packageManager.getLaunchIntentForPackage(packageInfo.packageName);
                        } catch (Exception unused) {
                            intent = null;
                        }
                        if (intent != null) {
                            builder = LocalApk.newBuilder();
                            builder.systemApp(true);
                        } else {
                            builder = null;
                        }
                    } else {
                        builder = LocalApk.newBuilder();
                        builder.systemApp(false);
                    }
                    if (builder != null) {
                        builder.packageName(packageInfo.packageName);
                        builder.versionName(!TextUtils.isEmpty(packageInfo.versionName) ? packageInfo.versionName : "");
                        if (packageInfo.versionCode > 0) {
                            i = packageInfo.versionCode;
                        }
                        builder.versionCode(i);
                        builder.filePath(packageInfo.applicationInfo.sourceDir);
                        builder.firstInstallTime(packageInfo.firstInstallTime);
                        builder.lastUpdateTime(packageInfo.lastUpdateTime);
                        builder.targetSdkVersion(packageInfo.applicationInfo.targetSdkVersion);
                        File file = new File(packageInfo.applicationInfo.sourceDir);
                        String str = packageInfo.packageName;
                        long j = 0;
                        if (file.exists()) {
                            CharSequence loadLabel = packageInfo.applicationInfo.loadLabel(packageManager);
                            str = loadLabel != null ? loadLabel.toString() : packageInfo.packageName;
                            j = file.length();
                        }
                        builder.appName(str);
                        builder.apkLength(j);
                        return builder.build();
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isSystemApp(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) > 0 || (applicationInfo.flags & 128) > 0;
    }

    public static boolean isInstalledApp(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 8388608) == 8388608;
    }

    public static boolean isFrozen(ApplicationInfo applicationInfo) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (privateFlagsField == null) {
                    privateFlagsField = ApplicationInfo.class.getField("privateFlags");
                }
                if ((privateFlagsField.getInt(applicationInfo) & 1) != 0) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else if ((applicationInfo.flags & 134217728) != 0) {
            return true;
        } else {
            return false;
        }
    }
}
