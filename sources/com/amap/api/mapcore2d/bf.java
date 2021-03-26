package com.amap.api.mapcore2d;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.interfaces.IOverlay;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PolylineDelegateImp */
class bf implements ag {
    private y a;
    private float b = 10.0f;
    private int c = -16777216;
    private float d = 0.0f;
    private boolean e = true;
    private boolean f = false;
    private boolean g = false;
    private String h;
    private List<ae> i = new ArrayList();
    private List<LatLng> j = new ArrayList();
    private LatLngBounds k = null;

    @Override // com.amap.api.interfaces.IOverlay
    public void destroy() {
    }

    public bf(y yVar) {
        this.a = yVar;
        try {
            this.h = getId();
        } catch (RemoteException e2) {
            cm.a(e2, "PolylineDelegateImp", "PolylineDelegateImp");
        }
    }

    void a(List<LatLng> list) throws RemoteException {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    LatLngBounds.Builder builder = LatLngBounds.builder();
                    this.i.clear();
                    if (list != null) {
                        LatLng latLng = null;
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            LatLng latLng2 = list.get(i2);
                            if (latLng2 != null) {
                                if (!latLng2.equals(latLng)) {
                                    if (!this.g) {
                                        ae aeVar = new ae();
                                        this.a.a(latLng2.latitude, latLng2.longitude, aeVar);
                                        this.i.add(aeVar);
                                        builder.include(latLng2);
                                    } else if (latLng != null) {
                                        if (Math.abs(latLng2.longitude - latLng.longitude) < 0.01d) {
                                            ae aeVar2 = new ae();
                                            this.a.a(latLng.latitude, latLng.longitude, aeVar2);
                                            this.i.add(aeVar2);
                                            builder.include(latLng);
                                            ae aeVar3 = new ae();
                                            this.a.a(latLng2.latitude, latLng2.longitude, aeVar3);
                                            this.i.add(aeVar3);
                                            builder.include(latLng2);
                                        } else {
                                            a(latLng, latLng2, this.i, builder);
                                        }
                                    }
                                    latLng = latLng2;
                                }
                            }
                        }
                    }
                    if (this.i.size() > 0) {
                        this.k = builder.build();
                    }
                }
            } catch (Throwable th) {
                cm.a(th, "PolylineDelegateImp", "calLatLng2Geo");
            }
        }
    }

    @Override // com.amap.api.interfaces.IOverlay
    public void remove() throws RemoteException {
        this.a.removeGLOverlay(getId());
    }

    @Override // com.amap.api.interfaces.IOverlay
    public String getId() throws RemoteException {
        if (this.h == null) {
            this.h = v.a("Polyline");
        }
        return this.h;
    }

    @Override // com.amap.api.interfaces.IPolyline
    public void setPoints(List<LatLng> list) throws RemoteException {
        if (this.g || this.f) {
            this.j = list;
        }
        a(list);
    }

    @Override // com.amap.api.interfaces.IPolyline
    public List<LatLng> getPoints() throws RemoteException {
        if (this.g || this.f) {
            return this.j;
        }
        return b();
    }

    private List<LatLng> b() throws RemoteException {
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

    @Override // com.amap.api.interfaces.IPolyline
    public void setWidth(float f2) throws RemoteException {
        this.b = f2;
    }

    @Override // com.amap.api.interfaces.IPolyline
    public float getWidth() throws RemoteException {
        return this.b;
    }

    @Override // com.amap.api.interfaces.IPolyline
    public void setDottedLine(boolean z) {
        this.f = z;
    }

    @Override // com.amap.api.interfaces.IPolyline
    public boolean isDottedLine() {
        return this.f;
    }

    @Override // com.amap.api.interfaces.IPolyline
    public void setGeodesic(boolean z) throws RemoteException {
        if (this.g != z) {
            this.g = z;
        }
    }

    @Override // com.amap.api.interfaces.IPolyline
    public boolean isGeodesic() {
        return this.g;
    }

    @Override // com.amap.api.interfaces.IPolyline
    public void setColor(int i2) throws RemoteException {
        this.c = i2;
    }

    @Override // com.amap.api.interfaces.IPolyline
    public int getColor() throws RemoteException {
        return this.c;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public void setZIndex(float f2) throws RemoteException {
        this.d = f2;
        this.a.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IOverlay
    public float getZIndex() throws RemoteException {
        return this.d;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public void setVisible(boolean z) throws RemoteException {
        this.e = z;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public boolean isVisible() throws RemoteException {
        return this.e;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.amap.api.interfaces.IOverlay
    public int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    @Override // com.amap.api.mapcore2d.ad
    public boolean a() {
        if (this.k == null) {
            return false;
        }
        LatLngBounds mapBounds = this.a.getMapBounds();
        if (mapBounds != null && !mapBounds.contains(this.k) && !this.k.intersects(mapBounds)) {
            return false;
        }
        return true;
    }

    @Override // com.amap.api.mapcore2d.ad
    public void a(Canvas canvas) throws RemoteException {
        List<ae> list = this.i;
        if (list != null && list.size() != 0 && this.b > 0.0f) {
            try {
                Path path = new Path();
                Point a2 = this.a.d().a(new w(this.i.get(0).b, this.i.get(0).a), new Point());
                path.moveTo((float) a2.x, (float) a2.y);
                for (int i2 = 1; i2 < this.i.size(); i2++) {
                    Point a3 = this.a.d().a(new w(this.i.get(i2).b, this.i.get(i2).a), new Point());
                    path.lineTo((float) a3.x, (float) a3.y);
                }
                Paint paint = new Paint();
                paint.setColor(getColor());
                paint.setAntiAlias(true);
                paint.setStrokeWidth(getWidth());
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeJoin(Paint.Join.ROUND);
                if (this.f) {
                    int width = (int) getWidth();
                    float f2 = (float) (width * 3);
                    float f3 = (float) width;
                    paint.setPathEffect(new DashPathEffect(new float[]{f2, f3, f2, f3}, 1.0f));
                }
                canvas.drawPath(path, paint);
            } catch (Throwable th) {
                cm.a(th, "PolylineDelegateImp", "draw");
            }
        }
    }

    ae a(ae aeVar, ae aeVar2, ae aeVar3, double d2, int i2) {
        ae aeVar4 = new ae();
        double d3 = (double) (aeVar2.a - aeVar.a);
        double d4 = (double) (aeVar2.b - aeVar.b);
        aeVar4.b = (int) (((((double) i2) * d2) / Math.sqrt(((d4 * d4) / (d3 * d3)) + 1.0d)) + ((double) aeVar3.b));
        aeVar4.a = (int) (((((double) (aeVar3.b - aeVar4.b)) * d4) / d3) + ((double) aeVar3.a));
        return aeVar4;
    }

    void a(List<ae> list, List<ae> list2, double d2) {
        if (list.size() == 3) {
            int i2 = 0;
            int i3 = 0;
            while (i3 <= 10) {
                float f2 = (float) i3;
                float f3 = f2 / 10.0f;
                ae aeVar = new ae();
                double d3 = 1.0d - ((double) f3);
                double d4 = d3 * d3;
                double d5 = ((double) (2.0f * f3)) * d3;
                float f4 = f3 * f3;
                double d6 = (((double) list.get(i2).a) * d4) + (((double) list.get(1).a) * d5 * d2) + ((double) (((float) list.get(2).a) * f4));
                double d7 = (((double) list.get(i2).b) * d4) + (((double) list.get(1).b) * d5 * d2) + ((double) (((float) list.get(2).b) * f4));
                double d8 = d4 + (d5 * d2) + ((double) f4);
                aeVar.a = (int) (d6 / d8);
                aeVar.b = (int) (d7 / d8);
                list2.add(aeVar);
                i3 = (int) (f2 + 1.0f);
                i2 = 0;
            }
        }
    }

    void a(LatLng latLng, LatLng latLng2, List<ae> list, LatLngBounds.Builder builder) {
        double abs = (Math.abs(latLng.longitude - latLng2.longitude) * 3.141592653589793d) / 180.0d;
        LatLng latLng3 = new LatLng((latLng2.latitude + latLng.latitude) / 2.0d, (latLng2.longitude + latLng.longitude) / 2.0d);
        builder.include(latLng).include(latLng3).include(latLng2);
        int i2 = latLng3.latitude > 0.0d ? 1 : -1;
        ae aeVar = new ae();
        this.a.a(latLng.latitude, latLng.longitude, aeVar);
        ae aeVar2 = new ae();
        this.a.a(latLng2.latitude, latLng2.longitude, aeVar2);
        ae aeVar3 = new ae();
        this.a.a(latLng3.latitude, latLng3.longitude, aeVar3);
        double d2 = abs * 0.5d;
        double cos = Math.cos(d2);
        ae a2 = a(aeVar, aeVar2, aeVar3, Math.hypot((double) (aeVar.a - aeVar2.a), (double) (aeVar.b - aeVar2.b)) * 0.5d * Math.tan(d2), i2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(aeVar);
        arrayList.add(a2);
        arrayList.add(aeVar2);
        a(arrayList, list, cos);
    }
}
