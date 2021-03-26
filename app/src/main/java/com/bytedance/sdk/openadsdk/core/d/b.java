package com.bytedance.sdk.openadsdk.core.d;

import com.bytedance.sdk.openadsdk.utils.u;
import org.json.JSONObject;

/* compiled from: AppInfo */
public class b {
    private String a;
    private String b;
    private String c;
    private int d;
    private int e;
    private int f;
    private String g;

    public String a() {
        return this.g;
    }

    public void a(String str) {
        this.g = str;
    }

    public String b() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.b;
    }

    public void c(String str) {
        this.b = str;
    }

    public String d() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public int e() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public int f() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public int g() {
        return this.f;
    }

    public void c(int i) {
        this.f = i;
    }

    public JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", c());
            jSONObject.put("app_size", g());
            jSONObject.put("comment_num", f());
            jSONObject.put("download_url", b());
            jSONObject.put("package_name", d());
            jSONObject.put("score", e());
        } catch (Exception e2) {
            u.b(e2.toString());
        }
        return jSONObject;
    }
}
