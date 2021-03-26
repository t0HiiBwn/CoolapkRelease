package com.pgl.sys.ces.a;

import android.content.Context;
import android.provider.Settings;
import com.pgl.sys.ces.b;
import com.pgl.sys.ces.out.ISdkInfo;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;

public class c {
    private static double a = -1.0d;

    public static String a() {
        String str;
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0011  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    public static String a(Context context) {
        String str;
        ISdkInfo e = b.e();
        if (e != null) {
            try {
                str = e.getDeviceId();
            } catch (Throwable unused) {
            }
            return str != null ? "" : str.trim();
        }
        str = "";
        if (str != null) {
        }
    }

    public static String b() {
        String str;
        try {
            ISdkInfo e = b.e();
            if (e != null) {
                str = e.getHardwareAddress();
                return "" + str;
            }
        } catch (Throwable unused) {
        }
        str = "";
        return "" + str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x000e A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0011  */
    public static String b(Context context) {
        String str;
        ISdkInfo e = b.e();
        if (e != null) {
            try {
                str = e.getSubscriberId();
            } catch (Throwable unused) {
            }
            return str != null ? "" : str.trim();
        }
        str = null;
        if (str != null) {
        }
    }

    public static String c(Context context) {
        String str;
        try {
            Locale locale = context.getResources().getConfiguration().locale;
            str = locale.getLanguage() + "_" + locale.getCountry();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    public static String d(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    public static String e(Context context) {
        int i;
        double d = a;
        double d2 = 0.0d;
        if (d >= 0.0d) {
            i = (int) d;
        } else {
            try {
                Class<?> cls = Class.forName("com.android.internal.os.PowerProfile");
                Object newInstance = cls.getConstructor(Context.class).newInstance(context);
                Method declaredMethod = cls.getDeclaredMethod("getAveragePower", String.class);
                declaredMethod.setAccessible(true);
                d2 = ((Double) declaredMethod.invoke(newInstance, "battery.capacity")).doubleValue();
            } catch (Throwable unused) {
            }
            a = d2;
            i = (int) d2;
        }
        return Integer.toString(i);
    }
}
