package com.tencent.android.tpush.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: ProGuard */
public class d {
    public static void a(Context context, Intent intent) {
        try {
            context.sendBroadcast(intent, a(context));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            context.getApplicationContext().registerReceiver(broadcastReceiver, intentFilter, a(context), null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.getApplicationContext().unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static String a(Context context) {
        return context.getPackageName() + ".permission.XGPUSH_RECEIVE";
    }
}
