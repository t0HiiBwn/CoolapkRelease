package com.tencent.tpns.baseapi;

import android.content.Context;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.baseapi.core.a;

/* compiled from: ProGuard */
public class XGApiConfig {
    private static String a = "";

    public static String getDebugMQTTServer(Context context) {
        if (Util.isNullOrEmptyString(a)) {
            a = PushPreferences.getString(context, "debug_server", "");
        }
        return a;
    }

    public static void setDebugMQTTServer(Context context, String str) {
        if (!Util.isNullOrEmptyString(str) && !a.equals(str)) {
            a = str;
            PushPreferences.putString(context, "debug_server", str);
        }
    }

    public static long getAccessId(Context context) {
        return a.a(context);
    }

    public static void setAccessId(Context context, long j) {
        a.a(context, j);
    }

    public static String getAccessKey(Context context) {
        return a.b(context);
    }

    public static void setAccessKey(Context context, String str) {
        a.a(context, str);
    }

    public static void setServerSuffix(Context context, String str) {
        a.b(context, str);
    }

    public static String getServerSuffix(Context context) {
        return a.c(context);
    }

    public static void setGuidServerAddr(Context context, String str) {
        a.c(context, str);
    }

    public static void setGuidServerAddrWithoutRefreshingTime(Context context, String str) {
        a.g(context, str);
    }

    public static void setStatServerAddr(Context context, String str) {
        a.d(context, str);
    }

    public static String getStatServerAddr(Context context) {
        return a.e(context);
    }

    public static void setErrCodeServerAddr(Context context, String str) {
        a.e(context, str);
    }

    public static String getErrCodeServerAddr(Context context) {
        return a.f(context);
    }

    public static void setCustomEvenServerAddr(Context context, String str) {
        a.f(context, str);
    }

    public static String getCustomEvenServerAddr(Context context) {
        return a.g(context);
    }

    public static String getOfflineMsgServerAddr(Context context) {
        return a.i(context);
    }

    public static void setPowerSaveMode(Context context, boolean z) {
        a.a(context, z);
    }

    public static boolean isPowerSaveMode(Context context) {
        return a.j(context);
    }

    public static long getFreeVersionAccessId(Context context) {
        return a.k(context);
    }

    public static boolean isEnableService(Context context) {
        return a.l(context);
    }

    public static void setRegisterSuccess(Context context) {
        a.m(context);
    }

    public static void clearRegistered(Context context) {
        a.n(context);
    }

    public static boolean isRegistered(Context context) {
        return a.o(context);
    }
}
