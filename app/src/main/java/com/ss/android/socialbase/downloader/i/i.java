package com.ss.android.socialbase.downloader.i;

import android.content.Context;
import android.content.pm.ServiceInfo;

/* compiled from: SystemUtils */
public class i {
    public static boolean a(Context context, String str, String str2) {
        try {
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && serviceInfo.permission == null && serviceInfo.name.equals(str2)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
