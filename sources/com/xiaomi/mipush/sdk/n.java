package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai;
import com.xiaomi.push.ec;
import com.xiaomi.push.ee;
import com.xiaomi.push.hh;
import com.xiaomi.push.hm;
import com.xiaomi.push.ib;
import com.xiaomi.push.im;
import com.xiaomi.push.in;
import com.xiaomi.push.l;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.aq;
import java.util.HashMap;

public class n {
    public static void a(Context context, Intent intent, Uri uri) {
        ec a;
        ee eeVar;
        if (context != null) {
            ak.a(context).m66a();
            if (ec.a(context.getApplicationContext()).m289a() == null) {
                ec.a(context.getApplicationContext()).a(b.m75a(context.getApplicationContext()).m76a(), context.getPackageName(), an.a(context.getApplicationContext()).a(hh.AwakeInfoUploadWaySwitch.a(), 0), new c());
                an.a(context).a(new p(102, "awake online config", context));
            }
            if ((context instanceof Activity) && intent != null) {
                a = ec.a(context.getApplicationContext());
                eeVar = ee.ACTIVITY;
            } else if (!(context instanceof Service) || intent == null) {
                if (uri != null && !TextUtils.isEmpty(uri.toString())) {
                    ec.a(context.getApplicationContext()).a(ee.PROVIDER, context, (Intent) null, uri.toString());
                    return;
                }
                return;
            } else if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                a = ec.a(context.getApplicationContext());
                eeVar = ee.SERVICE_COMPONENT;
            } else {
                a = ec.a(context.getApplicationContext());
                eeVar = ee.SERVICE_ACTION;
            }
            a.a(eeVar, context, intent, (String) null);
        }
    }

    private static void a(Context context, ib ibVar) {
        boolean z = false;
        boolean a = an.a(context).a(hh.AwakeAppPingSwitch.a(), false);
        int a2 = an.a(context).a(hh.AwakeAppPingFrequency.a(), 0);
        if (a2 >= 0 && a2 < 30) {
            b.c("aw_ping: frquency need > 30s.");
            a2 = 30;
        }
        if (a2 >= 0) {
            z = a;
        }
        if (!l.m568a()) {
            a(context, ibVar, z, a2);
        } else if (z) {
            ai.a(context.getApplicationContext()).a((ai.a) new o(ibVar, context), a2);
        }
    }

    public static final <T extends in<T, ?>> void a(Context context, T t, boolean z, int i) {
        byte[] a = im.a(t);
        if (a == null) {
            b.m41a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_help_ping");
        intent.putExtra("extra_help_ping_switch", z);
        intent.putExtra("extra_help_ping_frequency", i);
        intent.putExtra("mipush_payload", a);
        intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        ak.a(context).m67a(intent);
    }

    public static void a(Context context, String str) {
        b.m41a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
        HashMap hashMap = new HashMap();
        hashMap.put("awake_info", str);
        hashMap.put("event_type", String.valueOf(9999));
        hashMap.put("description", "ping message");
        ib ibVar = new ib();
        ibVar.b(b.m75a(context).m76a());
        ibVar.d(context.getPackageName());
        ibVar.c(hm.AwakeAppResponse.f576a);
        ibVar.a(aq.a());
        ibVar.f717a = hashMap;
        a(context, ibVar);
    }

    public static void a(Context context, String str, int i, String str2) {
        ib ibVar = new ib();
        ibVar.b(str);
        ibVar.a(new HashMap());
        ibVar.m481a().put("extra_aw_app_online_cmd", String.valueOf(i));
        ibVar.m481a().put("extra_help_aw_info", str2);
        ibVar.a(aq.a());
        byte[] a = im.a(ibVar);
        if (a == null) {
            b.m41a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_aw_app_logic");
        intent.putExtra("mipush_payload", a);
        ak.a(context).m67a(intent);
    }
}
