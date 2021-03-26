package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ai;
import com.xiaomi.push.hc;
import com.xiaomi.push.hi;
import com.xiaomi.push.hm;
import com.xiaomi.push.hp;
import com.xiaomi.push.hu;
import com.xiaomi.push.ib;
import com.xiaomi.push.im;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.ao;

public class aa extends ai.a {
    private Context a;

    public aa(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo141a() {
        return "2";
    }

    @Override // java.lang.Runnable
    public void run() {
        an a2 = an.a(this.a);
        hu huVar = new hu();
        huVar.a(ao.a(a2, hi.MISC_CONFIG));
        huVar.b(ao.a(a2, hi.PLUGIN_CONFIG));
        ib ibVar = new ib("-1", false);
        ibVar.c(hm.DailyCheckClientConfig.f576a);
        ibVar.a(im.a(huVar));
        ak.a(this.a).a((ak) ibVar, hc.Notification, (hp) null);
    }
}
