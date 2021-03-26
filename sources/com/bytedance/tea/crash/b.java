package com.bytedance.tea.crash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CallCenter */
public class b {
    private Map<c, List<a>> a = new HashMap();
    private Map<String, String> b = new HashMap();
    private final List<e> c = new CopyOnWriteArrayList();
    private final List<e> d = new CopyOnWriteArrayList();
    private final List<e> e = new CopyOnWriteArrayList();
    private final List<e> f = new CopyOnWriteArrayList();
    private f g = null;

    public List<a> a(c cVar) {
        return this.a.get(cVar);
    }

    void a(Map<? extends String, ? extends String> map) {
        this.b.putAll(map);
    }

    public Map<String, String> a() {
        return this.b;
    }

    public List<e> b() {
        return this.d;
    }

    public List<e> c() {
        return this.f;
    }

    void a(f fVar) {
        this.g = fVar;
    }

    public f d() {
        return this.g;
    }
}
