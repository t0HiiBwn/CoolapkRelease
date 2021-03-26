package com.kk.taurus.playerbase.log;

import android.util.Log;

public class PLog {
    public static boolean LOG_OPEN;

    public static void d(String str, String str2) {
        if (LOG_OPEN) {
            Log.d(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (LOG_OPEN) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (LOG_OPEN) {
            Log.e(str, str2);
        }
    }
}
