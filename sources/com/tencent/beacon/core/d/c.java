package com.tencent.beacon.core.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: NetStateUtil */
public final class c {
    private static NetworkInfo d(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public static boolean a(Context context) {
        NetworkInfo d = d(context);
        return d != null && d.getType() == 1;
    }

    public static boolean b(Context context) {
        NetworkInfo d = d(context);
        return d != null && d.isConnected();
    }

    public static String c(Context context) {
        NetworkInfo d = d(context);
        if (d == null) {
            return "unknown";
        }
        if (d.getType() == 1) {
            return "wifi";
        }
        String extraInfo = d.getExtraInfo();
        return (extraInfo == null || extraInfo.length() <= 64) ? extraInfo : extraInfo.substring(0, 64);
    }
}
