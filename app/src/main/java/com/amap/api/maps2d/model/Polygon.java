package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.interfaces.IPolygon;
import com.amap.api.mapcore2d.af;
import com.amap.api.mapcore2d.cm;
import java.util.List;

public final class Polygon {
    private IPolygon a;

    public Polygon(af afVar) {
        this.a = afVar;
    }

    public void remove() {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon != null) {
                iPolygon.remove();
            }
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "remove");
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon == null) {
                return null;
            }
            return iPolygon.getId();
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "getId");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon != null) {
                iPolygon.setPoints(list);
            }
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "setPoints");
            throw new RuntimeRemoteException(e);
        }
    }

    public List<LatLng> getPoints() {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon == null) {
                return null;
            }
            return iPolygon.getPoints();
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "getPoints");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStrokeWidth(float f) {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon != null) {
                iPolygon.setStrokeWidth(f);
            }
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "setStrokeWidth");
            throw new RuntimeRemoteException(e);
        }
    }

    public float getStrokeWidth() {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon == null) {
                return 0.0f;
            }
            return iPolygon.getStrokeWidth();
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "getStrokeWidth");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStrokeColor(int i) {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon != null) {
                iPolygon.setStrokeColor(i);
            }
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "setStrokeColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public int getStrokeColor() {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon == null) {
                return 0;
            }
            return iPolygon.getStrokeColor();
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "getStrokeColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFillColor(int i) {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon != null) {
                iPolygon.setFillColor(i);
            }
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "setFillColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public int getFillColor() {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon == null) {
                return 0;
            }
            return iPolygon.getFillColor();
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "getFillColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon != null) {
                iPolygon.setZIndex(f);
            }
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "setZIndex");
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon == null) {
                return 0.0f;
            }
            return iPolygon.getZIndex();
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "getZIndex");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon != null) {
                iPolygon.setVisible(z);
            }
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "setVisible");
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon == null) {
                return true;
            }
            return iPolygon.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean contains(LatLng latLng) {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon == null) {
                return false;
            }
            return iPolygon.contains(latLng);
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "contains");
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polygon)) {
            return false;
        }
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon == null) {
                return false;
            }
            return iPolygon.equalsRemote(((Polygon) obj).a);
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "equeals");
            return false;
        }
    }

    public int hashCode() {
        try {
            IPolygon iPolygon = this.a;
            if (iPolygon == null) {
                return 0;
            }
            return iPolygon.hashCodeRemote();
        } catch (RemoteException e) {
            cm.a(e, "Polygon", "hashCode");
            return super.hashCode();
        }
    }
}
