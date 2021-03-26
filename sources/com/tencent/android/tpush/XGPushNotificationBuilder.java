package com.tencent.android.tpush;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: ProGuard */
public abstract class XGPushNotificationBuilder {
    public static final String BASIC_NOTIFICATION_BUILDER_TYPE = "basic";
    public static final String CUSTOM_NOTIFICATION_BUILDER_TYPE = "custom";
    protected String A = null;
    private String B = "xg-channle-id";
    private boolean C = false;
    protected String a = "xg-channle-id";
    protected String b = "message";
    protected Integer c = null;
    protected PendingIntent d = null;
    protected RemoteViews e = null;
    protected RemoteViews f = null;
    protected Integer g = null;
    protected PendingIntent h = null;
    protected Integer i = null;
    protected Integer j = null;
    protected Integer k = null;
    protected Integer l = null;
    protected Integer m = null;
    protected Integer n = null;
    protected Integer o = null;
    protected Uri p = null;
    protected CharSequence q = null;
    protected long[] r = null;
    protected Long s = null;
    protected Integer t = null;
    protected Bitmap u = null;
    protected Integer v = null;
    protected String w;
    protected Integer x = null;
    protected Bitmap y = null;
    protected Integer z = null;

    protected abstract void a(JSONObject jSONObject);

    protected abstract void b(JSONObject jSONObject);

    public abstract Pair<Notification, Object> buildNotification(Context context);

    public abstract String getType();

    public void setRunAsSysAndAndBuildSdk26(boolean z2) {
        this.C = z2;
    }

    public void encode(JSONObject jSONObject) {
        a(jSONObject);
        CommonHelper.jsonPut(jSONObject, "audioStringType", this.c);
        CommonHelper.jsonPut(jSONObject, "defaults", this.g);
        CommonHelper.jsonPut(jSONObject, "flags", this.i);
        CommonHelper.jsonPut(jSONObject, "icon", this.j);
        CommonHelper.jsonPut(jSONObject, "iconLevel", this.k);
        CommonHelper.jsonPut(jSONObject, "ledARGB", this.l);
        CommonHelper.jsonPut(jSONObject, "ledOffMS", this.m);
        CommonHelper.jsonPut(jSONObject, "ledOnMS", this.n);
        CommonHelper.jsonPut(jSONObject, "number", this.o);
        CommonHelper.jsonPut(jSONObject, "sound", this.p);
        CommonHelper.jsonPut(jSONObject, "smallIcon", this.t);
        CommonHelper.jsonPut(jSONObject, "notificationLargeIcon", this.v);
        if (this.r != null) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (true) {
                long[] jArr = this.r;
                if (i2 >= jArr.length) {
                    break;
                }
                sb.append(String.valueOf(jArr[i2]));
                if (i2 != this.r.length - 1) {
                    sb.append(",");
                }
                i2++;
            }
            CommonHelper.jsonPut(jSONObject, "vibrate", sb.toString());
        }
        CommonHelper.jsonPut(jSONObject, "notificationId", this.x);
        CommonHelper.jsonPut(jSONObject, "thread_id", this.A);
    }

    public void decode(String str) {
        JSONObject jSONObject = new JSONObject(str);
        b(jSONObject);
        this.c = (Integer) CommonHelper.jsonGet(jSONObject, "audioStringType", null);
        this.g = (Integer) CommonHelper.jsonGet(jSONObject, "defaults", null);
        this.i = (Integer) CommonHelper.jsonGet(jSONObject, "flags", null);
        this.j = (Integer) CommonHelper.jsonGet(jSONObject, "icon", null);
        this.k = (Integer) CommonHelper.jsonGet(jSONObject, "iconLevel", null);
        this.l = (Integer) CommonHelper.jsonGet(jSONObject, "ledARGB", null);
        this.m = (Integer) CommonHelper.jsonGet(jSONObject, "ledOffMS", null);
        this.n = (Integer) CommonHelper.jsonGet(jSONObject, "ledOnMS", null);
        this.o = (Integer) CommonHelper.jsonGet(jSONObject, "number", null);
        String str2 = (String) CommonHelper.jsonGet(jSONObject, "sound", null);
        this.t = (Integer) CommonHelper.jsonGet(jSONObject, "smallIcon", null);
        this.v = (Integer) CommonHelper.jsonGet(jSONObject, "notificationLargeIcon", null);
        if (str2 != null) {
            this.p = Uri.parse(str2);
        }
        String str3 = (String) CommonHelper.jsonGet(jSONObject, "vibrate", null);
        if (str3 != null) {
            String[] split = str3.split(",");
            int length = split.length;
            this.r = new long[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    this.r[i2] = Long.valueOf(split[i2]).longValue();
                } catch (NumberFormatException e2) {
                    TLogger.w("XGPushNotificationBuilder", "parse vibrate str error " + e2.toString());
                }
            }
        }
        this.x = (Integer) CommonHelper.jsonGet(jSONObject, "notificationId", null);
        this.A = (String) CommonHelper.jsonGet(jSONObject, "thread_id", null);
    }

    public String getThread_id() {
        return this.A;
    }

    public void setThread_id(String str) {
        this.A = str;
    }

    public String getTitle(Context context) {
        if (this.w == null) {
            this.w = (String) context.getApplicationContext().getPackageManager().getApplicationLabel(context.getApplicationInfo());
        }
        return this.w;
    }

    public void setTitle(String str) {
        this.w = str;
    }

    public String getChannelId(Context context) {
        String notificationChannelID;
        if (!this.a.equals("xg-channle-id") || (notificationChannelID = XGPushConfig.getNotificationChannelID(context)) == null || TextUtils.isEmpty(notificationChannelID)) {
            return this.a;
        }
        return notificationChannelID;
    }

    public String getCurrentChannelId() {
        String str = this.B;
        return (str == null || str.length() <= 0) ? "xg-channle-id" : this.B;
    }

    public void setChannelId(String str) {
        this.a = str;
    }

    public String getChannelName(Context context) {
        String notificationChannelName;
        if (!this.b.equals("message") || (notificationChannelName = XGPushConfig.getNotificationChannelName(context)) == null || TextUtils.isEmpty(notificationChannelName)) {
            return this.b;
        }
        return notificationChannelName;
    }

    public void setChannelName(String str) {
        this.b = str;
    }

    private int b(Context context) {
        int i2 = SharePrefsUtil.getInt(context, "tpush.sound.channel.count", 0);
        SharePrefsUtil.setInt(context, "tpush.sound.channel.count", i2 + 1);
        return i2;
    }

    public int getApplicationIcon(Context context) {
        return context.getApplicationInfo().icon;
    }

    public Pair<Notification, Object> getChannelNotification(Context context) {
        Notification.Builder builder = new Notification.Builder(context);
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        Integer num = this.t;
        if (num != null) {
            builder.setSmallIcon(num.intValue());
        }
        Integer num2 = this.z;
        if (num2 != null && num2.intValue() > 0) {
            builder.setColor(this.z.intValue());
        }
        if (this.v != null) {
            try {
                builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), this.v.intValue()));
            } catch (OutOfMemoryError e2) {
                TLogger.w("XGPushNotificationBuilder", "getChannelNotification setLargeIcon res oom " + e2.toString());
            }
        }
        Bitmap bitmap = this.u;
        if (bitmap != null) {
            builder.setLargeIcon(bitmap);
        }
        CharSequence charSequence = this.w;
        if (charSequence == null) {
            this.w = getTitle(context);
        } else {
            builder.setContentTitle(charSequence);
        }
        CharSequence charSequence2 = this.q;
        if (charSequence2 == null || this.e != null) {
            builder.setContentText(charSequence2);
            builder.setTicker(this.q);
        } else {
            bigTextStyle.bigText(charSequence2);
            builder.setStyle(bigTextStyle);
            builder.setContentText(this.q);
            builder.setTicker(this.q);
        }
        if (this.y != null) {
            try {
                builder.setStyle(new Notification.BigPictureStyle().bigPicture(this.y));
            } catch (Throwable th) {
                TLogger.w("XGPushNotificationBuilder", "getChannelNotification setStyle error " + th.toString());
            }
        }
        String str = this.A;
        if (str != null) {
            builder.setGroup(str);
        }
        return new Pair<>(builder.build(), a(builder, context));
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x02f8 A[Catch:{ all -> 0x03a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x034d A[Catch:{ all -> 0x03a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0372 A[Catch:{ all -> 0x03a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0381 A[Catch:{ all -> 0x03a2 }] */
    private Object a(Notification.Builder builder, Context context) {
        Object obj;
        Throwable th;
        Object obj2;
        Integer num;
        Uri uri;
        Throwable th2;
        Class<?> cls;
        String str = "xg-channle-id";
        try {
            String channelId = getChannelId(context);
            if (channelId.equals(str)) {
                try {
                    cls = Class.forName("android.media.AudioAttributes");
                    Constructor<?> constructor = Class.forName("android.app.NotificationChannel").getConstructor(String.class, CharSequence.class, Integer.TYPE);
                    if (this.g == null) {
                        this.g = 0;
                    }
                    switch (this.g.intValue()) {
                        case 0:
                            str = "xg-n-channle-id";
                            break;
                        case 1:
                            str = "xg-s-channle-id";
                            break;
                        case 2:
                            str = "xg-v-channle-id";
                            break;
                        case 3:
                            str = "xg-s-v-channle-id";
                            break;
                        case 4:
                            str = "xg-l-channle-id";
                            break;
                        case 5:
                            str = "xg-s-l-channle-id";
                            break;
                        case 6:
                            str = "xg-l-v-channle-id";
                            break;
                        case 7:
                            break;
                        default:
                            str = channelId;
                            break;
                    }
                    if (this.p != null) {
                        str = getChannelId(context) + "-" + b(context);
                    }
                    TLogger.i("XGPushNotificationBuilder", "XGPushNotification create notificationChannle, channelId:" + str + ", channelName:" + getChannelName(context));
                    obj2 = constructor.newInstance(str, getChannelName(context), 4);
                } catch (Throwable th3) {
                    th = th3;
                    obj = null;
                    TLogger.ee("XGPushNotificationBuilder", "XGPushNotification create channel Error: " + th.getMessage());
                    th.printStackTrace();
                    return obj;
                }
                try {
                    Method method = obj2.getClass().getMethod("setSound", Uri.class, cls);
                    Method method2 = obj2.getClass().getMethod("enableVibration", Boolean.TYPE);
                    Method method3 = obj2.getClass().getMethod("enableLights", Boolean.TYPE);
                    switch (this.g.intValue()) {
                        case 0:
                            method.invoke(obj2, null, null);
                            method2.invoke(obj2, false);
                            method3.invoke(obj2, false);
                            break;
                        case 1:
                            method2.invoke(obj2, false);
                            method3.invoke(obj2, false);
                            break;
                        case 2:
                            method.invoke(obj2, null, null);
                            method2.invoke(obj2, true);
                            method3.invoke(obj2, false);
                            break;
                        case 3:
                            method2.invoke(obj2, true);
                            method3.invoke(obj2, false);
                            break;
                        case 4:
                            method.invoke(obj2, null, null);
                            method2.invoke(obj2, false);
                            method3.invoke(obj2, true);
                            break;
                        case 5:
                            method2.invoke(obj2, false);
                            method3.invoke(obj2, true);
                            break;
                        case 6:
                            method.invoke(obj2, null, null);
                            method2.invoke(obj2, true);
                            method3.invoke(obj2, true);
                            break;
                        case 7:
                            method2.invoke(obj2, true);
                            method3.invoke(obj2, true);
                            break;
                    }
                    Uri uri2 = this.p;
                    if (uri2 != null) {
                        method.invoke(obj2, uri2, null);
                    }
                    builder.getClass().getMethod("setChannelId", String.class).invoke(builder, str);
                    this.B = str;
                    return obj2;
                } catch (Throwable th4) {
                    th = th4;
                    obj = obj2;
                    TLogger.ee("XGPushNotificationBuilder", "XGPushNotification create channel Error: " + th.getMessage());
                    th.printStackTrace();
                    return obj;
                }
            } else {
                TLogger.i("XGPushNotificationBuilder", "XGPushNotification create notificationChannle has channelId:" + channelId);
                try {
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                    obj = notificationManager.getClass().getMethod("getNotificationChannel", String.class).invoke(notificationManager, this.a);
                    try {
                        this.B = this.a;
                        if (obj != null) {
                            TLogger.ii("XGPushNotificationBuilder", "Use old notificationChannel id:" + this.a);
                            builder.getClass().getMethod("setChannelId", String.class).invoke(builder, this.a);
                            return obj;
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        try {
                            TLogger.ee("XGPushNotificationBuilder", "XGPushNotification getNotificationChannel Error: " + th2.getMessage());
                            th2.printStackTrace();
                            Class<?> cls2 = Class.forName("android.media.AudioAttributes");
                            obj = Class.forName("android.app.NotificationChannel").getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance(channelId, getChannelName(context), 4);
                            Method method4 = obj.getClass().getMethod("setSound", Uri.class, cls2);
                            Method method5 = obj.getClass().getMethod("enableVibration", Boolean.TYPE);
                            Method method6 = obj.getClass().getMethod("enableLights", Boolean.TYPE);
                            num = this.g;
                            if (num != null) {
                            }
                            if (this.i != null) {
                            }
                            uri = this.p;
                            if (uri != null) {
                            }
                            builder.getClass().getMethod("setChannelId", String.class).invoke(builder, channelId);
                        } catch (Throwable th6) {
                            th = th6;
                            TLogger.ee("XGPushNotificationBuilder", "XGPushNotification create channel Error: " + th.getMessage());
                            th.printStackTrace();
                            return obj;
                        }
                        return obj;
                    }
                } catch (Throwable th7) {
                    th2 = th7;
                    obj = null;
                    TLogger.ee("XGPushNotificationBuilder", "XGPushNotification getNotificationChannel Error: " + th2.getMessage());
                    th2.printStackTrace();
                    Class<?> cls2 = Class.forName("android.media.AudioAttributes");
                    obj = Class.forName("android.app.NotificationChannel").getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance(channelId, getChannelName(context), 4);
                    Method method4 = obj.getClass().getMethod("setSound", Uri.class, cls2);
                    Method method5 = obj.getClass().getMethod("enableVibration", Boolean.TYPE);
                    Method method6 = obj.getClass().getMethod("enableLights", Boolean.TYPE);
                    num = this.g;
                    if (num != null) {
                    }
                    if (this.i != null) {
                    }
                    uri = this.p;
                    if (uri != null) {
                    }
                    builder.getClass().getMethod("setChannelId", String.class).invoke(builder, channelId);
                    return obj;
                }
                Class<?> cls2 = Class.forName("android.media.AudioAttributes");
                obj = Class.forName("android.app.NotificationChannel").getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance(channelId, getChannelName(context), 4);
                Method method4 = obj.getClass().getMethod("setSound", Uri.class, cls2);
                Method method5 = obj.getClass().getMethod("enableVibration", Boolean.TYPE);
                Method method6 = obj.getClass().getMethod("enableLights", Boolean.TYPE);
                num = this.g;
                if (num != null) {
                    if ((num.intValue() & 1) != 1) {
                        method4.invoke(obj, null, null);
                    }
                    if ((this.g.intValue() & 2) == 2) {
                        method5.invoke(obj, true);
                    } else {
                        method5.invoke(obj, false);
                    }
                    if ((this.g.intValue() & 4) == 4) {
                        method6.invoke(obj, true);
                    } else {
                        method6.invoke(obj, false);
                    }
                } else {
                    method4.invoke(obj, null, null);
                    method5.invoke(obj, false);
                    method6.invoke(obj, false);
                }
                if (this.i != null) {
                    method6.invoke(obj, true);
                }
                uri = this.p;
                if (uri != null) {
                    method4.invoke(obj, uri, null);
                }
                builder.getClass().getMethod("setChannelId", String.class).invoke(builder, channelId);
                return obj;
            }
        } catch (Throwable th8) {
            th = th8;
            obj2 = null;
            obj = obj2;
            TLogger.ee("XGPushNotificationBuilder", "XGPushNotification create channel Error: " + th.getMessage());
            th.printStackTrace();
            return obj;
        }
    }

    public static void createNotificationChannel(Context context, Object obj) {
        TLogger.d("XGPushNotificationBuilder", "createNotificationChannel");
        if (obj != null) {
            try {
                Class<?> cls = Class.forName("android.app.NotificationChannel");
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                notificationManager.getClass().getMethod("createNotificationChannel", cls).invoke(notificationManager, obj);
            } catch (Throwable th) {
                TLogger.ee("XGPushNotificationBuilder", "XGPushNotification createNotificationChannel Error: ", th);
            }
        }
    }

    private Notification c(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        Integer num = this.t;
        if (num != null) {
            builder.setSmallIcon(num.intValue());
        }
        Integer num2 = this.z;
        if (num2 != null && num2.intValue() > 0) {
            builder.setColor(this.z.intValue());
        }
        if (this.v != null) {
            try {
                builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), this.v.intValue()));
            } catch (OutOfMemoryError e2) {
                TLogger.w("XGPushNotificationBuilder", "getNotificationCompatBuilder setLargeIcon res oom " + e2.toString());
            }
        }
        Bitmap bitmap = this.u;
        if (bitmap != null) {
            builder.setLargeIcon(bitmap);
        }
        String str = this.w;
        if (str == null) {
            this.w = getTitle(context);
        } else {
            builder.setContentTitle(str);
        }
        CharSequence charSequence = this.q;
        if (charSequence == null || this.e != null) {
            builder.setContentText(charSequence);
            builder.setTicker(this.q);
        } else {
            bigTextStyle.bigText(charSequence);
            builder.setStyle(bigTextStyle);
            builder.setContentText(this.q);
            builder.setTicker(this.q);
        }
        if (this.y != null) {
            try {
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(this.y));
            } catch (Throwable th) {
                TLogger.w("XGPushNotificationBuilder", "getNotificationCompatBuilder setStyle error " + th.toString());
            }
        }
        if (this.A != null && Build.VERSION.SDK_INT >= 24) {
            builder.setGroup(this.A);
        }
        return builder.build();
    }

    protected Pair<Notification, Object> a(Context context) {
        Object obj;
        Notification notification;
        if (this.x == null) {
            this.x = 0;
        }
        TLogger.ii("XGPushNotificationBuilder", "XGPushNotification Build.VERSION.SDK_INT: " + Build.VERSION.SDK_INT + ", targetSDK:" + context.getApplicationInfo().targetSdkVersion);
        if (Build.VERSION.SDK_INT < 26 || (context.getApplicationInfo().targetSdkVersion < 26 && !this.C)) {
            notification = c(context);
            obj = null;
        } else {
            Pair<Notification, Object> channelNotification = getChannelNotification(context);
            notification = (Notification) channelNotification.first;
            obj = channelNotification.second;
        }
        Integer num = this.c;
        if (num != null) {
            notification.audioStreamType = num.intValue();
        }
        PendingIntent pendingIntent = this.d;
        if (pendingIntent != null) {
            notification.contentIntent = pendingIntent;
        }
        if (this.e != null) {
            if ("oppo".equals(Build.MANUFACTURER.trim().toLowerCase())) {
                TLogger.ww("XGPushNotificationBuilder", "XGPushNotification: Oppo Rom not allow custom contentview. Not set it");
            } else {
                notification.contentView = this.e;
            }
        }
        Integer num2 = this.g;
        if (num2 != null) {
            notification.defaults = num2.intValue();
        }
        Integer num3 = this.j;
        if (num3 != null) {
            notification.icon = num3.intValue();
        }
        PendingIntent pendingIntent2 = this.h;
        if (pendingIntent2 != null) {
            notification.deleteIntent = pendingIntent2;
        }
        Integer num4 = this.i;
        if (num4 != null) {
            notification.flags = num4.intValue();
        } else {
            notification.flags = 16;
        }
        Integer num5 = this.k;
        if (num5 != null) {
            notification.iconLevel = num5.intValue();
        }
        Integer num6 = this.l;
        if (num6 != null) {
            notification.ledARGB = num6.intValue();
        }
        Integer num7 = this.m;
        if (num7 != null) {
            notification.ledOffMS = num7.intValue();
        }
        Integer num8 = this.n;
        if (num8 != null) {
            notification.ledOnMS = num8.intValue();
        }
        Integer num9 = this.o;
        if (num9 != null) {
            notification.number = num9.intValue();
        }
        Uri uri = this.p;
        if (uri != null) {
            notification.sound = uri;
        }
        long[] jArr = this.r;
        if (jArr != null) {
            notification.vibrate = jArr;
        }
        Long l2 = this.s;
        if (l2 != null) {
            notification.when = l2.longValue();
        } else {
            notification.when = System.currentTimeMillis();
        }
        return new Pair<>(notification, obj);
    }

    public int getAudioStringType() {
        return this.c.intValue();
    }

    public XGPushNotificationBuilder setAudioStringType(int i2) {
        this.c = Integer.valueOf(i2);
        return this;
    }

    public PendingIntent getContentIntent() {
        return this.d;
    }

    public XGPushNotificationBuilder setContentIntent(PendingIntent pendingIntent) {
        this.d = pendingIntent;
        return this;
    }

    public XGPushNotificationBuilder setContentView(RemoteViews remoteViews) {
        this.e = remoteViews;
        return this;
    }

    public XGPushNotificationBuilder setbigContentView(RemoteViews remoteViews) {
        this.f = remoteViews;
        return this;
    }

    public int getDefaults() {
        return this.g.intValue();
    }

    public XGPushNotificationBuilder setDefaults(int i2) {
        Integer num = this.g;
        if (num == null) {
            this.g = Integer.valueOf(i2);
        } else {
            this.g = Integer.valueOf(i2 | num.intValue());
        }
        return this;
    }

    public int getFlags() {
        return this.i.intValue();
    }

    public XGPushNotificationBuilder setFlags(int i2) {
        Integer num = this.i;
        if (num == null) {
            this.i = Integer.valueOf(i2);
        } else {
            this.i = Integer.valueOf(i2 | num.intValue());
        }
        return this;
    }

    public Integer getIcon() {
        return this.j;
    }

    public XGPushNotificationBuilder setIcon(Integer num) {
        this.j = num;
        return this;
    }

    public Integer getSmallIcon() {
        return this.t;
    }

    public XGPushNotificationBuilder setSmallIcon(Integer num) {
        this.t = num;
        return this;
    }

    public Bitmap getLargeIcon() {
        return this.u;
    }

    public XGPushNotificationBuilder setColor(Integer num) {
        this.z = num;
        return this;
    }

    public Bitmap getRichIcon() {
        return this.y;
    }

    public XGPushNotificationBuilder setLargeIcon(Bitmap bitmap) {
        this.u = bitmap;
        return this;
    }

    public XGPushNotificationBuilder setRichIcon(Bitmap bitmap) {
        this.y = bitmap;
        return this;
    }

    public XGPushNotificationBuilder setNotificationLargeIcon(int i2) {
        this.v = Integer.valueOf(i2);
        return this;
    }

    public Integer getNotificationLargeIcon() {
        return this.v;
    }

    public int getIconLevel() {
        return this.k.intValue();
    }

    public XGPushNotificationBuilder setIconLevel(int i2) {
        this.k = Integer.valueOf(i2);
        return this;
    }

    public int getLedARGB() {
        return this.l.intValue();
    }

    public XGPushNotificationBuilder setLedARGB(int i2) {
        this.l = Integer.valueOf(i2);
        return this;
    }

    public int getLedOffMS() {
        return this.m.intValue();
    }

    public XGPushNotificationBuilder setLedOffMS(int i2) {
        this.m = Integer.valueOf(i2);
        return this;
    }

    public int getLedOnMS() {
        return this.n.intValue();
    }

    public XGPushNotificationBuilder setLedOnMS(int i2) {
        this.n = Integer.valueOf(i2);
        return this;
    }

    public int getNumber() {
        return this.o.intValue();
    }

    public XGPushNotificationBuilder setNumber(int i2) {
        this.o = Integer.valueOf(i2);
        return this;
    }

    public Uri getSound() {
        return this.p;
    }

    public XGPushNotificationBuilder setSound(Uri uri) {
        this.p = uri;
        return this;
    }

    public CharSequence getTickerText() {
        return this.q;
    }

    public XGPushNotificationBuilder setTickerText(CharSequence charSequence) {
        this.q = charSequence;
        return this;
    }

    public long[] getVibrate() {
        return this.r;
    }

    public XGPushNotificationBuilder setVibrate(long[] jArr) {
        this.r = jArr;
        return this;
    }

    public long getWhen() {
        return this.s.longValue();
    }

    public XGPushNotificationBuilder setWhen(long j2) {
        this.s = Long.valueOf(j2);
        return this;
    }
}
