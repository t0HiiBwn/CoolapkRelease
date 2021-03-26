package com.amap.api.mapcore2d;

import android.graphics.Canvas;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.GroundOverlayOptions;
import com.amap.api.maps2d.model.PolygonOptions;
import com.amap.api.maps2d.model.PolylineOptions;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: GLOverlayLayer */
class v {
    private static int b;
    y a;
    private CopyOnWriteArrayList<ad> c = new CopyOnWriteArrayList<>();
    private a d = new a();
    private Handler e = new Handler();
    private Runnable f = new Runnable() {
        /* class com.amap.api.mapcore2d.v.AnonymousClass1 */

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                Object[] array = v.this.c.toArray();
                Arrays.sort(array, v.this.d);
                v.this.c.clear();
                for (Object obj : array) {
                    v.this.c.add((ad) obj);
                }
            } catch (Throwable th) {
                Cdo.c(th, "MapOverlayImageView", "changeOverlayIndex");
            }
            return;
        }
    };

    public static synchronized String a(String str) {
        String str2;
        synchronized (v.class) {
            b++;
            str2 = str + b;
        }
        return str2;
    }

    /* compiled from: GLOverlayLayer */
    private class a implements Comparator<Object> {
        private a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            ad adVar = (ad) obj;
            ad adVar2 = (ad) obj2;
            if (adVar == null || adVar2 == null) {
                return 0;
            }
            try {
                if (adVar.getZIndex() > adVar2.getZIndex()) {
                    return 1;
                }
                if (adVar.getZIndex() < adVar2.getZIndex()) {
                    return -1;
                }
                return 0;
            } catch (Exception e) {
                cm.a(e, "GLOverlayLayer", "compare");
                return 0;
            }
        }
    }

    public v(y yVar) {
        this.a = yVar;
    }

    public void a() {
        Iterator<ad> it2 = this.c.iterator();
        while (it2.hasNext()) {
            it2.next().destroy();
        }
        try {
            Iterator<ad> it3 = this.c.iterator();
            while (it3.hasNext()) {
                it3.next().destroy();
            }
            this.c.clear();
        } catch (Exception e2) {
            cm.a(e2, "GLOverlayLayer", "clear");
            Log.d("amapApi", "GLOverlayLayer clear erro" + e2.getMessage());
        }
    }

    public void b() {
        try {
            Iterator<ad> it2 = this.c.iterator();
            while (it2.hasNext()) {
                it2.next().destroy();
            }
            a();
        } catch (Exception e2) {
            cm.a(e2, "GLOverlayLayer", "destory");
            Log.d("amapApi", "GLOverlayLayer destory erro" + e2.getMessage());
        }
    }

    private ad c(String str) throws RemoteException {
        Iterator<ad> it2 = this.c.iterator();
        while (it2.hasNext()) {
            ad next = it2.next();
            if (next != null && next.getId().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public void a(ad adVar) throws RemoteException {
        try {
            b(adVar.getId());
            this.c.add(adVar);
            c();
        } catch (Throwable th) {
            cm.a(th, "GLOverlayLayer", "addOverlay");
        }
    }

    public boolean b(String str) throws RemoteException {
        try {
            ad c2 = c(str);
            if (c2 != null) {
                return this.c.remove(c2);
            }
            return false;
        } catch (Throwable th) {
            cm.a(th, "GLOverlayLayer", "removeOverlay");
            return false;
        }
    }

    private void c() {
        this.e.removeCallbacks(this.f);
        this.e.postDelayed(this.f, 10);
    }

    public void a(Canvas canvas) {
        Object[] array = this.c.toArray();
        Arrays.sort(array, this.d);
        this.c.clear();
        for (Object obj : array) {
            try {
                this.c.add((ad) obj);
            } catch (Throwable th) {
                cm.a(th, "GLOverlayLayer", "draw");
            }
        }
        int size = this.c.size();
        Iterator<ad> it2 = this.c.iterator();
        while (it2.hasNext()) {
            ad next = it2.next();
            try {
                if (next.isVisible()) {
                    if (size <= 20) {
                        next.a(canvas);
                    } else if (next.a()) {
                        next.a(canvas);
                    }
                }
            } catch (RemoteException e2) {
                cm.a(e2, "GLOverlayLayer", "draw");
            }
        }
    }

    public synchronized ag a(PolylineOptions polylineOptions) throws RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        bf bfVar = new bf(this.a);
        bfVar.setColor(polylineOptions.getColor());
        bfVar.setDottedLine(polylineOptions.isDottedLine());
        bfVar.setGeodesic(polylineOptions.isGeodesic());
        bfVar.setPoints(polylineOptions.getPoints());
        bfVar.setVisible(polylineOptions.isVisible());
        bfVar.setWidth(polylineOptions.getWidth());
        bfVar.setZIndex(polylineOptions.getZIndex());
        a(bfVar);
        return bfVar;
    }

    public synchronized af a(PolygonOptions polygonOptions) throws RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        be beVar = new be(this.a);
        beVar.setFillColor(polygonOptions.getFillColor());
        beVar.setPoints(polygonOptions.getPoints());
        beVar.setVisible(polygonOptions.isVisible());
        beVar.setStrokeWidth(polygonOptions.getStrokeWidth());
        beVar.setZIndex(polygonOptions.getZIndex());
        beVar.setStrokeColor(polygonOptions.getStrokeColor());
        a(beVar);
        return beVar;
    }

    public synchronized z a(CircleOptions circleOptions) throws RemoteException {
        if (circleOptions == null) {
            return null;
        }
        o oVar = new o(this.a);
        oVar.setFillColor(circleOptions.getFillColor());
        oVar.setCenter(circleOptions.getCenter());
        oVar.setVisible(circleOptions.isVisible());
        oVar.setStrokeWidth(circleOptions.getStrokeWidth());
        oVar.setZIndex(circleOptions.getZIndex());
        oVar.setStrokeColor(circleOptions.getStrokeColor());
        oVar.setRadius(circleOptions.getRadius());
        a(oVar);
        return oVar;
    }

    public synchronized aa a(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        x xVar = new x(this.a);
        xVar.setAnchor(groundOverlayOptions.getAnchorU(), groundOverlayOptions.getAnchorV());
        xVar.setDimensions(groundOverlayOptions.getWidth(), groundOverlayOptions.getHeight());
        xVar.setImage(groundOverlayOptions.getImage());
        xVar.setPosition(groundOverlayOptions.getLocation());
        xVar.setPositionFromBounds(groundOverlayOptions.getBounds());
        xVar.setBearing(groundOverlayOptions.getBearing());
        xVar.setTransparency(groundOverlayOptions.getTransparency());
        xVar.setVisible(groundOverlayOptions.isVisible());
        xVar.setZIndex(groundOverlayOptions.getZIndex());
        a(xVar);
        return xVar;
    }
}
