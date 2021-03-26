package com.bytedance.embedapplog;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

final class ag extends u {
    private final Context e;
    private final z f;

    ag(Context context, z zVar) {
        super(true, false);
        this.e = context;
        this.f = zVar;
    }

    @Override // com.bytedance.embedapplog.u
    protected boolean a(JSONObject jSONObject) {
        Map<String, String> a = bw.a(this.e, this.f.e());
        if (a == null) {
            return false;
        }
        jSONObject.put("oaid", new JSONObject(a));
        return true;
    }
}
