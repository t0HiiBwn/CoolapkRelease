package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.opendevice.g;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;

public class AutoInitHelper {
    public static boolean isAutoInitEnabled(Context context) {
        q qVar = new q(context, "push_client_self_info");
        if (qVar.d("push_kit_auto_init_enabled")) {
            return qVar.a("push_kit_auto_init_enabled");
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("push_kit_auto_init_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void doAutoInit(Context context) {
        try {
            if (isAutoInitEnabled(context)) {
                HMSLog.i("AutoInit", "Push init start");
                new Thread(new g(context)).start();
            }
        } catch (Exception e) {
            HMSLog.e("AutoInit", "Push init failed", e);
        }
    }

    public static void setAutoInitEnabled(Context context, boolean z) {
        q qVar = new q(context, "push_client_self_info");
        boolean a = qVar.a("push_kit_auto_init_enabled");
        qVar.a("push_kit_auto_init_enabled", z);
        if (z && !a) {
            doAutoInit(context);
        }
    }
}
