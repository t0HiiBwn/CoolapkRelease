package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import com.tencent.tpns.baseapi.core.b.b;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: ProGuard */
public class Util {
    private static PowerManager.WakeLock a = null;
    private static long b = -1;
    private static String c;

    public static boolean isNullOrEmptyString(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static void getWakeCpu(Context context) {
        if (context == null) {
            Logger.e("Util", "Util -> getWakeCpu error null context");
            return;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (a == null) {
                a = powerManager.newWakeLock(536870913, "TPNS:VIP");
                b.a().a(a);
            }
            if (!b.a().b().isHeld()) {
                b.a().b().acquire(10000);
            }
            Logger.d("Util", "get Wake Cpu ");
        } catch (Throwable th) {
            Logger.e("Util", "get Wake cpu", th);
        }
    }

    public static boolean checkPermission(Context context, String str) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            Logger.i("Util", "checkPermission error:" + str, th);
            return false;
        }
    }

    public static void stopWakeCpu() {
        try {
            PowerManager.WakeLock b2 = b.a().b();
            if (b2 != null) {
                if (b2.isHeld()) {
                    try {
                        b2.release();
                    } catch (Throwable th) {
                        Logger.e("Util", "Wakelock exception", th);
                    }
                }
                Logger.d("Util", "stop WakeLock CPU");
            }
        } catch (Throwable th2) {
            Logger.e("Util", "stopWakeLock", th2);
        }
    }

    public static long getCurVersionCode(Context context) {
        long j = b;
        if (j > 0) {
            return j;
        }
        try {
            b = (long) context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.e("Util", "getCurVersionCode error: PackageManager.NameNotFoundException", e);
            b = -1;
        }
        return b;
    }

    public static String getCurAppVersion(Context context) {
        if (!isNullOrEmptyString(c)) {
            return c;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            c = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th) {
            Logger.e("Util", "get app version error", th);
        }
        return c;
    }

    public static boolean checkAccessId(long j) {
        if (j >= 1500000000 && j < 1600000000) {
            return true;
        }
        if (j >= 1800000000 && j < 1900000000) {
            return true;
        }
        Logger.e("Util", "AccessId is Invalid!!, accessId: " + j);
        return false;
    }

    public static boolean checkAccessKey(String str) {
        if (str == null || str.length() != 12) {
            Logger.e("Util", "AccessKey is Invalid!!, accessKey: " + str);
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isUpperCase(str.charAt(i)) && !Character.isDigit(str.charAt(i))) {
                Logger.e("Util", "AccessKey is Invalid!!, accessKey: " + str);
                return false;
            }
        }
        return true;
    }

    public static String getNotifiedMsgIds(Context context, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(PushMd5Pref.getString(context, "tpush_msgId_" + j, true));
        String sb2 = sb.toString();
        if (sb2 != null && sb2.length() > 20480) {
            sb2 = sb2.substring(0, sb2.indexOf("@@", 5120));
        }
        if (sb2 != null) {
            return sb2;
        }
        return "";
    }

    public static String getThrowableToString(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String getKey(String str) {
        return Md5.md5(str);
    }
}
