package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.interfaces.ICircle;
import com.amap.api.mapcore2d.cm;

public final class Circle {
    private final ICircle a;

    public Circle(ICircle iCircle) {
        this.a = iCircle;
    }

    public void remove() {
        try {
            ICircle iCircle = this.a;
            if (iCircle != null) {
                iCircle.remove();
            }
        } catch (RemoteException e) {
            cm.a(e, "Circle", "remove");
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            ICircle iCircle = this.a;
            if (iCircle == null) {
                return "";
            }
            return iCircle.getId();
        } catch (RemoteException e) {
            cm.a(e, "Circle", "getId");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setCenter(LatLng latLng) {
        try {
            ICircle iCircle = this.a;
            if (iCircle != null) {
                iCircle.setCenter(latLng);
            }
        } catch (RemoteException e) {
            cm.a(e, "Circle", "setCenter");
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLng getCenter() {
        try {
            ICircle iCircle = this.a;
            if (iCircle == null) {
                return null;
            }
            return iCircle.getCenter();
        } catch (RemoteException e) {
            cm.a(e, "Circle", "getCenter");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setRadius(double d) {
        try {
            ICircle iCircle = this.a;
            if (iCircle != null) {
                iCircle.setRadius(d);
            }
        } catch (RemoteException e) {
            cm.a(e, "Circle", "setRadius");
            throw new RuntimeRemoteException(e);
        }
    }

    public double getRadius() {
        try {
            ICircle iCircle = this.a;
            if (iCircle == null) {
                return 0.0d;
            }
            return iCircle.getRadius();
        } catch (RemoteException e) {
            cm.a(e, "Circle", "getRadius");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStrokeWidth(float f) {
        try {
            ICircle iCircle = this.a;
            if (iCircle != null) {
                iCircle.setStrokeWidth(f);
            }
        } catch (RemoteException e) {
            cm.a(e, "Circle", "setStrokeWidth");
            throw new RuntimeRemoteException(e);
        }
    }

    public float getStrokeWidth() {
        try {
            ICircle iCircle = this.a;
            if (iCircle == null) {
                return 0.0f;
            }
            return iCircle.getStrokeWidth();
        } catch (RemoteException e) {
            cm.a(e, "Circle", "getStrokeWidth");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStrokeColor(int i) {
        try {
            ICircle iCircle = this.a;
            if (iCircle != null) {
                iCircle.setStrokeColor(i);
            }
        } catch (RemoteException e) {
            cm.a(e, "Circle", "setStrokeColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public int getStrokeColor() {
        try {
            ICircle iCircle = this.a;
            if (iCircle == null) {
                return 0;
            }
            return iCircle.getStrokeColor();
        } catch (RemoteException e) {
            cm.a(e, "Circle", "getStrokeColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFillColor(int i) {
        try {
            ICircle iCircle = this.a;
            if (iCircle != null) {
                iCircle.setFillColor(i);
            }
        } catch (RemoteException e) {
            cm.a(e, "Circle", "setFillColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public int getFillColor() {
        try {
            ICircle iCircle = this.a;
            if (iCircle == null) {
                return 0;
            }
            return iCircle.getFillColor();
        } catch (RemoteException e) {
            cm.a(e, "Circle", "getFillColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        try {
            ICircle iCircle = this.a;
            if (iCircle != null) {
                iCircle.setZIndex(f);
            }
        } catch (RemoteException e) {
            cm.a(e, "Circle", "setZIndex");
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            ICircle iCircle = this.a;
            if (iCircle == null) {
                return 0.0f;
            }
            return iCircle.getZIndex();
        } catch (RemoteException e) {
            cm.a(e, "Circle", "getZIndex");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            ICircle iCircle = this.a;
            if (iCircle != null) {
                iCircle.setVisible(z);
            }
        } catch (RemoteException e) {
            cm.a(e, "Circle", "setVisible");
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            ICircle iCircle = this.a;
            if (iCircle == null) {
                return false;
            }
            return iCircle.isVisible();
        } catch (RemoteException e) {
            cm.a(e, "Circle", "isVisible");
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean contains(LatLng latLng) {
        try {
            ICircle iCircle = this.a;
            if (iCircle == null) {
                return false;
            }
            if (latLng == null) {
                return false;
            }
            return iCircle.contains(latLng);
        } catch (RemoteException e) {
            cm.a(e, "Circle", "contains");
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        try {
            ICircle iCircle = this.a;
            if (iCircle == null) {
                return false;
            }
            return iCircle.equalsRemote(((Circle) obj).a);
        } catch (RemoteException e) {
            cm.a(e, "Circle", "equals");
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            ICircle iCircle = this.a;
            if (iCircle == null) {
                return 0;
            }
            return iCircle.hashCodeRemote();
        } catch (RemoteException e) {
            cm.a(e, "Circle", "hashCode");
            throw new RuntimeRemoteException(e);
        }
    }
}
