package com.kepler.sdk;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.net.URLEncoder;

public class v {
    public static String a(Context context) {
        try {
            return ((TelephonyManager) w.a(context.getSystemService("phone"))).getDeviceId();
        } catch (Throwable unused) {
            return "Imei_null";
        }
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            return "version_null";
        }
    }

    public static String a() {
        try {
            return URLEncoder.encode(Build.MODEL, "UTF-8");
        } catch (Throwable unused) {
            return "model_null";
        }
    }

    public static String b() {
        try {
            return URLEncoder.encode(Build.MANUFACTURER, "UTF-8");
        } catch (Throwable unused) {
            return "manufacturer_null";
        }
    }
}
