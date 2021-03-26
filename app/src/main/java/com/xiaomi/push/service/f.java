package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.List;

public class f {
    public static boolean a(Context context, ComponentName componentName) {
        try {
            new Intent().setComponent(componentName);
            context.getPackageManager().getActivityInfo(componentName, 128);
            return true;
        } catch (Exception e) {
            b.m41a("checkActivity componentName: " + componentName + ", " + e);
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
            if (serviceInfoArr == null) {
                return false;
            }
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            b.m41a("checkService " + e);
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            return queryIntentServices != null && !queryIntentServices.isEmpty();
        } catch (Exception e) {
            b.m41a("checkService action: " + str2 + ", " + e);
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        boolean z = false;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT < 19) {
                return true;
            }
            List<ProviderInfo> queryContentProviders = packageManager.queryContentProviders(null, 0, 8);
            if (queryContentProviders != null && !queryContentProviders.isEmpty()) {
                for (ProviderInfo providerInfo : queryContentProviders) {
                    if (providerInfo.enabled && providerInfo.exported && providerInfo.authority.equals(str)) {
                        z = true;
                    }
                }
            }
            return z;
        } catch (Exception e) {
            b.m41a("checkProvider " + e);
        }
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            return packageManager.resolveActivity(intent, 65536) != null;
        } catch (Exception e) {
            b.m41a("checkActivity action: " + str2 + ", " + e);
            return false;
        }
    }
}
