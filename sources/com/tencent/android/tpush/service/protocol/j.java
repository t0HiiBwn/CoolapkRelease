package com.tencent.android.tpush.service.protocol;

import org.json.JSONObject;

/* compiled from: ProGuard */
public class j {
    public long a = 0;
    public long b = 0;
    public long c = 0;
    public String d = "";
    public String e = "";
    public long f = 0;
    public String g = "";
    public long h = 0;
    public long i = 0;
    public String j = "";
    public long k = 0;
    public int l = 0;
    public long m = 0;
    public long n = 0;
    public long o = 0;
    public String p = "";
    public String q = "";
    public String r = "";
    public String s = "";
    public long t = 0;
    public long u = 0;
    public int v = 0;
    public String w = "";
    public String x = "";
    public String y = "";

    public void a(JSONObject jSONObject) {
        this.a = jSONObject.optLong("msgId", 0);
        this.b = jSONObject.optLong("accessId", 0);
        this.c = jSONObject.optLong("busiMsgId", 0);
        this.d = jSONObject.optString("title", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("content");
        if (optJSONObject != null) {
            this.e = optJSONObject.toString();
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("inMsg");
        if (optJSONObject2 != null) {
            this.y = optJSONObject2.toString();
        }
        this.f = jSONObject.optLong("type", 0);
        this.g = jSONObject.optString("appPkgName", "");
        this.h = jSONObject.optLong("timestamp", 0) * 1000;
        this.i = jSONObject.optLong("multiPkg", 0);
        this.j = jSONObject.optString("date", "");
        this.k = jSONObject.optLong("serverTime", 0) * 1000000;
        this.l = jSONObject.optInt("ttl", 0);
        this.m = jSONObject.optLong("channelId", 0);
        this.n = jSONObject.optLong("adPush", 0);
        this.o = jSONObject.optLong("reseverId", 0);
        this.p = jSONObject.optString("statTag", "");
        this.r = jSONObject.optString("groupId", "");
        this.t = jSONObject.optLong("targetType", 0);
        this.u = jSONObject.optLong("source", 0);
        this.v = jSONObject.optInt("revokeId", 0);
        this.w = jSONObject.optString("templateId", "");
        this.x = jSONObject.optString("traceId", "");
    }
}
