package com.amap.api.mapcore2d;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CameraChangeFinishObserver */
class l {
    private static l a = new l();
    private ArrayList<a> b = new ArrayList<>();

    /* compiled from: CameraChangeFinishObserver */
    public interface a {
        void v();
    }

    l() {
    }

    public static l a() {
        return a;
    }

    public void b() {
        Iterator<a> it2 = this.b.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (next != null) {
                next.v();
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.b.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.b.remove(aVar);
        }
    }
}
