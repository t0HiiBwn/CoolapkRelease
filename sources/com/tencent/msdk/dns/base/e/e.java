package com.tencent.msdk.dns.base.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

/* compiled from: NetworkUtils */
public final class e {
    public static String a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "unknown" : "ethernet" : "wifi" : "4G" : "3G" : "2G";
    }

    public static String a(Context context) {
        return a(b(context));
    }

    public static int b(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return 0;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                return a(activeNetworkInfo);
            }
            if (type == 1) {
                return 4;
            }
            if (type != 9) {
                return 0;
            }
            return 5;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String c(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        if (context == null || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        return connectionInfo.getSSID();
    }

    private static int a(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return 0;
        }
        switch (networkInfo.getSubtype()) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 1;
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
                return 2;
            case 13:
            default:
                return 3;
        }
    }
}
