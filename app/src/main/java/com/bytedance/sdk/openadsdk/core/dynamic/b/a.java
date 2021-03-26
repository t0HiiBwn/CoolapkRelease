package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.aj;
import org.json.JSONObject;

/* compiled from: DynamicAdInfo */
public class a {
    private String a;
    private String b;
    private String c;

    public a(l lVar) {
        if (lVar != null) {
            this.a = lVar.ag();
            this.b = lVar.aj();
            this.c = aj.i(lVar);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.a)) {
                jSONObject.put("cid", this.a);
            }
            if (!TextUtils.isEmpty(this.b)) {
                jSONObject.put("log_extra", this.b);
            }
            if (!TextUtils.isEmpty(this.c)) {
                jSONObject.put("download_url", this.c);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
