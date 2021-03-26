package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.mapcore2d.aa;
import com.amap.api.mapcore2d.cm;

public final class GroundOverlay {
    private aa a;

    public GroundOverlay(aa aaVar) {
        this.a = aaVar;
    }

    public void remove() {
        try {
            aa aaVar = this.a;
            if (aaVar != null) {
                aaVar.remove();
            }
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "remove");
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            aa aaVar = this.a;
            if (aaVar == null) {
                return "";
            }
            return aaVar.getId();
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "getId");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            aa aaVar = this.a;
            if (aaVar != null) {
                aaVar.setPosition(latLng);
            }
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "setPosition");
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLng getPosition() {
        try {
            aa aaVar = this.a;
            if (aaVar == null) {
                return null;
            }
            return aaVar.getPosition();
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "getPosition");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setDimensions(float f) {
        try {
            aa aaVar = this.a;
            if (aaVar != null) {
                aaVar.setDimensions(f);
            }
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "setDimensions");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        try {
            aa aaVar = this.a;
            if (aaVar != null) {
                aaVar.setImage(bitmapDescriptor);
            }
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "setImage");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setDimensions(float f, float f2) {
        try {
            aa aaVar = this.a;
            if (aaVar != null) {
                aaVar.setDimensions(f, f2);
            }
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "setDimensions");
            throw new RuntimeRemoteException(e);
        }
    }

    public float getWidth() {
        try {
            aa aaVar = this.a;
            if (aaVar == null) {
                return 0.0f;
            }
            return aaVar.getWidth();
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "getWidth");
            throw new RuntimeRemoteException(e);
        }
    }

    public float getHeight() {
        try {
            aa aaVar = this.a;
            if (aaVar == null) {
                return 0.0f;
            }
            return aaVar.getHeight();
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "getHeight");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        try {
            aa aaVar = this.a;
            if (aaVar != null) {
                aaVar.setPositionFromBounds(latLngBounds);
            }
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "setPositionFromBounds");
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLngBounds getBounds() {
        try {
            aa aaVar = this.a;
            if (aaVar == null) {
                return null;
            }
            return aaVar.getBounds();
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "getBounds");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setBearing(float f) {
        try {
            aa aaVar = this.a;
            if (aaVar != null) {
                aaVar.setBearing(f);
            }
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "setBearing");
            throw new RuntimeRemoteException(e);
        }
    }

    public float getBearing() {
        try {
            aa aaVar = this.a;
            if (aaVar == null) {
                return 0.0f;
            }
            return aaVar.getBearing();
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "getBearing");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        try {
            aa aaVar = this.a;
            if (aaVar != null) {
                aaVar.setZIndex(f);
            }
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "setZIndex");
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            aa aaVar = this.a;
            if (aaVar == null) {
                return 0.0f;
            }
            return aaVar.getZIndex();
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "getZIndex");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            aa aaVar = this.a;
            if (aaVar != null) {
                aaVar.setVisible(z);
            }
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "setVisible");
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            aa aaVar = this.a;
            if (aaVar == null) {
                return false;
            }
            return aaVar.isVisible();
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "isVisible");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTransparency(float f) {
        try {
            aa aaVar = this.a;
            if (aaVar != null) {
                aaVar.setTransparency(f);
            }
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "setTransparency");
            throw new RuntimeRemoteException(e);
        }
    }

    public float getTransparency() {
        try {
            aa aaVar = this.a;
            if (aaVar == null) {
                return 0.0f;
            }
            return aaVar.getTransparency();
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "getTransparency");
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            throw new RemoteException();
        } catch (RemoteException e) {
            cm.a(e, "GroundOverlay", "equals");
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        aa aaVar = this.a;
        if (aaVar == null) {
            return 0;
        }
        return aaVar.hashCode();
    }
}
