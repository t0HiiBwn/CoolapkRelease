package com.bytedance.embedapplog;

import android.content.Context;
import org.json.JSONObject;

class j extends i {
    private final z b;
    private final aa c;

    @Override // com.bytedance.embedapplog.i
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.i
    String e() {
        return "c";
    }

    j(Context context, aa aaVar, z zVar) {
        super(context);
        this.c = aaVar;
        this.b = zVar;
    }

    @Override // com.bytedance.embedapplog.i
    long b() {
        return this.b.h() + 21600000;
    }

    @Override // com.bytedance.embedapplog.i
    long[] c() {
        return o.c;
    }

    @Override // com.bytedance.embedapplog.i
    public boolean d() {
        JSONObject a = this.c.a();
        if (this.c.o() == 0 || a == null || this.b.h() + 21600000 > System.currentTimeMillis()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", a);
        jSONObject.put("_gen_time", System.currentTimeMillis());
        JSONObject c2 = ao.c(ao.a(ap.a(this.a, this.c.a(), ao.a().getSettingUri(), true, AppLog.getIAppParam()), ao.c), jSONObject);
        AppLog.getDataObserver().onRemoteConfigGet(!bp.a(c2, this.b.g()), c2);
        if (c2 == null) {
            return false;
        }
        this.b.a(c2);
        return true;
    }
}
