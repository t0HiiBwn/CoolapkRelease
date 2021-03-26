package com.xiaomi.push.service;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.xiaomi.push.ai;
import com.xiaomi.push.bd;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import com.xiaomi.push.ep;
import com.xiaomi.push.eq;
import com.xiaomi.push.g;
import com.xiaomi.push.hc;
import com.xiaomi.push.hp;
import com.xiaomi.push.hy;
import com.xiaomi.push.l;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.t;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class ab {
    public static long a;

    /* renamed from: a  reason: collision with other field name */
    private static final LinkedList<Pair<Integer, hy>> f930a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f931a = Executors.newCachedThreadPool();

    private static class a implements Callable<Bitmap> {
        private Context a;

        /* renamed from: a  reason: collision with other field name */
        private String f932a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f933a;

        public a(String str, Context context, boolean z) {
            this.a = context;
            this.f932a = str;
            this.f933a = z;
        }

        /* renamed from: a */
        public Bitmap call() {
            Bitmap bitmap = null;
            if (!TextUtils.isEmpty(this.f932a)) {
                if (this.f932a.startsWith("http")) {
                    ak.b a2 = ak.a(this.a, this.f932a, this.f933a);
                    if (a2 != null) {
                        return a2.f949a;
                    }
                } else {
                    bitmap = ak.a(this.a, this.f932a);
                    if (bitmap != null) {
                        return bitmap;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.m41a("Failed get online picture/icon resource");
                return bitmap;
            }
            com.xiaomi.channel.commonutils.logger.b.m41a("Failed get online picture/icon resource cause picUrl is empty");
            return null;
        }
    }

    public static class b {
        long a = 0;

        /* renamed from: a  reason: collision with other field name */
        Notification f934a;
    }

    public static class c {
        public long a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f935a;
    }

    static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    private static int a(Map<String, String> map) {
        String str = map == null ? null : map.get("timeout");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static Notification a(Notification notification) {
        Object a2 = bd.a(notification, "extraNotification");
        if (a2 != null) {
            bd.a(a2, "setCustomizedIcon", true);
        }
        return notification;
    }

    private static Notification a(Notification notification, String str) {
        try {
            Field declaredField = Notification.class.getDeclaredField("extraNotification");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(notification);
            Method declaredMethod = obj.getClass().getDeclaredMethod("setTargetPkg", CharSequence.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, str);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
        return notification;
    }

    private static PendingIntent a(Context context, hy hyVar, hp hpVar, byte[] bArr, int i) {
        ComponentName componentName;
        Intent intent;
        Intent intent2;
        int i2 = c(hyVar) ? 1000 : m607a(hyVar) ? 3000 : -1;
        String a2 = hpVar != null ? hpVar.m422a() : "";
        if (hpVar == null || TextUtils.isEmpty(hpVar.f620e)) {
            if (m607a(hyVar)) {
                intent = new Intent();
                componentName = new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler");
            } else {
                intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                componentName = new ComponentName(hyVar.f703b, "com.xiaomi.mipush.sdk.PushMessageHandler");
            }
            intent.setComponent(componentName);
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i));
            intent.addCategory(String.valueOf(a2));
            intent.putExtra("messageId", a2);
            intent.putExtra("eventMessageType", i2);
            ComponentName componentName2 = new ComponentName(hyVar.f703b, "com.xiaomi.mipush.sdk.BridgeActivity");
            if (!f.a(context, componentName2)) {
                return PendingIntent.getService(context, 0, intent, 134217728);
            }
            intent2 = new Intent();
            intent2.setComponent(componentName2);
            intent2.addFlags(276824064);
            intent2.putExtra("mipush_serviceIntent", intent);
            intent2.addCategory(String.valueOf(i));
            intent2.addCategory(String.valueOf(a2));
        } else {
            intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(hpVar.f620e));
            intent2.addFlags(268435456);
            intent2.putExtra("messageId", a2);
            intent2.putExtra("eventMessageType", i2);
        }
        return PendingIntent.getActivity(context, 0, intent2, 134217728);
    }

    private static PendingIntent a(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5) {
        Intent a2;
        if (map == null || (a2 = m603a(context, str, map, str2, str3, str4, str5)) == null) {
            return null;
        }
        return PendingIntent.getActivity(context, 0, a2, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x010a  */
    /* renamed from: a  reason: collision with other method in class */
    private static Intent m603a(Context context, String str, Map<String, String> map, String str2, String str3, String str4, String str5) {
        Intent intent;
        Intent intent2;
        StringBuilder sb;
        String str6;
        MalformedURLException e;
        URISyntaxException e2;
        String str7 = map.get(str2);
        if (TextUtils.isEmpty(str7)) {
            return null;
        }
        if (aw.a.equals(str7)) {
            try {
                intent = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e3) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e3.getMessage());
            }
        } else {
            if (aw.b.equals(str7)) {
                if (map.containsKey(str3)) {
                    String str8 = map.get(str3);
                    if (str8 != null) {
                        try {
                            intent2 = Intent.parseUri(str8, 1);
                            try {
                                intent2.setPackage(str);
                            } catch (URISyntaxException e4) {
                                e2 = e4;
                            }
                        } catch (URISyntaxException e5) {
                            e2 = e5;
                            intent2 = null;
                            sb = new StringBuilder();
                            sb.append("Cause: ");
                            str6 = e2.getMessage();
                            sb.append(str6);
                            com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                            intent = intent2;
                            if (intent != null) {
                            }
                            return null;
                        }
                    }
                } else if (map.containsKey(str4)) {
                    Intent intent3 = new Intent();
                    intent3.setComponent(new ComponentName(str, map.get(str4)));
                    intent = intent3;
                }
                intent = null;
            } else {
                if (aw.c.equals(str7)) {
                    String str9 = map.get(str5);
                    if (!TextUtils.isEmpty(str9)) {
                        String trim = str9.trim();
                        if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                            trim = "http://" + trim;
                        }
                        try {
                            String protocol = new URL(trim).getProtocol();
                            if ("http".equals(protocol) || "https".equals(protocol)) {
                                intent2 = new Intent("android.intent.action.VIEW");
                                try {
                                    intent2.setData(Uri.parse(trim));
                                    am.a(context, intent2);
                                } catch (MalformedURLException e6) {
                                    e = e6;
                                }
                            }
                        } catch (MalformedURLException e7) {
                            e = e7;
                            intent2 = null;
                            sb = new StringBuilder();
                            sb.append("Cause: ");
                            str6 = e.getMessage();
                            sb.append(str6);
                            com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                            intent = intent2;
                            if (intent != null) {
                            }
                            return null;
                        }
                    }
                }
                intent = null;
            }
            intent = intent2;
        }
        if (intent != null) {
            intent.addFlags(268435456);
            try {
                if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                    return intent;
                }
            } catch (Exception e8) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e8.getMessage());
            }
        }
        return null;
    }

    private static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    /* JADX INFO: finally extract failed */
    private static Bitmap a(Context context, String str, boolean z) {
        Future submit = f931a.submit(new a(str, context, z));
        try {
            Bitmap bitmap = (Bitmap) submit.get(180, TimeUnit.SECONDS);
            if (bitmap != null) {
                return bitmap;
            }
            submit.cancel(true);
            return bitmap;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            submit.cancel(true);
            return null;
        } catch (Throwable th) {
            submit.cancel(true);
            throw th;
        }
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i = 1;
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            i = intrinsicHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static RemoteViews a(Context context, hy hyVar, byte[] bArr) {
        hp a2 = hyVar.m456a();
        String a3 = a(hyVar);
        if (!(a2 == null || a2.m423a() == null)) {
            Map<String, String> a4 = a2.m423a();
            String str = a4.get("layout_name");
            String str2 = a4.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a3);
                    int identifier = resourcesForApplication.getIdentifier(str, "layout", a3);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(a3, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has("text")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", a3);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has("image")) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                            Iterator<String> keys2 = jSONObject3.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                String string2 = jSONObject3.getString(next2);
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", a3);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", a3);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has("time")) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                            Iterator<String> keys3 = jSONObject4.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                String string3 = jSONObject4.getString(next3);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", a3);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (JSONException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
        }
        return null;
    }

    private static ai.a a(Context context, String str, int i, String str2, Notification notification) {
        return new ad(i, str2, context, str, notification);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r13v9, resolved type: com.xiaomi.push.eo */
    /* JADX WARN: Multi-variable type inference failed */
    private static ep a(Context context, Map<String, String> map, String str, String str2, int i) {
        PendingIntent a2;
        eq eqVar;
        String str3 = map.get("notification_style_type");
        if (Build.VERSION.SDK_INT >= 16 && "2".equals(str3)) {
            ep epVar = new ep(context);
            Bitmap a3 = TextUtils.isEmpty(map.get("notification_bigPic_uri")) ? null : a(context, map.get("notification_bigPic_uri"), false);
            if (a3 == null) {
                com.xiaomi.channel.commonutils.logger.b.m41a("can not get big picture.");
                return epVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(epVar);
            bigPictureStyle.bigPicture(a3);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            epVar.setStyle(bigPictureStyle);
            return epVar;
        } else if (Build.VERSION.SDK_INT < 16 || !"1".equals(str3)) {
            if ("4".equals(str3) && l.m569a(context)) {
                eo eoVar = new eo(context, str2);
                if (!TextUtils.isEmpty(map.get("notification_banner_image_uri"))) {
                    eoVar.mo295a(a(context, map.get("notification_banner_image_uri"), false));
                }
                eoVar.a(map);
                eqVar = eoVar;
            } else if (!"3".equals(str3) || !l.m569a(context)) {
                return new ep(context);
            } else {
                eq eqVar2 = new eq(context, i, str2);
                if (!TextUtils.isEmpty(map.get("notification_colorful_button_text")) && (a2 = a(context, str2, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri")) != null) {
                    eqVar2.a(map.get("notification_colorful_button_text"), a2).a(map.get("notification_colorful_button_bg_color"));
                }
                if (!TextUtils.isEmpty(map.get("notification_colorful_bg_color"))) {
                    eqVar2.b(map.get("notification_colorful_bg_color"));
                } else if (!TextUtils.isEmpty(map.get("notification_colorful_bg_image_uri"))) {
                    eqVar2.mo295a(a(context, map.get("notification_colorful_bg_image_uri"), false));
                }
                eqVar2.a(map);
                eqVar = eqVar2;
            }
            return eqVar;
        } else {
            ep epVar2 = new ep(context);
            epVar2.setStyle(new Notification.BigTextStyle().bigText(str));
            return epVar2;
        }
    }

    private static ep a(ep epVar, Context context, String str, Map<String, String> map) {
        if (!TextUtils.equals("3", map.get("notification_style_type")) && !TextUtils.equals("4", map.get("notification_style_type"))) {
            PendingIntent a2 = a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
            if (a2 != null && !TextUtils.isEmpty(map.get("notification_style_button_left_name"))) {
                epVar.addAction(0, map.get("notification_style_button_left_name"), a2);
            }
            PendingIntent a3 = a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
            if (a3 != null && !TextUtils.isEmpty(map.get("notification_style_button_mid_name"))) {
                epVar.addAction(0, map.get("notification_style_button_mid_name"), a3);
            }
            PendingIntent a4 = a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
            if (a4 != null && !TextUtils.isEmpty(map.get("notification_style_button_right_name"))) {
                epVar.addAction(0, map.get("notification_style_button_right_name"), a4);
            }
        }
        return epVar;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x03fd: APUT  
      (r11v6 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Boolean : 0x03f8: INVOKE  (r6v21 java.lang.Boolean) = (r6v20 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0412: APUT  
      (r10v13 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Boolean : 0x040d: INVOKE  (r3v24 java.lang.Boolean) = (r3v23 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0389 A[Catch:{ Exception -> 0x0456 }] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0432  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x04c1  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04d7  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0527  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x054e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0128 A[SYNTHETIC, Splitter:B:47:0x0128] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01bb  */
    private static b a(Context context, hy hyVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent, int i) {
        ep epVar;
        long j;
        boolean z;
        Bitmap a2;
        String str;
        long j2;
        boolean z2;
        long currentTimeMillis;
        int i2;
        Uri uri;
        String str2;
        boolean z3;
        b bVar;
        char c2;
        Notification notification;
        Object a3;
        int i3;
        String str3;
        int i4;
        String str4;
        List<NotificationChannel> a4;
        int i5;
        Bitmap bitmap;
        String str5;
        StringBuilder sb;
        String str6;
        b bVar2 = new b();
        hp a5 = hyVar.m456a();
        String a6 = a(hyVar);
        Map<String, String> a7 = a5.m423a();
        String[] a8 = a(context, a5);
        if (remoteViews != null) {
            epVar = new ep(context);
            epVar.setCustomContentView(remoteViews);
        } else {
            epVar = (a7 == null || !a7.containsKey("notification_style_type")) ? new ep(context) : a(context, a7, a8[1], a6, i);
        }
        a(epVar, context, hyVar.b(), a7);
        epVar.setContentTitle(a8[0]);
        epVar.setContentText(a8[1]);
        long currentTimeMillis2 = System.currentTimeMillis();
        epVar.setWhen(currentTimeMillis2);
        String str7 = a7 == null ? null : a7.get("notification_show_when");
        if (!TextUtils.isEmpty(str7)) {
            epVar.setShowWhen(Boolean.parseBoolean(str7));
        } else if (Build.VERSION.SDK_INT >= 24) {
            epVar.setShowWhen(true);
        }
        epVar.setContentIntent(pendingIntent);
        int a9 = a(context, a6, "mipush_notification");
        int a10 = a(context, a6, "mipush_small_notification");
        if (a9 > 0 && a10 > 0) {
            epVar.setLargeIcon(a(context, a9));
            epVar.setSmallIcon(a10);
        } else if (Build.VERSION.SDK_INT >= 23) {
            epVar.setSmallIcon(Icon.createWithResource(a6, am.a(context, a6)));
        } else {
            epVar.setSmallIcon(b(context, a6));
        }
        if (Build.VERSION.SDK_INT >= 23) {
            Bitmap a11 = a7 == null ? null : a(context, a7.get("notification_small_icon_uri"), true);
            if (a11 != null) {
                Object a12 = bd.a("android.graphics.drawable.Icon", "createWithBitmap", a11);
                if (a12 != null) {
                    bd.a((Object) epVar, "setSmallIcon", a12);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("miui.isGrayscaleIcon", true);
                    epVar.addExtras(bundle);
                    str5 = a7 == null ? null : a7.get("notification_small_icon_color");
                    if (!TextUtils.isEmpty(str5)) {
                        try {
                            bd.a((Object) epVar, "setColor", Integer.valueOf(Color.parseColor(str5)));
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.d("fail to set color. " + e);
                        }
                    }
                } else {
                    sb = new StringBuilder();
                    sb.append("failed te get small icon with url:");
                }
            } else {
                sb = new StringBuilder();
                sb.append("failed to get small icon url:");
                if (a7 == null) {
                    str6 = null;
                    sb.append(str6);
                    com.xiaomi.channel.commonutils.logger.b.m41a(sb.toString());
                    if (a7 == null) {
                    }
                    if (!TextUtils.isEmpty(str5)) {
                    }
                }
            }
            str6 = a7.get("notification_small_icon_uri");
            sb.append(str6);
            com.xiaomi.channel.commonutils.logger.b.m41a(sb.toString());
            if (a7 == null) {
            }
            if (!TextUtils.isEmpty(str5)) {
            }
        }
        String str8 = a7 == null ? null : a7.get("__dynamic_icon_uri");
        boolean z4 = (a7 != null && Boolean.parseBoolean(a7.get("__adiom"))) || !l.m568a();
        if (TextUtils.isEmpty(str8) || !z4) {
            j = currentTimeMillis2;
        } else {
            if (str8.startsWith("http")) {
                ak.b a13 = ak.a(context, str8, true);
                if (a13 != null) {
                    bitmap = a13.f949a;
                    j = currentTimeMillis2;
                    bVar2.a = a13.a;
                } else {
                    j = currentTimeMillis2;
                    bitmap = null;
                }
            } else {
                j = currentTimeMillis2;
                bitmap = ak.a(context, str8);
            }
            if (bitmap != null) {
                epVar.setLargeIcon(bitmap);
                z = true;
                a2 = a7 != null ? null : a(context, a7.get("notification_large_icon_uri"), true);
                if (a2 != null) {
                    epVar.setLargeIcon(a2);
                }
                if (a7 != null || Build.VERSION.SDK_INT < 24) {
                    j2 = j;
                    z2 = false;
                    str = null;
                } else {
                    String str9 = a7.get("notification_group");
                    boolean parseBoolean = Boolean.parseBoolean(a7.get("notification_is_summary"));
                    if (TextUtils.isEmpty(str9)) {
                        str9 = a(hyVar);
                    }
                    bd.a((Object) epVar, "setGroupSummary", Boolean.valueOf(parseBoolean));
                    String str10 = a7.get("notification_style_type");
                    if (!"com.xiaomi.xmsf".equals(context.getPackageName()) || (!"4".equals(str10) && !"3".equals(str10))) {
                        j2 = j;
                        str = str9;
                        z2 = false;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(a(hyVar));
                        sb2.append("_custom_");
                        j2 = j;
                        sb2.append(j2);
                        str = sb2.toString();
                        z2 = true;
                    }
                }
                epVar.setAutoCancel(true);
                currentTimeMillis = System.currentTimeMillis();
                if (a7 != null && a7.containsKey("ticker")) {
                    epVar.setTicker(a7.get("ticker"));
                }
                if (currentTimeMillis - a <= 10000) {
                    a = currentTimeMillis;
                    i2 = a5.f607a;
                    if (m610b(context, a6)) {
                        i2 = a(context, a6);
                    }
                    epVar.setDefaults(i2);
                    if (!(a7 == null || (i2 & 1) == 0)) {
                        String str11 = a7.get("sound_uri");
                        if (!TextUtils.isEmpty(str11)) {
                            if (str11.startsWith("android.resource://" + a6)) {
                                epVar.setDefaults(i2 ^ 1);
                                uri = Uri.parse(str11);
                                epVar.setSound(uri);
                            }
                        }
                    }
                    uri = null;
                } else {
                    uri = null;
                    i2 = -100;
                }
                if (a7 != null || Build.VERSION.SDK_INT < 26) {
                    bVar = bVar2;
                    z3 = z;
                    str2 = "com.xiaomi.xmsf";
                    if (a7 != null && Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 26) {
                        bd.a((Object) epVar, "setPriority", Integer.valueOf(c(a7)));
                    }
                } else {
                    al a14 = al.a(context, a6);
                    int a15 = a(a7);
                    bVar = bVar2;
                    if (a15 > 0) {
                        epVar = epVar;
                        bd.a((Object) epVar, "setTimeoutAfter", Long.valueOf((long) (a15 * 1000)));
                    }
                    String str12 = a7.get("channel_id");
                    if (!TextUtils.isEmpty(str12) || context.getApplicationInfo().targetSdkVersion >= 26) {
                        String a16 = a14.m619a("default");
                        if (TextUtils.isEmpty(str12)) {
                            str12 = a16;
                        } else if (l.m568a()) {
                            str12 = a14.m619a(str12);
                        }
                        String a17 = a(context, a6, a7);
                        int b2 = b(a7);
                        if (b2 < 4 || !l.m569a(context) || !m612b(a7)) {
                            i3 = b2;
                            z3 = z;
                            str2 = "com.xiaomi.xmsf";
                        } else {
                            int e2 = e(a7);
                            if (e2 == 0) {
                                com.xiaomi.channel.commonutils.logger.b.d("meet prd of top notification is zero.");
                                str3 = g.m359b(context, a6);
                                z3 = z;
                                str4 = a16;
                                str2 = "com.xiaomi.xmsf";
                                i4 = 1;
                                i3 = 3;
                                Object[] objArr = new Object[i4];
                                objArr[0] = str4;
                                bd.a((Object) epVar, "setChannelId", objArr);
                                if (a14.m618a(str4) == null) {
                                    Object newInstance = t.a(context, "android.app.NotificationChannel").getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance(str4, str3, Integer.valueOf(i3));
                                    if (i2 > -100) {
                                        epVar.setSound((Uri) null, (AudioAttributes) null);
                                        epVar.setDefaults(0);
                                        int i6 = i2 & 1;
                                        int i7 = i2 & 2;
                                        int i8 = i2 & 4;
                                        if (i6 != 1) {
                                            bd.a(newInstance, "setSound", null, null);
                                        }
                                        if (uri != null) {
                                            bd.a(newInstance, "setSound", uri, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                                        }
                                        Object[] objArr2 = new Object[1];
                                        objArr2[0] = Boolean.valueOf(i7 == 2);
                                        bd.a(newInstance, "enableVibration", objArr2);
                                        Object[] objArr3 = new Object[1];
                                        objArr3[0] = Boolean.valueOf(i8 == 4);
                                        bd.a(newInstance, "enableLights", objArr3);
                                    }
                                    a(newInstance, a7);
                                    a14.a((NotificationChannel) newInstance);
                                }
                                a4 = a14.m620a();
                                if (a4 != null && a4.size() > 0) {
                                    for (i5 = 0; i5 < a4.size(); i5++) {
                                        NotificationChannel notificationChannel = a4.get(i5);
                                        CharSequence name = notificationChannel.getName();
                                        String id = notificationChannel.getId();
                                        if (name.equals(g.m359b(context, a6)) && !id.equals(a16)) {
                                            a14.m621a(id);
                                        }
                                    }
                                }
                            } else {
                                i3 = b2;
                                epVar.setPriority(2);
                                int d = d(a7);
                                z3 = z;
                                Bundle bundle2 = new Bundle();
                                str2 = "com.xiaomi.xmsf";
                                bundle2.putLong("mipush_org_when", j2);
                                bundle2.putBoolean("mipush_n_top_flag", true);
                                if (d > 0 && d <= e2) {
                                    bundle2.putInt("mipush_n_top_fre", d);
                                }
                                if (e2 > 0 && d <= e2) {
                                    bundle2.putInt("mipush_n_top_prd", e2);
                                }
                                epVar.addExtras(bundle2);
                            }
                        }
                        str4 = str12;
                        str3 = a17;
                        i4 = 1;
                        Object[] objArr = new Object[i4];
                        objArr[0] = str4;
                        bd.a((Object) epVar, "setChannelId", objArr);
                        try {
                            if (a14.m618a(str4) == null) {
                            }
                            a4 = a14.m620a();
                            while (i5 < a4.size()) {
                            }
                        } catch (Exception e3) {
                            com.xiaomi.channel.commonutils.logger.b.d("meet error when process notification channel. " + e3);
                        }
                    } else {
                        z3 = z;
                        str2 = "com.xiaomi.xmsf";
                    }
                    String str13 = a7.get("background_color");
                    if (!TextUtils.isEmpty(str13)) {
                        try {
                            int parseInt = Integer.parseInt(str13);
                            epVar.setOngoing(true);
                            epVar.setColor(parseInt);
                            bd.a((Object) epVar, "setColorized", true);
                        } catch (Exception e4) {
                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                        }
                    }
                }
                if (str == null) {
                    if (!z2) {
                        str = ai.a().a(context, epVar, str);
                    }
                    c2 = 0;
                    bd.a((Object) epVar, "setGroup", str);
                } else {
                    c2 = 0;
                }
                if (l.c() && str2.equals(context.getPackageName())) {
                    Object[] objArr4 = new Object[3];
                    objArr4[c2] = context;
                    objArr4[1] = epVar;
                    objArr4[2] = a(hyVar);
                    bd.a("miui.util.NotificationHelper", "setTargetPkg", objArr4);
                }
                notification = epVar.getNotification();
                if (z3 && l.m568a()) {
                    a(notification);
                }
                if (!(a7 == null || (a3 = bd.a(notification, "extraNotification")) == null)) {
                    if (!TextUtils.isEmpty(a7.get("enable_keyguard"))) {
                        bd.a(a3, "setEnableKeyguard", Boolean.valueOf(Boolean.parseBoolean(a7.get("enable_keyguard"))));
                    }
                    if (!TextUtils.isEmpty(a7.get("enable_float"))) {
                        bd.a(a3, "setEnableFloat", Boolean.valueOf(Boolean.parseBoolean(a7.get("enable_float"))));
                    }
                }
                bVar.f934a = notification;
                return bVar;
            }
        }
        z = false;
        if (a7 != null) {
        }
        if (a2 != null) {
        }
        if (a7 != null) {
        }
        j2 = j;
        z2 = false;
        str = null;
        epVar.setAutoCancel(true);
        currentTimeMillis = System.currentTimeMillis();
        epVar.setTicker(a7.get("ticker"));
        if (currentTimeMillis - a <= 10000) {
        }
        if (a7 != null) {
        }
        bVar = bVar2;
        z3 = z;
        str2 = "com.xiaomi.xmsf";
        bd.a((Object) epVar, "setPriority", Integer.valueOf(c(a7)));
        if (str == null) {
        }
        Object[] objArr4 = new Object[3];
        objArr4[c2] = context;
        objArr4[1] = epVar;
        objArr4[2] = a(hyVar);
        bd.a("miui.util.NotificationHelper", "setTargetPkg", objArr4);
        notification = epVar.getNotification();
        a(notification);
        if (!TextUtils.isEmpty(a7.get("enable_keyguard"))) {
        }
        if (!TextUtils.isEmpty(a7.get("enable_float"))) {
        }
        bVar.f934a = notification;
        return bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x02fb  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0370  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x03f2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02a9  */
    /* renamed from: a  reason: collision with other method in class */
    public static c m604a(Context context, hy hyVar, byte[] bArr) {
        hp a2;
        RemoteViews a3;
        int hashCode;
        Notification notification;
        String str;
        String str2;
        LinkedList<Pair<Integer, hy>> linkedList;
        String str3;
        Map<String, String> a4;
        long currentTimeMillis;
        String str4;
        StringBuilder sb;
        Object e;
        String str5;
        c cVar = new c();
        g.a a5 = g.a(context, a(hyVar), true);
        if (!l.m569a(context) || a5 != g.a.NOT_ALLOWED) {
            a2 = hyVar.m456a();
            a3 = a(context, hyVar, bArr);
            hashCode = ((a(hyVar).hashCode() / 10) * 10) + (a2 != null ? a2.c() : 0);
            PendingIntent a6 = a(context, hyVar, a2, bArr, hashCode);
            if (a6 == null) {
                if (a2 != null) {
                    en.a(context.getApplicationContext()).a(hyVar.b(), b(hyVar), a2.m422a(), "11");
                }
                str5 = "The click PendingIntent is null. ";
            } else {
                String str6 = null;
                if (Build.VERSION.SDK_INT >= 11) {
                    b a7 = a(context, hyVar, bArr, a3, a6, hashCode);
                    cVar.a = a7.a;
                    cVar.f935a = a(hyVar);
                    notification = a7.f934a;
                } else {
                    notification = new Notification(b(context, a(hyVar)), null, System.currentTimeMillis());
                    String[] a8 = a(context, a2);
                    try {
                        notification.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context, a8[0], a8[1], a6);
                    } catch (NoSuchMethodException e2) {
                        e = e2;
                        if (a2 != null) {
                            en.a(context.getApplicationContext()).b(hyVar.b(), b(hyVar), a2.m422a(), "4");
                        }
                        sb = new StringBuilder();
                        str4 = "meet no such method error. ";
                    } catch (IllegalAccessException e3) {
                        e = e3;
                        if (a2 != null) {
                            en.a(context.getApplicationContext()).b(hyVar.b(), b(hyVar), a2.m422a(), "5");
                        }
                        sb = new StringBuilder();
                        str4 = "meet illegal access error. ";
                    } catch (IllegalArgumentException e4) {
                        e = e4;
                        if (a2 != null) {
                            en.a(context.getApplicationContext()).b(hyVar.b(), b(hyVar), a2.m422a(), "6");
                        }
                        sb = new StringBuilder();
                        str4 = "meet illegal argument error. ";
                    } catch (InvocationTargetException e5) {
                        e = e5;
                        if (a2 != null) {
                            en.a(context.getApplicationContext()).b(hyVar.b(), b(hyVar), a2.m422a(), "7");
                        }
                        sb = new StringBuilder();
                        str4 = "meet invocation target error. ";
                    }
                    a4 = a2.m423a();
                    if (a4 != null && a4.containsKey("ticker")) {
                        notification.tickerText = a4.get("ticker");
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - a > 10000) {
                        a = currentTimeMillis;
                        int i = a2.f607a;
                        if (m610b(context, a(hyVar))) {
                            i = a(context, a(hyVar));
                        }
                        notification.defaults = i;
                        if (!(a4 == null || (i & 1) == 0)) {
                            String str7 = a4.get("sound_uri");
                            if (!TextUtils.isEmpty(str7)) {
                                if (str7.startsWith("android.resource://" + a(hyVar))) {
                                    notification.defaults = 1 ^ i;
                                    notification.sound = Uri.parse(str7);
                                }
                            }
                        }
                    }
                    notification.flags |= 16;
                    if (a3 != null) {
                        notification.contentView = a3;
                    }
                }
                if (l.m568a() && Build.VERSION.SDK_INT >= 19) {
                    if (!TextUtils.isEmpty(a2.m422a())) {
                        notification.extras.putString("message_id", a2.m422a());
                    }
                    str3 = a2.m428b() != null ? null : a2.m428b().get("score_info");
                    if (!TextUtils.isEmpty(str3)) {
                        notification.extras.putString("score_info", str3);
                    }
                    int i2 = -1;
                    if (!c(hyVar)) {
                        i2 = 1000;
                    } else if (m607a(hyVar)) {
                        i2 = 3000;
                    }
                    notification.extras.putString("eventMessageType", String.valueOf(i2));
                    notification.extras.putString("target_package", a(hyVar));
                }
                str = a2.m423a() != null ? null : a2.m423a().get("message_count");
                if (l.m568a() && str != null) {
                    try {
                        a(notification, Integer.parseInt(str));
                    } catch (NumberFormatException e6) {
                        if (a2 != null) {
                            en.a(context.getApplicationContext()).b(hyVar.b(), b(hyVar), a2.m422a(), "8");
                        }
                        com.xiaomi.channel.commonutils.logger.b.d("fail to set message count. " + e6);
                    }
                }
                str2 = a2.m423a() != null ? null : a2.m423a().get("miui.showAtTail");
                if (Build.VERSION.SDK_INT >= 19 && l.m568a()) {
                    notification.extras.putBoolean("miui.showAtTail", "true".equals(str2));
                }
                if (!l.c() && l.m569a(context)) {
                    a(notification, a(hyVar));
                }
                String a9 = a(hyVar);
                al a10 = al.a(context, a9);
                a10.a(hashCode, notification);
                if (l.m568a() && l.m569a(context)) {
                    ai.a().a(context, hashCode, notification);
                    if (Build.VERSION.SDK_INT >= 26 && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
                        b(context, a9, hashCode, a2.m422a(), notification);
                    }
                }
                if (m607a(hyVar)) {
                    en.a(context.getApplicationContext()).a(hyVar.b(), b(hyVar), a2.m422a(), 3002, null);
                }
                if (c(hyVar)) {
                    en.a(context.getApplicationContext()).a(hyVar.b(), b(hyVar), a2.m422a(), 1002, null);
                }
                if (Build.VERSION.SDK_INT < 26) {
                    if (a2 != null) {
                        str6 = a2.m422a();
                    }
                    ai a11 = ai.a(context);
                    int a12 = a(a2.m423a());
                    if (a12 > 0 && !TextUtils.isEmpty(str6)) {
                        String str8 = "n_timeout_" + str6;
                        a11.m103a(str8);
                        a11.b(new ac(str8, a10, hashCode), a12);
                    }
                }
                Pair<Integer, hy> pair = new Pair<>(Integer.valueOf(hashCode), hyVar);
                linkedList = f930a;
                synchronized (linkedList) {
                    linkedList.add(pair);
                    if (linkedList.size() > 100) {
                        linkedList.remove();
                    }
                }
                return cVar;
            }
        } else {
            hp a13 = hyVar.m456a();
            if (a13 != null) {
                en.a(context.getApplicationContext()).a(hyVar.b(), b(hyVar), a13.m422a(), "10:" + a(hyVar));
            }
            str5 = "Do not notify because user block " + a(hyVar) + "‘s notification";
        }
        com.xiaomi.channel.commonutils.logger.b.m41a(str5);
        return cVar;
        sb.append(str4);
        sb.append(e);
        com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
        a4 = a2.m423a();
        notification.tickerText = a4.get("ticker");
        currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a > 10000) {
        }
        notification.flags |= 16;
        if (a3 != null) {
        }
        if (!TextUtils.isEmpty(a2.m422a())) {
        }
        if (a2.m428b() != null) {
        }
        if (!TextUtils.isEmpty(str3)) {
        }
        int i2 = -1;
        if (!c(hyVar)) {
        }
        notification.extras.putString("eventMessageType", String.valueOf(i2));
        notification.extras.putString("target_package", a(hyVar));
        if (a2.m423a() != null) {
        }
        a(notification, Integer.parseInt(str));
        if (a2.m423a() != null) {
        }
        notification.extras.putBoolean("miui.showAtTail", "true".equals(str2));
        a(notification, a(hyVar));
        String a9 = a(hyVar);
        al a10 = al.a(context, a9);
        a10.a(hashCode, notification);
        ai.a().a(context, hashCode, notification);
        b(context, a9, hashCode, a2.m422a(), notification);
        if (m607a(hyVar)) {
        }
        if (c(hyVar)) {
        }
        if (Build.VERSION.SDK_INT < 26) {
        }
        Pair<Integer, hy> pair = new Pair<>(Integer.valueOf(hashCode), hyVar);
        linkedList = f930a;
        synchronized (linkedList) {
        }
    }

    private static String a(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? g.m359b(context, str) : map.get("channel_name");
    }

    static String a(hy hyVar) {
        hp a2;
        if (!(!"com.xiaomi.xmsf".equals(hyVar.f703b) || (a2 = hyVar.m456a()) == null || a2.m423a() == null)) {
            String str = a2.m423a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hyVar.f703b;
    }

    private static void a(Notification notification, int i) {
        Object a2 = bd.a(notification, "extraNotification");
        if (a2 != null) {
            bd.a(a2, "setMessageCount", Integer.valueOf(i));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m605a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i) {
        al a2 = al.a(context, str);
        int hashCode = ((str.hashCode() / 10) * 10) + i;
        LinkedList linkedList = new LinkedList();
        if (i >= 0) {
            a2.a(hashCode);
        }
        LinkedList<Pair<Integer, hy>> linkedList2 = f930a;
        synchronized (linkedList2) {
            Iterator<Pair<Integer, hy>> it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                Pair<Integer, hy> next = it2.next();
                hy hyVar = (hy) next.second;
                if (hyVar != null) {
                    String a3 = a(hyVar);
                    if (i >= 0) {
                        if (hashCode == ((Integer) next.first).intValue()) {
                            if (!TextUtils.equals(a3, str)) {
                            }
                        }
                    } else if (i == -1 && TextUtils.equals(a3, str)) {
                        a2.a(((Integer) next.first).intValue());
                    }
                    linkedList.add(next);
                }
            }
            LinkedList<Pair<Integer, hy>> linkedList3 = f930a;
            if (linkedList3 != null) {
                linkedList3.removeAll(linkedList);
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            LinkedList linkedList = new LinkedList();
            LinkedList<Pair<Integer, hy>> linkedList2 = f930a;
            synchronized (linkedList2) {
                Iterator<Pair<Integer, hy>> it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    Pair<Integer, hy> next = it2.next();
                    hy hyVar = (hy) next.second;
                    if (hyVar != null) {
                        String a2 = a(hyVar);
                        hp a3 = hyVar.m456a();
                        if (a3 != null) {
                            if (TextUtils.equals(a2, str)) {
                                String c2 = a3.m430c();
                                String d = a3.d();
                                if (!TextUtils.isEmpty(c2) && !TextUtils.isEmpty(d) && a(str2, c2) && a(str3, d)) {
                                    al.a(context, str).a(((Integer) next.first).intValue());
                                    linkedList.add(next);
                                }
                            }
                        }
                    }
                }
                LinkedList<Pair<Integer, hy>> linkedList3 = f930a;
                if (linkedList3 != null) {
                    linkedList3.removeAll(linkedList);
                    a(context, linkedList);
                }
            }
        }
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            bl.a(context, "category_clear_notification", "clear_notification", (long) linkedList.size(), "");
        }
    }

    private static void a(Object obj, Map<String, String> map) {
        if (map != null && !TextUtils.isEmpty(map.get("channel_description"))) {
            bd.a(obj, "setDescription", map.get("channel_description"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m606a(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        String a2 = hpVar.m422a();
        return !TextUtils.isEmpty(a2) && a2.length() == 22 && "satuigmo".indexOf(a2.charAt(0)) >= 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m607a(hy hyVar) {
        hp a2 = hyVar.m456a();
        return a(a2) && a2.l();
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m608a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0070, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004e, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0072;
     */
    private static String[] a(Context context, hp hpVar) {
        String str;
        String c2 = hpVar.m430c();
        String d = hpVar.d();
        Map<String, String> a2 = hpVar.m423a();
        if (a2 != null) {
            int intValue = Float.valueOf((((float) context.getResources().getDisplayMetrics().widthPixels) / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (intValue <= 320) {
                String str2 = a2.get("title_short");
                if (!TextUtils.isEmpty(str2)) {
                    c2 = str2;
                }
                str = a2.get("description_short");
            } else if (intValue > 360) {
                String str3 = a2.get("title_long");
                if (!TextUtils.isEmpty(str3)) {
                    c2 = str3;
                }
                str = a2.get("description_long");
            }
            d = str;
        }
        return new String[]{c2, d};
    }

    private static int b(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return (a2 != 0 || Build.VERSION.SDK_INT < 9) ? a2 : context.getApplicationInfo().logo;
    }

    private static int b(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("importance=" + str);
            return Integer.parseInt(str);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing channel importance error: " + e);
            return 3;
        }
    }

    /* access modifiers changed from: private */
    public static String b(int i, String str) {
        return "n_top_update_" + i + "_" + str;
    }

    public static String b(hy hyVar) {
        return m607a(hyVar) ? "E100002" : c(hyVar) ? "E100000" : m611b(hyVar) ? "E100001" : d(hyVar) ? "E100003" : "";
    }

    /* renamed from: b  reason: collision with other method in class */
    static void m609b(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    private static void b(Context context, String str, int i, String str2, Notification notification) {
        boolean z;
        Notification notification2 = notification;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && al.a(context, str) != null && Build.VERSION.SDK_INT >= 26) {
            al a2 = al.a(context, str);
            if (notification2 == null) {
                List<StatusBarNotification> b2 = a2.b();
                if (b2 != null) {
                    Iterator<StatusBarNotification> it2 = b2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            notification2 = null;
                            break;
                        }
                        StatusBarNotification next = it2.next();
                        Notification notification3 = next.getNotification();
                        String string = notification3.extras.getString("message_id");
                        if (i == next.getId() && str2.equals(string)) {
                            notification2 = notification3;
                            break;
                        }
                    }
                    z = false;
                } else {
                    return;
                }
            } else if (str2.equals(notification2.extras.getString("message_id"))) {
                z = true;
            } else {
                return;
            }
            if (notification2 != null) {
                if (notification2.getGroupAlertBehavior() != 1) {
                    bd.a((Object) notification2, "mGroupAlertBehavior", (Object) 1);
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j = notification2.extras.getLong("mipush_org_when", 0);
                int i2 = notification2.extras.getInt("mipush_n_top_fre", 0);
                int i3 = notification2.extras.getInt("mipush_n_top_prd", 0);
                if (i3 > 0 && i3 >= i2) {
                    long j2 = ((long) (i3 * 1000)) + j;
                    if (j >= currentTimeMillis || currentTimeMillis >= j2) {
                        i3 = 0;
                    } else if (i2 > 0 && (i3 = (int) Math.min((j2 - currentTimeMillis) / 1000, (long) i2)) > 0 && !z) {
                        notification2.when = currentTimeMillis;
                        com.xiaomi.channel.commonutils.logger.b.m41a("update top notification: " + str2);
                        a2.a(i, notification2);
                    }
                    if (i3 > 0) {
                        com.xiaomi.channel.commonutils.logger.b.m41a("schedule top notification next update delay: " + i3);
                        ai.a(context).m103a(b(i, str2));
                        ai.a(context).b(a(context, str, i, str2, (Notification) null), i3);
                        return;
                    }
                    String a3 = a2.m619a("default");
                    if (a2.m618a(a3) == null) {
                        a2.a(new NotificationChannel(a3, g.m359b(context, str), 3));
                    }
                    Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, notification2);
                    recoverBuilder.setChannelId(a3);
                    recoverBuilder.setPriority(0);
                    com.xiaomi.channel.commonutils.logger.b.m41a("update top notification to common: " + str2);
                    a2.a(i, recoverBuilder.build());
                }
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    static boolean m610b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m611b(hy hyVar) {
        hp a2 = hyVar.m456a();
        return a(a2) && a2.f613b == 1 && !m607a(hyVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    private static boolean m612b(Map<String, String> map) {
        if (map != null) {
            String str = map.get("notification_top_repeat");
            if (!TextUtils.isEmpty(str)) {
                boolean parseBoolean = Boolean.parseBoolean(str);
                com.xiaomi.channel.commonutils.logger.b.c("top notification' repeat is " + parseBoolean);
                return parseBoolean;
            }
        }
        return true;
    }

    private static int c(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("priority=" + str);
            return Integer.parseInt(str);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing notification priority error: " + e);
            return 0;
        }
    }

    public static boolean c(hy hyVar) {
        hp a2 = hyVar.m456a();
        return a(a2) && a2.f613b == 0 && !m607a(hyVar);
    }

    private static int d(Map<String, String> map) {
        int i;
        if (map != null) {
            String str = map.get("notification_top_frequency");
            if (!TextUtils.isEmpty(str)) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.c("fre of top notification is " + str);
                    i = Integer.parseInt(str);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d("parsing top notification frequency error: " + e);
                }
                return Math.max(0, i);
            }
        }
        i = 0;
        return Math.max(0, i);
    }

    public static boolean d(hy hyVar) {
        return hyVar.a() == hc.Registration;
    }

    private static int e(Map<String, String> map) {
        int i;
        if (map != null) {
            String str = map.get("notification_top_period");
            if (!TextUtils.isEmpty(str)) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.c("prd of top notification is " + str);
                    i = Integer.parseInt(str);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d("parsing top notification period error: " + e);
                }
                return Math.max(0, i);
            }
        }
        i = 0;
        return Math.max(0, i);
    }

    public static boolean e(hy hyVar) {
        return m607a(hyVar) || c(hyVar) || m611b(hyVar);
    }
}
