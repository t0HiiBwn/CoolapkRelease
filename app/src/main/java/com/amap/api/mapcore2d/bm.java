package com.amap.api.mapcore2d;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: StopAnimObserver */
class bm {
    private static bm a = new bm();
    private ArrayList<a> b = new ArrayList<>();

    /* compiled from: StopAnimObserver */
    public interface a {
        void u();
    }

    bm() {
    }

    public static bm a() {
        return a;
    }

    public synchronized void b() {
        Iterator<a> it2 = this.b.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (next != null) {
                next.u();
            }
        }
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            this.b.remove(aVar);
        }
    }
}
