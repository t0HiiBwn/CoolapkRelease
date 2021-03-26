package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: BackHtmlModel */
public class d {
    private String a;
    private String b;
    private Map<String, String> c;

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void a(Map<String, String> map) {
        this.c = map;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
            try {
                jSONObject.put("url", this.a);
                jSONObject.put("html", this.b);
                JSONObject jSONObject2 = new JSONObject();
                Map<String, String> map = this.c;
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, String> entry : this.c.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("headers", jSONObject2);
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }
}
