package com.alibaba.baichuan.trade.common;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.ut.device.UTDevice;

public class AlibcMiniTradeCommon {
    public static final String APPKEY = "appkey";
    public static final String APP_VERSION = "app_version";
    public static final String PF_ANDROID = "android";
    public static final String PLATFORM = "platform";
    public static final String SDK_VERSION = "sdk_version";
    protected static String a = null;
    protected static String b = null;
    protected static boolean c = false;
    public static Application context = null;
    protected static String d = "3.2.0.0";
    protected static Environment e = Environment.ONLINE;
    public static String isvVersion = "1.0.0";
    public static String systemVersion = "";
    public static String ttid = "";

    public static boolean checkCommon() {
        return context != null && !TextUtils.isEmpty(systemVersion);
    }

    public static String getAppKey() {
        return b;
    }

    public static String getBuildModel() {
        return Build.MODEL;
    }

    public static String getSDKVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getUtdid() {
        return a;
    }

    public static Boolean init(Application application, String str, String str2) {
        boolean z;
        if (application == null) {
            z = false;
        } else {
            AlibcTradeCommon.context = application;
            if (str == null) {
                str = "99";
            }
            AlibcTradeCommon.systemVersion = str;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            AlibcTradeCommon.b = str2;
            AlibcTradeCommon.a = UTDevice.getUtdid(application);
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static void setChannel(String str) {
    }

    public static void setIsvVersion(String str) {
        AlibcTradeCommon.isvVersion = str;
    }

    public static void setTTID(String str) {
        AlibcTradeCommon.ttid = str;
    }

    public static void turnOffDebug() {
        c = true;
    }

    public static void turnOnDebug() {
        c = true;
    }
}
