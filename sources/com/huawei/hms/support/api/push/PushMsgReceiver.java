package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.push.m;
import com.huawei.hms.push.x;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class PushMsgReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && context != null) {
            HMSLog.i("PushMsgReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
            try {
                intent.getStringExtra("TestIntent");
                String action = intent.getAction();
                if (ResourceLoaderUtil.getmContext() == null) {
                    ResourceLoaderUtil.setmContext(context.getApplicationContext());
                }
                if ("com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action) || ("com.huawei.intent.action.PUSH".equals(action) && HwBuildEx.VERSION.EMUI_SDK_INT < 10)) {
                    a(context, intent);
                    return;
                }
                HMSLog.i("PushMsgReceiver", "message can't be recognised:" + intent.toUri(0));
            } catch (Exception unused) {
                HMSLog.e("PushMsgReceiver", "intent has some error");
            }
        }
    }

    private static void a(Context context, Intent intent) {
        if (intent.hasExtra("selfshow_info")) {
            if (!x.a(context)) {
                HMSLog.i("PushMsgReceiver", context.getPackageName() + " disable display notification.");
            }
            m.a(context, intent);
        }
    }
}
