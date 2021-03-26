package com.xiaomi.push;

import org.json.JSONObject;

public class cl {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f267a;

    /* renamed from: a  reason: collision with other field name */
    private String f268a;
    private long b;
    private long c;

    public cl() {
        this(0, 0, 0, null);
    }

    public cl(int i, long j, long j2, Exception exc) {
        this.a = i;
        this.f267a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f268a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.a;
    }

    public cl a(JSONObject jSONObject) {
        this.f267a = jSONObject.getLong("cost");
        this.c = jSONObject.getLong("size");
        this.b = jSONObject.getLong("ts");
        this.a = jSONObject.getInt("wt");
        this.f268a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m175a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f267a);
        jSONObject.put("size", this.c);
        jSONObject.put("ts", this.b);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.f268a);
        return jSONObject;
    }
}
