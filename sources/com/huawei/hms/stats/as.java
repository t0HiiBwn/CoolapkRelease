package com.huawei.hms.stats;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class as implements av {
    private Context a = b.j();
    private String b;
    private JSONObject c;
    private String d;
    private String e;
    private String f;
    private String g;
    private Boolean h;

    public as(String str, JSONObject jSONObject, String str2, String str3, long j) {
        this.b = str;
        this.c = jSONObject;
        this.d = str2;
        this.e = str3;
        this.f = String.valueOf(j);
        if (a.e(str2, "oper")) {
            ao a2 = an.a().a(str2, j);
            this.g = a2.a();
            this.h = Boolean.valueOf(a2.b());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        af.b("EventRecordTask", "Begin to run EventRecordTask...");
        int h2 = b.h();
        int h3 = c.h(this.d, this.e);
        if (ay.a(this.a, "stat_v2_1", h2 * 1048576)) {
            af.b("hmsSdk", "stat sp file reach max limited size, discard new event");
            aq.a().a("", "alltype");
            return;
        }
        w wVar = new w();
        wVar.b(this.b);
        wVar.c(this.c.toString());
        wVar.a(this.e);
        wVar.d(this.f);
        wVar.e(this.g);
        Boolean bool = this.h;
        wVar.f(bool == null ? null : String.valueOf(bool));
        try {
            JSONObject d2 = wVar.d();
            String a2 = bb.a(this.d, this.e);
            try {
                jSONArray = new JSONArray(ap.b(this.a, "stat_v2_1", a2, ""));
            } catch (JSONException unused) {
                af.b("EventRecordTask", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put(d2);
            ap.a(this.a, "stat_v2_1", a2, jSONArray.toString());
            if (jSONArray.toString().length() > h3 * 1024) {
                aq.a().a(this.d, this.e);
            }
        } catch (JSONException unused2) {
            af.c("EventRecordTask", "eventRecord toJson error! The record failed.");
        }
    }
}
