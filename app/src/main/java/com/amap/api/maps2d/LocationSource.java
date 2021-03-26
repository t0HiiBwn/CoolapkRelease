package com.amap.api.maps2d;

import android.location.Location;

public interface LocationSource {

    public interface OnLocationChangedListener {
        void onLocationChanged(Location location);
    }

    void activate(OnLocationChangedListener onLocationChangedListener);

    void deactivate();
}
