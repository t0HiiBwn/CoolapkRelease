package com.amap.api.mapcore2d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.interfaces.IOverlay;
import com.amap.api.maps2d.AMapUtils;
import com.amap.api.maps2d.model.LatLng;

/* compiled from: CircleDelegateImp */
class o implements z {
    private LatLng a = null;
    private double b = 0.0d;
    private float c = 10.0f;
    private int d = -16777216;
    private int e = 0;
    private float f = 0.0f;
    private boolean g = true;
    private String h;
    private y i;

    @Override // com.amap.api.mapcore2d.ad
    public boolean a() {
        return true;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public int hashCodeRemote() throws RemoteException {
        return 0;
    }

    public o(y yVar) {
        this.i = yVar;
        try {
            this.h = getId();
        } catch (RemoteException e2) {
            cm.a(e2, "CircleDelegateImp", "CircleDelegateIme");
        }
    }

    @Override // com.amap.api.interfaces.IOverlay
    public void remove() throws RemoteException {
        this.i.removeGLOverlay(getId());
        this.i.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IOverlay
    public String getId() throws RemoteException {
        if (this.h == null) {
            this.h = v.a("Circle");
        }
        return this.h;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public void setZIndex(float f2) throws RemoteException {
        this.f = f2;
        this.i.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IOverlay
    public float getZIndex() throws RemoteException {
        return this.f;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public void setVisible(boolean z) throws RemoteException {
        this.g = z;
        this.i.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IOverlay
    public boolean isVisible() throws RemoteException {
        return this.g;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.amap.api.mapcore2d.ad
    public void a(Canvas canvas) throws RemoteException {
        if (getCenter() != null && this.b > 0.0d && isVisible()) {
            try {
                float a2 = this.i.a().b.a((float) getRadius());
                w wVar = new w((int) (this.a.latitude * 1000000.0d), (int) (this.a.longitude * 1000000.0d));
                Point point = new Point();
                this.i.d().a(wVar, point);
                Paint paint = new Paint();
                paint.setColor(getFillColor());
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawCircle((float) point.x, (float) point.y, a2, paint);
                paint.setColor(getStrokeColor());
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(getStrokeWidth());
                canvas.drawCircle((float) point.x, (float) point.y, a2, paint);
            } catch (Throwable th) {
                cm.a(th, "CircleDelegateImp", "draw");
            }
        }
    }

    @Override // com.amap.api.interfaces.ICircle
    public void setCenter(LatLng latLng) throws RemoteException {
        this.a = latLng;
    }

    @Override // com.amap.api.interfaces.ICircle
    public LatLng getCenter() throws RemoteException {
        return this.a;
    }

    @Override // com.amap.api.interfaces.ICircle
    public void setRadius(double d2) throws RemoteException {
        this.b = d2;
    }

    @Override // com.amap.api.interfaces.ICircle
    public double getRadius() throws RemoteException {
        return this.b;
    }

    @Override // com.amap.api.interfaces.ICircle
    public void setStrokeWidth(float f2) throws RemoteException {
        this.c = f2;
    }

    @Override // com.amap.api.interfaces.ICircle
    public float getStrokeWidth() throws RemoteException {
        return this.c;
    }

    @Override // com.amap.api.interfaces.ICircle
    public void setStrokeColor(int i2) throws RemoteException {
        this.d = i2;
    }

    @Override // com.amap.api.interfaces.ICircle
    public int getStrokeColor() throws RemoteException {
        return this.d;
    }

    @Override // com.amap.api.interfaces.ICircle
    public void setFillColor(int i2) throws RemoteException {
        this.e = i2;
    }

    @Override // com.amap.api.interfaces.ICircle
    public int getFillColor() throws RemoteException {
        return this.e;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public void destroy() {
        this.a = null;
    }

    @Override // com.amap.api.interfaces.ICircle
    public boolean contains(LatLng latLng) throws RemoteException {
        return this.b >= ((double) AMapUtils.calculateLineDistance(this.a, latLng));
    }
}
