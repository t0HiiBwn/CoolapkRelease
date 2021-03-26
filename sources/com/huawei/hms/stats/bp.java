package com.huawei.hms.stats;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class bp {
    private static bp a;
    private Context b;
    private final Object c = new Object();

    private bp() {
    }

    public static bp a() {
        if (a == null) {
            b();
        }
        return a;
    }

    private JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
                af.d("HiAnalyticsEventManager", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    private static synchronized void b() {
        synchronized (bp.class) {
            if (a == null) {
                a = new bp();
            }
        }
    }

    public void a(Context context) {
        synchronized (this.c) {
            if (this.b == null) {
                this.b = context;
                aq.a().a(context);
            }
        }
    }

    public void a(String str, int i) {
        aq.a().a(str, i);
    }

    public void a(String str, int i, String str2, LinkedHashMap<String, String> linkedHashMap) {
        aq.a().a(str, i, str2, a(linkedHashMap));
    }

    public void a(String str, Context context, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            aq.a().a(str, 0, str2, jSONObject);
        } catch (JSONException unused) {
            af.c("HiAnalyticsEventManager", "onEvent():JSON structure Exception!");
        }
    }
}
