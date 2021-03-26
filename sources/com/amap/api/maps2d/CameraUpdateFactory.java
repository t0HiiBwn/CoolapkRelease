package com.amap.api.maps2d;

import android.graphics.Point;
import com.amap.api.mapcore2d.m;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;

public final class CameraUpdateFactory {
    public static CameraUpdate zoomIn() {
        return new CameraUpdate(m.b());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(m.c());
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        return new CameraUpdate(m.a(f, f2));
    }

    public static CameraUpdate zoomTo(float f) {
        return new CameraUpdate(m.a(f));
    }

    public static CameraUpdate zoomBy(float f) {
        return new CameraUpdate(m.b(f));
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        return new CameraUpdate(m.a(f, point));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        return new CameraUpdate(m.a(cameraPosition));
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        return new CameraUpdate(m.b(latLng));
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        return new CameraUpdate(m.a(latLng, f));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        return new CameraUpdate(m.a(latLngBounds, i));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        return new CameraUpdate(m.a(latLngBounds, i, i2, i3, i4));
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        return new CameraUpdate(m.a(latLng));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        return new CameraUpdate(m.a(latLngBounds, i, i2, i3));
    }
}
