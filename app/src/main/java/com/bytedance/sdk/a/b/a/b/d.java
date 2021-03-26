package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.ac;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: RouteDatabase */
public final class d {
    private final Set<ac> a = new LinkedHashSet();

    public synchronized void a(ac acVar) {
        this.a.add(acVar);
    }

    public synchronized void b(ac acVar) {
        this.a.remove(acVar);
    }

    public synchronized boolean c(ac acVar) {
        return this.a.contains(acVar);
    }
}
