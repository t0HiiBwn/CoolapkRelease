package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

class s extends u {
    private final Context e;
    private final z f;

    s(Context context, z zVar) {
        super(true, false);
        this.e = context;
        this.f = zVar;
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f.J())) {
            jSONObject.put("ab_client", this.f.J());
        }
        if (!TextUtils.isEmpty(this.f.t())) {
            if (bo.b) {
                bo.a("init config has abversion:" + this.f.t(), null);
            }
            jSONObject.put("ab_version", this.f.t());
        }
        if (!TextUtils.isEmpty(this.f.K())) {
            jSONObject.put("ab_group", this.f.K());
        }
        if (TextUtils.isEmpty(this.f.L())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f.L());
        return true;
    }
}
