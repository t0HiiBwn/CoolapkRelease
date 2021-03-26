package com.bytedance.sdk.openadsdk.core.d;

import org.json.JSONObject;

/* compiled from: PlayableInfo */
public class n {
    private String a;

    public String a() {
        return this.a;
    }

    public static String a(l lVar) {
        n h;
        if (lVar == null || (h = lVar.h()) == null) {
            return null;
        }
        return h.a();
    }

    public void a(String str) {
        this.a = str;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_url", a());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static n a(JSONObject jSONObject) {
        n nVar = new n();
        nVar.a(jSONObject.optString("playable_url", ""));
        return nVar;
    }
}
