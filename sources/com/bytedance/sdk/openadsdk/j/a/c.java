package com.bytedance.sdk.openadsdk.j.a;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ThreadPoolLogModel */
public class c {
    private final String a;
    private int b = 0;
    private int c = 0;
    private int d;
    private long e = 0;
    private long f = 0;
    private long g = 0;
    private long h = 0;
    private int i = 0;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.i <= 0) {
                return null;
            }
            jSONObject.put("poolType", this.a);
            jSONObject.put("corePoolSize", this.b);
            jSONObject.put("maximumPoolSize", this.c);
            jSONObject.put("largestPoolSize", this.d);
            jSONObject.put("waitLargestTime", this.e);
            jSONObject.put("waitAvgTime", (long) ((((float) this.f) * 1.0f) / ((float) this.i)));
            jSONObject.put("taskCostLargestTime", this.g);
            jSONObject.put("taskCostAvgTime", (long) ((((float) this.h) * 1.0f) / ((float) this.i)));
            jSONObject.put("logCount", this.i);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public c(String str, int i2, int i3, long j, long j2, long j3, long j4, int i4) {
        this.a = str;
        this.b = i2;
        this.c = i3;
        this.e = j;
        this.f = j2;
        this.g = j3;
        this.h = j4;
        this.i = i4;
    }

    public String b() {
        return this.a;
    }

    public long c() {
        return this.e;
    }

    public void a(long j) {
        this.e = j;
    }

    public void b(long j) {
        this.f += j;
    }

    public long d() {
        return this.g;
    }

    public void c(long j) {
        this.g = j;
    }

    public void d(long j) {
        this.h += j;
    }

    public int e() {
        return this.i;
    }

    public void a(int i2) {
        this.i += i2;
    }

    public void b(int i2) {
        this.d = i2;
    }
}
