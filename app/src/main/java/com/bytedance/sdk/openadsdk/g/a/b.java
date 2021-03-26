package com.bytedance.sdk.openadsdk.g.a;

import org.json.JSONObject;

/* compiled from: LoadAdNoRspLog */
public class b extends c<b> {
    private long a;
    private long b;

    public b a(long j) {
        this.a = j;
        return this;
    }

    public b b(long j) {
        this.b = j;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.g.a.c, com.bytedance.sdk.openadsdk.g.a.a
    public JSONObject a() {
        JSONObject a2 = super.a();
        try {
            a2.put("c_process_time", this.a);
            a2.put("s_process_time", this.b);
        } catch (Exception unused) {
        }
        return a2;
    }
}
