package com.tencent.android.tpush.logging;

import android.content.Context;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;

/* compiled from: ProGuard */
public class TLogger {
    public static void enableDebug(Context context, boolean z) {
        TBaseLogger.enableDebug(context, z);
    }

    public static void v(String str, String str2) {
        TBaseLogger.v(str, str2);
    }

    public static void vv(String str, String str2) {
        TBaseLogger.vv(str, str2);
    }

    public static void d(String str, String str2) {
        TBaseLogger.d(str, str2);
    }

    public static void dd(String str, String str2) {
        TBaseLogger.dd(str, str2);
    }

    public static void i(String str, String str2) {
        TBaseLogger.i(str, str2);
    }

    public static void ii(String str, String str2) {
        TBaseLogger.ii(str, str2);
    }

    public static void w(String str, String str2) {
        TBaseLogger.w(str, str2);
    }

    public static void ww(String str, String str2) {
        TBaseLogger.ww(str, str2);
    }

    public static void e(String str, String str2) {
        TBaseLogger.e(str, str2);
    }

    public static void ee(String str, String str2) {
        TBaseLogger.ee(str, str2);
    }

    public static void v(String str, String str2, Throwable th) {
        TBaseLogger.v(str, str2, th);
    }

    public static void vv(String str, String str2, Throwable th) {
        TBaseLogger.vv(str, str2, th);
    }

    public static void d(String str, String str2, Throwable th) {
        TBaseLogger.d(str, str2, th);
    }

    public static void dd(String str, String str2, Throwable th) {
        TBaseLogger.dd(str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        TBaseLogger.i(str, str2, th);
    }

    public static void ii(String str, String str2, Throwable th) {
        TBaseLogger.ii(str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        TBaseLogger.w(str, str2, th);
    }

    public static void ww(String str, String str2, Throwable th) {
        TBaseLogger.ww(str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        TBaseLogger.e(str, str2, th);
    }

    public static void ee(String str, String str2, Throwable th) {
        TBaseLogger.ee(str, str2, th);
    }

    public static String getStackTraceString(Throwable th) {
        return TBaseLogger.getStackTraceString(th);
    }

    public static void flush() {
        TBaseLogger.flush();
    }
}
