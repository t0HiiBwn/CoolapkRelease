package com.alibaba.mtl.log.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.mtl.log.a;

/* compiled from: AppInfoUtil */
public class b {
    private static String ae = "";
    private static String g;

    public static String p() {
        return "";
    }

    public static String q() {
        return "";
    }

    public static String m() {
        if (a.getContext() == null) {
            return "";
        }
        try {
            String string = a.getContext().getSharedPreferences("UTCommon", 0).getString("_lun", "");
            if (!TextUtils.isEmpty(string)) {
                return new String(c.decode(string.getBytes(), 2), "UTF-8");
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String n() {
        if (a.getContext() == null) {
            return "";
        }
        try {
            String string = a.getContext().getSharedPreferences("UTCommon", 0).getString("_luid", "");
            if (!TextUtils.isEmpty(string)) {
                return new String(c.decode(string.getBytes(), 2), "UTF-8");
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String o() {
        return ae;
    }

    public static void n(String str) {
        i.a("AppInfoUtil", "[setChannle]", str);
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("@");
            if (indexOf == -1) {
                ae = str;
            } else {
                ae = str.substring(0, indexOf);
            }
        }
    }

    public static String getAppkey() {
        return g;
    }

    public static void o(String str) {
        i.a("AppInfoUtil", "set Appkey:", str);
        g = str;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(packageName)) {
                    if (runningAppProcessInfo.importance == 400) {
                        return false;
                    }
                    if (powerManager.isScreenOn()) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }
}
