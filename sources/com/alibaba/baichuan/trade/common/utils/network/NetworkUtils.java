package com.alibaba.baichuan.trade.common.utils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

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
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return ConnectType.CONNECT_TYPE_DISCONNECT;
        }
        int type = activeNetworkInfo.getType();
        return type != 0 ? type != 1 ? ConnectType.CONNECT_TYPE_OTHER : ConnectType.CONNECT_TYPE_WIFI : ConnectType.CONNECT_TYPE_MOBILE;
    }

    public static MobileNetworkType getMobileNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getType() != 0 || !activeNetworkInfo.isConnected()) ? MobileNetworkType.MOBILE_NETWORK_TYPE_UNKNOWN : a(activeNetworkInfo.getSubtype());
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) ? false : true;
    }
}
