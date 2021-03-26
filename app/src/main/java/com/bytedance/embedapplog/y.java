package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

class y extends u {
    private final Context e;
    private final z f;

    y(Context context, z zVar) {
        super(false, false);
        this.e = context;
        this.f = zVar;
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        jSONObject.put("sdk_version", 336);
        jSONObject.put("sdk_version_name", "3.6.0-rc.9-embed");
        jSONObject.put("channel", this.f.k());
        aa.a(jSONObject, "aid", this.f.j());
        aa.a(jSONObject, "release_build", this.f.A());
        aa.a(jSONObject, "app_region", this.f.n());
        aa.a(jSONObject, "app_language", this.f.m());
        aa.a(jSONObject, "user_agent", this.f.B());
        aa.a(jSONObject, "ab_sdk_version", this.f.p());
        aa.a(jSONObject, "ab_version", this.f.t());
        aa.a(jSONObject, "aliyun_uuid", this.f.a());
        String l2 = this.f.l();
        if (TextUtils.isEmpty(l2)) {
            l2 = bk.a(this.e, this.f);
        }
        if (!TextUtils.isEmpty(l2)) {
            aa.a(jSONObject, "google_aid", l2);
        }
        String z = this.f.z();
        if (!TextUtils.isEmpty(z)) {
            try {
                jSONObject.put("app_track", new JSONObject(z));
            } catch (Throwable th) {
                bo.a(th);
            }
        }
        String o = this.f.o();
        if (o != null && o.length() > 0) {
            jSONObject.put("custom", new JSONObject(o));
        }
        aa.a(jSONObject, "user_unique_id", this.f.q());
        return true;
    }
}
