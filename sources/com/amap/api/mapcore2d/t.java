package com.amap.api.mapcore2d;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: DateUtil */
public class t {
    public static String a() {
        return a(Calendar.getInstance());
    }

    public static String a(Calendar calendar) {
        return a(calendar.getTime(), "yyyy-MM-dd");
    }

    public static String a(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static double a(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return (double) ((simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime()) / 86400000);
        } catch (ParseException e) {
            e.printStackTrace();
            return -1.0d;
        }
    }
}
