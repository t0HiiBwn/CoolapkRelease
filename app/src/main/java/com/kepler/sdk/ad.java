package com.kepler.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ad {
    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected() || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
        }
    }
}
