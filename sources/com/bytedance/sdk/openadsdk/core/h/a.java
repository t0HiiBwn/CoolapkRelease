package com.bytedance.sdk.openadsdk.core.h;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* compiled from: AdSlotSetter */
public class a {
    public String a;
    public int b = 1;
    public int c = 1;
    public int d = 2;
    public int e = 1;
    public int f = 1;
    public int g = 100;
    public int h = 0;
    public int i = 2;
    public int j = 1;
    public int k = 3;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public int o = 2;
    public int p = 1;
    public int q = 0;
    public int r = 1500;
    public int s = 2;
    public int t = -1;
    public int u = 20;
    public int v = -1;
    public int w = 0;
    public int x = 0;
    public int y = 5;
    public List<String> z;

    public static a a() {
        return new a();
    }

    private a() {
    }

    public a a(int i2) {
        this.v = i2;
        return this;
    }

    public a b(int i2) {
        this.w = i2;
        return this;
    }

    public a c(int i2) {
        this.x = i2;
        return this;
    }

    public a d(int i2) {
        this.u = i2;
        return this;
    }

    public a e(int i2) {
        this.t = i2;
        return this;
    }

    public a f(int i2) {
        this.q = i2;
        return this;
    }

    public a g(int i2) {
        this.r = i2;
        return this;
    }

    public a h(int i2) {
        this.s = i2;
        return this;
    }

    public a i(int i2) {
        this.o = i2;
        return this;
    }

    public a j(int i2) {
        this.m = i2;
        return this;
    }

    public a k(int i2) {
        this.n = i2;
        return this;
    }

    public a l(int i2) {
        this.l = i2;
        return this;
    }

    public a m(int i2) {
        this.k = i2;
        return this;
    }

    public a a(String str) {
        this.a = str;
        return this;
    }

    public a n(int i2) {
        this.b = i2;
        return this;
    }

    public a o(int i2) {
        this.c = i2;
        return this;
    }

    public a p(int i2) {
        this.d = i2;
        return this;
    }

    public a q(int i2) {
        this.e = i2;
        return this;
    }

    public a r(int i2) {
        this.f = i2;
        return this;
    }

    public a s(int i2) {
        this.g = i2;
        return this;
    }

    public a t(int i2) {
        this.h = i2;
        return this;
    }

    public a u(int i2) {
        this.i = i2;
        return this;
    }

    public a v(int i2) {
        this.j = i2;
        return this;
    }

    public a w(int i2) {
        this.p = i2;
        return this;
    }

    public a a(JSONArray jSONArray) {
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            this.z = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    this.z.add(jSONArray.get(i2).toString());
                } catch (Exception unused) {
                }
            }
        }
        return this;
    }

    public a x(int i2) {
        this.y = i2;
        return this;
    }
}
