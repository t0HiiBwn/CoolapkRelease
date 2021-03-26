package me.zhanghai.android.appiconloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;

class PackageItemInfoCompat {
    private PackageItemInfoCompat() {
    }

    public static Drawable loadUnbadgedIcon(PackageItemInfo packageItemInfo, PackageManager packageManager) {
        if (Build.VERSION.SDK_INT >= 22) {
            return packageItemInfo.loadUnbadgedIcon(packageManager);
        }
        ApplicationInfo applicationInfo = getApplicationInfo(packageItemInfo);
        Drawable drawable = null;
        if (packageItemInfo.packageName != null) {
            drawable = packageManager.getDrawable(packageItemInfo.packageName, packageItemInfo.icon, applicationInfo);
        }
        if (!(drawable != null || packageItemInfo == applicationInfo || applicationInfo == null)) {
            drawable = loadUnbadgedIcon(applicationInfo, packageManager);
        }
        return drawable == null ? loadDefaultIcon(packageItemInfo, packageManager) : drawable;
    }

    private static ApplicationInfo getApplicationInfo(PackageItemInfo packageItemInfo) {
        if (packageItemInfo instanceof ApplicationInfo) {
            return (ApplicationInfo) packageItemInfo;
        }
        if (packageItemInfo instanceof ComponentInfo) {
            return ((ComponentInfo) packageItemInfo).applicationInfo;
        }
        return null;
    }

    private static Drawable loadDefaultIcon(PackageItemInfo packageItemInfo, PackageManager packageManager) {
        return packageManager.getDefaultActivityIcon();
    }
}
