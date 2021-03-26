package com.huawei.hms.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.List;
import java.util.regex.Pattern;

public class Util {
    private static boolean a;
    private static boolean b;
    private static final Object c = new Object();

    public static boolean isChinaROM() {
        return SystemUtils.isChinaROM();
    }

    public static String getProductCountry() {
        int lastIndexOf;
        String systemProperties = getSystemProperties("ro.product.locale.region", "");
        if (!TextUtils.isEmpty(systemProperties)) {
            return systemProperties;
        }
        String systemProperties2 = getSystemProperties("ro.product.locale", "");
        if (!TextUtils.isEmpty(systemProperties2) && (lastIndexOf = systemProperties2.lastIndexOf("_")) != -1) {
            return systemProperties2.substring(lastIndexOf + 1);
        }
        String localCountry = SystemUtils.getLocalCountry();
        if (!TextUtils.isEmpty(localCountry)) {
            return localCountry;
        }
        return "";
    }

    public static String getSystemProperties(String str, String str2) {
        return SystemUtils.getSystemProperties(str, str2);
    }

    public static String getAppId(Context context) {
        return AGCUtils.getAppId(context);
    }

    public static int getHmsVersion(Context context) {
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("Util", "In getHmsVersion, Failed to get 'PackageManager' instance.");
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (!(applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("com.huawei.hms.version")) == null)) {
                String valueOf = String.valueOf(obj);
                if (!TextUtils.isEmpty(valueOf)) {
                    return b(valueOf);
                }
            }
            HMSLog.i("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
            return 0;
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
            return 0;
        }
    }

    private static boolean a(String str) {
        return Pattern.compile("(^([0-9]{1,2}\\.){2}[0-9]{1,2}$)|(^([0-9]{1,2}\\.){3}[0-9]{1,3}$)").matcher(str).find();
    }

    private static int b(String str) {
        if (!a(str)) {
            return 0;
        }
        String[] split = str.split("\\.");
        if (split.length < 3) {
            return 0;
        }
        int parseInt = (Integer.parseInt(split[0]) * 10000000) + (Integer.parseInt(split[1]) * 100000) + (Integer.parseInt(split[2]) * 1000);
        return split.length == 4 ? parseInt + Integer.parseInt(split[3]) : parseInt;
    }

    public static String getCpId(Context context) {
        return AGCUtils.getCpId(context);
    }

    public static String getAppName(Context context, String str) {
        if (context == null) {
            HMSLog.e("Util", "In getAppName, context is null.");
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("Util", "In getAppName, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName();
            }
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0));
            if (applicationLabel == null) {
                return "";
            }
            return applicationLabel.toString();
        } catch (PackageManager.NameNotFoundException | Resources.NotFoundException unused) {
            HMSLog.e("Util", "In getAppName, Failed to get app name.");
            return "";
        }
    }

    public static void unBindServiceCatchException(Context context, ServiceConnection serviceConnection) {
        try {
            HMSLog.i("Util", "Trying to unbind service from " + serviceConnection);
            context.unbindService(serviceConnection);
        } catch (Exception e) {
            HMSLog.e("Util", "On unBindServiceException:" + e.getMessage());
        }
    }

    public static int compareHmsVersion(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (a(str) && a(str2)) {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            if (Integer.parseInt(split[0]) > Integer.parseInt(split2[0])) {
                return 1;
            }
            if (Integer.parseInt(split[0]) < Integer.parseInt(split2[0])) {
                return -1;
            }
            if (Integer.parseInt(split[1]) > Integer.parseInt(split2[1])) {
                return 1;
            }
            if (Integer.parseInt(split[1]) < Integer.parseInt(split2[1])) {
                return -1;
            }
            if (Integer.parseInt(split[2]) > Integer.parseInt(split2[2])) {
                return 1;
            }
            if (Integer.parseInt(split[2]) < Integer.parseInt(split2[2])) {
                return -1;
            }
        }
        return 0;
    }

    public static Activity getValidActivity(Activity activity, Activity activity2) {
        if (activity != null && !activity.isFinishing()) {
            return activity;
        }
        if (activity2 == null || activity2.isFinishing()) {
            return null;
        }
        return activity2;
    }

    public static boolean isEMUI() {
        return SystemUtils.isEMUI();
    }

    public static boolean isBackground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return true;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return true;
        }
        String processName = getProcessName(context, Process.myPid());
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (TextUtils.equals(runningAppProcessInfo.processName, processName)) {
                HMSLog.i("Util", "appProcess.importance is " + runningAppProcessInfo.importance);
                boolean z = runningAppProcessInfo.importance == 100;
                boolean inKeyguardRestrictedInputMode = keyguardManager.inKeyguardRestrictedInputMode();
                HMSLog.i("Util", "isForground is " + z + "***  isLockedState is " + inKeyguardRestrictedInputMode);
                if (!z || inKeyguardRestrictedInputMode) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public static String getProcessName(Context context, int i) {
        return UIUtil.getProcessName(context, i);
    }

    public static String getNetType(Context context) {
        return SystemUtils.getNetType(context);
    }

    public static Activity getActiveActivity(Activity activity, Context context) {
        return UIUtil.getActiveActivity(activity, context);
    }

    public static boolean isAvailableLibExist(Context context) {
        Object obj;
        synchronized (c) {
            if (!a) {
                boolean z = false;
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    HMSLog.e("Util", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
                    try {
                        Class.forName("com.huawei.hms.adapter.AvailableAdapter");
                        z = true;
                    } catch (ClassNotFoundException unused) {
                        HMSLog.e("Util", "In isAvailableLibExist, Failed to find class AvailableAdapter.");
                    }
                } else {
                    try {
                        ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                        if (!(applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("availableLoaded")) == null || !String.valueOf(obj).equalsIgnoreCase("yes"))) {
                            HMSLog.i("Util", "available exist: true");
                            z = true;
                        }
                        HMSLog.e("Util", "In isAvailableLibExist, Failed to read meta data for the availableLoaded.");
                    } catch (PackageManager.NameNotFoundException unused2) {
                        HMSLog.e("Util", "In isAvailableLibExist, Failed to read meta data for the availableLoaded.");
                    }
                }
                b = z;
                a = true;
            }
        }
        HMSLog.i("Util", "available exist: " + b);
        return b;
    }
}
