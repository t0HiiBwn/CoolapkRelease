package com.amap.api.mapcore2d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.interfaces.IOverlay;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;

/* compiled from: GroundOverlayDelegateImp */
class x implements aa {
    private final double a = 0.01745329251994329d;
    private final double b = 6371000.79d;
    private y c;
    private BitmapDescriptor d;
    private LatLng e;
    private float f;
    private float g;
    private LatLngBounds h;
    private float i;
    private float j;
    private boolean k = true;
    private float l = 0.0f;
    private float m = 0.5f;
    private float n = 0.5f;
    private String o;
    private Bitmap p;

    x(y yVar) {
        this.c = yVar;
        try {
            this.o = getId();
        } catch (RemoteException e2) {
            cm.a(e2, "GroundOverlayDelegateImp", "GroundOverlayDelegateImp");
        }
    }

    @Override // com.amap.api.interfaces.IOverlay
    public void remove() throws RemoteException {
        this.c.removeGLOverlay(getId());
    }

    @Override // com.amap.api.interfaces.IOverlay
    public String getId() throws RemoteException {
        if (this.o == null) {
            this.o = v.a("GroundOverlay");
        }
        return this.o;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public void setZIndex(float f2) throws RemoteException {
        this.j = f2;
        this.c.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IOverlay
    public float getZIndex() throws RemoteException {
        return this.j;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public void setVisible(boolean z) throws RemoteException {
        this.k = z;
        this.c.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IOverlay
    public boolean isVisible() throws RemoteException {
        return this.k;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.amap.api.interfaces.IOverlay
    public int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    public void b() throws RemoteException {
        if (this.e == null) {
            d();
        } else if (this.h == null) {
            c();
        }
    }

    private void c() {
        double cos = ((double) this.f) / ((Math.cos(this.e.latitude * 0.01745329251994329d) * 6371000.79d) * 0.01745329251994329d);
        double d2 = ((double) this.g) / 111194.94043265979d;
        try {
            this.h = new LatLngBounds(new LatLng(this.e.latitude - (((double) (1.0f - this.n)) * d2), this.e.longitude - (((double) this.m) * cos)), new LatLng(this.e.latitude + (((double) this.n) * d2), this.e.longitude + (((double) (1.0f - this.m)) * cos)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void d() {
        LatLng latLng = this.h.southwest;
        LatLng latLng2 = this.h.northeast;
        LatLng latLng3 = new LatLng(latLng.latitude + (((double) (1.0f - this.n)) * (latLng2.latitude - latLng.latitude)), latLng.longitude + (((double) this.m) * (latLng2.longitude - latLng.longitude)));
        this.e = latLng3;
        this.f = (float) (Math.cos(latLng3.latitude * 0.01745329251994329d) * 6371000.79d * (latLng2.longitude - latLng.longitude) * 0.01745329251994329d);
        this.g = (float) ((latLng2.latitude - latLng.latitude) * 6371000.79d * 0.01745329251994329d);
    }

    @Override // com.amap.api.interfaces.IOverlay
    public void destroy() {
        Bitmap bitmap;
        try {
            remove();
            BitmapDescriptor bitmapDescriptor = this.d;
            if (!(bitmapDescriptor == null || (bitmap = bitmapDescriptor.getBitmap()) == null)) {
                bitmap.recycle();
                this.d = null;
            }
            this.e = null;
            this.h = null;
        } catch (Exception e2) {
            cm.a(e2, "GroundOverlayDelegateImp", "destroy");
            Log.d("destroy erro", "GroundOverlayDelegateImp destroy");
        }
    }

    @Override // com.amap.api.mapcore2d.ad
    public boolean a() {
        if (this.h == null) {
            return false;
        }
        LatLngBounds mapBounds = this.c.getMapBounds();
        if (mapBounds != null && !mapBounds.contains(this.h) && !this.h.intersects(mapBounds)) {
            return false;
        }
        return true;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public void setPosition(LatLng latLng) throws RemoteException {
        LatLng latLng2 = this.e;
        if (latLng2 == null || latLng2.equals(latLng)) {
            this.e = latLng;
            return;
        }
        this.e = latLng;
        c();
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public LatLng getPosition() throws RemoteException {
        return this.e;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public void setDimensions(float f2) throws RemoteException {
        if (f2 <= 0.0f) {
            Log.w("GroundOverlayDelegateImp", "Width must be non-negative");
        }
        if (this.f != f2) {
            this.f = f2;
            this.g = f2;
            return;
        }
        this.f = f2;
        this.g = f2;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public void setDimensions(float f2, float f3) throws RemoteException {
        if (f2 <= 0.0f || f3 <= 0.0f) {
            Log.w("GroundOverlayDelegateImp", "Width and Height must be non-negative");
        }
        if (this.f == f2 || this.g == f3) {
            this.f = f2;
            this.g = f3;
            return;
        }
        this.f = f2;
        this.g = f3;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public float getWidth() throws RemoteException {
        return this.f;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public float getHeight() throws RemoteException {
        return this.g;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public void setPositionFromBounds(LatLngBounds latLngBounds) throws RemoteException {
        LatLngBounds latLngBounds2 = this.h;
        if (latLngBounds2 == null || latLngBounds2.equals(latLngBounds)) {
            this.h = latLngBounds;
            return;
        }
        this.h = latLngBounds;
        d();
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public LatLngBounds getBounds() throws RemoteException {
        return this.h;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public void setBearing(float f2) throws RemoteException {
        float f3 = (((-f2) % 360.0f) + 360.0f) % 360.0f;
        if (Double.doubleToLongBits((double) this.i) != Double.doubleToLongBits((double) f3)) {
            this.i = f3;
        } else {
            this.i = f3;
        }
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public float getBearing() throws RemoteException {
        return this.i;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public void setTransparency(float f2) throws RemoteException {
        if (f2 < 0.0f) {
            Log.w("GroundOverlayDelegateImp", "Transparency must be in the range [0..1]");
        }
        this.l = f2;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public float getTransparency() throws RemoteException {
        return this.l;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public void setImage(BitmapDescriptor bitmapDescriptor) throws RemoteException {
        this.d = bitmapDescriptor;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public void setAnchor(float f2, float f3) throws RemoteException {
        this.m = f2;
        this.n = f3;
    }

    @Override // com.amap.api.mapcore2d.ad
    public void a(Canvas canvas) throws RemoteException {
        if (!this.k) {
            return;
        }
        if ((this.e != null || this.h != null) && this.d != null) {
            b();
            if (this.f != 0.0f || this.g != 0.0f) {
                Bitmap bitmap = this.d.getBitmap();
                this.p = bitmap;
                if (bitmap != null && !bitmap.isRecycled()) {
                    LatLng latLng = this.h.southwest;
                    LatLng latLng2 = this.h.northeast;
                    LatLng latLng3 = this.e;
                    w a2 = a(latLng);
                    w a3 = a(latLng2);
                    w a4 = a(latLng3);
                    Point point = new Point();
                    Point point2 = new Point();
                    Point point3 = new Point();
                    this.c.d().a(a2, point);
                    this.c.d().a(a3, point2);
                    this.c.d().a(a4, point3);
                    Paint paint = new Paint();
                    RectF rectF = new RectF((float) point.x, (float) point2.y, (float) point2.x, (float) point.y);
                    paint.setAlpha((int) (255.0f - (this.l * 255.0f)));
                    paint.setFilterBitmap(true);
                    canvas.save();
                    canvas.rotate(this.i, (float) point3.x, (float) point3.y);
                    canvas.drawBitmap(this.p, (Rect) null, rectF, paint);
                    canvas.restore();
                }
            }
        }
    }

    private w a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new w((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
    }
}
