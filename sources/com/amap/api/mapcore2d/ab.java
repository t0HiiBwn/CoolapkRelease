package com.amap.api.mapcore2d;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.amap.api.interfaces.IMarker;
import com.amap.api.maps2d.model.LatLng;

/* compiled from: IMarkerDelegate */
public interface ab extends IMarker, ac {
    Rect a();

    void a(Canvas canvas, y yVar);

    void a(LatLng latLng);

    s b();
}
