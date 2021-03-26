package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.ah;
import com.xiaomi.push.ea;
import com.xiaomi.push.eu;
import com.xiaomi.push.gi;
import com.xiaomi.push.gs;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.gx;
import com.xiaomi.push.gz;
import com.xiaomi.push.hi;
import com.xiaomi.push.hj;
import com.xiaomi.push.hk;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import com.xiaomi.push.it;
import com.xiaomi.push.service.o;
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
            i = (i & -4) + eu.a.NOT_ALLOWED.a();
        }
        return (short) i;
    }

    public static boolean isRegistered(Context context, String str) {
        return b.m54a(context).a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, hk hkVar) {
        b.a aVar;
        String k = hkVar.k();
        if (hkVar.f() == 0 && (aVar = dataMap.get(k)) != null) {
            aVar.a(hkVar.g, hkVar.h);
            b.m54a(context).a(k, aVar);
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(hkVar.g)) {
            arrayList = new ArrayList();
            arrayList.add(hkVar.g);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ea.COMMAND_REGISTER.k, arrayList, hkVar.e, hkVar.f, null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(k, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, hq hqVar) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ea.COMMAND_UNREGISTER.k, null, hqVar.e, hqVar.f, null);
        String g = hqVar.g();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(g, generateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (b.m54a(context).m59a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            b.a a = b.m54a(context).a(str);
            if (a != null) {
                arrayList.add(a.c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ea.COMMAND_REGISTER.k, arrayList, 0, null, null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                hi hiVar = new hi();
                hiVar.b(str2);
                hiVar.c(gs.PullOfflineMessage.S);
                hiVar.a(o.a());
                hiVar.a(false);
                aq.a(context).a(hiVar, gi.Notification, false, true, null, false, str, str2);
                c.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0)) < 5000) {
            c.a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
        String a2 = ah.a(6);
        b.a aVar = new b.a(context);
        aVar.c(str2, str3, a2);
        dataMap.put(str, aVar);
        hj hjVar = new hj();
        hjVar.a(o.a());
        hjVar.b(str2);
        hjVar.e(str3);
        hjVar.d(str);
        hjVar.f(a2);
        hjVar.c(eu.a(context, context.getPackageName()));
        hjVar.b(eu.b(context, context.getPackageName()));
        hjVar.h("3_7_5");
        hjVar.a(30705);
        hjVar.i(gw.e(context));
        hjVar.a(gx.Init);
        if (!it.g()) {
            String g = gw.g(context);
            if (!TextUtils.isEmpty(g)) {
                hjVar.k(ah.a(g));
            }
        }
        hjVar.j(gw.a());
        int b = gw.b();
        if (b >= 0) {
            hjVar.c(b);
        }
        hi hiVar2 = new hi();
        hiVar2.c(gs.HybridRegister.S);
        hiVar2.b(b.m54a(context).m55a());
        hiVar2.d(context.getPackageName());
        hiVar2.a(ht.a(hjVar));
        hiVar2.a(o.a());
        aq.a(context).a((aq) hiVar2, gi.Notification, (gv) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        an.a(context, str);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            c.a("do not ack message, message is null");
            return;
        }
        try {
            gz gzVar = new gz();
            gzVar.b(b.m54a(context).m55a());
            gzVar.a(miPushMessage.getMessageId());
            gzVar.a(Long.valueOf(miPushMessage.getExtra().get("__hybrid_message_ts")).longValue());
            gzVar.a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                gzVar.c(miPushMessage.getTopic());
            }
            aq.a(context).a((aq) gzVar, gi.AckMessage, false, PushMessageHelper.generateMessage(miPushMessage));
            c.b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
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
        b.a a = b.m54a(context).a(str);
        if (a != null) {
            hp hpVar = new hp();
            hpVar.a(o.a());
            hpVar.d(str);
            hpVar.b(a.f146a);
            hpVar.c(a.c);
            hpVar.e(a.b);
            hi hiVar = new hi();
            hiVar.c(gs.HybridUnregister.S);
            hiVar.b(b.m54a(context).m55a());
            hiVar.d(context.getPackageName());
            hiVar.a(ht.a(hpVar));
            hiVar.a(o.a());
            aq.a(context).a((aq) hiVar, gi.Notification, (gv) null);
            b.m54a(context).b(str);
        }
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        com.xiaomi.push.service.b.a(context, linkedList);
    }
}
