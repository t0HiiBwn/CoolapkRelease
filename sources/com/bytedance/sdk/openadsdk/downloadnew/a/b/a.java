package com.bytedance.sdk.openadsdk.downloadnew.a.b;

import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.l;
import org.json.JSONObject;

/* compiled from: LibEventExtra */
public class a {
    public l a;
    public String b;
    public String c;
    public JSONObject d;

    public static a a() {
        return new a();
    }

    public static a a(JSONObject jSONObject) {
        JSONObject jSONObject2;
        String str;
        String str2;
        l lVar = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            str2 = jSONObject.optString("tag", null);
            try {
                str = jSONObject.optString("label", null);
                try {
                    jSONObject2 = jSONObject.optJSONObject("extra");
                    try {
                        lVar = c.a(jSONObject.optJSONObject("material_meta"));
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    jSONObject2 = null;
                }
            } catch (Exception unused3) {
                str = null;
                jSONObject2 = str;
                return a().a(str2).b(str).b(jSONObject2).a(lVar);
            }
        } catch (Exception unused4) {
            str2 = null;
            str = null;
            jSONObject2 = str;
            return a().a(str2).b(str).b(jSONObject2).a(lVar);
        }
        return a().a(str2).b(str).b(jSONObject2).a(lVar);
    }

    public a a(l lVar) {
        this.a = lVar;
        return this;
    }

    public a a(String str) {
        this.b = str;
        return this;
    }

    public a b(String str) {
        this.c = str;
        return this;
    }

    public a b(JSONObject jSONObject) {
        this.d = jSONObject;
        return this;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", this.b);
            jSONObject.put("label", this.c);
            JSONObject jSONObject2 = this.d;
            if (jSONObject2 != null) {
                jSONObject.put("extra", jSONObject2);
            }
            l lVar = this.a;
            if (lVar != null) {
                jSONObject.put("material_meta", lVar.aF());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
