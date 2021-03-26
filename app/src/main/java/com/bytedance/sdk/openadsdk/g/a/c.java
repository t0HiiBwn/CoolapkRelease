package com.bytedance.sdk.openadsdk.g.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.g.a.c;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import org.json.JSONObject;

/* compiled from: LogStatsBase */
public class c<T extends c> implements a {
    private String a;
    private String b;
    private String c;
    private String d = "3.4.1.2";
    private String e;
    private long f = (System.currentTimeMillis() / 1000);
    private int g = 0;
    private String h;
    private int i = 0;
    private String j;
    private String k;

    /* renamed from: l  reason: collision with root package name */
    private String f1331l;
    private String m;

    private T q() {
        return this;
    }

    public static c<c> b() {
        return new c<>();
    }

    @Override // com.bytedance.sdk.openadsdk.g.a.a
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(c())) {
                jSONObject.put("type", c());
            }
            if (!TextUtils.isEmpty(e())) {
                jSONObject.put("rit", e());
            }
            if (!TextUtils.isEmpty(f())) {
                jSONObject.put("creative_id", f());
            }
            if (!TextUtils.isEmpty(g())) {
                jSONObject.put("ad_sdk_version", g());
            }
            if (!TextUtils.isEmpty(h())) {
                jSONObject.put("app_version", h());
            } else {
                jSONObject.put("app_version", aj.g());
            }
            if (i() > 0) {
                jSONObject.put("timestamp", i());
            }
            if (j() > 0) {
                jSONObject.put("adtype", j());
            }
            if (!TextUtils.isEmpty(k())) {
                jSONObject.put("req_id", k());
            }
            jSONObject.put("error_code", l());
            if (!TextUtils.isEmpty(m())) {
                jSONObject.put("error_msg", m());
            }
            if (!TextUtils.isEmpty(n())) {
                jSONObject.put("extra", n());
            }
            if (!TextUtils.isEmpty(o())) {
                jSONObject.put("image_url", o());
            }
            if (!TextUtils.isEmpty(d())) {
                jSONObject.put("event_extra", d());
            }
            jSONObject.put("conn_type", x.b(p.a()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("device_info", p());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
            jSONObject.put("imei", k.d(p.a()));
            jSONObject.put("oaid", y.a());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String c() {
        return this.a;
    }

    public T a(String str) {
        this.a = str;
        return q();
    }

    public String d() {
        return this.m;
    }

    public T b(String str) {
        this.m = str;
        return q();
    }

    public String e() {
        return this.b;
    }

    public T c(String str) {
        this.b = str;
        return q();
    }

    public String f() {
        return this.c;
    }

    public T d(String str) {
        this.c = str;
        return q();
    }

    public String g() {
        return this.d;
    }

    public T e(String str) {
        this.d = str;
        return q();
    }

    public String h() {
        return this.e;
    }

    public long i() {
        return this.f;
    }

    public T c(long j2) {
        this.f = j2;
        return q();
    }

    public int j() {
        return this.g;
    }

    public T a(int i2) {
        this.g = i2;
        return q();
    }

    public String k() {
        return this.h;
    }

    public T f(String str) {
        this.h = str;
        return q();
    }

    public int l() {
        return this.i;
    }

    public T b(int i2) {
        this.i = i2;
        return q();
    }

    public String m() {
        return this.j;
    }

    public T g(String str) {
        this.j = str;
        return q();
    }

    public String n() {
        return this.k;
    }

    public T h(String str) {
        this.k = str;
        return q();
    }

    public String o() {
        return this.f1331l;
    }

    public T i(String str) {
        this.f1331l = str;
        return q();
    }
}
