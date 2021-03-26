package com.amap.api.maps2d;

import com.amap.api.interfaces.MapCameraMessage;

public final class CameraUpdate {
    private MapCameraMessage a;

    public CameraUpdate(MapCameraMessage mapCameraMessage) {
        this.a = mapCameraMessage;
    }

    public MapCameraMessage getCameraUpdateFactoryDelegate() {
        return this.a;
    }
}
