package com.kepler.sdk;

import java.util.List;
import java.util.Map;

public class s {
    private Map<String, List<String>> a;
    private int b = -1010;
    private String c;

    public s(String str, Map<String, List<String>> map, int i) {
        this.c = str;
        this.a = map;
        this.b = i;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public List<String> a(String str) {
        Map<String, List<String>> map = this.a;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
