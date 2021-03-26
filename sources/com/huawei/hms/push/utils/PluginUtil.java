package com.huawei.hms.push.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.push.ab;
import com.huawei.hms.push.k;
import com.huawei.hms.push.l;
import com.huawei.hms.push.m;
import com.huawei.hms.push.x;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Iterator;

public class PluginUtil {
    private PluginUtil() {
    }

    public static boolean onNewToken(Context context, String str) {
        HMSLog.i("PluginUtil", "onNewToken");
        if (context == null) {
            return false;
        }
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString("message_type", "new_token");
        bundle.putString("device_token", str);
        return new l().a(context, bundle, intent);
    }

    public static boolean onDeletedMessages(Context context) {
        HMSLog.i("PluginUtil", "onDeletedMessages");
        if (context == null) {
            return false;
        }
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putInt("message_proxy_type", ProxyCenter.getInstance().getProxy().getProxyType());
        bundle.putString("message_type", "server_deleted_message");
        return new l().a(context, bundle, intent);
    }

    public static void onMessage(Context context, String[] strArr) {
        HMSLog.i("PluginUtil", "onMessage");
        if (context != null && strArr != null && strArr.length >= 5) {
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context.getApplicationContext());
            }
            if (a(context, strArr)) {
                a(context, strArr[0], strArr[3], strArr[4]);
            } else {
                b(context, strArr[0], strArr[3], strArr[4]);
            }
        }
    }

    private static void a(Context context, String str, String str2, String str3) {
        HMSLog.i("PluginUtil", "onNotification");
        if (!x.a(context)) {
            HMSLog.i("PluginUtil", context.getPackageName() + " disable display notification.");
            k.a(context, str, "103");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
        intent.putExtra("selfshow_info", str3.getBytes(ab.a));
        intent.putExtra("selfshow_token", str2.getBytes(ab.a));
        intent.setPackage(context.getPackageName());
        m.a(context, intent);
        HMSLog.i("PluginUtil", "invokeSelfShow done");
    }

    private static boolean b(Context context, String str, String str2, String str3) {
        HMSLog.i("PluginUtil", "onMessageReceived");
        if (TextUtils.isEmpty(str3)) {
            HMSLog.i("PluginUtil", "Empty message received");
            return true;
        }
        k.a(context, str, "102");
        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putString("message_id", str);
        bundle.putByteArray("message_body", str3.getBytes(ab.a));
        bundle.putString("message_type", "received_message");
        return new l().a(context, bundle, intent);
    }

    private static boolean a(Context context) {
        Iterator<ActivityManager.RunningAppProcessInfo> it2 = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (true) {
            boolean z = true;
            while (true) {
                if (!it2.hasNext()) {
                    return z;
                }
                ActivityManager.RunningAppProcessInfo next = it2.next();
                if (next.processName.equals(context.getPackageName())) {
                    if (next.importance == 100 || next.importance == 200) {
                        z = false;
                    }
                }
            }
        }
    }

    private static boolean a(Context context, String[] strArr) {
        if (!TextUtils.equals(strArr[1], "0")) {
            return false;
        }
        if (a(context) || TextUtils.equals(strArr[2], "1")) {
            return true;
        }
        return false;
    }
}
