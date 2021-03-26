package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.bd;
import com.xiaomi.push.hh;
import com.xiaomi.push.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ai {
    private static ai a = new ai();

    private class a {

        /* renamed from: a  reason: collision with other field name */
        List<b> f945a;
        List<b> b;

        private a() {
            this.f945a = new ArrayList();
            this.b = new ArrayList();
        }
    }

    private class b {
        int a;

        /* renamed from: a  reason: collision with other field name */
        Notification f946a;

        public b(int i, Notification notification) {
            this.a = i;
            this.f946a = notification;
        }

        public String toString() {
            return "id:" + this.a;
        }
    }

    private ai() {
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    public static ai a() {
        return a;
    }

    private String a(Notification notification) {
        if (notification == null || notification.extras == null) {
            return null;
        }
        return notification.extras.getString("push_src_group_name");
    }

    private List<StatusBarNotification> a(al alVar) {
        List<StatusBarNotification> b2 = alVar != null ? alVar.b() : null;
        if (b2 == null || b2.size() == 0) {
            return null;
        }
        return b2;
    }

    private void a(Context context, int i, Notification notification, boolean z) {
        String str;
        String a2 = am.a(notification);
        if (TextUtils.isEmpty(a2)) {
            str = "group auto not extract pkg from notification:" + i;
        } else {
            List<StatusBarNotification> a3 = a(al.a(context, a2));
            if (a3 == null) {
                str = "group auto not get notifications";
            } else {
                String b2 = b(notification);
                HashMap hashMap = new HashMap();
                for (StatusBarNotification statusBarNotification : a3) {
                    if (!(statusBarNotification.getNotification() == null || statusBarNotification.getId() == i)) {
                        a(hashMap, statusBarNotification);
                    }
                }
                for (Map.Entry<String, a> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        a value = entry.getValue();
                        if (z && key.equals(b2) && !m615b(notification)) {
                            (m614a(notification) ? value.b : value.f945a).add(new b(i, notification));
                        }
                        int size = value.f945a.size();
                        if (value.b.size() <= 0) {
                            if (z && size >= 2) {
                                a(context, a2, key, value.f945a.get(0).f946a);
                            }
                        } else if (size <= 0) {
                            a(context, a2, key);
                        }
                    }
                }
                return;
            }
        }
        com.xiaomi.channel.commonutils.logger.b.m41a(str);
    }

    private void a(Context context, String str, String str2) {
        com.xiaomi.channel.commonutils.logger.b.b("group cancel summary:" + str2);
        al.a(context, str).a(a(str, str2));
    }

    private void a(Context context, String str, String str2, Notification notification) {
        Notification.Builder builder;
        try {
            if (TextUtils.isEmpty(str2)) {
                com.xiaomi.channel.commonutils.logger.b.m41a("group show summary group is null");
                return;
            }
            int a2 = am.a(context, str);
            if (a2 == 0) {
                com.xiaomi.channel.commonutils.logger.b.m41a("group show summary not get icon from " + str);
                return;
            }
            al a3 = al.a(context, str);
            if (Build.VERSION.SDK_INT >= 26) {
                String a4 = a3.a(notification.getChannelId(), "groupSummary");
                NotificationChannel a5 = a3.m618a(a4);
                if ("groupSummary".equals(a4) && a5 == null) {
                    a3.a(new NotificationChannel(a4, "group_summary", 3));
                }
                builder = new Notification.Builder(context, a4);
            } else {
                builder = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            a(builder, true);
            Notification build = builder.setContentTitle("GroupSummary").setContentText("GroupSummary").setSmallIcon(Icon.createWithResource(str, a2)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (!l.c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                am.a(build, str);
            }
            if (!l.d()) {
                build.extras.putBoolean("miui.showAtTail", true);
            }
            int a6 = a(str, str2);
            a3.a(a6, build);
            com.xiaomi.channel.commonutils.logger.b.b("group show summary notify:" + a6);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m41a("group show summary error " + e);
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String b2 = b(statusBarNotification.getNotification());
        a aVar = map.get(b2);
        if (aVar == null) {
            aVar = new a();
            map.put(b2, aVar);
        }
        (m614a(statusBarNotification.getNotification()) ? aVar.b : aVar.f945a).add(new b(statusBarNotification.getId(), statusBarNotification.getNotification()));
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m613a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private boolean a(Notification.Builder builder, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(z ? 2 : 1);
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.b("not support setGroupAlertBehavior");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m614a(Notification notification) {
        if (notification == null) {
            return false;
        }
        Object a2 = bd.a((Object) notification, "isGroupSummary", (Object[]) null);
        if (a2 instanceof Boolean) {
            return ((Boolean) a2).booleanValue();
        }
        return false;
    }

    private boolean a(Context context) {
        if (b(context) && al.m617a(context)) {
            return an.a(context).a(hh.LatestNotificationNotIntoGroupSwitch.a(), false);
        }
        return false;
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return m615b(notification) ? a(notification) : notification.getGroup();
    }

    private void b(Context context, int i, Notification notification) {
        String str;
        String a2 = am.a(notification);
        if (TextUtils.isEmpty(a2)) {
            str = "group restore not extract pkg from notification:" + i;
        } else {
            al a3 = al.a(context, a2);
            List<StatusBarNotification> a4 = a(a3);
            if (a4 == null) {
                str = "group restore not get notifications";
            } else {
                for (StatusBarNotification statusBarNotification : a4) {
                    Notification notification2 = statusBarNotification.getNotification();
                    if (!(notification2 == null || !m615b(notification2) || statusBarNotification.getId() == i)) {
                        Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                        recoverBuilder.setGroup(a(notification2));
                        a(recoverBuilder, m614a(notification2));
                        a3.a(statusBarNotification.getId(), recoverBuilder.build());
                        com.xiaomi.channel.commonutils.logger.b.b("group restore notification:" + statusBarNotification.getId());
                    }
                }
                return;
            }
        }
        com.xiaomi.channel.commonutils.logger.b.m41a(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m615b(Notification notification) {
        if (notification == null || notification.getGroup() == null || notification.extras == null) {
            return false;
        }
        long j = notification.extras.getLong("push_src_group_time");
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(j), a(notification)));
    }

    private boolean b(Context context) {
        return an.a(context).a(hh.NotificationAutoGroupSwitch.a(), true);
    }

    public String a(Context context, Notification.Builder builder, String str) {
        if (!m613a() || !a(context)) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle extras = builder.getExtras();
        extras.putString("push_src_group_name", str);
        extras.putLong("push_src_group_time", currentTimeMillis);
        return String.format("pushmask_%s_%s", Long.valueOf(currentTimeMillis), str);
    }

    public void a(Context context, int i, Notification notification) {
        if (m613a()) {
            if (a(context)) {
                try {
                    b(context, i, notification);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m41a("group notify handle restore error " + e);
                }
            }
            if (b(context)) {
                try {
                    a(context, i, notification, true);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m41a("group notify handle auto error " + e2);
                }
            }
        }
    }
}
