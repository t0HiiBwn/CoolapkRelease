package com.tencent.android.tpush.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.reflecttools.Reflect;
import com.tencent.tpns.reflecttools.ReflectException;

/* compiled from: ProGuard */
public class a {
    private static Boolean a;
    private static Boolean b;

    public static boolean a(Context context) {
        if (a == null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo.uid <= 1000 || (applicationInfo.flags & 1) != 0) {
                try {
                    Class.forName("com.tencent.tpns.syspush.XGSystemPush");
                    a = true;
                    TLogger.ii("SysPush", "Run As SysPush!");
                } catch (Throwable unused) {
                    a = false;
                    TLogger.ii("SysPush", "Run in sys app, but not found sys push sdk");
                    return a.booleanValue();
                }
            } else {
                a = false;
                TLogger.d("SysPush", "Run in normal app");
            }
        }
        return a.booleanValue();
    }

    public static boolean b(Context context) {
        if (b == null) {
            try {
                for (ProviderInfo providerInfo : context.getPackageManager().queryContentProviders(null, 0, 0)) {
                    if (providerInfo.name.equals("com.tencent.tpns.syspush.XGSystemPushProvider") && providerInfo.authority.equals("com.tencent.tpns.syspush.auth")) {
                        TLogger.d("SysPush", "get sys push content provider");
                        ApplicationInfo applicationInfo = providerInfo.applicationInfo;
                        if (context.getPackageName().equals(applicationInfo.packageName)) {
                            b = false;
                            TLogger.i("SysPush", "Get isUseXgSysDevice false, beacuse it is itself");
                            return b.booleanValue();
                        } else if (applicationInfo.uid <= 1000 || (applicationInfo.flags & 1) != 0) {
                            b = true;
                            TLogger.i("SysPush", "Get isUseXgSysDevice true -> uid:" + applicationInfo.uid + ", applicationInfo.flags:" + applicationInfo.flags);
                            return b.booleanValue();
                        }
                    }
                }
            } catch (Throwable th) {
                TLogger.w("SysPush", "isUseXgSysDevice Throwable ", th);
            }
            b = false;
        }
        TLogger.i("SysPush", "isUseXgSysDevice: " + b);
        return b.booleanValue();
    }

    public static boolean a(Context context, long j, String str) {
        try {
            return ((Boolean) Reflect.on("com.tencent.tpns.syspush.XGSystemPush").call("checkAccessIdAndPackage", context, Long.valueOf(j), str).get()).booleanValue();
        } catch (ReflectException unused) {
            return false;
        }
    }

    public static String a(Context context, long j) {
        try {
            return (String) Reflect.on("com.tencent.tpns.syspush.XGSystemPush").call("getAppPackage", context, Long.valueOf(j)).get();
        } catch (ReflectException unused) {
            return null;
        }
    }

    public static int a() {
        try {
            return ((Integer) Reflect.on("com.tencent.tpns.syspush.XGSystemPush").call("getPushChannelType").get()).intValue();
        } catch (ReflectException unused) {
            return -1;
        }
    }
}
