package com.loc;

import java.util.Calendar;
import java.util.Date;

/* compiled from: DateUtil */
public final class ek {
    private static long a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j));
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    public static long a(long j, long j2, int i) {
        if (i > 0) {
            try {
                if (Math.abs(j - j2) > ((long) i) * 31536000000L) {
                    long a = a(j2) + (j - a(j));
                    long abs = Math.abs(a - j2);
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(new Date(a));
                    int i2 = instance.get(11);
                    if (i2 == 23 && abs >= 82800000) {
                        a -= 86400000;
                    }
                    return (i2 != 0 || abs < 82800000) ? a : a + 86400000;
                }
            } catch (Throwable unused) {
            }
        }
        return j;
    }
}
