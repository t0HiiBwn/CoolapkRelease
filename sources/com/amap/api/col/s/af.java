package com.amap.api.col.s;

import com.amap.api.col.s.ad;
import com.amap.api.services.core.LatLonPoint;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: RequestCacheWorkerCheckDistance */
final class af extends ae {
    private double a;

    public af(String... strArr) {
        super(strArr);
        this.a = 0.0d;
        this.a = 0.0d;
    }

    @Override // com.amap.api.col.s.ae
    protected final boolean a(LinkedHashMap<ad.b, Object> linkedHashMap, ad.b bVar) {
        if (!(linkedHashMap == null || bVar == null)) {
            if (bVar.b == null) {
                return super.a(linkedHashMap, bVar);
            }
            for (ad.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && bVar2.a != null && bVar2.a.equals(bVar.a) && (bVar2.b instanceof a) && ((a) bVar2.b).a(bVar.b)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.amap.api.col.s.ae
    protected final Object b(LinkedHashMap<ad.b, Object> linkedHashMap, ad.b bVar) {
        if (!(linkedHashMap == null || bVar == null)) {
            if (bVar.b == null) {
                return super.b(linkedHashMap, bVar);
            }
            for (ad.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && bVar2.a != null && bVar2.a.equals(bVar.a) && (bVar2.b instanceof a) && ((a) bVar2.b).a(bVar.b)) {
                    return linkedHashMap.get(bVar2);
                }
            }
        }
        return null;
    }

    @Override // com.amap.api.col.s.ae
    protected final Object c(LinkedHashMap<ad.b, Object> linkedHashMap, ad.b bVar) {
        ad.b bVar2;
        if (!(linkedHashMap == null || bVar == null)) {
            if (bVar.b == null) {
                return super.c(linkedHashMap, bVar);
            }
            Iterator<ad.b> it2 = linkedHashMap.keySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    bVar2 = null;
                    break;
                }
                bVar2 = it2.next();
                if (bVar2 != null && bVar2.a != null && bVar2.a.equals(bVar.a) && (bVar2.b instanceof a) && ((a) bVar2.b).a(bVar.b)) {
                    break;
                }
            }
            if (bVar2 != null) {
                return linkedHashMap.remove(bVar2);
            }
        }
        return null;
    }

    public final double a() {
        return this.a;
    }

    @Override // com.amap.api.col.s.ae
    public final void a(ad.a aVar) {
        super.a(aVar);
        if (aVar != null) {
            this.a = aVar.d();
        }
    }

    /* compiled from: RequestCacheWorkerCheckDistance */
    static class a {
        LatLonPoint a = null;
        double b = 0.0d;

        public a(double d, double d2, double d3) {
            this.a = new LatLonPoint(d, d2);
            this.b = d3;
        }

        public final boolean a(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                LatLonPoint latLonPoint = this.a;
                a aVar = (a) obj;
                LatLonPoint latLonPoint2 = aVar.a;
                if (latLonPoint == latLonPoint2) {
                    return true;
                }
                if (latLonPoint != null && ((double) i.a(latLonPoint, latLonPoint2)) <= aVar.b) {
                    return true;
                }
            }
            return false;
        }
    }
}
