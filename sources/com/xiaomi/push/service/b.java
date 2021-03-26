package com.xiaomi.push.service;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
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
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.xiaomi.push.ac;
import com.xiaomi.push.dv;
import com.xiaomi.push.eu;
import com.xiaomi.push.gi;
import com.xiaomi.push.gn;
import com.xiaomi.push.gv;
import com.xiaomi.push.hf;
import com.xiaomi.push.it;
import com.xiaomi.push.jb;
import com.xiaomi.push.service.j;
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

public class b {
    public static long a;
    private static final LinkedList<Pair<Integer, hf>> b = new LinkedList<>();
    private static ExecutorService c = Executors.newCachedThreadPool();

    private static class a implements Callable<Bitmap> {
        private String a;
        private Context b;
        private boolean c;

        public a(String str, Context context, boolean z) {
            this.b = context;
            this.a = str;
            this.c = z;
        }

        /* renamed from: a */
        public Bitmap call() {
            Bitmap bitmap = null;
            if (!TextUtils.isEmpty(this.a)) {
                if (this.a.startsWith("http")) {
                    j.b a2 = j.a(this.b, this.a, this.c);
                    if (a2 != null) {
                        return a2.a;
                    }
                } else {
                    bitmap = j.a(this.b, this.a);
                    if (bitmap != null) {
                        return bitmap;
                    }
                }
                com.xiaomi.a.a.a.c.a("Failed get online picture/icon resource");
                return bitmap;
            }
            com.xiaomi.a.a.a.c.a("Failed get online picture/icon resource cause picUrl is empty");
            return null;
        }
    }

    /* renamed from: com.xiaomi.push.service.b$b  reason: collision with other inner class name */
    public static class C0186b {
        Notification a;
        long b = 0;
    }

    public static class c {
        public String a;
        public long b = 0;
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    private static Notification.Builder a(Notification.Builder builder, Context context, String str, Map<String, String> map) {
        PendingIntent a2 = a(context, str, 1, map);
        if (a2 != null && !TextUtils.isEmpty(map.get("notification_style_button_left_name"))) {
            builder.addAction(0, map.get("notification_style_button_left_name"), a2);
        }
        PendingIntent a3 = a(context, str, 2, map);
        if (a3 != null && !TextUtils.isEmpty(map.get("notification_style_button_mid_name"))) {
            builder.addAction(0, map.get("notification_style_button_mid_name"), a3);
        }
        PendingIntent a4 = a(context, str, 3, map);
        if (a4 != null && !TextUtils.isEmpty(map.get("notification_style_button_right_name"))) {
            builder.addAction(0, map.get("notification_style_button_right_name"), a4);
        }
        return builder;
    }

    private static Notification.Builder a(Context context, Map<String, String> map, Notification.Builder builder, String str) {
        if ("2".equals(map.get("notification_style_type"))) {
            Bitmap a2 = map == null ? null : a(context, map.get("notification_bigPic_uri"), false);
            if (a2 == null) {
                com.xiaomi.a.a.a.c.a("can not get big picture.");
                return builder;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(builder);
            bigPictureStyle.bigPicture(a2);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            builder.setStyle(bigPictureStyle);
        } else if ("1".equals(map.get("notification_style_type"))) {
            builder.setStyle(new Notification.BigTextStyle().bigText(str));
        }
        return builder;
    }

    private static Notification a(Notification notification) {
        Object a2 = ac.a(notification, "extraNotification");
        if (a2 != null) {
            ac.a(a2, "setCustomizedIcon", true);
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
            com.xiaomi.a.a.a.c.a(e);
        }
        return notification;
    }

    private static PendingIntent a(Context context, hf hfVar, gv gvVar, byte[] bArr, int i) {
        ComponentName componentName;
        Intent intent;
        int i2 = d(hfVar) ? 1000 : b(hfVar) ? 3000 : -1;
        String b2 = gvVar != null ? gvVar.b() : "";
        if (gvVar == null || TextUtils.isEmpty(gvVar.g)) {
            if (b(hfVar)) {
                intent = new Intent();
                componentName = new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler");
            } else {
                intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                componentName = new ComponentName(hfVar.f, "com.xiaomi.mipush.sdk.PushMessageHandler");
            }
            intent.setComponent(componentName);
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(i));
            intent.addCategory(String.valueOf(b2));
            intent.putExtra("messageId", b2);
            intent.putExtra("eventMessageType", i2);
            if (!bd.b(context, hfVar.f, "com.xiaomi.mipush.MESSAGE_CLICKED")) {
                return PendingIntent.getService(context, 0, intent, 134217728);
            }
            Intent intent2 = new Intent();
            intent2.setAction("com.xiaomi.mipush.MESSAGE_CLICKED");
            intent2.setClassName(hfVar.f, "com.xiaomi.mipush.sdk.BridgeActivity");
            intent2.addFlags(276824064);
            intent2.putExtra("mipush_serviceIntent", intent);
            intent2.addCategory(String.valueOf(i));
            intent2.addCategory(String.valueOf(b2));
            return PendingIntent.getActivity(context, 0, intent2, 134217728);
        }
        Intent intent3 = new Intent("android.intent.action.VIEW");
        intent3.setData(Uri.parse(gvVar.g));
        intent3.addFlags(268435456);
        intent3.putExtra("messageId", b2);
        intent3.putExtra("eventMessageType", i2);
        return PendingIntent.getActivity(context, 0, intent3, 134217728);
    }

    private static PendingIntent a(Context context, String str, int i, Map<String, String> map) {
        Intent b2;
        if (map == null || (b2 = b(context, str, i, map)) == null) {
            return null;
        }
        return PendingIntent.getActivity(context, 0, b2, 0);
    }

    private static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    /* JADX INFO: finally extract failed */
    private static Bitmap a(Context context, String str, boolean z) {
        Future submit = c.submit(new a(str, context, z));
        try {
            Bitmap bitmap = (Bitmap) submit.get(180, TimeUnit.SECONDS);
            if (bitmap != null) {
                return bitmap;
            }
            submit.cancel(true);
            return bitmap;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            com.xiaomi.a.a.a.c.a(e);
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

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x03df: APUT  
      (r11v9 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Boolean : 0x03da: INVOKE  (r9v20 java.lang.Boolean) = (r13v12 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x03f4: APUT  
      (r10v21 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Boolean : 0x03ef: INVOKE  (r3v27 java.lang.Boolean) = (r13v13 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0579  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0117 A[SYNTHETIC, Splitter:B:45:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01fc  */
    private static C0186b a(Context context, hf hfVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent) {
        boolean z;
        Bitmap a2;
        long currentTimeMillis;
        Uri uri;
        int i;
        boolean z2;
        C0186b bVar;
        Notification notification;
        Object a3;
        int d;
        Uri uri2;
        String str;
        List list;
        String str2;
        String str3;
        int a4;
        String str4;
        Bitmap bitmap;
        String str5;
        StringBuilder sb;
        String str6;
        C0186b bVar2 = new C0186b();
        gv m = hfVar.m();
        String a5 = a(hfVar);
        Map<String, String> s = m.s();
        Notification.Builder builder = new Notification.Builder(context);
        String[] a6 = a(context, m);
        builder.setContentTitle(a6[0]);
        builder.setContentText(a6[1]);
        if (remoteViews != null) {
            builder.setContent(remoteViews);
        } else if (Build.VERSION.SDK_INT >= 16 && s != null && s.containsKey("notification_style_type")) {
            builder = a(context, s, builder, a6[1]);
        }
        Notification.Builder a7 = a(builder, context, hfVar.j(), s);
        long currentTimeMillis2 = System.currentTimeMillis();
        a7.setWhen(currentTimeMillis2);
        String str7 = s == null ? null : s.get("notification_show_when");
        if (!TextUtils.isEmpty(str7)) {
            a7.setShowWhen(Boolean.parseBoolean(str7));
        } else if (Build.VERSION.SDK_INT >= 24) {
            a7.setShowWhen(true);
        }
        a7.setContentIntent(pendingIntent);
        int a8 = a(context, a5, "mipush_notification");
        int a9 = a(context, a5, "mipush_small_notification");
        if (a8 <= 0 || a9 <= 0) {
            a7.setSmallIcon(f(context, a5));
        } else {
            a7.setLargeIcon(a(context, a8));
            a7.setSmallIcon(a9);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            Bitmap a10 = s == null ? null : a(context, s.get("notification_small_icon_uri"), true);
            if (a10 != null) {
                Object a11 = ac.a("android.graphics.drawable.Icon", "createWithBitmap", a10);
                if (a11 != null) {
                    ac.a(a7, "setSmallIcon", a11);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("miui.isGrayscaleIcon", true);
                    a7.addExtras(bundle);
                    str5 = s == null ? null : s.get("notification_small_icon_color");
                    if (!TextUtils.isEmpty(str5)) {
                        try {
                            ac.a(a7, "setColor", Integer.valueOf(Color.parseColor(str5)));
                        } catch (Exception e) {
                            com.xiaomi.a.a.a.c.a(e);
                        }
                    }
                } else {
                    sb = new StringBuilder();
                    sb.append("failed te get small icon with url:");
                }
            } else {
                sb = new StringBuilder();
                sb.append("failed to get small icon url:");
                if (s == null) {
                    str6 = null;
                    sb.append(str6);
                    com.xiaomi.a.a.a.c.a(sb.toString());
                    if (s == null) {
                    }
                    if (!TextUtils.isEmpty(str5)) {
                    }
                }
            }
            str6 = s.get("notification_small_icon_uri");
            sb.append(str6);
            com.xiaomi.a.a.a.c.a(sb.toString());
            if (s == null) {
            }
            if (!TextUtils.isEmpty(str5)) {
            }
        }
        String str8 = s == null ? null : s.get("__dynamic_icon_uri");
        boolean z3 = (s != null && Boolean.parseBoolean(s.get("__adiom"))) || !it.a();
        if (str8 != null && z3) {
            if (str8.startsWith("http")) {
                j.b a12 = j.a(context, str8, true);
                if (a12 != null) {
                    bitmap = a12.a;
                    bVar2.b = a12.b;
                } else {
                    bitmap = null;
                }
            } else {
                bitmap = j.a(context, str8);
            }
            if (bitmap != null) {
                a7.setLargeIcon(bitmap);
                z = true;
                a2 = s != null ? null : a(context, s.get("notification_large_icon_uri"), true);
                if (a2 != null) {
                    a7.setLargeIcon(a2);
                }
                if (s != null && Build.VERSION.SDK_INT >= 24) {
                    str4 = s.get("notification_group");
                    boolean parseBoolean = Boolean.parseBoolean(s.get("notification_is_summary"));
                    if (TextUtils.isEmpty(str4)) {
                        str4 = a(hfVar);
                    }
                    ac.a(a7, "setGroup", h.a().a(context, a7, str4));
                    ac.a(a7, "setGroupSummary", Boolean.valueOf(parseBoolean));
                }
                a7.setAutoCancel(true);
                currentTimeMillis = System.currentTimeMillis();
                if (s != null && s.containsKey("ticker")) {
                    a7.setTicker(s.get("ticker"));
                }
                if (currentTimeMillis - a <= 10000) {
                    a = currentTimeMillis;
                    i = m.f;
                    if (e(context, a5)) {
                        i = c(context, a5);
                    }
                    a7.setDefaults(i);
                    if (!(s == null || (i & 1) == 0)) {
                        String str9 = s.get("sound_uri");
                        if (!TextUtils.isEmpty(str9)) {
                            if (str9.startsWith("android.resource://" + a5)) {
                                a7.setDefaults(i ^ 1);
                                uri = Uri.parse(str9);
                                a7.setSound(uri);
                                if (s != null || Build.VERSION.SDK_INT < 26) {
                                    bVar = bVar2;
                                    z2 = z;
                                    if (s != null && Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 26) {
                                        d = d(s);
                                        ac.a(a7, "setPriority", Integer.valueOf(d));
                                        if (d >= 1) {
                                            ac.a(a7, "setGroup", a(hfVar) + "_top_" + currentTimeMillis2);
                                        }
                                    }
                                } else {
                                    int b2 = b(s);
                                    bVar = bVar2;
                                    if (b2 > 0) {
                                        uri2 = uri;
                                        ac.a(a7, "setTimeoutAfter", Long.valueOf((long) (b2 * 1000)));
                                    } else {
                                        uri2 = uri;
                                    }
                                    String str10 = s.get("channel_id");
                                    if (!TextUtils.isEmpty(str10) || context.getApplicationInfo().targetSdkVersion >= 26) {
                                        String str11 = "mipush_" + a5 + "_default";
                                        if (TextUtils.isEmpty(str10)) {
                                            z2 = z;
                                            str10 = str11;
                                        } else if (it.a()) {
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("mipush_");
                                            sb2.append(a5);
                                            z2 = z;
                                            sb2.append("_");
                                            sb2.append(str10);
                                            str10 = sb2.toString();
                                        } else {
                                            z2 = z;
                                        }
                                        ac.a(a7, "setChannelId", str10);
                                        String a13 = a(context, a5, s);
                                        int c2 = c(s);
                                        String str12 = str11;
                                        if (c2 >= 4) {
                                            StringBuilder sb3 = new StringBuilder();
                                            str = "mipush_";
                                            sb3.append(a(hfVar));
                                            sb3.append("_top_");
                                            sb3.append(currentTimeMillis2);
                                            ac.a(a7, "setGroup", sb3.toString());
                                            if ("com.xiaomi.xmsf".equals(context.getPackageName()) && l.a(context).a(gn.TopNotificationUpdateSwitch.a(), true) && (a4 = l.a(context).a(gn.TopNotificationUpdateFrequency.a(), 14400)) > 0) {
                                                ac.a(a7, "setTimeoutAfter", Long.valueOf((long) (a4 * 1000)));
                                                Bundle bundle2 = new Bundle();
                                                bundle2.putLong("mipush_org_when", currentTimeMillis2);
                                                a7.addExtras(bundle2);
                                            }
                                        } else {
                                            str = "mipush_";
                                        }
                                        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                                        try {
                                            if (ac.a(notificationManager, "getNotificationChannel", str10) == null) {
                                                Object newInstance = jb.a(context, "android.app.NotificationChannel").getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance(str10, a13, Integer.valueOf(c2));
                                                if (i > -100) {
                                                    a7.setSound((Uri) null, (AudioAttributes) null);
                                                    a7.setDefaults(0);
                                                    int i2 = i & 1;
                                                    int i3 = i & 2;
                                                    int i4 = i & 4;
                                                    if (i2 != 1) {
                                                        ac.a(newInstance, "setSound", null, null);
                                                    }
                                                    if (uri2 != null) {
                                                        ac.a(newInstance, "setSound", uri2, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                                                    }
                                                    Object[] objArr = new Object[1];
                                                    objArr[0] = Boolean.valueOf(i3 == 2);
                                                    ac.a(newInstance, "enableVibration", objArr);
                                                    Object[] objArr2 = new Object[1];
                                                    objArr2[0] = Boolean.valueOf(i4 == 4);
                                                    ac.a(newInstance, "enableLights", objArr2);
                                                }
                                                a(newInstance, s);
                                                ac.a(notificationManager, "createNotificationChannel", newInstance);
                                            }
                                            Object a14 = ac.a(notificationManager, "getNotificationChannels", new Object[0]);
                                            if (a14 != null && (a14 instanceof List) && (list = (List) a14) != null && list.size() > 0) {
                                                int i5 = 0;
                                                while (i5 < list.size()) {
                                                    Object obj = list.get(i5);
                                                    Object a15 = ac.a(obj, "getName", new Object[0]);
                                                    Object a16 = ac.a(obj, "getId", new Object[0]);
                                                    String g = eu.g(context, a5);
                                                    if (a15 == null || a16 == null || !(a15 instanceof CharSequence) || !(a16 instanceof String) || !a15.equals(g)) {
                                                        str3 = str12;
                                                        str2 = str;
                                                    } else {
                                                        StringBuilder sb4 = new StringBuilder();
                                                        str2 = str;
                                                        sb4.append(str2);
                                                        sb4.append(a5);
                                                        if (((String) a16).startsWith(sb4.toString())) {
                                                            str3 = str12;
                                                            if (!a16.equals(str3)) {
                                                                ac.a(notificationManager, "deleteNotificationChannel", a16);
                                                            }
                                                        } else {
                                                            str3 = str12;
                                                        }
                                                    }
                                                    i5++;
                                                    str12 = str3;
                                                    str = str2;
                                                }
                                            }
                                        } catch (Exception e2) {
                                            com.xiaomi.a.a.a.c.a(e2);
                                        }
                                    } else {
                                        z2 = z;
                                    }
                                    String str13 = s.get("background_color");
                                    if (!TextUtils.isEmpty(str13)) {
                                        try {
                                            int parseInt = Integer.parseInt(str13);
                                            a7.setOngoing(true);
                                            a7.setColor(parseInt);
                                            ac.a(a7, "setColorized", true);
                                        } catch (Exception e3) {
                                            com.xiaomi.a.a.a.c.a(e3);
                                        }
                                    }
                                }
                                if (it.e() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                                    ac.a("miui.util.NotificationHelper", "setTargetPkg", context, a7, a(hfVar));
                                }
                                notification = a7.getNotification();
                                if (z2 && it.a()) {
                                    a(notification);
                                }
                                if (!(s == null || (a3 = ac.a(notification, "extraNotification")) == null)) {
                                    if (!TextUtils.isEmpty(s.get("enable_keyguard"))) {
                                        ac.a(a3, "setEnableKeyguard", Boolean.valueOf(Boolean.parseBoolean(s.get("enable_keyguard"))));
                                    }
                                    if (!TextUtils.isEmpty(s.get("enable_float"))) {
                                        ac.a(a3, "setEnableFloat", Boolean.valueOf(Boolean.parseBoolean(s.get("enable_float"))));
                                    }
                                }
                                bVar.a = notification;
                                return bVar;
                            }
                        }
                    }
                } else {
                    i = -100;
                }
                uri = null;
                if (s != null) {
                }
                bVar = bVar2;
                z2 = z;
                d = d(s);
                ac.a(a7, "setPriority", Integer.valueOf(d));
                if (d >= 1) {
                }
                ac.a("miui.util.NotificationHelper", "setTargetPkg", context, a7, a(hfVar));
                notification = a7.getNotification();
                a(notification);
                if (!TextUtils.isEmpty(s.get("enable_keyguard"))) {
                }
                if (!TextUtils.isEmpty(s.get("enable_float"))) {
                }
                bVar.a = notification;
                return bVar;
            }
        }
        z = false;
        if (s != null) {
        }
        if (a2 != null) {
        }
        str4 = s.get("notification_group");
        boolean parseBoolean = Boolean.parseBoolean(s.get("notification_is_summary"));
        if (TextUtils.isEmpty(str4)) {
        }
        ac.a(a7, "setGroup", h.a().a(context, a7, str4));
        ac.a(a7, "setGroupSummary", Boolean.valueOf(parseBoolean));
        a7.setAutoCancel(true);
        currentTimeMillis = System.currentTimeMillis();
        a7.setTicker(s.get("ticker"));
        if (currentTimeMillis - a <= 10000) {
        }
        uri = null;
        if (s != null) {
        }
        bVar = bVar2;
        z2 = z;
        d = d(s);
        ac.a(a7, "setPriority", Integer.valueOf(d));
        if (d >= 1) {
        }
        ac.a("miui.util.NotificationHelper", "setTargetPkg", context, a7, a(hfVar));
        notification = a7.getNotification();
        a(notification);
        if (!TextUtils.isEmpty(s.get("enable_keyguard"))) {
        }
        if (!TextUtils.isEmpty(s.get("enable_float"))) {
        }
        bVar.a = notification;
        return bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0352 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0276  */
    public static c a(Context context, hf hfVar, byte[] bArr) {
        Notification notification;
        String str;
        LinkedList<Pair<Integer, hf>> linkedList;
        String str2;
        Map<String, String> s;
        long currentTimeMillis;
        Throwable e;
        String str3;
        String str4;
        String str5;
        String str6;
        dv dvVar;
        String str7;
        c cVar = new c();
        if (eu.c(context, a(hfVar)) == eu.a.NOT_ALLOWED) {
            gv m = hfVar.m();
            if (m != null) {
                dv.a(context.getApplicationContext()).a(hfVar.j(), g(hfVar), m.b(), "10:" + a(hfVar));
            }
            str7 = "Do not notify because user block " + a(hfVar) + "‘s notification";
        } else {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            gv m2 = hfVar.m();
            RemoteViews b2 = b(context, hfVar, bArr);
            int hashCode = ((a(hfVar).hashCode() / 10) * 10) + (m2 != null ? m2.q() : 0);
            PendingIntent a2 = a(context, hfVar, m2, bArr, hashCode);
            if (a2 == null) {
                if (m2 != null) {
                    dv.a(context.getApplicationContext()).a(hfVar.j(), g(hfVar), m2.b(), "11");
                }
                str7 = "The click PendingIntent is null. ";
            } else {
                if (Build.VERSION.SDK_INT >= 11) {
                    C0186b a3 = a(context, hfVar, bArr, b2, a2);
                    cVar.b = a3.b;
                    cVar.a = a(hfVar);
                    notification = a3.a;
                } else {
                    notification = new Notification(f(context, a(hfVar)), null, System.currentTimeMillis());
                    String[] a4 = a(context, m2);
                    try {
                        notification.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context, a4[0], a4[1], a2);
                    } catch (NoSuchMethodException e2) {
                        e = e2;
                        if (m2 != null) {
                            dvVar = dv.a(context.getApplicationContext());
                            str6 = hfVar.j();
                            str5 = g(hfVar);
                            str4 = m2.b();
                            str3 = "4";
                            dvVar.b(str6, str5, str4, str3);
                        }
                        com.xiaomi.a.a.a.c.a(e);
                        s = m2.s();
                        notification.tickerText = s.get("ticker");
                        currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - a > 10000) {
                        }
                        notification.flags |= 16;
                        if (b2 != null) {
                        }
                        if (!TextUtils.isEmpty(m2.b())) {
                        }
                        if (m2.u() == null) {
                        }
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        int i = -1;
                        if (d(hfVar)) {
                        }
                        notification.extras.putString("eventMessageType", String.valueOf(i));
                        notification.extras.putString("target_package", a(hfVar));
                        if (m2.s() == null) {
                        }
                        try {
                            a(notification, Integer.parseInt(str));
                        } catch (NumberFormatException e3) {
                            if (m2 != null) {
                                dv.a(context.getApplicationContext()).b(hfVar.j(), g(hfVar), m2.b(), "8");
                            }
                            com.xiaomi.a.a.a.c.a(e3);
                        }
                        a(notification, a(hfVar));
                        notificationManager.notify(hashCode, notification);
                        h.a().a(context, hashCode, notification);
                        if (b(hfVar)) {
                        }
                        if (d(hfVar)) {
                        }
                        if (Build.VERSION.SDK_INT < 26) {
                        }
                        Pair<Integer, hf> pair = new Pair<>(Integer.valueOf(hashCode), hfVar);
                        linkedList = b;
                        synchronized (linkedList) {
                        }
                    } catch (IllegalAccessException e4) {
                        e = e4;
                        if (m2 != null) {
                            dvVar = dv.a(context.getApplicationContext());
                            str6 = hfVar.j();
                            str5 = g(hfVar);
                            str4 = m2.b();
                            str3 = "5";
                            dvVar.b(str6, str5, str4, str3);
                        }
                        com.xiaomi.a.a.a.c.a(e);
                        s = m2.s();
                        notification.tickerText = s.get("ticker");
                        currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - a > 10000) {
                        }
                        notification.flags |= 16;
                        if (b2 != null) {
                        }
                        if (!TextUtils.isEmpty(m2.b())) {
                        }
                        if (m2.u() == null) {
                        }
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        int i = -1;
                        if (d(hfVar)) {
                        }
                        notification.extras.putString("eventMessageType", String.valueOf(i));
                        notification.extras.putString("target_package", a(hfVar));
                        if (m2.s() == null) {
                        }
                        a(notification, Integer.parseInt(str));
                        a(notification, a(hfVar));
                        notificationManager.notify(hashCode, notification);
                        h.a().a(context, hashCode, notification);
                        if (b(hfVar)) {
                        }
                        if (d(hfVar)) {
                        }
                        if (Build.VERSION.SDK_INT < 26) {
                        }
                        Pair<Integer, hf> pair = new Pair<>(Integer.valueOf(hashCode), hfVar);
                        linkedList = b;
                        synchronized (linkedList) {
                        }
                    } catch (IllegalArgumentException e5) {
                        e = e5;
                        if (m2 != null) {
                            dvVar = dv.a(context.getApplicationContext());
                            str6 = hfVar.j();
                            str5 = g(hfVar);
                            str4 = m2.b();
                            str3 = "6";
                            dvVar.b(str6, str5, str4, str3);
                        }
                        com.xiaomi.a.a.a.c.a(e);
                        s = m2.s();
                        notification.tickerText = s.get("ticker");
                        currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - a > 10000) {
                        }
                        notification.flags |= 16;
                        if (b2 != null) {
                        }
                        if (!TextUtils.isEmpty(m2.b())) {
                        }
                        if (m2.u() == null) {
                        }
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        int i = -1;
                        if (d(hfVar)) {
                        }
                        notification.extras.putString("eventMessageType", String.valueOf(i));
                        notification.extras.putString("target_package", a(hfVar));
                        if (m2.s() == null) {
                        }
                        a(notification, Integer.parseInt(str));
                        a(notification, a(hfVar));
                        notificationManager.notify(hashCode, notification);
                        h.a().a(context, hashCode, notification);
                        if (b(hfVar)) {
                        }
                        if (d(hfVar)) {
                        }
                        if (Build.VERSION.SDK_INT < 26) {
                        }
                        Pair<Integer, hf> pair = new Pair<>(Integer.valueOf(hashCode), hfVar);
                        linkedList = b;
                        synchronized (linkedList) {
                        }
                    } catch (InvocationTargetException e6) {
                        e = e6;
                        if (m2 != null) {
                            dvVar = dv.a(context.getApplicationContext());
                            str6 = hfVar.j();
                            str5 = g(hfVar);
                            str4 = m2.b();
                            str3 = "7";
                            dvVar.b(str6, str5, str4, str3);
                        }
                        com.xiaomi.a.a.a.c.a(e);
                        s = m2.s();
                        notification.tickerText = s.get("ticker");
                        currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - a > 10000) {
                        }
                        notification.flags |= 16;
                        if (b2 != null) {
                        }
                        if (!TextUtils.isEmpty(m2.b())) {
                        }
                        if (m2.u() == null) {
                        }
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        int i = -1;
                        if (d(hfVar)) {
                        }
                        notification.extras.putString("eventMessageType", String.valueOf(i));
                        notification.extras.putString("target_package", a(hfVar));
                        if (m2.s() == null) {
                        }
                        a(notification, Integer.parseInt(str));
                        a(notification, a(hfVar));
                        notificationManager.notify(hashCode, notification);
                        h.a().a(context, hashCode, notification);
                        if (b(hfVar)) {
                        }
                        if (d(hfVar)) {
                        }
                        if (Build.VERSION.SDK_INT < 26) {
                        }
                        Pair<Integer, hf> pair = new Pair<>(Integer.valueOf(hashCode), hfVar);
                        linkedList = b;
                        synchronized (linkedList) {
                        }
                    }
                    s = m2.s();
                    if (s != null && s.containsKey("ticker")) {
                        notification.tickerText = s.get("ticker");
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - a > 10000) {
                        a = currentTimeMillis;
                        int i2 = m2.f;
                        if (e(context, a(hfVar))) {
                            i2 = c(context, a(hfVar));
                        }
                        notification.defaults = i2;
                        if (!(s == null || (i2 & 1) == 0)) {
                            String str8 = s.get("sound_uri");
                            if (!TextUtils.isEmpty(str8)) {
                                if (str8.startsWith("android.resource://" + a(hfVar))) {
                                    notification.defaults = i2 ^ 1;
                                    notification.sound = Uri.parse(str8);
                                }
                            }
                        }
                    }
                    notification.flags |= 16;
                    if (b2 != null) {
                        notification.contentView = b2;
                    }
                }
                if (it.a() && Build.VERSION.SDK_INT >= 19) {
                    if (!TextUtils.isEmpty(m2.b())) {
                        notification.extras.putString("message_id", m2.b());
                    }
                    str2 = m2.u() == null ? null : m2.u().get("score_info");
                    if (!TextUtils.isEmpty(str2)) {
                        notification.extras.putString("score_info", str2);
                    }
                    int i = -1;
                    if (d(hfVar)) {
                        i = 1000;
                    } else if (b(hfVar)) {
                        i = 3000;
                    }
                    notification.extras.putString("eventMessageType", String.valueOf(i));
                    notification.extras.putString("target_package", a(hfVar));
                }
                str = m2.s() == null ? null : m2.s().get("message_count");
                if (it.a() && str != null) {
                    a(notification, Integer.parseInt(str));
                }
                if (!it.e() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                    a(notification, a(hfVar));
                }
                notificationManager.notify(hashCode, notification);
                if (it.a() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                    h.a().a(context, hashCode, notification);
                }
                if (b(hfVar)) {
                    dv.a(context.getApplicationContext()).a(hfVar.j(), g(hfVar), m2.b(), 3002, null);
                }
                if (d(hfVar)) {
                    dv.a(context.getApplicationContext()).a(hfVar.j(), g(hfVar), m2.b(), 1002, null);
                }
                if (Build.VERSION.SDK_INT < 26) {
                    com.xiaomi.push.j a5 = com.xiaomi.push.j.a(context);
                    a5.a(hashCode);
                    int b3 = b(m2.s());
                    if (b3 > 0) {
                        a5.b(new c(hashCode, notificationManager), b3);
                    }
                }
                Pair<Integer, hf> pair = new Pair<>(Integer.valueOf(hashCode), hfVar);
                linkedList = b;
                synchronized (linkedList) {
                    linkedList.add(pair);
                    if (linkedList.size() > 100) {
                        linkedList.remove();
                    }
                }
                return cVar;
            }
        }
        com.xiaomi.a.a.a.c.a(str7);
        return cVar;
    }

    private static String a(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? eu.g(context, str) : map.get("channel_name");
    }

    static String a(hf hfVar) {
        gv m;
        if (!(!"com.xiaomi.xmsf".equals(hfVar.f) || (m = hfVar.m()) == null || m.s() == null)) {
            String str = m.s().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hfVar.f;
    }

    private static void a(Notification notification, int i) {
        Object a2 = ac.a(notification, "extraNotification");
        if (a2 != null) {
            ac.a(a2, "setMessageCount", Integer.valueOf(i));
        }
    }

    public static void a(Context context, String str, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        int hashCode = ((str.hashCode() / 10) * 10) + i;
        LinkedList linkedList = new LinkedList();
        if (i >= 0) {
            notificationManager.cancel(hashCode);
        }
        LinkedList<Pair<Integer, hf>> linkedList2 = b;
        synchronized (linkedList2) {
            Iterator<Pair<Integer, hf>> it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                Pair<Integer, hf> next = it2.next();
                hf hfVar = (hf) next.second;
                if (hfVar != null) {
                    String a2 = a(hfVar);
                    if (i >= 0) {
                        if (hashCode == ((Integer) next.first).intValue()) {
                            if (!TextUtils.equals(a2, str)) {
                            }
                        }
                    } else if (i == -1 && TextUtils.equals(a2, str)) {
                        notificationManager.cancel(((Integer) next.first).intValue());
                    }
                    linkedList.add(next);
                }
            }
            LinkedList<Pair<Integer, hf>> linkedList3 = b;
            if (linkedList3 != null) {
                linkedList3.removeAll(linkedList);
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            LinkedList linkedList = new LinkedList();
            LinkedList<Pair<Integer, hf>> linkedList2 = b;
            synchronized (linkedList2) {
                Iterator<Pair<Integer, hf>> it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    Pair<Integer, hf> next = it2.next();
                    hf hfVar = (hf) next.second;
                    if (hfVar != null) {
                        String a2 = a(hfVar);
                        gv m = hfVar.m();
                        if (m != null) {
                            if (TextUtils.equals(a2, str)) {
                                String h = m.h();
                                String j = m.j();
                                if (!TextUtils.isEmpty(h) && !TextUtils.isEmpty(j) && a(str2, h) && a(str3, j)) {
                                    notificationManager.cancel(((Integer) next.first).intValue());
                                    linkedList.add(next);
                                }
                            }
                        }
                    }
                }
                LinkedList<Pair<Integer, hf>> linkedList3 = b;
                if (linkedList3 != null) {
                    linkedList3.removeAll(linkedList);
                    a(context, linkedList);
                }
            }
        }
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            ak.a(context, "category_clear_notification", "clear_notification", (long) linkedList.size(), "");
        }
    }

    private static void a(Object obj, Map<String, String> map) {
        if (map != null && !TextUtils.isEmpty(map.get("channel_description"))) {
            ac.a(obj, "setDescription", map.get("channel_description"));
        }
    }

    public static boolean a(Context context, String str) {
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

    private static boolean a(gv gvVar) {
        if (gvVar == null) {
            return false;
        }
        String b2 = gvVar.b();
        return !TextUtils.isEmpty(b2) && b2.length() == 22 && "satuigmo".indexOf(b2.charAt(0)) >= 0;
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    public static boolean a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0072, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004f, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0074;
     */
    private static String[] a(Context context, gv gvVar) {
        String str;
        String h = gvVar.h();
        String j = gvVar.j();
        Map<String, String> s = gvVar.s();
        if (s != null) {
            int intValue = Float.valueOf((((float) context.getResources().getDisplayMetrics().widthPixels) / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (intValue <= 320) {
                String str2 = s.get("title_short");
                if (!TextUtils.isEmpty(str2)) {
                    h = str2;
                }
                str = s.get("description_short");
            } else if (intValue > 360) {
                String str3 = s.get("title_long");
                if (!TextUtils.isEmpty(str3)) {
                    h = str3;
                }
                str = s.get("description_long");
            }
            j = str;
        }
        return new String[]{h, j};
    }

    private static int b(Map<String, String> map) {
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

    /* JADX WARNING: Removed duplicated region for block: B:74:0x013f  */
    private static Intent b(Context context, String str, int i, Map<String, String> map) {
        Intent intent;
        Intent intent2;
        StringBuilder sb;
        String str2;
        MalformedURLException e;
        URISyntaxException e2;
        String str3 = map.get(i < 2 ? "notification_style_button_left_notify_effect" : i < 3 ? "notification_style_button_mid_notify_effect" : "notification_style_button_right_notify_effect");
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        if (u.a.equals(str3)) {
            try {
                intent = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e3) {
                com.xiaomi.a.a.a.c.d("Cause: " + e3.getMessage());
            }
        } else {
            if (u.b.equals(str3)) {
                String str4 = i < 2 ? "notification_style_button_left_intent_uri" : i < 3 ? "notification_style_button_mid_intent_uri" : "notification_style_button_right_intent_uri";
                String str5 = i < 2 ? "notification_style_button_left_intent_class" : i < 3 ? "notification_style_button_mid_intent_class" : "notification_style_button_right_intent_class";
                if (map.containsKey(str4)) {
                    String str6 = map.get(str4);
                    if (str6 != null) {
                        try {
                            intent2 = Intent.parseUri(str6, 1);
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
                            str2 = e2.getMessage();
                            sb.append(str2);
                            com.xiaomi.a.a.a.c.d(sb.toString());
                            intent = intent2;
                            if (intent != null) {
                            }
                            return null;
                        }
                    } else {
                        intent2 = null;
                    }
                } else {
                    if (map.containsKey(str5)) {
                        Intent intent3 = new Intent();
                        intent3.setComponent(new ComponentName(str, map.get(str5)));
                        intent = intent3;
                    }
                    intent = null;
                }
            } else {
                if (u.c.equals(str3)) {
                    String str7 = map.get(i < 2 ? "notification_style_button_left_web_uri" : i < 3 ? "notification_style_button_mid_web_uri" : "notification_style_button_right_web_uri");
                    if (!TextUtils.isEmpty(str7)) {
                        String trim = str7.trim();
                        if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                            trim = "http://" + trim;
                        }
                        try {
                            String protocol = new URL(trim).getProtocol();
                            if ("http".equals(protocol) || "https".equals(protocol)) {
                                intent2 = new Intent("android.intent.action.VIEW");
                                try {
                                    intent2.setData(Uri.parse(trim));
                                    k.a(context, intent2);
                                } catch (MalformedURLException e6) {
                                    e = e6;
                                }
                            }
                        } catch (MalformedURLException e7) {
                            e = e7;
                            intent2 = null;
                            sb = new StringBuilder();
                            sb.append("Cause: ");
                            str2 = e.getMessage();
                            sb.append(str2);
                            com.xiaomi.a.a.a.c.d(sb.toString());
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
                com.xiaomi.a.a.a.c.d("Cause: " + e8.getMessage());
            }
        }
        return null;
    }

    private static RemoteViews b(Context context, hf hfVar, byte[] bArr) {
        gv m = hfVar.m();
        String a2 = a(hfVar);
        Map<String, String> s = m.s();
        if (s == null) {
            return null;
        }
        String str = s.get("layout_name");
        String str2 = s.get("layout_value");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a2);
                int identifier = resourcesForApplication.getIdentifier(str, "layout", a2);
                if (identifier == 0) {
                    return null;
                }
                RemoteViews remoteViews = new RemoteViews(a2, identifier);
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (jSONObject.has("text")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            String string = jSONObject2.getString(next);
                            int identifier2 = resourcesForApplication.getIdentifier(next, "id", a2);
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
                            int identifier3 = resourcesForApplication.getIdentifier(next2, "id", a2);
                            int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", a2);
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
                            int identifier5 = resourcesForApplication.getIdentifier(next3, "id", a2);
                            if (identifier5 > 0) {
                                remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                            }
                        }
                    }
                    return remoteViews;
                } catch (JSONException e) {
                    com.xiaomi.a.a.a.c.a(e);
                    return null;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                com.xiaomi.a.a.a.c.a(e2);
            }
        }
        return null;
    }

    public static void b(Context context, String str) {
        a(context, str, -1);
    }

    static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    public static boolean b(hf hfVar) {
        gv m = hfVar.m();
        return a(m) && m.w();
    }

    static int c(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    private static int c(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            com.xiaomi.a.a.a.c.c("importance=3");
            return Integer.parseInt(str);
        } catch (Exception e) {
            com.xiaomi.a.a.a.c.d("parsing channel importance error: " + e);
            return 3;
        }
    }

    public static boolean c(hf hfVar) {
        gv m = hfVar.m();
        return a(m) && m.h == 1 && !b(hfVar);
    }

    private static int d(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            com.xiaomi.a.a.a.c.c("priority=" + str);
            return Integer.parseInt(str);
        } catch (Exception e) {
            com.xiaomi.a.a.a.c.d("parsing notification priority error: " + e);
            return 0;
        }
    }

    static void d(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static boolean d(hf hfVar) {
        gv m = hfVar.m();
        return a(m) && m.h == 0 && !b(hfVar);
    }

    static boolean e(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    public static boolean e(hf hfVar) {
        return hfVar.a() == gi.Registration;
    }

    private static int f(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return (a2 != 0 || Build.VERSION.SDK_INT < 9) ? a2 : context.getApplicationInfo().logo;
    }

    public static boolean f(hf hfVar) {
        return b(hfVar) || d(hfVar) || c(hfVar);
    }

    public static String g(hf hfVar) {
        return b(hfVar) ? "E100002" : d(hfVar) ? "E100000" : c(hfVar) ? "E100001" : e(hfVar) ? "E100003" : "";
    }
}
