package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: DynamicLayoutBrick */
public class c {
    public static final Map<String, Integer> a;
    private String b;
    private String c;
    private d d;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("title", 0);
        hashMap.put("subtitle", 0);
        hashMap.put("source", 0);
        hashMap.put("score-count", 0);
        hashMap.put("text_star", 0);
        hashMap.put("image", 1);
        hashMap.put("image-wide", 1);
        hashMap.put("image-square", 1);
        hashMap.put("image-long", 1);
        hashMap.put("image-splash", 1);
        hashMap.put("image-cover", 1);
        hashMap.put("app-icon", 1);
        hashMap.put("icon-download", 1);
        hashMap.put("star", 1);
        hashMap.put("logoad", 4);
        hashMap.put("logounion", 5);
        hashMap.put("logo-union", 6);
        hashMap.put("dislike", 3);
        hashMap.put("close", 3);
        hashMap.put("close-fill", 3);
        hashMap.put("text", 2);
        hashMap.put("button", 2);
        hashMap.put("downloadWithIcon", 2);
        hashMap.put("downloadButton", 2);
        hashMap.put("fillButton", 2);
        hashMap.put("laceButton", 2);
        hashMap.put("cardButton", 2);
        hashMap.put("colourMixtureButton", 2);
        hashMap.put("arrowButton", 2);
        hashMap.put("vessel", 6);
        hashMap.put("video-hd", 7);
        hashMap.put("video-vd", 7);
    }

    public int a() {
        if (TextUtils.isEmpty(this.b)) {
            return 0;
        }
        if (this.b.equals("logo")) {
            this.b += this.c;
        }
        Map<String, Integer> map = a;
        if (map.get(this.b) != null) {
            return map.get(this.b).intValue();
        }
        return 0;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public d c() {
        return this.d;
    }

    public void a(d dVar) {
        this.d = dVar;
    }

    public static void a(JSONObject jSONObject, c cVar) {
        if (jSONObject != null && cVar != null) {
            cVar.a(jSONObject.optString("type", "root"));
            cVar.b(jSONObject.optString("data"));
            cVar.a(d.a(jSONObject.optJSONObject("values")));
        }
    }
}
