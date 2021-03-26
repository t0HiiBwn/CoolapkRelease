package com.tencent.imsdk.utils;

import com.tencent.imsdk.log.QLog;

public class QualityReportHelper {
    private static final String TAG = ("imsdk." + QualityReportHelper.class.getSimpleName());

    public static void report(int i, int i2, String str) {
        String str2 = TAG;
        QLog.d(str2, "event report, eventId: " + i + "|code: " + i2 + "|descr: " + str);
    }
}
