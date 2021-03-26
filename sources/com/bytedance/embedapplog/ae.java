package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

class ae extends u {
    private final Context e;
    private final z f;

    ae(Context context, z zVar) {
        super(true, false);
        this.e = context;
        this.f = zVar;
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        String mac = AppLog.getInitConfig() != null ? AppLog.getInitConfig().getSensitiveInfoProvider().getMac() : "";
        if (TextUtils.isEmpty(mac)) {
            return true;
        }
        jSONObject.put("mc", mac);
        return true;
    }
}
