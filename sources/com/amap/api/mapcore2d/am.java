package com.amap.api.mapcore2d;

/* compiled from: InprocessingTiles */
class am extends bn<bs> {
    am() {
    }

    synchronized void a(bs bsVar) {
        remove(bsVar);
    }

    synchronized boolean b(bs bsVar) {
        if (contains(bsVar)) {
            return false;
        }
        a((am) bsVar);
        return true;
    }
}
