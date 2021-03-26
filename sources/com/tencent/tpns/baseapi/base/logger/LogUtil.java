package com.tencent.tpns.baseapi.base.logger;

import android.content.Context;
import android.os.Environment;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: ProGuard */
public class LogUtil {
    public static String PATTERN_DATETIME_FILENAME = "yyyyMMdd_HHmm";
    private static ThreadLocal<DateFormat> a = new ThreadLocal<>();

    public static String getTodayDateTimeForFilename() {
        return new SimpleDateFormat(PATTERN_DATETIME_FILENAME).format(new Date());
    }

    public static Date parseDateInFilename(String str) {
        try {
            return new SimpleDateFormat(PATTERN_DATETIME_FILENAME).parse(str);
        } catch (Throwable th) {
            TBaseLogger.e("LogUtil", "parse filename datetime error - " + str, th);
            return null;
        }
    }

    public static boolean isDaysAgo(Date date, int i) {
        if (date == null) {
            return false;
        }
        try {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(date.getTime());
            instance.add(5, -i);
            return instance.after(instance2);
        } catch (Throwable th) {
            TBaseLogger.e("LogUtil", "action -> isDaysAgo ", th);
            return false;
        }
    }

    private static boolean a(Context context, String str) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            TBaseLogger.e("LogUtil", "checkPermission error", th);
            return false;
        }
    }

    public static boolean isSDCardMounted(Context context) {
        String externalStorageState;
        if (context == null) {
            return false;
        }
        try {
            if (!a(context, "android.permission.WRITE_EXTERNAL_STORAGE") || (externalStorageState = Environment.getExternalStorageState()) == null || !externalStorageState.equals("mounted")) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            TBaseLogger.e("LogUtil", "isSDCardMounted", th);
        }
    }

    private static DateFormat a(String str) {
        DateFormat dateFormat = a.get();
        if (dateFormat != null) {
            return dateFormat;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        a.set(simpleDateFormat);
        return simpleDateFormat;
    }

    public static String formatDate(Date date, String str) {
        try {
            return a(str).format(date);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static Date parse(String str, String str2) {
        try {
            return a(str2).parse(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
