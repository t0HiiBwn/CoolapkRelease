package com.tencent.android.tpush;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.TPushAlarmManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.MqttChannel;
import com.tencent.tpns.mqttchannel.api.MqttConfig;

/* compiled from: ProGuard */
public class XGPushReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (context == null || intent == null || !j.h(context)) {
            Process.killProcess(Process.myPid());
            return;
        }
        String action = intent.getAction();
        if (action != null) {
            b.b(context.getApplicationContext());
            if (XGPushConfig.enableDebug) {
                TLogger.d("XGPushReceiver", "PushReceiver received " + action + " @@ " + context.getPackageName());
            }
            if ("com.tencent.android.xg.vip.action.INTERNAL_PUSH_MESSAGE".equals(action)) {
                a.b(b.e());
            } else if (!"com.tencent.android.xg.vip.action.SDK".equals(action)) {
                if ("com.tencent.android.xg.vip.action.ACTION_SDK_KEEPALIVE".equals(action)) {
                    CommonWorkingThread.getInstance().execute(new Runnable() {
                        /* class com.tencent.android.tpush.XGPushReceiver.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            XGPushReceiver.this.a(context, intent);
                        }
                    });
                    return;
                }
                TLogger.d("XGPushReceiver", "start XGService");
                b.a(context.getApplicationContext(), 3500);
                CommonWorkingThread.getInstance().execute(new Runnable() {
                    /* class com.tencent.android.tpush.XGPushReceiver.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public void run() {
                        a.b(context.getApplicationContext());
                    }
                });
            }
        }
    }

    public void a(Context context, Intent intent) {
        TLogger.d("XGPushReceiver", "ping from receiver");
        TPushAlarmManager.getAlarmManager(context).set(0, System.currentTimeMillis() + ((long) (MqttConfig.getKeepAliveInterval(context) * 1000)), PendingIntent.getBroadcast(context, 0, intent, 134217728), XGApiConfig.isPowerSaveMode(context));
        Util.getWakeCpu(context);
        MqttChannel.getInstance(context).ping(null);
    }
}
