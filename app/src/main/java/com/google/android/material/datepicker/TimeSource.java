package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

class TimeSource {
    private static final TimeSource SYSTEM_TIME_SOURCE = new TimeSource(null, null);
    private final Long fixedTimeMs;
    private final TimeZone fixedTimeZone;

    private TimeSource(Long l2, TimeZone timeZone) {
        this.fixedTimeMs = l2;
        this.fixedTimeZone = timeZone;
    }

    static TimeSource system() {
        return SYSTEM_TIME_SOURCE;
    }

    static TimeSource fixed(long j, TimeZone timeZone) {
        return new TimeSource(Long.valueOf(j), timeZone);
    }

    static TimeSource fixed(long j) {
        return new TimeSource(Long.valueOf(j), null);
    }

    Calendar now() {
        return now(this.fixedTimeZone);
    }

    Calendar now(TimeZone timeZone) {
        Calendar instance = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l2 = this.fixedTimeMs;
        if (l2 != null) {
            instance.setTimeInMillis(l2.longValue());
        }
        return instance;
    }
}
