package com.bytedance.sdk.openadsdk.core.d;

import com.bytedance.sdk.openadsdk.utils.u;
import org.json.JSONObject;

/* compiled from: VideoInfo */
public class t {
    private int a;
    private int b;
    private long c;
    private double d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    private int l = 0;
    private int m = 0;

    public int a() {
        return this.k;
    }

    public void a(int i2) {
        this.k = i2;
    }

    public int b() {
        return this.a;
    }

    public void b(int i2) {
        this.a = i2;
    }

    public int c() {
        return this.b;
    }

    public void c(int i2) {
        this.b = i2;
    }

    public long d() {
        return this.c;
    }

    public void a(long j2) {
        this.c = j2;
    }

    public double e() {
        return this.d;
    }

    public void a(double d2) {
        this.d = d2;
    }

    public String f() {
        return this.e;
    }

    public void a(String str) {
        this.e = str;
    }

    public int[] g() {
        try {
            int indexOf = this.e.indexOf("x");
            return new int[]{Integer.parseInt(this.e.substring(0, indexOf).trim()), Integer.parseInt(this.e.substring(indexOf + 1).trim())};
        } catch (Throwable th) {
            u.c("VideoInfo", "getWidthAndHeight error", th);
            return null;
        }
    }

    public String h() {
        return this.f;
    }

    public void b(String str) {
        this.f = str;
    }

    public String i() {
        return this.g;
    }

    public void c(String str) {
        this.g = str;
    }

    public String j() {
        return this.h;
    }

    public void d(String str) {
        this.h = str;
    }

    public String k() {
        return this.i;
    }

    public void e(String str) {
        this.i = str;
    }

    public String l() {
        return this.j;
    }

    public void f(String str) {
        this.j = str;
    }

    public JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", b());
            jSONObject.put("cover_url", h());
            jSONObject.put("cover_width", c());
            jSONObject.put("endcard", j());
            jSONObject.put("file_hash", l());
            jSONObject.put("resolution", f());
            jSONObject.put("size", d());
            jSONObject.put("video_duration", e());
            jSONObject.put("video_url", i());
            jSONObject.put("playable_download_url", k());
            jSONObject.put("if_playable_loading_show", n());
            jSONObject.put("remove_loading_page_type", o());
            jSONObject.put("fallback_endcard_judge", a());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int n() {
        return this.l;
    }

    public void d(int i2) {
        this.l = i2;
    }

    public int o() {
        return this.m;
    }

    public void e(int i2) {
        this.m = i2;
    }

    public static int[] a(l lVar) {
        if (lVar == null || lVar.R() == null) {
            return null;
        }
        return lVar.R().g();
    }
}
