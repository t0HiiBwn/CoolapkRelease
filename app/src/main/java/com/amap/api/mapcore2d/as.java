package com.amap.api.mapcore2d;

import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MapMessageQueue */
class as {
    b a;
    private CopyOnWriteArrayList<m> b = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<MapMessage> c = new CopyOnWriteArrayList<>();

    public as(b bVar) {
        this.a = bVar;
    }

    public void a(m mVar) {
        this.b.add(mVar);
    }
}
