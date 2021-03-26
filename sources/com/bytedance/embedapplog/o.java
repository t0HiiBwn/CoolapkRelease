package com.bytedance.embedapplog;

import android.content.Context;
import org.json.JSONObject;

class o extends i {
    static final long[] b = {60000, 60000, 60000, 120000, 120000, 120000, 180000, 180000};
    static final long[] c = {180000, 180000, 360000, 360000, 540000, 540000};
    private static final long[] d = {10000, 10000, 20000, 20000, 60000, 6000, 180000, 180000, 540000, 540000};
    private aa e;
    private q f;

    @Override // com.bytedance.embedapplog.i
    boolean a() {
        return true;
    }

    @Override // com.bytedance.embedapplog.i
    String e() {
        return "r";
    }

    o(Context context, aa aaVar, q qVar) {
        super(context);
        this.e = aaVar;
        this.f = qVar;
    }

    @Override // com.bytedance.embedapplog.i
    long b() {
        return this.e.p() + ((long) (this.f.c() ? 21600000 : 43200000));
    }

    @Override // com.bytedance.embedapplog.i
    long[] c() {
        int o = this.e.o();
        if (o == 0) {
            return d;
        }
        if (o == 1) {
            return c;
        }
        if (o == 2) {
            return b;
        }
        bo.a(null);
        return c;
    }

    @Override // com.bytedance.embedapplog.i
    boolean d() {
        JSONObject jSONObject = new JSONObject();
        JSONObject a = this.e.a();
        if (a != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("header", a);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            JSONObject a2 = ao.a(ap.a(this.a, this.e.a(), ao.a().getRegisterUri(), true, AppLog.getIAppParam()), jSONObject);
            if (a2 == null) {
                return false;
            }
            return this.e.a(a2, a2.optString("device_id", ""), a2.optString("install_id", ""), a2.optString("ssid", ""));
        }
        bo.a(null);
        return false;
    }
}
