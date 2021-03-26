package com.amap.api.mapcore2d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.interfaces.IOverlay;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PolygonDelegateImp */
class be implements af {
    private y a;
    private float b = 0.0f;
    private boolean c = true;
    private String d;
    private float e;
    private int f;
    private int g;
    private List<LatLng> h;
    private List<ae> i = new ArrayList();
    private LatLngBounds j = null;

    @Override // com.amap.api.interfaces.IOverlay
    public void destroy() {
    }

    public be(y yVar) {
        this.a = yVar;
        try {
            this.d = getId();
        } catch (RemoteException e2) {
            cm.a(e2, "PolygonDelegateImp", "PolygonDelegateImp");
        }
    }

    @Override // com.amap.api.interfaces.IOverlay
    public void remove() throws RemoteException {
        this.a.removeGLOverlay(getId());
    }

    @Override // com.amap.api.interfaces.IOverlay
    public String getId() throws RemoteException {
        if (this.d == null) {
            this.d = v.a("Polygon");
        }
        return this.d;
    }

    @Override // com.amap.api.interfaces.IPolygon
    public void setPoints(List<LatLng> list) throws RemoteException {
        this.h = list;
        a(list);
    }

    @Override // com.amap.api.interfaces.IPolygon
    public List<LatLng> getPoints() throws RemoteException {
        return b();
    }

    @Override // com.amap.api.interfaces.IOverlay
    public void setZIndex(float f2) throws RemoteException {
        this.b = f2;
        this.a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IOverlay
    public float getZIndex() throws RemoteException {
        return this.b;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public void setVisible(boolean z) throws RemoteException {
        this.c = z;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public boolean isVisible() throws RemoteException {
        return this.c;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    void a(List<LatLng> list) throws RemoteException {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        this.i.clear();
        if (list != null) {
            Object obj = null;
            for (LatLng latLng : list) {
                if (latLng != null && !latLng.equals(obj)) {
                    ae aeVar = new ae();
                    this.a.a(latLng.latitude, latLng.longitude, aeVar);
                    this.i.add(aeVar);
                    builder.include(latLng);
                    obj = latLng;
                }
            }
            int size = this.i.size();
            if (size > 1) {
                ae aeVar2 = this.i.get(0);
                int i2 = size - 1;
                ae aeVar3 = this.i.get(i2);
                if (aeVar2.a == aeVar3.a && aeVar2.b == aeVar3.b) {
                    this.i.remove(i2);
                }
            }
        }
        this.j = builder.build();
    }

    List<LatLng> b() throws RemoteException {
        if (this.i == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ae aeVar : this.i) {
            if (aeVar != null) {
                s sVar = new s();
                this.a.b(aeVar.a, aeVar.b, sVar);
                arrayList.add(new LatLng(sVar.b, sVar.a));
            }
        }
        return arrayList;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    @Override // com.amap.api.mapcore2d.ad
    public boolean a() {
        if (this.j == null) {
            return false;
        }
        LatLngBounds mapBounds = this.a.getMapBounds();
        if (mapBounds != null && !this.j.contains(mapBounds) && !this.j.intersects(mapBounds)) {
            return false;
        }
        return true;
    }

    @Override // com.amap.api.mapcore2d.ad
    public void a(Canvas canvas) throws RemoteException {
        List<ae> list = this.i;
        if (!(list == null || list.size() == 0)) {
            Path path = new Path();
            Point a2 = this.a.d().a(new w(this.i.get(0).b, this.i.get(0).a), new Point());
            path.moveTo((float) a2.x, (float) a2.y);
            for (int i2 = 1; i2 < this.i.size(); i2++) {
                Point a3 = this.a.d().a(new w(this.i.get(i2).b, this.i.get(i2).a), new Point());
                path.lineTo((float) a3.x, (float) a3.y);
            }
            Paint paint = new Paint();
            paint.setColor(getFillColor());
            paint.setAntiAlias(true);
            path.close();
            paint.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, paint);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(getStrokeColor());
            paint.setStrokeWidth(getStrokeWidth());
            canvas.drawPath(path, paint);
        }
    }

    @Override // com.amap.api.interfaces.IPolygon
    public void setStrokeWidth(float f2) throws RemoteException {
        this.e = f2;
    }

    @Override // com.amap.api.interfaces.IPolygon
    public float getStrokeWidth() throws RemoteException {
        return this.e;
    }

    @Override // com.amap.api.interfaces.IPolygon
    public void setFillColor(int i2) throws RemoteException {
        this.f = i2;
    }

    @Override // com.amap.api.interfaces.IPolygon
    public int getFillColor() throws RemoteException {
        return this.f;
    }

    @Override // com.amap.api.interfaces.IPolygon
    public void setStrokeColor(int i2) throws RemoteException {
        this.g = i2;
    }

    @Override // com.amap.api.interfaces.IPolygon
    public int getStrokeColor() throws RemoteException {
        return this.g;
    }

    @Override // com.amap.api.interfaces.IPolygon
    public boolean contains(LatLng latLng) throws RemoteException {
        return cm.a(latLng, getPoints());
    }
}
