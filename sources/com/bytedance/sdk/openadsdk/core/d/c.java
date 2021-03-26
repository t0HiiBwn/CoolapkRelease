package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;

/* compiled from: AppManageModel */
public class c {
    private String a;
    private String b;
    private String c;
    private JSONArray d;
    private String e;
    private String f;
    private HashMap<String, String> g = new HashMap<>();

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.g.put(str, str2);
        }
    }

    public HashMap<String, String> a() {
        return this.g;
    }

    public String b() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String c() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String d() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public JSONArray e() {
        return this.d;
    }

    public void a(JSONArray jSONArray) {
        this.d = jSONArray;
    }

    public String f() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }

    public String g() {
        return this.f;
    }

    public void e(String str) {
        this.f = str;
    }
}
