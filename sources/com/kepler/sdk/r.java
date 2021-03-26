package com.kepler.sdk;

import java.util.HashMap;
import java.util.Map;

public class r {
    protected String a;
    protected String b = "get";
    protected byte[] c;
    protected String d;
    protected HashMap<String, String> e;
    int f;

    public r(String str, Map<String, String> map, String str2) {
        this.b = str2;
        if (af.a(map)) {
            this.a = str;
            return;
        }
        String a2 = ag.a(map);
        if (af.a(a2)) {
            return;
        }
        if ("post".equalsIgnoreCase(str2)) {
            this.a = str;
            this.c = a2.getBytes();
            return;
        }
        this.a = str + "?" + a2;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public byte[] c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public HashMap<String, String> e() {
        return this.e;
    }

    public void a(int i) {
        this.f = i;
    }

    public int f() {
        return this.f;
    }
}
