package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.interfaces.IMarker;
import com.amap.api.mapcore2d.cm;
import java.util.ArrayList;

public final class Marker {
    IMarker a;

    public Marker(MarkerOptions markerOptions) {
    }

    public Marker(IMarker iMarker) {
        this.a = iMarker;
    }

    public void setPosition(LatLng latLng) {
        IMarker iMarker = this.a;
        if (iMarker != null) {
            iMarker.setPosition(latLng);
        }
    }

    public LatLng getPosition() {
        IMarker iMarker = this.a;
        if (iMarker == null) {
            return null;
        }
        return iMarker.getPosition();
    }

    public float getZIndex() {
        IMarker iMarker = this.a;
        if (iMarker == null) {
            return 0.0f;
        }
        return iMarker.getZIndex();
    }

    public void setZIndex(float f) {
        IMarker iMarker = this.a;
        if (iMarker != null) {
            iMarker.setZIndex(f);
        }
    }

    public void remove() {
        try {
            IMarker iMarker = this.a;
            if (iMarker != null) {
                iMarker.remove();
            }
        } catch (Exception e) {
            cm.a(e, "Marker", "remove");
        }
    }

    public void setObject(Object obj) {
        IMarker iMarker = this.a;
        if (iMarker != null) {
            iMarker.setObject(obj);
        }
    }

    public Object getObject() {
        IMarker iMarker = this.a;
        if (iMarker != null) {
            return iMarker.getObject();
        }
        return null;
    }

    public void setPeriod(int i) {
        try {
            IMarker iMarker = this.a;
            if (iMarker != null) {
                iMarker.setPeriod(i);
            }
        } catch (RemoteException e) {
            cm.a(e, "Marker", "setPeriod");
            throw new RuntimeRemoteException(e);
        }
    }

    public int getPeriod() {
        try {
            return this.a.getPeriod();
        } catch (RemoteException e) {
            cm.a(e, "Marker", "getPeriod");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        try {
            this.a.setIcons(arrayList);
        } catch (RemoteException e) {
            cm.a(e, "Marker", "setIcons");
            throw new RuntimeRemoteException(e);
        }
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        try {
            return this.a.getIcons();
        } catch (RemoteException e) {
            cm.a(e, "Marker", "getIcons");
            throw new RuntimeRemoteException(e);
        }
    }

    public void destroy() {
        try {
            IMarker iMarker = this.a;
            if (iMarker != null) {
                iMarker.destroy();
            }
        } catch (Exception e) {
            cm.a(e, "Marker", "destroy");
        }
    }

    public String getId() {
        IMarker iMarker = this.a;
        if (iMarker == null) {
            return null;
        }
        return iMarker.getId();
    }

    public void setTitle(String str) {
        IMarker iMarker = this.a;
        if (iMarker != null) {
            iMarker.setTitle(str);
        }
    }

    public String getTitle() {
        IMarker iMarker = this.a;
        if (iMarker == null) {
            return null;
        }
        return iMarker.getTitle();
    }

    public void setSnippet(String str) {
        IMarker iMarker = this.a;
        if (iMarker != null) {
            iMarker.setSnippet(str);
        }
    }

    public String getSnippet() {
        IMarker iMarker = this.a;
        if (iMarker == null) {
            return null;
        }
        return iMarker.getSnippet();
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        IMarker iMarker = this.a;
        if (iMarker != null && bitmapDescriptor != null) {
            iMarker.setIcon(bitmapDescriptor);
        }
    }

    public void setAnchor(float f, float f2) {
        IMarker iMarker = this.a;
        if (iMarker != null) {
            iMarker.setAnchor(f, f2);
        }
    }

    public void setDraggable(boolean z) {
        IMarker iMarker = this.a;
        if (iMarker != null) {
            iMarker.setDraggable(z);
        }
    }

    public boolean isDraggable() {
        IMarker iMarker = this.a;
        if (iMarker == null) {
            return false;
        }
        return iMarker.isDraggable();
    }

    public void showInfoWindow() {
        IMarker iMarker = this.a;
        if (iMarker != null) {
            iMarker.showInfoWindow();
        }
    }

    public void hideInfoWindow() {
        IMarker iMarker = this.a;
        if (iMarker != null) {
            iMarker.hideInfoWindow();
        }
    }

    public boolean isInfoWindowShown() {
        IMarker iMarker = this.a;
        if (iMarker == null) {
            return false;
        }
        return iMarker.isInfoWindowShown();
    }

    public void setVisible(boolean z) {
        IMarker iMarker = this.a;
        if (iMarker != null) {
            iMarker.setVisible(z);
        }
    }

    public boolean isVisible() {
        IMarker iMarker = this.a;
        if (iMarker == null) {
            return false;
        }
        return iMarker.isVisible();
    }

    public void setRotateAngle(float f) {
        try {
            this.a.setRotateAngle(f);
        } catch (RemoteException e) {
            cm.a(e, "Marker", "setRotateAngle");
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        IMarker iMarker;
        if ((obj instanceof Marker) && (iMarker = this.a) != null) {
            return iMarker.equalsRemote(((Marker) obj).a);
        }
        return false;
    }

    public int hashCode() {
        IMarker iMarker = this.a;
        if (iMarker == null) {
            return super.hashCode();
        }
        return iMarker.hashCodeRemote();
    }

    public void setPositionByPixels(int i, int i2) {
        try {
            IMarker iMarker = this.a;
            if (iMarker != null) {
                iMarker.setPositionByPixels(i, i2);
            }
        } catch (RemoteException e) {
            cm.a(e, "Marker", "setPositionByPixels");
            e.printStackTrace();
        }
    }
}
