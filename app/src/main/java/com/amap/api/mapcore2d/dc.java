package com.amap.api.mapcore2d;

import java.util.HashMap;
import java.util.Map;

@Deprecated
/* compiled from: AuthRequest */
class dc extends ew {
    private Map<String, String> a = new HashMap();
    private String b;
    private Map<String, String> f = new HashMap();

    dc() {
    }

    void a(Map<String, String> map) {
        this.a.clear();
        this.a.putAll(map);
    }

    void a(String str) {
        this.b = str;
    }

    void b(Map<String, String> map) {
        this.f.clear();
        this.f.putAll(map);
    }

    @Override // com.amap.api.mapcore2d.ew
    public String h() {
        return this.b;
    }

    @Override // com.amap.api.mapcore2d.ew
    public Map<String, String> f() {
        return this.a;
    }

    @Override // com.amap.api.mapcore2d.ew
    public Map<String, String> g() {
        return this.f;
    }
}
