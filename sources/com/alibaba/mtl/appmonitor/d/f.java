package com.alibaba.mtl.appmonitor.d;

import com.alibaba.mtl.appmonitor.f.b;
import com.alibaba.mtl.log.d.i;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AlarmSampling */
public class f extends g {
    String TAG = "AlarmSampling";
    private int o = 0;
    private int p = 0;

    @Override // com.alibaba.mtl.appmonitor.d.g
    public /* bridge */ /* synthetic */ boolean a(int i, String str, String str2, Map map) {
        return super.a(i, str, str2, map);
    }

    public f(com.alibaba.mtl.appmonitor.a.f fVar, int i) {
        super(fVar, i);
        this.o = i;
        this.p = i;
    }

    public boolean a(int i, String str, String str2, Boolean bool, Map<String, String> map) {
        h hVar;
        String str3 = this.TAG;
        i.a(str3, "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.o), "failSampling:" + this.p);
        if (this.f49q != null && (hVar = (h) this.f49q.get(str)) != null && (hVar instanceof d)) {
            return ((d) hVar).a(i, str2, bool, map);
        }
        if (bool.booleanValue()) {
            if (i < this.o) {
                return true;
            }
            return false;
        } else if (i < this.p) {
            return true;
        } else {
            return false;
        }
    }

    @Override // com.alibaba.mtl.appmonitor.d.g
    public void b(JSONObject jSONObject) {
        a(jSONObject);
        c(jSONObject);
        this.f49q.clear();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("metrics");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("module");
                    if (b.c(string)) {
                        h hVar = (h) this.f49q.get(string);
                        if (hVar == null) {
                            hVar = new d(string, this.o, this.p);
                            this.f49q.put(string, hVar);
                        }
                        hVar.b(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.alibaba.mtl.appmonitor.d.a
    protected void a(JSONObject jSONObject) {
        super.a((f) jSONObject);
        this.o = this.n;
        this.p = this.n;
        try {
            Integer valueOf = Integer.valueOf(jSONObject.getInt("successSampling"));
            if (valueOf != null) {
                this.o = valueOf.intValue();
            }
            Integer valueOf2 = Integer.valueOf(jSONObject.getInt("failSampling"));
            if (valueOf2 != null) {
                this.p = valueOf2.intValue();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.alibaba.mtl.appmonitor.d.g
    public void setSampling(int i) {
        super.setSampling(i);
        this.o = i;
        this.p = i;
    }
}
