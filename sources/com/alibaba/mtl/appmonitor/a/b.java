package com.alibaba.mtl.appmonitor.a;

import org.json.JSONObject;

/* compiled from: CountEvent */
public class b extends d {
    public int count;
    public double value;

    public synchronized void a(double d) {
        this.value += d;
        this.count++;
    }

    @Override // com.alibaba.mtl.appmonitor.a.d
    /* renamed from: a */
    public synchronized JSONObject mo3a() {
        JSONObject a;
        a = super.mo3a();
        try {
            a.put("count", this.count);
            a.put("value", this.value);
        } catch (Exception unused) {
        }
        return a;
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public synchronized void fill(Object... objArr) {
        super.fill(objArr);
        this.value = 0.0d;
        this.count = 0;
    }
}
