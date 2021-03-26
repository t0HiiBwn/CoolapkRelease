package com.coolapk.market.util;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateUtils {
    private static final int[] CONSTELLATION_DAY_DATA = {20, 19, 21, 20, 21, 22, 23, 23, 23, 24, 23, 22};
    private static final String[] CONSTELLATION_STRING_DATA = {"摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座"};

    private static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    public static long getSomeDateTime() {
        Calendar calendar = getCalendar();
        calendar.set(2010, 1, 1);
        return calendar.getTimeInMillis() / 1000;
    }

    public static long getTimeInMillis() {
        return getCalendar().getTimeInMillis();
    }

    public static long getTimestamp() {
        return getTimeInMillis() / 1000;
    }

    public static String getTimestampString() {
        return String.valueOf(getTimestamp());
    }

    public static String getTimeDescription(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return getTimeDescription(context, Long.valueOf(str));
    }

    public static String getTimeDescription(Context context, Long l2) {
        long longValue = l2 == null ? 0 : l2.longValue();
        long timestamp = getTimestamp() - longValue;
        if (timestamp < 60) {
            return context.getString(2131887006);
        }
        if (timestamp < 3600) {
            return ((long) (((double) (timestamp / 60)) + 0.5d)) + context.getString(2131887004);
        } else if (timestamp < 86400) {
            return (timestamp / 3600) + context.getString(2131887003);
        } else if (timestamp < 2592000) {
            return (timestamp / 86400) + context.getString(2131887002);
        } else {
            String string = isSameYear(longValue) ? context.getString(2131887007) : "yyyy-M-d";
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(longValue * 1000);
            return new SimpleDateFormat(string, Locale.getDefault()).format(instance.getTime());
        }
    }

    public static String getCreateTimeDescription(Context context, Long l2, boolean z) {
        long longValue = l2 == null ? 0 : l2.longValue();
        String str = z ? "yyyy-M-d HH:mm" : "yyyy-M-d";
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(longValue * 1000);
        return new SimpleDateFormat(str, Locale.getDefault()).format(instance.getTime());
    }

    public static String getTodayDescription() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(getTimestamp() * 1000);
        return new SimpleDateFormat("yyyy", Locale.getDefault()).format(instance.getTime());
    }

    public static String getUpdateTimeDescription(Context context, Long l2) {
        long longValue = l2 == null ? 0 : l2.longValue();
        long timestamp = getTimestamp() - longValue;
        int i = (timestamp > 900 ? 1 : (timestamp == 900 ? 0 : -1));
        if (i < 0) {
            return context.getString(2131887006);
        }
        if (i >= 0 && timestamp < 3600) {
            return context.getString(2131887000);
        }
        if (timestamp >= 3600 && timestamp < 10800) {
            return context.getString(2131887001);
        }
        if (longValue >= floorDay(Calendar.getInstance()).getTimeInMillis() / 1000) {
            return context.getString(2131887054);
        }
        return context.getString(2131887055);
    }

    public static String getHistoryTimeDescription(Context context, Long l2) {
        long longValue = l2 == null ? 0 : l2.longValue();
        if (getTimestamp() - longValue < 3600) {
            return context.getString(2131887006);
        }
        if (longValue >= floorDay(Calendar.getInstance()).getTimeInMillis() / 1000) {
            return context.getString(2131887005);
        }
        return context.getString(2131887008);
    }

    public static boolean isShowTimeInMessage(Long l2, Long l3) {
        long j = 0;
        long longValue = l2 == null ? 0 : l2.longValue();
        if (l3 != null) {
            j = l3.longValue();
        }
        return longValue - j > 600;
    }

    public static String getHourTimeDescription(Long l2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(getTimestamp() * 1000);
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(instance.getTime());
    }

    public static boolean isSameDay(long j) {
        return j > floorDay(Calendar.getInstance()).getTimeInMillis() && j < ceilDay(Calendar.getInstance()).getTimeInMillis();
    }

    public static boolean isSameYear(long j) {
        Calendar floorDay = floorDay(Calendar.getInstance());
        floorDay.set(2, 0);
        floorDay.set(5, 1);
        if (j * 1000 >= floorDay.getTimeInMillis()) {
            return true;
        }
        return false;
    }

    public static Calendar floorDay(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public static Calendar ceilDay(Calendar calendar) {
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar;
    }

    public static long getWeekAgoTime() {
        return System.currentTimeMillis() - 604800000;
    }

    public static Long getDays(Long l2) {
        return Long.valueOf(Long.valueOf(System.currentTimeMillis() - l2.longValue()).longValue() / ((long) 86400000));
    }

    public static String getConstellation(int i, int i2) {
        int i3 = i - 1;
        return i2 < CONSTELLATION_DAY_DATA[i3] ? CONSTELLATION_STRING_DATA[i3] : CONSTELLATION_STRING_DATA[i];
    }
}
