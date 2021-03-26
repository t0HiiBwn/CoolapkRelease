package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* compiled from: NetworkUtils */
public class x {
    public static boolean a(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!(connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null)) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static int b(Context context) {
        int c = c(context);
        if (c == 1) {
            return 0;
        }
        if (c == 4) {
            return 1;
        }
        if (c != 5) {
            return c;
        }
        return 4;
    }

    public static int c(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            if (!activeNetworkInfo.isAvailable()) {
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
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
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        return 5;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        if (TextUtils.isEmpty(subtypeName) || (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000"))) {
                            return 1;
                        }
                        return 3;
                }
            } else if (type != 1) {
                return 1;
            } else {
                return 4;
            }
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static boolean d(Context context) {
        return c(context) == 4;
    }

    public static boolean e(Context context) {
        return c(context) == 5;
    }

    public static String f(Context context) {
        int c = c(context);
        if (c == 2) {
            return "2g";
        }
        if (c == 3) {
            return "3g";
        }
        if (c != 4) {
            return c != 5 ? "mobile" : "4g";
        }
        return "wifi";
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }
}
