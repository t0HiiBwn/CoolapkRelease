package com.huawei.hms.push;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Date;

/* compiled from: PushNotification */
public class s {
    private static int a;

    public static synchronized void a(Context context, o oVar) {
        int i;
        int i2;
        int i3;
        int i4;
        synchronized (s.class) {
            if (context != null && oVar != null) {
                HMSLog.d("PushSelfShowLog", " showNotification , the msg id = " + oVar.a());
                if (a == 0) {
                    a = (context.getPackageName() + new Date().toString()).hashCode();
                }
                if (TextUtils.isEmpty(oVar.e())) {
                    String t = oVar.t();
                    if (!TextUtils.isEmpty(t)) {
                        int hashCode = t.hashCode();
                        oVar.a(hashCode);
                        HMSLog.d("PushSelfShowLog", "notification msgTag = " + hashCode);
                    }
                    if (oVar.u() != -1) {
                        i4 = oVar.u();
                        i3 = a + 1;
                        a = i3;
                        i2 = i3 + 1;
                        a = i2;
                        i = i2 + 1;
                        a = i;
                    } else {
                        i4 = a + 1;
                        a = i4;
                        i3 = i4 + 1;
                        a = i3;
                        i2 = i3 + 1;
                        a = i2;
                        i = i2 + 1;
                        a = i;
                    }
                } else {
                    i4 = (oVar.i() + oVar.e()).hashCode();
                    i3 = a + 1;
                    a = i3;
                    i2 = i3 + 1;
                    a = i2;
                    i = i2 + 1;
                    a = i;
                }
                HMSLog.d("PushSelfShowLog", "notifyId:" + i4 + ",openNotifyId:" + i3 + ",delNotifyId:" + i2 + ",alarmNotifyId:" + i);
                Notification notification = null;
                if (u.a()) {
                    notification = a(context, oVar, i4, i3, i2);
                }
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (!(notificationManager == null || notification == null)) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        notificationManager.createNotificationChannel(new NotificationChannel("HwPushChannelID", context.getString(ResourceLoaderUtil.getStringId("hms_push_channel")), 3));
                    }
                    notificationManager.notify(i4, notification);
                    c(context, oVar, i4, i);
                    k.a(context, "100", String.valueOf(i4), oVar);
                }
            }
        }
    }

    private static PendingIntent a(Context context, o oVar, int i, int i2) {
        return PendingIntent.getBroadcast(context, i2, a(context, oVar, i, "1", 268435456), 134217728);
    }

    private static PendingIntent b(Context context, o oVar, int i, int i2) {
        return PendingIntent.getBroadcast(context, i2, a(context, oVar, i, "2", 268435456), 134217728);
    }

    private static Intent a(Context context, o oVar, int i, String str, int i2) {
        Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        intent.putExtra("selfshow_info", oVar.c()).putExtra("selfshow_token", oVar.d()).putExtra("selfshow_event_id", str).putExtra("selfshow_notify_id", i).setPackage(context.getPackageName()).setFlags(i2);
        return intent;
    }

    private static Notification a(Context context, o oVar, int i, int i2, int i3) {
        Notification.Builder builder = new Notification.Builder(context);
        if (q.a(oVar) == r.STYLE_BIGTEXT) {
            q.a(builder, oVar.r(), oVar);
        }
        p.a(context, builder, oVar);
        a(oVar, builder);
        a(context, oVar, builder);
        b(context, oVar, builder);
        a(builder);
        b(oVar, builder);
        c(oVar, builder);
        builder.setContentIntent(a(context, oVar, i, i2));
        builder.setDeleteIntent(b(context, oVar, i, i3));
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("HwPushChannelID");
        }
        a(context, builder, oVar);
        b(context, builder, oVar);
        return builder.build();
    }

    private static void a(Context context, Notification.Builder builder, o oVar) {
        if ("com.huawei.android.pushagent".equals(context.getPackageName())) {
            Bundle bundle = new Bundle();
            String i = oVar.i();
            if (!TextUtils.isEmpty(i)) {
                bundle.putString("hw_origin_sender_package_name", i);
                builder.setExtras(bundle);
            }
        }
    }

    private static void b(Context context, Notification.Builder builder, o oVar) {
        if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11 && u.a(context)) {
            Bundle bundle = new Bundle();
            String i = oVar.i();
            HMSLog.i("PushSelfShowLog", "the package name of notification is:" + i);
            if (!TextUtils.isEmpty(i)) {
                String a2 = u.a(context, i);
                HMSLog.i("PushSelfShowLog", "the app name is:" + a2);
                if (a2 != null) {
                    bundle.putCharSequence("android.extraAppName", a2);
                }
            }
            builder.setExtras(bundle);
        }
    }

    public static void a(Context context, Intent intent, long j, int i) {
        try {
            HMSLog.d("PushSelfShowLog", "enter setDelayAlarm(intent:" + intent.toURI() + " interval:" + j + "ms, context:" + context);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager != null) {
                alarmManager.set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, i, intent, 134217728));
            }
        } catch (Exception e) {
            HMSLog.w("PushSelfShowLog", "set DelayAlarm error" + e.toString());
        }
    }

    private static void c(Context context, o oVar, int i, int i2) {
        HMSLog.i("PushSelfShowLog", "setAutoClear time is: " + oVar.f());
        if (oVar.f() > 0) {
            a(context, a(context, oVar, i, "-1", 32), (long) oVar.f(), i2);
        }
    }

    private static void a(o oVar, Notification.Builder builder) {
        String p = oVar.p();
        if (!TextUtils.isEmpty(p)) {
            builder.setSubText(p);
        }
    }

    private static void a(Context context, o oVar, Notification.Builder builder) {
        String str;
        if (TextUtils.isEmpty(oVar.l())) {
            str = context.getResources().getString(context.getApplicationInfo().labelRes);
        } else {
            str = oVar.l();
        }
        String k = oVar.k();
        builder.setContentTitle(str);
        builder.setContentText(k);
    }

    private static void b(Context context, o oVar, Notification.Builder builder) {
        Bitmap a2 = p.a(context, oVar);
        if (a2 != null) {
            builder.setLargeIcon(a2);
        }
    }

    private static void a(Notification.Builder builder) {
        builder.setShowWhen(true);
        builder.setWhen(System.currentTimeMillis());
    }

    private static void b(o oVar, Notification.Builder builder) {
        boolean z = true;
        if (oVar.s() != 1) {
            z = false;
        }
        builder.setAutoCancel(z);
        builder.setOngoing(false);
    }

    private static void c(o oVar, Notification.Builder builder) {
        builder.setTicker(oVar.v());
    }
}
