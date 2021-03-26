package com.alibaba.mtl.appmonitor.d;

import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.f.b;
import com.alibaba.mtl.log.d.i;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: EventTypeSampling */
class g extends a<JSONObject> {
    private f e;
    protected int q = -1;

    /* renamed from: q  reason: collision with other field name */
    protected Map<String, h> f50q;

    public g(f fVar, int i) {
        super(i);
        this.e = fVar;
        this.f50q = Collections.synchronizedMap(new HashMap());
    }

    public boolean a(int i, String str, String str2, Map<String, String> map) {
        h hVar;
        Map<String, h> map2 = this.f50q;
        if (map2 == null || (hVar = map2.get(str)) == null) {
            return i < this.n;
        }
        return hVar.a(i, str2, map);
    }

    public void b(JSONObject jSONObject) {
        a((g) jSONObject);
        c(jSONObject);
        this.f50q.clear();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("metrics");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("module");
                    if (b.c(optString)) {
                        h hVar = this.f50q.get(optString);
                        if (hVar == null) {
                            hVar = new h(optString, this.n);
                            this.f50q.put(optString, hVar);
                        }
                        hVar.b(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    protected void c(JSONObject jSONObject) {
        f fVar;
        i.a("EventTypeSampling", "[updateEventTypeTriggerCount]", this, jSONObject);
        if (jSONObject != null) {
            try {
                int optInt = jSONObject.optInt("cacheCount");
                if (optInt > 0 && (fVar = this.e) != null) {
                    fVar.b(optInt);
                }
            } catch (Throwable th) {
                i.a("EventTypeSampling", "updateTriggerCount", th);
            }
        }
    }

    public void setSampling(int i) {
        this.n = i;
    }
}
