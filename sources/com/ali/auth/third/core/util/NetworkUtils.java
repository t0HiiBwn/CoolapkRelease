package com.ali.auth.third.core.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class NetworkUtils {
    private static MobileNetworkType a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return MobileNetworkType.MOBILE_NETWORK_TYPE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return MobileNetworkType.MOBILE_NETWORK_TYPE_3G;
            case 13:
                return MobileNetworkType.MOBILE_NETWORK_TYPE_4G;
            default:
                return MobileNetworkType.MOBILE_NETWORK_TYPE_UNKNOWN;
        }
    }

    public static ConnectType getConnectType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return ConnectType.CONNECT_TYPE_DISCONNECT;
        }
        int type = activeNetworkInfo.getType();
        return type != 0 ? type != 1 ? ConnectType.CONNECT_TYPE_OTHER : ConnectType.CONNECT_TYPE_WIFI : ConnectType.CONNECT_TYPE_MOBILE;
    }

    public static String getLocalMacAddress(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return null;
        }
        return connectionInfo.getMacAddress();
    }

    public static MobileNetworkType getMobileNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getType() != 0 || !activeNetworkInfo.isConnected()) ? MobileNetworkType.MOBILE_NETWORK_TYPE_UNKNOWN : a(activeNetworkInfo.getSubtype());
    }

    public static boolean isNetworkAvaiable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }
}
