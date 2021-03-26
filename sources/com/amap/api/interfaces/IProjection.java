package com.amap.api.interfaces;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.VisibleRegion;

public interface IProjection {
    LatLng fromScreenLocation(Point point) throws RemoteException;

    VisibleRegion getVisibleRegion() throws RemoteException;

    PointF toMapLocation(LatLng latLng) throws RemoteException;

    Point toScreenLocation(LatLng latLng) throws RemoteException;
}
