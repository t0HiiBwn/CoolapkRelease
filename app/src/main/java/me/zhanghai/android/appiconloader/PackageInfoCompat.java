package me.zhanghai.android.appiconloader;

import android.content.pm.PackageInfo;
import android.os.Build;

class PackageInfoCompat {
    private PackageInfoCompat() {
    }

    public static long getLongVersionCode(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }
}
