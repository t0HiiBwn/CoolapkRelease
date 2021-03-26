package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import com.alibaba.mtl.appmonitor.c.e;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Event */
public abstract class d implements b {
    public int e;
    public String o;
    public String p;
    public String s;

    /* renamed from: a */
    public JSONObject mo3a() {
        JSONObject jSONObject = (JSONObject) a.a().a(e.class, new Object[0]);
        try {
            jSONObject.put("page", this.o);
            jSONObject.put("monitorPoint", this.p);
            String str = this.s;
            if (str != null) {
                jSONObject.put("arg", str);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        this.e = 0;
        this.o = null;
        this.p = null;
        this.s = null;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        this.e = ((Integer) objArr[0]).intValue();
        this.o = (String) objArr[1];
        this.p = (String) objArr[2];
        if (objArr.length > 3 && objArr[3] != null) {
            this.s = (String) objArr[3];
        }
    }
}
