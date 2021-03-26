package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.interfaces.IPolyline;
import com.amap.api.mapcore2d.cm;
import java.util.List;

public class Polyline {
    private final IPolyline a;

    public Polyline(IPolyline iPolyline) {
        this.a = iPolyline;
    }

    public void remove() {
        try {
            IPolyline iPolyline = this.a;
            if (iPolyline != null) {
                iPolyline.remove();
            }
        } catch (RemoteException e) {
            cm.a(e, "Polyline", "remove");
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            IPolyline iPolyline = this.a;
            if (iPolyline == null) {
                return "";
            }
            return iPolyline.getId();
        } catch (RemoteException e) {
            cm.a(e, "Polyline", "getId");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            IPolyline iPolyline = this.a;
            if (iPolyline != null) {
                iPolyline.setPoints(list);
            }
        } catch (RemoteException e) {
            cm.a(e, "Polyline", "setPoints");
            throw new RuntimeRemoteException(e);
        }
    }

    public List<LatLng> getPoints() {
        try {
            IPolyline iPolyline = this.a;
            if (iPolyline == null) {
                return null;
            }
            return iPolyline.getPoints();
        } catch (RemoteException e) {
            cm.a(e, "Polyline", "getPoints");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setWidth(float f) {
        try {
            IPolyline iPolyline = this.a;
            if (iPolyline != null) {
                iPolyline.setWidth(f);
            }
        } catch (RemoteException e) {
            cm.a(e, "Polyline", "setWidth");
            throw new RuntimeRemoteException(e);
        }
    }

    public float getWidth() {
        try {
            IPolyline iPolyline = this.a;
            if (iPolyline == null) {
                return 0.0f;
            }
            return iPolyline.getWidth();
        } catch (RemoteException e) {
            cm.a(e, "Polyline", "getWidth");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setColor(int i) {
        try {
            IPolyline iPolyline = this.a;
            if (iPolyline != null) {
                iPolyline.setColor(i);
            }
        } catch (RemoteException e) {
            cm.a(e, "Polyline", "setColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public int getColor() {
        try {
            IPolyline iPolyline = this.a;
            if (iPolyline == null) {
                return 0;
            }
            return iPolyline.getColor();
        } catch (RemoteException e) {
            cm.a(e, "Polyline", "getColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        try {
            IPolyline iPolyline = this.a;
            if (iPolyline != null) {
                iPolyline.setZIndex(f);
            }
        } catch (RemoteException e) {
            cm.a(e, "Polyline", "setZIndex");
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            IPolyline iPolyline = this.a;
            if (iPolyline == null) {
                return 0.0f;
            }
            return iPolyline.getZIndex();
        } catch (RemoteException e) {
            cm.a(e, "Polyline", "getZIndex");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            IPolyline iPolyline = this.a;
            if (iPolyline != null) {
                iPolyline.setVisible(z);
            }
        } catch (RemoteException e) {
            cm.a(e, "Polyline", "setVisible");
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            IPolyline iPolyline = this.a;
            if (iPolyline == null) {
                return false;
            }
            return iPolyline.isVisible();
        } catch (RemoteException e) {
            cm.a(e, "Polyline", "isVisible");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setGeodesic(boolean z) {
        try {
            IPolyline iPolyline = this.a;
            if (iPolyline != null && iPolyline.isGeodesic() != z) {
                List<LatLng> points = getPoints();
                this.a.setGeodesic(z);
                setPoints(points);
            }
        } catch (RemoteException e) {
            cm.a(e, "Polyline", "setGeodesic");
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isGeodesic() {
        IPolyline iPolyline = this.a;
        if (iPolyline == null) {
            return false;
        }
        return iPolyline.isGeodesic();
    }

    public void setDottedLine(boolean z) {
        IPolyline iPolyline = this.a;
        if (iPolyline != null) {
            iPolyline.setDottedLine(z);
        }
    }

    public boolean isDottedLine() {
        IPolyline iPolyline = this.a;
        if (iPolyline == null) {
            return false;
        }
        return iPolyline.isDottedLine();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            IPolyline iPolyline = this.a;
            if (iPolyline == null) {
                return false;
            }
            return iPolyline.equalsRemote(((Polyline) obj).a);
        } catch (RemoteException e) {
            cm.a(e, "Polyline", "equals");
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            IPolyline iPolyline = this.a;
            if (iPolyline == null) {
                return 0;
            }
            return iPolyline.hashCodeRemote();
        } catch (RemoteException e) {
            cm.a(e, "Polyline", "hashCode");
            throw new RuntimeRemoteException(e);
        }
    }
}
