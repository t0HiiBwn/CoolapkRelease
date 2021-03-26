package com.amap.api.mapcore2d;

import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.interfaces.MapCameraMessage;
import com.amap.api.maps2d.model.CameraPosition;

/* compiled from: AMapCallback */
class a {
    private b a;
    private int b;

    public a(b bVar) {
        this.a = bVar;
    }

    protected void a(MapCameraMessage mapCameraMessage) throws RemoteException {
        try {
            b bVar = this.a;
            if (bVar == null) {
                return;
            }
            if (bVar.i() != null) {
                float zoomLevel = this.a.getZoomLevel();
                if (mapCameraMessage.nowType == MapCameraMessage.Type.scrollBy) {
                    if (this.a.b != null) {
                        this.a.b.d((int) mapCameraMessage.xPixel, (int) mapCameraMessage.yPixel);
                    }
                    this.a.postInvalidate();
                } else if (mapCameraMessage.nowType == MapCameraMessage.Type.zoomIn) {
                    this.a.i().a(true);
                } else if (mapCameraMessage.nowType == MapCameraMessage.Type.zoomOut) {
                    this.a.i().a(false);
                } else if (mapCameraMessage.nowType == MapCameraMessage.Type.zoomTo) {
                    this.a.i().c(mapCameraMessage.zoom);
                } else if (mapCameraMessage.nowType == MapCameraMessage.Type.zoomBy) {
                    float a2 = this.a.a(mapCameraMessage.amount + zoomLevel);
                    Point point = mapCameraMessage.focus;
                    float f = a2 - zoomLevel;
                    if (point != null) {
                        this.a.a(f, point, false, 0L);
                    } else {
                        this.a.i().c(a2);
                    }
                } else if (mapCameraMessage.nowType == MapCameraMessage.Type.newCameraPosition) {
                    CameraPosition cameraPosition = mapCameraMessage.cameraPosition;
                    if (cameraPosition != null) {
                        this.a.i().a(new w((int) (cameraPosition.target.latitude * 1000000.0d), (int) (cameraPosition.target.longitude * 1000000.0d)), cameraPosition.zoom);
                    }
                } else if (mapCameraMessage.nowType == MapCameraMessage.Type.changeCenter) {
                    CameraPosition cameraPosition2 = mapCameraMessage.cameraPosition;
                    this.a.i().a(new w((int) (cameraPosition2.target.latitude * 1000000.0d), (int) (cameraPosition2.target.longitude * 1000000.0d)));
                } else {
                    if (mapCameraMessage.nowType != MapCameraMessage.Type.newLatLngBounds) {
                        if (mapCameraMessage.nowType != MapCameraMessage.Type.newLatLngBoundsWithSize) {
                            mapCameraMessage.isChangeFinished = true;
                        }
                    }
                    this.a.a(mapCameraMessage, false, -1L);
                }
                if (zoomLevel != ((float) this.b) && this.a.c().isScaleControlsEnabled()) {
                    this.a.s();
                }
                l.a().b();
            }
        } catch (Exception e) {
            cm.a(e, "AMapCallback", "runCameraUpdate");
        }
    }
}
