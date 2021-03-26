package com.amap.api.interfaces;

import android.graphics.Point;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLngBounds;

public abstract class MapCameraMessage {
    public float amount;
    public LatLngBounds bounds;
    public CameraPosition cameraPosition;
    public Point focus = null;
    public int height;
    public boolean isChangeFinished = false;
    public Type nowType = Type.none;
    public int paddingBottom;
    public int paddingLeft;
    public int paddingRight;
    public int paddingTop;
    public int width;
    public float xPixel;
    public float yPixel;
    public float zoom;

    public enum Type {
        none,
        zoomIn,
        changeCenter,
        changeGeoCenterZoom,
        zoomOut,
        zoomTo,
        zoomBy,
        scrollBy,
        newCameraPosition,
        newLatLngBounds,
        newLatLngBoundsWithSize,
        changeGeoCenterZoomTiltBearing
    }
}
