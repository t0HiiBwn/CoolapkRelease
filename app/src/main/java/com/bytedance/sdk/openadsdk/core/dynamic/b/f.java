package com.bytedance.sdk.openadsdk.core.dynamic.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DynamicLayoutUnit */
public class f {
    private String a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private c g;
    private List<f> h;

    public void a(String str) {
        this.a = str;
    }

    public float a() {
        return this.b;
    }

    public void a(float f2) {
        this.b = f2;
    }

    public float b() {
        return this.c;
    }

    public void b(float f2) {
        this.c = f2;
    }

    public float c() {
        return this.d;
    }

    public void c(float f2) {
        this.d = f2;
    }

    public float d() {
        return this.e;
    }

    public void d(float f2) {
        this.e = f2;
    }

    public void e(float f2) {
        this.f = f2;
    }

    public c e() {
        return this.g;
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    public List<f> f() {
        return this.h;
    }

    public void a(f fVar) {
        if (this.h == null) {
            this.h = new ArrayList();
        }
        this.h.add(fVar);
    }

    public static void a(JSONObject jSONObject, f fVar) {
        if (!(jSONObject == null || fVar == null)) {
            fVar.a(jSONObject.optString("id", "root"));
            fVar.a((float) jSONObject.optDouble("x", 0.0d));
            fVar.b((float) jSONObject.optDouble("y", 0.0d));
            fVar.c((float) jSONObject.optDouble("width", 0.0d));
            fVar.d((float) jSONObject.optDouble("height", 0.0d));
            fVar.e((float) jSONObject.optDouble("remainWidth", 0.0d));
            c cVar = new c();
            c.a(jSONObject.optJSONObject("brick"), cVar);
            fVar.a(cVar);
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    Object opt = optJSONArray.opt(i);
                    if (opt != null && !"null".equals(opt.toString()) && (opt instanceof JSONArray)) {
                        int i2 = 0;
                        while (true) {
                            JSONArray jSONArray = (JSONArray) opt;
                            if (i2 >= jSONArray.length()) {
                                break;
                            }
                            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                            f fVar2 = new f();
                            a(optJSONObject, fVar2);
                            fVar.a(fVar2);
                            i2++;
                        }
                    }
                }
            }
        }
    }
}
