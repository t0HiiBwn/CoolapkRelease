package com.amap.api.mapcore2d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.interfaces.IMarker;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MarkerDelegateImp */
class ay implements ab {
    private static int a;
    private int b = 0;
    private float c = 0.0f;
    private CopyOnWriteArrayList<BitmapDescriptor> d = null;
    private int e = 20;
    private String f;
    private LatLng g;
    private LatLng h;
    private String i;
    private String j;
    private float k = 0.5f;

    /* renamed from: l  reason: collision with root package name */
    private float f1219l = 1.0f;
    private boolean m = false;
    private boolean n = true;
    private at o;
    private Object p;
    private boolean q = false;
    private a r;
    private boolean s = false;
    private int t;
    private int u;
    private float v;
    private int w;

    static /* synthetic */ int c(ay ayVar) {
        int i2 = ayVar.b;
        ayVar.b = i2 + 1;
        return i2;
    }

    private static String a(String str) {
        a++;
        return str + a;
    }

    @Override // com.amap.api.interfaces.IMarker
    public void destroy() {
        try {
            CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
            if (copyOnWriteArrayList == null) {
                this.g = null;
                this.p = null;
                this.r = null;
                return;
            }
            Iterator<BitmapDescriptor> it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                BitmapDescriptor next = it2.next();
                if (next != null) {
                    Bitmap bitmap = next.getBitmap();
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                }
            }
            this.d = null;
            this.g = null;
            this.p = null;
            this.r = null;
            at atVar = this.o;
            if (atVar != null && atVar.a != null) {
                this.o.a.postInvalidate();
            }
        } catch (Exception e2) {
            cm.a(e2, "MarkerDelegateImp", "destroy");
            Log.d("destroy erro", "MarkerDelegateImp destroy");
        }
    }

    void c() {
        CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList == null) {
            this.d = new CopyOnWriteArrayList<>();
        } else {
            copyOnWriteArrayList.clear();
        }
    }

    public void a(ArrayList<BitmapDescriptor> arrayList) {
        try {
            c();
            if (arrayList != null) {
                Iterator<BitmapDescriptor> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    BitmapDescriptor next = it2.next();
                    if (next != null) {
                        this.d.add(next.clone());
                    }
                }
                if (arrayList.size() > 1 && this.r == null) {
                    a aVar = new a();
                    this.r = aVar;
                    aVar.start();
                }
            }
            this.o.a().postInvalidate();
        } catch (Throwable th) {
            cm.a(th, "MarkerDelegateImp", "setBitmapDescriptor");
        }
    }

    private void a(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            c();
            this.d.add(bitmapDescriptor.clone());
        }
        this.o.a().postInvalidate();
    }

    public ay(MarkerOptions markerOptions, at atVar) {
        this.o = atVar;
        this.q = markerOptions.isGps();
        this.v = markerOptions.getZIndex();
        if (markerOptions.getPosition() != null) {
            if (this.q) {
                try {
                    double[] a2 = fy.a(markerOptions.getPosition().longitude, markerOptions.getPosition().latitude);
                    this.h = new LatLng(a2[1], a2[0]);
                } catch (Exception e2) {
                    cm.a(e2, "MarkerDelegateImp", "MarkerDelegateImp");
                    this.h = markerOptions.getPosition();
                }
            }
            this.g = markerOptions.getPosition();
        }
        this.k = markerOptions.getAnchorU();
        this.f1219l = markerOptions.getAnchorV();
        this.n = markerOptions.isVisible();
        this.j = markerOptions.getSnippet();
        this.i = markerOptions.getTitle();
        this.m = markerOptions.isDraggable();
        this.e = markerOptions.getPeriod();
        this.f = getId();
        a(markerOptions.getIcons());
        CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() == 0) {
            a(markerOptions.getIcon());
        }
    }

    public ae d() {
        w wVar;
        if (getPosition() == null) {
            return null;
        }
        ae aeVar = new ae();
        try {
            if (this.q) {
                wVar = new w((int) (getRealPosition().latitude * 1000000.0d), (int) (getRealPosition().longitude * 1000000.0d));
            } else {
                wVar = new w((int) (getPosition().latitude * 1000000.0d), (int) (getPosition().longitude * 1000000.0d));
            }
            Point point = new Point();
            this.o.a().d().a(wVar, point);
            aeVar.a = point.x;
            aeVar.b = point.y;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return aeVar;
    }

    @Override // com.amap.api.interfaces.IMarker
    public int getWidth() {
        if (f() != null) {
            return f().getWidth();
        }
        return 0;
    }

    @Override // com.amap.api.interfaces.IMarker
    public int getHeight() {
        if (f() != null) {
            return f().getHeight();
        }
        return 0;
    }

    @Override // com.amap.api.mapcore2d.ab
    public s b() {
        s sVar = new s();
        CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
        if (!(copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0)) {
            sVar.a = (double) (((float) getWidth()) * this.k);
            sVar.b = (double) (((float) getHeight()) * this.f1219l);
        }
        return sVar;
    }

    public ae e() {
        ae d2 = d();
        if (d2 == null) {
            return null;
        }
        return d2;
    }

    @Override // com.amap.api.mapcore2d.ab
    public Rect a() {
        ae e2 = e();
        if (e2 == null) {
            return new Rect(0, 0, 0, 0);
        }
        try {
            int width = getWidth();
            int height = getHeight();
            Rect rect = new Rect();
            if (this.c == 0.0f) {
                float f2 = (float) height;
                rect.top = (int) (((float) e2.b) - (this.f1219l * f2));
                float f3 = (float) width;
                rect.left = (int) (((float) e2.a) - (this.k * f3));
                rect.bottom = (int) (((float) e2.b) + (f2 * (1.0f - this.f1219l)));
                rect.right = (int) (((float) e2.a) + ((1.0f - this.k) * f3));
            } else {
                float f4 = (float) width;
                float f5 = (float) height;
                ae a2 = a((-this.k) * f4, (this.f1219l - 1.0f) * f5);
                ae a3 = a((-this.k) * f4, this.f1219l * f5);
                ae a4 = a((1.0f - this.k) * f4, this.f1219l * f5);
                ae a5 = a((1.0f - this.k) * f4, (this.f1219l - 1.0f) * f5);
                rect.top = e2.b - Math.max(a2.b, Math.max(a3.b, Math.max(a4.b, a5.b)));
                rect.left = e2.a + Math.min(a2.a, Math.min(a3.a, Math.min(a4.a, a5.a)));
                rect.bottom = e2.b - Math.min(a2.b, Math.min(a3.b, Math.min(a4.b, a5.b)));
                rect.right = e2.a + Math.max(a2.a, Math.max(a3.a, Math.max(a4.a, a5.a)));
            }
            return rect;
        } catch (Throwable th) {
            cm.a(th, "MarkerDelegateImp", "getRect");
            return new Rect(0, 0, 0, 0);
        }
    }

    private ae a(float f2, float f3) {
        ae aeVar = new ae();
        double d2 = (double) f2;
        double d3 = (double) ((float) ((((double) this.c) * 3.141592653589793d) / 180.0d));
        double d4 = (double) f3;
        aeVar.a = (int) ((Math.cos(d3) * d2) + (Math.sin(d3) * d4));
        aeVar.b = (int) ((d4 * Math.cos(d3)) - (d2 * Math.sin(d3)));
        return aeVar;
    }

    @Override // com.amap.api.interfaces.IMarker
    public boolean remove() {
        return this.o.b(this);
    }

    @Override // com.amap.api.interfaces.IMarker
    public LatLng getPosition() {
        if (!this.s) {
            return this.g;
        }
        s sVar = new s();
        this.o.a.a(this.t, this.u, sVar);
        return new LatLng(sVar.b, sVar.a);
    }

    @Override // com.amap.api.interfaces.IMarker
    public String getId() {
        if (this.f == null) {
            this.f = a("Marker");
        }
        return this.f;
    }

    @Override // com.amap.api.interfaces.IMarker
    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            if (this.q) {
                try {
                    double[] a2 = fy.a(latLng.longitude, latLng.latitude);
                    this.h = new LatLng(a2[1], a2[0]);
                } catch (Exception e2) {
                    cm.a(e2, "MarkerDelegateImp", "setPosition");
                    this.h = latLng;
                }
            }
            this.s = false;
            this.g = latLng;
            this.o.a().postInvalidate();
        }
    }

    @Override // com.amap.api.mapcore2d.ab
    public void a(LatLng latLng) {
        if (this.q) {
            this.h = latLng;
        } else {
            this.g = latLng;
        }
        try {
            Point screenLocation = this.o.a().getAMapProjection().toScreenLocation(latLng);
            this.t = screenLocation.x;
            this.u = screenLocation.y;
        } catch (Throwable th) {
            cm.a(th, "MarkerDelegateImp", "setOffSetPosition");
        }
    }

    @Override // com.amap.api.interfaces.IMarker
    public void setTitle(String str) {
        this.i = str;
    }

    @Override // com.amap.api.interfaces.IMarker
    public String getTitle() {
        return this.i;
    }

    @Override // com.amap.api.interfaces.IMarker
    public void setSnippet(String str) {
        this.j = str;
    }

    @Override // com.amap.api.interfaces.IMarker
    public String getSnippet() {
        return this.j;
    }

    @Override // com.amap.api.interfaces.IMarker
    public void setDraggable(boolean z) {
        this.m = z;
    }

    @Override // com.amap.api.interfaces.IMarker
    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
                if (copyOnWriteArrayList != null) {
                    copyOnWriteArrayList.clear();
                    this.d.add(bitmapDescriptor);
                    if (isInfoWindowShown()) {
                        this.o.e(this);
                        this.o.d(this);
                    }
                    this.o.a().postInvalidate();
                }
            } catch (Throwable th) {
                cm.a(th, "MarkerDelegateImp", "setIcon");
            }
        }
    }

    public BitmapDescriptor f() {
        CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        if (copyOnWriteArrayList.size() == 0) {
            c();
            this.d.add(BitmapDescriptorFactory.defaultMarker());
        } else if (this.d.get(0) == null) {
            this.d.clear();
            return f();
        }
        return this.d.get(0);
    }

    @Override // com.amap.api.interfaces.IMarker
    public boolean isDraggable() {
        return this.m;
    }

    @Override // com.amap.api.interfaces.IMarker
    public void showInfoWindow() {
        if (isVisible()) {
            this.o.d(this);
        }
    }

    @Override // com.amap.api.interfaces.IMarker
    public void hideInfoWindow() {
        if (isInfoWindowShown()) {
            this.o.e(this);
        }
    }

    @Override // com.amap.api.interfaces.IMarker
    public boolean isInfoWindowShown() {
        return this.o.f(this);
    }

    @Override // com.amap.api.interfaces.IMarker
    public void setVisible(boolean z) {
        this.n = z;
        if (!z && isInfoWindowShown()) {
            this.o.e(this);
        }
        this.o.a().postInvalidate();
    }

    @Override // com.amap.api.interfaces.IMarker
    public boolean isVisible() {
        return this.n;
    }

    @Override // com.amap.api.interfaces.IMarker
    public void setAnchor(float f2, float f3) {
        if (this.k != f2 || this.f1219l != f3) {
            this.k = f2;
            this.f1219l = f3;
            if (isInfoWindowShown()) {
                this.o.e(this);
                this.o.d(this);
            }
            this.o.a().postInvalidate();
        }
    }

    public float g() {
        return this.k;
    }

    public float h() {
        return this.f1219l;
    }

    @Override // com.amap.api.interfaces.IMarker
    public void setRotateAngle(float f2) {
        this.c = (((-f2) % 360.0f) + 360.0f) % 360.0f;
        if (isInfoWindowShown()) {
            this.o.e(this);
            this.o.d(this);
        }
        this.o.a().postInvalidate();
    }

    @Override // com.amap.api.interfaces.IMarker
    public boolean equalsRemote(IMarker iMarker) {
        if (iMarker != null) {
            return equals(iMarker) || iMarker.getId().equals(getId());
        }
        return false;
    }

    @Override // com.amap.api.interfaces.IMarker
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.amap.api.mapcore2d.ab
    public void a(Canvas canvas, y yVar) {
        ae aeVar;
        Bitmap bitmap;
        if (this.n && getPosition() != null && f() != null) {
            if (isViewMode()) {
                aeVar = new ae(this.t, this.u);
            } else {
                aeVar = e();
            }
            ArrayList<BitmapDescriptor> icons = getIcons();
            if (icons != null) {
                if (icons.size() > 1) {
                    bitmap = icons.get(this.b).getBitmap();
                } else {
                    bitmap = icons.size() == 1 ? icons.get(0).getBitmap() : null;
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    canvas.save();
                    canvas.rotate(this.c, (float) aeVar.a, (float) aeVar.b);
                    canvas.drawBitmap(bitmap, ((float) aeVar.a) - (g() * ((float) bitmap.getWidth())), ((float) aeVar.b) - (h() * ((float) bitmap.getHeight())), (Paint) null);
                    canvas.restore();
                }
            }
        }
    }

    @Override // com.amap.api.interfaces.IMarker
    public void setObject(Object obj) {
        this.p = obj;
    }

    @Override // com.amap.api.interfaces.IMarker
    public Object getObject() {
        return this.p;
    }

    @Override // com.amap.api.interfaces.IMarker
    public LatLng getRealPosition() {
        if (!this.s) {
            return this.q ? this.h : this.g;
        }
        s sVar = new s();
        this.o.a.a(this.t, this.u, sVar);
        return new LatLng(sVar.b, sVar.a);
    }

    @Override // com.amap.api.interfaces.IMarker
    public void setPeriod(int i2) throws RemoteException {
        if (i2 <= 1) {
            this.e = 1;
        } else {
            this.e = i2;
        }
    }

    @Override // com.amap.api.interfaces.IMarker
    public int getPeriod() throws RemoteException {
        return this.e;
    }

    @Override // com.amap.api.interfaces.IMarker
    public void setIcons(ArrayList<BitmapDescriptor> arrayList) throws RemoteException {
        if (arrayList != null) {
            a(arrayList);
            if (this.r == null) {
                a aVar = new a();
                this.r = aVar;
                aVar.start();
            }
            if (isInfoWindowShown()) {
                this.o.e(this);
                this.o.d(this);
            }
            this.o.a().postInvalidate();
        }
    }

    @Override // com.amap.api.interfaces.IMarker
    public ArrayList<BitmapDescriptor> getIcons() {
        CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return null;
        }
        ArrayList<BitmapDescriptor> arrayList = new ArrayList<>();
        Iterator<BitmapDescriptor> it2 = this.d.iterator();
        while (it2.hasNext()) {
            BitmapDescriptor next = it2.next();
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @Override // com.amap.api.interfaces.IMarker
    public void setPositionByPixels(int i2, int i3) {
        this.t = i2;
        this.u = i3;
        this.s = true;
        if (isInfoWindowShown()) {
            showInfoWindow();
        }
    }

    @Override // com.amap.api.interfaces.IMarker
    public boolean isViewMode() {
        return this.s;
    }

    /* compiled from: MarkerDelegateImp */
    private class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                setName("MarkerThread");
                while (!Thread.currentThread().isInterrupted() && ay.this.d != null && ay.this.d.size() > 1) {
                    if (ay.this.b == ay.this.d.size() - 1) {
                        ay.this.b = 0;
                    } else {
                        ay.c(ay.this);
                    }
                    ay.this.o.a().postInvalidate();
                    try {
                        Thread.sleep((long) (ay.this.e * 250));
                    } catch (InterruptedException e) {
                        cm.a(e, "MarkerDelegateImp", "run");
                    }
                    if (ay.this.d == null) {
                        Thread.currentThread().interrupt();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.interfaces.IMarker
    public void setZIndex(float f2) {
        this.v = f2;
        this.o.d();
    }

    @Override // com.amap.api.interfaces.IMarker, com.amap.api.mapcore2d.ac
    public float getZIndex() {
        return this.v;
    }

    @Override // com.amap.api.mapcore2d.ac
    public void setAddIndex(int i2) {
        this.w = i2;
    }

    @Override // com.amap.api.mapcore2d.ac
    public int getAddIndex() {
        return this.w;
    }
}
