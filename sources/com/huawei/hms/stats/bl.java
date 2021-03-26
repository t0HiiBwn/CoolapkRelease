package com.huawei.hms.stats;

import org.json.JSONObject;

public class bl extends t {
    protected String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g;

    public void b(String str) {
        this.c = str;
    }

    @Override // com.huawei.hms.stats.y
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.a);
        jSONObject.put("oaid", this.g);
        jSONObject.put("uuid", this.b);
        jSONObject.put("upid", this.f);
        jSONObject.put("imei", this.c);
        jSONObject.put("sn", this.d);
        jSONObject.put("udid", this.e);
        return jSONObject;
    }

    public void c(String str) {
        this.d = str;
    }

    public void d(String str) {
        this.f = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public void f(String str) {
        this.b = str;
    }

    public void g(String str) {
        this.g = str;
    }
}
