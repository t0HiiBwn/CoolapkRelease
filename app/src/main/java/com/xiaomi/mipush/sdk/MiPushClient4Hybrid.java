package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.bi;
import com.xiaomi.push.ew;
import com.xiaomi.push.g;
import com.xiaomi.push.hc;
import com.xiaomi.push.hm;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hs;
import com.xiaomi.push.i;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.im;
import com.xiaomi.push.l;
import com.xiaomi.push.service.ab;
import com.xiaomi.push.service.aq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MiPushClient4Hybrid {
    private static Map<String, b.a> dataMap = new HashMap();
    private static MiPushCallback sCallback;
    private static Map<String, Long> sRegisterTimeMap = new HashMap();

    public static class MiPushCallback {
        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }
    }

    private static void addPullNotificationTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putLong("last_pull_notification_" + str, System.currentTimeMillis()).commit();
    }

    private static short getDeviceStatus(MiPushMessage miPushMessage, boolean z) {
        String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get("__hybrid_device_status");
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            i = Integer.valueOf(str).intValue();
        }
        if (!z) {
            i = (i & -4) + g.a.NOT_ALLOWED.a();
        }
        return (short) i;
    }

    public static boolean isRegistered(Context context, String str) {
        return b.m75a(context).a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, id idVar) {
        b.a aVar;
        String b = idVar.b();
        if (idVar.a() == 0 && (aVar = dataMap.get(b)) != null) {
            aVar.a(idVar.f771e, idVar.f772f);
            b.m75a(context).a(b, aVar);
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(idVar.f771e)) {
            arrayList = new ArrayList();
            arrayList.add(idVar.f771e);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ew.COMMAND_REGISTER.f419a, arrayList, idVar.f761a, idVar.f770d, null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(b, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, ij ijVar) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ew.COMMAND_UNREGISTER.f419a, null, ijVar.f837a, ijVar.f845d, null);
        String a = ijVar.a();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(a, generateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (b.m75a(context).m80a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            b.a a = b.m75a(context).a(str);
            if (a != null) {
                arrayList.add(a.c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ew.COMMAND_REGISTER.f419a, arrayList, 0, null, null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                ib ibVar = new ib();
                ibVar.b(str2);
                ibVar.c(hm.PullOfflineMessage.f576a);
                ibVar.a(aq.a());
                ibVar.a(false);
                ak.a(context).a(ibVar, hc.Notification, false, true, null, false, str, str2);
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0)) < 5000) {
            com.xiaomi.channel.commonutils.logger.b.m41a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
        String a2 = bi.a(6);
        b.a aVar = new b.a(context);
        aVar.c(str2, str3, a2);
        dataMap.put(str, aVar);
        ic icVar = new ic();
        icVar.a(aq.a());
        icVar.b(str2);
        icVar.e(str3);
        icVar.d(str);
        icVar.f(a2);
        icVar.c(g.m356a(context, context.getPackageName()));
        icVar.b(g.a(context, context.getPackageName()));
        icVar.h("3_7_9");
        icVar.a(30709);
        icVar.a(hq.Init);
        if (!l.d()) {
            String g = i.g(context);
            if (!TextUtils.isEmpty(g)) {
                icVar.i(bi.a(g));
            }
        }
        int a3 = i.a();
        if (a3 >= 0) {
            icVar.c(a3);
        }
        ib ibVar2 = new ib();
        ibVar2.c(hm.HybridRegister.f576a);
        ibVar2.b(b.m75a(context).m76a());
        ibVar2.d(context.getPackageName());
        ibVar2.a(im.a(icVar));
        ibVar2.a(aq.a());
        ak.a(context).a((ak) ibVar2, hc.Notification, (hp) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        ai.a(context, str);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.channel.commonutils.logger.b.m41a("do not ack message, message is null");
            return;
        }
        try {
            hs hsVar = new hs();
            hsVar.b(b.m75a(context).m76a());
            hsVar.a(miPushMessage.getMessageId());
            hsVar.a(Long.valueOf(miPushMessage.getExtra().get("__hybrid_message_ts")).longValue());
            hsVar.a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                hsVar.c(miPushMessage.getTopic());
            }
            ak.a(context).a((ak) hsVar, hc.AckMessage, false, PushMessageHelper.generateMessage(miPushMessage));
            com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
        } catch (Throwable th) {
            miPushMessage.getExtra().remove("__hybrid_message_ts");
            miPushMessage.getExtra().remove("__hybrid_device_status");
            throw th;
        }
        miPushMessage.getExtra().remove("__hybrid_message_ts");
        miPushMessage.getExtra().remove("__hybrid_device_status");
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    private static boolean shouldPullNotification(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("last_pull_notification_");
        sb.append(str);
        return Math.abs(System.currentTimeMillis() - sharedPreferences.getLong(sb.toString(), -1)) > 300000;
    }

    public static void unregisterPush(Context context, String str) {
        sRegisterTimeMap.remove(str);
        b.a a = b.m75a(context).a(str);
        if (a != null) {
            ii iiVar = new ii();
            iiVar.a(aq.a());
            iiVar.d(str);
            iiVar.b(a.f164a);
            iiVar.c(a.c);
            iiVar.e(a.b);
            ib ibVar = new ib();
            ibVar.c(hm.HybridUnregister.f576a);
            ibVar.b(b.m75a(context).m76a());
            ibVar.d(context.getPackageName());
            ibVar.a(im.a(iiVar));
            ibVar.a(aq.a());
            ak.a(context).a((ak) ibVar, hc.Notification, (hp) null);
            b.m75a(context).b(str);
        }
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        ab.a(context, linkedList);
    }
}
