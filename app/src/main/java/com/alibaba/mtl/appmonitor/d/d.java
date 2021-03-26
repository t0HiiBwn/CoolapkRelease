package com.alibaba.mtl.appmonitor.d;

import com.alibaba.mtl.appmonitor.f.b;
import com.alibaba.mtl.log.d.i;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AlarmModuleSampling */
public class d extends h {
    private int o = this.n;
    private int p = this.n;

    @Override // com.alibaba.mtl.appmonitor.d.h
    public /* bridge */ /* synthetic */ boolean a(int i, String str, Map map) {
        return super.a(i, str, map);
    }

    public d(String str, int i, int i2) {
        super(str, 0);
    }

    public boolean a(int i, String str, Boolean bool, Map<String, String> map) {
        i iVar;
        i.a("AlarmModuleSampling", "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.o), "failSampling:", Integer.valueOf(this.p));
        if (this.r == null || (iVar = (i) this.r.get(str)) == null || !(iVar instanceof e)) {
            return a(i, bool.booleanValue());
        }
        return ((e) iVar).a(i, bool, map);
    }

    @Override // com.alibaba.mtl.appmonitor.d.h
    public void b(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("monitorPoints");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("monitorPoint");
                    if (b.c(string)) {
                        i iVar = (i) this.r.get(string);
                        if (iVar == null) {
                            iVar = new e(string, this.o, this.p);
                            this.r.put(string, iVar);
                        }
                        iVar.b(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    protected boolean a(int i, boolean z) {
        if (z) {
            return i < this.o;
        }
        if (i < this.p) {
            return true;
        }
        return false;
    }

    @Override // com.alibaba.mtl.appmonitor.d.a
    protected void a(JSONObject jSONObject) {
        super.a((d) jSONObject);
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
            i.a("AlarmModuleSampling", "[updateSelfSampling]", jSONObject, "successSampling:", valueOf, "failSampling");
        } catch (Exception unused) {
        }
    }
}
