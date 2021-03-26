package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ac;
import com.xiaomi.push.gn;
import com.xiaomi.push.it;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class h {
    private static h a = new h();

    private class a {
        List<b> a;
        List<b> b;

        private a() {
            this.a = new ArrayList();
            this.b = new ArrayList();
        }
    }

    private class b {
        int a;
        Notification b;

        public b(int i, Notification notification) {
            this.a = i;
            this.b = notification;
        }

        public String toString() {
            return "id:" + this.a;
        }
    }

    private h() {
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    public static h a() {
        return a;
    }

    private String a(Notification notification) {
        if (notification == null || notification.extras == null) {
            return null;
        }
        return notification.extras.getString("push_src_group_name");
    }

    private void a(NotificationManager notificationManager, String str, String str2) {
        c.b("group cancel summary:" + str2);
        notificationManager.cancel(a(str, str2));
    }

    private void a(Context context, int i, Notification notification, boolean z) {
        String str;
        NotificationManager c = c(context);
        StatusBarNotification[] a2 = a(c);
        if (a2 == null) {
            str = "group auto not get notifications";
        } else {
            String a3 = k.a(notification);
            if (TextUtils.isEmpty(a3)) {
                str = "group auto not extract pkg from notification:" + i;
            } else {
                String b2 = b(notification);
                HashMap hashMap = new HashMap();
                for (StatusBarNotification statusBarNotification : a2) {
                    Notification notification2 = statusBarNotification.getNotification();
                    if (!(notification2 == null || !a3.equals(k.a(notification2)) || statusBarNotification.getId() == i)) {
                        a(hashMap, statusBarNotification);
                    }
                }
                for (Map.Entry<String, a> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        a value = entry.getValue();
                        if (z && key.equals(b2) && !d(notification)) {
                            (c(notification) ? value.b : value.a).add(new b(i, notification));
                        }
                        int size = value.a.size();
                        if (value.b.size() <= 0) {
                            if (size >= 2) {
                                a(context, c, a3, key);
                            }
                        } else if (size <= 0) {
                            a(c, a3, key);
                        } else if (size >= 2 && !a(context)) {
                            b bVar = value.b.get(0);
                            c.b("group refresh:" + bVar);
                            bVar.b.when = System.currentTimeMillis();
                            c.notify(bVar.a, bVar.b);
                        }
                    }
                }
                return;
            }
        }
        c.a(str);
    }

    private void a(Context context, NotificationManager notificationManager, String str, String str2) {
        Notification.Builder builder;
        try {
            if (TextUtils.isEmpty(str2)) {
                c.a("group show summary group is null");
                return;
            }
            int a2 = k.a(context, str);
            if (a2 == 0) {
                c.a("group show summary not get icon from " + str);
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                if (notificationManager.getNotificationChannel("groupSummary") == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("groupSummary", "group_summary", 3));
                }
                builder = new Notification.Builder(context, "groupSummary");
            } else {
                builder = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            Notification build = builder.setContentTitle("GroupSummary").setContentText("GroupSummary").setSmallIcon(Icon.createWithResource(str, a2)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (!it.e() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                k.a(build, str);
            }
            int a3 = a(str, str2);
            notificationManager.notify(a3, build);
            c.b("group show summary notify:" + a3);
        } catch (Exception e) {
            c.a("group show summary error " + e);
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String b2 = b(statusBarNotification.getNotification());
        a aVar = map.get(b2);
        if (aVar == null) {
            aVar = new a();
            map.put(b2, aVar);
        }
        (c(statusBarNotification.getNotification()) ? aVar.b : aVar.a).add(new b(statusBarNotification.getId(), statusBarNotification.getNotification()));
    }

    private boolean a(Context context) {
        b(context);
        return false;
    }

    private StatusBarNotification[] a(NotificationManager notificationManager) {
        StatusBarNotification[] activeNotifications = notificationManager != null ? notificationManager.getActiveNotifications() : null;
        if (activeNotifications == null || activeNotifications.length == 0) {
            return null;
        }
        return activeNotifications;
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return d(notification) ? a(notification) : notification.getGroup();
    }

    private void b(Context context, int i, Notification notification) {
        String str;
        NotificationManager c = c(context);
        StatusBarNotification[] a2 = a(c);
        if (a2 == null) {
            str = "group restore not get notifications";
        } else {
            String a3 = k.a(notification);
            if (TextUtils.isEmpty(a3)) {
                str = "group restore not extract pkg from notification:" + i;
            } else {
                String b2 = b(notification);
                for (StatusBarNotification statusBarNotification : a2) {
                    Notification notification2 = statusBarNotification.getNotification();
                    if (notification2 != null && a3.equals(k.a(notification2)) && d(notification2) && statusBarNotification.getId() != i) {
                        Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                        recoverBuilder.setGroup(b2);
                        c.notify(statusBarNotification.getId(), recoverBuilder.build());
                        c.b("group restore notification:" + statusBarNotification.getId());
                    }
                }
                return;
            }
        }
        c.a(str);
    }

    private boolean b() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private boolean b(Context context) {
        return l.a(context).a(gn.NotificationAutoGroupSwitch.a(), true);
    }

    private NotificationManager c(Context context) {
        return (NotificationManager) context.getSystemService("notification");
    }

    private boolean c(Notification notification) {
        if (notification == null) {
            return false;
        }
        Object a2 = ac.a(notification, "isGroupSummary", (Object[]) null);
        if (a2 instanceof Boolean) {
            return ((Boolean) a2).booleanValue();
        }
        return false;
    }

    private boolean d(Notification notification) {
        if (notification == null || notification.getGroup() == null || notification.extras == null) {
            return false;
        }
        long j = notification.extras.getLong("push_src_group_time");
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(j), a(notification)));
    }

    public String a(Context context, Notification.Builder builder, String str) {
        if (!b() || !a(context)) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle extras = builder.getExtras();
        extras.putString("push_src_group_name", str);
        extras.putLong("push_src_group_time", currentTimeMillis);
        return String.format("pushmask_%s_%s", Long.valueOf(currentTimeMillis), str);
    }

    public void a(Context context, int i, Notification notification) {
        if (b()) {
            if (a(context)) {
                try {
                    b(context, i, notification);
                } catch (Exception e) {
                    c.a("group notify handle restore error " + e);
                }
            }
            if (b(context)) {
                try {
                    a(context, i, notification, true);
                } catch (Exception e2) {
                    c.a("group notify handle auto error " + e2);
                }
            }
        }
    }
}
