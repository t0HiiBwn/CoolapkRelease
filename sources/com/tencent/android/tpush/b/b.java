package com.tencent.android.tpush.b;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.tencent.android.tpush.NotificationAction;
import com.tencent.android.tpush.TpnsActivity;
import com.tencent.android.tpush.XGBasicPushNotificationBuilder;
import com.tencent.android.tpush.XGCustomPushNotificationBuilder;
import com.tencent.android.tpush.XGNotifaction;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.XGPushNotifactionCallback;
import com.tencent.android.tpush.XGPushNotificationBuilder;
import com.tencent.android.tpush.XGSysNotifaction;
import com.tencent.android.tpush.XGSysPushNotifactionCallback;
import com.tencent.android.tpush.b.e;
import com.tencent.android.tpush.common.d;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.f.a;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class b {
    private static volatile BroadcastReceiver a;
    private static volatile BroadcastReceiver b;
    private static MediaPlayer c;

    private static String a(int i) {
        return "TPUSH_NOTIF_BUILDID_" + String.valueOf(i);
    }

    public static synchronized XGPushNotificationBuilder a(Context context) {
        XGPushNotificationBuilder flags;
        synchronized (b.class) {
            flags = new XGBasicPushNotificationBuilder().setFlags(16);
        }
        return flags;
    }

    public static void a(Context context, int i, XGPushNotificationBuilder xGPushNotificationBuilder) {
        String a2 = a(i);
        JSONObject jSONObject = new JSONObject();
        xGPushNotificationBuilder.encode(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        CommonHelper.jsonPut(jSONObject2, xGPushNotificationBuilder.getType(), jSONObject.toString());
        PushPreferences.putString(context, a2, jSONObject2.toString());
    }

    public static XGPushNotificationBuilder a(Context context, int i) {
        JSONException e;
        XGPushNotificationBuilder xGCustomPushNotificationBuilder;
        String string;
        XGPushNotificationBuilder xGPushNotificationBuilder = null;
        if (context == null) {
            return null;
        }
        String string2 = PushPreferences.getString(context, a(i), null);
        if (string2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(string2);
                if (jSONObject.has("basic")) {
                    xGCustomPushNotificationBuilder = new XGBasicPushNotificationBuilder();
                    try {
                        string = jSONObject.getString("basic");
                    } catch (JSONException e2) {
                        e = e2;
                        xGPushNotificationBuilder = xGCustomPushNotificationBuilder;
                        TLogger.e("MessageHelper", "unexpected for getNotificationBuilder", e);
                        return xGPushNotificationBuilder;
                    }
                } else if (!jSONObject.has("custom")) {
                    return null;
                } else {
                    xGCustomPushNotificationBuilder = new XGCustomPushNotificationBuilder();
                    string = jSONObject.getString("custom");
                }
                xGPushNotificationBuilder = xGCustomPushNotificationBuilder;
                xGPushNotificationBuilder.decode(string);
            } catch (JSONException e3) {
                e = e3;
                TLogger.e("MessageHelper", "unexpected for getNotificationBuilder", e);
                return xGPushNotificationBuilder;
            }
        } else {
            TLogger.i("MessageHelper", "PushNotificationBuilder not found :" + i);
        }
        return xGPushNotificationBuilder;
    }

    public static String b(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                if (resolveInfo.activityInfo != null) {
                    return resolveInfo.activityInfo.name;
                }
            }
        } catch (Throwable th) {
            TLogger.e("MessageHelper", "get Activity error", th);
        }
        return null;
    }

    public static Intent a(Context context, e.a aVar, boolean z, g gVar, boolean z2) {
        NotificationAction notificationAction = NotificationAction.getNotificationAction(aVar.a);
        Intent intent = null;
        if (notificationAction == null) {
            return null;
        }
        int i = AnonymousClass3.a[notificationAction.ordinal()];
        if (i == 1) {
            intent = new Intent("com.tencent.android.xg.vip.action.INTERNAL_PUSH_MESSAGE");
            String str = aVar.b;
            if (j.b(str)) {
                str = b(context);
            }
            int i2 = 538968064;
            if (aVar.c == null || aVar.c.a <= 0) {
                if (z) {
                    i2 = 268435456;
                }
                intent.addFlags(i2);
                intent.setFlags(67239936);
            } else {
                intent.setFlags(aVar.c.a);
            }
            intent.putExtra("activity", str);
            intent.putExtra("notificationActionType", NotificationAction.activity.getType());
            intent.putExtra("action_type", NotificationAction.activity.getType());
            intent.putExtra("PUSH.CHANNEL", gVar.a);
            intent.setClass(context, TpnsActivity.class);
        } else if (i == 2) {
            intent = new Intent("com.tencent.android.xg.vip.action.INTERNAL_PUSH_MESSAGE");
            intent.putExtra("activity", aVar.f);
            intent.putExtra("action_type", aVar.a);
            intent.putExtra("notificationActionType", NotificationAction.url.getType());
            intent.putExtra("PUSH.CHANNEL", gVar.a);
            intent.setClass(context, TpnsActivity.class);
        } else if (i == 3 || i == 4) {
            intent = new Intent("com.tencent.android.xg.vip.action.INTERNAL_PUSH_MESSAGE");
            intent.putExtra("activity", aVar.d);
            intent.putExtra("action_type", aVar.a);
            if (aVar.a == NotificationAction.intent_with_action.getType()) {
                intent.putExtra("notificationActionType", NotificationAction.intent_with_action.getType());
            } else {
                intent.putExtra("notificationActionType", NotificationAction.intent.getType());
            }
            intent.putExtra("PUSH.CHANNEL", gVar.a);
            intent.setClass(context, TpnsActivity.class);
        } else if (i != 5) {
            TLogger.e("MessageHelper", "getIntentByOpenType unknown action_type: " + aVar.a);
        } else {
            intent = new Intent("com.tencent.android.xg.vip.action.INTERNAL_PUSH_MESSAGE");
            String str2 = aVar.h;
            if (j.b(str2)) {
                return intent;
            }
            intent.putExtra("action_type", aVar.a);
            intent.putExtra("packageDownloadUrl", aVar.j);
            intent.putExtra("packageName", str2);
            intent.putExtra("activity", str2);
            intent.putExtra("notificationActionType", NotificationAction.action_package.getType());
            intent.putExtra("PUSH.CHANNEL", gVar.a);
            intent.setClass(context, TpnsActivity.class);
        }
        if (intent != null) {
            intent.putExtra("action_confirm", aVar.g);
            intent.putExtra("msgId", gVar.b());
            intent.putExtra("busiMsgId", gVar.d());
            intent.putExtra("pushTime", gVar.b);
            intent.putExtra("pushChannel", gVar.a);
            intent.putExtra("groupId", gVar.g());
            intent.putExtra("targetType", gVar.j());
            intent.putExtra("source", gVar.k());
        }
        if (intent != null && z2) {
            if (aVar.c == null || aVar.c.a <= 0) {
                intent.setFlags(67239936);
            } else {
                intent.setFlags(aVar.c.a);
            }
        }
        return intent;
    }

    /* renamed from: com.tencent.android.tpush.b.b$3  reason: invalid class name */
    /* compiled from: ProGuard */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NotificationAction.values().length];
            a = iArr;
            try {
                iArr[NotificationAction.activity.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NotificationAction.url.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[NotificationAction.intent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[NotificationAction.intent_with_action.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[NotificationAction.action_package.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a(Context context, Context context2, g gVar) {
        boolean z;
        Context context3;
        boolean z2;
        g gVar2;
        int i;
        Intent intent;
        Notification notification;
        Throwable th;
        if (context2 == null) {
            context3 = context;
            z = false;
        } else {
            context3 = context2;
            z = true;
        }
        e eVar = (e) gVar.m();
        e.a l = eVar.l();
        XGPushNotificationBuilder a2 = a(context, eVar.g());
        if (a2 == null || eVar.u() == 1) {
            a2 = b(context, eVar, a2);
        }
        a(context, eVar, a2);
        String f = eVar.f();
        if (j.b(f) || "{}".equalsIgnoreCase(f)) {
            gVar2 = gVar;
            z2 = false;
        } else {
            gVar2 = gVar;
            z2 = true;
        }
        Intent a3 = a(context, l, z2, gVar2, z);
        if (a3 == null) {
            TLogger.e("MessageHelper", "unexpected action intent null, Action -> showNotification terminate");
            return;
        }
        if (z2) {
            a3.putExtra("custom_content", eVar.f());
        }
        a3.putExtra("tag.tpush.MSG", "true");
        a3.putExtra("title", Rijndael.encrypt(eVar.d()));
        a3.putExtra("content", Rijndael.encrypt(eVar.e()));
        if (eVar.f() != null) {
            a3.putExtra("custom_content", Rijndael.encrypt(eVar.f()));
        }
        a3.putExtra("msgId", gVar.b());
        a3.putExtra("accId", gVar.c());
        a3.putExtra("busiMsgId", gVar.d());
        a3.putExtra("timestamps", gVar.e());
        a3.putExtra("group_id", gVar.g());
        a3.putExtra("templateId", gVar.h());
        a3.putExtra("traceId", gVar.i());
        a3.putExtra("protect", Rijndael.encrypt("" + (System.currentTimeMillis() - 1000)));
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        int k = eVar.k();
        if (k == -1) {
            notificationManager.cancelAll();
        }
        if (k <= 0) {
            k = b(context, eVar.g());
        }
        a3.putExtra("notifaction_id", k);
        int i2 = (l.c == null || l.c.b <= 0) ? 134217728 : l.c.b;
        if (a == null) {
            a = new BroadcastReceiver() {
                /* class com.tencent.android.tpush.b.b.AnonymousClass1 */

                @Override // android.content.BroadcastReceiver
                public void onReceive(final Context context, final Intent intent) {
                    final String stringExtra = intent.getStringExtra("packName");
                    TLogger.ii("MessageHelper", "onReceive: Notification has canceled! pkg name: " + stringExtra);
                    if (a.a(context.getApplicationContext()) || (!j.b(stringExtra) && stringExtra.equals(context.getPackageName()))) {
                        CommonWorkingThread.getInstance().execute(new Runnable() {
                            /* class com.tencent.android.tpush.b.b.AnonymousClass1.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                c.a().f(context, intent.getLongExtra("msgId", -1));
                                Intent intent = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
                                intent.setPackage(stringExtra);
                                intent.putExtras(intent);
                                intent.putExtra("TPUSH.FEEDBACK", 4);
                                d.a(context, intent);
                                Intent intent2 = new Intent("com.tencent.android.xg.vip.action.PUSH_CANCELLED.RESULT.V4");
                                intent2.putExtras(intent);
                                intent2.putExtra("clickTime", System.currentTimeMillis() / 1000);
                                ServiceStat.appReportNotificationCleared(context, intent2);
                                d.a(context, intent2);
                            }
                        });
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(context3.getPackageName() + ".APP_PUSH_CANCELLED.RESULT");
            d.a(context3, a, intentFilter);
        }
        Intent intent2 = new Intent(context3.getPackageName() + ".APP_PUSH_CANCELLED.RESULT");
        intent2.setPackage(context3.getPackageName());
        intent2.putExtra("packName", context.getPackageName());
        intent2.putExtra("action", NotificationAction.delete.getType());
        intent2.putExtras(a3);
        if (Build.VERSION.SDK_INT == 19) {
            PendingIntent.getActivity(context, k, a3, i2).cancel();
        }
        if (!z) {
            a2.setContentIntent(PendingIntent.getActivity(context, k, a3, i2));
        } else if (Build.VERSION.SDK_INT >= 26) {
            a2.setRunAsSysAndAndBuildSdk26(true);
        }
        if (b == null) {
            b = new BroadcastReceiver() {
                /* class com.tencent.android.tpush.b.b.AnonymousClass2 */

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    if (action != null) {
                        String stringExtra = intent.getStringExtra("xg_media_audio_resources");
                        if (!action.equals(context.getPackageName() + ".APP_PUSH_MEDIA.PLAY") || TextUtils.isEmpty(stringExtra)) {
                            if (action.equals(context.getPackageName() + ".APP_PUSH_MEDIA.STOP")) {
                                try {
                                    if (b.c != null) {
                                        b.c.stop();
                                        b.c.release();
                                        MediaPlayer unused = b.c = null;
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        } else {
                            try {
                                if (b.c == null) {
                                    MediaPlayer unused2 = b.c = new MediaPlayer();
                                    b.c.setAudioStreamType(3);
                                }
                                b.c.reset();
                                b.c.setDataSource(stringExtra);
                                b.c.prepare();
                                b.c.start();
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                            } catch (IllegalStateException e2) {
                                e2.printStackTrace();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
            };
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction(context.getPackageName() + ".APP_PUSH_MEDIA.PLAY");
            intentFilter2.addAction(context.getPackageName() + ".APP_PUSH_MEDIA.STOP");
            d.a(context, b, intentFilter2);
        }
        a(context, gVar, eVar, a2, k, i2);
        Pair<Notification, Object> buildNotification = a2.buildNotification(context);
        Notification notification2 = (Notification) buildNotification.first;
        Object obj = buildNotification.second;
        notification2.deleteIntent = PendingIntent.getBroadcast(context3, k, intent2, i2);
        boolean z3 = eVar.x() == 1 && a(context3, context.getPackageName());
        TLogger.d("MessageHelper", "is_show_type:" + eVar.x() + ", OnForeground:" + a(context3, context.getPackageName()));
        if (z) {
            XGSysPushNotifactionCallback sysNotifactionCallback = XGPushManager.getSysNotifactionCallback();
            if (sysNotifactionCallback == null) {
                TLogger.ee("MessageHelper", "XG Sys Push init Error, no notifactionCallback!");
                return;
            } else if (z3) {
                TLogger.d("MessageHelper", "appOnForeground ");
                intent = a3;
                i = k;
            } else {
                intent = a3;
                i = k;
                sysNotifactionCallback.handleNotify(new XGSysNotifaction(context.getPackageName(), k, notification2, intent, i2, obj));
            }
        } else {
            intent = a3;
            i = k;
            XGPushNotifactionCallback notifactionCallback = XGPushManager.getNotifactionCallback();
            if (obj != null) {
                XGPushNotificationBuilder.createNotificationChannel(context, obj);
            }
            if (z3) {
                TLogger.d("MessageHelper", "appOnForeground ");
            } else if (notifactionCallback == null) {
                int y = eVar.y();
                if (y == -2) {
                    XGPushConfig.changeHuaweiBadgeNum(context, 1);
                } else if (y >= 0) {
                    XGPushConfig.setBadgeNum(context, y);
                }
                try {
                    String z4 = eVar.z();
                    if (TextUtils.isEmpty(z4) || Build.VERSION.SDK_INT < 24) {
                        notification = notification2;
                        notificationManager.notify(i, notification);
                    } else {
                        notification = notification2;
                        try {
                            notificationManager.notify(-z4.hashCode(), a(context, a2.getCurrentChannelId(), z4, eVar.A(), a2.getSmallIcon().intValue(), eVar.B()));
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        notificationManager.notify(i, notification);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    notification = notification2;
                    TLogger.e("MessageHelper", "show group notification error: " + th.toString());
                    notificationManager.notify(i, notification);
                    Intent intent3 = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
                    intent3.putExtra("TPUSH.ERRORCODE", 0);
                    intent3.setPackage(context.getPackageName());
                    intent3.putExtras(intent);
                    intent3.putExtra("TPUSH.FEEDBACK", 5);
                    intent3.putExtra("notifaction_id", i);
                    d.a(context, intent3);
                }
            } else {
                TLogger.i("MessageHelper", "call notifactionCallback:" + notification2);
                notifactionCallback.handleNotify(new XGNotifaction(context, i, notification2, eVar));
                TLogger.d("MessageHelper", "not appOnForeground ");
            }
        }
        Intent intent3 = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
        intent3.putExtra("TPUSH.ERRORCODE", 0);
        intent3.setPackage(context.getPackageName());
        intent3.putExtras(intent);
        intent3.putExtra("TPUSH.FEEDBACK", 5);
        intent3.putExtra("notifaction_id", i);
        d.a(context, intent3);
    }

    private static void a(Context context, g gVar, e eVar, XGPushNotificationBuilder xGPushNotificationBuilder, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            int identifier = context.getResources().getIdentifier("xg_notification", "layout", context.getPackageName());
            if (identifier != 0) {
                TLogger.d("MessageHelper", "has xg_notification layout");
                int identifier2 = context.getResources().getIdentifier("xg_notification_icon", "id", context.getPackageName());
                int identifier3 = context.getResources().getIdentifier("xg_notification_style_title", "id", context.getPackageName());
                int identifier4 = context.getResources().getIdentifier("xg_notification_date", "id", context.getPackageName());
                int identifier5 = context.getResources().getIdentifier("xg_notification_style_content", "id", context.getPackageName());
                int identifier6 = context.getResources().getIdentifier("xg_notification_audio_play", "id", context.getPackageName());
                int identifier7 = context.getResources().getIdentifier("xg_notification_audio_stop", "id", context.getPackageName());
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), identifier);
                if (!(identifier2 == 0 || identifier3 == 0 || identifier5 == 0)) {
                    remoteViews.setTextViewText(identifier3, eVar.d());
                    remoteViews.setTextViewText(identifier5, eVar.e());
                    if (!TextUtils.isEmpty(eVar.r())) {
                        Bitmap a2 = a(eVar.r());
                        if (a2 == null) {
                            remoteViews.setImageViewResource(identifier2, context.getApplicationInfo().icon);
                        } else {
                            remoteViews.setImageViewBitmap(identifier2, a2);
                        }
                    } else {
                        remoteViews.setImageViewResource(identifier2, context.getApplicationInfo().icon);
                    }
                }
                if (identifier4 != 0) {
                    remoteViews.setTextViewText(identifier4, String.valueOf(new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis()))));
                }
                if (!(identifier6 == 0 || identifier7 == 0 || TextUtils.isEmpty(eVar.o()))) {
                    remoteViews.setViewVisibility(identifier6, 0);
                    remoteViews.setViewVisibility(identifier7, 0);
                    Intent intent = new Intent(context.getPackageName() + ".APP_PUSH_MEDIA.PLAY");
                    intent.putExtra("msgId", gVar.b());
                    intent.putExtra("xg_media_audio_resources", eVar.o());
                    intent.putExtra("packName", context.getPackageName());
                    remoteViews.setOnClickPendingIntent(identifier6, PendingIntent.getBroadcast(context, i, intent, i2));
                    Intent intent2 = new Intent(context.getPackageName() + ".APP_PUSH_MEDIA.STOP");
                    intent2.putExtra("msgId", gVar.b());
                    intent2.putExtra("xg_media_audio_resources", eVar.o());
                    intent2.putExtra("packName", context.getPackageName());
                    remoteViews.setOnClickPendingIntent(identifier7, PendingIntent.getBroadcast(context, i, intent2, i2));
                }
                xGPushNotificationBuilder.setContentView(remoteViews);
                return;
            }
            TLogger.d("MessageHelper", "no xg_notification layout");
        }
    }

    private static void a(Context context, e eVar, XGPushNotificationBuilder xGPushNotificationBuilder) {
        Bitmap a2;
        if (eVar.m() > 0) {
            xGPushNotificationBuilder.setIcon(Integer.valueOf(eVar.m()));
        }
        if (!(eVar.n() == null || TextUtils.isEmpty(eVar.n()) || (a2 = a(eVar.n())) == null)) {
            xGPushNotificationBuilder.setRichIcon(a2);
        }
        if (xGPushNotificationBuilder.getSmallIcon() == null && xGPushNotificationBuilder.getLargeIcon() == null && xGPushNotificationBuilder.getIcon() == null) {
            int identifier = context.getResources().getIdentifier("notification_icon", "drawable", context.getPackageName());
            if (identifier > 0) {
                xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(identifier));
            } else {
                xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(context.getApplicationInfo().icon));
            }
            xGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), context.getApplicationInfo().icon));
        }
        xGPushNotificationBuilder.setTitle(eVar.d());
        xGPushNotificationBuilder.setTickerText(eVar.e());
        String v = eVar.v();
        if (!TextUtils.isEmpty(v)) {
            xGPushNotificationBuilder.setChannelId(v);
        }
        if (!TextUtils.isEmpty(eVar.w())) {
            xGPushNotificationBuilder.setChannelName(eVar.w());
        }
        if (!TextUtils.isEmpty(eVar.z())) {
            xGPushNotificationBuilder.setThread_id(eVar.z());
        }
    }

    private static XGPushNotificationBuilder b(Context context, e eVar, XGPushNotificationBuilder xGPushNotificationBuilder) {
        if (xGPushNotificationBuilder == null) {
            xGPushNotificationBuilder = XGPushManager.getDefaultNotificationBuilder(context);
        }
        if (xGPushNotificationBuilder == null) {
            xGPushNotificationBuilder = a(context);
        }
        if (eVar.j() != 0) {
            xGPushNotificationBuilder.setFlags(16);
        }
        if (eVar.h() != 0) {
            if (!TextUtils.isEmpty(eVar.q())) {
                int identifier = context.getResources().getIdentifier(eVar.q(), "raw", context.getPackageName());
                if (identifier > 0) {
                    xGPushNotificationBuilder.setSound(Uri.parse("android.resource://" + context.getPackageName() + "/" + identifier));
                } else {
                    xGPushNotificationBuilder.setDefaults(1);
                }
            } else {
                xGPushNotificationBuilder.setDefaults(1);
            }
        }
        if (eVar.i() != 0) {
            xGPushNotificationBuilder.setDefaults(2);
        }
        if (eVar.p() != 0) {
            xGPushNotificationBuilder.setDefaults(4);
            xGPushNotificationBuilder.setFlags(1);
        }
        String s = eVar.s();
        String g = com.tencent.android.tpush.d.d.g();
        if (s != null && !TextUtils.isEmpty(s)) {
            int identifier2 = context.getResources().getIdentifier(s, "drawable", context.getPackageName());
            if (identifier2 > 0) {
                xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(identifier2));
            } else if (g.equals("google")) {
                int identifier3 = context.getResources().getIdentifier("notification_icon", "drawable", context.getPackageName());
                if (identifier3 > 0) {
                    xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(identifier3));
                } else {
                    xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(context.getApplicationInfo().icon));
                }
            } else {
                xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(context.getApplicationInfo().icon));
            }
        } else if (xGPushNotificationBuilder.getSmallIcon() == null) {
            if (g.equals("google")) {
                int identifier4 = context.getResources().getIdentifier("notification_icon", "drawable", context.getPackageName());
                if (identifier4 > 0) {
                    xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(identifier4));
                } else {
                    xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(context.getApplicationInfo().icon));
                }
            } else {
                xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(context.getApplicationInfo().icon));
            }
        }
        int t = eVar.t();
        String r = eVar.r();
        Integer num = null;
        if (xGPushNotificationBuilder instanceof XGCustomPushNotificationBuilder) {
            num = ((XGCustomPushNotificationBuilder) xGPushNotificationBuilder).getLayoutIconId();
        }
        if (r != null && !TextUtils.isEmpty(r)) {
            if (t <= 0) {
                int identifier5 = context.getResources().getIdentifier(r, "drawable", context.getPackageName());
                if (identifier5 > 0) {
                    xGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), identifier5));
                    if (num != null) {
                        ((XGCustomPushNotificationBuilder) xGPushNotificationBuilder).setLayoutIconDrawableId(identifier5);
                    }
                } else {
                    xGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), context.getApplicationInfo().icon));
                }
            } else {
                Bitmap a2 = a(r);
                if (a2 == null) {
                    xGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), context.getApplicationInfo().icon));
                } else {
                    xGPushNotificationBuilder.setLargeIcon(a2);
                    if (num != null) {
                        ((XGCustomPushNotificationBuilder) xGPushNotificationBuilder).setLayoutIconDrawableBmp(a2);
                    }
                }
            }
        }
        int B = eVar.B();
        if (B > 0) {
            xGPushNotificationBuilder.setColor(Integer.valueOf(B));
        }
        return xGPushNotificationBuilder;
    }

    private static Notification a(Context context, String str, String str2, String str3, int i, int i2) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setGroup(str2).setGroupSummary(true).setAutoCancel(true);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                builder.getClass().getMethod("setChannelId", String.class).invoke(builder, str);
            } catch (Throwable th) {
                TLogger.e("MessageHelper", "NotificationGroup setChannelId error", th);
            }
        }
        if (i > 0) {
            builder.setSmallIcon(i);
        } else {
            builder.setSmallIcon(context.getApplicationInfo().icon);
        }
        if (i2 > 0) {
            builder.setColor(i2);
        }
        if (!TextUtils.isEmpty(str3)) {
            builder.setStyle(new NotificationCompat.BigTextStyle().setSummaryText(str3));
        }
        return builder.build();
    }

    private static boolean a(Context context, String str) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str) && runningAppProcessInfo.importance == 100) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:? */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a9 A[SYNTHETIC, Splitter:B:52:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ae A[Catch:{ IOException -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b3 A[Catch:{ IOException -> 0x00b7 }] */
    private static Bitmap a(String str) {
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        try {
            URL url = new URL(str);
            if (url.getProtocol().toLowerCase().equals("https")) {
                httpURLConnection = (HttpsURLConnection) url.openConnection();
                try {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                } catch (Throwable unused) {
                    inputStream = null;
                }
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("charset", "UTF-8");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            if (httpURLConnection.getResponseCode() != 200) {
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (IOException unused2) {
                    }
                }
                return null;
            }
            inputStream = httpURLConnection.getInputStream();
            if (inputStream != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.toByteArray().length);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused3) {
                                return null;
                            }
                        }
                        byteArrayOutputStream.close();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return decodeByteArray;
                    } catch (Throwable unused4) {
                        if (inputStream != null) {
                        }
                        if (byteArrayOutputStream != 0) {
                        }
                        if (httpURLConnection != null) {
                        }
                        return null;
                    }
                } catch (Throwable unused5) {
                    byteArrayOutputStream = 0;
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream != 0) {
                    }
                    if (httpURLConnection != null) {
                    }
                    return null;
                }
            } else {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            }
        } catch (Throwable unused7) {
            httpURLConnection = null;
            inputStream = null;
            byteArrayOutputStream = inputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused8) {
                    return null;
                }
            }
            if (byteArrayOutputStream != 0) {
                byteArrayOutputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        }
    }

    public static void a(Context context, g gVar) {
        if (gVar.m() instanceof e) {
            TLogger.ii("MessageHelper", "Action -> showNotification " + gVar.f());
            e eVar = (e) gVar.m();
            if (eVar == null || eVar.l() == null) {
                TLogger.e("MessageHelper", "showNotification holder == null || holder.getAction() == null");
                return;
            }
            try {
                Context applicationContext = context.getApplicationContext();
                if (!a.a(applicationContext) || gVar.l() == null || gVar.l().equals(applicationContext.getPackageName())) {
                    a(applicationContext, (Context) null, gVar);
                    return;
                }
                TLogger.ii("MessageHelper", "receive otehr app notification: " + gVar.l());
                a(applicationContext.createPackageContext(gVar.l(), 3), applicationContext, gVar);
            } catch (Throwable th) {
                TLogger.ww("MessageHelper", "showNotification Throwable:", th);
            }
        }
    }

    private static synchronized int b(Context context, int i) {
        int i2;
        synchronized (b.class) {
            i2 = 0;
            try {
                String str = "_XINGE_NOTIF_NUMBER_" + String.valueOf(i);
                int i3 = PushPreferences.getInt(context, str, 0);
                if (i3 < 2147483646) {
                    i2 = i3;
                }
                PushPreferences.putInt(context, str, i2 + 1);
            } catch (Throwable th) {
                TLogger.e("MessageHelper", "", th);
            }
        }
        return i2;
    }
}
