package com.alibaba.mtl.appmonitor.d;

import org.json.JSONObject;

/* compiled from: AbstractSampling */
public abstract class a<T extends JSONObject> {
    protected int n;

    public a(int i) {
        this.n = i;
    }

    protected void a(T t) {
        try {
            Integer valueOf = Integer.valueOf(t.getInt("sampling"));
            if (valueOf != null) {
                this.n = valueOf.intValue();
            }
        } catch (Exception unused) {
        }
    }

    protected boolean a(int i) {
        return i < this.n;
    }
}
