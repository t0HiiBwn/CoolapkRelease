package com.amap.api.maps2d;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.interfaces.IProjection;
import com.amap.api.mapcore2d.cm;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.RuntimeRemoteException;
import com.amap.api.maps2d.model.VisibleRegion;

public class Projection {
    private final IProjection a;

    public Projection(IProjection iProjection) {
        this.a = iProjection;
    }

    public LatLng fromScreenLocation(Point point) {
        try {
            return this.a.fromScreenLocation(point);
        } catch (RemoteException e) {
            cm.a(e, "Projection", "fromScreenLocation");
            throw new RuntimeRemoteException(e);
        }
    }

    public Point toScreenLocation(LatLng latLng) {
        try {
            return this.a.toScreenLocation(latLng);
        } catch (RemoteException e) {
            cm.a(e, "Projection", "toScreenLocation");
            throw new RuntimeRemoteException(e);
        }
    }

    public PointF toMapLocation(LatLng latLng) {
        try {
            return this.a.toMapLocation(latLng);
        } catch (RemoteException e) {
            cm.a(e, "Projection", "toMapLocation");
            throw new RuntimeRemoteException(e);
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            return this.a.getVisibleRegion();
        } catch (RemoteException e) {
            cm.a(e, "Projection", "getVisibleRegion");
            throw new RuntimeRemoteException(e);
        }
    }
}
