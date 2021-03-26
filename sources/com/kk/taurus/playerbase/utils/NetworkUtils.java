package com.kk.taurus.playerbase.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class NetworkUtils {
    public static boolean isMobile(int i) {
        return i > 1;
    }

    public static int getNetworkState(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return -1;
        }
        if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING) {
            return -2;
        }
        if (!activeNetworkInfo.isAvailable()) {
            return -1;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
            return 1;
        }
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
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
                return 3;
            case 13:
                return 4;
            default:
                return 5;
        }
    }

    public static boolean isNetConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    public static synchronized boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        int type;
        synchronized (NetworkUtils.class) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || ((type = activeNetworkInfo.getType()) != 1 && type != 9)) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        }
    }
}
