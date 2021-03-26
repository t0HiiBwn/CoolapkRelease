package com.tencent.android.tpush.common;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class g {
    private static final String[] a = {"android.permission.INTERNET", "android.permission.ACCESS_WIFI_STATE", "android.permission.ACCESS_NETWORK_STATE"};
    private static Map<String, Boolean> b = new HashMap(8);

    private static Context b() {
        if (XGPushManager.getContext() != null) {
            return XGPushManager.getContext();
        }
        return b.e();
    }

    public static boolean a() {
        Context b2 = b();
        if (b2 != null) {
            try {
                PackageManager packageManager = b2.getPackageManager();
                if (packageManager == null) {
                    return true;
                }
                String[] strArr = packageManager.getPackageInfo(b2.getPackageName(), 4096).requestedPermissions;
                if (strArr == null) {
                    return false;
                }
                String[] strArr2 = a;
                for (String str : strArr2) {
                    boolean a2 = a(strArr, str);
                    b.put(str, Boolean.valueOf(a2));
                    if (!a2) {
                        TLogger.ee("PermissionChecker", "The required permission of <" + str + "> does not found!");
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                TLogger.e("PermissionChecker", "check required permissins exception.", th);
                return false;
            }
        } else {
            throw new IllegalArgumentException("The context parameter can not be null!");
        }
    }

    private static boolean a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
