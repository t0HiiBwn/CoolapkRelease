package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: AhAttempt */
public class a {
    public String a;
    public int b = -1;
    public String c;
    public String d;
    public String e;

    public String a() {
        return b().toString();
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        return jSONObject;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("ah_plan_type", this.a);
                jSONObject.put("error_code", String.valueOf(this.b));
                jSONObject.put("error_msg", this.c);
                jSONObject.put("real_device_plan", this.d);
                jSONObject.put("device_plans", this.e);
            } catch (Throwable unused) {
            }
        }
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.e = jSONObject.optString("device_plans", null);
            aVar.d = jSONObject.optString("real_device_plan", null);
            aVar.c = jSONObject.optString("error_msg", null);
            aVar.a = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                aVar.b = -1;
            } else {
                aVar.b = Integer.parseInt(optString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return aVar;
    }
}
