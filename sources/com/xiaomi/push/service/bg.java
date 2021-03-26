package com.xiaomi.push.service;

import com.xiaomi.push.gh;
import com.xiaomi.push.gm;
import java.util.List;

public class bg implements gh {
    private final XMPushService a;

    public bg(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.push.gh
    public void a(List<gm> list, String str, String str2) {
        this.a.a(new bh(this, 4, str, list, str2));
    }
}
