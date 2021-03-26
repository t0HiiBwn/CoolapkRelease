package com.bytedance.embedapplog;

import android.app.Application;
import org.json.JSONObject;

class g extends i {
    private long b;
    private final z c;
    private final aa d;

    @Override // com.bytedance.embedapplog.i
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.i
    String e() {
        return "ab";
    }

    g(Application application, aa aaVar, z zVar) {
        super(application);
        this.d = aaVar;
        this.c = zVar;
    }

    @Override // com.bytedance.embedapplog.i
    long b() {
        long s = this.c.s();
        if (s < 600000) {
            s = 600000;
        }
        return this.b + s;
    }

    @Override // com.bytedance.embedapplog.i
    long[] c() {
        return o.c;
    }

    @Override // com.bytedance.embedapplog.i
    boolean d() {
        JSONObject a = this.d.a();
        if (this.d.o() == 0 || a == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.d.a());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", currentTimeMillis);
        JSONObject d2 = ao.d(ao.a(ap.a(this.a, this.d.a(), ao.a().getABConfigUri(), true, AppLog.getIAppParam()), ao.c), jSONObject);
        if (d2 == null) {
            return false;
        }
        AppLog.getDataObserver().onRemoteAbConfigGet(!bp.a(AppLog.getAbConfig(), d2), d2);
        if (bo.b) {
            bo.a("getAbConfig " + d2, null);
        }
        this.d.a(d2);
        this.b = currentTimeMillis;
        return true;
    }
}
