package com.huawei.hms.push;

import android.content.Context;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: TokenUtil */
public class j {
    public static a a(Context context) {
        if (b(context)) {
            return a.SUCCESS;
        }
        if (AutoInitHelper.isAutoInitEnabled(context)) {
            HMSLog.e("TokenUtil", "Token not exist, try auto init");
            AutoInitHelper.doAutoInit(context);
            return a.ERROR_AUTO_INITIALIZING;
        }
        HMSLog.e("TokenUtil", "Token not exist");
        return a.ERROR_NO_TOKEN;
    }

    private static boolean b(Context context) {
        return new ac(context, "push_client_self_info").c("token_info_v2");
    }
}
