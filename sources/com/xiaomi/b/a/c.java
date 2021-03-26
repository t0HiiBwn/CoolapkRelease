package com.xiaomi.b.a;

import org.json.JSONException;
import org.json.JSONObject;

public class c extends d {
    public int a;
    public long b = -1;
    public long c = -1;

    public static c c() {
        return new c();
    }

    @Override // com.xiaomi.b.a.d
    public JSONObject a() {
        try {
            JSONObject a2 = super.a();
            if (a2 == null) {
                return null;
            }
            a2.put("code", this.a);
            a2.put("perfCounts", this.b);
            a2.put("perfLatencies", this.c);
            return a2;
        } catch (JSONException e) {
            com.xiaomi.a.a.a.c.a(e);
            return null;
        }
    }

    @Override // com.xiaomi.b.a.d
    public String b() {
        return super.b();
    }
}
