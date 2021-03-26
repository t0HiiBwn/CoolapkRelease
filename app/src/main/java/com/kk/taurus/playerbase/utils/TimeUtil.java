package com.kk.taurus.playerbase.utils;

import android.text.TextUtils;

public class TimeUtil {
    private static final long SECONDS_ONE_HOUR = 3600;
    public static final String TIME_FORMAT_01 = "%02d:%02d";
    public static final String TIME_FORMAT_02 = "%02d:%02d:%02d";

    public static String getTimeFormat1(long j) {
        return getTime("%02d:%02d", j);
    }

    public static String getTimeFormat2(long j) {
        return getTime("%02d:%02d:%02d", j);
    }

    public static String getTimeSmartFormat(long j) {
        if (((long) ((int) (j / 1000))) >= 3600) {
            return getTimeFormat2(j);
        }
        return getTimeFormat1(j);
    }

    public static String getFormat(long j) {
        return ((long) ((int) (j / 1000))) >= 3600 ? "%02d:%02d:%02d" : "%02d:%02d";
    }

    public static String getTime(String str, long j) {
        if (j <= 0) {
            j = 0;
        }
        int i = (int) (j / 1000);
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        if ("%02d:%02d".equals(str)) {
            return String.format(str, Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ("%02d:%02d:%02d".equals(str)) {
            return String.format(str, Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if (TextUtils.isEmpty(str)) {
            str = "%02d:%02d:%02d";
        }
        return String.format(str, Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2));
    }
}
