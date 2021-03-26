package com.amap.api.mapcore2d;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.VisibleRegion;

/* compiled from: ProjectionDelegateImp */
class bi implements ah {
    private String a = "ProjectionDelegateImp";
    private y b;

    public bi(y yVar) {
        this.b = yVar;
    }

    @Override // com.amap.api.interfaces.IProjection
    public LatLng fromScreenLocation(Point point) throws RemoteException {
        s sVar = new s();
        this.b.a(point.x, point.y, sVar);
        return new LatLng(sVar.b, sVar.a);
    }

    @Override // com.amap.api.interfaces.IProjection
    public Point toScreenLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        ae aeVar = new ae();
        this.b.b(latLng.latitude, latLng.longitude, aeVar);
        return new Point(aeVar.a, aeVar.b);
    }

    @Override // com.amap.api.interfaces.IProjection
    public VisibleRegion getVisibleRegion() throws RemoteException {
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        LatLng latLng4;
        Throwable th;
        LatLngBounds latLngBounds = null;
        try {
            int mapWidth = this.b.getMapWidth();
            int mapHeight = this.b.getMapHeight();
            latLng3 = fromScreenLocation(new Point(0, 0));
            try {
                latLng = fromScreenLocation(new Point(mapWidth, 0));
            } catch (Throwable th2) {
                th = th2;
                latLng4 = null;
                latLng2 = null;
                latLng = latLng2;
                cm.a(th, this.a, "getVisibleRegion");
                return new VisibleRegion(latLng2, latLng4, latLng3, latLng, latLngBounds);
            }
            try {
                latLng2 = fromScreenLocation(new Point(0, mapHeight));
                try {
                    latLng4 = fromScreenLocation(new Point(mapWidth, mapHeight));
                    try {
                        latLngBounds = LatLngBounds.builder().include(latLng2).include(latLng4).include(latLng3).include(latLng).build();
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    latLng4 = null;
                    cm.a(th, this.a, "getVisibleRegion");
                    return new VisibleRegion(latLng2, latLng4, latLng3, latLng, latLngBounds);
                }
            } catch (Throwable th5) {
                th = th5;
                latLng4 = null;
                latLng2 = null;
                cm.a(th, this.a, "getVisibleRegion");
                return new VisibleRegion(latLng2, latLng4, latLng3, latLng, latLngBounds);
            }
        } catch (Throwable th6) {
            th = th6;
            latLng4 = null;
            latLng3 = null;
            latLng2 = null;
            latLng = latLng2;
            cm.a(th, this.a, "getVisibleRegion");
            return new VisibleRegion(latLng2, latLng4, latLng3, latLng, latLngBounds);
        }
        return new VisibleRegion(latLng2, latLng4, latLng3, latLng, latLngBounds);
    }

    @Override // com.amap.api.interfaces.IProjection
    public PointF toMapLocation(LatLng latLng) throws RemoteException {
        s sVar = new s();
        this.b.a(latLng.latitude, latLng.longitude, sVar);
        return new PointF((float) sVar.a, (float) sVar.b);
    }
}
