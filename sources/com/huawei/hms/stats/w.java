package com.huawei.hms.stats;

import android.text.TextUtils;
import com.huawei.hms.stats.e;
import org.json.JSONObject;

public class w implements y {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.b = jSONObject.optString("event");
            this.c = jSONObject.optString("properties");
            this.c = e.a().a(e.a.AES).a(am.a().c(), this.c);
            this.a = jSONObject.optString("type");
            this.d = jSONObject.optString("eventtime");
            this.e = jSONObject.optString("event_session_name");
            this.f = jSONObject.optString("first_session_event");
        }
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.b = str;
    }

    @Override // com.huawei.hms.stats.y
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.a);
        jSONObject.put("eventtime", this.d);
        jSONObject.put("event", this.b);
        jSONObject.put("event_session_name", this.e);
        jSONObject.put("first_session_event", this.f);
        if (TextUtils.isEmpty(this.c)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.c));
        return jSONObject;
    }

    public void c(String str) {
        this.c = str;
    }

    public JSONObject d() {
        JSONObject c2 = c();
        c2.put("properties", e.a().a(e.a.AES).b(am.a().c(), this.c));
        return c2;
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public void f(String str) {
        this.f = str;
    }
}
