package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ax;
import com.xiaomi.push.bi;
import com.xiaomi.push.g;
import com.xiaomi.push.hc;
import com.xiaomi.push.hm;
import com.xiaomi.push.hp;
import com.xiaomi.push.i;
import com.xiaomi.push.ib;
import com.xiaomi.push.l;
import com.xiaomi.push.n;
import com.xiaomi.push.service.aq;
import java.util.HashMap;
import java.util.Map;

final class ar implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f158a;

    ar(Context context, boolean z) {
        this.a = context;
        this.f158a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        Map<String, String> map;
        b.m41a("do sync info");
        ib ibVar = new ib(aq.a(), false);
        b a2 = b.m75a(this.a);
        ibVar.c(hm.SyncInfo.f576a);
        ibVar.b(a2.m76a());
        ibVar.d(this.a.getPackageName());
        ibVar.f717a = new HashMap();
        Map<String, String> map2 = ibVar.f717a;
        Context context = this.a;
        n.a(map2, "app_version", g.m356a(context, context.getPackageName()));
        Map<String, String> map3 = ibVar.f717a;
        Context context2 = this.a;
        n.a(map3, "app_version_code", Integer.toString(g.a(context2, context2.getPackageName())));
        n.a(ibVar.f717a, "push_sdk_vn", "3_7_9");
        n.a(ibVar.f717a, "push_sdk_vc", Integer.toString(30709));
        n.a(ibVar.f717a, "token", a2.b());
        i.a(this.a, ibVar.f717a);
        if (!l.d()) {
            String a3 = bi.a(i.f(this.a));
            String h = i.h(this.a);
            if (!TextUtils.isEmpty(h)) {
                a3 = a3 + "," + h;
            }
            if (!TextUtils.isEmpty(a3)) {
                n.a(ibVar.f717a, "imei_md5", a3);
            }
        }
        ax.a(this.a).a(ibVar.f717a);
        n.a(ibVar.f717a, "reg_id", a2.m83c());
        n.a(ibVar.f717a, "reg_secret", a2.d());
        n.a(ibVar.f717a, "accept_time", MiPushClient.getAcceptTime(this.a).replace(",", "-"));
        if (this.f158a) {
            n.a(ibVar.f717a, "aliases_md5", aq.c(MiPushClient.getAllAlias(this.a)));
            n.a(ibVar.f717a, "topics_md5", aq.c(MiPushClient.getAllTopic(this.a)));
            map = ibVar.f717a;
            str2 = aq.c(MiPushClient.getAllUserAccount(this.a));
            str = "accounts_md5";
        } else {
            n.a(ibVar.f717a, "aliases", aq.d(MiPushClient.getAllAlias(this.a)));
            n.a(ibVar.f717a, "topics", aq.d(MiPushClient.getAllTopic(this.a)));
            map = ibVar.f717a;
            str2 = aq.d(MiPushClient.getAllUserAccount(this.a));
            str = "user_accounts";
        }
        n.a(map, str, str2);
        ak.a(this.a).a((ak) ibVar, hc.Notification, false, (hp) null);
    }
}
