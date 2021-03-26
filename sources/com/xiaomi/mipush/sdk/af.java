package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gi;
import com.xiaomi.push.go;
import com.xiaomi.push.gs;
import com.xiaomi.push.gv;
import com.xiaomi.push.hb;
import com.xiaomi.push.hi;
import com.xiaomi.push.ht;
import com.xiaomi.push.j;
import com.xiaomi.push.service.l;
import com.xiaomi.push.service.m;

public class af extends j.a {
    private Context a;

    public af(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        l a2 = l.a(this.a);
        hb hbVar = new hb();
        hbVar.a(m.a(a2, go.MISC_CONFIG));
        hbVar.b(m.a(a2, go.PLUGIN_CONFIG));
        hi hiVar = new hi("-1", false);
        hiVar.c(gs.DailyCheckClientConfig.S);
        hiVar.a(ht.a(hbVar));
        aq.a(this.a).a((aq) hiVar, gi.Notification, (gv) null);
    }
}
