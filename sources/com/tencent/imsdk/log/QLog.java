package com.tencent.imsdk.log;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.imsdk.manager.IMSystemUtil;

public class QLog {
    private static final String TAG = "QLog";
    private static boolean sIsSoLoaded = IMSystemUtil.ExperimentalAPI.loadLibrary(null);

    public static native void nativeWriteLog(int i, String str, String str2, int i2, String str3);

    public static void v(String str, String str2) {
        log(2, str, str2);
    }

    public static void d(String str, String str2) {
        log(3, str, str2);
    }

    public static void i(String str, String str2) {
        log(4, str, str2);
    }

    public static void w(String str, String str2) {
        log(5, str, str2);
    }

    public static void e(String str, String str2) {
        log(6, str, str2);
    }

    private static void log(int i, String str, String str2) {
        if (!sIsSoLoaded) {
            Log.e(TAG, "libImSDK is not loaded!");
        } else if (i < 0 || i > 6) {
            String str3 = TAG;
            e(str3, "logLevel is illegal ： " + i);
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String str4 = TAG;
            e(str4, "logLevel is illegal ： " + i);
        } else {
            nativeWriteLog(i, str, "", 0, str2);
        }
    }

    public static void writeException(String str, String str2, Throwable th) {
        if (!sIsSoLoaded) {
            Log.e(TAG, "libImSDK is not loaded!");
            return;
        }
        Log.e(str, str2 + " exception : " + Log.getStackTraceString(th));
        e(str, str2 + " exception : " + Log.getStackTraceString(th));
    }
}
