package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ac;
import java.util.List;

class k {
    private static final String[] a = {"com.mi.globalbrowser", "com.android.browser"};
    private static String b = null;

    static int a(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (str.equals(context.getPackageName())) {
            applicationInfo = context.getApplicationInfo();
        } else {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                c.a("not found app info " + str);
                applicationInfo = null;
            }
        }
        if (applicationInfo == null) {
            return 0;
        }
        int i = applicationInfo.icon;
        return (i != 0 || Build.VERSION.SDK_INT < 9) ? i : applicationInfo.logo;
    }

    static String a(Notification notification) {
        Object a2;
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                str = notification.extras.getString("target_package");
            }
            return (!TextUtils.isEmpty(str) || (a2 = ac.a(notification, "extraNotification")) == null) ? str : (String) ac.a(a2, "getTargetPkg", new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void a(Notification notification, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                notification.extras.putString("target_package", str);
            }
            Object a2 = ac.a(notification, "extraNotification");
            if (a2 != null) {
                ac.a(a2, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    static void a(Context context, Intent intent) {
        String str;
        int i = -1;
        while (true) {
            str = i < 0 ? b : a[i];
            if (!TextUtils.isEmpty(str)) {
                intent.setPackage(str);
                try {
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
                    if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                        break;
                    }
                } catch (Exception e) {
                    c.a("not found xm browser:" + e);
                }
            }
            i++;
            if (i >= a.length) {
                str = null;
                break;
            }
        }
        intent.setPackage(str);
        b = str;
    }
}
