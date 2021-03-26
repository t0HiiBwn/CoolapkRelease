package com.tencent.tpns.baseapi.base.device;

import android.content.Context;
import com.tencent.tpns.baseapi.core.a.a;

/* compiled from: ProGuard */
public class GuidInfoManager {
    public static synchronized GUIDInfo refreshConnectInfoSynchronized(Context context, int i, RefreshCallback refreshCallback) {
        GUIDInfo a;
        synchronized (GuidInfoManager.class) {
            a = a.a(context, i);
        }
        return a;
    }

    public static synchronized String getLastResolvedGuidServerIP(Context context) {
        String e;
        synchronized (GuidInfoManager.class) {
            e = a.e(context);
        }
        return e;
    }

    public static synchronized void setLastResolvedGuidServerIP(Context context, String str) {
        synchronized (GuidInfoManager.class) {
            a.a(context, str);
        }
    }

    public static synchronized String getMqttServerIP(Context context) {
        String f;
        synchronized (GuidInfoManager.class) {
            f = a.f(context);
        }
        return f;
    }

    public static synchronized void setMqttServerIP(Context context, String str) {
        synchronized (GuidInfoManager.class) {
            a.b(context, str);
        }
    }

    public static synchronized long getMqttServerRefreshTime(Context context) {
        long l;
        synchronized (GuidInfoManager.class) {
            l = a.l(context);
        }
        return l;
    }

    public static synchronized void setMqttServerRefreshTime(Context context, long j) {
        synchronized (GuidInfoManager.class) {
            a.a(context, j);
        }
    }

    public static String getToken(Context context) {
        return a.a(context);
    }

    public static String getTokenList(Context context) {
        return a.b(context);
    }

    public static long getGuid(Context context) {
        return a.c(context);
    }

    public static String getMqttServer(Context context) {
        return a.d(context);
    }

    public static String getMqttUserName(Context context) {
        return a.g(context);
    }

    public static String getMqttPassword(Context context) {
        return a.h(context);
    }

    public static long getExpiredSeconds(Context context) {
        return a.i(context);
    }

    public static long getLastRefreshTime(Context context) {
        return a.j(context);
    }

    public static boolean isExpired(Context context) {
        return a.k(context);
    }

    public static boolean isMqttServerExpired(Context context) {
        return a.m(context);
    }

    public static void forceExpired(Context context) {
        a.n(context);
    }

    public static void clearGuidInfo(Context context) {
        a.o(context);
    }

    public static void wrtieDebugInfo(Context context, String str, String str2) {
        a.a(context, str, str2);
    }

    public static boolean isServerDestroy(Context context) {
        return a.p(context);
    }

    public static int getRefuseRate(Context context) {
        return a.q(context);
    }

    public static int getEncryptLevel(Context context) {
        return a.r(context);
    }
}
