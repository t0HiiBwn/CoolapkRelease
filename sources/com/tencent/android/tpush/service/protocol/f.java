package com.tencent.android.tpush.service.protocol;

import org.json.JSONObject;

/* compiled from: ProGuard */
public class f {
    public String a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public String i = "";
    public String j = "";
    public long k = 0;
    public String l = "";
    public String m = "";
    public String n = "";
    public String o = "";
    public String p = "";
    public String q = "";
    public int r = 3;
    public n s = null;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("imei", this.a);
        jSONObject.put("model", this.b);
        jSONObject.put("os", this.c);
        jSONObject.put("network", this.d);
        jSONObject.put("sdCard", this.e);
        jSONObject.put("sdDouble", this.f);
        jSONObject.put("resolution", this.g);
        jSONObject.put("manu", this.h);
        jSONObject.put("apiLevel", this.i);
        jSONObject.put("sdkVersionName", this.j);
        jSONObject.put("isRooted", this.k);
        jSONObject.put("appList", this.l);
        jSONObject.put("cpuInfo", this.m);
        jSONObject.put("language", this.n);
        jSONObject.put("timezone", this.o);
        jSONObject.put("launcherName", this.p);
        jSONObject.put("xgAppList", this.q);
        jSONObject.put("ntfBar", this.r);
        n nVar = this.s;
        if (nVar != null) {
            jSONObject.put("tUinInfo", nVar.a());
        }
        return jSONObject;
    }
}
