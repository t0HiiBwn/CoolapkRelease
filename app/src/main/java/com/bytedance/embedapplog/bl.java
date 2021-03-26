package com.bytedance.embedapplog;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class bl {
    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            bo.a(e);
        } catch (Throwable unused) {
        }
        if (networkInfo == null && networkInfo.isAvailable()) {
            int type = networkInfo.getType();
            if (1 == type) {
                return "wifi";
            }
            if (type != 0) {
                return null;
            }
            switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    return "2g";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    return "3g";
                case 13:
                case 18:
                case 19:
                    return "4g";
                default:
                    return "mobile";
            }
        }
        networkInfo = null;
        return networkInfo == null ? null : null;
    }
}
