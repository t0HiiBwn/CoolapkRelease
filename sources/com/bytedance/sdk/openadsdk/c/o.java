package com.bytedance.sdk.openadsdk.c;

import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.g.c.c;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: StatsEventThread */
public class o extends g<c.a> {
    private q<a> m = p.f();

    public o(String str, String str2, e eVar, q qVar, g.b bVar, g.a aVar) {
        super(str, str2, eVar, qVar, bVar, aVar);
        this.f1291l = true;
    }

    @Override // com.bytedance.sdk.openadsdk.c.g
    public h a(List<c.a> list) {
        if (this.m == null) {
            this.m = p.f();
        }
        if (list == null || list.size() == 0 || !com.bytedance.sdk.openadsdk.core.h.g.a()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (c.a aVar : list) {
                jSONArray.put(aVar.b);
            }
            jSONObject.put("stats_list", jSONArray);
        } catch (Exception unused) {
        }
        return this.m.a(jSONObject);
    }
}
