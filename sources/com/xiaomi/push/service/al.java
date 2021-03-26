package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bd;
import com.xiaomi.push.hh;
import com.xiaomi.push.i;
import com.xiaomi.push.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

public class al {
    private static Context a;

    /* renamed from: a  reason: collision with other field name */
    private static Object f950a;

    /* renamed from: a  reason: collision with other field name */
    private static WeakHashMap<Integer, al> f951a = new WeakHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static boolean f952a;

    /* renamed from: a  reason: collision with other field name */
    private String f953a;

    private al(String str) {
        this.f953a = str;
    }

    private static int a(String str) {
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        try {
            return a.getPackageManager().getPackageUid(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    private static NotificationManager a() {
        return (NotificationManager) a.getSystemService("notification");
    }

    public static al a(Context context, String str) {
        a(context);
        int hashCode = str.hashCode();
        al alVar = f951a.get(Integer.valueOf(hashCode));
        if (alVar != null) {
            return alVar;
        }
        al alVar2 = new al(str);
        f951a.put(Integer.valueOf(hashCode), alVar2);
        return alVar2;
    }

    private static <T> T a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    private static void a(Context context) {
        if (a == null) {
            a = context.getApplicationContext();
            NotificationManager a2 = a();
            Boolean bool = (Boolean) bd.a((Object) a2, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            b("fwk is support.init:" + bool);
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            f952a = booleanValue;
            if (booleanValue) {
                f950a = bd.a((Object) a2, "getService", new Object[0]);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m616a() {
        if (l.m568a() && an.a(a).a(hh.NotificationBelongToAppSwitch.a(), true)) {
            return f952a;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m617a(Context context) {
        a(context);
        return m616a();
    }

    static void b(String str) {
        b.m41a("NMHelper:" + str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public NotificationChannel m618a(String str) {
        try {
            if (!m616a()) {
                return a().getNotificationChannel(str);
            }
            List<NotificationChannel> a2 = m620a();
            if (a2 == null) {
                return null;
            }
            for (NotificationChannel notificationChannel : a2) {
                if (str.equals(notificationChannel.getId())) {
                    return notificationChannel;
                }
            }
            return null;
        } catch (Exception e) {
            b("getNotificationChannel error" + e);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    String m619a(String str) {
        return String.format(m616a() ? "mipush|%s|%s" : "mipush_%s_%s", this.f953a, str);
    }

    String a(String str, String str2) {
        return m616a() ? str : str2;
    }

    /* renamed from: a  reason: collision with other method in class */
    List<NotificationChannel> m620a() {
        String str;
        String str2 = this.f953a;
        List<NotificationChannel> list = null;
        try {
            if (m616a()) {
                int a2 = a(str2);
                if (a2 != -1) {
                    Object obj = f950a;
                    Object[] objArr = {str2, Integer.valueOf(a2), false};
                    str = "mipush|%s|%s";
                    list = (List) a(bd.a(obj, "getNotificationChannelsForPackage", objArr));
                } else {
                    str = null;
                }
            } else {
                list = a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!l.m568a() || list == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            String format = String.format(str, str2, "");
            for (NotificationChannel notificationChannel : list) {
                if (notificationChannel.getId().startsWith(format)) {
                    arrayList.add(notificationChannel);
                }
            }
            return arrayList;
        } catch (Exception e) {
            b("getNotificationChannels error " + e);
            return null;
        }
    }

    void a(int i) {
        String str = this.f953a;
        try {
            if (m616a()) {
                bd.b(f950a, "cancelNotificationWithTag", str, null, Integer.valueOf(i), Integer.valueOf(i.a()));
                b("cancel succ:" + i);
                return;
            }
            a().cancel(i);
        } catch (Exception e) {
            b("cancel error" + e);
        }
    }

    public void a(int i, Notification notification) {
        String str = this.f953a;
        NotificationManager a2 = a();
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (m616a()) {
                if (i2 >= 19) {
                    notification.extras.putString("xmsf_target_package", str);
                }
                if (i2 >= 29) {
                    a2.notifyAsPackage(str, null, i, notification);
                    return;
                }
            }
            a2.notify(i, notification);
        } catch (Exception unused) {
        }
    }

    void a(NotificationChannel notificationChannel) {
        String str = this.f953a;
        try {
            if (m616a()) {
                int a2 = a(str);
                if (a2 != -1) {
                    bd.b(f950a, "createNotificationChannelsForPackage", str, Integer.valueOf(a2), a(Arrays.asList(notificationChannel)));
                    return;
                }
                return;
            }
            a().createNotificationChannel(notificationChannel);
        } catch (Exception e) {
            b("createNotificationChannel error" + e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    void m621a(String str) {
        a().deleteNotificationChannel(str);
    }

    public List<StatusBarNotification> b() {
        Exception e;
        String str = this.f953a;
        NotificationManager a2 = a();
        ArrayList arrayList = null;
        try {
            if (m616a()) {
                int a3 = i.a();
                if (a3 != -1) {
                    return (List) a(bd.a(f950a, "getAppActiveNotifications", str, Integer.valueOf(a3)));
                }
                return null;
            }
            StatusBarNotification[] activeNotifications = a2.getActiveNotifications();
            boolean a4 = l.m568a();
            if (activeNotifications == null || activeNotifications.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (!a4 || str.equals(am.a(statusBarNotification.getNotification()))) {
                        arrayList2.add(statusBarNotification);
                    }
                }
                return arrayList2;
            } catch (Exception e2) {
                e = e2;
                arrayList = arrayList2;
                b("getActiveNotifications error " + e);
                return arrayList;
            }
        } catch (Exception e3) {
            e = e3;
            b("getActiveNotifications error " + e);
            return arrayList;
        }
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f953a + "}";
    }
}
