package com.amap.api.mapcore2d;

import android.graphics.Point;
import com.amap.api.interfaces.MapCameraMessage;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;

/* compiled from: CameraUpdateFactoryDelegate */
public class m extends MapCameraMessage {
    private float a;
    private float b;
    private ae c;

    private m() {
    }

    public static m a() {
        return new m();
    }

    public static m b() {
        m a2 = a();
        a2.nowType = MapCameraMessage.Type.zoomIn;
        return a2;
    }

    public static m c() {
        m a2 = a();
        a2.nowType = MapCameraMessage.Type.zoomOut;
        return a2;
    }

    public static m a(float f, float f2) {
        m a2 = a();
        a2.nowType = MapCameraMessage.Type.scrollBy;
        a2.xPixel = f;
        a2.yPixel = f2;
        return a2;
    }

    public static m a(float f) {
        m a2 = a();
        a2.nowType = MapCameraMessage.Type.zoomTo;
        a2.zoom = f;
        return a2;
    }

    public static m b(float f) {
        return a(f, (Point) null);
    }

    public static m a(float f, Point point) {
        m a2 = a();
        a2.nowType = MapCameraMessage.Type.zoomBy;
        a2.amount = f;
        a2.focus = point;
        return a2;
    }

    public static m a(CameraPosition cameraPosition) {
        m a2 = a();
        a2.nowType = MapCameraMessage.Type.newCameraPosition;
        a2.cameraPosition = cameraPosition;
        return a2;
    }

    public static m a(LatLng latLng) {
        m a2 = a();
        a2.nowType = MapCameraMessage.Type.changeCenter;
        a2.cameraPosition = new CameraPosition(latLng, 0.0f, 0.0f, 0.0f);
        return a2;
    }

    public static m b(LatLng latLng) {
        return a(CameraPosition.builder().target(latLng).build());
    }

    public static m a(LatLng latLng, float f) {
        return a(CameraPosition.builder().target(latLng).zoom(f).build());
    }

    public static m a(LatLng latLng, float f, float f2, float f3) {
        return a(CameraPosition.builder().target(latLng).zoom(f).bearing(f2).tilt(f3).build());
    }

    static m a(ae aeVar, float f, float f2, float f3) {
        m a2 = a();
        a2.nowType = MapCameraMessage.Type.changeGeoCenterZoomTiltBearing;
        a2.c = aeVar;
        a2.zoom = f;
        a2.b = f2;
        a2.a = f3;
        return a2;
    }

    public static m a(LatLngBounds latLngBounds, int i) {
        m a2 = a();
        a2.nowType = MapCameraMessage.Type.newLatLngBounds;
        a2.bounds = latLngBounds;
        a2.paddingLeft = i;
        a2.paddingRight = i;
        a2.paddingTop = i;
        a2.paddingBottom = i;
        return a2;
    }

    public static m a(LatLngBounds latLngBounds, int i, int i2, int i3) {
        m a2 = a();
        a2.nowType = MapCameraMessage.Type.newLatLngBoundsWithSize;
        a2.bounds = latLngBounds;
        a2.paddingLeft = i3;
        a2.paddingRight = i3;
        a2.paddingTop = i3;
        a2.paddingBottom = i3;
        a2.width = i;
        a2.height = i2;
        return a2;
    }

    public static MapCameraMessage a(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        m a2 = a();
        a2.nowType = MapCameraMessage.Type.newLatLngBounds;
        a2.bounds = latLngBounds;
        a2.paddingLeft = i;
        a2.paddingRight = i2;
        a2.paddingTop = i3;
        a2.paddingBottom = i4;
        return a2;
    }
}
