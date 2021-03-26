package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;

public abstract class a {
    public static void a(Context context, BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null && context != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e) {
                com.huawei.updatesdk.a.a.b.a.a.a.d("ActivityUtil", "unregisterReceiver error:" + e.toString());
            }
        }
    }

    public static void a(Context context, IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        if (intentFilter != null && broadcastReceiver != null && !a(context)) {
            try {
                context.registerReceiver(broadcastReceiver, intentFilter);
            } catch (IllegalArgumentException e) {
                com.huawei.updatesdk.a.a.b.a.a.a.d("ActivityUtil", "registerReceiver error:" + e.toString());
            }
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return true;
        }
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        if (!activity.isFinishing() && (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed())) {
            return false;
        }
        com.huawei.updatesdk.a.a.b.a.a.a.d("ActivityUtil", "activity has bean finished, cannot instance:" + activity);
        return true;
    }
}
