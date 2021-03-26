package com.xiaomi.push;

import org.json.JSONObject;

public class bl {
    private int a;
    private long b;
    private long c;
    private String d;
    private long e;

    public bl() {
        this(0, 0, 0, null);
    }

    public bl(int i, long j, long j2, Exception exc) {
        this.a = i;
        this.b = j;
        this.e = j2;
        this.c = System.currentTimeMillis();
        if (exc != null) {
            this.d = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.a;
    }

    public bl a(JSONObject jSONObject) {
        this.b = jSONObject.getLong("cost");
        this.e = jSONObject.getLong("size");
        this.c = jSONObject.getLong("ts");
        this.a = jSONObject.getInt("wt");
        this.d = jSONObject.optString("expt");
        return this;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.b);
        jSONObject.put("size", this.e);
        jSONObject.put("ts", this.c);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.d);
        return jSONObject;
    }
}
