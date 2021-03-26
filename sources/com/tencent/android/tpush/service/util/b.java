package com.tencent.android.tpush.service.util;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CloudManager;

/* compiled from: ProGuard */
public class b {
    public static boolean a(Context context) {
        try {
            if (CloudManager.getInstance(context).disableCollData()) {
                TLogger.d("NotificationsUtils", "disable notification");
                return true;
            } else if (Build.VERSION.SDK_INT >= 26) {
                TLogger.i("NotificationsUtils", "OS >= 26, return true");
                return NotificationManagerCompat.from(context).areNotificationsEnabled();
            } else {
                if (Build.VERSION.SDK_INT >= 19) {
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    String packageName = context.getApplicationContext().getPackageName();
                    int i = applicationInfo.uid;
                    Class<?> cls = Class.forName(AppOpsManager.class.getName());
                    if (((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
        } catch (Throwable th) {
            TLogger.e("NotificationsUtils", th.getMessage());
        }
    }

    public static int b(Context context) {
        try {
            if (CloudManager.getInstance(context).disableCollData()) {
                TLogger.d("NotificationsUtils", "disable notification status");
                return 4;
            } else if (Build.VERSION.SDK_INT >= 26) {
                TLogger.i("NotificationsUtils", "OS >= 26, return true");
                if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                    return 2;
                }
                return 1;
            } else {
                if (Build.VERSION.SDK_INT >= 19) {
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    String packageName = context.getApplicationContext().getPackageName();
                    int i = applicationInfo.uid;
                    Class<?> cls = Class.forName(AppOpsManager.class.getName());
                    if (((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0) {
                        return 2;
                    }
                    return 1;
                }
                return 4;
            }
        } catch (Throwable th) {
            TLogger.e("NotificationsUtils", th.getMessage());
        }
    }
}
