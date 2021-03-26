package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.ah;
import com.xiaomi.push.eu;
import com.xiaomi.push.gi;
import com.xiaomi.push.gs;
import com.xiaomi.push.gv;
import com.xiaomi.push.gw;
import com.xiaomi.push.hi;
import com.xiaomi.push.it;
import com.xiaomi.push.iv;
import com.xiaomi.push.service.o;
import com.xiaomi.push.v;
import java.util.HashMap;
import java.util.Map;

final class ax implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f140a;

    ax(Context context, boolean z) {
        this.a = context;
        this.f140a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        Map<String, String> map;
        c.a("do sync info");
        hi hiVar = new hi(o.a(), false);
        b a2 = b.m54a(this.a);
        hiVar.c(gs.SyncInfo.S);
        hiVar.b(a2.m55a());
        hiVar.d(this.a.getPackageName());
        hiVar.h = new HashMap();
        Map<String, String> map2 = hiVar.h;
        Context context = this.a;
        iv.a(map2, "app_version", eu.a(context, context.getPackageName()));
        Map<String, String> map3 = hiVar.h;
        Context context2 = this.a;
        iv.a(map3, "app_version_code", Integer.toString(eu.b(context2, context2.getPackageName())));
        iv.a(hiVar.h, "push_sdk_vn", "3_7_5");
        iv.a(hiVar.h, "push_sdk_vc", Integer.toString(30705));
        iv.a(hiVar.h, "token", a2.b());
        if (!it.g()) {
            String a3 = ah.a(gw.f(this.a));
            String h = gw.h(this.a);
            if (!TextUtils.isEmpty(h)) {
                a3 = a3 + "," + h;
            }
            if (!TextUtils.isEmpty(a3)) {
                iv.a(hiVar.h, "imei_md5", a3);
            }
        }
        v.a(this.a).a(hiVar.h);
        iv.a(hiVar.h, "reg_id", a2.m62c());
        iv.a(hiVar.h, "reg_secret", a2.d());
        iv.a(hiVar.h, "accept_time", MiPushClient.getAcceptTime(this.a).replace(",", "-"));
        if (this.f140a) {
            iv.a(hiVar.h, "aliases_md5", aw.c(MiPushClient.getAllAlias(this.a)));
            iv.a(hiVar.h, "topics_md5", aw.c(MiPushClient.getAllTopic(this.a)));
            map = hiVar.h;
            str2 = aw.c(MiPushClient.getAllUserAccount(this.a));
            str = "accounts_md5";
        } else {
            iv.a(hiVar.h, "aliases", aw.d(MiPushClient.getAllAlias(this.a)));
            iv.a(hiVar.h, "topics", aw.d(MiPushClient.getAllTopic(this.a)));
            map = hiVar.h;
            str2 = aw.d(MiPushClient.getAllUserAccount(this.a));
            str = "user_accounts";
        }
        iv.a(map, str, str2);
        aq.a(this.a).a((aq) hiVar, gi.Notification, false, (gv) null);
    }
}
