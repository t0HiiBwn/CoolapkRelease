package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bd;
import com.xiaomi.push.g;

public class am {
    private static String a = null;

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f954a = {"com.mi.globalbrowser", "com.android.browser"};

    public static int a(ContentResolver contentResolver) {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
            } catch (Exception e) {
                b.m41a("get user aggregate failed, " + e);
            }
        }
        return 0;
    }

    static int a(Context context, String str) {
        return g.b(context, str);
    }

    public static String a(Notification notification) {
        Object a2;
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                str = notification.extras.getString("target_package");
            }
            return (!TextUtils.isEmpty(str) || (a2 = bd.a(notification, "extraNotification")) == null) ? str : (String) bd.a(a2, "getTargetPkg", new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void a(Notification notification, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                notification.extras.putString("target_package", str);
            }
            Object a2 = bd.a(notification, "extraNotification");
            if (a2 != null) {
                bd.a(a2, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    static void a(Context context, Intent intent) {
        String str;
        int i = -1;
        while (true) {
            str = i < 0 ? a : f954a[i];
            if (!TextUtils.isEmpty(str)) {
                intent.setPackage(str);
                try {
                    if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                        break;
                    }
                } catch (Exception e) {
                    b.m41a("not found xm browser:" + e);
                }
            }
            i++;
            if (i >= f954a.length) {
                str = null;
                break;
            }
        }
        intent.setPackage(str);
        a = str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m622a(ContentResolver contentResolver) {
        int a2 = a(contentResolver);
        return a2 == 1 || a2 == 2;
    }
}
