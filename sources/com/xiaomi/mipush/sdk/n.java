package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.dj;
import com.xiaomi.push.dl;
import com.xiaomi.push.gn;
import com.xiaomi.push.gs;
import com.xiaomi.push.hi;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.it;
import com.xiaomi.push.j;
import com.xiaomi.push.service.l;
import com.xiaomi.push.service.o;
import java.util.HashMap;

public class n {
    public static void a(Context context, Intent intent, Uri uri) {
        dj a;
        dl dlVar;
        if (context != null) {
            aq.a(context).m45a();
            if (dj.a(context.getApplicationContext()).a() == null) {
                dj.a(context.getApplicationContext()).a(b.m54a(context.getApplicationContext()).m55a(), context.getPackageName(), l.a(context.getApplicationContext()).a(gn.AwakeInfoUploadWaySwitch.a(), 0), new c());
                l.a(context).a(new p(102, "awake online config", context));
            }
            if ((context instanceof Activity) && intent != null) {
                a = dj.a(context.getApplicationContext());
                dlVar = dl.ACTIVITY;
            } else if (!(context instanceof Service) || intent == null) {
                if (uri != null && !TextUtils.isEmpty(uri.toString())) {
                    dj.a(context.getApplicationContext()).a(dl.PROVIDER, context, (Intent) null, uri.toString());
                    return;
                }
                return;
            } else if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                a = dj.a(context.getApplicationContext());
                dlVar = dl.SERVICE_COMPONENT;
            } else {
                a = dj.a(context.getApplicationContext());
                dlVar = dl.SERVICE_ACTION;
            }
            a.a(dlVar, context, intent, (String) null);
        }
    }

    private static void a(Context context, hi hiVar) {
        boolean z = false;
        boolean a = l.a(context).a(gn.AwakeAppPingSwitch.a(), false);
        int a2 = l.a(context).a(gn.AwakeAppPingFrequency.a(), 0);
        if (a2 >= 0 && a2 < 30) {
            c.c("aw_ping: frquency need > 30s.");
            a2 = 30;
        }
        if (a2 >= 0) {
            z = a;
        }
        if (!it.a()) {
            a(context, hiVar, z, a2);
        } else if (z) {
            j.a(context.getApplicationContext()).a((j.a) new o(hiVar, context), a2);
        }
    }

    public static final <T extends hu<T, ?>> void a(Context context, T t, boolean z, int i) {
        byte[] a = ht.a(t);
        if (a == null) {
            c.a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_help_ping");
        intent.putExtra("extra_help_ping_switch", z);
        intent.putExtra("extra_help_ping_frequency", i);
        intent.putExtra("mipush_payload", a);
        intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        aq.a(context).m46a(intent);
    }

    public static void a(Context context, String str) {
        c.a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
        HashMap hashMap = new HashMap();
        hashMap.put("awake_info", str);
        hashMap.put("event_type", String.valueOf(9999));
        hashMap.put("description", "ping message");
        hi hiVar = new hi();
        hiVar.b(b.m54a(context).m55a());
        hiVar.d(context.getPackageName());
        hiVar.c(gs.AwakeAppResponse.S);
        hiVar.a(o.a());
        hiVar.h = hashMap;
        a(context, hiVar);
    }

    public static void a(Context context, String str, int i, String str2) {
        hi hiVar = new hi();
        hiVar.b(str);
        hiVar.a(new HashMap());
        hiVar.j().put("extra_aw_app_online_cmd", String.valueOf(i));
        hiVar.j().put("extra_help_aw_info", str2);
        hiVar.a(o.a());
        byte[] a = ht.a(hiVar);
        if (a == null) {
            c.a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_aw_app_logic");
        intent.putExtra("mipush_payload", a);
        aq.a(context).m46a(intent);
    }
}
