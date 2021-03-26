package com.xiaomi.b.a;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.al;
import com.xiaomi.push.it;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    private String a = al.a();
    private String b = it.d();
    private String c;
    private String d;
    public int e;
    public String f;
    public int g;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("production", this.e);
            jSONObject.put("reportType", this.g);
            jSONObject.put("clientInterfaceId", this.f);
            jSONObject.put("os", this.a);
            jSONObject.put("miuiVersion", this.b);
            jSONObject.put("pkgName", this.c);
            jSONObject.put("sdkVersion", this.d);
            return jSONObject;
        } catch (JSONException e2) {
            c.a(e2);
            return null;
        }
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        JSONObject a2 = a();
        return a2 == null ? "" : a2.toString();
    }

    public void b(String str) {
        this.d = str;
    }
}
