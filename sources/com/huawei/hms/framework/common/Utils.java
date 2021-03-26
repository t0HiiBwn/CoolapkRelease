package com.huawei.hms.framework.common;

import android.os.SystemClock;

public class Utils {
    public static long getCurrentTime(boolean z) {
        return z ? SystemClock.elapsedRealtime() : System.currentTimeMillis();
    }
}
