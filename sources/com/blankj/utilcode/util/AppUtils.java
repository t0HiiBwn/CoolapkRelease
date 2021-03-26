package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class AppUtils {
    private AppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void registerAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        Objects.requireNonNull(onAppStatusChangedListener, "Argument 'listener' of type Utils.OnAppStatusChangedListener (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        UtilsBridge.addOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    public static void unregisterAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        Objects.requireNonNull(onAppStatusChangedListener, "Argument 'listener' of type Utils.OnAppStatusChangedListener (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        UtilsBridge.removeOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    public static void installApp(String str) {
        installApp(UtilsBridge.getFileByPath(str));
    }

    public static void installApp(File file) {
        Intent installAppIntent = UtilsBridge.getInstallAppIntent(file);
        if (installAppIntent != null) {
            Utils.getApp().startActivity(installAppIntent);
        }
    }

    public static void installApp(Uri uri) {
        Intent installAppIntent = UtilsBridge.getInstallAppIntent(uri);
        if (installAppIntent != null) {
            Utils.getApp().startActivity(installAppIntent);
        }
    }

    public static void uninstallApp(String str) {
        if (!UtilsBridge.isSpace(str)) {
            Utils.getApp().startActivity(UtilsBridge.getUninstallAppIntent(str));
        }
    }

    public static boolean isAppInstalled(String str) {
        if (UtilsBridge.isSpace(str)) {
            return false;
        }
        try {
            return Utils.getApp().getPackageManager().getApplicationInfo(str, 0).enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isAppRoot() {
        if (UtilsBridge.execCmd("echo root", true).result == 0) {
            return true;
        }
        return false;
    }

    public static boolean isAppDebug() {
        return isAppDebug(Utils.getApp().getPackageName());
    }

    public static boolean isAppDebug(String str) {
        if (UtilsBridge.isSpace(str)) {
            return false;
        }
        try {
            if ((Utils.getApp().getPackageManager().getApplicationInfo(str, 0).flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isAppSystem() {
        return isAppSystem(Utils.getApp().getPackageName());
    }

    public static boolean isAppSystem(String str) {
        if (UtilsBridge.isSpace(str)) {
            return false;
        }
        try {
            if ((Utils.getApp().getPackageManager().getApplicationInfo(str, 0).flags & 1) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isAppForeground() {
        return UtilsBridge.isAppForeground();
    }

    public static boolean isAppForeground(String str) {
        Objects.requireNonNull(str, "Argument 'pkgName' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return !UtilsBridge.isSpace(str) && str.equals(UtilsBridge.getForegroundProcessName());
    }

    public static boolean isAppRunning(String str) {
        ActivityManager activityManager;
        if (!UtilsBridge.isSpace(str) && (activityManager = (ActivityManager) Utils.getApp().getSystemService("activity")) != null) {
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);
            if (runningTasks != null && runningTasks.size() > 0) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (runningTaskInfo.baseActivity != null && str.equals(runningTaskInfo.baseActivity.getPackageName())) {
                        return true;
                    }
                }
            }
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
            if (runningServices != null && runningServices.size() > 0) {
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    if (str.equals(runningServiceInfo.service.getPackageName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void launchApp(String str) {
        if (!UtilsBridge.isSpace(str)) {
            Intent launchAppIntent = UtilsBridge.getLaunchAppIntent(str);
            if (launchAppIntent == null) {
                Log.e("AppUtils", "Didn't exist launcher activity.");
            } else {
                Utils.getApp().startActivity(launchAppIntent);
            }
        }
    }

    public static void relaunchApp() {
        relaunchApp(false);
    }

    public static void relaunchApp(boolean z) {
        Intent launchAppIntent = UtilsBridge.getLaunchAppIntent(Utils.getApp().getPackageName());
        if (launchAppIntent == null) {
            Log.e("AppUtils", "Didn't exist launcher activity.");
            return;
        }
        launchAppIntent.addFlags(335577088);
        Utils.getApp().startActivity(launchAppIntent);
        if (z) {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }

    public static void launchAppDetailsSettings() {
        launchAppDetailsSettings(Utils.getApp().getPackageName());
    }

    public static void launchAppDetailsSettings(String str) {
        if (!UtilsBridge.isSpace(str)) {
            Intent launchAppDetailsSettingsIntent = UtilsBridge.getLaunchAppDetailsSettingsIntent(str, true);
            if (UtilsBridge.isIntentAvailable(launchAppDetailsSettingsIntent)) {
                Utils.getApp().startActivity(launchAppDetailsSettingsIntent);
            }
        }
    }

    public static void launchAppDetailsSettings(Activity activity, int i) {
        launchAppDetailsSettings(activity, i, Utils.getApp().getPackageName());
    }

    public static void launchAppDetailsSettings(Activity activity, int i, String str) {
        if (activity != null && !UtilsBridge.isSpace(str)) {
            Intent launchAppDetailsSettingsIntent = UtilsBridge.getLaunchAppDetailsSettingsIntent(str, false);
            if (UtilsBridge.isIntentAvailable(launchAppDetailsSettingsIntent)) {
                activity.startActivityForResult(launchAppDetailsSettingsIntent, i);
            }
        }
    }

    public static void exitApp() {
        UtilsBridge.finishAllActivities();
        System.exit(0);
    }

    public static Drawable getAppIcon() {
        return getAppIcon(Utils.getApp().getPackageName());
    }

    public static Drawable getAppIcon(String str) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        try {
            PackageManager packageManager = Utils.getApp().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.applicationInfo.loadIcon(packageManager);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getAppIconId() {
        return getAppIconId(Utils.getApp().getPackageName());
    }

    public static int getAppIconId(String str) {
        if (UtilsBridge.isSpace(str)) {
            return 0;
        }
        try {
            PackageInfo packageInfo = Utils.getApp().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return 0;
            }
            return packageInfo.applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getAppPackageName() {
        String packageName = Utils.getApp().getPackageName();
        Objects.requireNonNull(packageName, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppPackageName() marked by @androidx.annotation.NonNull");
        return packageName;
    }

    public static String getAppName() {
        String appName = getAppName(Utils.getApp().getPackageName());
        Objects.requireNonNull(appName, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppName() marked by @androidx.annotation.NonNull");
        return appName;
    }

    public static String getAppName(String str) {
        String str2;
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        try {
            PackageManager packageManager = Utils.getApp().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                str2 = "";
            } else {
                str2 = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            }
            if (str2 != null) {
                return str2;
            }
            throw new NullPointerException("Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppName() marked by @androidx.annotation.NonNull");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getAppPath() {
        String appPath = getAppPath(Utils.getApp().getPackageName());
        Objects.requireNonNull(appPath, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppPath() marked by @androidx.annotation.NonNull");
        return appPath;
    }

    public static String getAppPath(String str) {
        String str2;
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = Utils.getApp().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                str2 = "";
            } else {
                str2 = packageInfo.applicationInfo.sourceDir;
            }
            if (str2 != null) {
                return str2;
            }
            throw new NullPointerException("Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppPath() marked by @androidx.annotation.NonNull");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getAppVersionName() {
        String appVersionName = getAppVersionName(Utils.getApp().getPackageName());
        Objects.requireNonNull(appVersionName, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppVersionName() marked by @androidx.annotation.NonNull");
        return appVersionName;
    }

    public static String getAppVersionName(String str) {
        String str2;
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = Utils.getApp().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                str2 = "";
            } else {
                str2 = packageInfo.versionName;
            }
            if (str2 != null) {
                return str2;
            }
            throw new NullPointerException("Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppVersionName() marked by @androidx.annotation.NonNull");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getAppVersionCode() {
        return getAppVersionCode(Utils.getApp().getPackageName());
    }

    public static int getAppVersionCode(String str) {
        if (UtilsBridge.isSpace(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = Utils.getApp().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Signature[] getAppSignatures() {
        return getAppSignatures(Utils.getApp().getPackageName());
    }

    public static Signature[] getAppSignatures(String str) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        try {
            PackageManager packageManager = Utils.getApp().getPackageManager();
            if (Build.VERSION.SDK_INT >= 28) {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217728);
                if (packageInfo == null) {
                    return null;
                }
                SigningInfo signingInfo = packageInfo.signingInfo;
                if (signingInfo.hasMultipleSigners()) {
                    return signingInfo.getApkContentsSigners();
                }
                return signingInfo.getSigningCertificateHistory();
            }
            PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 64);
            if (packageInfo2 == null) {
                return null;
            }
            return packageInfo2.signatures;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Signature[] getAppSignatures(File file) {
        if (file == null) {
            return null;
        }
        PackageManager packageManager = Utils.getApp().getPackageManager();
        if (Build.VERSION.SDK_INT >= 28) {
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 134217728);
            if (packageArchiveInfo == null) {
                return null;
            }
            SigningInfo signingInfo = packageArchiveInfo.signingInfo;
            if (signingInfo.hasMultipleSigners()) {
                return signingInfo.getApkContentsSigners();
            }
            return signingInfo.getSigningCertificateHistory();
        }
        PackageInfo packageArchiveInfo2 = packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 64);
        if (packageArchiveInfo2 == null) {
            return null;
        }
        return packageArchiveInfo2.signatures;
    }

    public static List<String> getAppSignaturesSHA1() {
        List<String> appSignaturesSHA1 = getAppSignaturesSHA1(Utils.getApp().getPackageName());
        Objects.requireNonNull(appSignaturesSHA1, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppSignaturesSHA1() marked by @androidx.annotation.NonNull");
        return appSignaturesSHA1;
    }

    public static List<String> getAppSignaturesSHA1(String str) {
        List<String> appSignaturesHash = getAppSignaturesHash(str, "SHA1");
        Objects.requireNonNull(appSignaturesHash, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppSignaturesSHA1() marked by @androidx.annotation.NonNull");
        return appSignaturesHash;
    }

    public static List<String> getAppSignaturesSHA256() {
        List<String> appSignaturesSHA256 = getAppSignaturesSHA256(Utils.getApp().getPackageName());
        Objects.requireNonNull(appSignaturesSHA256, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppSignaturesSHA256() marked by @androidx.annotation.NonNull");
        return appSignaturesSHA256;
    }

    public static List<String> getAppSignaturesSHA256(String str) {
        List<String> appSignaturesHash = getAppSignaturesHash(str, "SHA256");
        Objects.requireNonNull(appSignaturesHash, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppSignaturesSHA256() marked by @androidx.annotation.NonNull");
        return appSignaturesHash;
    }

    public static List<String> getAppSignaturesMD5() {
        List<String> appSignaturesMD5 = getAppSignaturesMD5(Utils.getApp().getPackageName());
        Objects.requireNonNull(appSignaturesMD5, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppSignaturesMD5() marked by @androidx.annotation.NonNull");
        return appSignaturesMD5;
    }

    public static List<String> getAppSignaturesMD5(String str) {
        List<String> appSignaturesHash = getAppSignaturesHash(str, "MD5");
        Objects.requireNonNull(appSignaturesHash, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppSignaturesMD5() marked by @androidx.annotation.NonNull");
        return appSignaturesHash;
    }

    public static int getAppUid() {
        return getAppUid(Utils.getApp().getPackageName());
    }

    public static int getAppUid(String str) {
        try {
            return Utils.getApp().getPackageManager().getApplicationInfo(str, 0).uid;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static List<String> getAppSignaturesHash(String str, String str2) {
        Signature[] appSignatures;
        ArrayList arrayList = new ArrayList();
        if (!UtilsBridge.isSpace(str) && (appSignatures = getAppSignatures(str)) != null && appSignatures.length > 0) {
            for (Signature signature : appSignatures) {
                arrayList.add(UtilsBridge.bytes2HexString(UtilsBridge.hashTemplate(signature.toByteArray(), str2)).replaceAll("(?<=[0-9A-F]{2})[0-9A-F]{2}", ":$0"));
            }
        }
        return arrayList;
    }

    public static AppInfo getAppInfo() {
        return getAppInfo(Utils.getApp().getPackageName());
    }

    public static AppInfo getAppInfo(String str) {
        try {
            PackageManager packageManager = Utils.getApp().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return getBean(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<AppInfo> getAppsInfo() {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = Utils.getApp().getPackageManager();
        if (packageManager == null) {
            return arrayList;
        }
        for (PackageInfo packageInfo : packageManager.getInstalledPackages(0)) {
            AppInfo bean = getBean(packageManager, packageInfo);
            if (bean != null) {
                arrayList.add(bean);
            }
        }
        return arrayList;
    }

    public static AppInfo getApkInfo(File file) {
        if (file == null || !file.isFile() || !file.exists()) {
            return null;
        }
        return getApkInfo(file.getAbsolutePath());
    }

    public static AppInfo getApkInfo(String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (UtilsBridge.isSpace(str) || (packageManager = Utils.getApp().getPackageManager()) == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0)) == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        return getBean(packageManager, packageArchiveInfo);
    }

    private static AppInfo getBean(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        String str = packageInfo.versionName;
        int i = packageInfo.versionCode;
        String str2 = packageInfo.packageName;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return new AppInfo(str2, "", null, "", str, i, false);
        }
        return new AppInfo(str2, applicationInfo.loadLabel(packageManager).toString(), applicationInfo.loadIcon(packageManager), applicationInfo.sourceDir, str, i, (applicationInfo.flags & 1) != 0);
    }

    public static class AppInfo {
        private Drawable icon;
        private boolean isSystem;
        private String name;
        private String packageName;
        private String packagePath;
        private int versionCode;
        private String versionName;

        public Drawable getIcon() {
            return this.icon;
        }

        public void setIcon(Drawable drawable) {
            this.icon = drawable;
        }

        public boolean isSystem() {
            return this.isSystem;
        }

        public void setSystem(boolean z) {
            this.isSystem = z;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getPackagePath() {
            return this.packagePath;
        }

        public void setPackagePath(String str) {
            this.packagePath = str;
        }

        public int getVersionCode() {
            return this.versionCode;
        }

        public void setVersionCode(int i) {
            this.versionCode = i;
        }

        public String getVersionName() {
            return this.versionName;
        }

        public void setVersionName(String str) {
            this.versionName = str;
        }

        public AppInfo(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            setName(str2);
            setIcon(drawable);
            setPackageName(str);
            setPackagePath(str3);
            setVersionName(str4);
            setVersionCode(i);
            setSystem(z);
        }

        public String toString() {
            String str = "{\n    pkg name: " + getPackageName() + "\n    app icon: " + getIcon() + "\n    app name: " + getName() + "\n    app path: " + getPackagePath() + "\n    app v name: " + getVersionName() + "\n    app v code: " + getVersionCode() + "\n    is system: " + isSystem() + "\n}";
            Objects.requireNonNull(str, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.AppInfo.toString() marked by @androidx.annotation.NonNull");
            return str;
        }
    }
}
