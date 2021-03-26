package com.amap.api.maps2d;

import android.os.RemoteException;
import com.amap.api.interfaces.IUiSettings;
import com.amap.api.mapcore2d.cm;

public final class UiSettings {
    private final IUiSettings a;

    public UiSettings(IUiSettings iUiSettings) {
        this.a = iUiSettings;
    }

    public void setScaleControlsEnabled(boolean z) {
        try {
            this.a.setScaleControlsEnabled(z);
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "setScaleControlsEnabled");
            e.printStackTrace();
        }
    }

    public void setZoomControlsEnabled(boolean z) {
        try {
            this.a.setZoomControlsEnabled(z);
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "setZoomControlsEnabled");
            e.printStackTrace();
        }
    }

    public void setCompassEnabled(boolean z) {
        try {
            this.a.setCompassEnabled(z);
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "setCompassEnabled");
            e.printStackTrace();
        }
    }

    public void setMyLocationButtonEnabled(boolean z) {
        try {
            this.a.setMyLocationButtonEnabled(z);
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "setMyLocationButtonEnabled");
            e.printStackTrace();
        }
    }

    public void setScrollGesturesEnabled(boolean z) {
        try {
            this.a.setScrollGesturesEnabled(z);
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "setScrollGesturesEnabled");
            e.printStackTrace();
        }
    }

    public void setZoomGesturesEnabled(boolean z) {
        try {
            this.a.setZoomGesturesEnabled(z);
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "setZoomGesturesEnabled");
            e.printStackTrace();
        }
    }

    public void setAllGesturesEnabled(boolean z) {
        try {
            this.a.setAllGesturesEnabled(z);
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "setAllGesturesEnabled");
            e.printStackTrace();
        }
    }

    public void setLogoPosition(int i) {
        try {
            this.a.setLogoPosition(i);
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "setLogoPosition");
            e.printStackTrace();
        }
    }

    public void setZoomPosition(int i) {
        try {
            this.a.setZoomPosition(i);
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "setZoomPosition");
            e.printStackTrace();
        }
    }

    public boolean isScaleControlsEnabled() {
        try {
            return this.a.isScaleControlsEnabled();
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "isScaleControlsEnabled");
            e.printStackTrace();
            return false;
        }
    }

    public boolean isZoomControlsEnabled() {
        try {
            return this.a.isZoomControlsEnabled();
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "isZoomControlsEnabled");
            e.printStackTrace();
            return false;
        }
    }

    public boolean isCompassEnabled() {
        try {
            return this.a.isCompassEnabled();
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "isCompassEnabled");
            e.printStackTrace();
            return false;
        }
    }

    public boolean isMyLocationButtonEnabled() {
        try {
            return this.a.isMyLocationButtonEnabled();
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "isMyLocationButtonEnabled");
            e.printStackTrace();
            return false;
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            return this.a.isScrollGesturesEnabled();
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "isScrollGestureEnabled");
            e.printStackTrace();
            return false;
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.a.isZoomGesturesEnabled();
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "isZoomGesturesEnabled");
            e.printStackTrace();
            return false;
        }
    }

    public int getLogoPosition() {
        try {
            return this.a.getLogoPosition();
        } catch (RemoteException e) {
            cm.a(e, "UiSettings", "getLogoPosition");
            e.printStackTrace();
            return 0;
        }
    }

    public int getZoomPosition() {
        try {
            return this.a.getZoomPosition();
        } catch (Throwable th) {
            cm.a(th, "UiSettings", "getZoomPosition");
            th.printStackTrace();
            return 0;
        }
    }

    public void setZoomInByScreenCenter(boolean z) {
        try {
            this.a.setZoomInByScreenCenter(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLogoCenter(int i, int i2) {
        try {
            this.a.setLogoCenter(i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
