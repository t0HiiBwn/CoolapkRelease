package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: ProGuard */
public class NetworkUtil {
    public static final String TAG = "NetworkUtil";

    public static boolean isNetworkConnected(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Throwable th) {
            Logger.i("NetworkUtil", th.getMessage());
            return false;
        }
    }
}
