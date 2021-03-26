package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import com.bytedance.sdk.openadsdk.preload.geckox.h.b;
import java.util.List;

/* compiled from: AppUtils */
public class a {
    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            b.a("gecko-debug-tag", "getVersion:", e);
            return "null";
        }
    }

    public static String b(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            if (applicationInfo == null) {
                return "";
            }
            return applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable th) {
            b.a("gecko-debug-tag", "getApplicationName:", th);
            return "";
        }
    }

    public static String c(Context context) {
        try {
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return null;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception e) {
            b.a("gecko-debug-tag", "getProcessName:", e);
        }
    }
}
