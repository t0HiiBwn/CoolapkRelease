package com.xiaomi.push.service;

import com.xiaomi.push.hb;
import com.xiaomi.push.hg;
import java.util.List;

public class i implements hb {
    private final XMPushService a;

    public i(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.push.hb
    public void a(List<hg> list, String str, String str2) {
        this.a.a(new j(this, 4, str, list, str2));
    }
}
