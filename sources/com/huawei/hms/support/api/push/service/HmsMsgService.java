package com.huawei.hms.support.api.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hms.push.f;
import com.huawei.hms.push.m;
import com.huawei.hms.push.x;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Objects;

public class HmsMsgService extends Service {
    /* access modifiers changed from: private */
    public static void c(Context context, Bundle bundle) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.huawei.android.push.intent.RECEIVE");
            intent.putExtra("msg_data", f.c(bundle, "msg_data"));
            intent.putExtra("device_token", f.c(bundle, "device_token"));
            intent.putExtra("msgIdStr", f.b(bundle, "msgIdStr"));
            intent.setFlags(32);
            intent.setPackage(f.b(bundle, "push_package"));
            context.sendBroadcast(intent, context.getPackageName() + ".permission.PROCESS_PUSH_MSG");
            HMSLog.i("HmsMsgService", "send broadcast passby done");
        } catch (SecurityException unused) {
            HMSLog.i("HmsMsgService", "send broadcast SecurityException");
        } catch (Exception unused2) {
            HMSLog.i("HmsMsgService", "send broadcast Exception");
        }
    }

    /* access modifiers changed from: private */
    public static void d(Context context, Bundle bundle) {
        if (!x.a(context)) {
            HMSLog.i("HmsMsgService", context.getPackageName() + " disable display notification.");
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
        intent.putExtra("selfshow_info", f.c(bundle, "selfshow_info"));
        intent.putExtra("selfshow_token", f.c(bundle, "selfshow_token"));
        intent.setPackage(f.b(bundle, "push_package"));
        m.a(context, intent);
        HMSLog.i("HmsMsgService", "invokeSelfShow done");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        HMSLog.i("HmsMsgService", "onBind");
        Messenger messenger = new Messenger(new a(this));
        stopService(intent);
        return messenger.getBinder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        HMSLog.i("HmsMsgService", "Enter onStartCommand.");
        if (Build.VERSION.SDK_INT < 26) {
            return 2;
        }
        NotificationChannel notificationChannel = new NotificationChannel("HwPushChannelID", "pushKit", 3);
        notificationChannel.enableVibration(false);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
        Notification.Builder builder = new Notification.Builder(this, "HwPushChannelID");
        builder.setAutoCancel(true);
        startForeground(1, builder.build());
        return 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
    }

    static class a extends Handler {
        private Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            if (Build.VERSION.SDK_INT >= 21) {
                if (Objects.equals(this.a.getApplicationContext().getPackageManager().getNameForUid(message.sendingUid), HMSPackageManager.getInstance(this.a).getHMSPackageName()) && data != null) {
                    if (HMSPackageManager.getInstance(this.a).getHMSPackageStates() != PackageManagerHelper.PackageStates.ENABLED) {
                        HMSLog.i("HmsMsgService", "service not start by hms");
                    } else {
                        HMSLog.i("HmsMsgService", "chose push type");
                        if (Objects.equals(f.a(data, "push_action"), "com.huawei.push.msg.NOTIFY_MSG")) {
                            if (ResourceLoaderUtil.getmContext() == null) {
                                ResourceLoaderUtil.setmContext(this.a.getApplicationContext());
                            }
                            HMSLog.i("HmsMsgService", "invokeSelfShow");
                            HmsMsgService.d(this.a, data);
                        } else if (Objects.equals(f.a(data, "push_action"), "com.huawei.push.msg.PASSBY_MSG")) {
                            HMSLog.i("HmsMsgService", "sendBroadcastToHms");
                            HmsMsgService.c(this.a, data);
                        }
                    }
                }
                super.handleMessage(message);
            }
        }
    }
}
