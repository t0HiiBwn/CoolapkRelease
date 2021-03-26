package com.coolapk.market.view.danmaku.easy.utils;

import android.util.Log;

public class EasyL {
    private static boolean sEnabled;

    public static void setEnabled(boolean z) {
        sEnabled = z;
    }

    public static void v(String str, String str2) {
        if (sEnabled) {
            Log.v(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (sEnabled) {
            Log.d(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (sEnabled) {
            Log.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (sEnabled) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (sEnabled) {
            Log.e(str, str2);
        }
    }

    public static void d(String str, Object... objArr) {
        if (sEnabled) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                sb.append(obj);
                sb.append(" ");
            }
            Log.d(str, sb.toString());
        }
    }
}
